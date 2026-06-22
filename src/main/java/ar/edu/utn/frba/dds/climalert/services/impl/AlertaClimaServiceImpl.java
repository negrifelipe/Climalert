package ar.edu.utn.frba.dds.climalert.services.impl;

import ar.edu.utn.frba.dds.climalert.config.localidad.LocalidadConfig;
import ar.edu.utn.frba.dds.climalert.domain.alertas.EvaluadorAlertaClima;
import ar.edu.utn.frba.dds.climalert.repositories.AlertaClimaRepository;
import ar.edu.utn.frba.dds.climalert.repositories.ReporteClimaRepository;
import ar.edu.utn.frba.dds.climalert.services.AlertaClimaService;
import ar.edu.utn.frba.dds.climalert.infra.notificaciones.NotificadorAlertaClima;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AlertaClimaServiceImpl implements AlertaClimaService {
  private final EvaluadorAlertaClima evaluadorAlertaClima;
  private final AlertaClimaRepository alertaClimaRepository;
  private final NotificadorAlertaClima notificadorAlertaClima;
  private final ReporteClimaRepository reporteClimaRepository;
  private final LocalidadConfig localidadConfig;

  public AlertaClimaServiceImpl(AlertaClimaRepository alertaClimaRepository, NotificadorAlertaClima notificadorAlertaClima, ReporteClimaRepository reporteClimaRepository, LocalidadConfig localidadConfig) {
    this.evaluadorAlertaClima = new EvaluadorAlertaClima();
    this.alertaClimaRepository = alertaClimaRepository;
    this.notificadorAlertaClima = notificadorAlertaClima;
    this.reporteClimaRepository = reporteClimaRepository;
    this.localidadConfig = localidadConfig;
  }

  @Override
  public void evaluarClimaActual() {
    var maybeReporteClima = reporteClimaRepository.obtenerUltimo(localidadConfig.id());

    if (maybeReporteClima.isEmpty()) {
      log.info("No hay reportes de clima disponibles para evaluar alertas en {}({})", localidadConfig.nombre(), localidadConfig.id());
      return;
    }

    var reporteClima = maybeReporteClima.get();

    if (alertaClimaRepository.existeAlerta(reporteClima.getLocalidadId(), reporteClima.getTiempo())) {
      log.info("Ya existe una alerta climatica para {} en la hora {}", reporteClima.getLocalidadId(), reporteClima.getTiempo());
      return;
    }

    var maybeAlertaClima = evaluadorAlertaClima.evaluar(reporteClima);

    if (maybeAlertaClima.isEmpty()) {
      return;
    }

    var alertaClima = maybeAlertaClima.get();
    alertaClimaRepository.guardar(alertaClima);
    notificadorAlertaClima.notificar(alertaClima);

    log.warn("Generada alerta climatica para {} con {} regla(s) incumplida(s)", reporteClima.getLocalidadId(), alertaClima.getReglasIncumplidas().size());
  }
}
