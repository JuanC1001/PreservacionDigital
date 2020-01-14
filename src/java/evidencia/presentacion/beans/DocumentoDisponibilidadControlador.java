/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evidencia.presentacion.beans;

import evidencia.logica.clases.DocumentoDisponibilidad;
import evidencia.logica.funciones.FDocumento_Disponibilidad;
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
public class DocumentoDisponibilidadControlador {

    private DocumentoDisponibilidad objDocumentoDi;
    private ArrayList<DocumentoDisponibilidad> lstDocumentoDi;
    private DocumentoDisponibilidad documentoDiSel;
    @ManagedProperty(value = "#{sesionUsuarioDataManager}")
    private SesionUsuarioDataManager dm;

    //manejo de Dumentos
    private String nombreDocumentoDi;
    private UploadedFile archivoDocumentoDi;
    //cargar configuracion del  path
    java.util.ResourceBundle Configuracion = java.util.ResourceBundle.getBundle("recursos.rutasMedia");

    public DocumentoDisponibilidadControlador() {
        this.documentoDiSel = new DocumentoDisponibilidad();
        this.objDocumentoDi = new DocumentoDisponibilidad();
        this.cargarDocumentoDi();
    }

    //<editor-fold defaultstate="collapsed" desc="Set y Get">
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Cargar">
    public void cargarDocumentoDi() {
        try {
            lstDocumentoDi = FDocumento_Disponibilidad.obtenerTodos();
        } catch (Exception e) {
            Util.addErrorMessage(e, "Error");
        }
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Insertar">
    public void insertarDocumentoDi() {
        try {
            UsuarioRol us = new UsuarioRol();
            us.setCodigo(dm.getSesionUsuarioRolActual().getCodigo());
            objDocumentoDi.setCodigo_usuario_rol(us);
            if (FDocumento_Disponibilidad.insertar(objDocumentoDi) == true) {
                FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Insertados");
                FacesContext.getCurrentInstance().addMessage(null, mensaje);
                DefaultRequestContext.getCurrentInstance().execute("dlgInsertarDocumentoDi.hide()");
                this.cargarDocumentoDi();
                this.objDocumentoDi = new DocumentoDisponibilidad();
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
    public void actualizarDocumentoDi() {
        try {
            UsuarioRol us = new UsuarioRol();
            us.setCodigo(dm.getSesionUsuarioRolActual().getCodigo());
            objDocumentoDi.setCodigo_usuario_rol(us);
            if (FDocumento_Disponibilidad.actualizar(documentoDiSel)) {
                FacesMessage mensajeActualizacion = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Actualizados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeActualizacion);
                DefaultRequestContext.getCurrentInstance().execute("dlgEditarDocumentoDi.hide()");
                this.cargarDocumentoDi();
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
    public void eliminarDocumentoDi() {
        try {
            if (FDocumento_Disponibilidad.eliminar(documentoDiSel)) {
                FacesMessage mensajeEliminar = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Eliminados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeEliminar);
                DefaultRequestContext.getCurrentInstance().execute("dlgEliminarDocumentoDi.hide()");
                this.cargarDocumentoDi();
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
        this.archivoDocumentoDi = file;
        System.out.println(file.getContentType());
        objDocumentoDi.setTipo(file.getContentType());
        System.out.println(file.getSize());
        System.out.println(file.getFileName());
        nombreDocumentoDi = file.getFileName();
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
        String rutaDocumentoDi = Configuracion.getString("rutaDocumentoDi");
        int longitudRelativa = Integer.valueOf(Configuracion.getString("logitudRelativa"));
        File f = new File(rutaDocumentoDi + nombre);
        try {
            System.out.println("PATH: " + f.getAbsolutePath());
            objDocumentoDi.setPath(Functions.substring(f.getAbsolutePath(), longitudRelativa, f.getAbsolutePath().length()));
            objDocumentoDi.setTitulo(nombre);
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
    public DocumentoDisponibilidad getObjDocumentoDi() {
        return objDocumentoDi;
    }

    public void setObjDocumentoDi(DocumentoDisponibilidad objDocumentoDi) {
        this.objDocumentoDi = objDocumentoDi;
    }

    public ArrayList<DocumentoDisponibilidad> getLstDocumentoDi() {
        return lstDocumentoDi;
    }

    public void setLstDocumentoDi(ArrayList<DocumentoDisponibilidad> lstDocumentoDi) {
        this.lstDocumentoDi = lstDocumentoDi;
    }

    public DocumentoDisponibilidad getDocumentoDiSel() {
        return documentoDiSel;
    }

    public void setDocumentoDiSel(DocumentoDisponibilidad documentoDiSel) {
        this.documentoDiSel = documentoDiSel;
    }

    public SesionUsuarioDataManager getDm() {
        return dm;
    }

    public void setDm(SesionUsuarioDataManager dm) {
        this.dm = dm;
    }

    public String getNombreDocumentoDi() {
        return nombreDocumentoDi;
    }

    public void setNombreDocumentoDi(String nombreDocumentoDi) {
        this.nombreDocumentoDi = nombreDocumentoDi;
    }

    public UploadedFile getArchivoDocumentoDi() {
        return archivoDocumentoDi;
    }

    public void setArchivoDocumentoDi(UploadedFile archivoDocumentoDi) {
        this.archivoDocumentoDi = archivoDocumentoDi;
    }

    public ResourceBundle getConfiguracion() {
        return Configuracion;
    }

    public void setConfiguracion(ResourceBundle Configuracion) {
        this.Configuracion = Configuracion;
    }
     //</editor-fold>

}
