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
import master.logica.clases.Modulo;
import master.logica.funciones.FInstitucion;
import master.logica.funciones.FModulo;
import org.primefaces.context.DefaultRequestContext;
import recursos.Util;

/**
 *
 * @author icits
 */
@ManagedBean //Modificador
@ViewScoped
public class ModuloC {

    private Modulo objModulo;
    private ArrayList<Modulo> lstModulo;
    private Modulo moduloSel;
    private ArrayList<Institucion> lstInstitucion;
    private Institucion institucionSel;
    private int estadoSel;
    
    

    public ModuloC() {
        this.moduloSel = new Modulo(0, null, null, 0, new Institucion() );              
        this.objModulo = new Modulo();
        this.cargarModulo(); 
        this.institucionSel = new Institucion();
        this.cargarInstituciones();
       this.estadoSel = -1;      
    }

    public int getEstadoSel() {
        return estadoSel;
    }

    public void setEstadoSel(int estadoSel) {
        this.estadoSel = estadoSel;
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

    public Modulo getObjModulo() {
        return objModulo;
    }

    public void setObjModulo(Modulo objModulo) {
        this.objModulo = objModulo;
    }

    public ArrayList<Modulo> getLstModulo() {
        return lstModulo;
    }

    public void setLstModulo(ArrayList<Modulo> lstModulo) {
        this.lstModulo = lstModulo;
    }

    public Modulo getModuloSel() {
        return moduloSel;
    }

    public void setModuloSel(Modulo moduloSel) {
        this.moduloSel = moduloSel;
    }
    
    

    public void cargarModulo() {
        try {
            lstModulo = FModulo.ObtenerModulos();

        } catch (Exception e) {
            Util.addErrorMessage(e, "Error");
        }
    }
     public void cargarInstituciones() {
        try {
            lstInstitucion = FInstitucion.ObtenerInstituciones();
        } catch (Exception e) {
             Util.addErrorMessage(e, "Error");
        }
    }   
    public void insertarModulo() {
        try {
               objModulo.setCodigo_inst(FInstitucion.ObtenerInstitucionDadoCodigo(institucionSel.getCodigo()));
               objModulo.setEstado(estadoSel);
            if (FModulo.insertar(objModulo) == true) {
                FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Insertados");
                FacesContext.getCurrentInstance().addMessage(null, mensaje);
                DefaultRequestContext.getCurrentInstance().execute("dlgInsertarModulo.hide()");
                this.cargarModulo();
                this.objModulo = new Modulo();
                estadoSel=-1;
                institucionSel.setCodigo(0);
            } else {
                FacesMessage mensajeError = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", "Datos no Insertados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeError);
            }
        } catch (Exception e) {
            FacesMessage mensajeErrorIngreso = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, mensajeErrorIngreso);
        }
    }

    public void actualizarModulo() {
        try {
            
          
            if (FModulo.actualizar(moduloSel)) {
                FacesMessage mensajeActualizacion = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Actualizados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeActualizacion);
                DefaultRequestContext.getCurrentInstance().execute("dlgEditarModulo.hide()");
                 
            } else {
                FacesMessage mensajeErrorActualizacion = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", "Datos no Actualizados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeErrorActualizacion);
            }
        } catch (Exception e) {
            FacesMessage mensajeErrorA = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, mensajeErrorA);
        }
    }

    public void eliminarModulo() {
        try {
            if (FModulo.eliminar(moduloSel)) {
                FacesMessage mensajeEliminar = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Eliminados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeEliminar);
                DefaultRequestContext.getCurrentInstance().execute("dlgEliminarModulo.hide()");
                this.cargarModulo();

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
