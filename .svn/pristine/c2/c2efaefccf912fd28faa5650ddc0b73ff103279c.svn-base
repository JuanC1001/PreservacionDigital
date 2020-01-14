/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package digitales.presentacion.beans;

import digitales.logica.clases.Articulo;
import digitales.logica.clases.Categoria;
import digitales.logica.clases.Documento;
import digitales.logica.clases.Imagen;
import digitales.logica.clases.Sonido;
import digitales.logica.clases.Texto;
import digitales.logica.clases.Video;
import digitales.logica.funciones.FArticulo;
import digitales.logica.funciones.FCategoria;
import digitales.logica.funciones.FDocumento;
import digitales.logica.funciones.FImagen;
import digitales.logica.funciones.FSonido;
import digitales.logica.funciones.FTexto;
import digitales.logica.funciones.FVideo;
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
public class AgregarArticuloControlador {

    private Articulo objArticulo;
    private Articulo objArticuloSel;
    private ArrayList<Articulo> lstArticulos;
    private Categoria categoriaSel;
    private ArrayList<Categoria> lstCategorias;
    private int estadoSel;
    private ArrayList<Texto> lstTextos;
    private Texto textoSel;
    private Imagen imagenSel;
    private ArrayList<Imagen> lstImagen;
    private ArrayList<Imagen> lstImagenSel;
    private Imagen objImagen;
    private Sonido sonidoSel;
    private ArrayList<Sonido> lstSonido;
    private ArrayList<Sonido> lstSonidoSel;
    private Sonido objSonido;
    private Video videoSel;
    private ArrayList<Video> lstVideo;
    private ArrayList<Video> lstVideoSel;
    private Video objVideo;
    private Documento documentoSel;
    private ArrayList<Documento> lstDocumento;
    private ArrayList<Documento> lstDocumentoSel;
    private Documento objDocumento;
    @ManagedProperty(value = "#{sesionUsuarioDataManager}")
    private SesionUsuarioDataManager dm;
    private Texto objTexto;
    private String accion;

    public AgregarArticuloControlador() {
        this.objArticulo = new Articulo();
        this.objArticuloSel = new Articulo();
        this.objArticulo.setEstado(-1);
        this.objImagen = new Imagen();
        this.objSonido = new Sonido();
        this.objVideo = new Video();
        this.objDocumento = new Documento();
        this.objTexto = new Texto();
        this.cargarArticulos();
        this.cargarCategorias();
        this.cargarTextos();
        this.cargarDocumento();
        this.cargarImagen();
        this.cargarSonido();
        this.cargarVideo();
        this.categoriaSel = new Categoria();
        this.lstImagenSel = new ArrayList<Imagen>();
        this.lstVideoSel = new ArrayList<Video>();
        this.lstSonidoSel = new ArrayList<Sonido>();
        this.lstDocumentoSel = new ArrayList<Documento>();
        this.textoSel = new Texto();
        this.estadoSel = -1;
        this.accion = "insertando";
    }

    
    public Articulo getObjArticuloSel() {
        return objArticuloSel;
    }

    public void setObjArticuloSel(Articulo objArticuloSel) {
        this.objArticuloSel = objArticuloSel;
    }

    public Texto getObjTexto() {
        return objTexto;
    }

    public void setObjTexto(Texto objTexto) {
        this.objTexto = objTexto;
    }

    public SesionUsuarioDataManager getDm() {
        return dm;
    }

    public void setDm(SesionUsuarioDataManager dm) {
        this.dm = dm;
    }

    public ArrayList<Articulo> getLstArticulos() {
        return lstArticulos;
    }

    public void setLstArticulos(ArrayList<Articulo> lstArticulos) {
        this.lstArticulos = lstArticulos;
    }

    public Sonido getObjSonido() {
        return objSonido;
    }

    public void setObjSonido(Sonido objSonido) {
        this.objSonido = objSonido;
    }

    public Video getObjVideo() {
        return objVideo;
    }

