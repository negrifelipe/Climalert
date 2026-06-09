package ar.edu.utn.frba.dds.climalert.infra.clima.impl;

import ar.edu.utn.frba.dds.climalert.config.weatherapi.WeatherAPIConfig;
import ar.edu.utn.frba.dds.climalert.infra.clima.Clima;
import ar.edu.utn.frba.dds.climalert.infra.clima.ProveedorClima;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

// Existe un SDK para la api, pero no se actualiza desde hace 4 años... Además, para instalarlo en el proyecto hay que clonarlo…

@Service
public class WeatherAPIProveedorClimaImpl implements ProveedorClima {
  private final WeatherAPIConfig weatherAPIConfig;
  private final RestTemplate restTemplate;

  public WeatherAPIProveedorClimaImpl(WeatherAPIConfig weatherAPIConfig) {
    this.weatherAPIConfig = weatherAPIConfig;
    this.restTemplate = new RestTemplate();
  }


  @Override
  public Clima obtenerClimaActual(Double latitud, Double logitud) {
    var uri = UriComponentsBuilder.fromUriString(weatherAPIConfig.baseUrl())
        .path("/current.json")
        .queryParam("q", latitud + " " + logitud)
        .queryParam("key", weatherAPIConfig.apiKey())
        .build()
        .toUri();

    var response = restTemplate.getForEntity(uri, WeatherAPIResponse.class);
    if(!response.getStatusCode().is2xxSuccessful()) {
      throw new RuntimeException("No se ha podido obtener el clima desde el proveedor WeatherAPI status code " + response.getStatusCode());
    }

    var body = response.getBody();
    if (body == null) {
      throw new RuntimeException("El cuerpo de la respuesta de WeatherAPI está vacío");
    }

    return ClimaImpl.from(body);
  }
}

