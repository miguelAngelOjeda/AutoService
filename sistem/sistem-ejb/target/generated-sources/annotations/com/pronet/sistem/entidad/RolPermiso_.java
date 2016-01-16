package com.pronet.sistem.entidad;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(RolPermiso.class)
public abstract class RolPermiso_ {

	public static volatile SingularAttribute<RolPermiso, Long> id;
	public static volatile SingularAttribute<RolPermiso, Permiso> permiso;
	public static volatile SingularAttribute<RolPermiso, Rol> rol;

}

