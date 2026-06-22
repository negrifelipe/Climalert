package ar.edu.utn.frba.dds.climalert.infra.clima.impl;

import ar.edu.utn.frba.dds.climalert.domain.clima.CondicionClima;
import ar.edu.utn.frba.dds.climalert.domain.common.Unidad;
import ar.edu.utn.frba.dds.climalert.domain.common.UnidadMedida;
import ar.edu.utn.frba.dds.climalert.infra.clima.Clima;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public record ClimaImpl(
    LocalDateTime tiempo,
    Unidad temperatura,
    boolean esDeDia,
    CondicionClima condicion,
    Unidad velocidadViento,
    Unidad rafaga,
    Unidad humedad,
    Unidad nubosidad,
    Unidad presion,
    Unidad precipitacion,
    Unidad sensacionTermica,
    Unidad visibilidad,
    Unidad indiceUV
) implements Clima {

  private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

  // Muchas gracias copilot por hacer el trabajo mas duro
  public static ClimaImpl from(WeatherAPIResponse response) {
    var current = response.getCurrent();
    var localtime = LocalDateTime.parse(current.getLastUpdated(), FORMATTER);
    var condicion = CondicionClimaMapper.fromCode(current.getCondition().getCode());

    return new ClimaImpl(
        localtime,
        new Unidad(current.getTempC(), UnidadMedida.GradosCelsius),
        current.getIsDay() == 1,
        condicion,
        new Unidad(current.getWindKph(), UnidadMedida.KilometrosPorHora),
        new Unidad(current.getGustKph(), UnidadMedida.KilometrosPorHora),
        new Unidad((double) current.getHumidity(), UnidadMedida.Porcentaje),
        new Unidad((double) current.getCloud(), UnidadMedida.Porcentaje),
        new Unidad(current.getPressureMb(), UnidadMedida.Hectopascales),
        new Unidad(current.getPrecipMm(), UnidadMedida.Milimetros),
        new Unidad(current.getFeelslikeC(), UnidadMedida.GradosCelsius),
        new Unidad(current.getVisKm(), UnidadMedida.Kilometros),
        new Unidad((double) current.getUv(), UnidadMedida.IndiceUV)
    );
  }
}
