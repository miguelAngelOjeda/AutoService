/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pronet.sistem.controller;

import com.pronet.sistem.manager.UsuarioManager;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Miguel
 */
public class BaseController {
    
    private Context context;

    protected UsuarioManager usuarioManager;
    
    protected void inicializarUsuarioManager() throws Exception{
		if (context == null)
			try {
				context = new InitialContext();
			} catch (NamingException e1) {
				
			}
		if (usuarioManager == null) {
			try {

				usuarioManager = (UsuarioManager) context
						.lookup("java:app/sistem-ejb/UsuarioManagerImpl");
			} catch (NamingException ne) {
				
			}
		}
	}
}
