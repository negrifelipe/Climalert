package ar.edu.utn.frba.dds.climalert.infra.mail.impl;

import ar.edu.utn.frba.dds.climalert.infra.mail.EnviadorMail;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SpringEnviadorMail implements EnviadorMail {
  private final JavaMailSender javaMailSender;

  public SpringEnviadorMail(JavaMailSender javaMailSender) {
    this.javaMailSender = javaMailSender;
  }

  @Override
  public void enviar(List<String> destinatarios, String asunto, String cuerpo) {
    var mensaje = new SimpleMailMessage();
    mensaje.setTo(destinatarios.toArray(String[]::new));
    mensaje.setSubject(asunto);
    mensaje.setText(cuerpo);

    javaMailSender.send(mensaje);
  }
}
