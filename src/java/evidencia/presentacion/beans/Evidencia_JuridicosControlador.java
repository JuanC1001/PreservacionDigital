/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evidencia.presentacion.beans;

import evidencia.logica.clases.Evidencia_Juridicos;
import evidencia.logica.funciones.FEvidencia_Juridicos;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import recursos.Util;

/**
 *
 * @author RUBEN
 */
@ManagedBean
@ViewScoped
public class Evidencia_JuridicosControlador {

    private ArrayList<Evidencia_Juridicos> lstevidenciajuridicos;
    private Evidencia_Juridicos selcevidenciajuridicos;


    public Evidencia_JuridicosControlador() {
        reinit();
    }

    private void reinit() {
        this.lstevidenciajuridicos = new ArrayList<Evidencia_Juridicos>();
        this.selcevidenciajuridicos = new Evidencia_Juridicos();
        this.cargarEvidenciaJuridico();
    }

    public ArrayList<Evidencia_Juridicos> getLstevidenciajuridicos() {
        return lstevidenciajuridicos;
    }

    public void setLstevidenciajuridicos(ArrayList<Evidencia_Juridicos> lstevidenciajuridicos) {
        this.lstevidenciajuridicos = lstevidenciajuridicos;
    }

    public Evidencia_Juridicos getSelcevidenciajuridicos() {
        return selcevidenciajuridicos;
    }

    public void setSelcevidenciajuridicos(Evidencia_Juridicos selcevidenciajuridicos) {
        this.selcevidenciajuridicos = selcevidenciajuridicos;
    }

    public void cargarEvidenciaJuridico() {
        try {
            lstevidenciajuridicos = FEvidencia_Juridicos.obtenerEvidencia_Juridicos();
        } catch (Exception e) {
            Util.addErrorMessage(e, "No Existe Registro de Casos");
        }
    }

}
