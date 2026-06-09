package ar.edu.utn.frba.dds.climalert.infra.clima;

import ar.edu.utn.frba.dds.climalert.domain.clima.CondicionClima;
import ar.edu.utn.frba.dds.climalert.domain.common.Unidad;

import java.time.LocalDateTime;

public interface Clima {
  LocalDateTime tiempo();
  Unidad temperatura();
  boolean esDeDia();
  CondicionClima condicion();
  Unidad velocidadViento();
  Unidad rafaga();
  Unidad humedad();
  Unidad nubosidad();
  Unidad presion();
  Unidad precipitacion();
  Unidad sensacionTermica();
  Unidad visibilidad();
  Unidad indiceUV();
}
