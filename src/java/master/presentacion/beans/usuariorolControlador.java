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
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import master.logica.clases.Modulo;
import master.logica.clases.Rol;
import master.logica.clases.Usuario;
import master.logica.clases.UsuarioRol;
import master.logica.funciones.FModulo;
import master.logica.funciones.FRoles;
import master.logica.funciones.FUsuario;
import master.logica.funciones.FUsuarioRol;
import org.primefaces.context.DefaultRequestContext;
import recursos.Util;

/**
 *
 * @author cfviteris
 */
@ManagedBean
@ViewScoped
public class usuariorolControlador {

    @ManagedProperty(value = "#{sesionUsuarioDataManager}")
    private SesionUsuarioDataManager dm;
    private ArrayList<UsuarioRol> usuarioroles;
    private UsuarioRol usuariorol;
    private UsuarioRol seleccionarUsuarioRol;
    private ArrayList<Rol> roles;
    private ArrayList<Modulo> modulos;
    private ArrayList<Usuario> usuarios;
    private Integer valorRolSeleccionado;
    private Integer valorModuloSeleccionado;
    private Integer valorUsuarioSeleccionado;
    private int estado;

    public usuariorolControlador() {

        valorModuloSeleccionado = 0;
        usuarioroles = new ArrayList<UsuarioRol>();
        usuariorol = new UsuarioRol();
        roles = new ArrayList<Rol>();
        modulos = new ArrayList<Modulo>();
        usuarios = new ArrayList<Usuario>();
        seleccionarUsuarioRol = new UsuarioRol();
        cargarModulos();
        //cargarRoles();
        cargarRolesDadoModulo();
        cargarUsuarioRol();
        cargarUsuarios();

    }

    public SesionUsuarioDataManager getDm() {
        return dm;
    }

