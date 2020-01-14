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
import master.logica.clases.Grupo_Menus;
import master.logica.clases.Modulo;
import master.logica.clases.ModuloGrupoMenu;
import master.logica.funciones.FGrupo_Menus;
import master.logica.funciones.FModulo;
import master.logica.funciones.FModuloGrupoMenu;
import org.primefaces.context.DefaultRequestContext;
/**
 *
 * @author icits
 */
@ManagedBean
@ViewScoped
public class ModuloGrupoMenuC {
    private ArrayList<Modulo> lstModulo;
    private ArrayList<Grupo_Menus> lstGrupoMenus;
    private ArrayList<ModuloGrupoMenu> lstModuloGrupoMenu;
    private ModuloGrupoMenu moduloGrupoMenu;
    private ModuloGrupoMenu moduloGrupoMenuSel;
    private Modulo moduloSel;
    private Grupo_Menus grupoMenusSel;
    private int estadoSel;

    public ModuloGrupoMenuC() {
    this.cargarModuloGrupoMenu();
    this.cargarModulo();
    this.cargarGrupoMenus();
    this.moduloSel = new Modulo();
    this.grupoMenusSel = new Grupo_Menus();
    this.moduloGrupoMenuSel = new ModuloGrupoMenu(0, new Modulo(), new Grupo_Menus(), 0 );
    this.estadoSel = -1;
    
    }

    public ArrayList<Modulo> getLstModulo() {
        return lstModulo;
    }

    public void setLstModulo(ArrayList<Modulo> lstModulo) {
        this.lstModulo = lstModulo;
    }

    public ArrayList<Grupo_Menus> getLstGrupoMenus() {
        return lstGrupoMenus;
    }

    public void setLstGrupoMenus(ArrayList<Grupo_Menus> lstGrupoMenus) {
        this.lstGrupoMenus = lstGrupoMenus;
    }

    public ArrayList<ModuloGrupoMenu> getLstModuloGrupoMenu() {
        return lstModuloGrupoMenu;
    }

    public void setLstModuloGrupoMenu(ArrayList<ModuloGrupoMenu> lstModuloGrupoMenu) {
        this.lstModuloGrupoMenu = lstModuloGrupoMenu;
    }

    public ModuloGrupoMenu getModuloGrupoMenu() {
        return moduloGrupoMenu;
    }

    public void setModuloGrupoMenu(ModuloGrupoMenu moduloGrupoMenu) {
        this.moduloGrupoMenu = moduloGrupoMenu;
    }

    public ModuloGrupoMenu getModuloGrupoMenuSel() {
        return moduloGrupoMenuSel;
    }
    public void setModuloGrupoMenuSel(ModuloGrupoMenu moduloGrupoMenuSel) {
        this.moduloGrupoMenuSel = moduloGrupoMenuSel;
    }

    public Modulo getModuloSel() {
        return moduloSel;
    }

    public void setModuloSel(Modulo moduloSel) {
        this.moduloSel = moduloSel;
    }

    public Grupo_Menus getGrupoMenusSel() {
        return grupoMenusSel;
    }

    public void setGrupoMenusSel(Grupo_Menus grupoMenusSel) {
        this.grupoMenusSel = grupoMenusSel;
    }

    public int getEstadoSel() {
        return estadoSel;
    }

    public void setEstadoSel(int estadoSel) {
        this.estadoSel = estadoSel;
    }
     
