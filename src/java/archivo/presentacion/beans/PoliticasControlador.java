/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivo.presentacion.beans;

import archivo.logica.clases.Politicas;
import archivo.logica.funciones.FPoliticas;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import master.logica.clases.UsuarioRol;
import master.presentacion.beans.SesionUsuarioDataManager;
import org.primefaces.context.DefaultRequestContext;
import recursos.Tools;
import recursos.Util;

/**
 *
 * @author RUBEN
 */
@ManagedBean
@ViewScoped
public class PoliticasControlador {

    private Politicas objpoliticas;
    private ArrayList<Politicas> lstpoliticas;
    private Politicas politicassel;
    @ManagedProperty(value = "#{sesionUsuarioDataManager}")
    private SesionUsuarioDataManager dm;
    private java.util.Date fechaRegistro;

    public PoliticasControlador() {
        this.reinit();
    }

    private void reinit() {
        this.objpoliticas = new Politicas();
        this.lstpoliticas = new ArrayList<Politicas>();
        this.politicassel = new Politicas();
        fechaRegistro = new java.util.Date();
        this.cargarPoliticas();
    }

    public Politicas getObjpoliticas() {
        return objpoliticas;
    }

    public void setObjpoliticas(Politicas objpoliticas) {
        this.objpoliticas = objpoliticas;
    }

    public ArrayList<Politicas> getLstpoliticas() {
        return lstpoliticas;
    }

    public void setLstpoliticas(ArrayList<Politicas> lstpoliticas) {
        this.lstpoliticas = lstpoliticas;
    }

    public Politicas getPoliticassel() {
        return politicassel;
    }

    public void setPoliticassel(Politicas politicassel) {
        this.politicassel = politicassel;
    }

    public SesionUsuarioDataManager getDm() {
        return dm;
    }

    public void setDm(SesionUsuarioDataManager dm) {
        this.dm = dm;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public void cargarPoliticas() {
        try {
            lstpoliticas = FPoliticas.obtenerPoliticas();
        } catch (Exception e) {
            Util.addErrorMessage(e, "Error");
        }
    }

    public void insertarPoliticas() {
        try {

            UsuarioRol us = new UsuarioRol();
            us.setCodigo(dm.getSesionUsuarioRolActual().getCodigo());
            objpoliticas.setCodigo_usuario_rol(us);
            objpoliticas.setFecha_registro(new java.sql.Date(this.fechaRegistro.getTime()));

            if (FPoliticas.insertar(objpoliticas) == true) {
                FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Insertados");
                FacesContext.getCurrentInstance().addMessage(null, mensaje);
                DefaultRequestContext.getCurrentInstance().execute("dlgInsertarPoliticas.hide()");
                this.cargarPoliticas();
                this.objpoliticas = new Politicas();
            } else {
                FacesMessage mensajeError = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", "Datos no Insertados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeError);
            }
        } catch (Exception e) {
            FacesMessage mensajeErrorIngreso = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, mensajeErrorIngreso);
        }
    }

    public void actualizarPoliticas() {
        try {
            // objDocumento.setCodigo_persona(dm.getSesionPersona().getCodigo_titular());

            UsuarioRol us = new UsuarioRol();
            us.setCodigo(dm.getSesionUsuarioRolActual().getCodigo());
            objpoliticas.setCodigo_usuario_rol(us);
            if (FPoliticas.actualizar(politicassel)) {
                FacesMessage mensajeActualizacion = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Actualizados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeActualizacion);
                DefaultRequestContext.getCurrentInstance().execute("dlgEditarPoliticas.hide()");
                this.cargarPoliticas();
            } else {
                FacesMessage mensajeErrorActualizacion = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", "Datos no Actualizados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeErrorActualizacion);
            }
        } catch (Exception e) {
            FacesMessage mensajeErrorA = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, mensajeErrorA);
        }
    }

    public void eliminarPoliticas() {
        try {
            if (FPoliticas.eliminar(politicassel)) {
                FacesMessage mensajeEliminar = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Eliminados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeEliminar);
                DefaultRequestContext.getCurrentInstance().execute("dlgEliminarPoliticas.hide()");
                this.cargarPoliticas();
            } else {
                FacesMessage mensajeErrorEliminar = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", "Datos no  Eliminados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeErrorEliminar);
            }
        } catch (Exception e) {
            FacesMessage mensajeErrorE = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, mensajeErrorE);
        }
    }

}
