/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evidencia.presentacion.beans;

import evidencia.logica.clases.Detalle_EvidenciaIn;
import evidencia.logica.clases.Documento;
import evidencia.logica.clases.Entorno_hw_RecojidoIn;
import evidencia.logica.clases.Entorno_sw_RecojidoIn;
import evidencia.logica.clases.Evidencia_Juridicos;
import evidencia.logica.clases.IncrementoEvidencias_Juridicos;
import evidencia.logica.clases.MetadatosIn;
import evidencia.logica.clases.Procedimineto_RecojidaIn;
import evidencia.logica.clases.TecnicasIn;
import evidencia.logica.funciones.FEvidencia_Juridicos;
import evidencia.logica.funciones.FIncrementoEvidencias_Juridicos;
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
 * @author RUBENCHO
 */
@ManagedBean
@ViewScoped
public class IncrmentoEvidencias_JuridicosControladores {

    // private IncrementoEvidencias_Juridicos objInEvJu;
    private ArrayList<IncrementoEvidencias_Juridicos> lstInEvJu;
    private ArrayList<IncrementoEvidencias_Juridicos> filtereInvidencia;
    private IncrementoEvidencias_Juridicos selIncrmento;
    private java.util.Date fechaRegistro;
    @ManagedProperty("#{sesionUsuarioDataManager}")
    private SesionUsuarioDataManager dm;

    //Evidencia Juridicos
    private ArrayList<Evidencia_Juridicos> lstEviJu;
    private ArrayList<Evidencia_Juridicos> filterevidencia;
    private Evidencia_Juridicos evidenciaSel;
    private String keywords;
    private String cedula;
    private Documento ArchivoSel;
    private String tipo;

    //>>>>>Ingreso de Evidencias
    //Entorno swr
    private Entorno_sw_RecojidoIn objentornoswrecojidoin;
    //Entorno hwr
    private Entorno_hw_RecojidoIn objentornohwrecojidoin;
    //Procedimineto Recojido
    private Procedimineto_RecojidaIn objprocedimientorecojidoin;
    //Detalles evidencia
    private Detalle_EvidenciaIn objdetalleevidenciain;
    //Metadatos 
    private MetadatosIn objmetadosin;
    //Tecnicas
    private TecnicasIn objtecnicasin;
    //Evidencia Juridicos
    //private Evidencia_Juridicos objevidenciajuridicos;
    private IncrementoEvidencias_Juridicos objInEvJu;

    //manejo de documentos
    //manejo de Documento
    private String nombreDocumentoIn;
    private UploadedFile archivoDocumentosIn;
    //manejo de Documeto Técnica
    private String nombreDocumentoTecIn;
    private UploadedFile archivoDocumentoTecnIn;
    //manejo de imagen 
    private String nombreImagenIn;
    private UploadedFile archivoImagenIn;
    //cargar configuracion del  path
    ResourceBundle Configuracion = ResourceBundle.getBundle("recursos.rutasMedia");

    public IncrmentoEvidencias_JuridicosControladores() {
        reinit();
    }