    public void cargarModuloGrupoMenu(){
        try {
            lstModuloGrupoMenu= FModuloGrupoMenu.obtenerTodosModuloGrupoMenu();
        } catch (Exception e) {
            FacesMessage mensajeErrorE=new FacesMessage(FacesMessage.SEVERITY_FATAL,"Error", e.getMessage()); 
            FacesContext.getCurrentInstance().addMessage(null, mensajeErrorE);
        }
    }
    public void cargarModulo(){
        try {
            lstModulo= FModulo.ObtenerModulos();
        } catch (Exception e) {
            FacesMessage mensajeErrorE=new FacesMessage(FacesMessage.SEVERITY_FATAL,"Error", e.getMessage()); 
            FacesContext.getCurrentInstance().addMessage(null, mensajeErrorE);
        }
    }
    public void cargarGrupoMenus(){
        try {
            lstGrupoMenus= FGrupo_Menus.ObtenerGruposMenus();
        } catch (Exception e) {
            FacesMessage mensajeErrorE=new FacesMessage(FacesMessage.SEVERITY_FATAL,"Error", e.getMessage()); 
            FacesContext.getCurrentInstance().addMessage(null, mensajeErrorE);
        }
    }
   
public void insertarModuloGrupoMenu(){
     try {
         moduloGrupoMenu = new ModuloGrupoMenu();
         moduloGrupoMenu.setCodigo_modulo(FModulo.ObtenerModuloDadoCodigo(moduloSel.getCodigo()));
         moduloGrupoMenu.setCodigo_grupo_menu(FGrupo_Menus.ObtenerGrupoMenuDadoCodigo(grupoMenusSel.getCodigo()));
         moduloGrupoMenu.setEstado(estadoSel);
         if (FModuloGrupoMenu.insertar(moduloGrupoMenu)) { //Falta el insertarModuloGrupoMenu
             FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO,"Correcto","Datos Insertados...!");
                FacesContext.getCurrentInstance().addMessage(null, mensaje);
                DefaultRequestContext.getCurrentInstance().execute("dlgAgregarModuloGrupoMenu.hide()");
                this.cargarModuloGrupoMenu();
                this.moduloGrupoMenu = new ModuloGrupoMenu();
            
         } else {
            FacesMessage mensajeError = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Incorrecto","Los datos no han sido Insertados...!");
                FacesContext.getCurrentInstance().addMessage(null, mensajeError); 
         }
                 
     } catch (Exception e) {
            FacesMessage mensajeErrorIngreso=new FacesMessage(FacesMessage.SEVERITY_FATAL,"Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, mensajeErrorIngreso);
     }     
 }    

 public void actualizarModuloGrupoMenu(){
     try {        
         moduloGrupoMenuSel.setCodigo_modulo(FModulo.ObtenerModuloDadoCodigo(moduloGrupoMenuSel.getCodigo_modulo().getCodigo()));
         moduloGrupoMenuSel.setCodigo_grupo_menu(FGrupo_Menus.ObtenerGrupoMenuDadoCodigo(moduloGrupoMenuSel.getCodigo_grupo_menu().getCodigo()));
         moduloGrupoMenuSel.setEstado(moduloGrupoMenuSel.getEstado());
         if (FModuloGrupoMenu.actualizar(moduloGrupoMenuSel)) {
              FacesMessage mensaje=new FacesMessage(FacesMessage.SEVERITY_INFO,"Correcto", "Datos Actualizados");
                FacesContext.getCurrentInstance().addMessage(null, mensaje);
                DefaultRequestContext.getCurrentInstance().execute("dlgEditarModuloGrupoMenu.hide()");
                this.cargarGrupoMenus();
                moduloGrupoMenuSel=new ModuloGrupoMenu();
                moduloSel= new Modulo();
                grupoMenusSel =new Grupo_Menus();
                estadoSel =-1;
         } else {
              FacesMessage mensajeError=new FacesMessage(FacesMessage.SEVERITY_ERROR,"Atención", "Datos no se Actualizó");
                FacesContext.getCurrentInstance().addMessage(null, mensajeError);
         }
     } catch (Exception e) {
            FacesMessage mensajeErrorIngreso=new FacesMessage(FacesMessage.SEVERITY_FATAL,"Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, mensajeErrorIngreso);
     }
     
 }
 
public void eliminarModuloGrupoMenu(){
    try {
        if (FModuloGrupoMenu.eliminar(moduloGrupoMenuSel)) {
             FacesMessage mensaje=new FacesMessage(FacesMessage.SEVERITY_INFO,"Correcto", "Datos Eliminados");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
                DefaultRequestContext.getCurrentInstance().execute("dlgEliminarModuloGrupoMenu.hide()");
                this.cargarGrupoMenus();
                moduloGrupoMenuSel=new ModuloGrupoMenu();
        } else {
            FacesMessage mensajeError=new FacesMessage(FacesMessage.SEVERITY_ERROR,"Atención", "Datos no Eliminados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeError);
        }
    } catch (Exception e) {
        FacesMessage mensajeErrorEliminar=new FacesMessage(FacesMessage.SEVERITY_FATAL,"Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, mensajeErrorEliminar);
    }
}
}
