package com.pronet.sistem.entidad;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Permiso.class)
public abstract class Permiso_ {

	public static volatile SingularAttribute<Permiso, Long> id;
	public static volatile SingularAttribute<Permiso, String> permiso;
	public static volatile ListAttribute<Permiso, RolPermiso> rolPermisos;

}

