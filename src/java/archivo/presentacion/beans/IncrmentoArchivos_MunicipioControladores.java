/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivo.presentacion.beans;

import archivo.logica.clases.Detalle_ArchivoIn;
import archivo.logica.clases.Documento;
import archivo.logica.clases.Entorno_hw_RecojidoIn;
import archivo.logica.clases.Entorno_sw_RecojidoIn;
import archivo.logica.clases.Archivo_Municipio;
import archivo.logica.clases.IncrementoArchivos_Municipio;
import archivo.logica.clases.MetadatosIn;
import archivo.logica.clases.Procedimineto_RecojidaIn;
import archivo.logica.clases.TecnicasIn;
import archivo.logica.funciones.FArchivo_Municipio;
import archivo.logica.funciones.FIncrementoArchivos_Municipio;
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
public class IncrmentoArchivos_MunicipioControladores {

    // private IncrementoArchivos_Municipio objInEvJu;
    private ArrayList<IncrementoArchivos_Municipio> lstInEvJu;
    private ArrayList<IncrementoArchivos_Municipio> filtereInvidencia;
    private IncrementoArchivos_Municipio selIncrmento;
    private java.util.Date fechaRegistro;
    @ManagedProperty("#{sesionUsuarioDataManager}")
    private SesionUsuarioDataManager dm;

    //Archivo Municipio
    private ArrayList<Archivo_Municipio> lstEviJu;
    private ArrayList<Archivo_Municipio> filterarchivo;
    private Archivo_Municipio archivoSel;
    private String keywords;
    private String cedula;
    private Documento ArchivoSel;
    private String tipo;

    //>>>>>Ingreso de Archivos
    //Entorno swr
    private Entorno_sw_RecojidoIn objentornoswrecojidoin;
    //Entorno hwr
    private Entorno_hw_RecojidoIn objentornohwrecojidoin;
    //Procedimineto Recojido
    private Procedimineto_RecojidaIn objprocedimientorecojidoin;
    //Detalles archivo
    private Detalle_ArchivoIn objdetallearchivoin;
    //Metadatos 
    private MetadatosIn objmetadosin;
    //Tecnicas
    private TecnicasIn objtecnicasin;
    //Archivo Municipio
    //private Archivo_Municipio objarchivomunicipio;
    private IncrementoArchivos_Municipio objInEvJu;

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

    public IncrmentoArchivos_MunicipioControladores() {
        reinit();
    }