    public void setDm(SesionUsuarioDataManager dm) {
        this.dm = dm;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public ArrayList<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(ArrayList<Modulo> modulos) {
        this.modulos = modulos;
    }

    public ArrayList<Rol> getRoles() {
        return roles;
    }

    public void setRoles(ArrayList<Rol> roles) {
        this.roles = roles;
    }

    public UsuarioRol getUsuariorol() {
        return usuariorol;
    }

    public void setUsuariorol(UsuarioRol usuariorol) {
        this.usuariorol = usuariorol;
    }

    public ArrayList<UsuarioRol> getUsuarioroles() {
        return usuarioroles;
    }

    public void setUsuarioroles(ArrayList<UsuarioRol> usuarioroles) {
        this.usuarioroles = usuarioroles;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Integer getValorModuloSeleccionado() {
        return valorModuloSeleccionado;
    }

    public void setValorModuloSeleccionado(Integer valorModuloSeleccionado) {
        this.valorModuloSeleccionado = valorModuloSeleccionado;
    }

    public Integer getValorRolSeleccionado() {
        return valorRolSeleccionado;
    }

    public void setValorRolSeleccionado(Integer valorRolSeleccionado) {
        this.valorRolSeleccionado = valorRolSeleccionado;
    }

    public Integer getValorUsuarioSeleccionado() {
        return valorUsuarioSeleccionado;
    }

    public void setValorUsuarioSeleccionado(Integer valorUsuarioSeleccionado) {
        this.valorUsuarioSeleccionado = valorUsuarioSeleccionado;
    }

    public UsuarioRol getSeleccionarUsuarioRol() {
        return seleccionarUsuarioRol;
    }

    public void setSeleccionarUsuarioRol(UsuarioRol seleccionarUsuarioRol) {
        this.seleccionarUsuarioRol = seleccionarUsuarioRol;
    }

    public void cargarRoles() {
        try {
            roles = FRoles.ObtenerRoles();

        } catch (Exception e) {
        }
    }

    public void cargarUsuarios() {
        try {
            usuarios = FUsuario.ObtenerUsuarios();

            System.out.println(usuarios.get(0).getNombres());
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

    public void cargarRolesDadoModulo() {
        try {
            roles = FRoles.obtenerRolesDadoModulo(valorModuloSeleccionado);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void cargarRolesDadoModuloEditar() {
        try {
            valorModuloSeleccionado = seleccionarUsuarioRol.getCodigo_rol().getCodigo_modulo().getCodigo();
            roles = FRoles.obtenerRolesDadoModulo(valorModuloSeleccionado);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void cargarModulos() {
        try {
            modulos = FModulo.ObtenerModulos();
        } catch (Exception e) {
        }
    }

    public void cargarUsuarioRol() {
        try {
            usuarioroles = FUsuarioRol.ObtenerUsuariosRol();
            seleccionarUsuarioRol = usuarioroles.get(0);
            System.out.println(usuarioroles.get(0).getCodigo());
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

    public void procesarEditar() {
        valorModuloSeleccionado = seleccionarUsuarioRol.getCodigo_rol().getCodigo_modulo().getCodigo();
        cargarRolesDadoModulo();
    }

    public void insertarUsuarioRol() {
        try {
            usuariorol.setFecha_creacion(recursos.Tools.obtieneFechaActualenMiliseg());
            usuariorol.setFecha_modificacion(recursos.Tools.obtieneFechaActualenMiliseg());
            usuariorol.setCodigo_rol(FRoles.ObtenerRolDadoCodigo(valorRolSeleccionado));
            usuariorol.setCodigo_usuario(FUsuario.ObtenerUsuarioDadoCodigo(valorUsuarioSeleccionado));
            //usuariorol.setCodigo_usuario_trans(FUsuario.ObtenerUsuarioDadoCodigo(dm.getSesionUsuario().getCodigo()));
            usuariorol.setCodigo_usuario_trans(FUsuario.ObtenerUsuarioDadoCodigo(3));
            FUsuarioRol.Insertar(usuariorol);
            cargarUsuarioRol();
            Util.addSuccessMessage("Datos Insertados");
        } catch (Exception e) {
            System.out.println("Error de inserción" + e.getMessage());
            Util.mostrarMensaje(e.getMessage());
        }
        usuariorol = new UsuarioRol();
        DefaultRequestContext.getCurrentInstance().execute("wdlgusuariorolAgregar.hide()");
    }

    public void editarUsuarioRol() {
        try {
            usuariorol = seleccionarUsuarioRol;
            usuariorol.setFecha_modificacion(recursos.Tools.obtieneFechaActualenMiliseg());
            usuariorol.setCodigo_rol(FRoles.ObtenerRolDadoCodigo(usuariorol.getCodigo_rol().getCodigo()));
            usuariorol.setCodigo_usuario(FUsuario.ObtenerUsuarioDadoCodigo(usuariorol.getCodigo_usuario().getCodigo()));
            //usuariorol.setCodigo_usuario_trans(FUsuario.ObtenerUsuarioDadoCodigo(dm.getSesionUsuario().getCodigo()));
            usuariorol.setCodigo_usuario_trans(FUsuario.ObtenerUsuarioDadoCodigo(3));
            FUsuarioRol.Actualizar(usuariorol);
            cargarUsuarioRol();
            Util.addSuccessMessage("Datos Actualizados");
        } catch (Exception e) {
            System.out.println("Error de inserción" + e.getMessage());
            Util.mostrarMensaje(e.getMessage());
        }
        usuariorol = new UsuarioRol();
        DefaultRequestContext.getCurrentInstance().execute("wdlgUsuarioRolEditar.hide()");
    }
    public void eliminarUsuarioRol() {
        try {
            usuariorol = seleccionarUsuarioRol;
            FUsuarioRol.Eliminar(usuariorol.getCodigo());
            cargarUsuarioRol();
            Util.addSuccessMessage("Datos Eliminados");
        } catch (Exception e) {
            System.out.println("Error de inserción" + e.getMessage());
            Util.mostrarMensaje(e.getMessage());
        }
        usuariorol = new UsuarioRol();
        DefaultRequestContext.getCurrentInstance().execute("wdlgUsuarioRolEliminar.hide()");
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
