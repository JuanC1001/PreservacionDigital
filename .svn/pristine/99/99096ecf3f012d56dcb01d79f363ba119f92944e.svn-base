/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package master.presentacion.beans;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import master.logica.clases.Modulo;
import master.logica.clases.Rol;
import master.logica.funciones.FModulo;
import master.logica.funciones.FRoles;
import org.primefaces.context.DefaultRequestContext;
import recursos.Util;

/**
 *
 * @author cfviteris
 */
@ManagedBean
@ViewScoped
public class rolControlador {
    
    private ArrayList<Rol> roles;
    private Rol rol;
    private boolean mostrarActualizar;
    private Rol seleccionarRol;
    private Integer valorRolSeleccionado;
    private ArrayList<Modulo> modulos;
    
    public rolControlador() {
        roles = new ArrayList<Rol>();
        rol = new Rol();
        seleccionarRol = new Rol();
        modulos = new ArrayList<Modulo>();
        cargarRol();
        cargarModulo();
    }
    
    public Rol getRol() {
        return rol;
    }
    
    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
    public ArrayList<Rol> getRoles() {
        return roles;
    }
    
    public void setRoles(ArrayList<Rol> roles) {
        this.roles = roles;
    }
    
    public Rol getSeleccionarRol() {
        return seleccionarRol;
    }
    
    public void setSeleccionarRol(Rol seleccionarRol) {
        this.seleccionarRol = seleccionarRol;
    }
    
    public ArrayList<Modulo> getModulos() {
        return modulos;
    }
    
    public void setModulos(ArrayList<Modulo> modulos) {
        this.modulos = modulos;
    }
    
    public Integer getValorRolSeleccionado() {
        return valorRolSeleccionado;
    }
    
    public void setValorRolSeleccionado(Integer valorRolSeleccionado) {
        this.valorRolSeleccionado = valorRolSeleccionado;
    }
    
    public void cargarRol() {
        try {
            roles = FRoles.ObtenerRoles();
        } catch (Exception e) {
        }
    }
    
    public void cargarModulo() {
        try {
            modulos = FModulo.ObtenerModulos();
            seleccionarRol = roles.get(0);
        } catch (Exception e) {
        }
    }
    
    public boolean isMostrarActualizar() {
        return mostrarActualizar;
    }
    
    public void setMostrarActualizar(boolean mostrarActualizar) {
        this.mostrarActualizar = mostrarActualizar;
    }
    
    public void insertarRol() {
        try {
            rol.setCodigo_modulo(FModulo.ObtenerModuloDadoCodigo(valorRolSeleccionado));
            boolean bandera = FRoles.Insertar(rol);
            if (bandera == true) {
                cargarRol();
                rol = new Rol();
                DefaultRequestContext.getCurrentInstance().execute("wdlgrolAgregar.hide()");
                Util.addSuccessMessage("Datos Insertados");
            } else {
                
            }
            
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
        
    }
    
    public void actualizarrol() {
        try {
            seleccionarRol.setCodigo_modulo(FModulo.ObtenerModuloDadoCodigo(seleccionarRol.getCodigo_modulo().getCodigo()));
            FRoles.Actualizar(seleccionarRol);
            seleccionarRol = new Rol();
        mostrarActualizar = false;
        DefaultRequestContext.getCurrentInstance().execute("wdlgrolActualizar.hide()");
            Util.addSuccessMessage("Datos Actualizados");
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
        
    }
    
    public void cambiarEstadoMostrarActualizar() {
        mostrarActualizar = true;
    }
    
    public void eliminarrol() {
        try {
            FRoles.Eliminar(seleccionarRol.getCodigo());
            cargarRol();
            seleccionarRol = new Rol();
        DefaultRequestContext.getCurrentInstance().execute("wdlgrolEliminar.hide()");
            Util.addSuccessMessage("Datos Eliminados");
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
        
    }
}
