/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package master.presentacion.beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import master.logica.clases.Menu_Sitio;

/**
 *
 * @author saberes
 */
@ManagedBean
@SessionScoped
public class SesionSitioDataManager implements Serializable{

    private Menu_Sitio paginaActual;

    public SesionSitioDataManager() {
        this.paginaActual = new Menu_Sitio();
    }

    public Menu_Sitio getPaginaActual() {
        return paginaActual;
    }

    public void setPaginaActual(Menu_Sitio paginaActual) {
        this.paginaActual = paginaActual;
    }

    
}
