/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package master.presentacion.beans;


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

    private int codigo_articulo;
    //sesion del sitio
    @ManagedProperty(value = "#{sesionSitioDataManager}")
    private SesionSitioDataManager dmSitio;

    public ListaArticuloC() {
        
        
    }

    public SesionSitioDataManager getDmSitio() {
        return dmSitio;
    }

    public void setDmSitio(SesionSitioDataManager dmSitio) {
        this.dmSitio = dmSitio;
    }

    public int getCodigo_articulo() {
        return codigo_articulo;
    }

    public void setCodigo_articulo(int codigo_articulo) {
        this.codigo_articulo = codigo_articulo;
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
