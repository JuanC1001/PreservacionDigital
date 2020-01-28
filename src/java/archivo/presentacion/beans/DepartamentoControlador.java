package archivo.presentacion.beans;

import archivo.logica.clases.AutorizacionResponsable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import archivo.logica.clases.Departamento;
import archivo.logica.clases.DepartamentoPersonaUsuario;
import archivo.logica.clases.Dependencia;
import archivo.logica.clases.Detalle_Archivo;
import archivo.logica.clases.Entorno_hw_Recojido;
import archivo.logica.clases.Entorno_sw_Recojido;
import archivo.logica.clases.Archivo_Municipio;
import archivo.logica.clases.Metadatos;
import archivo.logica.clases.Persona;
import archivo.logica.clases.Politicas;
import archivo.logica.clases.Procedimineto_Recojida;
import archivo.logica.clases.Tecnicas;
import archivo.logica.clases.Tipo_Departamento;
import archivo.logica.clases.Tipo_Usuario;
import archivo.logica.funciones.FDepartamento;
import archivo.logica.funciones.FDepartamentoPersonaUsuario;
import archivo.logica.funciones.FDependencia;
import archivo.logica.funciones.FArchivoMunicipio;
import archivo.logica.funciones.FPersona;
import archivo.logica.funciones.FPoliticas;
import archivo.logica.funciones.FTipo_Departamento;
import archivo.logica.funciones.FTipo_Usuario;
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
public class DepartamentoControlador {

    private Departamento objdepartamento;
    //private ArrayList<DepartamentoPersonaUsuario> lstCPU;
    private ArrayList<Departamento> lstDepartamento, filterDepartamento;
    private Departamento departamentoSel;
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

    //Tipo de Departamento
    private ArrayList<Tipo_Departamento> lstTipoDepartamento;
    private Tipo_Departamento tipoDepartamentoSel;
    private Integer valortipoDepartamento;

    //Dependencia
    private ArrayList<Dependencia> lstdependencia;
    private Dependencia dependenciaSel;
    private Integer valordependencia;

    //Persona con su tipo de usuario
    //private Persona_TipoUsuario objpersonaTipoUsuario;
    //Insertar Departamento Persona Usuario
    private DepartamentoPersonaUsuario objCUP;
    private ArrayList<DepartamentoPersonaUsuario> lstCUP;
    private DepartamentoPersonaUsuario cupSel;
    private String cdgDepartamentoIns;
    private Integer ultimoCodigo;

    //>>>>>Ingreso de Archivos
    //Aurotizacion Responsable
    private AutorizacionResponsable objautorizacionresponsable;
    //Entorno swr
    private Entorno_sw_Recojido objentornoswrecojido;
    //Entorno hwr
    private Entorno_hw_Recojido objentornohwrecojido;
    //Procedimineto Recojido
    private Procedimineto_Recojida objprocedimientorecojido;
    //Detalles archivo
    private Detalle_Archivo objdetallearchivo;
    //Metadatos 
    private Metadatos objmetados;
    //Tecnicas
    private Tecnicas objtecnicas;
    //Archivo Municipio
    private Archivo_Municipio objarchivomunicipio;

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

    //Archivos.
    public DepartamentoControlador() {
        this.reinit();
    }

