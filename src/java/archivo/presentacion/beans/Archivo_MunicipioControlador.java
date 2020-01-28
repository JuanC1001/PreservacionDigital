/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivo.presentacion.beans;

import archivo.logica.clases.Archivo_Municipio;
import archivo.logica.funciones.FArchivo_Municipio;
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
public class Archivo_MunicipioControlador {

    private ArrayList<Archivo_Municipio> lstarchivomunicipio;
    private Archivo_Municipio selcarchivomunicipio;


    public Archivo_MunicipioControlador() {
        reinit();
    }

    private void reinit() {
        this.lstarchivomunicipio = new ArrayList<Archivo_Municipio>();
        this.selcarchivomunicipio = new Archivo_Municipio();
        this.cargarArchivoJuridico();
    }

    public ArrayList<Archivo_Municipio> getLstarchivomunicipio() {
        return lstarchivomunicipio;
    }

    public void setLstarchivomunicipio(ArrayList<Archivo_Municipio> lstarchivomunicipio) {
        this.lstarchivomunicipio = lstarchivomunicipio;
    }

    public Archivo_Municipio getSelcarchivomunicipio() {
        return selcarchivomunicipio;
    }

    public void setSelcarchivomunicipio(Archivo_Municipio selcarchivomunicipio) {
        this.selcarchivomunicipio = selcarchivomunicipio;
    }

    public void cargarArchivoJuridico() {
        try {
            lstarchivomunicipio = FArchivo_Municipio.obtenerArchivo_Municipio();
        } catch (Exception e) {
            Util.addErrorMessage(e, "No Existe Registro de Departamentos");
        }
    }

}
