/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivo.presentacion.beans;

import archivo.logica.clases.Auditoria_I_U_D;
import archivo.logica.funciones.FAuditoria_I_U_D;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import recursos.Util;

/**
 *
 * @author RUBEN
 */
@ManagedBean
@ViewScoped
public class Auditoria_I_U_DControlador {
     private ArrayList<Auditoria_I_U_D> lstAuditoria_I_U_D;
     
     public Auditoria_I_U_DControlador (){
     this.lstAuditoria_I_U_D = new ArrayList();
     this.cargarAuditoria_I_U_D();
     }

     // Cargar Auditoria de Insertar Eliminar Actualizar
    public void cargarAuditoria_I_U_D() {
        try {
            lstAuditoria_I_U_D = FAuditoria_I_U_D.obtenerAuditoriaIUD();
        } catch (Exception e) {
            Util.addErrorMessage(e, "No Existe Registro de Auditoria de Insert Update Delete");
        }
    }
     
     
     
     
    public ArrayList<Auditoria_I_U_D> getLstAuditoria_I_U_D() {
        return lstAuditoria_I_U_D;
    }

    public void setLstAuditoria_I_U_D(ArrayList<Auditoria_I_U_D> lstAuditoria_I_U_D) {
        this.lstAuditoria_I_U_D = lstAuditoria_I_U_D;
    }
     
     
     
     
     
}



