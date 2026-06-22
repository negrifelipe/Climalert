package ar.edu.utn.frba.dds.climalert.repositories;

import ar.edu.utn.frba.dds.climalert.domain.alertas.AlertaClima;

import java.time.LocalDateTime;

public interface AlertaClimaRepository {
  boolean existeAlerta(String localidadId, LocalDateTime horaReporte);

  void guardar(AlertaClima alertaClima);
}
