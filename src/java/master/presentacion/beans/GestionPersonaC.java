/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package master.presentacion.beans;

import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import master.logica.clases.Persona;
import master.logica.funciones.FPersona;
import org.primefaces.context.DefaultRequestContext;
import recursos.Util;
/**
 *
 * @author icits
 */
@ManagedBean
@ViewScoped
public class GestionPersonaC {
  private ArrayList<Persona> lstPersonas;
  private Persona objPersona;
  private Persona personaSel;

    public GestionPersonaC() {
     this.cargarPersonas();
     this.objPersona = new Persona();
        
    }

    public ArrayList<Persona> getLstPersonas() {
        return lstPersonas;
    }

    public void setLstPersonas(ArrayList<Persona> lstPersonas) {
        this.lstPersonas = lstPersonas;
    }

    public Persona getObjPersona() {
        return objPersona;
    }

    public void setObjPersona(Persona objPersona) {
        this.objPersona = objPersona;
    }

    public Persona getPersonaSel() {
        return personaSel;
    }

    public void setPersonaSel(Persona personaSel) {
        this.personaSel = personaSel;
    }
  public void cargarPersonas(){
      try {
          this.lstPersonas = FPersona.obtenerTodasPersonas();
      } catch (Exception e) {
          Util.addErrorMessage(e,"Error al acceder a la base de datos");
      }
  }
  public void insertarPersona(){
              try {
            objPersona.setCodigo_global(0);
            if (FPersona.insertar(objPersona) == true) {
                
            FacesMessage mensaje=new FacesMessage(FacesMessage.SEVERITY_INFO,"Correcto", "Datos Insertados");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
            DefaultRequestContext.getCurrentInstance().execute("wdlgAgregarPersona.hide()");  
            this.cargarPersonas();
            this.objPersona = new Persona();
            } else {
                FacesMessage mensajeError=new FacesMessage(FacesMessage.SEVERITY_ERROR,"Atención", "Datos no se Insertó");
                FacesContext.getCurrentInstance().addMessage(null, mensajeError);
            }
        } catch (Exception e) {
             FacesMessage mensajeErrorIngreso=new FacesMessage(FacesMessage.SEVERITY_FATAL,"Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, mensajeErrorIngreso);
        }      
  }
  
   public void actualizarPersona (){
     try {
         personaSel.setCodigo_global(0);
         if (FPersona.actualizar(personaSel)) {
               FacesMessage mensajeActualizacion=new FacesMessage(FacesMessage.SEVERITY_INFO,"Correcto", "Datos Actualizados");
                FacesContext.getCurrentInstance().addMessage(null,mensajeActualizacion);
                DefaultRequestContext.getCurrentInstance().execute("wdlgEditarPersona.hide()");             
         } else {
              FacesMessage mensajeErrorActualizacion=new FacesMessage(FacesMessage.SEVERITY_ERROR,"Atención", "Datos no Actualizados");
             FacesContext.getCurrentInstance().addMessage(null, mensajeErrorActualizacion);
         }
         
     } catch (Exception e) {
          FacesMessage mensajeErrorA=new FacesMessage(FacesMessage.SEVERITY_FATAL,"Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, mensajeErrorA);
     }           
} 

   public void eliminarPersona (){
    try {
        if (FPersona.eliminar(personaSel.getCodigo_persona())) {       
          FacesMessage mensajeEliminar=new FacesMessage(FacesMessage.SEVERITY_INFO,"Correcto", "Datos Eliminados");
          FacesContext.getCurrentInstance().addMessage(null,mensajeEliminar);
          DefaultRequestContext.getCurrentInstance().execute("wdlgEliminarPersona.hide()");
          this.cargarPersonas();
            
        } else {
             FacesMessage mensajeErrorEliminar=new FacesMessage(FacesMessage.SEVERITY_ERROR,"Atención", "Datos no se Eliminó");
             FacesContext.getCurrentInstance().addMessage(null, mensajeErrorEliminar);            
        }
    } catch (Exception e) {
           FacesMessage mensajeErrorE=new FacesMessage(FacesMessage.SEVERITY_FATAL,"Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, mensajeErrorE);
    }     
}   
}//Cierrala clase

