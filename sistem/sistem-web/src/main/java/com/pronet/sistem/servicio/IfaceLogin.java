/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pronet.sistem.servicio;

import com.pronet.sistem.entidad.Usuario;




/**
 *
 * @author miguel ojeda
 */
public interface IfaceLogin {
    
    Usuario validarLogin(Usuario obj) throws Exception;
}
