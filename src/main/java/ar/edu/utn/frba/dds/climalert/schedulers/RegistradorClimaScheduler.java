package ar.edu.utn.frba.dds.climalert.schedulers;

import ar.edu.utn.frba.dds.climalert.services.ClimaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class RegistradorClimaScheduler {
  private final ClimaService climaService;

  public RegistradorClimaScheduler(ClimaService climaService) {
    this.climaService = climaService;
  }

  // El enunciado pide cada 5 minuto se usa fixedRate, si pidiera cada 5 minutos desde la ultima vez seria fixedDelay
  @Scheduled(fixedRate = 5, timeUnit = TimeUnit.MINUTES)
  public void registarClimaActual() {
    try {
      climaService.registrarClimaActual();
    }
    catch (Exception e) {
      log.error("Error al registrar el clima actual: {}", e.getMessage(), e);
    }
  }
}
