package ar.edu.utn.frba.dds.climalert.services.impl;

import ar.edu.utn.frba.dds.climalert.domain.alertas.EvaluadorAlertaClima;
import ar.edu.utn.frba.dds.climalert.domain.clima.ReporteClima;
import ar.edu.utn.frba.dds.climalert.repositories.AlertaClimaRepository;
import ar.edu.utn.frba.dds.climalert.services.AlertaClimaService;
import ar.edu.utn.frba.dds.climalert.services.NotificadorAlertaClima;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AlertaClimaServiceImpl implements AlertaClimaService {
  private final EvaluadorAlertaClima evaluadorAlertaClima;
  private final AlertaClimaRepository alertaClimaRepository;
  private final NotificadorAlertaClima notificadorAlertaClima;

  public AlertaClimaServiceImpl(AlertaClimaRepository alertaClimaRepository, NotificadorAlertaClima notificadorAlertaClima) {
    this.evaluadorAlertaClima = new EvaluadorAlertaClima();
    this.alertaClimaRepository = alertaClimaRepository;
    this.notificadorAlertaClima = notificadorAlertaClima;
  }

  @Override
  public void evaluar(ReporteClima reporteClima) {
    if (alertaClimaRepository.existeAlerta(reporteClima.getLocalidadId(), reporteClima.getTiempo())) {
      log.info("Ya existe una alerta climatica para {} en la hora {}", reporteClima.getLocalidadId(), reporteClima.getTiempo());
      return;
    }

    var alertaClima = evaluadorAlertaClima.evaluar(reporteClima);

    if (alertaClima.isEmpty()) {
      return;
    }

    var alerta = alertaClima.get();
    alertaClimaRepository.guardar(alerta);
    notificadorAlertaClima.notificar(alerta);

    log.warn("Generada alerta climatica para {} con {} regla(s) incumplida(s)", reporteClima.getLocalidadId(), alerta.getReglasIncumplidas().size());
  }
}
