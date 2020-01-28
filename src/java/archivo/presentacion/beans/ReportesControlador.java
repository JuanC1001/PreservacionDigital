/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivo.presentacion.beans;

import archivo.logica.clases.DepartamentoPersonaUsuario;
import archivo.logica.clases.Archivo_Municipio;
import archivo.logica.funciones.FDepartamentoPersonaUsuario;
import archivo.logica.funciones.FArchivo_Municipio;
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

    //Datos Para Reportes de Departamento Usuario
    private ArrayList<Archivo_Municipio> lstArchivoMunicipio;
    private ArrayList<Archivo_Municipio> filtroArchivoMunicipio;

    //Departamento
    private ArrayList<DepartamentoPersonaUsuario> lstCPS;
    private ArrayList<DepartamentoPersonaUsuario> filterlstCPS;

    private Date fechaInicio, fechaFin;

    public ReportesControlador() {
        reinit();
    }

    public void reinit() {
        this.lstArchivoMunicipio = new ArrayList<Archivo_Municipio>();
        this.filtroArchivoMunicipio = new ArrayList<Archivo_Municipio>();
        this.lstCPS = new ArrayList<DepartamentoPersonaUsuario>();
        this.filterlstCPS = new ArrayList<DepartamentoPersonaUsuario>();
    }

    //<editor-fold defaultstate="collapsed" desc="Listar Departamentos Registro po Fecha Inicio Fecha Fin" defaultstate="collapsed">
    public void ListarDepartamentoRegistradosFechas() {
        //java.util.Date fechaInicio = new java.util.Date();
        java.sql.Date fechaI = new java.sql.Date(fechaInicio.getTime());

        System.out.println("java.util.Date: " + fechaInicio);
        System.out.println("java.sql.Date.: " + fechaI);

        //java.util.Date fechaFin = new java.util.Date();
        java.sql.Date fechaF = new java.sql.Date(fechaFin.getTime());

        System.out.println("java.util.Date: " + fechaFin);
        System.out.println("java.sql.Date.: " + fechaF);
        try {
            this.lstCPS = FDepartamentoPersonaUsuario.ObtenerCPUdadoCodFechas(fechaI, fechaF);
            this.filterlstCPS = lstCPS;
        } catch (Exception e) {
            System.out.println("error :" + e.getMessage());
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Listar Evidecnias Registro po Fecha Inicio Fecha Fin" defaultstate="collapsed">
    public void ListarArchivoRegistradosFechas() {
        //java.util.Date fechaInicio = new java.util.Date();
        java.sql.Date fechaI = new java.sql.Date(fechaInicio.getTime());

        System.out.println("java.util.Date: " + fechaInicio);
        System.out.println("java.sql.Date.: " + fechaI);

        //java.util.Date fechaFin = new java.util.Date();
        java.sql.Date fechaF = new java.sql.Date(fechaFin.getTime());

        System.out.println("java.util.Date: " + fechaFin);
        System.out.println("java.sql.Date.: " + fechaF);
        try {
            this.lstArchivoMunicipio = FArchivo_Municipio.ObtenerArchivodadoCodFechas(fechaI, fechaF);
            this.filtroArchivoMunicipio = lstArchivoMunicipio;
        } catch (Exception e) {
            System.out.println("error :" + e.getMessage());
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Set y Get" defaultstate="collapsed">
    public ArrayList<Archivo_Municipio> getLstArchivoMunicipio() {
        return lstArchivoMunicipio;
    }

    public void setLstArchivoMunicipio(ArrayList<Archivo_Municipio> lstArchivoMunicipio) {
        this.lstArchivoMunicipio = lstArchivoMunicipio;
    }

    public ArrayList<Archivo_Municipio> getFiltroArchivoMunicipio() {
        return filtroArchivoMunicipio;
    }

    public void setFiltroArchivoMunicipio(ArrayList<Archivo_Municipio> filtroArchivoMunicipio) {
        this.filtroArchivoMunicipio = filtroArchivoMunicipio;
    }

    public ArrayList<DepartamentoPersonaUsuario> getLstCPS() {
        return lstCPS;
    }

    public void setLstCPS(ArrayList<DepartamentoPersonaUsuario> lstCPS) {
        this.lstCPS = lstCPS;
    }

    public ArrayList<DepartamentoPersonaUsuario> getFilterlstCPS() {
        return filterlstCPS;
    }

    public void setFilterlstCPS(ArrayList<DepartamentoPersonaUsuario> filterlstCPS) {
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
