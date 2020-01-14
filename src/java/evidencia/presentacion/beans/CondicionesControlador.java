/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evidencia.presentacion.beans;

import evidencia.logica.clases.Condiciones;
import evidencia.logica.funciones.FCondiciones;
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
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import recursos.Util;

/**
 *
 * @author RUBEN
 */
@ManagedBean
@ViewScoped
public class CondicionesControlador {

    private Condiciones objCondiciones;
    private ArrayList<Condiciones> lstcondiciones;
    @ManagedProperty("#{sesionUsuarioDataManager}")
    private SesionUsuarioDataManager dm;

    private String nombreCondiciones;
    private UploadedFile archivoCondiciones;
    ResourceBundle Configuracion = ResourceBundle.getBundle("recursos.rutasMedia");

    public CondicionesControlador() {
        reinit();
    }

    private void reinit() {
        this.objCondiciones = new Condiciones();
        this.lstcondiciones = new ArrayList();
        cargarIncrementoArchivos();
    }

    public Condiciones getObjCondiciones() {
        return objCondiciones;
    }

    public void setObjCondiciones(Condiciones objCondiciones) {
        this.objCondiciones = objCondiciones;
    }

    public ArrayList<Condiciones> getLstcondiciones() {
        return lstcondiciones;
    }

    public void setLstcondiciones(ArrayList<Condiciones> lstcondiciones) {
        this.lstcondiciones = lstcondiciones;
    }

    public SesionUsuarioDataManager getDm() {
        return dm;
    }

    public void setDm(SesionUsuarioDataManager dm) {
        this.dm = dm;
    }

    public String getNombreCondiciones() {
        return nombreCondiciones;
    }

    public void setNombreCondiciones(String nombreCondiciones) {
        this.nombreCondiciones = nombreCondiciones;
    }

    public UploadedFile getArchivoCondiciones() {
        return archivoCondiciones;
    }

    public void setArchivoCondiciones(UploadedFile archivoCondiciones) {
        this.archivoCondiciones = archivoCondiciones;
    }

    public ResourceBundle getConfiguracion() {
        return Configuracion;
    }

    public void setConfiguracion(ResourceBundle Configuracion) {
        this.Configuracion = Configuracion;
    }

    public void cargarIncrementoArchivos() {
        try {
            this.lstcondiciones = FCondiciones.obtenerTodosCondiciones();
        } catch (Exception e) {
            Util.addErrorMessage(e, "Error");
        }
    }

    public void insertarIncrementoArchivos() {
        try {
            UsuarioRol us = new UsuarioRol();
            us.setCodigo(this.dm.getSesionUsuarioRolActual().getCodigo());
            this.objCondiciones.setCodigo_usuario_rol(us);
            //         this.objIncrementoArchivos.setCodigo_documento(this.ArchivoSel);

            if (FCondiciones.insertar(this.objCondiciones) == true) {
                FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Insertados");
                FacesContext.getCurrentInstance().addMessage(null, mensaje);

                this.objCondiciones = new Condiciones();
            } else {
                FacesMessage mensajeError = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atenci�n", "Datos no Insertados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeError);
            }
        } catch (Exception e) {
            FacesMessage mensajeErrorIngreso = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, mensajeErrorIngreso);
        }
    }

    public void cargarCondiciones(FileUploadEvent e) {
        System.out.println("Entra al m�todo cargar archivos");
        UploadedFile file = e.getFile();
        this.archivoCondiciones = file;
        System.out.println(file.getContentType());

        System.out.println(file.getSize());
        System.out.println(file.getFileName());
        this.nombreCondiciones = file.getFileName();
        try {
            byte[] contenido = getFileContents(e.getFile().getInputstream());
            if (guardarCondiciones(file.getFileName(), contenido)) {
                Util.addSuccessMessage("Archivo Cargado con �xito!!");
            } else {
                Util.addErrorMessage("Error al cargar la Archivo");
            }
        } catch (IOException ex) {
            Logger.getLogger(CondicionesControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean guardarCondiciones(String nombre, byte[] contenido) {
        String rutaCondiciones = this.Configuracion.getString("rutaCondiciones");
        int longitudRelativa = Integer.valueOf(this.Configuracion.getString("logitudRelativa")).intValue();
        File f = new File(rutaCondiciones + nombre);
        try {
            System.out.println("PATH: " + f.getAbsolutePath());
            this.objCondiciones.setPath(Functions.substring(f.getAbsolutePath(), longitudRelativa, f.getAbsolutePath().length()));

            System.out.println("cargar objeto fos ");
            FileOutputStream fos = new FileOutputStream(f);
            System.out.println("escribir fos ");
            fos.write(contenido);
            return true;
        } catch (Exception e) {
            Util.mostrarMensaje(e.getMessage());
        }
        return false;
    }

    private byte[] getFileContents(InputStream in) {
        byte[] bytes = null;
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int read = 0;
            bytes = new byte['?'];
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
