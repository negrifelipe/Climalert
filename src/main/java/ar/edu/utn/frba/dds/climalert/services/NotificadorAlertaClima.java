package ar.edu.utn.frba.dds.climalert.services;

import ar.edu.utn.frba.dds.climalert.domain.alertas.AlertaClima;

public interface NotificadorAlertaClima {
  void notificar(AlertaClima alertaClima);
}
