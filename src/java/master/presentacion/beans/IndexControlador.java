/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package master.presentacion.beans;

import evidencia.logica.clases.DocumentoDisponibilidad;
import evidencia.logica.clases.DocumentoPlInf;
import evidencia.logica.clases.DocumentoTutoriales;
import evidencia.logica.clases.DocumentoViabilidad;
import evidencia.logica.funciones.FDocumentoPl_Inf;
import evidencia.logica.funciones.FDocumento_Disponibilidad;
import evidencia.logica.funciones.FDocumento_Tutoriales;
import evidencia.logica.funciones.FDocumento_Viabilidad;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import master.logica.clases.Menu_Sitio;
import master.logica.funciones.FMenu_Sitio;
import org.apache.taglibs.standard.functions.Functions;
import recursos.Util;

/**
 *
 * @author icits
 */
@ManagedBean
@ViewScoped
public class IndexControlador implements Serializable {

    private final static String[] iconos;
    private ArrayList<Menu_Sitio> lstMenuSitio;
    private int codigo_articulo;

    private ArrayList<DocumentoViabilidad> lstDocumentoVi;
    private ArrayList<DocumentoTutoriales> lstDocumentoTu;
    private ArrayList<DocumentoDisponibilidad> lstDocumentoDi;
    private ArrayList<DocumentoPlInf> lstDocumentoPi;

    //sesion del sitio
    @ManagedProperty(value = "#{sesionSitioDataManager}")
    private SesionSitioDataManager dmSitio;

    static {
        iconos = new String[3];
        iconos[0] = "*.pdf";
        iconos[1] = "*.word";
        iconos[2] = "*.odt";
    }

    public IndexControlador() {
        this.cargarMenuSitio();
        this.cargarDocumentos();
        this.cargarDocumentosTu();
        this.cargarDocumentosDi();
        this.cargarDocumentosPi();
    }

    public SesionSitioDataManager getDmSitio() {
        return dmSitio;
    }

    public void setDmSitio(SesionSitioDataManager dmSitio) {
        this.dmSitio = dmSitio;
    }

    public ArrayList<Menu_Sitio> getLstMenuSitio() {
        return lstMenuSitio;
    }

    public void setLstMenuSitio(ArrayList<Menu_Sitio> lstMenuSitio) {
        this.lstMenuSitio = lstMenuSitio;
    }

    public int getCodigo_articulo() {
        return codigo_articulo;
    }

    public void setCodigo_articulo(int codigo_articulo) {
        this.codigo_articulo = codigo_articulo;
    }

    public ArrayList<DocumentoViabilidad> getLstDocumentoVi() {
        return lstDocumentoVi;
    }

    public void setLstDocumentoVi(ArrayList<DocumentoViabilidad> lstDocumentoVi) {
        this.lstDocumentoVi = lstDocumentoVi;
    }

    public ArrayList<DocumentoTutoriales> getLstDocumentoTu() {
        return lstDocumentoTu;
    }

    public void setLstDocumentoTu(ArrayList<DocumentoTutoriales> lstDocumentoTu) {
        this.lstDocumentoTu = lstDocumentoTu;
    }

    public ArrayList<DocumentoDisponibilidad> getLstDocumentoDi() {
        return lstDocumentoDi;
    }

    public void setLstDocumentoDi(ArrayList<DocumentoDisponibilidad> lstDocumentoDi) {
        this.lstDocumentoDi = lstDocumentoDi;
    }

    public ArrayList<DocumentoPlInf> getLstDocumentoPi() {
        return lstDocumentoPi;
    }

    public void setLstDocumentoPi(ArrayList<DocumentoPlInf> lstDocumentoPi) {
        this.lstDocumentoPi = lstDocumentoPi;
    }

    public void cargarMenuSitio() {
        try {
            lstMenuSitio = FMenu_Sitio.ObtenerMenuSitio();
        } catch (Exception e) {
            Util.addErrorMessage(e, "Error con la conexion");
        }
    }

    public String cambiarPagina() {

        return "/faces" + (Functions.substring(this.dmSitio.getPaginaActual().getUrl(), 2,
                this.dmSitio.getPaginaActual().getUrl().length() - 6));
    }

    public void cargarDocumentos() {
        try {
            lstDocumentoVi = FDocumento_Viabilidad.obtenerTodos();
        } catch (Exception e) {
            Util.addErrorMessage(e, "Error con la conexion");
        }
    }

    public void cargarDocumentosTu() {
        try {
            lstDocumentoTu = FDocumento_Tutoriales.obtenerTodos();
        } catch (Exception e) {
            Util.addErrorMessage(e, "Error con la conexion");
        }
    }

    public void cargarDocumentosDi() {
        try {
            lstDocumentoDi = FDocumento_Disponibilidad.obtenerTodos();
        } catch (Exception e) {
            Util.addErrorMessage(e, "Error con la conexion");
        }
    }
      public void cargarDocumentosPi() {
        try {
            lstDocumentoPi = FDocumentoPl_Inf.obtenerTodos();
        } catch (Exception e) {
            Util.addErrorMessage(e, "Error con la conexion");
        }
    }

    /*public int CargarIconos() {
     int tamaño = lstDocumento.size();
     int valor = 0;
     if (lstDocumento.get(valor).equals(iconos[0])) {
     valor = 1;

     }
     if (lstDocumento.get(i).equals(iconos[1])) {
     valor = 2;

     }
     if (lstDocumento.get(i).equals(iconos[2])) {
     valor = 3;
     }
     return valor;
     }*/
}
