/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package digitales.presentacion.beans;

import digitales.logica.clases.Imagen;
import digitales.logica.funciones.FImagen;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
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
public class ImagenControlador implements Serializable {

    private Imagen objImagen;
    private ArrayList<Imagen> lstImagen;
    private Imagen imagenSel;
    @ManagedProperty(value = "#{sesionUsuarioDataManager}")
    private SesionUsuarioDataManager dm;
    private int estadoSel;
    //manejo de imagenes
    private String nombreImagen;
    private UploadedFile archivoImagen;
    //cargar configuracion del  path
    java.util.ResourceBundle Configuracion = java.util.ResourceBundle.getBundle("recursos.rutasMedia");

    public ImagenControlador() {

        this.imagenSel = new Imagen();
        this.objImagen = new Imagen();
        this.cargarImagen();
        this.estadoSel = -1;
    }

    public String getNombreImagen() {
        return nombreImagen;
    }

    public void setNombreImagen(String nombreImagen) {
        this.nombreImagen = nombreImagen;
    }

    public UploadedFile getArchivoImagen() {
        return archivoImagen;
    }

    public void setArchivoImagen(UploadedFile archivoImagen) {
        this.archivoImagen = archivoImagen;
    }

    public int getEstadoSel() {
        return estadoSel;
    }

    public void setEstadoSel(int estadoSel) {
        this.estadoSel = estadoSel;
    }

    public Imagen getObjImagen() {
        return objImagen;
    }

    public void setObjImagen(Imagen objImagen) {
        this.objImagen = objImagen;
    }

    public ArrayList<Imagen> getLstImagen() {
        return lstImagen;
    }

    public void setLstImagen(ArrayList<Imagen> lstImagen) {
        this.lstImagen = lstImagen;
    }

    public Imagen getImagenSel() {
        return imagenSel;
    }

    public void setImagenSel(Imagen imagenSel) {
        this.imagenSel = imagenSel;
    }

    public SesionUsuarioDataManager getDm() {
        return dm;
    }

    public void setDm(SesionUsuarioDataManager dm) {
        this.dm = dm;
    }

    public void cargarImagen() {
        try {
            lstImagen = FImagen.obtenerTodos();
        } catch (Exception e) {
            Util.addErrorMessage(e, "Error");
        }

    }

    public void insertarImagen() {
        try {
            objImagen.setEstado(estadoSel);
            objImagen.setFecha_registro(Tools.obtieneFechaActualenMiliseg());
            objImagen.setCodigo_persona(dm.getSesionPersona().getCodigo_titular());
            if (FImagen.insertar(objImagen) == true) {
                FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Insertados");
                FacesContext.getCurrentInstance().addMessage(null, mensaje);
                DefaultRequestContext.getCurrentInstance().execute("dlgInsertarImagen.hide()");
                this.cargarImagen();
                this.objImagen = new Imagen();
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

    public void actualizarImagen() {
        try {
            objImagen.setCodigo_persona(dm.getSesionPersona().getCodigo_titular());
            if (FImagen.actualizar(imagenSel)) {
                FacesMessage mensajeActualizacion = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Actualizados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeActualizacion);
                DefaultRequestContext.getCurrentInstance().execute("dlgEditarImagen.hide()");
            } else {
                FacesMessage mensajeErrorActualizacion = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", "Datos no Actualizados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeErrorActualizacion);
            }
        } catch (Exception e) {
            FacesMessage mensajeErrorA = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, mensajeErrorA);
        }
    }

    public void eliminarImagen() {
        try {
            if (FImagen.eliminar(imagenSel)) {
                FacesMessage mensajeEliminar = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Eliminados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeEliminar);
                DefaultRequestContext.getCurrentInstance().execute("dlgEliminarImagen.hide()");
                this.cargarImagen();
            } else {
                FacesMessage mensajeErrorEliminar = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", "Datos no  Eliminados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeErrorEliminar);
            }
        } catch (Exception e) {
            FacesMessage mensajeErrorE = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, mensajeErrorE);
        }
    }

    public void cargarArchivoImagen(FileUploadEvent e) {
        System.out.println("Entra al método cargar imagen");
        UploadedFile file = e.getFile();
        this.archivoImagen = file;
        System.out.println(file.getContentType());
        objImagen.setTipo(file.getContentType());
        System.out.println(file.getSize());
        System.out.println(file.getFileName());
        nombreImagen = file.getFileName();
        //byte[] contenido = file.getContents();
        byte[] contenido;
        try {
            contenido = this.getFileContents(e.getFile().getInputstream());
            if (guardarArchivo(file.getFileName(), contenido)) {
            Util.addSuccessMessage("Imagen guardada con éxito!!");
        } else {
            Util.addErrorMessage("Error al cargar la imagen");
        }
        } catch (IOException ex) {
            Logger.getLogger(ImagenControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public boolean guardarArchivo(String nombre, byte[] contenido) {
        String rutaImagenes = Configuracion.getString("rutaImagenes");
        int longitudRelativa = Integer.valueOf(Configuracion.getString("logitudRelativa"));
        File f = new File(rutaImagenes+nombre);
        try {
            System.out.println("PATH: " + f.getAbsolutePath());
            objImagen.setPath(Functions.substring(f.getAbsolutePath(), longitudRelativa, f.getAbsolutePath().length()));
            objImagen.setTitulo(nombre);
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
