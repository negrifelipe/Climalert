package ar.edu.utn.frba.dds.climalert.infra.notificaciones;

import ar.edu.utn.frba.dds.climalert.domain.alertas.AlertaClima;

public interface NotificadorAlertaClima {
  void notificar(AlertaClima alertaClima);
}
