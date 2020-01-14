/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package digitales.presentacion.beans;

import digitales.logica.clases.Documento;
import digitales.logica.funciones.FDocumento;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
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
public class DocumentoControlador implements Serializable{
     private Documento objDocumento;
    private ArrayList<Documento> lstDocumento;
    private Documento documentoSel;
    @ManagedProperty(value = "#{sesionUsuarioDataManager}")
    private SesionUsuarioDataManager dm;
    private int estadoSel;
    
    //manejo de imagenes
    private String nombreDocumento;
    private UploadedFile archivoDocumento;
    //cargar configuracion del  path
    java.util.ResourceBundle Configuracion = java.util.ResourceBundle.getBundle("recursos.rutasMedia");

    public DocumentoControlador() {
        
        this.documentoSel = new Documento();
        this.objDocumento = new Documento();
        this.cargarDocumento();
        this.estadoSel = -1;
    }

    public int getEstadoSel() {
        return estadoSel;
    }

    public String getNombreDocumento() {
        return nombreDocumento;
    }

    public void setNombreDocumento(String nombreDocumento) {
        this.nombreDocumento = nombreDocumento;
    }

    public UploadedFile getArchivoDocumento() {
        return archivoDocumento;
    }

    public void setArchivoDocumento(UploadedFile archivoDocumento) {
        this.archivoDocumento = archivoDocumento;
    }

    public ResourceBundle getConfiguracion() {
        return Configuracion;
    }

    public void setConfiguracion(ResourceBundle Configuracion) {
        this.Configuracion = Configuracion;
    }
    
    

    public void setEstadoSel(int estadoSel) {
        this.estadoSel = estadoSel;
    }

    public Documento getObjDocumento() {
        return objDocumento;
    }

    public void setObjDocumento(Documento objDocumento) {
        this.objDocumento = objDocumento;
    }

    public ArrayList<Documento> getLstDocumento() {
        return lstDocumento;
    }

    public void setLstDocumento(ArrayList<Documento> lstDocumento) {
        this.lstDocumento = lstDocumento;
    }

    public Documento getDocumentoSel() {
        return documentoSel;
    }

    public void setDocumentoSel(Documento documentoSel) {
        this.documentoSel = documentoSel;
    }

    public SesionUsuarioDataManager getDm() {
        return dm;
    }

    public void setDm(SesionUsuarioDataManager dm) {
        this.dm = dm;
    }

    public void cargarDocumento() {
        try {
            lstDocumento = FDocumento.obtenerTodos();
        } catch (Exception e) {
            Util.addErrorMessage(e, "Error");
        }


    }

    public void insertarDocumento() {
        try {
           objDocumento.setEstado(estadoSel);
           objDocumento.setFecha_registro(Tools.obtieneFechaActualenMiliseg());
            objDocumento.setCodigo_persona(dm.getSesionPersona().getCodigo_titular());
            if (FDocumento.insertar(objDocumento) == true) {
                FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Insertados");
                FacesContext.getCurrentInstance().addMessage(null, mensaje);
                DefaultRequestContext.getCurrentInstance().execute("dlgInsertarDocumento.hide()");
                this.cargarDocumento();
                this.objDocumento = new Documento();
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

    public void actualizarDocumento() {
        try {
            objDocumento.setCodigo_persona(dm.getSesionPersona().getCodigo_titular());
            if (FDocumento.actualizar(documentoSel)) {
                FacesMessage mensajeActualizacion = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Actualizados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeActualizacion);
                DefaultRequestContext.getCurrentInstance().execute("dlgEditarDocumento.hide()");
            } else {
                FacesMessage mensajeErrorActualizacion = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", "Datos no Actualizados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeErrorActualizacion);
            }
        } catch (Exception e) {
            FacesMessage mensajeErrorA = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, mensajeErrorA);
        }
    }
    public void eliminarDocumento(){
        try {
            if (FDocumento.eliminar(documentoSel)) {
                FacesMessage mensajeEliminar = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Eliminados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeEliminar);
                DefaultRequestContext.getCurrentInstance().execute("dlgEliminarDocumento.hide()");
                this.cargarDocumento();
            } else {
                FacesMessage mensajeErrorEliminar = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", "Datos no  Eliminados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeErrorEliminar);
            }
        } catch (Exception e) {
            FacesMessage mensajeErrorE = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, mensajeErrorE);
        }
    }
    
    public void cargarArchivoDocumento(FileUploadEvent e) {
        System.out.println("Entra al método cargar documento");
        UploadedFile file = e.getFile();
        this.archivoDocumento = file;
        System.out.println(file.getContentType());
        objDocumento.setTipo(file.getContentType());
        System.out.println(file.getSize());
        System.out.println(file.getFileName());
        nombreDocumento = file.getFileName();
        //byte[] contenido = file.getContents();
        byte[] contenido;
        try {
            contenido = this.getFileContents(e.getFile().getInputstream());
            if (guardarArchivo(file.getFileName(), contenido)) {
            Util.addSuccessMessage("Documento guardado con éxito!!");
        } else {
            Util.addErrorMessage("Error al cargar el Documento");
        }
        } catch (IOException ex) {
            Logger.getLogger(ImagenControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public boolean guardarArchivo(String nombre, byte[] contenido) {
        String rutaImagenes = Configuracion.getString("rutaDocumentos");
        int longitudRelativa = Integer.valueOf(Configuracion.getString("logitudRelativa"));
        File f = new File(rutaImagenes+nombre);
        try {
            System.out.println("PATH: " + f.getAbsolutePath());
            objDocumento.setPath(Functions.substring(f.getAbsolutePath(), longitudRelativa, f.getAbsolutePath().length()));
            objDocumento.setTitulo(nombre);
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
