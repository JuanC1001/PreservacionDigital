/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package digitales.presentacion.beans;

import digitales.logica.clases.Sonido;
import digitales.logica.funciones.FSonido;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import master.presentacion.beans.SesionUsuario;
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
public class SonidoControlador {

    private Sonido objSonido;
    private ArrayList<Sonido> lstSonido;
    private Sonido sonidoSel;
    @ManagedProperty(value = "#{sesionUsuarioDataManager}")
    private SesionUsuarioDataManager dm;
    private int estadoSel;
    //manejo de sonidos
    private String nombreSonido;
    private UploadedFile archivoSonido;
    //cargar configuracion del  path
    java.util.ResourceBundle Configuracion = java.util.ResourceBundle.getBundle("recursos.rutasMedia");

    public SonidoControlador() {

        this.sonidoSel = new Sonido();
        this.objSonido = new Sonido();
        this.cargarSonido();
        this.estadoSel = -1;
    }

    public String getNombreSonido() {
        return nombreSonido;
    }

    public void setNombreSonido(String nombreSonido) {
        this.nombreSonido = nombreSonido;
    }

    public UploadedFile getArchivoSonido() {
        return archivoSonido;
    }

    public void setArchivoSonido(UploadedFile archivoSonido) {
        this.archivoSonido = archivoSonido;
    }

    public int getEstadoSel() {
        return estadoSel;
    }

    public void setEstadoSel(int estadoSel) {
        this.estadoSel = estadoSel;
    }

    public Sonido getObjSonido() {
        return objSonido;
    }

    public void setObjSonido(Sonido objSonido) {
        this.objSonido = objSonido;
    }

    public ArrayList<Sonido> getLstSonido() {
        return lstSonido;
    }

    public void setLstSonido(ArrayList<Sonido> lstSonido) {
        this.lstSonido = lstSonido;
    }

    public Sonido getSonidoSel() {
        return sonidoSel;
    }

    public void setSonidoSel(Sonido sonidoSel) {
        this.sonidoSel = sonidoSel;
    }

    public SesionUsuarioDataManager getDm() {
        return dm;
    }

    public void setDm(SesionUsuarioDataManager dm) {
        this.dm = dm;
    }

    public void cargarSonido() {
        try {
            lstSonido = FSonido.obtenerTodos();
        } catch (Exception e) {
            Util.addErrorMessage(e, "Error");
        }


    }

    public void insertarSonido() {
        try {
            objSonido.setEstado(estadoSel);
            objSonido.setFecha_registro(Tools.obtieneFechaActualenMiliseg());
            objSonido.setCodigo_persona(dm.getSesionPersona().getCodigo_titular());
            if (FSonido.insertar(objSonido) == true) {
                FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Insertados");
                FacesContext.getCurrentInstance().addMessage(null, mensaje);
                DefaultRequestContext.getCurrentInstance().execute("dlgInsertarSonido.hide()");
                this.cargarSonido();
                this.objSonido = new Sonido();
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

    public void actualizarSonido() {
        try {
            objSonido.setCodigo_persona(dm.getSesionPersona().getCodigo_titular());
            if (FSonido.actualizar(sonidoSel)) {
                FacesMessage mensajeActualizacion = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Actualizados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeActualizacion);
                DefaultRequestContext.getCurrentInstance().execute("dlgEditarSonido.hide()");
            } else {
                FacesMessage mensajeErrorActualizacion = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", "Datos no Actualizados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeErrorActualizacion);
            }
        } catch (Exception e) {
            FacesMessage mensajeErrorA = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, mensajeErrorA);
        }
    }

    public void eliminarSonido() {
        try {
            if (FSonido.eliminar(sonidoSel)) {
                FacesMessage mensajeEliminar = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Eliminados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeEliminar);
                DefaultRequestContext.getCurrentInstance().execute("dlgEliminarSonido.hide()");
                this.cargarSonido();
            } else {
                FacesMessage mensajeErrorEliminar = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", "Datos no  Eliminados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeErrorEliminar);
            }
        } catch (Exception e) {
            FacesMessage mensajeErrorE = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, mensajeErrorE);
        }
    }

    public void cargarArchivoSonido(FileUploadEvent e) {
        System.out.println("Entra al método cargar sonido");
        UploadedFile file = e.getFile();
        this.archivoSonido = file;
        System.out.println(file.getContentType());
        objSonido.setTipo(file.getContentType());
        System.out.println(file.getSize());
        System.out.println(file.getFileName());
        nombreSonido = file.getFileName();
        //byte[] contenido = file.getContents();
        byte[] contenido;
        try {
            contenido = this.getFileContents(e.getFile().getInputstream());
            if (guardarArchivo(file.getFileName(), contenido)) {
                Util.addSuccessMessage("Sonido guardado con éxito!!");
            } else {
                Util.addErrorMessage("Error al cargar el Sonido");
            }
        } catch (IOException ex) {
            Logger.getLogger(SonidoControlador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public boolean guardarArchivo(String nombre, byte[] contenido) {
        String rutaSonidos = Configuracion.getString("rutaSonidos");
        int longitudRelativa = Integer.valueOf(Configuracion.getString("logitudRelativa"));
        File f = new File(rutaSonidos + nombre);
        try {
            System.out.println("PATH: " + f.getAbsolutePath());
            objSonido.setPath(Functions.substring(f.getAbsolutePath(), longitudRelativa, f.getAbsolutePath().length()));
            objSonido.setTitulo(nombre);
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
