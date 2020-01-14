/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package master.presentacion.beans;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import master.logica.funciones.FFuncion;
import master.logica.funciones.FNodoMenu;
import master.logica.funciones.FUsuarioRol;
import recursos.Util;

/**
 *
 * @author escorpionDJ
 */
@ManagedBean
@ViewScoped
public class IndexMasterControlador {

    @ManagedProperty(value = "#{sesionUsuarioDataManager}")
    private SesionUsuarioDataManager dm;
    

    public IndexMasterControlador() {
    }

    public SesionUsuarioDataManager getDm() {
        return dm;
    }

    public void setDm(SesionUsuarioDataManager dm) {
        this.dm = dm;
    }

    //asignar funcion actual segun el codigo provisto en el menu
    public void asignaCodigoFuncion() {
        try {
            this.dm.setFuncionActual(FFuncion.ObtenerFuncionDadoCodigo(this.dm.getCodigoFuncionActual()));
            Util.setPrimerIngreso(true);
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }

    //cambiar rol del usuario en la sesion
    public void cambiarRol() {
        ResourceBundle recurso = ResourceBundle.getBundle("/recursos/mensajesSeguridad");
        try {
            //si existe la sesion y esta validada
            if (this.dm.getSesionUsuario() != null && this.dm.getValidado() != false) {
                //cargamos el usuario rol actual
                this.dm.setSesionUsuarioRolActual(FUsuarioRol.ObtenerUsuarioRolDadoCodigo(this.dm.getIntSesionUsuarioRolActual()));
                //objeto encargado de generar el menu
                FNodoMenu objMenu = new FNodoMenu();
                this.dm.setMenu(objMenu.generarMenuUsuario(this.dm.getSesionUsuarioRolActual().getCodigo_rol().getCodigo()));
                //redirijo a la pagina por defecto del sitio
                this.dm.setPaginaActual("home.xhtml");
                // return "index?faces-redirect=true";
            } else {
                Util.addErrorMessage(null, recurso.getString("login"));
                this.dm.setValidado(Boolean.FALSE);
                // return "/faces/login";
            }
        } catch (Exception ex) {
            Util.addErrorMessage(ex, String.format(recurso.getString("errorCatch"), "Autentificación"));
            // return "/faces/login";
        }
    }

    public String getFechaActual() {
        SimpleDateFormat formato = new SimpleDateFormat("EEEE, dd 'de' MMMM 'de' yyyy");
        Calendar cal = Calendar.getInstance();
        return formato.format(cal.getTime());
    }
}
