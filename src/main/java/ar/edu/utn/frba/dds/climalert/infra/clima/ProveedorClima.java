package ar.edu.utn.frba.dds.climalert.infra.clima;

public interface ProveedorClima {
  Clima obtenerClimaActual(Double latitud, Double logitud);
}
