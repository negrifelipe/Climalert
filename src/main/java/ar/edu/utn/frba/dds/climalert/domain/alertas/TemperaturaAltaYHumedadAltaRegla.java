package ar.edu.utn.frba.dds.climalert.domain.alertas;

import ar.edu.utn.frba.dds.climalert.domain.clima.ReporteClima;
import ar.edu.utn.frba.dds.climalert.domain.common.Unidad;
import ar.edu.utn.frba.dds.climalert.domain.common.UnidadMedida;

import java.util.Optional;

public class TemperaturaAltaYHumedadAltaRegla implements ReglaAlertaClima {
  private static final Unidad TEMPERATURA_MAXIMA = new Unidad(35d, UnidadMedida.GradosCelsius);
  private static final Unidad HUMEDAD_MAXIMA = new Unidad(60d, UnidadMedida.Porcentaje);

  @Override
  public String getCodigo() {
    return "TEMPERATURA_ALTA_Y_HUMEDAD_ALTA";
  }

  @Override
  public Optional<ReglaIncumplida> evaluar(ReporteClima reporteClima) {
    if (reporteClima.getTemperatura().mayorQue(TEMPERATURA_MAXIMA)
        && reporteClima.getHumedad().mayorQue(HUMEDAD_MAXIMA)) {
      return Optional.of(new ReglaIncumplida(
          getCodigo(),
          "Temperatura mayor a 35 grados y humedad superior a 60%"
      ));
    }

    return Optional.empty();
  }

}