    public void setObjVideo(Video objVideo) {
        this.objVideo = objVideo;
    }

    public Documento getObjDocumento() {
        return objDocumento;
    }

    public void setObjDocumento(Documento objDocumento) {
        this.objDocumento = objDocumento;
    }

    public Imagen getObjImagen() {
        return objImagen;
    }

    public void setObjImagen(Imagen objImagen) {
        this.objImagen = objImagen;
    }

    public Articulo getObjArticulo() {
        return objArticulo;
    }

    public void setObjArticulo(Articulo objArticulo) {
        this.objArticulo = objArticulo;
    }

    public Categoria getCategoriaSel() {
        return categoriaSel;
    }

    public void setCategoriaSel(Categoria categoriaSel) {
        this.categoriaSel = categoriaSel;
    }

    public ArrayList<Categoria> getLstCategorias() {
        return lstCategorias;
    }

    public void setLstCategorias(ArrayList<Categoria> lstCategorias) {
        this.lstCategorias = lstCategorias;
    }

    public int getEstadoSel() {
        return estadoSel;
    }

    public void setEstadoSel(int estadoSel) {
        this.estadoSel = estadoSel;
    }

    public ArrayList<Texto> getLstTextos() {
        return lstTextos;
    }

    public void setLstTextos(ArrayList<Texto> lstTextos) {
        this.lstTextos = lstTextos;
    }

    public Texto getTextoSel() {
        return textoSel;
    }

    public void setTextoSel(Texto textoSel) {
        this.textoSel = textoSel;
    }

    public ArrayList<Imagen> getLstImagen() {
        return lstImagen;
    }

    public void setLstImagen(ArrayList<Imagen> lstImagen) {
        this.lstImagen = lstImagen;
    }

    public ArrayList<Imagen> getLstImagenSel() {
        return lstImagenSel;
    }

    public void setLstImagenSel(ArrayList<Imagen> lstImagenSel) {
        this.lstImagenSel = lstImagenSel;
    }

    public ArrayList<Sonido> getLstSonido() {
        return lstSonido;
    }

    public void setLstSonido(ArrayList<Sonido> lstSonido) {
        this.lstSonido = lstSonido;
    }

    public ArrayList<Sonido> getLstSonidoSel() {
        return lstSonidoSel;
    }

    public void setLstSonidoSel(ArrayList<Sonido> lstSonidoSel) {
        this.lstSonidoSel = lstSonidoSel;
    }

    public ArrayList<Video> getLstVideo() {
        return lstVideo;
    }

    public void setLstVideo(ArrayList<Video> lstVideo) {
        this.lstVideo = lstVideo;
    }

    public ArrayList<Video> getLstVideoSel() {
        return lstVideoSel;
    }

    public void setLstVideoSel(ArrayList<Video> lstVideoSel) {
        this.lstVideoSel = lstVideoSel;
    }

    public ArrayList<Documento> getLstDocumento() {
        return lstDocumento;
    }

    public void setLstDocumento(ArrayList<Documento> lstDocumento) {
        this.lstDocumento = lstDocumento;
    }

    public ArrayList<Documento> getLstDocumentoSel() {
        return lstDocumentoSel;
    }

    public void setLstDocumentoSel(ArrayList<Documento> lstDocumentoSel) {
        this.lstDocumentoSel = lstDocumentoSel;
    }

    public void cargarCategorias() {
        try {
            this.lstCategorias = FCategoria.obtenerTodos();
        } catch (Exception e) {
        }
    }

    public void cargarTextos() {
        try {
            this.lstTextos = FTexto.obtenerTodos();
        } catch (Exception e) {
        }
    }

    public void cargarImagen() {
        try {
            this.lstImagen = FImagen.obtenerTodos();
        } catch (Exception e) {
        }
    }

    public void cargarDocumento() {
        try {
            this.lstDocumento = FDocumento.obtenerTodos();
        } catch (Exception e) {
        }
    }

