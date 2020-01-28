/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package master.presentacion.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import master.logica.clases.*;

/**
 *
 * @author escorpionDJ
 */
@ManagedBean
@SessionScoped
public class SesionUsuarioDataManager implements Serializable{
    //datos usuario actual

    private Usuario sesionUsuario;
    //usuario persona actual
    private UsuarioPersona sesionPersona;
    //rol actual del usuario
    private UsuarioRol sesionUsuarioRolActual;
    private Integer intSesionUsuarioRolActual;
    //lista de roles del usuario
    private List<UsuarioRol> sesionUsuarioRoles;
    //controlar si hay sesion valida
    private Boolean validado;
    //pagina actual de la sesion
    private String paginaActual;
    //codigo de funcion actual
    private Integer codigoFuncionActual;
    //objeto funcion actual
    private Funcion funcionActual;
    //menu del usuario
    private List<NodoMenu> menu;
    //tema del usuario
    private String temaSitio;

    //constructor
    public SesionUsuarioDataManager() {
        this.sesionUsuario = new Usuario();
        this.sesionPersona = new UsuarioPersona();
        this.validado = false;
        this.paginaActual = "";
        this.codigoFuncionActual = 0;
        this.sesionUsuarioRolActual = new UsuarioRol();
        this.intSesionUsuarioRolActual = 0;
        this.sesionUsuarioRoles = new ArrayList<UsuarioRol>();
        this.temaSitio = "glass-x";
        System.out.println("Creando la sesion");
    }
    //destructor

    public void destroy() {
        this.codigoFuncionActual = 0;
        this.funcionActual = null;
        this.menu = null;
        this.paginaActual = "";
        this.sesionUsuario = null;
        this.sesionPersona = null;
        this.sesionUsuarioRolActual = null;
        this.sesionUsuarioRoles = null;
        this.validado = Boolean.FALSE;
    }

    public UsuarioPersona getSesionPersona() {
        return sesionPersona;
    }

    public void setSesionPersona(UsuarioPersona sesionPersona) {
        this.sesionPersona = sesionPersona;
    }

    public Integer getIntSesionUsuarioRolActual() {
        return intSesionUsuarioRolActual;
    }

    public void setIntSesionUsuarioRolActual(Integer intSesionUsuarioRolActual) {
        this.intSesionUsuarioRolActual = intSesionUsuarioRolActual;
    }

    public Integer getCodigoFuncionActual() {
        System.out.println("GET " + codigoFuncionActual);
        return codigoFuncionActual;
    }

    public void setCodigoFuncionActual(Integer codigoFuncionActual) {
        System.out.println("SET " + codigoFuncionActual);
        this.codigoFuncionActual = codigoFuncionActual;
    }

    public Funcion getFuncionActual() {
        return funcionActual;
    }

    public void setFuncionActual(Funcion funcionActual) {
        this.funcionActual = funcionActual;
    }

    public List<NodoMenu> getMenu() {
        return menu;
    }

    public void setMenu(List<NodoMenu> menu) {
        this.menu = menu;
    }

    public String getPaginaActual() {
        return paginaActual;
    }

    public void setPaginaActual(String paginaActual) {
        this.paginaActual = paginaActual;
    }

    public Usuario getSesionUsuario() {
        return sesionUsuario;
    }

    public void setSesionUsuario(Usuario sesionUsuario) {
        this.sesionUsuario = sesionUsuario;
    }

    public UsuarioRol getSesionUsuarioRolActual() {
        System.out.println("get rol actual" + sesionUsuarioRolActual);
        return sesionUsuarioRolActual;
    }

    public void setSesionUsuarioRolActual(UsuarioRol sesionUsuarioRolActual) {
        System.out.println("set rol actual" + sesionUsuarioRolActual);
        this.sesionUsuarioRolActual = sesionUsuarioRolActual;
    }

    public List<UsuarioRol> getSesionUsuarioRoles() {
        return sesionUsuarioRoles;
    }

    public void setSesionUsuarioRoles(List<UsuarioRol> sesionUsuarioRoles) {
        this.sesionUsuarioRoles = sesionUsuarioRoles;
    }

    public Boolean getValidado() {
        return validado;
    }

    public void setValidado(Boolean validado) {
        this.validado = validado;
    }

    public String getTemaSitio() {
        return temaSitio;
    }

    public void setTemaSitio(String temaSitio) {
        this.temaSitio = temaSitio;
    }
}
