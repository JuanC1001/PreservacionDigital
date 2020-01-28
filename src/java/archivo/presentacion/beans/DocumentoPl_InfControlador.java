/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivo.presentacion.beans;

import archivo.logica.clases.DocumentoPlInf;
import archivo.logica.funciones.FDocumentoPl_Inf;
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
public class DocumentoPl_InfControlador {

    private DocumentoPlInf objDocumentoPi;
    private ArrayList<DocumentoPlInf> lstDocumentoPi;
    private DocumentoPlInf documentoPiSel;
    @ManagedProperty(value = "#{sesionUsuarioDataManager}")
    private SesionUsuarioDataManager dm;

    //manejo de Dumentos
    private String nombreDocumentoPi;
    private UploadedFile archivoDocumentoPi;
    //cargar configuracion del  path
    java.util.ResourceBundle Configuracion = java.util.ResourceBundle.getBundle("recursos.rutasMedia");

    public DocumentoPl_InfControlador() {
        this.documentoPiSel = new DocumentoPlInf();
        this.objDocumentoPi = new DocumentoPlInf();
        this.cargarDocumentoPi();
    }

    //<editor-fold defaultstate="collapsed" desc="Set y Get">
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Cargar">
    public void cargarDocumentoPi() {
        try {
            lstDocumentoPi = FDocumentoPl_Inf.obtenerTodos();
        } catch (Exception e) {
            Util.addErrorMessage(e, "Error");
        }
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Insertar">
    public void insertarDocumentoPi() {
        try {
            UsuarioRol us = new UsuarioRol();
            us.setCodigo(dm.getSesionUsuarioRolActual().getCodigo());
            objDocumentoPi.setCodigo_usuario_rol(us);
            if (FDocumentoPl_Inf.insertar(objDocumentoPi) == true) {
                FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Insertados");
                FacesContext.getCurrentInstance().addMessage(null, mensaje);
                DefaultRequestContext.getCurrentInstance().execute("dlgInsertarDocumentoPi.hide()");
                this.cargarDocumentoPi();
                this.objDocumentoPi = new DocumentoPlInf();
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
    public void actualizarDocumentoPi() {
        try {
            UsuarioRol us = new UsuarioRol();
            us.setCodigo(dm.getSesionUsuarioRolActual().getCodigo());
            objDocumentoPi.setCodigo_usuario_rol(us);
            if (FDocumentoPl_Inf.actualizar(documentoPiSel)) {
                FacesMessage mensajeActualizacion = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Actualizados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeActualizacion);
                DefaultRequestContext.getCurrentInstance().execute("dlgEditarDocumentoPi.hide()");
                this.cargarDocumentoPi();
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
    public void eliminarDocumentoPi() {
        try {
            if (FDocumentoPl_Inf.eliminar(documentoPiSel)) {
                FacesMessage mensajeEliminar = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Eliminados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeEliminar);
                DefaultRequestContext.getCurrentInstance().execute("dlgEliminarDocumentoPi.hide()");
                this.cargarDocumentoPi();
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
        this.archivoDocumentoPi = file;
        System.out.println(file.getContentType());
        objDocumentoPi.setTipo(file.getContentType());
        System.out.println(file.getSize());
        System.out.println(file.getFileName());
        nombreDocumentoPi = file.getFileName();
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
        String rutaDocumentoPi = Configuracion.getString("rutaDocumentoPi");
        int longitudRelativa = Integer.valueOf(Configuracion.getString("logitudRelativa"));
        File f = new File(rutaDocumentoPi + nombre);
        try {
            System.out.println("PATH: " + f.getAbsolutePath());
            objDocumentoPi.setPath(Functions.substring(f.getAbsolutePath(), longitudRelativa, f.getAbsolutePath().length()));
            objDocumentoPi.setTitulo(nombre);
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
    public DocumentoPlInf getObjDocumentoPi() {
        return objDocumentoPi;
    }

    public void setObjDocumentoPi(DocumentoPlInf objDocumentoPi) {
        this.objDocumentoPi = objDocumentoPi;
    }

    public ArrayList<DocumentoPlInf> getLstDocumentoPi() {
        return lstDocumentoPi;
    }

    public void setLstDocumentoPi(ArrayList<DocumentoPlInf> lstDocumentoPi) {
        this.lstDocumentoPi = lstDocumentoPi;
    }

    public DocumentoPlInf getDocumentoPiSel() {
        return documentoPiSel;
    }

    public void setDocumentoPiSel(DocumentoPlInf documentoPiSel) {
        this.documentoPiSel = documentoPiSel;
    }

    public SesionUsuarioDataManager getDm() {
        return dm;
    }

    public void setDm(SesionUsuarioDataManager dm) {
        this.dm = dm;
    }

    public String getNombreDocumentoPi() {
        return nombreDocumentoPi;
    }

    public void setNombreDocumentoPi(String nombreDocumentoPi) {
        this.nombreDocumentoPi = nombreDocumentoPi;
    }

    public UploadedFile getArchivoDocumentoPi() {
        return archivoDocumentoPi;
    }

    public void setArchivoDocumentoPi(UploadedFile archivoDocumentoPi) {
        this.archivoDocumentoPi = archivoDocumentoPi;
    }

    public ResourceBundle getConfiguracion() {
        return Configuracion;
    }

    public void setConfiguracion(ResourceBundle Configuracion) {
        this.Configuracion = Configuracion;
    }
    //</editor-fold>

}
