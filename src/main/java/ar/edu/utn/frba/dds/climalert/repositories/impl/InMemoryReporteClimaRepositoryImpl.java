package ar.edu.utn.frba.dds.climalert.repositories.impl;

import ar.edu.utn.frba.dds.climalert.domain.clima.ReporteClima;
import ar.edu.utn.frba.dds.climalert.repositories.ReporteClimaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryReporteClimaRepositoryImpl implements ReporteClimaRepository {
  private final Map<String, ReporteClimaModel> database = new ConcurrentHashMap<>();

  @Override
  public boolean existeClima(String localidadId, LocalDateTime tiempo) {
    return database.containsKey(key(localidadId, tiempo));
  }

  @Override
  public Optional<ReporteClima> obtenerUltimo(String localidadId) {
    return database.values().stream()
        .filter(model -> model.localidadId().equals(localidadId))
        .max(Comparator.comparing(ReporteClimaModel::hora))
        .map(ReporteClimaModel::toDomain);
  }

  @Override
  public void guardar(ReporteClima reporteClima) {
    var model = ReporteClimaModel.fromDomain(reporteClima);
    database.put(key(model.localidadId(), model.hora()), model);
  }

  private static String key(String localidadId, LocalDateTime tiempo) {
    return localidadId + "-" + tiempo.toString();
  }
}
