/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pronet.sistem.manager;

import com.pronet.sistem.entidad.Usuario;
import javax.ejb.Local;

/**
 *
 * @author Miguel
 */
@Local
public interface UsuarioManager extends GenericDao<Usuario, Long>{
    
}
