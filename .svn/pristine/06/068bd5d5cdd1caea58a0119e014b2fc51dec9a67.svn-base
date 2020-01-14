/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package master.presentacion.beans;

import digitales.logica.clases.Articulo;
import digitales.logica.clases.ArticuloIndex;
import digitales.logica.clases.Documento;
import digitales.logica.clases.Imagen;
import digitales.logica.clases.Sonido;
import digitales.logica.clases.Video;
import digitales.logica.funciones.FArticulo;
import digitales.logica.funciones.FDocumento;
import digitales.logica.funciones.FImagen;
import digitales.logica.funciones.FSonido;
import digitales.logica.funciones.FVideo;
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

    private ArrayList<ArticuloIndex> lstBlogs;
    private ArrayList<ArticuloIndex> lstNoticias;
    private ArrayList<ArticuloIndex> lstProyectos;
    private ArrayList<ArticuloIndex> lstEquipo;
    private ArrayList<Video> lstVideos;
    private ArrayList<Articulo> lstDocumentos;
    private ArrayList<Imagen> lstImagenes;
    private ArrayList<Documento> lstDocumento;
    private final static String[] iconos;
    private ArrayList<Menu_Sitio> lstMenuSitio;
    private int codigo_articulo;
    private Imagen objImagen;
    private ArrayList<Sonido> lstSonidos;
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
        this.cargarBlogs();
        this.cargarNoticias();
        this.cargarProyectos();
        this.cargarDocumentos();
        this.cargarMenuSitio();
        this.cargarVideos();
        this.cargarSonidos();
    }

    public ArrayList<Sonido> getLstSonidos() {
        return lstSonidos;
    }

    public void setLstSonidos(ArrayList<Sonido> lstSonidos) {
        this.lstSonidos = lstSonidos;
    }

    public ArrayList<Video> getLstVideos() {
        return lstVideos;
    }

    public void setLstVideos(ArrayList<Video> lstVideos) {
        this.lstVideos = lstVideos;
    }

    public SesionSitioDataManager getDmSitio() {
        return dmSitio;
    }

    public void setDmSitio(SesionSitioDataManager dmSitio) {
        this.dmSitio = dmSitio;
    }

    public ArrayList<Documento> getLstDocumento() {
        return lstDocumento;
    }

    public void setLstDocumento(ArrayList<Documento> lstDocumento) {
        this.lstDocumento = lstDocumento;
    }

    public ArrayList<Menu_Sitio> getLstMenuSitio() {
        return lstMenuSitio;
    }

    public void setLstMenuSitio(ArrayList<Menu_Sitio> lstMenuSitio) {
        this.lstMenuSitio = lstMenuSitio;
    }

    public ArrayList<Articulo> getLstDocumentos() {
        return lstDocumentos;
    }

    public void setLstDocumentos(ArrayList<Articulo> lstDocumentos) {
        this.lstDocumentos = lstDocumentos;
    }

    public ArrayList<Imagen> getLstImagenes() {
        return lstImagenes;
    }

    public void setLstImagenes(ArrayList<Imagen> lstImagenes) {
        this.lstImagenes = lstImagenes;
    }

    public ArrayList<ArticuloIndex> getLstBlogs() {
        return lstBlogs;
    }

    public void setLstBlogs(ArrayList<ArticuloIndex> lstBlogs) {
        this.lstBlogs = lstBlogs;
    }

    public ArrayList<ArticuloIndex> getLstNoticias() {
        return lstNoticias;
    }

    public void setLstNoticias(ArrayList<ArticuloIndex> lstNoticias) {
        this.lstNoticias = lstNoticias;
    }

    public ArrayList<ArticuloIndex> getLstProyectos() {
        return lstProyectos;
    }

    public void setLstProyectos(ArrayList<ArticuloIndex> lstProyectos) {
        this.lstProyectos = lstProyectos;
    }

    public void cargarNoticias() {
        try {
            lstNoticias = FArticulo.obtenerArticuloDadoCategoriaIndex(10);
        } catch (Exception e) {
            Util.addErrorMessage(e, "Error con la conexion");
        }

    }

    public void cargarDocumentos() {
        try {
            lstDocumento = FDocumento.obtenerTodos();
        } catch (Exception e) {
            Util.addErrorMessage(e, "Error con la conexion");
        }

    }

    public void cargarBlogs() {
        try {
            lstBlogs = FArticulo.obtenerArticuloDadoCategoriaIndex(11);
        } catch (Exception e) {
            Util.addErrorMessage(e, "Error con la conexion");
        }
    }

    public void cargarProyectos() {
        try {
            lstProyectos = FArticulo.obtenerArticuloDadoCategoriaIndex(12);
        } catch (Exception e) {
            Util.addErrorMessage(e, "Error con la conexion");
        }
    }

    public void cargarImagenes() {
        try {
            lstImagenes = FImagen.obtenerTodos();
        } catch (Exception e) {
            Util.addErrorMessage(e, "Error con la conexion");
        }
    }
    
    public void cargarVideos(){
        try {
            lstVideos = FVideo.obtenerTodos();
        } catch (Exception e) {
            Util.addErrorMessage(e, "Error con la conexion");
        }
    }

    public void cargarSonidos(){
        try {
            lstSonidos = FSonido.obtenerTodos();
        } catch (Exception e) {
            Util.addErrorMessage(e, "Error con la conexion");
        }
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
