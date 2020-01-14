/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package master.presentacion.beans;

import digitales.logica.clases.Articulo;
import digitales.logica.clases.Documento;
import digitales.logica.clases.Imagen;
import digitales.logica.clases.Sonido;
import digitales.logica.clases.Texto;
import digitales.logica.clases.Video;
import digitales.logica.funciones.FArticulo;
import digitales.logica.funciones.FDocumento;
import digitales.logica.funciones.FImagen;
import digitales.logica.funciones.FSonido;
import digitales.logica.funciones.FTexto;
import digitales.logica.funciones.FVideo;
import java.io.Serializable;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
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
public class DetalleArticuloC implements Serializable {

    private ArrayList<Imagen> lstImagen;
    private ArrayList<Video> lstVideo;
    private ArrayList<Sonido> lstSonido;
    private ArrayList<Documento> lstDocumento;
    private Texto objTexto;
    private Articulo objArticulo;
    //sesion del sitio
    @ManagedProperty(value = "#{sesionSitioDataManager}")
    private SesionSitioDataManager dmSitio;

    public DetalleArticuloC() {

    }

    @PostConstruct
    public void PostDetalleArticuloC() {
        this.cargarImagen();
        this.cargarVideo();
        this.cargarSonido();
        this.cargarDocumento();
        this.cargarArticulo();
        this.cargarTexto();
    }

    public SesionSitioDataManager getDmSitio() {
        return dmSitio;
    }

    public void setDmSitio(SesionSitioDataManager dmSitio) {
        this.dmSitio = dmSitio;
    }

    public Articulo getObjArticulo() {
        return objArticulo;
    }

    public void setObjArticulo(Articulo objArticulo) {
        this.objArticulo = objArticulo;
    }

    public Texto getObjTexto() {
        return objTexto;
    }

    public void setObjTexto(Texto objTexto) {
        this.objTexto = objTexto;
    }

    public ArrayList<Imagen> getLstImagen() {
        return lstImagen;
    }

    public void setLstImagen(ArrayList<Imagen> lstImagen) {
        this.lstImagen = lstImagen;
    }

    public ArrayList<Video> getLstVideo() {
        return lstVideo;
    }

    public void setLstVideo(ArrayList<Video> lstVideo) {
        this.lstVideo = lstVideo;
    }

    public ArrayList<Sonido> getLstSonido() {
        return lstSonido;
    }

    public void setLstSonido(ArrayList<Sonido> lstSonido) {
        this.lstSonido = lstSonido;
    }

    public ArrayList<Documento> getLstDocumento() {
        return lstDocumento;
    }

    public void setLstDocumento(ArrayList<Documento> lstDocumento) {
        this.lstDocumento = lstDocumento;
    }

    public void cargarImagen() {
        try {
            lstImagen = FImagen.obtenerListaImagenDadoArticulo(this.dmSitio.getArticuloActual().getCodigo());
        } catch (Exception e) {
            Util.addErrorMessage(e, "Error con la conexion");
        }
    }

    public void cargarVideo() {
        try {
            lstVideo = FVideo.obtenerListaVideoDadoArticulo(this.dmSitio.getArticuloActual().getCodigo());
        } catch (Exception e) {
            Util.addErrorMessage(e, "Error con la conexion");
        }
    }

    public void cargarSonido() {
        try {
            lstSonido = FSonido.obtenerListaSonidoDadoArticulo(this.dmSitio.getArticuloActual().getCodigo());
        } catch (Exception e) {
            Util.addErrorMessage(e, "Error con la conexion");
        }
    }

    public void cargarDocumento() {
        try {
            lstDocumento = FDocumento.obtenerListaDocumentoDadoArticulo(this.dmSitio.getArticuloActual().getCodigo());
        } catch (Exception e) {
            Util.addErrorMessage(e, "Error con la conexion");
        }
    }

    public void cargarArticulo() {
        try {
            objArticulo = FArticulo.obtenerArticuloDadoCodigo(this.dmSitio.getArticuloActual().getCodigo());
        } catch (Exception e) {
            Util.addErrorMessage(e, "Error con la conexion");
        }
    }
    public void cargarTexto() {
        try {
            objTexto= FTexto.obtenerTextoDadoArticulo(this.dmSitio.getArticuloActual().getCodigo());
        } catch (Exception e) {
            Util.addErrorMessage(e, "Error con la conexion");
        }
    }
    public String leerArticulo() {

        return "/faces/detalleArticulo";
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
