/**
 * 
 */
package com.pronet.sistem.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author Hermann Bottger
 * 
 */
@Controller
@RequestMapping(value = "/")
public class LoginController {
		

	@RequestMapping(value = "login",method = RequestMethod.GET)
	public String login(Model model) {
		return "login";
	}

	
	
	/**
	 * Mapping para el metodo GET de la vista clientesLista.
	 * 
	 */
	@RequestMapping(value = "usuario", method = RequestMethod.GET)
	public ModelAndView obtenerMisDatos(Model model) {
		return new ModelAndView("usuarios");
	}

 
    

	
}
