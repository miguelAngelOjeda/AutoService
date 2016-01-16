/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pronet.sistem.session;


import com.pronet.sistem.controller.BaseController;
import com.pronet.sistem.entidad.Usuario;
import com.pronet.sistem.manager.UsuarioManager;
import com.pronet.sistem.userDetail.UserDetail;
import com.pronet.sistem.servicio.IfaceLogin;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 *
 * @author Miguel
 */
public class UserSession implements AuthenticationProvider {
    
        //@EJB(mappedName = "java:global/sistem/sistem-ejb/UsuarioManagerImpl")
    private UsuarioManager usuarioManager;
    
    private Context context;

    
    private IfaceLogin serviceLogin;

    /**
     * @return the serviceLogin
     */
    public IfaceLogin getServiceLogin() {
        return serviceLogin;
    }

    /**
     * @param serviceLogin the serviceLogin to set
     */
    public void setServiceLogin(IfaceLogin serviceLogin) {
        this.serviceLogin = serviceLogin;
    }

    public boolean userExist(Usuario user) {
        try {
            inicializarUsuarioManager();
            Usuario ejUsuario = new Usuario();
            ejUsuario.setAlias(user.getAlias());
            ejUsuario.setClaveAcceso(user.getClaveAcceso());

            ejUsuario =  usuarioManager.get(ejUsuario);
            if(ejUsuario != null && ejUsuario.getId() != null) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userLogin = authentication.getPrincipal().toString();
        String passwordLogin = authentication.getCredentials().toString();
        System.out.println("User: " + userLogin);
        System.out.println("Password: " + passwordLogin);
        Usuario user = new Usuario();
        user.setAlias(userLogin);
        user.setClaveAcceso(passwordLogin);
        if(userExist(user)) {
            List<GrantedAuthority> autoridades = new ArrayList<GrantedAuthority>();
            autoridades.add(new SimpleGrantedAuthority("ROLE_USER"));
            autoridades.add(new SimpleGrantedAuthority("ROLE_VIP"));
            autoridades.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            autoridades.add(new SimpleGrantedAuthority("ROLE_VENDEDOR"));
            autoridades.add(new SimpleGrantedAuthority("ROLE_ALUMNO"));
            UserDetail userDetails = new UserDetail();
            userDetails.setUsername(userLogin);
            userDetails.setPassword(passwordLogin);
            userDetails.setNombre(userLogin);
            Authentication customAuthentication = new UsernamePasswordAuthenticationToken(userDetails, 
                    passwordLogin, autoridades);
            BeanMenu menu = new BeanMenu();
            menu.setUser(user);
            menu.setVisibleMenu(true);
            menu.setDisInicio(true);
            ServletRequestAttributes attr = (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
            HttpSession session = attr.getRequest().getSession(true);
            session.setAttribute("beanMenu", menu);
            return customAuthentication;
        } else {
            System.out.println("Usuario o Contraseña Inválidos.");
            throw new BadCredentialsException("Usuario o Contraseña Inválidos.");
        }
    }

    @Override
    public boolean supports(Class<?> type) {
        return true;
    }
    
    private void inicializarUsuarioManager() {
		if (context == null)
			try {
				context = new InitialContext();
			} catch (NamingException e1) {
				throw new RuntimeException("No se puede inicializar el contexto", e1);
			}
		if (usuarioManager == null) {
			try {

				usuarioManager = (UsuarioManager) context.lookup("java:app/sistem-ejb/UsuarioManagerImpl");
			} catch (NamingException ne) {
				throw new RuntimeException("No se encuentra EJB valor Manager: ", ne);
			}
		}
	}
}