    private void reinit() {

        this.lstInEvJu = new ArrayList();
        this.fechaRegistro = new java.util.Date();
        this.archivoSel = new Archivo_Municipio();
        this.lstEviJu = new ArrayList();
        this.ArchivoSel = new Documento();

        //Ingreso de Archivo
        objentornoswrecojidoin = new Entorno_sw_RecojidoIn();
        objentornohwrecojidoin = new Entorno_hw_RecojidoIn();
        objprocedimientorecojidoin = new Procedimineto_RecojidaIn();
        objdetallearchivoin = new Detalle_ArchivoIn();
        objmetadosin = new MetadatosIn();
        objtecnicasin = new TecnicasIn();
        this.objInEvJu = new IncrementoArchivos_Municipio();
        cargarInArchivos();
        cargarArchivos();
    }
    //<editor-fold defaultstate="collapsed" desc="Llenar Listas de Producto, Servicio y Ubicacion">

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Cargar Incremento de Archivo Municipio">
    public void cargarInArchivos() {
        try {
            this.lstInEvJu = FIncrementoArchivos_Municipio.obtenerTodosIncrementoArchivos_Municipio();
            this.filterarchivo = lstEviJu;
        } catch (Exception e) {
            Util.addErrorMessage(e, "Error");
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Cargar Archivos Municipio">
    public void cargarArchivos() {
        try {
            this.lstEviJu = FArchivo_Municipio.obtenerArchivo_Municipio();
            this.filterarchivo = lstEviJu;
        } catch (Exception e) {
            Util.addErrorMessage(e, "Error");
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Insertar Incremento Archivos Municipio">
    public void insertarIncrementoArchivoDepartamento() {
        try {
            UsuarioRol us = new UsuarioRol();
            us.setCodigo(dm.getSesionUsuarioRolActual().getCodigo());
            this.objdetallearchivoin.setCodigo_usuario_rol(us);
            this.objentornoswrecojidoin.setCodigo_usuario_rol(us);
            this.objentornohwrecojidoin.setCodigo_usuario_rol(us);
            this.objprocedimientorecojidoin.setCodigo_usuario_rol(us);
            this.objInEvJu.setCodigo_usuario_rol(us);

            this.objentornoswrecojidoin.setFecharegistro_entornoswreco(new java.sql.Timestamp(fechaRegistro.getTime()));
            this.objentornohwrecojidoin.setFecharegistro_hwreco(new java.sql.Timestamp(fechaRegistro.getTime()));
            this.objprocedimientorecojidoin.setFecharegistro_procereco(new java.sql.Timestamp(fechaRegistro.getTime()));
            this.objdetallearchivoin.setFecharegistro_detalles(new java.sql.Timestamp(fechaRegistro.getTime()));

            this.objInEvJu.setCodigo_archivos(archivoSel);

            if (archivoSel == null) {
                FacesMessage mensajeError = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", "Selecion una archivo a Incrementar.?}");
                FacesContext.getCurrentInstance().addMessage(null, mensajeError);
            } else {
                if (objtecnicasin.getTecnica() == null) {
                    //Ingreso de documento sin Técnica
                    objtecnicasin.setPath("Estándar");
                    objtecnicasin.setTecnica("Archivo Estándar");
                    objtecnicasin.setDetalle("Archivo Estándar");
                    if (FIncrementoArchivos_Municipio.insertar(objmetadosin, objtecnicasin, objdetallearchivoin,
                            objentornoswrecojidoin, objentornohwrecojidoin, objprocedimientorecojidoin,
                            objInEvJu) > 0) {
                        FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Insertados");
                        FacesContext.getCurrentInstance().addMessage(null, mensaje);
                        DefaultRequestContext.getCurrentInstance().execute("wdlgincrementoE.hide()");
                        //DefaultRequestContext.getCurrentInstance().execute("PF('wdlgNuevoArchivo').hide()");
                        this.objentornoswrecojidoin = new Entorno_sw_RecojidoIn();
                        this.objentornohwrecojidoin = new Entorno_hw_RecojidoIn();
                        this.objprocedimientorecojidoin = new Procedimineto_RecojidaIn();
                        this.objdetallearchivoin = new Detalle_ArchivoIn();
                        this.objmetadosin = new MetadatosIn();
                        this.objtecnicasin = new TecnicasIn();
                        this.objInEvJu = new IncrementoArchivos_Municipio();
                    } else {
                        FacesMessage mensajeError = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", "Datos no Insertados");
                        FacesContext.getCurrentInstance().addMessage(null, mensajeError);
                    }

                } else //Ingreso de documento con Técnica
                if (FIncrementoArchivos_Municipio.insertar(objmetadosin, objtecnicasin, objdetallearchivoin,
                        objentornoswrecojidoin, objentornohwrecojidoin, objprocedimientorecojidoin,
                        objInEvJu) > 0) {
                    this.objentornoswrecojidoin = new Entorno_sw_RecojidoIn();
                    this.objentornohwrecojidoin = new Entorno_hw_RecojidoIn();
                    this.objprocedimientorecojidoin = new Procedimineto_RecojidaIn();
                    this.objdetallearchivoin = new Detalle_ArchivoIn();
                    this.objmetadosin = new MetadatosIn();
                    this.objtecnicasin = new TecnicasIn();
                    this.objInEvJu = new IncrementoArchivos_Municipio();
                    FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Insertados");
                    FacesContext.getCurrentInstance().addMessage(null, mensaje);
                    DefaultRequestContext.getCurrentInstance().execute("wdlgNuevoArchivo.hide()");

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
            Logger.getLogger(IncrmentoArchivos_MunicipioControladores.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public boolean guardarDocumento(String nombre, byte[] contenido) {
        String rutaArchivosOriginales = Configuracion.getString("rutaDetalleEvi");
        int longitudRelativa = Integer.valueOf(Configuracion.getString("logitudRelativa"));
        File f = new File(rutaArchivosOriginales + nombre);
        try {
            System.out.println("PATH: " + f.getAbsolutePath());
            objdetallearchivoin.setPath(Functions.substring(f.getAbsolutePath(), longitudRelativa, f.getAbsolutePath().length()));
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
            Logger.getLogger(IncrmentoArchivos_MunicipioControladores.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(IncrmentoArchivos_MunicipioControladores.class.getName()).log(Level.SEVERE, null, ex);
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
    public ArrayList<IncrementoArchivos_Municipio> getFiltereInvidencia() {
        return filtereInvidencia;
    }

    public void setFiltereInvidencia(ArrayList<IncrementoArchivos_Municipio> filtereInvidencia) {
        this.filtereInvidencia = filtereInvidencia;
    }

    public IncrementoArchivos_Municipio getObjInEvJu() {
        return objInEvJu;
    }

    public void setObjInEvJu(IncrementoArchivos_Municipio objInEvJu) {
        this.objInEvJu = objInEvJu;
    }

    public IncrementoArchivos_Municipio getObjIncrementoArchivos() {
        return this.objInEvJu;
    }

    public void setObjIncrementoArchivos(IncrementoArchivos_Municipio objInEvJu) {
        this.objInEvJu = objInEvJu;
    }

    public ArrayList<IncrementoArchivos_Municipio> getLstIncrementoArchivos() {
        return this.lstInEvJu;
    }

    public void setLstIncrementoArchivos(ArrayList<IncrementoArchivos_Municipio> lstInEvJu) {
        this.lstInEvJu = lstInEvJu;
    }

    public IncrementoArchivos_Municipio getSelIncrmento() {
        return this.selIncrmento;
    }

    public void setSelIncrmento(IncrementoArchivos_Municipio selIncrmento) {
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

    public ArrayList<Archivo_Municipio> getFilterarchivo() {
        return filterarchivo;
    }

    public void setFilterarchivo(ArrayList<Archivo_Municipio> filterarchivo) {
        this.filterarchivo = filterarchivo;
    }

    public Archivo_Municipio getArchivoSel() {
        return archivoSel;
    }

    public void setArchivoSel(Archivo_Municipio archivoSel) {
        this.archivoSel = archivoSel;
    }

    public String getKeywords() {
        return this.keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public ArrayList<IncrementoArchivos_Municipio> getLstInEvJu() {
        return lstInEvJu;
    }

    public void setLstInEvJu(ArrayList<IncrementoArchivos_Municipio> lstInEvJu) {
        this.lstInEvJu = lstInEvJu;
    }

    public ArrayList<Archivo_Municipio> getLstEviJu() {
        return lstEviJu;
    }

    public void setLstEviJu(ArrayList<Archivo_Municipio> lstEviJu) {
        this.lstEviJu = lstEviJu;
    }

    public String getCedula() {
        return this.cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
// Componente existente con codigo anterior archivo, pero al cambiar 
    public Documento getArchiveSel() {
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

    public Detalle_ArchivoIn getObjdetallearchivoin() {
        return objdetallearchivoin;
    }

    public void setObjdetallearchivoin(Detalle_ArchivoIn objdetallearchivoin) {
        this.objdetallearchivoin = objdetallearchivoin;
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
