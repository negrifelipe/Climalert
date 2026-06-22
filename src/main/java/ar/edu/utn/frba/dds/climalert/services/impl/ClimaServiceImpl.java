package ar.edu.utn.frba.dds.climalert.services.impl;

import ar.edu.utn.frba.dds.climalert.config.localidad.LocalidadConfig;
import ar.edu.utn.frba.dds.climalert.domain.clima.ReporteClima;
import ar.edu.utn.frba.dds.climalert.infra.clima.ProveedorClima;
import ar.edu.utn.frba.dds.climalert.repositories.ReporteClimaRepository;
import ar.edu.utn.frba.dds.climalert.services.ClimaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ClimaServiceImpl implements ClimaService {
  private final ProveedorClima proveedorClima;
  private final ReporteClimaRepository reporteClimaRepository;
  private final LocalidadConfig localidadConfig;

  public ClimaServiceImpl(ProveedorClima proveedorClima, ReporteClimaRepository reporteClimaRepository, LocalidadConfig localidadConfig) {
    this.proveedorClima = proveedorClima;
    this.reporteClimaRepository = reporteClimaRepository;
    this.localidadConfig = localidadConfig;
  }

  @Override
  public void registrarClimaActual() {
    log.info("Registrando clima actual de {}({})", localidadConfig.nombre(), localidadConfig.id());
    var clima = proveedorClima.obtenerClimaActual(localidadConfig.latitud(), localidadConfig.longitud());

    if (reporteClimaRepository.existeClima(localidadConfig.id(), clima.tiempo())) {
      log.warn("Ya se ha registrado el clima para la hora {} en {}({})", clima.tiempo(), localidadConfig.nombre(), localidadConfig.id());
      return;
    }

    var reporteClima = new ReporteClima(
        localidadConfig.id(),
        clima.tiempo(),
        clima.temperatura(),
        clima.esDeDia(),
        clima.condicion(),
        clima.velocidadViento(),
        clima.rafaga(),
        clima.humedad(),
        clima.nubosidad(),
        clima.presion(),
        clima.precipitacion(),
        clima.sensacionTermica(),
        clima.visibilidad(),
        clima.indiceUV()
    );

    reporteClimaRepository.guardar(reporteClima);
    log.info("Registrado clima actual de {}({}) para la hora {}", localidadConfig.nombre(), localidadConfig.id(), clima.tiempo());
  }
}
