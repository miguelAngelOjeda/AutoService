package com.pronet.sistem.entidad;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Rol.class)
public abstract class Rol_ {

	public static volatile SingularAttribute<Rol, Long> id;
	public static volatile SingularAttribute<Rol, String> nombreRol;

}

