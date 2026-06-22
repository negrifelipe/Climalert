package ar.edu.utn.frba.dds.climalert.config.alertas;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "alertas.email")
public record AlertaEmailConfig(List<String> destinatarios) {
}
