package ar.edu.utn.frba.dds.climalert.domain.clima;

import ar.edu.utn.frba.dds.climalert.domain.common.Unidad;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ReporteClima {
  /*
  El enunciado dice 1 sola localidad.
  El problema esta en que si quiere cambiar de localidad o desplegar n instancias de esta app para localidades distintas
  pero usa la misma base de datos, necesitamos identificar unequivocamente a que localidad pertenece este reporte.
  Es por eso que decidi agregar el localidad id que en este caso se suple desde la config
  * */
  private String localidadId;
  private LocalDateTime tiempo;
  private Unidad temperatura;
  private boolean esDeDia;
  private CondicionClima condicion;
  private Unidad velocidadViento;
  private Unidad rafaga;
  private Unidad humedad;
  private Unidad nubosidad;
  private Unidad presion;
  private Unidad precipitacion;
  private Unidad sensacionTermica;
  private Unidad visibilidad;
  private Unidad indiceUV;

  public ReporteClima(String localidadId, LocalDateTime tiempo, Unidad temperatura, boolean esDeDia, CondicionClima condicion, Unidad velocidadViento, Unidad rafaga, Unidad humedad, Unidad nubosidad, Unidad presion, Unidad precipitacion, Unidad sensacionTermica, Unidad visibilidad, Unidad indiceUV) {
    this.localidadId = localidadId;
    this.tiempo = tiempo;
    this.temperatura = temperatura;
    this.esDeDia = esDeDia;
    this.condicion = condicion;
    this.velocidadViento = velocidadViento;
    this.rafaga = rafaga;
    this.humedad = humedad;
    this.nubosidad = nubosidad;
    this.presion = presion;
    this.precipitacion = precipitacion;
    this.sensacionTermica = sensacionTermica;
    this.visibilidad = visibilidad;
    this.indiceUV = indiceUV;
  }
}
