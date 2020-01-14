/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package master.presentacion.beans;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import master.logica.clases.Accion;
import master.logica.clases.Funcion;
import master.logica.clases.Grupo_Menus;
import master.logica.clases.Rol;
import master.logica.funciones.FAccion;
import master.logica.funciones.FFuncion;
import master.logica.funciones.FGrupo_Menus;
import master.logica.funciones.FRoles;
import org.primefaces.context.DefaultRequestContext;
import recursos.Util;

/**
 *
 * @author cfviteris
 */
@ManagedBean
@ViewScoped
public class funcionControlador {

    private ArrayList<Funcion> funciones;
    private Funcion funcion;
    private ArrayList<Accion> acciones;
    private ArrayList<Rol> roles;
    private ArrayList<Grupo_Menus> grupomenus;
    private boolean mostrarActualizar;
    private int valorAccionSeleccionada;
    private int valorRolSeleccionado;
    private int valorGrupoMenusSelecciondo;
    private Funcion seleccionarFuncion;

    public funcionControlador() {


        funciones = new ArrayList<Funcion>();
        funcion = new Funcion();
        acciones = new ArrayList<Accion>();
        roles = new ArrayList<Rol>();
        grupomenus = new ArrayList<Grupo_Menus>();
        seleccionarFuncion = new Funcion();

        cargarAcciones();
        cargarRoles();
        cargarGruposMenus();
        cargarfunciones();

    }

    public Funcion getFuncion() {
        return funcion;
    }

    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }

    public ArrayList<Accion> getAcciones() {
        return acciones;
    }

    public void setAcciones(ArrayList<Accion> acciones) {
        this.acciones = acciones;
    }

    public ArrayList<Funcion> getFunciones() {
        return funciones;
    }

    public void setFunciones(ArrayList<Funcion> funciones) {
        this.funciones = funciones;
    }

    public ArrayList<Grupo_Menus> getGrupomenus() {
        return grupomenus;
    }

    public void setGrupomenus(ArrayList<Grupo_Menus> grupomenus) {
        this.grupomenus = grupomenus;
    }

    public boolean isMostrarActualizar() {
        return mostrarActualizar;
    }

    public void setMostrarActualizar(boolean mostrarActualizar) {
        this.mostrarActualizar = mostrarActualizar;
    }

    public ArrayList<Rol> getRoles() {
        return roles;
    }

    public void setRoles(ArrayList<Rol> roles) {
        this.roles = roles;
    }

    public Funcion getSeleccionarFuncion() {
        return seleccionarFuncion;
    }

    public void setSeleccionarFuncion(Funcion seleccionarFuncion) {
        this.seleccionarFuncion = seleccionarFuncion;
    }

    public int getValorAccionSeleccionada() {
        return valorAccionSeleccionada;
    }

    public void setValorAccionSeleccionada(int valorAccionSeleccionada) {
        this.valorAccionSeleccionada = valorAccionSeleccionada;
    }

    public int getValorGrupoMenusSelecciondo() {
        return valorGrupoMenusSelecciondo;
    }

    public void setValorGrupoMenusSelecciondo(int valorGrupoMenusSelecciondo) {
        this.valorGrupoMenusSelecciondo = valorGrupoMenusSelecciondo;
    }

    public int getValorRolSeleccionado() {
        return valorRolSeleccionado;
    }

    public void setValorRolSeleccionado(int valorRolSeleccionado) {
        this.valorRolSeleccionado = valorRolSeleccionado;
    }

    public void cargarAcciones() {
        try {
            acciones = FAccion.ObtenerAcciones();
            System.out.println(acciones.get(0).getDescripcion());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void cargarRoles() {
        try {
            roles = FRoles.ObtenerRoles();
            System.out.println(roles.get(0).getNombre());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void cargarGruposMenus() {
        try {
            grupomenus = FGrupo_Menus.ObtenerGruposMenus();
            System.out.println(grupomenus.get(0).getNombre());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void cargarfunciones() {
        try {
            funciones = FFuncion.ObtenerFunciones();
            seleccionarFuncion = funciones.get(0);
            System.out.println(funciones.get(0).getCodigo());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertarFuncion() {
        try {

            funcion.setOrden(0);
            Accion accion = new Accion();
            accion.setCodigo(valorAccionSeleccionada);
            funcion.setCodigo_accion(accion);

            Rol rol = new Rol();
            rol.setCodigo(valorRolSeleccionado);
            funcion.setCodigo_rol(rol);

            Grupo_Menus grpmenus = new Grupo_Menus();
            grpmenus.setCodigo(valorGrupoMenusSelecciondo);
            funcion.setCodigo_grupo_menus(grpmenus);

            FFuncion.Insertar(funcion);
            cargarfunciones();
            funcion = new Funcion();
            DefaultRequestContext.getCurrentInstance().execute("wdlgfuncionAgregar.hide()");
            Util.addSuccessMessage("Datos Insertados");
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }

    }

    public void cambiarEstadoMostrarActualizar() {
        mostrarActualizar = true;
    }

    public void actualizarFuncion() {
        try {
            seleccionarFuncion.setCodigo_grupo_menus(FGrupo_Menus.ObtenerGrupoMenuDadoCodigo(seleccionarFuncion.getCodigo_grupo_menus().getCodigo()));
            seleccionarFuncion.setCodigo_rol(FRoles.ObtenerRolDadoCodigo(seleccionarFuncion.getCodigo_rol().getCodigo()));
            seleccionarFuncion.setCodigo_accion(FAccion.ObtenerAccionDadoCodigo(seleccionarFuncion.getCodigo_accion().getCodigo()));
            FFuncion.Actualizar(seleccionarFuncion);
            seleccionarFuncion = new Funcion();
            mostrarActualizar = false;
            DefaultRequestContext.getCurrentInstance().execute("wdlgfuncionActualizar.hide()");
            Util.addSuccessMessage("Datos Actualizados");
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }

    public void eliminarFuncion() {
        try {
            FFuncion.Eliminar(seleccionarFuncion.getCodigo());
            cargarfunciones();
            seleccionarFuncion = new Funcion();
            DefaultRequestContext.getCurrentInstance().execute("wdlgfuncionEliminar.hide()");
            Util.addSuccessMessage("Datos Eliminados");
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }

    }
}
