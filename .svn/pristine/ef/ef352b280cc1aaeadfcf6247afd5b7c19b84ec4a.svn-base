/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package master.presentacion.beans;

import digitales.logica.clases.Articulo;
import digitales.logica.clases.ArticuloIndex;
import digitales.logica.clases.Imagen;
import digitales.logica.funciones.FArticulo;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import recursos.Util;

/**
 *
 * @author icits
 */
@ManagedBean
@ViewScoped
public class ListaArticuloC {

    private ArrayList<ArticuloIndex> lstArticulo;
    private int codigo_articulo;
    private Articulo objArticulo;
    //sesion del sitio
    @ManagedProperty(value = "#{sesionSitioDataManager}")
    private SesionSitioDataManager dmSitio;

    public ListaArticuloC() {
        this.cargarArticulo();
    }

    public SesionSitioDataManager getDmSitio() {
        return dmSitio;
    }

    public void setDmSitio(SesionSitioDataManager dmSitio) {
        this.dmSitio = dmSitio;
    }

    public ArrayList<ArticuloIndex> getLstArticulo() {
        return lstArticulo;
    }

    public void setLstArticulo(ArrayList<ArticuloIndex> lstArticulo) {
        this.lstArticulo = lstArticulo;
    }

    public int getCodigo_articulo() {
        return codigo_articulo;
    }

    public void setCodigo_articulo(int codigo_articulo) {
        this.codigo_articulo = codigo_articulo;
    }

    public Articulo getObjArticulo() {
        return objArticulo;
    }

    public void setObjArticulo(Articulo objArticulo) {
        this.objArticulo = objArticulo;
    }

    public void cargarArticulo() {
        try {
            lstArticulo = FArticulo.obtenerArticuloDadoCategoriaIndex(11);
        } catch (Exception e) {
            Util.addErrorMessage(e, "Error con la conexion");
        }
    }
    
    public String obtieneFecha(long fecha) {
        Timestamp fechaFin = null;
        try {
            fechaFin = recursos.Tools.obtieneFechaTimeStamp(fecha);
        } catch (ParseException ex) {
            Util.addErrorMessage(ex, "Error");
           // Logger.getLogger(MovPresItemC.class.getName()).log(Level.SEVERE, null, ex);
        }
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formato.format(fechaFin.getTime());
    }
}
