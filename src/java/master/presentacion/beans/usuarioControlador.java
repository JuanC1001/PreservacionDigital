/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package master.presentacion.beans;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import master.logica.clases.Persona;
import master.logica.clases.Usuario;
//import master.logica.funciones.FLazyPersonasDataModel;
import master.logica.funciones.FPersona;
import master.logica.funciones.FUsuario;
import org.primefaces.context.DefaultRequestContext;
//import org.primefaces.model.LazyDataModel;
import recursos.Util;

/**
 *
 * @author cfviteris
 */
@ManagedBean
@ViewScoped
public class usuarioControlador {
    private ArrayList<Usuario> usuarios;
    private Usuario usuario;
    private Usuario seleccionarusuario;
    private String criterioBusquedaTitular;
    private String datoBusqueda;
    private ArrayList<Persona> personas;
    //private LazyDataModel<Persona> lazyModel;
    private Persona selectedPersona;
    private Persona persona;
    
    private Persona selectPersona;
     private String cedula;

    public usuarioControlador() {
        usuario = new Usuario();
        usuarios = new ArrayList<Usuario>();
        seleccionarusuario = new Usuario();
        personas = new ArrayList<Persona>();
        selectedPersona = new Persona();
        persona = new Persona();
        cargarUsuarios();
        usuario.setEstado(1);
        selectPersona = new Persona();

    }

    public Usuario getSeleccionarusuario() {
        return seleccionarusuario;
    }

    public void setSeleccionarusuario(Usuario seleccionarusuario) {
        this.seleccionarusuario = seleccionarusuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void cargarUsuarios() {
        try {
            usuarios = FUsuario.ObtenerUsuarios();

        } catch (Exception e) {
        }
    }

    public void insertarUsuario() {
        try {

            usuario.setBool_imagen(false);
            usuario.setCodigo_salt("espoch");
            usuario.setFecha_modificacion(recursos.Tools.obtieneFechaActualenMilisegDivididaPOrMil());
            usuario.setPrimer_acceso(recursos.Tools.obtieneFechaActualenMilisegDivididaPOrMil());
            usuario.setUltima_ip("localhost");
            usuario.setUtimo_acceso(recursos.Tools.obtieneFechaActualenMilisegDivididaPOrMil());
            usuario.setApellidos(selectPersona.getApellido());
            usuario.setNombres(selectPersona.getNombre() );
            usuario.setMail(selectPersona.getMail());
            FUsuario.Insertar(usuario, selectPersona.getCodigo_persona());
            usuario = new Usuario();
            DefaultRequestContext.getCurrentInstance().execute("wdlgusuarioAgregar.hide()");
            Util.addSuccessMessage("Datos Insertados");
            cargarUsuarios();
        } catch (Exception e) {
            Util.mostrarMensaje(e.getMessage());
        }

    }

    public void actualizarUsuario() {
        try {
            FUsuario.Actualizar(seleccionarusuario);
            seleccionarusuario = new Usuario();

            DefaultRequestContext.getCurrentInstance().execute("wdlgusuarioActualizar.hide()");
            Util.addSuccessMessage("Datos Actualizados");
        } catch (Exception e) {
            Util.mostrarMensaje(e.getMessage());
        }

    }

    public void eliminarUsuario() {
        try {
            FUsuario.Eliminar(seleccionarusuario.getCodigo());
            cargarUsuarios();
            seleccionarusuario = new Usuario();
            DefaultRequestContext.getCurrentInstance().execute("wdlgusuarioEliminar.hide()");
            Util.addSuccessMessage("Datos Eliminados");
        } catch (Exception e) {
            Util.mostrarMensaje(e.getMessage());
        }

    }

//    public void obtenerPersonas() {
//        try {
//            if(criterioBusquedaTitular.equals("cedula")){
//                setPersonas(FPersona.ObtenerPersonaDadoCedula(datoBusqueda));
//            }else{
//                setPersonas(FPersona.ObtenerPersonaDadoApellido(datoBusqueda.toUpperCase()));
//            }
//            setLazyModel(new FLazyPersonasDataModel(getPersonas()));
//        } catch (Exception e) {
//        }
//    }

    public void asignarSelectedPersona() {
        try {
            persona = (FPersona.ObtenerPersonaDadoCodigo(selectedPersona.getCodigo_persona()));
            System.out.print(getPersona().getCedula());
        } catch (java.lang.Exception e) {

            System.out.print(getPersona().getApellido() + " " + e.getMessage());
        }
        DefaultRequestContext.getCurrentInstance().execute("wdialogoBusquedaPersonas.hide()");
        DefaultRequestContext.getCurrentInstance().execute("wdlgusuarioAgregar.show()");
    }

    /**
     * @return the criterioBusquedaTitular
     */
    public String getCriterioBusquedaTitular() {
        return criterioBusquedaTitular;
    }

    /**
     * @param criterioBusquedaTitular the criterioBusquedaTitular to set
     */
    public void setCriterioBusquedaTitular(String criterioBusquedaTitular) {
        this.criterioBusquedaTitular = criterioBusquedaTitular;
    }

    /**
     * @return the datoBusqueda
     */
    public String getDatoBusqueda() {
        return datoBusqueda;
    }

    /**
     * @param datoBusqueda the datoBusqueda to set
     */
    public void setDatoBusqueda(String datoBusqueda) {
        this.datoBusqueda = datoBusqueda;
    }

    /**
     * @return the personas
     */
    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    /**
     * @param personas the personas to set
     */
    public void setPersonas(ArrayList<Persona> personas) {
        this.personas = personas;
    }

    /**
     * @return the selectedPersona
     */
    public Persona getSelectedPersona() {
        return selectedPersona;
    }

    /**
     * @param selectedPersona the selectedPersona to set
     */
    public void setSelectedPersona(Persona selectedPersona) {
        this.selectedPersona = selectedPersona;
    }

    /**
     * @return the persona
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * @param persona the persona to set
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    ///

    public Persona getSelectPersona() {
        return selectPersona;
    }

    public void setSelectPersona(Persona selectPersona) {
        this.selectPersona = selectPersona;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    
    
      public void buscarPersonaCedula() {
      try {
          this.selectPersona= FPersona.ObtenerPersonaDadoCedula1(cedula);
      } catch (Exception e) {
          Util.addErrorMessage(e, "Error en la busqueda");
      }
}
      public String obtieneFecha(long fecha) {
        Timestamp fechaFin = null;
        try {
            fechaFin = recursos.Tools.obtieneFechaTimeStamp(fecha);
        } catch (ParseException ex) {
            Util.addErrorMessage(ex, "Error");
           // Logger.getLogger(MovPresItemC.class.getName()).log(Level.SEVERE, null, ex);
        }
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formato.format(fechaFin.getTime());
    }    
      
}

