package com.pronet.sistem.entidad;

import java.sql.Timestamp;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Base.class)
public abstract class Base_ {

	public static volatile SingularAttribute<Base, Long> id;
	public static volatile SingularAttribute<Base, Timestamp> fechaEliminacion;
	public static volatile SingularAttribute<Base, Long> idUsuarioEliminacion;
	public static volatile SingularAttribute<Base, Long> idUsuarioCreacion;
	public static volatile SingularAttribute<Base, Long> idUsuarioModificacion;
	public static volatile SingularAttribute<Base, Timestamp> fechaCreacion;
	public static volatile SingularAttribute<Base, Timestamp> fechaModificacion;
	public static volatile SingularAttribute<Base, String> activo;

}

