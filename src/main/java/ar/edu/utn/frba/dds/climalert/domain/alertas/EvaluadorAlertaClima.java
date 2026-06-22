package ar.edu.utn.frba.dds.climalert.domain.alertas;

import ar.edu.utn.frba.dds.climalert.domain.clima.ReporteClima;

import java.util.List;
import java.util.Optional;

public class EvaluadorAlertaClima {
  private static final List<ReglaAlertaClima> reglas = List.of(new TemperaturaAltaYHumedadAltaRegla());

  public Optional<AlertaClima> evaluar(ReporteClima reporteClima) {
    var reglasIncumplidas = reglas.stream()
        .map(regla -> regla.evaluar(reporteClima))
        .flatMap(Optional::stream)
        .toList();

    if (reglasIncumplidas.isEmpty()) {
      return Optional.empty();
    }

    return Optional.of(new AlertaClima(reporteClima, reglasIncumplidas));
  }
}
