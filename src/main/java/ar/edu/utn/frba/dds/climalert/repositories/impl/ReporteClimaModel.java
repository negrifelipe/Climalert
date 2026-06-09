package ar.edu.utn.frba.dds.climalert.repositories.impl;

import ar.edu.utn.frba.dds.climalert.domain.clima.CondicionClima;
import ar.edu.utn.frba.dds.climalert.domain.clima.ReporteClima;
import ar.edu.utn.frba.dds.climalert.domain.common.UnidadMedida;
import java.time.LocalDateTime;

/* vendría a simular la tabla de la db para la entidad de dominio,
  pero con un formato que sería friendly para la base de datos,
  por ejemplo en una db como MariaDB querríamos que el valor y tipo de unidad sean 2 campos y no uno
*/
public record ReporteClimaModel(

    String localidadId,
    LocalDateTime hora,
    Double temperaturaValor,
    UnidadMedida temperaturaUnidad,
    boolean esDeDia,
    CondicionClima condicion,
    Double velocidadVientoValor,
    UnidadMedida velocidadVientoUnidad,
    Double rafagaValor,
    UnidadMedida rafagaUnidad,
    Double humedadValor,
    UnidadMedida humedadUnidad,
    Double nubosidadValor,
    UnidadMedida nubosidadUnidad,
    Double presionValor,
    UnidadMedida presionUnidad,
    Double precipitacionValor,
    UnidadMedida precipitacionUnidad,
    Double sensacionTermicaValor,
    UnidadMedida sensacionTermicaUnidad,
    Double visibilidadValor,
    UnidadMedida visibilidadUnidad,
    Double indiceUVValor,
    UnidadMedida indiceUVUnidad
) {
  public static ReporteClimaModel fromDomain(ReporteClima reporte) {
    return new ReporteClimaModel(
        reporte.getLocalidadId(),
        reporte.getTiempo(),
        reporte.getTemperatura().valor(),
        reporte.getTemperatura().unidad(),
        reporte.isEsDeDia(),
        reporte.getCondicion(),
        reporte.getVelocidadViento().valor(),
        reporte.getVelocidadViento().unidad(),
        reporte.getRafaga().valor(),
        reporte.getRafaga().unidad(),
        reporte.getHumedad().valor(),
        reporte.getHumedad().unidad(),
        reporte.getNubosidad().valor(),
        reporte.getNubosidad().unidad(),
        reporte.getPresion().valor(),
        reporte.getPresion().unidad(),
        reporte.getPrecipitacion().valor(),
        reporte.getPrecipitacion().unidad(),
        reporte.getSensacionTermica().valor(),
        reporte.getSensacionTermica().unidad(),
        reporte.getVisibilidad().valor(),
        reporte.getVisibilidad().unidad(),
        reporte.getIndiceUV().valor(),
        reporte.getIndiceUV().unidad()
    );
  }

  public ReporteClima toDomain() {
    return new ReporteClima(
        localidadId, hora,
        new ar.edu.utn.frba.dds.climalert.domain.common.Unidad(temperaturaValor, temperaturaUnidad),
        esDeDia, condicion,
        new ar.edu.utn.frba.dds.climalert.domain.common.Unidad(velocidadVientoValor, velocidadVientoUnidad),
        new ar.edu.utn.frba.dds.climalert.domain.common.Unidad(rafagaValor, rafagaUnidad),
        new ar.edu.utn.frba.dds.climalert.domain.common.Unidad(humedadValor, humedadUnidad),
        new ar.edu.utn.frba.dds.climalert.domain.common.Unidad(nubosidadValor, nubosidadUnidad),
        new ar.edu.utn.frba.dds.climalert.domain.common.Unidad(presionValor, presionUnidad),
        new ar.edu.utn.frba.dds.climalert.domain.common.Unidad(precipitacionValor, precipitacionUnidad),
        new ar.edu.utn.frba.dds.climalert.domain.common.Unidad(sensacionTermicaValor, sensacionTermicaUnidad),
        new ar.edu.utn.frba.dds.climalert.domain.common.Unidad(visibilidadValor, visibilidadUnidad),
        new ar.edu.utn.frba.dds.climalert.domain.common.Unidad(indiceUVValor, indiceUVUnidad)
    );
  }
}
