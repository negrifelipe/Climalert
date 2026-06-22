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
  private final AlertaClimaService alertaClimaService;

  public EvaluadorAlertaClimaScheduler(AlertaClimaService alertaClimaService) {
    this.alertaClimaService = alertaClimaService;
  }

  @Scheduled(fixedRate = 1, timeUnit = TimeUnit.MINUTES)
  public void evaluarUltimoClimaDisponible() {
    try {
      alertaClimaService.evaluarClimaActual();
    } catch (Exception e) {
      log.error("Error al evaluar alertas climaticas: {}", e.getMessage(), e);
    }
  }
}
