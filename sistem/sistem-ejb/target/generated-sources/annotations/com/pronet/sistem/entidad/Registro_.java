package com.pronet.sistem.entidad;

import java.sql.Timestamp;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Registro.class)
public abstract class Registro_ {

	public static volatile SingularAttribute<Registro, Long> id;
	public static volatile SingularAttribute<Registro, String> tipoError;
	public static volatile SingularAttribute<Registro, String> error;
	public static volatile SingularAttribute<Registro, String> json;
	public static volatile SingularAttribute<Registro, Long> idUsuarioCreacion;
	public static volatile SingularAttribute<Registro, Timestamp> fechaCreacion;
	public static volatile SingularAttribute<Registro, String> respuesta;

}

