/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package digitales.presentacion.beans;

import digitales.logica.clases.Texto;
import digitales.logica.funciones.FTexto;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import master.presentacion.beans.SesionUsuarioDataManager;
import org.primefaces.context.DefaultRequestContext;
import recursos.Tools;
import recursos.Util;

/**
 *
 * @author icits
 */
@ManagedBean
@ViewScoped
public class TextoControlador {
    private Texto objTexto;
    private ArrayList<Texto> lstTexto;
    private Texto textoSel;
    @ManagedProperty(value = "#{sesionUsuarioDataManager}")
    private SesionUsuarioDataManager dm;
    private int estadoSel;

    public TextoControlador() {
        
        this.textoSel = new Texto();
        this.objTexto = new Texto();
        this.cargarTexto();
        this.estadoSel = -1;
    }

    public int getEstadoSel() {
        return estadoSel;
    }

    public void setEstadoSel(int estadoSel) {
        this.estadoSel = estadoSel;
    }

    public Texto getObjTexto() {
        return objTexto;
    }

    public void setObjTexto(Texto objTexto) {
        this.objTexto = objTexto;
    }

    public ArrayList<Texto> getLstTexto() {
        return lstTexto;
    }

    public void setLstTexto(ArrayList<Texto> lstTexto) {
        this.lstTexto = lstTexto;
    }

    public Texto getTextoSel() {
        return textoSel;
    }

    public void setTextoSel(Texto textoSel) {
        this.textoSel = textoSel;
    }

    public SesionUsuarioDataManager getDm() {
        return dm;
    }

    public void setDm(SesionUsuarioDataManager dm) {
        this.dm = dm;
    }

    public void cargarTexto() {
        try {
            lstTexto = FTexto.obtenerTodos();
        } catch (Exception e) {
            Util.addErrorMessage(e, "Error");
        }


    }

    public void insertarTexto() {
        try {
           objTexto.setEstado(estadoSel);
           objTexto.setFecha_edicion(Tools.obtieneFechaActualenMiliseg());
           objTexto.setFecha_registro(Tools.obtieneFechaActualenMiliseg());
            objTexto.setCodigo_persona(dm.getSesionPersona().getCodigo_titular());
            if (FTexto.insertar(objTexto) == true) {
                FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Insertados");
                FacesContext.getCurrentInstance().addMessage(null, mensaje);
                DefaultRequestContext.getCurrentInstance().execute("dlgInsertarTexto.hide()");
                this.cargarTexto();
                this.objTexto = new Texto();
                estadoSel = -1;
            } else {
                FacesMessage mensajeError = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", "Datos no Insertados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeError);
            }
        } catch (Exception e) {
            FacesMessage mensajeErrorIngreso = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, mensajeErrorIngreso);
        }
    }

    public void actualizarTexto() {
        try {
            objTexto.setFecha_edicion(Tools.obtieneFechaActualenMilisegDivididaPOrMil());
            objTexto.setCodigo_persona(dm.getSesionPersona().getCodigo_titular());
            if (FTexto.actualizar(textoSel)) {
                FacesMessage mensajeActualizacion = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Actualizados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeActualizacion);
                DefaultRequestContext.getCurrentInstance().execute("dlgEditarTexto.hide()");
            } else {
                FacesMessage mensajeErrorActualizacion = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", "Datos no Actualizados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeErrorActualizacion);
            }
        } catch (Exception e) {
            FacesMessage mensajeErrorA = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, mensajeErrorA);
        }
    }
    public void eliminarTexto(){
        try {
            if (FTexto.eliminar(textoSel)) {
                FacesMessage mensajeEliminar = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Eliminados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeEliminar);
                DefaultRequestContext.getCurrentInstance().execute("dlgEliminarTexto.hide()");
                this.cargarTexto();
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
