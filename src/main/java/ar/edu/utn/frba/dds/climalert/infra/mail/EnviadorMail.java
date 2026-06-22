package ar.edu.utn.frba.dds.climalert.infra.mail;

import java.util.List;

public interface EnviadorMail {
  void enviar(List<String> destinatarios, String asunto, String cuerpo);
}
