package evidencia.presentacion.beans;

import evidencia.logica.clases.AutorizacionJuez;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import evidencia.logica.clases.Caso;
import evidencia.logica.clases.CasoPersonaUsuario;
import evidencia.logica.clases.Dependencia;
import evidencia.logica.clases.Detalle_Evidencia;
import evidencia.logica.clases.Entorno_hw_Recojido;
import evidencia.logica.clases.Entorno_sw_Recojido;
import evidencia.logica.clases.Evidencia_Juridicos;
import evidencia.logica.clases.Metadatos;
import evidencia.logica.clases.Persona;
import evidencia.logica.clases.Politicas;
import evidencia.logica.clases.Procedimineto_Recojida;
import evidencia.logica.clases.Tecnicas;
import evidencia.logica.clases.Tipo_Caso;
import evidencia.logica.clases.Tipo_Usuario;
import evidencia.logica.funciones.FCaso;
import evidencia.logica.funciones.FCasoPersonaUsuario;
import evidencia.logica.funciones.FDependencia;
import evidencia.logica.funciones.FEvidenciaJuridicos;
import evidencia.logica.funciones.FPersona;
import evidencia.logica.funciones.FPoliticas;
import evidencia.logica.funciones.FTipo_Caso;
import evidencia.logica.funciones.FTipo_Usuario;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
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
 * @author RUBEN
 */
@ManagedBean
@ViewScoped
public class CasoControlador {

    private Caso objcaso;
    //private ArrayList<CasoPersonaUsuario> lstCPU;
    private ArrayList<Caso> lstCaso, filterCaso;
    private Caso casoSel;
    private java.util.Date fechaRegistro;
    @ManagedProperty(value = "#{sesionUsuarioDataManager}")
    private SesionUsuarioDataManager dm;

    //personas
    private ArrayList<Persona> lstPersona;
    private Persona personaSel;
    private String cedula;
    private String apellidos;

    //Tipo de Usuario
    private ArrayList<Tipo_Usuario> lstTipoUsuario;
    private ArrayList<Tipo_Usuario> lsttipoUsuariosel;
    private Tipo_Usuario tipoUsuarioSel;
    private String nombre_usuario;
    private Integer valorTipoUsuario;

    //Politicas
    private ArrayList<Politicas> lstPoliticas;

    //Tipo de Caso
    private ArrayList<Tipo_Caso> lstTipoCaso;
    private Tipo_Caso tipoCasoSel;
    private Integer valortipoCaso;

    //Dependencia
    private ArrayList<Dependencia> lstdependencia;
    private Dependencia dependenciaSel;
    private Integer valordependencia;

    //Persona con su tipo de usuario
    //private Persona_TipoUsuario objpersonaTipoUsuario;
    //Insertar Caso Persona Usuario
    private CasoPersonaUsuario objCUP;
    private ArrayList<CasoPersonaUsuario> lstCUP;
    private CasoPersonaUsuario cupSel;
    private String cdgCasoIns;
    private Integer ultimoCodigo;

    //>>>>>Ingreso de Evidencias
    //Aurotizacion Juez
    private AutorizacionJuez objautorizacionjuez;
    //Entorno swr
    private Entorno_sw_Recojido objentornoswrecojido;
    //Entorno hwr
    private Entorno_hw_Recojido objentornohwrecojido;
    //Procedimineto Recojido
    private Procedimineto_Recojida objprocedimientorecojido;
    //Detalles evidencia
    private Detalle_Evidencia objdetalleevidencia;
    //Metadatos 
    private Metadatos objmetados;
    //Tecnicas
    private Tecnicas objtecnicas;
    //Evidencia Juridicos
    private Evidencia_Juridicos objevidenciajuridicos;

    //manejo de Documento
    private String nombreDocumento;
    private UploadedFile archivoDocumentos;
    //manejo de Documeto Técnica
    private String nombreDocumentoTec;
    private UploadedFile archivoDocumentoTecn;
    //manejo de Documeto Autorizacion
    private String nombreAutorizacion;
    private UploadedFile archivoAutorizacion;
    //manejo de imagen 
    private String nombreImagen;
    private UploadedFile archivoImagen;
    //cargar configuracion del  path
    java.util.ResourceBundle Configuracion = java.util.ResourceBundle.getBundle("recursos.rutasMedia");

