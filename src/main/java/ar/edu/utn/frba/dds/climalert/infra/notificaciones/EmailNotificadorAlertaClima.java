package ar.edu.utn.frba.dds.climalert.infra.notificaciones;

import ar.edu.utn.frba.dds.climalert.config.alertas.AlertaEmailConfig;
import ar.edu.utn.frba.dds.climalert.domain.alertas.AlertaClima;
import ar.edu.utn.frba.dds.climalert.domain.common.Unidad;
import ar.edu.utn.frba.dds.climalert.infra.mail.EnviadorMail;
import ar.edu.utn.frba.dds.climalert.services.NotificadorAlertaClima;
import org.springframework.stereotype.Component;

@Component
public class EmailNotificadorAlertaClima implements NotificadorAlertaClima {
  private final EnviadorMail enviadorMail;
  private final AlertaEmailConfig alertaEmailConfig;

  public EmailNotificadorAlertaClima(EnviadorMail enviadorMail, AlertaEmailConfig alertaEmailConfig) {
    this.enviadorMail = enviadorMail;
    this.alertaEmailConfig = alertaEmailConfig;
  }

  @Override
  public void notificar(AlertaClima alertaClima) {
    enviadorMail.enviar(
        alertaEmailConfig.destinatarios(),
        "Alerta climatica",
        formatear(alertaClima)
    );
  }

  public String formatear(AlertaClima alertaClima) {
    var reporte = alertaClima.getReporteClima();

    return "Se genero una alerta climatica.\n\n"
        + "Reglas incumplidas:\n"
        + reglasIncumplidas(alertaClima)
        + "\nDetalle completo del clima:\n"
        + "Localidad: " + reporte.getLocalidadId() + "\n"
        + "Hora del reporte: " + reporte.getTiempo() + "\n"
        + "Fecha de generacion de alerta: " + alertaClima.getFechaGeneracion() + "\n"
        + "Temperatura: " + unidad(reporte.getTemperatura()) + "\n"
        + "Es de dia: " + reporte.isEsDeDia() + "\n"
        + "Condicion: " + reporte.getCondicion() + "\n"
        + "Velocidad del viento: " + unidad(reporte.getVelocidadViento()) + "\n"
        + "Rafaga: " + unidad(reporte.getRafaga()) + "\n"
        + "Humedad: " + unidad(reporte.getHumedad()) + "\n"
        + "Nubosidad: " + unidad(reporte.getNubosidad()) + "\n"
        + "Presion: " + unidad(reporte.getPresion()) + "\n"
        + "Precipitacion: " + unidad(reporte.getPrecipitacion()) + "\n"
        + "Sensacion termica: " + unidad(reporte.getSensacionTermica()) + "\n"
        + "Visibilidad: " + unidad(reporte.getVisibilidad()) + "\n"
        + "Indice UV: " + unidad(reporte.getIndiceUV()) + "\n";
  }

  private String reglasIncumplidas(AlertaClima alertaClima) {
    return alertaClima.getReglasIncumplidas()
        .stream()
        .map(regla -> "- " + regla.codigo() + ": " + regla.descripcion())
        .reduce("", (acumulado, regla) -> acumulado + regla + "\n");
  }

  private String unidad(Unidad unidad) {
    return unidad.valor() + " " + unidad.unidad();
  }
}