    public void cargarSonido() {
        try {
            this.lstSonido = FSonido.obtenerTodos();
        } catch (Exception e) {
        }
    }

    public void cargarVideo() {
        try {
            this.lstVideo = FVideo.obtenerTodos();
        } catch (Exception e) {
        }
    }

    public void cargarArticulos() {
        try {
            this.lstArticulos = FArticulo.obtenerTodos();
        } catch (Exception e) {
            Util.addErrorMessage(e, "Error");
        }

    }

    public void eliminarLstImagenSel() {
        lstImagenSel.remove(objImagen);
    }

    public void eliminarLstSonidoSel() {
        lstSonidoSel.remove(objSonido);
    }

    public void eliminarLstVideoSel() {
        lstVideoSel.remove(objVideo);
    }

    public void eliminarLstDocumentoSel() {
        lstDocumentoSel.remove(objDocumento);
    }

    public void insertarArticulos() {

        try {
            objArticulo.setEstado(estadoSel);
            objArticulo.setFecha_registro(Tools.obtieneFechaActualenMiliseg());
            objArticulo.setCodigo_categoria(categoriaSel);
            objArticulo.setFecha_edicion(Tools.obtieneFechaActualenMiliseg());
            objArticulo.setCodigo_persona(dm.getSesionPersona().getCodigo_titular());
            objTexto=textoSel;
            if (FArticulo.insertar(objArticulo, objTexto, lstImagen, lstVideo,
                    lstSonido, lstDocumento) > 0) {
                FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Guardados");
                FacesContext.getCurrentInstance().addMessage(null, mensaje);
                DefaultRequestContext.getCurrentInstance().execute("dlgGuardarDatos.hide()");
                this.cargarArticulos();

            } else {
                FacesMessage mensajeError = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", "Datos no Guardados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeError);
            }
        } catch (Exception e) {
            FacesMessage mensajeErrorIngreso = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, mensajeErrorIngreso);
        }

    }
    
  public void cargarFormulario(){
  objArticulo=objArticuloSel;
  this.accion="actualizando";
  this.categoriaSel=objArticuloSel.getCodigo_categoria();
      try {
          textoSel=FTexto.obtenerTextoDadoArticulo(objArticuloSel.getCodigo());
          lstImagenSel=FImagen.obtenerListaImagenDadoArticulo(objArticuloSel.getCodigo());
          lstDocumentoSel=FDocumento.obtenerListaDocumentoDadoArticulo(objArticuloSel.getCodigo());
          lstSonidoSel=FSonido.obtenerListaSonidoDadoArticulo(objArticuloSel.getCodigo());
          lstVideoSel=FVideo.obtenerListaVideoDadoArticulo(objArticuloSel.getCodigo());
      } catch (Exception e) {
      }

  }
  
  public void actualizarArticulo(){
      try {
            objArticulo.setEstado(estadoSel);
            objArticulo.setCodigo_categoria(categoriaSel);
            objArticulo.setFecha_edicion(Tools.obtieneFechaActualenMiliseg());
            objArticulo.setFecha_registro(Tools.obtieneFechaActualenMiliseg());
            objArticulo.setCodigo_persona(dm.getSesionPersona().getCodigo_titular());
            objTexto=textoSel;
            if (FArticulo.actualizar(objArticulo, objTexto, lstImagenSel, lstVideoSel, lstSonidoSel, lstDocumentoSel)) {
                FacesMessage mensajeActualizacion = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Actualizados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeActualizacion);
                DefaultRequestContext.getCurrentInstance().execute("dlgGuardarDatos.hide()");
            } else {
                FacesMessage mensajeErrorActualizacion = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", "Datos no Actualizados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeErrorActualizacion);
            }
        } catch (Exception e) {
            FacesMessage mensajeErrorA = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, mensajeErrorA);
        }
  }
  
  public void guardarDatos(){
      if (accion == "insertando") {
          this.insertarArticulos();
          
      } else {
          this.actualizarArticulo();
      }
  
  }
}
