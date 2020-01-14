/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package digitales.presentacion.beans;

import digitales.logica.clases.Articulo;
import digitales.logica.funciones.FArticulo;
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
public class ListaArticulosControlador {
    private ArrayList<Articulo> lstArticulo;
    private Articulo articuloSel;
    private int estadoSel;

    public ListaArticulosControlador() {
      this.articuloSel = new Articulo();
      this.cargarArticulo();     
      this.estadoSel=-1;
    }

    public int getEstadoSel() {
        return estadoSel;
    }

    public void setEstadoSel(int estadoSel) {
        this.estadoSel = estadoSel;
    }

    public ArrayList<Articulo> getLstArticulo() {
        return lstArticulo;
    }

    public void setLstArticulo(ArrayList<Articulo> lstArticulo) {
        this.lstArticulo = lstArticulo;
    }

    public Articulo getArticuloSel() {
        return articuloSel;
    }

    public void setArticuloSel(Articulo articuloSel) {
        this.articuloSel = articuloSel;
    }
    
      public void cargarArticulo() {
        try {
            lstArticulo = FArticulo.obtenerTodos();
        } catch (Exception e) {
            Util.addErrorMessage(e, "Error");
        }
    }       
      public void eliminarArticulo(){
          try {
              if (FArticulo.eliminar(articuloSel)) {
                FacesMessage mensajeEliminar = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Eliminados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeEliminar);
                DefaultRequestContext.getCurrentInstance().execute("dlgEliminarArticulo.hide()");
                this.cargarArticulo();                  
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
