package ar.edu.utn.frba.dds.climalert.schedulers;

import ar.edu.utn.frba.dds.climalert.config.localidad.LocalidadConfig;
import ar.edu.utn.frba.dds.climalert.repositories.ReporteClimaRepository;
import ar.edu.utn.frba.dds.climalert.services.AlertaClimaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class EvaluadorAlertaClimaScheduler {
  private final ReporteClimaRepository reporteClimaRepository;
  private final AlertaClimaService alertaClimaService;
  private final LocalidadConfig localidadConfig;

  public EvaluadorAlertaClimaScheduler(ReporteClimaRepository reporteClimaRepository, AlertaClimaService alertaClimaService, LocalidadConfig localidadConfig) {
    this.reporteClimaRepository = reporteClimaRepository;
    this.alertaClimaService = alertaClimaService;
    this.localidadConfig = localidadConfig;
  }

  @Scheduled(fixedRate = 1, timeUnit = TimeUnit.MINUTES)
  public void evaluarUltimoClimaDisponible() {
    try {
      var reporteClima = reporteClimaRepository.obtenerUltimo(localidadConfig.id());

      if (reporteClima.isEmpty()) {
        log.info("No hay reportes de clima disponibles para evaluar alertas en {}({})", localidadConfig.nombre(), localidadConfig.id());
        return;
      }

      alertaClimaService.evaluar(reporteClima.get());
    } catch (Exception e) {
      log.error("Error al evaluar alertas climaticas: {}", e.getMessage(), e);
    }
  }
}
