package ar.edu.utn.frba.dds.climalert.domain.common;

/*
 Por ahora un valor y enum me sirve porque no hago operaciones pero capaz en un futuro necesite hacer operaciones entre unidades y ahí podria aplicar una composicion dependiendo del tipo de unidades quizas.
 */
public record Unidad(Double valor, UnidadMedida unidad) {
}
