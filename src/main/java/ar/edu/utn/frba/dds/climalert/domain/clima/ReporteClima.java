package ar.edu.utn.frba.dds.climalert.domain.clima;

import ar.edu.utn.frba.dds.climalert.domain.common.Unidad;

import java.time.LocalDateTime;

public class ReporteClima {
  private LocalDateTime hora;
  private Unidad temperatura;
  private boolean esDeDia;
  private CondicionClima condicion;
  private Unidad velocidadViento;
  private Unidad rafaga;
  private Double humedad;
  private Double nubosidad;
  private Unidad presion;
  private Unidad precipitacion;
  private Unidad sensacionTermica;
  private Unidad visibilidad;
  private Double indiceUV;

  public ReporteClima(LocalDateTime hora, Unidad temperatura, boolean esDeDia, CondicionClima condicion, Unidad velocidadViento, Unidad rafaga, Double humedad, Double nubosidad, Unidad presion, Unidad precipitacion, Unidad sensacionTermica, Unidad visibilidad, Double indiceUV) {
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
    this.hora = hora;
  }
}
