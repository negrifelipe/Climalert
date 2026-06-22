package ar.edu.utn.frba.dds.climalert.config.weatherapi;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "weather-api")
public record WeatherAPIConfig(String apiKey, String baseUrl) {
}

