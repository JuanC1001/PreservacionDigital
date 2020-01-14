/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package digitales.presentacion.beans;


import digitales.logica.clases.Video;
import digitales.logica.funciones.FVideo;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import master.presentacion.beans.SesionUsuarioDataManager;
import org.apache.taglibs.standard.functions.Functions;
import org.primefaces.context.DefaultRequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import recursos.Tools;
import recursos.Util;

/**
 *
 * @author icits
 */
@ManagedBean
@ViewScoped
public class VideoControlador {
    private Video objVideo;
    private ArrayList<Video> lstVideo;
    private Video videoSel;
    @ManagedProperty(value = "#{sesionUsuarioDataManager}")
    private SesionUsuarioDataManager dm;
    private int estadoSel;
     private String nombreVideo;
    private UploadedFile archivoVideo;
    java.util.ResourceBundle Configuracion = java.util.ResourceBundle.getBundle("recursos.rutasMedia");

    public VideoControlador() {
        this.videoSel = new Video();
        this.objVideo = new Video();
        this.cargarVideo();
        this.estadoSel = -1;        
    }

    public String getNombreVideo() {
        return nombreVideo;
    }

    public void setNombreVideo(String nombreVideo) {
        this.nombreVideo = nombreVideo;
    }

    public UploadedFile getArchivoVideo() {
        return archivoVideo;
    }

    public void setArchivoVideo(UploadedFile archivoVideo) {
        this.archivoVideo = archivoVideo;
    }
    
    public Video getObjVideo() {
        return objVideo;
    }

    public void setObjVideo(Video objVideo) {
        this.objVideo = objVideo;
    }

    public ArrayList<Video> getLstVideo() {
        return lstVideo;
    }

    public void setLstVideo(ArrayList<Video> lstVideo) {
        this.lstVideo = lstVideo;
    }

    public Video getVideoSel() {
        return videoSel;
    }

    public void setVideoSel(Video videoSel) {
        this.videoSel = videoSel;
    }

    public SesionUsuarioDataManager getDm() {
        return dm;
    }

    public void setDm(SesionUsuarioDataManager dm) {
        this.dm = dm;
    }

    public int getEstadoSel() {
        return estadoSel;
    }

    public void setEstadoSel(int estadoSel) {
        this.estadoSel = estadoSel;
    }
    
      public void cargarVideo() {
        try {
            lstVideo = FVideo.obtenerTodos();
        } catch (Exception e) {
            Util.addErrorMessage(e, "Error");
        }
    }
    
public void insertarVideo() {
        try {
            objVideo.setEstado(estadoSel);
            objVideo.setFecha_registro(Tools.obtieneFechaActualenMiliseg());
            objVideo.setCodigo_persona(dm.getSesionPersona().getCodigo_titular());
            if (FVideo.insertar(objVideo) == true) {
                FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Insertados");
                FacesContext.getCurrentInstance().addMessage(null, mensaje);
                DefaultRequestContext.getCurrentInstance().execute("dlgInsertarVideo.hide()");
                this.cargarVideo();
                this.objVideo = new Video();
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
public void actualizarVideo() {
        try {
            objVideo.setCodigo_persona(dm.getSesionPersona().getCodigo_titular());
            if (FVideo.actualizar(videoSel)) {
                FacesMessage mensajeActualizacion = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Actualizados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeActualizacion);
                DefaultRequestContext.getCurrentInstance().execute("dlgEditarVideo.hide()");
            } else {
                FacesMessage mensajeErrorActualizacion = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", "Datos no Actualizados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeErrorActualizacion);
            }
        } catch (Exception e) {
            FacesMessage mensajeErrorA = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, mensajeErrorA);
        }
    }

public void eliminarVideo() {
        try {
            if (FVideo.eliminar(videoSel)) {
                FacesMessage mensajeEliminar = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Eliminados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeEliminar);
                DefaultRequestContext.getCurrentInstance().execute("dlgEliminarVideo.hide()");
                this.cargarVideo();
            } else {
                FacesMessage mensajeErrorEliminar = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", "Datos no  Eliminados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeErrorEliminar);
            }
        } catch (Exception e) {
            FacesMessage mensajeErrorE = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, mensajeErrorE);
        }
    }
 public void cargarArchivoVideo(FileUploadEvent e) {
        System.out.println("Entra al método cargar video");
        UploadedFile file = e.getFile();
        this.archivoVideo = file;
        System.out.println(file.getContentType());
        objVideo.setTipo(file.getContentType());
        System.out.println(file.getSize());
        System.out.println(file.getFileName());
        nombreVideo = file.getFileName();
        //byte[] contenido = file.getContents();
        byte[] contenido;
        try {
            contenido = this.getFileContents(e.getFile().getInputstream());
            if (guardarArchivo(file.getFileName(), contenido)) {
            Util.addSuccessMessage("Video guardado con éxito!!");
        } else {
            Util.addErrorMessage("Error al cargar el video");
        }
        } catch (IOException ex) {
            Logger.getLogger(VideoControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public boolean guardarArchivo(String nombre, byte[] contenido) {
        String rutaVideo = Configuracion.getString("rutaVideos");
        int longitudRelativa = Integer.valueOf(Configuracion.getString("logitudRelativa"));
        File f = new File(rutaVideo+nombre);
        try {
            System.out.println("PATH: " + f.getAbsolutePath());
            objVideo.setPath(Functions.substring(f.getAbsolutePath(), longitudRelativa, f.getAbsolutePath().length()));
            objVideo.setTitulo(nombre);
            System.out.println("cargar objeto fos ");
            FileOutputStream fos = new FileOutputStream(f);
            System.out.println("escribir fos ");
            fos.write(contenido);

            return true;
        } catch (Exception e) {
            Util.mostrarMensaje(e.getMessage());
            return false;
        }
    }

    private byte[] getFileContents(InputStream in) {
        byte[] bytes = null;
        try {
            // write the inputStream to a FileOutputStream            
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int read = 0;
            bytes = new byte[1024];

            while ((read = in.read(bytes)) != -1) {
                bos.write(bytes, 0, read);
            }
            bytes = bos.toByteArray();
            in.close();
            in = null;
            bos.flush();
            bos.close();
            bos = null;
            System.out.println("New file created!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return bytes;
    }
}
