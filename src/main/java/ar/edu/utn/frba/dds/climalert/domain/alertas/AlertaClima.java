package ar.edu.utn.frba.dds.climalert.domain.alertas;

import ar.edu.utn.frba.dds.climalert.domain.clima.ReporteClima;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class AlertaClima {
  private final ReporteClima reporteClima;
  private final List<ReglaIncumplida> reglasIncumplidas;
  private final LocalDateTime fechaGeneracion;

  public AlertaClima(ReporteClima reporteClima, List<ReglaIncumplida> reglasIncumplidas) {
    if (reglasIncumplidas.isEmpty()) {
      throw new IllegalArgumentException("Una alerta debe tener al menos una regla incumplida");
    }

    this.reporteClima = reporteClima;
    this.reglasIncumplidas = List.copyOf(reglasIncumplidas);
    this.fechaGeneracion = LocalDateTime.now();
  }
}
