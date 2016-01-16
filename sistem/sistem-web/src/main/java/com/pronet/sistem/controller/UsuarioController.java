/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pronet.sistem.controller;

import com.pronet.sistem.entidad.Usuario;
import com.pronet.sistem.servicio.Mensaje;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Miguel
 */
@Controller
@RequestMapping(value = "/usuarios")
@ManagedBean(name="userView")
@ViewScoped
public class UsuarioController extends BaseController implements Serializable{
    String atributos = "id,nombre,alias,documento,telefono,email,nombreRol";
    private FacesContext faceContext;
    private FacesMessage faceMessage;
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView Usuarios(Model model) {
        ModelAndView retorno = new ModelAndView();
        retorno.addObject("url","/usuarios");
        try {
			
            inicializarUsuarioManager();

            Usuario ejemplo = new Usuario();

            List<Map<String, Object>> listMapUsuarios = usuarioManager.listAtributos(ejemplo, atributos.split(","), true);


            model.addAttribute("usuarios", listMapUsuarios);

            retorno.setViewName("usuarios");

            

    } catch (Exception e) {
           
    }

    return retorno;
    }
    
    /**
    * Mapping para el metodo GET de la vista clientesLista.
    * 
    */
   @RequestMapping(value = "/crear", method = RequestMethod.GET)
   public ModelAndView crear(Model model) {
           return new ModelAndView("usuario");
   }
    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
   public ModelAndView guardar(@ModelAttribute("Usuario") Usuario clienteRecibido) {
       Mensaje mensaje = new Mensaje();
       try{
           inicializarUsuarioManager();
           Usuario ejUsuario = new Usuario();
           ejUsuario.setActivo("S");
           ejUsuario.setFechaCreacion(new Timestamp(System.currentTimeMillis()));
           ejUsuario.setFechaModificacion(new Timestamp(System.currentTimeMillis()));
           ejUsuario.setAlias(clienteRecibido.getAlias());
           ejUsuario.setClaveAcceso(clienteRecibido.getClaveAcceso());
           ejUsuario.setDocumento(clienteRecibido.getDocumento());
           ejUsuario.setEmail(clienteRecibido.getEmail());
           ejUsuario.setNombre(clienteRecibido.getNombre());
           ejUsuario.setNombreRol(clienteRecibido.getNombreRol());
           ejUsuario.setTelefono(clienteRecibido.getTelefono());
           
                   
           usuarioManager.save(ejUsuario);
           
       }catch(Exception e){
           System.out.println("Error");
       }
           
           return new ModelAndView("usuario");
   }
}
