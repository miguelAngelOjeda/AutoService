/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pronet.sistem.managerImpl;

import com.pronet.sistem.entidad.Usuario;
import com.pronet.sistem.manager.UsuarioManager;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;

/**
 *
 * @author Miguel
 */
@Stateless
public class UsuarioManagerImpl extends GenericDaoImpl<Usuario, Long>
		implements UsuarioManager{
        @Override
	protected Class<Usuario> getEntityBeanType() {
		return Usuario.class;
	}

}
