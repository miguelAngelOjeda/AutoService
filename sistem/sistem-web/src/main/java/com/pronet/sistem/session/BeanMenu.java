/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pronet.sistem.session;

import com.pronet.sistem.entidad.Registro;
import com.pronet.sistem.entidad.UrlEmisor;
import com.pronet.sistem.entidad.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.servlet.ModelAndView;
/**
 *
 * @author miguel ojeda
 */
public class BeanMenu implements Serializable{
    private Usuario user;
    private UrlEmisor urlEmisor;
    private Registro  registro;
    private boolean visibleMenu = false;
    private boolean disInicio;
    private boolean disUsuarios;
    
    private void resetMenu() {
        setDisInicio(false);
        setDisUsuarios(false);
    }

    /**
     * @return the user
     */
    public Usuario getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(Usuario user) {
        this.user = user;
    }

    /**
     * @return the visibleMenu
     */
    public boolean isVisibleMenu() {
        return visibleMenu;
    }

    /**
     * @param visibleMenu the visibleMenu to set
     */
    public void setVisibleMenu(boolean visibleMenu) {
        this.visibleMenu = visibleMenu;
    }

    /**
     * @return the disInicio
     */
    public boolean isDisInicio() {
        return disInicio;
    }

    /**
     * @param disInicio the disInicio to set
     */
    public void setDisInicio(boolean disInicio) {
        this.disInicio = disInicio;
    }

    /**
     * @return the disUsuarios
     */
    public boolean isDisUsuarios() {
        return disUsuarios;
    }

    /**
     * @param disUsuarios the disUsuarios to set
     */
    public void setDisUsuarios(boolean disUsuarios) {
        this.disUsuarios = disUsuarios;
    }
    
    public String disabledInicio() {
        resetMenu();
        setDisInicio(true);
        return "/welcome?faces-redirect=true";
    }
    
    public String disabledUsuarios() {
        resetMenu();
        setDisUsuarios(true);
        return "usuarios";
    }

    public UrlEmisor getUrlEmisor() {
        return urlEmisor;
    }

    public void setUrlEmisor(UrlEmisor urlEmisor) {
        this.urlEmisor = urlEmisor;
    }

    public Registro getRegistro() {
        return registro;
    }

    public void setRegistro(Registro registro) {
        this.registro = registro;
    }
    
   
}
