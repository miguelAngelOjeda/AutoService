package com.pronet.sistem.entidad;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(UrlEmisor.class)
public abstract class UrlEmisor_ extends com.pronet.sistem.entidad.Base_ {

	public static volatile SingularAttribute<UrlEmisor, String> urlAnulacion;
	public static volatile SingularAttribute<UrlEmisor, String> urlPago;
	public static volatile SingularAttribute<UrlEmisor, String> urlConsulta;

}

