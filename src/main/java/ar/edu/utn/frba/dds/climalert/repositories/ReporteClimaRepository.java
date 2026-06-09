package ar.edu.utn.frba.dds.climalert.repositories;

import ar.edu.utn.frba.dds.climalert.domain.clima.ReporteClima;
import java.time.LocalDateTime;

public interface ReporteClimaRepository {
  boolean existeClima(String localidadId, LocalDateTime tiempo);
  void guardar(ReporteClima reporteClima);
}
