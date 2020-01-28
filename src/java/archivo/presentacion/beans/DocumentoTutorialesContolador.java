/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivo.presentacion.beans;

import archivo.logica.clases.DocumentoTutoriales;
import archivo.logica.funciones.FDocumento_Tutoriales;
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
import master.logica.clases.UsuarioRol;
import master.presentacion.beans.SesionUsuarioDataManager;
import org.apache.taglibs.standard.functions.Functions;
import org.primefaces.context.DefaultRequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import recursos.Util;

/**
 *
 * @author ruben
 */
@ManagedBean
@ViewScoped
public class DocumentoTutorialesContolador {

    private DocumentoTutoriales objDocumentoTU;
    private ArrayList<DocumentoTutoriales> lstDocumentoTu;
    private DocumentoTutoriales documentoTuSel;
    @ManagedProperty(value = "#{sesionUsuarioDataManager}")
    private SesionUsuarioDataManager dm;

    //manejo de Dumentos
    private String nombreDocumentoTu;
    private UploadedFile archivoDocumentoTu;
    //cargar configuracion del  path
    java.util.ResourceBundle Configuracion = java.util.ResourceBundle.getBundle("recursos.rutasMedia");

    public DocumentoTutorialesContolador() {
        this.documentoTuSel = new DocumentoTutoriales();
        this.objDocumentoTU = new DocumentoTutoriales();
        this.cargarDocumentoTu();
    }

    //<editor-fold defaultstate="collapsed" desc="Set y Get">
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Cargar">
    public void cargarDocumentoTu() {
        try {
            lstDocumentoTu = FDocumento_Tutoriales.obtenerTodos();
        } catch (Exception e) {
            Util.addErrorMessage(e, "Error");
        }
    }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Insertar">
    public void insertarDocumentoTu() {
        try {
            UsuarioRol us = new UsuarioRol();
            us.setCodigo(dm.getSesionUsuarioRolActual().getCodigo());
            objDocumentoTU.setCodigo_usuario_rol(us);
            if (FDocumento_Tutoriales.insertar(objDocumentoTU) == true) {
                FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Insertados");
                FacesContext.getCurrentInstance().addMessage(null, mensaje);
                DefaultRequestContext.getCurrentInstance().execute("dlgInsertarDocumentoTu.hide()");
                this.cargarDocumentoTu();
                this.objDocumentoTU = new DocumentoTutoriales();
            } else {
                FacesMessage mensajeError = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", "Datos no Insertados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeError);
            }
        } catch (Exception e) {
            FacesMessage mensajeErrorIngreso = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, mensajeErrorIngreso);
        }
    }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Actualizar">
    public void actualizarDocumentoTu() {
        try {
            UsuarioRol us = new UsuarioRol();
            us.setCodigo(dm.getSesionUsuarioRolActual().getCodigo());
            objDocumentoTU.setCodigo_usuario_rol(us);
            if (FDocumento_Tutoriales.actualizar(documentoTuSel)) {
                FacesMessage mensajeActualizacion = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Actualizados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeActualizacion);
                DefaultRequestContext.getCurrentInstance().execute("dlgEditarDocumentoTu.hide()");
                this.cargarDocumentoTu();
            } else {
                FacesMessage mensajeErrorActualizacion = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", "Datos no Actualizados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeErrorActualizacion);
            }
        } catch (Exception e) {
            FacesMessage mensajeErrorA = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, mensajeErrorA);
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Eliminar">
    public void eliminarDocumentoTu() {
        try {
            if (FDocumento_Tutoriales.eliminar(documentoTuSel)) {
                FacesMessage mensajeEliminar = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Eliminados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeEliminar);
                DefaultRequestContext.getCurrentInstance().execute("dlgEliminarDocumentoTu.hide()");
                this.cargarDocumentoTu();
            } else {
                FacesMessage mensajeErrorEliminar = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", "Datos no  Eliminados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeErrorEliminar);
            }
        } catch (Exception e) {
            FacesMessage mensajeErrorE = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, mensajeErrorE);
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Cargar Documentos">
    public void cargarArchivoDocumento(FileUploadEvent e) {
        System.out.println("Entra al método cargar documento");
        UploadedFile file = e.getFile();
        this.archivoDocumentoTu = file;
        System.out.println(file.getContentType());
        objDocumentoTU.setTipo(file.getContentType());
        System.out.println(file.getSize());
        System.out.println(file.getFileName());
        nombreDocumentoTu = file.getFileName();
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
            Logger.getLogger(DocumentoViabilidadControlador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public boolean guardarArchivo(String nombre, byte[] contenido) {
        String rutaDocumentoTu = Configuracion.getString("rutaDocumentoTu");
        int longitudRelativa = Integer.valueOf(Configuracion.getString("logitudRelativa"));
        File f = new File(rutaDocumentoTu + nombre);
        try {
            System.out.println("PATH: " + f.getAbsolutePath());
            objDocumentoTU.setPath(Functions.substring(f.getAbsolutePath(), longitudRelativa, f.getAbsolutePath().length()));
            objDocumentoTU.setTitulo(nombre);
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
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Set y Get">
    public DocumentoTutoriales getObjDocumentoTU() {
        return objDocumentoTU;
    }

    public void setObjDocumentoTU(DocumentoTutoriales objDocumentoTU) {
        this.objDocumentoTU = objDocumentoTU;
    }

    public ArrayList<DocumentoTutoriales> getLstDocumentoTu() {
        return lstDocumentoTu;
    }

    public void setLstDocumentoTu(ArrayList<DocumentoTutoriales> lstDocumentoTu) {
        this.lstDocumentoTu = lstDocumentoTu;
    }

    public DocumentoTutoriales getDocumentoTuSel() {
        return documentoTuSel;
    }

    public void setDocumentoTuSel(DocumentoTutoriales documentoTuSel) {
        this.documentoTuSel = documentoTuSel;
    }

    public SesionUsuarioDataManager getDm() {
        return dm;
    }

    public void setDm(SesionUsuarioDataManager dm) {
        this.dm = dm;
    }

    public String getNombreDocumentoTu() {
        return nombreDocumentoTu;
    }

    public void setNombreDocumentoTu(String nombreDocumentoTu) {
        this.nombreDocumentoTu = nombreDocumentoTu;
    }

    public UploadedFile getArchivoDocumentoTu() {
        return archivoDocumentoTu;
    }

    public void setArchivoDocumentoTu(UploadedFile archivoDocumentoTu) {
        this.archivoDocumentoTu = archivoDocumentoTu;
    }

    public ResourceBundle getConfiguracion() {
        return Configuracion;
    }

    public void setConfiguracion(ResourceBundle Configuracion) {
        this.Configuracion = Configuracion;
    }

    //</editor-fold> 
}
