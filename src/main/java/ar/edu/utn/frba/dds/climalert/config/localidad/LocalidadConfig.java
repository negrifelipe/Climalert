package ar.edu.utn.frba.dds.climalert.config.localidad;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "clima.localidad")
public record LocalidadConfig(String id, String nombre, double latitud, double longitud) {
}
