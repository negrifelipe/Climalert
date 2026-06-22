package ar.edu.utn.frba.dds.climalert.domain.alertas;

import ar.edu.utn.frba.dds.climalert.domain.clima.ReporteClima;

import java.util.Optional;

public interface ReglaAlertaClima {
  String getCodigo();

  Optional<ReglaIncumplida> evaluar(ReporteClima reporteClima);
}
