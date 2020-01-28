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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import recursos.Util;

/**
 *
 * @author ruben
 */
@ManagedBean
@ViewScoped
public class DepartamentoPersonaUsuarioControlador {

    private ArrayList<DepartamentoPersonaUsuario> lstCPS;
    private ArrayList<DepartamentoPersonaUsuario> lstCaPerUsFil;
    private ArrayList<DepartamentoPersonaUsuario> filterlstCPS;
    private DepartamentoPersonaUsuario cpsSel;
    private ArrayList<DepartamentoPersonaUsuario> cpuSel;

    private String condicion;

    private Archivo_Municipio lstEviJuri;
    private Archivo_Municipio evJuSel;



    public DepartamentoPersonaUsuarioControlador() {
        reinit();
    }

    private void reinit() {
        this.lstCPS = new ArrayList<DepartamentoPersonaUsuario>();
        lstCaPerUsFil = new ArrayList<DepartamentoPersonaUsuario>();
        this.filterlstCPS = new ArrayList<DepartamentoPersonaUsuario>();
        this.cpsSel = new DepartamentoPersonaUsuario();
        this.evJuSel = new Archivo_Municipio();
        this.cargarDepartamentoPersonaUsuarioT();
        this.cargarDepartamentoPersonaUsuario();
        this.cargarEvidecniaDadoCodigoDepartamento();
    }

    public void cargarDepartamentoPersonaUsuarioT() {
        try {
            lstCPS = FDepartamentoPersonaUsuario.obteneTodosDepartamentoPersonaUsuario();
            this.filterlstCPS = lstCPS;
        } catch (Exception e) {
            Util.addErrorMessage(e, "No Existe Registro de Departamentos");
        }
    }

    public void cargarDepartamentoPersonaUsuario() {
        try {
            lstCaPerUsFil = FDepartamentoPersonaUsuario.ObtenerCPUdadoCodInstCedula(condicion);
        } catch (Exception e) {
            Util.addErrorMessage(e, "Ingrese Código Institucional/Cédula");
        }
    }

    public void cargarEvidecniaDadoCodigoDepartamento() {
        //int departamento = 38;
        try {
            evJuSel = FArchivo_Municipio.ObtenerEvidecniaJuridicoDadoCodigoDepartamento(cpsSel.getCodigo_departamento().getCodigo());
        } catch (Exception e) {
            Util.addErrorMessage(e, "No Existe Registro de Departamentos");
        }
    }
  
    public ArrayList<DepartamentoPersonaUsuario> getCpuSel() {
        return cpuSel;
    }

    public void setCpuSel(ArrayList<DepartamentoPersonaUsuario> cpuSel) {
        this.cpuSel = cpuSel;
    }

    public Archivo_Municipio getEvJuSel() {
        return evJuSel;
    }

    public void setEvJuSel(Archivo_Municipio evJuSel) {
        this.evJuSel = evJuSel;
    }

    public ArrayList<DepartamentoPersonaUsuario> getLstCPS() {
        return lstCPS;
    }

    public void setLstCPS(ArrayList<DepartamentoPersonaUsuario> lstCPS) {
        this.lstCPS = lstCPS;
    }

    public DepartamentoPersonaUsuario getCpsSel() {
        return cpsSel;
    }

    public void setCpsSel(DepartamentoPersonaUsuario cpsSel) {
        this.cpsSel = cpsSel;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public Archivo_Municipio getLstEviJuri() {
        return lstEviJuri;
    }

    public void setLstEviJuri(Archivo_Municipio lstEviJuri) {
        this.lstEviJuri = lstEviJuri;
    }

    public ArrayList<DepartamentoPersonaUsuario> getFilterlstCPS() {
        return filterlstCPS;
    }

    public void setFilterlstCPS(ArrayList<DepartamentoPersonaUsuario> filterlstCPS) {
        this.filterlstCPS = filterlstCPS;
    }

    public ArrayList<DepartamentoPersonaUsuario> getLstCaPerUsFil() {
        return lstCaPerUsFil;
    }

    public void setLstCaPerUsFil(ArrayList<DepartamentoPersonaUsuario> lstCaPerUsFil) {
        this.lstCaPerUsFil = lstCaPerUsFil;
    }

}
