/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package master.presentacion.beans;

import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import master.logica.clases.Institucion;
import master.logica.funciones.FInstitucion;
import org.primefaces.context.DefaultRequestContext;
import recursos.Util;

/**
 *
 * @author icits
 */
@ManagedBean
@ViewScoped
public class InstitucionC {

    private Institucion objInstitucion;
    private ArrayList<Institucion> lstInstitucion;
    private Institucion institucionSel;

    public InstitucionC(Institucion objInstitucion, Institucion institucionSel) {
        this.objInstitucion = objInstitucion;
        this.institucionSel = institucionSel;
        
    }

    public InstitucionC() {
        this.cargarInstitucion();
        this.objInstitucion = new Institucion();
    }

    public Institucion getObjInstitucion() {
        return objInstitucion;
    }

    public void setObjInstitucion(Institucion objInstitucion) {
        this.objInstitucion = objInstitucion;
    }

    public ArrayList<Institucion> getLstInstitucion() {
        return lstInstitucion;
    }

    public void setLstInstitucion(ArrayList<Institucion> lstInstitucion) {
        this.lstInstitucion = lstInstitucion;
    }

    public Institucion getInstitucionSel() {
        return institucionSel;
    }

    public void setInstitucionSel(Institucion institucionSel) {
        this.institucionSel = institucionSel;
    }

    public void cargarInstitucion() {
        try {
            lstInstitucion = FInstitucion.ObtenerInstituciones();
        } catch (Exception e) {
            Util.addErrorMessage(e, "Error con la conexion");

        }
    }

    public void insertarInstitucion() {
        try {
            //objInstitucion.setCodigo_inst(FInstitucion.ObtenerInstitucionDadoCodigo(institucionSel.getCodigo()));
            //objModulo.setEstado(estadoSel);
            if (FInstitucion.insertar(objInstitucion) == true) {
                FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Insertados");
                FacesContext.getCurrentInstance().addMessage(null, mensaje);
                DefaultRequestContext.getCurrentInstance().execute("dlgInsertarInstitucion.hide()");
                this.cargarInstitucion();
                this.objInstitucion = new Institucion();
                //institucionSel.setCodigo(0);
            } else {
                FacesMessage mensajeError = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", "Datos no Insertados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeError);
            }
        } catch (Exception e) {
            FacesMessage mensajeErrorIngreso = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, mensajeErrorIngreso);
        }
    }

    public void actualizarInstitucion() {
        try {
            if (FInstitucion.actualizar(institucionSel)) {
                FacesMessage mensajeActualizacion = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Actualizados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeActualizacion);
                DefaultRequestContext.getCurrentInstance().execute("dlgEditarInstitucion.hide()");

            } else {
                FacesMessage mensajeErrorActualizacion = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", "Datos no Actualizados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeErrorActualizacion);
            }
        } catch (Exception e) {
            FacesMessage mensajeErrorA = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, mensajeErrorA);
        }
    }

    public void eliminarInstitucion() {
        try {
            if (FInstitucion.eliminar(institucionSel)) {
                FacesMessage mensajeEliminar = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Eliminados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeEliminar);
                DefaultRequestContext.getCurrentInstance().execute("dlgEliminarInstitucion.hide()");
                this.cargarInstitucion();

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
