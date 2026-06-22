package ar.edu.utn.frba.dds.climalert.repositories.impl;

import ar.edu.utn.frba.dds.climalert.domain.alertas.AlertaClima;
import ar.edu.utn.frba.dds.climalert.repositories.AlertaClimaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryAlertaClimaRepositoryImpl implements AlertaClimaRepository {
  private final Map<String, AlertaClimaModel> database = new ConcurrentHashMap<>();

  @Override
  public boolean existeAlerta(String localidadId, LocalDateTime horaReporte) {
    return database.containsKey(key(localidadId, horaReporte));
  }

  @Override
  public void guardar(AlertaClima alertaClima) {
    var model = AlertaClimaModel.fromDomain(alertaClima);
    database.put(key(model.localidadId(), model.horaReporte()), model);
  }

  private static String key(String localidadId, LocalDateTime horaReporte) {
    return localidadId + "-" + horaReporte;
  }
}
