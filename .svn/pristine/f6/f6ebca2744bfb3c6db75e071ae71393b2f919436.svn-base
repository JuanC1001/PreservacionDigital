/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package digitales.presentacion.beans;

import digitales.logica.clases.Categoria;
import digitales.logica.funciones.FCategoria;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.DefaultRequestContext;
import recursos.Util;

/**
 *
 * @author icits
 */
@ManagedBean
@ViewScoped
public class CategoriaControlador {

    private Categoria objCategoria;
    private ArrayList<Categoria> lstCategoria;
    private Categoria categoriaSel;
    private int estadoSel;

    public CategoriaControlador() {
        this.categoriaSel = new Categoria();
        this.objCategoria = new Categoria();
        this.cargarCategoria();
        this.estadoSel = -1;
    }

    public Categoria getObjCategoria() {
        return objCategoria;
    }

    public void setObjCategoria(Categoria objCategoria) {
        this.objCategoria = objCategoria;
    }

    public ArrayList<Categoria> getLstCategoria() {
        return lstCategoria;
    }

    public void setLstCategoria(ArrayList<Categoria> lstCategoria) {
        this.lstCategoria = lstCategoria;
    }

    public Categoria getCategoriaSel() {
        return categoriaSel;
    }

    public void setCategoriaSel(Categoria categoriaSel) {
        this.categoriaSel = categoriaSel;
    }

    public int getEstadoSel() {
        return estadoSel;
    }

    public void setEstadoSel(int estadoSel) {
        this.estadoSel = estadoSel;
    }

    public void cargarCategoria() {
        try {
            lstCategoria = FCategoria.obtenerTodos();
        } catch (Exception e) {
            Util.addErrorMessage(e, "Error");
        }
    }

    public void insertaCategoria() {

        try {
            objCategoria.setEstado(estadoSel);
            if (FCategoria.insertar(objCategoria) == true) {
                FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Insertados");
                FacesContext.getCurrentInstance().addMessage(null, mensaje);
                DefaultRequestContext.getCurrentInstance().execute("dlgInsertarCategoria.hide()");
                this.cargarCategoria();
                this.objCategoria = new Categoria();
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

    public void actualizarCategoria() {
        try {

            if (FCategoria.actualizar(categoriaSel)) {
                FacesMessage mensajeActualizacion = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Actualizados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeActualizacion);
                DefaultRequestContext.getCurrentInstance().execute("dlgEditarCategoria.hide()");
            } else {
                FacesMessage mensajeErrorActualizacion = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", "Datos no Actualizados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeErrorActualizacion);
            }
        } catch (Exception e) {
            FacesMessage mensajeErrorA = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, mensajeErrorA);
        }
    }

    public void eliminarCategoria() {
        try {
            if (FCategoria.eliminar(categoriaSel)) {
                FacesMessage mensajeEliminar = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Eliminados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeEliminar);
                DefaultRequestContext.getCurrentInstance().execute("dlgEliminarCategoria.hide()");
                this.cargarCategoria();
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
