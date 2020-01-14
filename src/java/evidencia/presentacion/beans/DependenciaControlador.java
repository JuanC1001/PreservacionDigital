/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import evidencia.logica.clases.Dependencia;
import evidencia.logica.funciones.FDependencia;
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
import recursos.Util;

/**
 *
 * @author RUBEN
 */
@ManagedBean
@ViewScoped
public class DependenciaControlador {

    private Dependencia objdependencia;
    private ArrayList<Dependencia> lstdependencia;
    private Dependencia dependenciasel;
    @ManagedProperty(value = "#{sesionUsuarioDataManager}")
    private SesionUsuarioDataManager dm;
    private java.util.Date fechaRegistro;

    public DependenciaControlador() {
        this.reinit();
    }

    private void reinit() {
        this.objdependencia = new Dependencia();
        this.lstdependencia = new ArrayList<Dependencia>();
        this.dependenciasel = new Dependencia();
        fechaRegistro = new java.util.Date();
        this.cargarDependencia();
    }

    public Dependencia getObjdependencia() {
        return objdependencia;
    }

    public void setObjdependencia(Dependencia objdependencia) {
        this.objdependencia = objdependencia;
    }

    public ArrayList<Dependencia> getLstdependencia() {
        return lstdependencia;
    }

    public void setLstdependencia(ArrayList<Dependencia> lstdependencia) {
        this.lstdependencia = lstdependencia;
    }

    public Dependencia getDependenciasel() {
        return dependenciasel;
    }

    public void setDependenciasel(Dependencia dependenciasel) {
        this.dependenciasel = dependenciasel;
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

    public void cargarDependencia() {
        try {
            lstdependencia = FDependencia.obtenerDependencia();
        } catch (Exception e) {
            Util.addErrorMessage(e, "Error");
        }
    }

    public void insertarDependencia() {
        try {

            UsuarioRol us = new UsuarioRol();
            us.setCodigo(dm.getSesionUsuarioRolActual().getCodigo());
            objdependencia.setCodigo_usuario_rol(us);
            objdependencia.setFecha_registro(new java.sql.Date(this.fechaRegistro.getTime()));

            if (FDependencia.insertar(objdependencia) == true) {
                FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Insertados");
                FacesContext.getCurrentInstance().addMessage(null, mensaje);
                DefaultRequestContext.getCurrentInstance().execute("dlgInsertarDependencia.hide()");
                this.cargarDependencia();
                this.objdependencia = new Dependencia();
            } else {
                FacesMessage mensajeError = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", "Datos no Insertados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeError);
            }
        } catch (Exception e) {
            FacesMessage mensajeErrorIngreso = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, mensajeErrorIngreso);
        }
    }

    public void actualizarDependencia() {
        try {
            // objDocumento.setCodigo_persona(dm.getSesionPersona().getCodigo_titular());

            UsuarioRol us = new UsuarioRol();
            us.setCodigo(dm.getSesionUsuarioRolActual().getCodigo());
            objdependencia.setCodigo_usuario_rol(us);
            if (FDependencia.actualizar(dependenciasel)) {
                FacesMessage mensajeActualizacion = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Actualizados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeActualizacion);
                DefaultRequestContext.getCurrentInstance().execute("dlgEditarDependencia.hide()");
                this.cargarDependencia();
            } else {
                FacesMessage mensajeErrorActualizacion = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", "Datos no Actualizados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeErrorActualizacion);
            }
        } catch (Exception e) {
            FacesMessage mensajeErrorA = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, mensajeErrorA);
        }
    }

    public void eliminarDependencia() {
        try {
            if (FDependencia.eliminar(dependenciasel)) {
                FacesMessage mensajeEliminar = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Eliminados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeEliminar);
                DefaultRequestContext.getCurrentInstance().execute("dlgEliminarDependencia.hide()");
                this.cargarDependencia();
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
