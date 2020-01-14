/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evidencia.presentacion.beans;

import evidencia.logica.clases.Tipo_Usuario;
import evidencia.logica.funciones.FTipo_Usuario;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
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
@SessionScoped
public class TipoUsuarioControlador {

    private Tipo_Usuario objTipoUsuario;
    private ArrayList<Tipo_Usuario> lstTipoUsuario;
    private Tipo_Usuario TipoUsariosel;
    @ManagedProperty(value = "#{sesionUsuarioDataManager}")
    private SesionUsuarioDataManager dm;
    private java.util.Date fechaRegistro;

    public TipoUsuarioControlador() {
        this.reinit();
    }

    private void reinit() {
        this.objTipoUsuario = new Tipo_Usuario();
        this.lstTipoUsuario = new ArrayList<Tipo_Usuario>();
        this.TipoUsariosel = new Tipo_Usuario();
        fechaRegistro = new java.util.Date();
        this.cargarTipoUsuario();
    }

    public Tipo_Usuario getObjTipoUsuario() {
        return objTipoUsuario;
    }

    public void setObjTipoUsuario(Tipo_Usuario objTipoUsuario) {
        this.objTipoUsuario = objTipoUsuario;
    }

    public ArrayList<Tipo_Usuario> getLstTipoUsuario() {
        return lstTipoUsuario;
    }

    public void setLstTipoUsuario(ArrayList<Tipo_Usuario> lstTipoUsuario) {
        this.lstTipoUsuario = lstTipoUsuario;
    }

    public Tipo_Usuario getTipoUsariosel() {
        return TipoUsariosel;
    }

    public void setTipoUsariosel(Tipo_Usuario TipoUsariosel) {
        this.TipoUsariosel = TipoUsariosel;
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

    public void cargarTipoUsuario() {
        try {
            lstTipoUsuario = FTipo_Usuario.obtenerTipoUsuario();
        } catch (Exception e) {
            Util.addErrorMessage(e, "Error");
        }
    }
 public void insertarTipoUsuario() {
        try {

            UsuarioRol us = new UsuarioRol();
            us.setCodigo(dm.getSesionUsuarioRolActual().getCodigo());
            objTipoUsuario.setCodigo_usuario_rol(us);
            objTipoUsuario.setFecha_registro(new java.sql.Date(this.fechaRegistro.getTime()));

            if (FTipo_Usuario.insertar(objTipoUsuario) == true) {
                FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Insertados");
                FacesContext.getCurrentInstance().addMessage(null, mensaje);
                DefaultRequestContext.getCurrentInstance().execute("dlgInsertarTipoUsuario.hide()");
                this.cargarTipoUsuario();
                this.objTipoUsuario = new Tipo_Usuario();
            } else {
                FacesMessage mensajeError = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", "Datos no Insertados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeError);
            }
        } catch (Exception e) {
            FacesMessage mensajeErrorIngreso = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, mensajeErrorIngreso);
        }
    }
 
 public void actualizarTipoUsuario() {
        try {
            // objDocumento.setCodigo_persona(dm.getSesionPersona().getCodigo_titular());

            UsuarioRol us = new UsuarioRol();
            us.setCodigo(dm.getSesionUsuarioRolActual().getCodigo());
            objTipoUsuario.setCodigo_usuario_rol(us);
            if (FTipo_Usuario.actualizar(TipoUsariosel)) {
                FacesMessage mensajeActualizacion = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Actualizados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeActualizacion);
                DefaultRequestContext.getCurrentInstance().execute("dlgEditarTipoUsuario.hide()");
                this.cargarTipoUsuario();
            } else {
                FacesMessage mensajeErrorActualizacion = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", "Datos no Actualizados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeErrorActualizacion);
            }
        } catch (Exception e) {
            FacesMessage mensajeErrorA = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, mensajeErrorA);
        }
    }
 
     public void eliminarTipoUsuario() {
        try {
            if (FTipo_Usuario.eliminar(TipoUsariosel)) {
                FacesMessage mensajeEliminar = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Eliminados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeEliminar);
                DefaultRequestContext.getCurrentInstance().execute("dlgEliminarTipoUsuario.hide()");
                this.cargarTipoUsuario();
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
