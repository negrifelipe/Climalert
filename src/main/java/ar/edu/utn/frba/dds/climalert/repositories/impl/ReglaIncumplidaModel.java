package ar.edu.utn.frba.dds.climalert.repositories.impl;

import ar.edu.utn.frba.dds.climalert.domain.alertas.ReglaIncumplida;

public record ReglaIncumplidaModel(
    String codigo,
    String descripcion
) {
  public static ReglaIncumplidaModel fromDomain(ReglaIncumplida reglaIncumplida) {
    return new ReglaIncumplidaModel(reglaIncumplida.codigo(), reglaIncumplida.descripcion());
  }
}
