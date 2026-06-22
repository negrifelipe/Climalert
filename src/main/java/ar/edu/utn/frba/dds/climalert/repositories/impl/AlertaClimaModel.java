package ar.edu.utn.frba.dds.climalert.repositories.impl;

import ar.edu.utn.frba.dds.climalert.domain.alertas.AlertaClima;

import java.time.LocalDateTime;
import java.util.List;

public record AlertaClimaModel(
    String localidadId,
    LocalDateTime horaReporte,
    LocalDateTime fechaGeneracion,
    ReporteClimaModel reporteClima,
    List<ReglaIncumplidaModel> reglasIncumplidas
) {
  public static AlertaClimaModel fromDomain(AlertaClima alertaClima) {
    var reporteClima = alertaClima.getReporteClima();

    return new AlertaClimaModel(
        reporteClima.getLocalidadId(),
        reporteClima.getTiempo(),
        alertaClima.getFechaGeneracion(),
        ReporteClimaModel.fromDomain(reporteClima),
        alertaClima.getReglasIncumplidas().stream()
            .map(ReglaIncumplidaModel::fromDomain)
            .toList()
    );
  }
}
