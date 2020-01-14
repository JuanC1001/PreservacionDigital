/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evidencia.presentacion.beans;

import evidencia.logica.clases.Tipo_Caso;
import evidencia.logica.funciones.FTipo_Caso;
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
public class TipoCasoControlador {

    private Tipo_Caso objtipoCaso;
    private ArrayList<Tipo_Caso> lsttipoCaso;
    private Tipo_Caso tipoCasosel;
    @ManagedProperty(value = "#{sesionUsuarioDataManager}")
    private SesionUsuarioDataManager dm;
    private java.util.Date fechaRegistro;

    public TipoCasoControlador() {
        this.reinit();
    }

    private void reinit() {
        this.objtipoCaso = new Tipo_Caso();
        this.lsttipoCaso = new ArrayList<Tipo_Caso>();
        this.tipoCasosel = new Tipo_Caso();
        fechaRegistro = new java.util.Date();
        this.cargarTipoCaso();
    }

    public Tipo_Caso getObjtipoCaso() {
        return objtipoCaso;
    }

    public void setObjtipoCaso(Tipo_Caso objtipoCaso) {
        this.objtipoCaso = objtipoCaso;
    }

    public ArrayList<Tipo_Caso> getLsttipoCaso() {
        return lsttipoCaso;
    }

    public void setLsttipoCaso(ArrayList<Tipo_Caso> lsttipoCaso) {
        this.lsttipoCaso = lsttipoCaso;
    }

    public Tipo_Caso getTipoCasosel() {
        return tipoCasosel;
    }

    public void setTipoCasosel(Tipo_Caso tipoCasosel) {
        this.tipoCasosel = tipoCasosel;
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

    public void cargarTipoCaso() {
        try {
            lsttipoCaso = FTipo_Caso.obtenerTipoCasos();
        } catch (Exception e) {
            Util.addErrorMessage(e, "Error");
        }
    }

    public void insertarTipoCaso() {
        try {

            UsuarioRol us = new UsuarioRol();
            us.setCodigo(dm.getSesionUsuarioRolActual().getCodigo());
            objtipoCaso.setCodigo_usuario_rol(us);
            objtipoCaso.setFecha_registro(new java.sql.Date(this.fechaRegistro.getTime()));

            if (FTipo_Caso.insertar(objtipoCaso) == true) {
                FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Insertados");
                FacesContext.getCurrentInstance().addMessage(null, mensaje);
                DefaultRequestContext.getCurrentInstance().execute("dlgInsertarTipoCaso.hide()");
                this.cargarTipoCaso();
                this.objtipoCaso = new Tipo_Caso();
            } else {
                FacesMessage mensajeError = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", "Datos no Insertados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeError);
            }
        } catch (Exception e) {
            FacesMessage mensajeErrorIngreso = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, mensajeErrorIngreso);
        }
    }

    public void actualizarTipoCaso() {
        try {
            // objDocumento.setCodigo_persona(dm.getSesionPersona().getCodigo_titular());

            UsuarioRol us = new UsuarioRol();
            us.setCodigo(dm.getSesionUsuarioRolActual().getCodigo());
            objtipoCaso.setCodigo_usuario_rol(us);
            if (FTipo_Caso.actualizar(tipoCasosel)) {
                FacesMessage mensajeActualizacion = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Actualizados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeActualizacion);
                DefaultRequestContext.getCurrentInstance().execute("dlgEditarTipoCaso.hide()");
                this.cargarTipoCaso();
            } else {
                FacesMessage mensajeErrorActualizacion = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", "Datos no Actualizados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeErrorActualizacion);
            }
        } catch (Exception e) {
            FacesMessage mensajeErrorA = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, mensajeErrorA);
        }
    }

    public void eliminarTipoCaso() {
        try {
            if (FTipo_Caso.eliminar(tipoCasosel)) {
                FacesMessage mensajeEliminar = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Eliminados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeEliminar);
                DefaultRequestContext.getCurrentInstance().execute("dlgEliminarTipoCaso.hide()");
                this.cargarTipoCaso();
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
