/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package master.presentacion.beans;

import java.util.ArrayList;
import java.util.ResourceBundle;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import master.logica.clases.Accion;
import master.logica.funciones.FAccion;
import org.primefaces.context.DefaultRequestContext;
import recursos.Util;

/**
 *
 * @author cfviteris
 */
@ManagedBean
@ViewScoped
public class accionControlador {

    private ArrayList<Accion> acciones;
    private Accion accion;
    private boolean mostrarActualizar;
    private Accion seleccionarAccion;
    ResourceBundle atributosVistas = ResourceBundle.getBundle("/recursos/atributosVistas");

    public accionControlador() {
        try {
            accion = new Accion();
            acciones = new ArrayList<Accion>();
            seleccionarAccion = new Accion();
            cargarAccion();
        } catch (Exception e) {
            System.out.println("constructor" + e.getMessage());
        }


    }

    public ResourceBundle getAtributosVistas() {
        return atributosVistas;
    }

    public void setAtributosVistas(ResourceBundle atributosVistas) {
        this.atributosVistas = atributosVistas;
    }

    public Accion getAccion() {
        System.out.println("GET ACCION " + accion);
        return accion;
    }

    public void setAccion(Accion accion) {
        System.out.println("SET ACCION " + accion);
        this.accion = accion;
    }

    public ArrayList<Accion> getAcciones() {
        return acciones;
    }

    public void setAcciones(ArrayList<Accion> acciones) {
        this.acciones = acciones;
    }

    public Accion getSeleccionarAccion() {
        return seleccionarAccion;
    }

    public void setSeleccionarAccion(Accion seleccionarAccion) {
        this.seleccionarAccion = seleccionarAccion;
    }

    public boolean isMostrarActualizar() {
        return mostrarActualizar;
    }

    public void setMostrarActualizar(boolean mostrarActualizar) {
        this.mostrarActualizar = mostrarActualizar;
    }

    public void cargarAccion() {
        try {
            acciones = FAccion.ObtenerAcciones();
            System.out.println(acciones.get(0).getCodigo());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertarAccion() {
        try {
            FAccion.Insertar(accion);
            cargarAccion();
            accion = new Accion();
            DefaultRequestContext.getCurrentInstance().execute("wdlgaccionAgregar.hide()");
            Util.addSuccessMessage("Datos Insertados");
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }

    }

    public void cambiarEstadoMostrarActualizar() {
        mostrarActualizar = true;
    }

    public void actualizarAccion() {
        try {
            FAccion.actualizar(seleccionarAccion);
            seleccionarAccion = new Accion();
            DefaultRequestContext.getCurrentInstance().execute("wdlgaccionActualizar.hide()");
            Util.addSuccessMessage("Datos Actualizados");
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }

    public void eliminarAccion() {
        try {
            FAccion.eliminar(seleccionarAccion.getCodigo());
            cargarAccion();
            seleccionarAccion = new Accion();
            DefaultRequestContext.getCurrentInstance().execute("wdlgaccionEliminar.hide()");
            Util.addSuccessMessage("Datos Eliminados");
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }

    }
}
