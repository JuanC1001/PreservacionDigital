/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evidencia.presentacion.beans;

import evidencia.logica.clases.CasoPersonaUsuario;
import evidencia.logica.clases.Evidencia_Juridicos;
import evidencia.logica.funciones.FCasoPersonaUsuario;
import evidencia.logica.funciones.FEvidencia_Juridicos;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.DefaultRequestContext;
import recursos.Util;

/**
 *
 * @author ruben
 */
@ManagedBean
@ViewScoped
public class ReportesControlador {

    //Datos Para Reportes de Caso Usuario
    private ArrayList<Evidencia_Juridicos> lstEvidenciaJuridicos;
    private ArrayList<Evidencia_Juridicos> filtroEvidenciaJuridicos;

    //Caso
    private ArrayList<CasoPersonaUsuario> lstCPS;
    private ArrayList<CasoPersonaUsuario> filterlstCPS;

    private Date fechaInicio, fechaFin;

    public ReportesControlador() {
        reinit();
    }

    public void reinit() {
        this.lstEvidenciaJuridicos = new ArrayList<Evidencia_Juridicos>();
        this.filtroEvidenciaJuridicos = new ArrayList<Evidencia_Juridicos>();
        this.lstCPS = new ArrayList<CasoPersonaUsuario>();
        this.filterlstCPS = new ArrayList<CasoPersonaUsuario>();
    }

    //<editor-fold defaultstate="collapsed" desc="Listar Casos Registro po Fecha Inicio Fecha Fin" defaultstate="collapsed">
    public void ListarCasoRegistradosFechas() {
        //java.util.Date fechaInicio = new java.util.Date();
        java.sql.Date fechaI = new java.sql.Date(fechaInicio.getTime());

        System.out.println("java.util.Date: " + fechaInicio);
        System.out.println("java.sql.Date.: " + fechaI);

        //java.util.Date fechaFin = new java.util.Date();
        java.sql.Date fechaF = new java.sql.Date(fechaFin.getTime());

        System.out.println("java.util.Date: " + fechaFin);
        System.out.println("java.sql.Date.: " + fechaF);
        try {
            this.lstCPS = FCasoPersonaUsuario.ObtenerCPUdadoCodFechas(fechaI, fechaF);
            this.filterlstCPS = lstCPS;
        } catch (Exception e) {
            System.out.println("error :" + e.getMessage());
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Listar Evidecnias Registro po Fecha Inicio Fecha Fin" defaultstate="collapsed">
    public void ListarEvidenciaRegistradosFechas() {
        //java.util.Date fechaInicio = new java.util.Date();
        java.sql.Date fechaI = new java.sql.Date(fechaInicio.getTime());

        System.out.println("java.util.Date: " + fechaInicio);
        System.out.println("java.sql.Date.: " + fechaI);

        //java.util.Date fechaFin = new java.util.Date();
        java.sql.Date fechaF = new java.sql.Date(fechaFin.getTime());

        System.out.println("java.util.Date: " + fechaFin);
        System.out.println("java.sql.Date.: " + fechaF);
        try {
            this.lstEvidenciaJuridicos = FEvidencia_Juridicos.ObtenerEvidenciadadoCodFechas(fechaI, fechaF);
            this.filtroEvidenciaJuridicos = lstEvidenciaJuridicos;
        } catch (Exception e) {
            System.out.println("error :" + e.getMessage());
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Set y Get" defaultstate="collapsed">
    public ArrayList<Evidencia_Juridicos> getLstEvidenciaJuridicos() {
        return lstEvidenciaJuridicos;
    }

    public void setLstEvidenciaJuridicos(ArrayList<Evidencia_Juridicos> lstEvidenciaJuridicos) {
        this.lstEvidenciaJuridicos = lstEvidenciaJuridicos;
    }

    public ArrayList<Evidencia_Juridicos> getFiltroEvidenciaJuridicos() {
        return filtroEvidenciaJuridicos;
    }

    public void setFiltroEvidenciaJuridicos(ArrayList<Evidencia_Juridicos> filtroEvidenciaJuridicos) {
        this.filtroEvidenciaJuridicos = filtroEvidenciaJuridicos;
    }

    public ArrayList<CasoPersonaUsuario> getLstCPS() {
        return lstCPS;
    }

    public void setLstCPS(ArrayList<CasoPersonaUsuario> lstCPS) {
        this.lstCPS = lstCPS;
    }

    public ArrayList<CasoPersonaUsuario> getFilterlstCPS() {
        return filterlstCPS;
    }

    public void setFilterlstCPS(ArrayList<CasoPersonaUsuario> filterlstCPS) {
        this.filterlstCPS = filterlstCPS;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
//</editor-fold>
}