    private void reinit() {

        this.lstInEvJu = new ArrayList();
        this.fechaRegistro = new java.util.Date();
        this.evidenciaSel = new Evidencia_Juridicos();
        this.lstEviJu = new ArrayList();
        this.ArchivoSel = new Documento();

        //Ingreso de Evidencia
        objentornoswrecojidoin = new Entorno_sw_RecojidoIn();
        objentornohwrecojidoin = new Entorno_hw_RecojidoIn();
        objprocedimientorecojidoin = new Procedimineto_RecojidaIn();
        objdetalleevidenciain = new Detalle_EvidenciaIn();
        objmetadosin = new MetadatosIn();
        objtecnicasin = new TecnicasIn();
        this.objInEvJu = new IncrementoEvidencias_Juridicos();
        cargarInEvidencias();
        cargarEvidencias();
    }
    //<editor-fold defaultstate="collapsed" desc="Llenar Listas de Producto, Servicio y Ubicacion">

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Cargar Incremento de Evidencia Juridicos">
    public void cargarInEvidencias() {
        try {
            this.lstInEvJu = FIncrementoEvidencias_Juridicos.obtenerTodosIncrementoEvidencias_Juridicos();
            this.filterevidencia = lstEviJu;
        } catch (Exception e) {
            Util.addErrorMessage(e, "Error");
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Cargar Evidencias Juridicos">
    public void cargarEvidencias() {
        try {
            this.lstEviJu = FEvidencia_Juridicos.obtenerEvidencia_Juridicos();
            this.filterevidencia = lstEviJu;
        } catch (Exception e) {
            Util.addErrorMessage(e, "Error");
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Insertar Incremento Evidencias Juridicos">
    public void insertarIncrementoEvidenciaCaso() {
        try {
            UsuarioRol us = new UsuarioRol();
            us.setCodigo(dm.getSesionUsuarioRolActual().getCodigo());
            this.objdetalleevidenciain.setCodigo_usuario_rol(us);
            this.objentornoswrecojidoin.setCodigo_usuario_rol(us);
            this.objentornohwrecojidoin.setCodigo_usuario_rol(us);
            this.objprocedimientorecojidoin.setCodigo_usuario_rol(us);
            this.objInEvJu.setCodigo_usuario_rol(us);

            this.objentornoswrecojidoin.setFecharegistro_entornoswreco(new java.sql.Timestamp(fechaRegistro.getTime()));
            this.objentornohwrecojidoin.setFecharegistro_hwreco(new java.sql.Timestamp(fechaRegistro.getTime()));
            this.objprocedimientorecojidoin.setFecharegistro_procereco(new java.sql.Timestamp(fechaRegistro.getTime()));
            this.objdetalleevidenciain.setFecharegistro_detalles(new java.sql.Timestamp(fechaRegistro.getTime()));

            this.objInEvJu.setCodigo_evidencias(evidenciaSel);

            if (evidenciaSel == null) {
                FacesMessage mensajeError = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", "Selecion una evidencia a Incrementar.?}");
                FacesContext.getCurrentInstance().addMessage(null, mensajeError);
            } else {
                if (objtecnicasin.getTecnica() == null) {
                    //Ingreso de documento sin Técnica
                    objtecnicasin.setPath("Estándar");
                    objtecnicasin.setTecnica("Archivo Estándar");
                    objtecnicasin.setDetalle("Archivo Estándar");
                    if (FIncrementoEvidencias_Juridicos.insertar(objmetadosin, objtecnicasin, objdetalleevidenciain,
                            objentornoswrecojidoin, objentornohwrecojidoin, objprocedimientorecojidoin,
                            objInEvJu) > 0) {
                        FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Insertados");
                        FacesContext.getCurrentInstance().addMessage(null, mensaje);
                        DefaultRequestContext.getCurrentInstance().execute("wdlgincrementoE.hide()");
                        //DefaultRequestContext.getCurrentInstance().execute("PF('wdlgNuevoEvidencia').hide()");
                        this.objentornoswrecojidoin = new Entorno_sw_RecojidoIn();
                        this.objentornohwrecojidoin = new Entorno_hw_RecojidoIn();
                        this.objprocedimientorecojidoin = new Procedimineto_RecojidaIn();
                        this.objdetalleevidenciain = new Detalle_EvidenciaIn();
                        this.objmetadosin = new MetadatosIn();
                        this.objtecnicasin = new TecnicasIn();
                        this.objInEvJu = new IncrementoEvidencias_Juridicos();
                    } else {
                        FacesMessage mensajeError = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", "Datos no Insertados");
                        FacesContext.getCurrentInstance().addMessage(null, mensajeError);
                    }

                } else //Ingreso de documento con Técnica
                if (FIncrementoEvidencias_Juridicos.insertar(objmetadosin, objtecnicasin, objdetalleevidenciain,
                        objentornoswrecojidoin, objentornohwrecojidoin, objprocedimientorecojidoin,
                        objInEvJu) > 0) {
                    this.objentornoswrecojidoin = new Entorno_sw_RecojidoIn();
                    this.objentornohwrecojidoin = new Entorno_hw_RecojidoIn();
                    this.objprocedimientorecojidoin = new Procedimineto_RecojidaIn();
                    this.objdetalleevidenciain = new Detalle_EvidenciaIn();
                    this.objmetadosin = new MetadatosIn();
                    this.objtecnicasin = new TecnicasIn();
                    this.objInEvJu = new IncrementoEvidencias_Juridicos();
                    FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Insertados");
                    FacesContext.getCurrentInstance().addMessage(null, mensaje);
                    DefaultRequestContext.getCurrentInstance().execute("wdlgNuevoEvidencia.hide()");

                } else {
                    FacesMessage mensajeError = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", "Datos no Insertados");
                    FacesContext.getCurrentInstance().addMessage(null, mensajeError);
                }
            }

        } catch (Exception e) {
            FacesMessage mensajeErrorIngreso = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error Técnico", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, mensajeErrorIngreso);
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Cargar Documento con estandar">
    public void cargarDocumentoDoc(FileUploadEvent e) {
        System.out.println("Entra al método cargar archivos");
        UploadedFile file = e.getFile();
        this.archivoDocumentosIn = file;
        System.out.println(file.getContentType());
        objmetadosin.setTipo(file.getContentType());
        System.out.println(file.getSize());
        objmetadosin.setTamanio(file.getSize());
        System.out.println(file.getFileName());
        nombreDocumentoIn = file.getFileName();
        //byte[] contenido = file.getContents();
        byte[] contenido;
        try {
            contenido = this.getFileContents(e.getFile().getInputstream());
            if (guardarDocumento(file.getFileName(), contenido)) {
                Util.addSuccessMessage("Archivo guardada con éxito!!");
            } else {
                Util.addErrorMessage("Error al cargar la Archivo");
            }
        } catch (IOException ex) {
            Logger.getLogger(IncrmentoEvidencias_JuridicosControladores.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public boolean guardarDocumento(String nombre, byte[] contenido) {
        String rutaArchivosOriginales = Configuracion.getString("rutaDetalleEvi");
        int longitudRelativa = Integer.valueOf(Configuracion.getString("logitudRelativa"));
        File f = new File(rutaArchivosOriginales + nombre);
        try {
            System.out.println("PATH: " + f.getAbsolutePath());
            objdetalleevidenciain.setPath(Functions.substring(f.getAbsolutePath(), longitudRelativa, f.getAbsolutePath().length()));
            objmetadosin.setNombre(nombre);
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
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Cargar  tenicas">
    public void cargarDocumentoTecn(FileUploadEvent e) {
        System.out.println("Entra al método cargar archivos");
        UploadedFile file = e.getFile();
        this.archivoDocumentoTecnIn = file;
        System.out.println(file.getContentType());
        System.out.println(file.getSize());
        System.out.println(file.getFileName());
        nombreDocumentoTecIn = file.getFileName();
        byte[] contenido;
        try {
            contenido = this.getFileContents(e.getFile().getInputstream());
            if (guardarTecnicas(file.getFileName(), contenido)) {
                Util.addSuccessMessage("Archivo guardada con éxito!!");
            } else {
                Util.addErrorMessage("Error al cargar la Archivo");
            }
        } catch (IOException ex) {
            Logger.getLogger(IncrmentoEvidencias_JuridicosControladores.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public boolean guardarTecnicas(String nombre, byte[] contenido) {
        String rutaAutorizacion = Configuracion.getString("rutaTecnicas");
        int longitudRelativa = Integer.valueOf(Configuracion.getString("logitudRelativa"));
        File f = new File(rutaAutorizacion + nombre);
        try {
            System.out.println("PATH: " + f.getAbsolutePath());
            objtecnicasin.setPath(Functions.substring(f.getAbsolutePath(), longitudRelativa, f.getAbsolutePath().length()));
            //objMigracionArchivos.setTitulo(nombre);
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
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Cargar Imagen">
    public void cargarimagen(FileUploadEvent e) {
        System.out.println("Entra al método cargar archivos");
        UploadedFile file = e.getFile();
        this.archivoImagenIn = file;
        System.out.println(file.getContentType());
        System.out.println(file.getSize());
        System.out.println(file.getFileName());
        nombreImagenIn = file.getFileName();
        byte[] contenido;
        try {
            contenido = this.getFileContents(e.getFile().getInputstream());
            if (guardarImagen(file.getFileName(), contenido)) {
                Util.addSuccessMessage("Imagen guardada con éxito!!");
            } else {
                Util.addErrorMessage("Error al cargar la Archivo");
            }
        } catch (IOException ex) {
            Logger.getLogger(IncrmentoEvidencias_JuridicosControladores.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public boolean guardarImagen(String nombre, byte[] contenido) {
        String rutaImagen = Configuracion.getString("rutaImagenIn");
        int longitudRelativa = Integer.valueOf(Configuracion.getString("logitudRelativa"));
        File f = new File(rutaImagen + nombre);
        try {
            System.out.println("PATH: " + f.getAbsolutePath());
            objentornohwrecojidoin.setFoto(Functions.substring(f.getAbsolutePath(), longitudRelativa, f.getAbsolutePath().length()));
            //objMigracionArchivos.setTitulo(nombre);
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
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Cargar Archivo">
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
    //</editor-fold>  

    //<editor-fold defaultstate="collapsed" desc="Set y get">
    public ArrayList<IncrementoEvidencias_Juridicos> getFiltereInvidencia() {
        return filtereInvidencia;
    }

    public void setFiltereInvidencia(ArrayList<IncrementoEvidencias_Juridicos> filtereInvidencia) {
        this.filtereInvidencia = filtereInvidencia;
    }

    public IncrementoEvidencias_Juridicos getObjInEvJu() {
        return objInEvJu;
    }

    public void setObjInEvJu(IncrementoEvidencias_Juridicos objInEvJu) {
        this.objInEvJu = objInEvJu;
    }

    public IncrementoEvidencias_Juridicos getObjIncrementoArchivos() {
        return this.objInEvJu;
    }

    public void setObjIncrementoArchivos(IncrementoEvidencias_Juridicos objInEvJu) {
        this.objInEvJu = objInEvJu;
    }

    public ArrayList<IncrementoEvidencias_Juridicos> getLstIncrementoArchivos() {
        return this.lstInEvJu;
    }

    public void setLstIncrementoArchivos(ArrayList<IncrementoEvidencias_Juridicos> lstInEvJu) {
        this.lstInEvJu = lstInEvJu;
    }

    public IncrementoEvidencias_Juridicos getSelIncrmento() {
        return this.selIncrmento;
    }

    public void setSelIncrmento(IncrementoEvidencias_Juridicos selIncrmento) {
        this.selIncrmento = selIncrmento;
    }

    public java.util.Date getFechaRegistro() {
        return this.fechaRegistro;
    }

    public void setFechaRegistro(java.util.Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public SesionUsuarioDataManager getDm() {
        return this.dm;
    }

    public void setDm(SesionUsuarioDataManager dm) {
        this.dm = dm;
    }

    public ResourceBundle getConfiguracion() {
        return this.Configuracion;
    }

    public void setConfiguracion(ResourceBundle Configuracion) {
        this.Configuracion = Configuracion;
    }

    public ArrayList<Evidencia_Juridicos> getFilterevidencia() {
        return filterevidencia;
    }

    public void setFilterevidencia(ArrayList<Evidencia_Juridicos> filterevidencia) {
        this.filterevidencia = filterevidencia;
    }

    public Evidencia_Juridicos getEvidenciaSel() {
        return evidenciaSel;
    }

    public void setEvidenciaSel(Evidencia_Juridicos evidenciaSel) {
        this.evidenciaSel = evidenciaSel;
    }

    public String getKeywords() {
        return this.keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public ArrayList<IncrementoEvidencias_Juridicos> getLstInEvJu() {
        return lstInEvJu;
    }

    public void setLstInEvJu(ArrayList<IncrementoEvidencias_Juridicos> lstInEvJu) {
        this.lstInEvJu = lstInEvJu;
    }

    public ArrayList<Evidencia_Juridicos> getLstEviJu() {
        return lstEviJu;
    }

    public void setLstEviJu(ArrayList<Evidencia_Juridicos> lstEviJu) {
        this.lstEviJu = lstEviJu;
    }

    public String getCedula() {
        return this.cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Documento getArchivoSel() {
        return this.ArchivoSel;
    }

    public void setArchivoSel(Documento ArchivoSel) {
        this.ArchivoSel = ArchivoSel;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Entorno_sw_RecojidoIn getObjentornoswrecojidoin() {
        return objentornoswrecojidoin;
    }

    public void setObjentornoswrecojidoin(Entorno_sw_RecojidoIn objentornoswrecojidoin) {
        this.objentornoswrecojidoin = objentornoswrecojidoin;
    }

    public Entorno_hw_RecojidoIn getObjentornohwrecojidoin() {
        return objentornohwrecojidoin;
    }

    public void setObjentornohwrecojidoin(Entorno_hw_RecojidoIn objentornohwrecojidoin) {
        this.objentornohwrecojidoin = objentornohwrecojidoin;
    }

    public Procedimineto_RecojidaIn getObjprocedimientorecojidoin() {
        return objprocedimientorecojidoin;
    }

    public void setObjprocedimientorecojidoin(Procedimineto_RecojidaIn objprocedimientorecojidoin) {
        this.objprocedimientorecojidoin = objprocedimientorecojidoin;
    }

    public Detalle_EvidenciaIn getObjdetalleevidenciain() {
        return objdetalleevidenciain;
    }

    public void setObjdetalleevidenciain(Detalle_EvidenciaIn objdetalleevidenciain) {
        this.objdetalleevidenciain = objdetalleevidenciain;
    }

    public MetadatosIn getObjmetadosin() {
        return objmetadosin;
    }

    public void setObjmetadosin(MetadatosIn objmetadosin) {
        this.objmetadosin = objmetadosin;
    }

    public TecnicasIn getObjtecnicasin() {
        return objtecnicasin;
    }

    public void setObjtecnicasin(TecnicasIn objtecnicasin) {
        this.objtecnicasin = objtecnicasin;
    }

    public String getNombreDocumentoIn() {
        return nombreDocumentoIn;
    }

    public void setNombreDocumentoIn(String nombreDocumentoIn) {
        this.nombreDocumentoIn = nombreDocumentoIn;
    }

    public UploadedFile getArchivoDocumentosIn() {
        return archivoDocumentosIn;
    }

    public void setArchivoDocumentosIn(UploadedFile archivoDocumentosIn) {
        this.archivoDocumentosIn = archivoDocumentosIn;
    }

    public String getNombreDocumentoTecIn() {
        return nombreDocumentoTecIn;
    }

    public void setNombreDocumentoTecIn(String nombreDocumentoTecIn) {
        this.nombreDocumentoTecIn = nombreDocumentoTecIn;
    }

    public UploadedFile getArchivoDocumentoTecnIn() {
        return archivoDocumentoTecnIn;
    }

    public void setArchivoDocumentoTecnIn(UploadedFile archivoDocumentoTecnIn) {
        this.archivoDocumentoTecnIn = archivoDocumentoTecnIn;
    }

    public String getNombreImagenIn() {
        return nombreImagenIn;
    }

    public void setNombreImagenIn(String nombreImagenIn) {
        this.nombreImagenIn = nombreImagenIn;
    }

    public UploadedFile getArchivoImagenIn() {
        return archivoImagenIn;
    }

    public void setArchivoImagenIn(UploadedFile archivoImagenIn) {
        this.archivoImagenIn = archivoImagenIn;
    }

    //</editor-fold>
}
