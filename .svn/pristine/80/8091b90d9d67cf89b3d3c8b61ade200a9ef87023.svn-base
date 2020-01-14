/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package master.presentacion.beans;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import master.logica.clases.Menu_Sitio;
import master.logica.funciones.FMenu_Sitio;
import org.primefaces.context.DefaultRequestContext;
import recursos.Util;

/**
 *
 * @author icits
 */
@ManagedBean
@ViewScoped
public class Menu_SitioC {

    private ArrayList<Menu_Sitio> menuSitios;
    private Menu_Sitio menuSitio;
    private Menu_Sitio selMenuSitio;
    private int estadoSel;

    public Menu_SitioC() {
        try {
            menuSitio = new Menu_Sitio();
            menuSitios = new ArrayList<Menu_Sitio>();
            selMenuSitio = new Menu_Sitio();
            this.estadoSel = -1;
            cargarMenuSitio();
        } catch (Exception e) {
            System.out.println("constructor" + e.getMessage());
        }
    }

    public int getEstadoSel() {
        return estadoSel;
    }

    public void setEstadoSel(int estadoSel) {
        this.estadoSel = estadoSel;
    }

    public ArrayList<Menu_Sitio> getMenuSitios() {
        return menuSitios;
    }

    public void setMenuSitios(ArrayList<Menu_Sitio> menuSitios) {
        this.menuSitios = menuSitios;
    }

    public Menu_Sitio getMenuSitio() {
        return menuSitio;
    }

    public void setMenuSitio(Menu_Sitio menuSitio) {
        this.menuSitio = menuSitio;
    }

    public Menu_Sitio getSelMenuSitio() {
        return selMenuSitio;
    }

    public void setSelMenuSitio(Menu_Sitio selMenuSitio) {
        this.selMenuSitio = selMenuSitio;
    }

    public void cargarMenuSitio() {
        try {
            menuSitios = FMenu_Sitio.ObtenerMenuSitio();
            System.out.println(menuSitios.get(0).getCodigo());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertarMenuSitio() {
        try {
            menuSitio.setOrden(0);
            menuSitio.setCodigo_padre(0);
            FMenu_Sitio.Insertar(menuSitio);
            cargarMenuSitio();
            menuSitio = new Menu_Sitio();
            DefaultRequestContext.getCurrentInstance().execute("wdlgInsertarMenuSitio.hide()");
            Util.addSuccessMessage("Datos Insertados");
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }

    public void actualizarMenuSitio() {
        try {
            menuSitio.setOrden(0);
            menuSitio.setCodigo_padre(0);
            FMenu_Sitio.actualizar(selMenuSitio);            
            selMenuSitio = new Menu_Sitio();
            DefaultRequestContext.getCurrentInstance().execute("wdlgActualizarMenuSitio.hide()");
            Util.addSuccessMessage("Datos Actualizados");
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }

    public void eliminarMenuSitio() {
        try {
            FMenu_Sitio.eliminar(selMenuSitio.getCodigo());
            cargarMenuSitio();
            selMenuSitio = new Menu_Sitio();
            DefaultRequestContext.getCurrentInstance().execute("wdlgEliminarMenuSitio.hide()");
            Util.addSuccessMessage("Datos Eliminados");
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }
}
