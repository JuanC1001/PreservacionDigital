/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package master.presentacion.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author escorpionDJ
 */
@ManagedBean
@ViewScoped
public class SesionUsuario {

    public SesionUsuario() {
    }
    
    public String preparaLogin() {
        return "/faces/login";
    }
}