    //<editor-fold defaultstate="collapsed" desc="Constructor">
    private void reinit() {
        this.objdepartamento = new Departamento();
        //  this.lstCPU = new ArrayList<DepartamentoPersonaUsuario>(); 
        this.lstDepartamento = new ArrayList<Departamento>();
        this.fechaRegistro = new java.util.Date();
        this.lstPersona = new ArrayList<Persona>();
        //this.autorSel = new Usuario();
        this.personaSel = new Persona();
        this.lstTipoUsuario = new ArrayList<Tipo_Usuario>();
        this.lsttipoUsuariosel = new ArrayList<Tipo_Usuario>();
        this.tipoUsuarioSel = new Tipo_Usuario();
        this.lstPoliticas = new ArrayList<Politicas>();
        this.lstTipoDepartamento = new ArrayList<Tipo_Departamento>();
        this.tipoDepartamentoSel = new Tipo_Departamento();
        this.lstdependencia = new ArrayList<Dependencia>();
        this.dependenciaSel = new Dependencia();
        //Insertar CUP
        this.objCUP = new DepartamentoPersonaUsuario();
        this.lstCUP = new ArrayList<DepartamentoPersonaUsuario>();
        this.cupSel = new DepartamentoPersonaUsuario();
        //Ingreso de Archivo
        objautorizacionresponsable = new AutorizacionResponsable();
        objentornoswrecojido = new Entorno_sw_Recojido();
        objentornohwrecojido = new Entorno_hw_Recojido();
        objprocedimientorecojido = new Procedimineto_Recojida();
        objdetallearchivo = new Detalle_Archivo();
        objmetados = new Metadatos();
        objtecnicas = new Tecnicas();
        objarchivomunicipio = new Archivo_Municipio();

        this.cargarDepartamentos();
        this.cargarTipoUsuario();
        // this.cargarListaPersonas();
        this.cargarPoliticas();
        this.cargarTipoDepartamento();
        this.cargarDependencia();
        //this.cargarDepartamentoDadoCodIns();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Funciones de Cargar del Departamento">
    public void cargarDepartamentos() {
        try {
            lstDepartamento = FDepartamento.obtenerDepartamentos();
            this.filterDepartamento = lstDepartamento;
        } catch (Exception e) {
            Util.addErrorMessage(e, "No Existe Registro de Departamentos");
        }
    }

    //En análisis y desarrollo
    public void cargarDepartamentoDadoCodIns() {
        try {
            lstCUP = FDepartamentoPersonaUsuario.ObtenerCPUdadoCodInst(objCUP.getCodigo_departamento().getCodigo_institucional());
        } catch (Exception e) {
            Util.addErrorMessage(e, "Ingrese Departamento Para Ingresar Usuario..?");
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

    public void cargarTipoDepartamento() {
        try {
            lstTipoDepartamento = FTipo_Departamento.obtenerTipoDepartamentos();
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

    //<editor-fold defaultstate="collapsed" desc="Insertar Departamento">
    public void insertarUsuarioDepartamento() {
        try {
            UsuarioRol us = new UsuarioRol();
            us.setCodigo(dm.getSesionUsuarioRolActual().getCodigo());
            objdepartamento.setCodigo_usuario_rol(us);
            objdepartamento.setFecha_registro(new java.sql.Timestamp(fechaRegistro.getTime()));
            objdepartamento.setCodigo_tipo_departamento(FTipo_Departamento.ObtenerTipoDepartamentoDadoCodigo(valortipoDepartamento));
            objdepartamento.setCodigo_dependencia(FDependencia.ObtenerDependenciaDadoCodigo(valordependencia));
            if (objdepartamento.getPoliticas() == null) {
                Util.addSuccessMessage("Debes Aceptar las Politicas");
            } else if (FDepartamento.insertar(objdepartamento) > 0) {

                FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Insertados");
                FacesContext.getCurrentInstance().addMessage(null, mensaje);
                //DefaultRequestContext.getCurrentInstance().execute("insertarNuevoDepartamento.hide()");
                //this.objdepartamento = new Departamento();
                this.cargarDepartamentos();
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

    //<editor-fold defaultstate="collapsed" desc="Insertar Usuarios al Departamento">
    public void insertarUsuarioPersonaDepartamento() {
        try {
            objCUP.setCodigo_departamento(FDepartamento.ObtenerDepartamentoUltimo());
            objCUP.setCodigo_persona(personaSel);
            objCUP.setCodigo_tipo_usuario(FTipo_Usuario.ObtenerTipoUsuarioDadoCodigo(valorTipoUsuario));

            if (personaSel == null & valorTipoUsuario == null) {
                Util.addSuccessMessage("Ingrese Persona o Usuario");
            } else if (FDepartamentoPersonaUsuario.insertar(objCUP) == true) {
                FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Insertados");
                FacesContext.getCurrentInstance().addMessage(null, mensaje);
                this.cargarDepartamentoDadoCodIns();
            } else {
                FacesMessage mensajeError = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", "Datos no Insertados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeError);
            }
        } catch (Exception e) {
            FacesMessage mensajeErrorIngreso = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Ingrese Departamento", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, mensajeErrorIngreso);
        }

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Insertar Archivo del Departamento">
    public void insertarArchivoDepartamento() {
        try {
            UsuarioRol us = new UsuarioRol();
            us.setCodigo(dm.getSesionUsuarioRolActual().getCodigo());
            objdetallearchivo.setCodigo_usuario_rol(us);
            objautorizacionresponsable.setCodigo_usuario_rol(us);
            objentornoswrecojido.setCodigo_usuario_rol(us);
            objentornohwrecojido.setCodigo_usuario_rol(us);
            objprocedimientorecojido.setCodigo_usuario_rol(us);

            this.objautorizacionresponsable.setFecharegistro_autresponsable(new java.sql.Timestamp(fechaRegistro.getTime()));
            this.objentornoswrecojido.setFecharegistro_entornoswreco(new java.sql.Timestamp(fechaRegistro.getTime()));
            this.objentornohwrecojido.setFecharegistro_hwreco(new java.sql.Timestamp(fechaRegistro.getTime()));
            this.objprocedimientorecojido.setFecharegistro_procereco(new java.sql.Timestamp(fechaRegistro.getTime()));
            this.objdetallearchivo.setFecharegistro_detalles(new java.sql.Timestamp(fechaRegistro.getTime()));

            this.objarchivomunicipio.setCodigo_departamento(departamentoSel);
            this.objautorizacionresponsable.setCodigo_persona(personaSel);

            if (departamentoSel == null) {
                FacesMessage mensajeError = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", "Seleciones un departamento");
                FacesContext.getCurrentInstance().addMessage(null, mensajeError);
            } else {

                if (objtecnicas.getTecnica() == null) {
                    //Ingreso de documento sin Técnica
                    objtecnicas.setPath("Estándar");
                    objtecnicas.setTecnica("Archivo Estándar");
                    objtecnicas.setDetalle("Archivo Estándar");

                    if (FArchivoMunicipio.insertar(objmetados, objtecnicas, objdetallearchivo, objautorizacionresponsable, objentornoswrecojido, objentornohwrecojido, objprocedimientorecojido, objarchivomunicipio) > 0) {
                        FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Insertados");
                        FacesContext.getCurrentInstance().addMessage(null, mensaje);
                        DefaultRequestContext.getCurrentInstance().execute("wdlgNuevoArchivo.hide()");
                        objautorizacionresponsable = new AutorizacionResponsable();
                        objentornoswrecojido = new Entorno_sw_Recojido();
                        objentornohwrecojido = new Entorno_hw_Recojido();
                        objprocedimientorecojido = new Procedimineto_Recojida();
                        objdetallearchivo = new Detalle_Archivo();
                        objmetados = new Metadatos();
                        objtecnicas = new Tecnicas();
                        objarchivomunicipio = new Archivo_Municipio();

                    } else {
                        FacesMessage mensajeError = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", "Datos no Insertados");
                        FacesContext.getCurrentInstance().addMessage(null, mensajeError);
                    }

                } else //Ingreso de documento con Técnica
                if (FArchivoMunicipio.insertar(objmetados, objtecnicas, objdetallearchivo, objautorizacionresponsable, objentornoswrecojido, objentornohwrecojido, objprocedimientorecojido, objarchivomunicipio) > 0) {
                    FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Insertados");
                    FacesContext.getCurrentInstance().addMessage(null, mensaje);
//                  DefaultRequestContext.getCurrentInstance().execute("insertarNuevoArchivo.hide()");
                    objautorizacionresponsable = new AutorizacionResponsable();
                    objentornoswrecojido = new Entorno_sw_Recojido();
                    objentornohwrecojido = new Entorno_hw_Recojido();
                    objprocedimientorecojido = new Procedimineto_Recojida();
                    objdetallearchivo = new Detalle_Archivo();
                    objmetados = new Metadatos();
                    objtecnicas = new Tecnicas();
                    objarchivomunicipio = new Archivo_Municipio();
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
        this.objdepartamento = new Departamento();
        this.objCUP = new DepartamentoPersonaUsuario();
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
            Logger.getLogger(DepartamentoControlador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public boolean guardarDocumento(String nombre, byte[] contenido) {
        String rutaArchivosOriginales = Configuracion.getString("rutaArchivosOriginales");
        int longitudRelativa = Integer.valueOf(Configuracion.getString("logitudRelativa"));
        File f = new File(rutaArchivosOriginales + nombre);
        try {
            System.out.println("PATH: " + f.getAbsolutePath());
            objdetallearchivo.setPath(Functions.substring(f.getAbsolutePath(), longitudRelativa, f.getAbsolutePath().length()));
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
            Logger.getLogger(DepartamentoControlador.class.getName()).log(Level.SEVERE, null, ex);
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

    //<editor-fold defaultstate="collapsed" desc="Cargar Responsable">
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
            Logger.getLogger(DepartamentoControlador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public boolean guardarDocumentoAutorizacion(String nombre, byte[] contenido) {
        String rutaAutorizacion = Configuracion.getString("rutaAutorizacion");
        int longitudRelativa = Integer.valueOf(Configuracion.getString("logitudRelativa"));
        File f = new File(rutaAutorizacion + nombre);
        try {
            System.out.println("PATH: " + f.getAbsolutePath());
            objautorizacionresponsable.setAutorizacion_path(Functions.substring(f.getAbsolutePath(), longitudRelativa, f.getAbsolutePath().length()));
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
            Logger.getLogger(DepartamentoControlador.class.getName()).log(Level.SEVERE, null, ex);
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
    //<editor-fold defaultstate="collapsed" desc="set y get departamento">
    public ArrayList<Departamento> getFilterDepartamento() {
        return filterDepartamento;
    }

    public void setFilterDepartamento(ArrayList<Departamento> filterDepartamento) {
        this.filterDepartamento = filterDepartamento;
    }

    public Departamento getObjdepartamento() {
        return objdepartamento;
    }

    public void setObjdepartamento(Departamento objdepartamento) {
        this.objdepartamento = objdepartamento;
    }

    public ArrayList<Departamento> getLstDepartamento() {
        return lstDepartamento;
    }

    public void setLstDepartamento(ArrayList<Departamento> lstDepartamento) {
        this.lstDepartamento = lstDepartamento;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Departamento getDepartamentoSel() {
        return departamentoSel;
    }

    public void setDepartamentoSel(Departamento departamentoSel) {
        this.departamentoSel = departamentoSel;
    }

    public SesionUsuarioDataManager getDm() {
        return dm;
    }

    public void setDm(SesionUsuarioDataManager dm) {
        this.dm = dm;
    }

    /*
     public ArrayList<DepartamentoPersonaUsuario> getLstCPU() {
     return lstCPU;
     }

     public void setLstCPU(ArrayList<DepartamentoPersonaUsuario> lstCPU) {
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

    public DepartamentoPersonaUsuario getObjCUP() {
        return objCUP;
    }

    public void setObjCUP(DepartamentoPersonaUsuario objCUP) {
        this.objCUP = objCUP;
    }

    public ArrayList<DepartamentoPersonaUsuario> getLstCUP() {
        return lstCUP;
    }

    public void setLstCUP(ArrayList<DepartamentoPersonaUsuario> lstCUP) {
        this.lstCUP = lstCUP;
    }

    public ArrayList<Politicas> getLstPoliticas() {
        return lstPoliticas;
    }

    public void setLstPoliticas(ArrayList<Politicas> lstPoliticas) {
        this.lstPoliticas = lstPoliticas;
    }

    public ArrayList<Tipo_Departamento> getLstTipoDepartamento() {
        return lstTipoDepartamento;
    }

    public void setLstTipoDepartamento(ArrayList<Tipo_Departamento> lstTipoDepartamento) {
        this.lstTipoDepartamento = lstTipoDepartamento;
    }

    public Tipo_Departamento getTipoDepartamentoSel() {
        return tipoDepartamentoSel;
    }

    public void setTipoDepartamentoSel(Tipo_Departamento tipoDepartamentoSel) {
        this.tipoDepartamentoSel = tipoDepartamentoSel;
    }

    public Integer getValortipoDepartamento() {
        return valortipoDepartamento;
    }

    public void setValortipoDepartamento(Integer valortipoDepartamento) {
        this.valortipoDepartamento = valortipoDepartamento;
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

    public String getCdgDepartamentoIns() {
        return cdgDepartamentoIns;
    }

    public void setCdgDepartamentoIns(String cdgDepartamentoIns) {
        this.cdgDepartamentoIns = cdgDepartamentoIns;
    }

    public DepartamentoPersonaUsuario getCupSel() {
        return cupSel;
    }

    public void setCupSel(DepartamentoPersonaUsuario cupSel) {
        this.cupSel = cupSel;
    }

    public Integer getUltimoCodigo() {
        return ultimoCodigo;
    }

    public void setUltimoCodigo(Integer ultimoCodigo) {
        this.ultimoCodigo = ultimoCodigo;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Set y Get de Archivo">
    public AutorizacionResponsable getObjautorizacionresponsable() {
        return objautorizacionresponsable;
    }

    public void setObjautorizacionresponsable(AutorizacionResponsable objautorizacionresponsable) {
        this.objautorizacionresponsable = objautorizacionresponsable;
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

    public Detalle_Archivo getObjdetallearchivo() {
        return objdetallearchivo;
    }

    public void setObjdetallearchivo(Detalle_Archivo objdetallearchivo) {
        this.objdetallearchivo = objdetallearchivo;
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

    public Archivo_Municipio getObjarchivomunicipio() {
        return objarchivomunicipio;
    }

    public void setObjarchivomunicipio(Archivo_Municipio objarchivomunicipio) {
        this.objarchivomunicipio = objarchivomunicipio;
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