    //Evidencias.
    public CasoControlador() {
        this.reinit();
    }

    //<editor-fold defaultstate="collapsed" desc="Constructor">
    private void reinit() {
        this.objcaso = new Caso();
        //  this.lstCPU = new ArrayList<CasoPersonaUsuario>(); 
        this.lstCaso = new ArrayList<Caso>();
        this.fechaRegistro = new java.util.Date();
        this.lstPersona = new ArrayList<Persona>();
        //this.autorSel = new Usuario();
        this.personaSel = new Persona();
        this.lstTipoUsuario = new ArrayList<Tipo_Usuario>();
        this.lsttipoUsuariosel = new ArrayList<Tipo_Usuario>();
        this.tipoUsuarioSel = new Tipo_Usuario();
        this.lstPoliticas = new ArrayList<Politicas>();
        this.lstTipoCaso = new ArrayList<Tipo_Caso>();
        this.tipoCasoSel = new Tipo_Caso();
        this.lstdependencia = new ArrayList<Dependencia>();
        this.dependenciaSel = new Dependencia();
        //Insertar CUP
        this.objCUP = new CasoPersonaUsuario();
        this.lstCUP = new ArrayList<CasoPersonaUsuario>();
        this.cupSel = new CasoPersonaUsuario();
        //Ingreso de Evidencia
        objautorizacionjuez = new AutorizacionJuez();
        objentornoswrecojido = new Entorno_sw_Recojido();
        objentornohwrecojido = new Entorno_hw_Recojido();
        objprocedimientorecojido = new Procedimineto_Recojida();
        objdetalleevidencia = new Detalle_Evidencia();
        objmetados = new Metadatos();
        objtecnicas = new Tecnicas();
        objevidenciajuridicos = new Evidencia_Juridicos();

        this.cargarCasos();
        this.cargarTipoUsuario();
        // this.cargarListaPersonas();
        this.cargarPoliticas();
        this.cargarTipoCaso();
        this.cargarDependencia();
        //this.cargarCasoDadoCodIns();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Funciones de Cargar del Caso">
    public void cargarCasos() {
        try {
            lstCaso = FCaso.obtenerCasos();
            this.filterCaso = lstCaso;
        } catch (Exception e) {
            Util.addErrorMessage(e, "No Existe Registro de Casos");
        }
    }

    //En análisis y desarrollo
    public void cargarCasoDadoCodIns() {
        try {
            lstCUP = FCasoPersonaUsuario.ObtenerCPUdadoCodInst(objCUP.getCodigo_caso().getCodigo_institucional());
        } catch (Exception e) {
            Util.addErrorMessage(e, "Ingrese Caso Para Ingresar Usuario..?");
        }
    }

    public void cargarTipoUsuario() {
        try {
            lstTipoUsuario = FTipo_Usuario.obtenerTipoUsuario();
        } catch (Exception e) {
            Util.addErrorMessage(e, "Error");
        }
    }

    public void buscarTipo_Usuario() {
        try {
            tipoUsuarioSel = FTipo_Usuario.ObtenerTipoUsuarioDadoCodigo(valorTipoUsuario);
            if (tipoUsuarioSel != null) {
                lsttipoUsuariosel.add(tipoUsuarioSel);
            }

        } catch (Exception e) {
            FacesMessage mensajeErrorIngreso = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Cargo no encontrado", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, mensajeErrorIngreso);
        }
    }

    public void cargarPoliticas() {
        try {
            lstPoliticas = FPoliticas.obtenerPoliticas();
        } catch (Exception e) {
            Util.addErrorMessage(e, "Error");
        }
    }

    public void cargarTipoCaso() {
        try {
            lstTipoCaso = FTipo_Caso.obtenerTipoCasos();
        } catch (Exception e) {
            Util.addErrorMessage(e, "Error");
        }
    }

    public void cargarDependencia() {
        try {
            lstdependencia = FDependencia.obtenerDependencia();
        } catch (Exception e) {
            Util.addErrorMessage(e, "Error");
        }
    }

    public void buscarPersona() {
        try {
            personaSel = FPersona.ObtenerPersonaDadoCedula(cedula);
            if (personaSel != null) {
                lstPersona.add(personaSel);
            }
        } catch (Exception e) {
            FacesMessage mensajeErrorIngreso = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Persona no encontrado", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, mensajeErrorIngreso);

        }
    }

    public void buscarPersonaApellidos() {
        try {
            personaSel = FPersona.ObtenerPersonaDadoApellidos(apellidos);
            if (personaSel != null) {
                lstPersona.add(personaSel);
            }

        } catch (Exception e) {
            FacesMessage mensajeErrorIngreso = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Persona no encontrado", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, mensajeErrorIngreso);

        }
    }

    public void cargarListaPersonas() {
        lstPersona.add(personaSel);

    }

    public void cargarListaUsuario() {
        lsttipoUsuariosel.add(tipoUsuarioSel);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Insertar Caso">
    public void insertarUsuarioCaso() {
        try {
            UsuarioRol us = new UsuarioRol();
            us.setCodigo(dm.getSesionUsuarioRolActual().getCodigo());
            objcaso.setCodigo_usuario_rol(us);
            objcaso.setFecha_registro(new java.sql.Timestamp(fechaRegistro.getTime()));
            objcaso.setCodigo_tipo_caso(FTipo_Caso.ObtenerTipoCasoDadoCodigo(valortipoCaso));
            objcaso.setCodigo_dependencia(FDependencia.ObtenerDependenciaDadoCodigo(valordependencia));
            if (objcaso.getPoliticas() == null) {
                Util.addSuccessMessage("Debes Aceptar las Politicas");
            } else if (FCaso.insertar(objcaso) > 0) {

                FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Insertados");
                FacesContext.getCurrentInstance().addMessage(null, mensaje);
                //DefaultRequestContext.getCurrentInstance().execute("insertarNuevoCaso.hide()");
                //this.objcaso = new Caso();
                this.cargarCasos();
            } else {
                FacesMessage mensajeError = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", "Datos no Insertados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeError);
            }
        } catch (Exception e) {
            FacesMessage mensajeErrorIngreso = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Atención Error ", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, mensajeErrorIngreso);
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Insertar Usuarios al Caso">
    public void insertarUsuarioPersonaCaso() {
        try {
            objCUP.setCodigo_caso(FCaso.ObtenerCasoUltimo());
            objCUP.setCodigo_persona(personaSel);
            objCUP.setCodigo_tipo_usuario(FTipo_Usuario.ObtenerTipoUsuarioDadoCodigo(valorTipoUsuario));

            if (personaSel == null & valorTipoUsuario == null) {
                Util.addSuccessMessage("Ingrese Persona o Usuario");
            } else if (FCasoPersonaUsuario.insertar(objCUP) == true) {
                FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Insertados");
                FacesContext.getCurrentInstance().addMessage(null, mensaje);
                this.cargarCasoDadoCodIns();
            } else {
                FacesMessage mensajeError = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", "Datos no Insertados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeError);
            }
        } catch (Exception e) {
            FacesMessage mensajeErrorIngreso = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Ingrese Caso", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, mensajeErrorIngreso);
        }

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Insertar Evidencia del Caso">
    public void insertarEvidenciaCaso() {
        try {
            UsuarioRol us = new UsuarioRol();
            us.setCodigo(dm.getSesionUsuarioRolActual().getCodigo());
            objdetalleevidencia.setCodigo_usuario_rol(us);
            objautorizacionjuez.setCodigo_usuario_rol(us);
            objentornoswrecojido.setCodigo_usuario_rol(us);
            objentornohwrecojido.setCodigo_usuario_rol(us);
            objprocedimientorecojido.setCodigo_usuario_rol(us);

            this.objautorizacionjuez.setFecharegistro_autjuez(new java.sql.Timestamp(fechaRegistro.getTime()));
            this.objentornoswrecojido.setFecharegistro_entornoswreco(new java.sql.Timestamp(fechaRegistro.getTime()));
            this.objentornohwrecojido.setFecharegistro_hwreco(new java.sql.Timestamp(fechaRegistro.getTime()));
            this.objprocedimientorecojido.setFecharegistro_procereco(new java.sql.Timestamp(fechaRegistro.getTime()));
            this.objdetalleevidencia.setFecharegistro_detalles(new java.sql.Timestamp(fechaRegistro.getTime()));

            this.objevidenciajuridicos.setCodigo_caso(casoSel);
            this.objautorizacionjuez.setCodigo_persona(personaSel);

            if (casoSel == null) {
                FacesMessage mensajeError = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", "Seleciones un caso");
                FacesContext.getCurrentInstance().addMessage(null, mensajeError);
            } else {

                if (objtecnicas.getTecnica() == null) {
                    //Ingreso de documento sin Técnica
                    objtecnicas.setPath("Estándar");
                    objtecnicas.setTecnica("Archivo Estándar");
                    objtecnicas.setDetalle("Archivo Estándar");

                    if (FEvidenciaJuridicos.insertar(objmetados, objtecnicas, objdetalleevidencia, objautorizacionjuez, objentornoswrecojido, objentornohwrecojido, objprocedimientorecojido, objevidenciajuridicos) > 0) {
                        FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Insertados");
                        FacesContext.getCurrentInstance().addMessage(null, mensaje);
                        DefaultRequestContext.getCurrentInstance().execute("wdlgNuevoEvidencia.hide()");
                        objautorizacionjuez = new AutorizacionJuez();
                        objentornoswrecojido = new Entorno_sw_Recojido();
                        objentornohwrecojido = new Entorno_hw_Recojido();
                        objprocedimientorecojido = new Procedimineto_Recojida();
                        objdetalleevidencia = new Detalle_Evidencia();
                        objmetados = new Metadatos();
                        objtecnicas = new Tecnicas();
                        objevidenciajuridicos = new Evidencia_Juridicos();

                    } else {
                        FacesMessage mensajeError = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", "Datos no Insertados");
                        FacesContext.getCurrentInstance().addMessage(null, mensajeError);
                    }

                } else //Ingreso de documento con Técnica
                if (FEvidenciaJuridicos.insertar(objmetados, objtecnicas, objdetalleevidencia, objautorizacionjuez, objentornoswrecojido, objentornohwrecojido, objprocedimientorecojido, objevidenciajuridicos) > 0) {
                    FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Insertados");
                    FacesContext.getCurrentInstance().addMessage(null, mensaje);
//                  DefaultRequestContext.getCurrentInstance().execute("insertarNuevoArchivo.hide()");
                    objautorizacionjuez = new AutorizacionJuez();
                    objentornoswrecojido = new Entorno_sw_Recojido();
                    objentornohwrecojido = new Entorno_hw_Recojido();
                    objprocedimientorecojido = new Procedimineto_Recojida();
                    objdetalleevidencia = new Detalle_Evidencia();
                    objmetados = new Metadatos();
                    objtecnicas = new Tecnicas();
                    objevidenciajuridicos = new Evidencia_Juridicos();
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

    //<editor-fold defaultstate="collapsed" desc="Liempiar">
    public void Liempiar() {
        this.objcaso = new Caso();
        this.objCUP = new CasoPersonaUsuario();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Cargar Documento con estandar">
    public void cargarDocumentoDoc(FileUploadEvent e) {
        System.out.println("Entra al método cargar archivos");
        UploadedFile file = e.getFile();
        this.archivoDocumentos = file;
        System.out.println(file.getContentType());
        objmetados.setTipo(file.getContentType());
        System.out.println(file.getSize());
        objmetados.setTamanio(file.getSize());
        System.out.println(file.getFileName());
        nombreDocumento = file.getFileName();
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
            Logger.getLogger(CasoControlador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public boolean guardarDocumento(String nombre, byte[] contenido) {
        String rutaArchivosOriginales = Configuracion.getString("rutaArchivosOriginales");
        int longitudRelativa = Integer.valueOf(Configuracion.getString("logitudRelativa"));
        File f = new File(rutaArchivosOriginales + nombre);
        try {
            System.out.println("PATH: " + f.getAbsolutePath());
            objdetalleevidencia.setPath(Functions.substring(f.getAbsolutePath(), longitudRelativa, f.getAbsolutePath().length()));
            objmetados.setNombre(nombre);
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

    //<editor-fold defaultstate="collapsed" desc="Cargar Documento con Ténicas">
    public void cargarDocumentoTecn(FileUploadEvent e) {
        System.out.println("Entra al método cargar archivos");
        UploadedFile file = e.getFile();
        this.archivoAutorizacion = file;
        System.out.println(file.getContentType());
        System.out.println(file.getSize());
        System.out.println(file.getFileName());
        nombreAutorizacion = file.getFileName();
        byte[] contenido;
        try {
            contenido = this.getFileContents(e.getFile().getInputstream());
            if (guardarDocumentoTec(file.getFileName(), contenido)) {
                Util.addSuccessMessage("Archivo guardada con éxito!!");
            } else {
                Util.addErrorMessage("Error al cargar la Archivo");
            }
        } catch (IOException ex) {
            Logger.getLogger(CasoControlador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public boolean guardarDocumentoTec(String nombre, byte[] contenido) {
        String rutaDocumentoTecnicas = Configuracion.getString("rutaDocumentoTecnicas");
        int longitudRelativa = Integer.valueOf(Configuracion.getString("logitudRelativa"));
        File f = new File(rutaDocumentoTecnicas + nombre);
        try {
            System.out.println("PATH: " + f.getAbsolutePath());
            objtecnicas.setPath(Functions.substring(f.getAbsolutePath(), longitudRelativa, f.getAbsolutePath().length()));
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

    //<editor-fold defaultstate="collapsed" desc="Cargar Juez">
    public void cargarDocumentoAutorizacion(FileUploadEvent e) {
        System.out.println("Entra al método cargar archivos");
        UploadedFile file = e.getFile();
        this.archivoDocumentoTecn = file;
        System.out.println(file.getContentType());
        System.out.println(file.getSize());
        System.out.println(file.getFileName());
        nombreDocumentoTec = file.getFileName();
        byte[] contenido;
        try {
            contenido = this.getFileContents(e.getFile().getInputstream());
            if (guardarDocumentoAutorizacion(file.getFileName(), contenido)) {
                Util.addSuccessMessage("Archivo guardada con éxito!!");
            } else {
                Util.addErrorMessage("Error al cargar la Archivo");
            }
        } catch (IOException ex) {
            Logger.getLogger(CasoControlador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public boolean guardarDocumentoAutorizacion(String nombre, byte[] contenido) {
        String rutaAutorizacion = Configuracion.getString("rutaAutorizacion");
        int longitudRelativa = Integer.valueOf(Configuracion.getString("logitudRelativa"));
        File f = new File(rutaAutorizacion + nombre);
        try {
            System.out.println("PATH: " + f.getAbsolutePath());
            objautorizacionjuez.setAutorizacion_path(Functions.substring(f.getAbsolutePath(), longitudRelativa, f.getAbsolutePath().length()));
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
        this.archivoImagen = file;
        System.out.println(file.getContentType());
        System.out.println(file.getSize());
        System.out.println(file.getFileName());
        nombreImagen = file.getFileName();
        byte[] contenido;
        try {
            contenido = this.getFileContents(e.getFile().getInputstream());
            if (guardarImagen(file.getFileName(), contenido)) {
                Util.addSuccessMessage("Imagen guardada con éxito!!");
            } else {
                Util.addErrorMessage("Error al cargar la Archivo");
            }
        } catch (IOException ex) {
            Logger.getLogger(CasoControlador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public boolean guardarImagen(String nombre, byte[] contenido) {
        String rutaImagen = Configuracion.getString("rutaImagen");
        int longitudRelativa = Integer.valueOf(Configuracion.getString("logitudRelativa"));
        File f = new File(rutaImagen + nombre);
        try {
            System.out.println("PATH: " + f.getAbsolutePath());
            objentornohwrecojido.setFoto(Functions.substring(f.getAbsolutePath(), longitudRelativa, f.getAbsolutePath().length()));
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

    //<editor-fold defaultstate="collapsed" desc=" subir contenido">
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

    //<editor-fold defaultstate="collapsed" desc="Llenar Listas de Producto, Servicio y Ubicacion">
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="set y get caso">
    public ArrayList<Caso> getFilterCaso() {
        return filterCaso;
    }

    public void setFilterCaso(ArrayList<Caso> filterCaso) {
        this.filterCaso = filterCaso;
    }

    public Caso getObjcaso() {
        return objcaso;
    }

    public void setObjcaso(Caso objcaso) {
        this.objcaso = objcaso;
    }

    public ArrayList<Caso> getLstCaso() {
        return lstCaso;
    }

    public void setLstCaso(ArrayList<Caso> lstCaso) {
        this.lstCaso = lstCaso;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Caso getCasoSel() {
        return casoSel;
    }

    public void setCasoSel(Caso casoSel) {
        this.casoSel = casoSel;
    }

    public SesionUsuarioDataManager getDm() {
        return dm;
    }

    public void setDm(SesionUsuarioDataManager dm) {
        this.dm = dm;
    }

    /*
     public ArrayList<CasoPersonaUsuario> getLstCPU() {
     return lstCPU;
     }

     public void setLstCPU(ArrayList<CasoPersonaUsuario> lstCPU) {
     this.lstCPU = lstCPU;
     }
     */
    public ArrayList<Persona> getLstPersona() {
        return lstPersona;
    }

    public void setLstPersona(ArrayList<Persona> lstPersona) {
        this.lstPersona = lstPersona;
    }

    public Persona getPersonaSel() {
        return personaSel;
    }

    public void setPersonaSel(Persona personaSel) {
        this.personaSel = personaSel;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public ArrayList<Tipo_Usuario> getLstTipoUsuario() {
        return lstTipoUsuario;
    }

    public void setLstTipoUsuario(ArrayList<Tipo_Usuario> lstTipoUsuario) {
        this.lstTipoUsuario = lstTipoUsuario;
    }

    public ArrayList<Tipo_Usuario> getLsttipoUsuariosel() {
        return lsttipoUsuariosel;
    }

    public void setLsttipoUsuariosel(ArrayList<Tipo_Usuario> lsttipoUsuariosel) {
        this.lsttipoUsuariosel = lsttipoUsuariosel;
    }

    public Tipo_Usuario getTipoUsuarioSel() {
        return tipoUsuarioSel;
    }

    public void setTipoUsuarioSel(Tipo_Usuario tipoUsuarioSel) {
        this.tipoUsuarioSel = tipoUsuarioSel;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public Integer getValorTipoUsuario() {
        return valorTipoUsuario;
    }

    public void setValorTipoUsuario(Integer valorTipoUsuario) {
        this.valorTipoUsuario = valorTipoUsuario;
    }

    public CasoPersonaUsuario getObjCUP() {
        return objCUP;
    }

    public void setObjCUP(CasoPersonaUsuario objCUP) {
        this.objCUP = objCUP;
    }

    public ArrayList<CasoPersonaUsuario> getLstCUP() {
        return lstCUP;
    }

    public void setLstCUP(ArrayList<CasoPersonaUsuario> lstCUP) {
        this.lstCUP = lstCUP;
    }

    public ArrayList<Politicas> getLstPoliticas() {
        return lstPoliticas;
    }

    public void setLstPoliticas(ArrayList<Politicas> lstPoliticas) {
        this.lstPoliticas = lstPoliticas;
    }

    public ArrayList<Tipo_Caso> getLstTipoCaso() {
        return lstTipoCaso;
    }

    public void setLstTipoCaso(ArrayList<Tipo_Caso> lstTipoCaso) {
        this.lstTipoCaso = lstTipoCaso;
    }

    public Tipo_Caso getTipoCasoSel() {
        return tipoCasoSel;
    }

    public void setTipoCasoSel(Tipo_Caso tipoCasoSel) {
        this.tipoCasoSel = tipoCasoSel;
    }

    public Integer getValortipoCaso() {
        return valortipoCaso;
    }

    public void setValortipoCaso(Integer valortipoCaso) {
        this.valortipoCaso = valortipoCaso;
    }

    public Integer getValordependencia() {
        return valordependencia;
    }

    public void setValordependencia(Integer valordependencia) {
        this.valordependencia = valordependencia;
    }

    public ArrayList<Dependencia> getLstdependencia() {
        return lstdependencia;
    }

    public void setLstdependencia(ArrayList<Dependencia> lstdependencia) {
        this.lstdependencia = lstdependencia;
    }

    public Dependencia getDependenciaSel() {
        return dependenciaSel;
    }

    public void setDependenciaSel(Dependencia dependenciaSel) {
        this.dependenciaSel = dependenciaSel;
    }

    public String getCdgCasoIns() {
        return cdgCasoIns;
    }

    public void setCdgCasoIns(String cdgCasoIns) {
        this.cdgCasoIns = cdgCasoIns;
    }

    public CasoPersonaUsuario getCupSel() {
        return cupSel;
    }

    public void setCupSel(CasoPersonaUsuario cupSel) {
        this.cupSel = cupSel;
    }

    public Integer getUltimoCodigo() {
        return ultimoCodigo;
    }

    public void setUltimoCodigo(Integer ultimoCodigo) {
        this.ultimoCodigo = ultimoCodigo;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Set y Get de Evidencia">
    public AutorizacionJuez getObjautorizacionjuez() {
        return objautorizacionjuez;
    }

    public void setObjautorizacionjuez(AutorizacionJuez objautorizacionjuez) {
        this.objautorizacionjuez = objautorizacionjuez;
    }

    public Entorno_sw_Recojido getObjentornoswrecojido() {
        return objentornoswrecojido;
    }

    public void setObjentornoswrecojido(Entorno_sw_Recojido objentornoswrecojido) {
        this.objentornoswrecojido = objentornoswrecojido;
    }

    public Entorno_hw_Recojido getObjentornohwrecojido() {
        return objentornohwrecojido;
    }

    public void setObjentornohwrecojido(Entorno_hw_Recojido objentornohwrecojido) {
        this.objentornohwrecojido = objentornohwrecojido;
    }

    public Procedimineto_Recojida getObjprocedimientorecojido() {
        return objprocedimientorecojido;
    }

    public void setObjprocedimientorecojido(Procedimineto_Recojida objprocedimientorecojido) {
        this.objprocedimientorecojido = objprocedimientorecojido;
    }

    public Detalle_Evidencia getObjdetalleevidencia() {
        return objdetalleevidencia;
    }

    public void setObjdetalleevidencia(Detalle_Evidencia objdetalleevidencia) {
        this.objdetalleevidencia = objdetalleevidencia;
    }

    public Metadatos getObjmetados() {
        return objmetados;
    }

    public void setObjmetados(Metadatos objmetados) {
        this.objmetados = objmetados;
    }

    public Tecnicas getObjtecnicas() {
        return objtecnicas;
    }

    public void setObjtecnicas(Tecnicas objtecnicas) {
        this.objtecnicas = objtecnicas;
    }

    public Evidencia_Juridicos getObjevidenciajuridicos() {
        return objevidenciajuridicos;
    }

    public void setObjevidenciajuridicos(Evidencia_Juridicos objevidenciajuridicos) {
        this.objevidenciajuridicos = objevidenciajuridicos;
    }

    public String getNombreDocumento() {
        return nombreDocumento;
    }

    public void setNombreDocumento(String nombreDocumento) {
        this.nombreDocumento = nombreDocumento;
    }

    public UploadedFile getArchivoDocumentos() {
        return archivoDocumentos;
    }

    public void setArchivoDocumentos(UploadedFile archivoDocumentos) {
        this.archivoDocumentos = archivoDocumentos;
    }

    public String getNombreDocumentoTec() {
        return nombreDocumentoTec;
    }

    public void setNombreDocumentoTec(String nombreDocumentoTec) {
        this.nombreDocumentoTec = nombreDocumentoTec;
    }

    public UploadedFile getArchivoDocumentoTecn() {
        return archivoDocumentoTecn;
    }

    public void setArchivoDocumentoTecn(UploadedFile archivoDocumentoTecn) {
        this.archivoDocumentoTecn = archivoDocumentoTecn;
    }

    public String getNombreAutorizacion() {
        return nombreAutorizacion;
    }

    public void setNombreAutorizacion(String nombreAutorizacion) {
        this.nombreAutorizacion = nombreAutorizacion;
    }

    public UploadedFile getArchivoAutorizacion() {
        return archivoAutorizacion;
    }

    public void setArchivoAutorizacion(UploadedFile archivoAutorizacion) {
        this.archivoAutorizacion = archivoAutorizacion;
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

    public ResourceBundle getConfiguracion() {
        return Configuracion;
    }

    public void setConfiguracion(ResourceBundle Configuracion) {
        this.Configuracion = Configuracion;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    //</editor-fold>
}
