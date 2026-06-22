package ar.edu.utn.frba.dds.climalert.repositories;

import ar.edu.utn.frba.dds.climalert.domain.clima.ReporteClima;

import java.time.LocalDateTime;
import java.util.Optional;

public interface ReporteClimaRepository {
  boolean existeClima(String localidadId, LocalDateTime tiempo);

  Optional<ReporteClima> obtenerUltimo(String localidadId);

  void guardar(ReporteClima reporteClima);
}
