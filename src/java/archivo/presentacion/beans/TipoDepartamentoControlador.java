/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivo.presentacion.beans;

import archivo.logica.clases.Tipo_Departamento;
import archivo.logica.funciones.FTipo_Departamento;
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
public class TipoDepartamentoControlador {

    private Tipo_Departamento objtipoDepartamento;
    private ArrayList<Tipo_Departamento> lsttipoDepartamento;
    private Tipo_Departamento tipoDepartamentosel;
    @ManagedProperty(value = "#{sesionUsuarioDataManager}")
    private SesionUsuarioDataManager dm;
    private java.util.Date fechaRegistro;

    public TipoDepartamentoControlador() {
        this.reinit();
    }

    private void reinit() {
        this.objtipoDepartamento = new Tipo_Departamento();
        this.lsttipoDepartamento = new ArrayList<Tipo_Departamento>();
        this.tipoDepartamentosel = new Tipo_Departamento();
        fechaRegistro = new java.util.Date();
        this.cargarTipoDepartamento();
    }

    public Tipo_Departamento getObjtipoDepartamento() {
        return objtipoDepartamento;
    }

    public void setObjtipoDepartamento(Tipo_Departamento objtipoDepartamento) {
        this.objtipoDepartamento = objtipoDepartamento;
    }

    public ArrayList<Tipo_Departamento> getLsttipoDepartamento() {
        return lsttipoDepartamento;
    }

    public void setLsttipoDepartamento(ArrayList<Tipo_Departamento> lsttipoDepartamento) {
        this.lsttipoDepartamento = lsttipoDepartamento;
    }

    public Tipo_Departamento getTipoDepartamentosel() {
        return tipoDepartamentosel;
    }

    public void setTipoDepartamentosel(Tipo_Departamento tipoDepartamentosel) {
        this.tipoDepartamentosel = tipoDepartamentosel;
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

    public void cargarTipoDepartamento() {
        try {
            lsttipoDepartamento = FTipo_Departamento.obtenerTipoDepartamentos();
        } catch (Exception e) {
            Util.addErrorMessage(e, "Error");
        }
    }

    public void insertarTipoDepartamento() {
        try {

            UsuarioRol us = new UsuarioRol();
            us.setCodigo(dm.getSesionUsuarioRolActual().getCodigo());
            objtipoDepartamento.setCodigo_usuario_rol(us);
            objtipoDepartamento.setFecha_registro(new java.sql.Date(this.fechaRegistro.getTime()));

            if (FTipo_Departamento.insertar(objtipoDepartamento) == true) {
                FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Insertados");
                FacesContext.getCurrentInstance().addMessage(null, mensaje);
                DefaultRequestContext.getCurrentInstance().execute("dlgInsertarTipoDepartamento.hide()");
                this.cargarTipoDepartamento();
                this.objtipoDepartamento = new Tipo_Departamento();
            } else {
                FacesMessage mensajeError = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", "Datos no Insertados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeError);
            }
        } catch (Exception e) {
            FacesMessage mensajeErrorIngreso = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, mensajeErrorIngreso);
        }
    }

    public void actualizarTipoDepartamento() {
        try {
            // objDocumento.setCodigo_persona(dm.getSesionPersona().getCodigo_titular());

            UsuarioRol us = new UsuarioRol();
            us.setCodigo(dm.getSesionUsuarioRolActual().getCodigo());
            objtipoDepartamento.setCodigo_usuario_rol(us);
            if (FTipo_Departamento.actualizar(tipoDepartamentosel)) {
                FacesMessage mensajeActualizacion = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Actualizados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeActualizacion);
                DefaultRequestContext.getCurrentInstance().execute("dlgEditarTipoDepartamento.hide()");
                this.cargarTipoDepartamento();
            } else {
                FacesMessage mensajeErrorActualizacion = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", "Datos no Actualizados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeErrorActualizacion);
            }
        } catch (Exception e) {
            FacesMessage mensajeErrorA = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, mensajeErrorA);
        }
    }

    public void eliminarTipoDepartamento() {
        try {
            if (FTipo_Departamento.eliminar(tipoDepartamentosel)) {
                FacesMessage mensajeEliminar = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Eliminados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeEliminar);
                DefaultRequestContext.getCurrentInstance().execute("dlgEliminarTipoDepartamento.hide()");
                this.cargarTipoDepartamento();
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
