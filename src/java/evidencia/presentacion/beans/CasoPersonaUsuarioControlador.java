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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import recursos.Util;

/**
 *
 * @author ruben
 */
@ManagedBean
@ViewScoped
public class CasoPersonaUsuarioControlador {

    private ArrayList<CasoPersonaUsuario> lstCPS;
    private ArrayList<CasoPersonaUsuario> lstCaPerUsFil;
    private ArrayList<CasoPersonaUsuario> filterlstCPS;
    private CasoPersonaUsuario cpsSel;
    private ArrayList<CasoPersonaUsuario> cpuSel;

    private String condicion;

    private Evidencia_Juridicos lstEviJuri;
    private Evidencia_Juridicos evJuSel;



    public CasoPersonaUsuarioControlador() {
        reinit();
    }

    private void reinit() {
        this.lstCPS = new ArrayList<CasoPersonaUsuario>();
        lstCaPerUsFil = new ArrayList<CasoPersonaUsuario>();
        this.filterlstCPS = new ArrayList<CasoPersonaUsuario>();
        this.cpsSel = new CasoPersonaUsuario();
        this.evJuSel = new Evidencia_Juridicos();
        this.cargarCasoPersonaUsuarioT();
        this.cargarCasoPersonaUsuario();
        this.cargarEvidecniaDadoCodigoCaso();
    }

    public void cargarCasoPersonaUsuarioT() {
        try {
            lstCPS = FCasoPersonaUsuario.obteneTodosCasoPersonaUsuario();
            this.filterlstCPS = lstCPS;
        } catch (Exception e) {
            Util.addErrorMessage(e, "No Existe Registro de Casos");
        }
    }

    public void cargarCasoPersonaUsuario() {
        try {
            lstCaPerUsFil = FCasoPersonaUsuario.ObtenerCPUdadoCodInstCedula(condicion);
        } catch (Exception e) {
            Util.addErrorMessage(e, "Ingrese Código Institucional/Cédula");
        }
    }

    public void cargarEvidecniaDadoCodigoCaso() {
        //int caso = 38;
        try {
            evJuSel = FEvidencia_Juridicos.ObtenerEvidecniaJuridicoDadoCodigoCaso(cpsSel.getCodigo_caso().getCodigo());
        } catch (Exception e) {
            Util.addErrorMessage(e, "No Existe Registro de Casos");
        }
    }
  
    public ArrayList<CasoPersonaUsuario> getCpuSel() {
        return cpuSel;
    }

    public void setCpuSel(ArrayList<CasoPersonaUsuario> cpuSel) {
        this.cpuSel = cpuSel;
    }

    public Evidencia_Juridicos getEvJuSel() {
        return evJuSel;
    }

    public void setEvJuSel(Evidencia_Juridicos evJuSel) {
        this.evJuSel = evJuSel;
    }

    public ArrayList<CasoPersonaUsuario> getLstCPS() {
        return lstCPS;
    }

    public void setLstCPS(ArrayList<CasoPersonaUsuario> lstCPS) {
        this.lstCPS = lstCPS;
    }

    public CasoPersonaUsuario getCpsSel() {
        return cpsSel;
    }

    public void setCpsSel(CasoPersonaUsuario cpsSel) {
        this.cpsSel = cpsSel;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public Evidencia_Juridicos getLstEviJuri() {
        return lstEviJuri;
    }

    public void setLstEviJuri(Evidencia_Juridicos lstEviJuri) {
        this.lstEviJuri = lstEviJuri;
    }

    public ArrayList<CasoPersonaUsuario> getFilterlstCPS() {
        return filterlstCPS;
    }

    public void setFilterlstCPS(ArrayList<CasoPersonaUsuario> filterlstCPS) {
        this.filterlstCPS = filterlstCPS;
    }

    public ArrayList<CasoPersonaUsuario> getLstCaPerUsFil() {
        return lstCaPerUsFil;
    }

    public void setLstCaPerUsFil(ArrayList<CasoPersonaUsuario> lstCaPerUsFil) {
        this.lstCaPerUsFil = lstCaPerUsFil;
    }

}
