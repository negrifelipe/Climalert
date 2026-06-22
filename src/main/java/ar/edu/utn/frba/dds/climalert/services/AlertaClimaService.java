package ar.edu.utn.frba.dds.climalert.services;

import ar.edu.utn.frba.dds.climalert.domain.clima.ReporteClima;

public interface AlertaClimaService {
  void evaluar(ReporteClima reporteClima);
}
