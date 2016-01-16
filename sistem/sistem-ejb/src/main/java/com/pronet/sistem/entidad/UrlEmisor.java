/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pronet.sistem.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Miguel
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "usuario" }))
public class UrlEmisor extends Base{
    
    private static final long serialVersionUID = 7986185608L;

    @NotNull
    @NotEmpty
    @Column(name = "url_consulta")
    private String urlConsulta;

    @NotNull
    @NotEmpty
    @Column(name = "url_pago")
    private String urlPago;
    
    @NotNull
    @NotEmpty
    @Column(name = "url_anulacion")
    private String urlAnulacion;
    
    @JoinColumn(name = "usuario")
    private Usuario usuario;
    
    public UrlEmisor() {

    }

    public UrlEmisor(Long id) {
            super(id);
    }

    public String getUrlConsulta() {
        return urlConsulta;
    }

    public void setUrlConsulta(String urlConsulta) {
        this.urlConsulta = urlConsulta;
    }

    public String getUrlPago() {
        return urlPago;
    }

    public void setUrlPago(String urlPago) {
        this.urlPago = urlPago;
    }

    public String getUrlAnulacion() {
        return urlAnulacion;
    }

    public void setUrlAnulacion(String urlAnulacion) {
        this.urlAnulacion = urlAnulacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    
}
