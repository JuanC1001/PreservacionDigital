/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivo.presentacion.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import archivo.logica.clases.Persona;
import archivo.logica.funciones.FPersona;
import static com.sun.faces.facelets.util.Path.context;
import java.sql.Date;

/**
 *
 * @author RUBENCHO
 */
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import master.logica.clases.UsuarioRol;
import master.presentacion.beans.SesionUsuarioDataManager;
import org.primefaces.context.DefaultRequestContext;
import org.primefaces.context.RequestContext;
import recursos.Util;
//import recursos.utilBeans.ValidacionCedula;

@ManagedBean
@ViewScoped
public class PersonaControlador {
    private Persona objpersona;
    private ArrayList<Persona> lstpersona, lstfilterPersona ;
    private Persona personasel;
    private java.util.Date fechaRegistro;
    @ManagedProperty(value = "#{sesionUsuarioDataManager}")
    private SesionUsuarioDataManager dm;
    boolean todocorrecto = false;
    private String cedula;

    public PersonaControlador() {
        this.reinit();
    }

    private void reinit() {
        lstpersona = new ArrayList<Persona>();
        this.objpersona = new Persona();
        this.personasel = new Persona();
        fechaRegistro = new java.util.Date();
        this.cargarPersonas();
    }

    public Persona getObjpersona() {
        return objpersona;
    }

    public void setObjpersona(Persona objpersona) {
        this.objpersona = objpersona;
    }

    public ArrayList<Persona> getLstpersona() {
        return lstpersona;
    }

    public void setLstpersona(ArrayList<Persona> lstpersona) {
        this.lstpersona = lstpersona;
    }

    public Persona getPersonasel() {
        return personasel;
    }

    public void setPersonasel(Persona personasel) {
        this.personasel = personasel;
    }


    public java.util.Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(java.util.Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public SesionUsuarioDataManager getDm() {
        return dm;
    }

    public void setDm(SesionUsuarioDataManager dm) {
        this.dm = dm;
    }

    public boolean isTodocorrecto() {
        return todocorrecto;
    }

    public void setTodocorrecto(boolean todocorrecto) {
        this.todocorrecto = todocorrecto;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public RequestContext getContext() {
        return context;
    }

    public void setContext(RequestContext context) {
        this.context = context;
    }

    public ArrayList<Persona> getLstfilterPersona() {
        return lstfilterPersona;
    }

    public void setLstfilterPersona(ArrayList<Persona> lstfilterPersona) {
        this.lstfilterPersona = lstfilterPersona;
    }

   
    
    public void cargarPersonas() {
        try {
            lstpersona = FPersona.obtenerPersonas();
            this.lstfilterPersona = lstpersona;
        } catch (Exception e) {
            Util.addErrorMessage(e, "No Existe Registro de Autores");
        }
    }

    public void insertarPersonas() {
        try {
            UsuarioRol us = new UsuarioRol();
            us.setCodigo(dm.getSesionUsuarioRolActual().getCodigo());
            objpersona.setCodigo_usuario_rol(us);
            objpersona.setFecha_registro(new java.sql.Date(this.fechaRegistro.getTime()));

            if (esCedulaValida(cedula) == true) {
                objpersona.setCedula(cedula);

                if (FPersona.insertar(objpersona)) {
                    this.reinit();
                    DefaultRequestContext.getCurrentInstance().execute("dlgInsertarPersonas.hide()");
                this.cargarPersonas();
                this.objpersona = new Persona();
//                Util.addSuccessMessage("Información guardada con éxito");
                    System.out.println("public void insertarAutores dice: Error al guardar la información");
                } else {
                    Util.addSuccessMessage("Error al guardar la información");
                    System.out.println("public void insertarAutores dice: Error al guardar la información");
                }
            } else {
                Util.addSuccessMessage("Número de Cédula Icorrecto");
                cedula = "";
            }

        } catch (Exception e) {
            Util.addErrorMessage("private void insertarAutores dice: " + e.getMessage());
            System.out.println("private void insertarAutores dice: " + e.getMessage());
        }

    }

    public void actualizarPersonas() {
        try {
            // objDocumento.setCodigo_persona(dm.getSesionPersona().getCodigo_titular());

            UsuarioRol us = new UsuarioRol();
            us.setCodigo(dm.getSesionUsuarioRolActual().getCodigo());
            objpersona.setCodigo_usuario_rol(us);
            if (FPersona.actualizar(personasel)) {
                FacesMessage mensajeActualizacion = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Actualizados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeActualizacion);
                DefaultRequestContext.getCurrentInstance().execute("dlgEditarPersonas.hide()");
                this.cargarPersonas();
            } else {
                FacesMessage mensajeErrorActualizacion = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", "Datos no Actualizados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeErrorActualizacion);
            }
        } catch (Exception e) {
            FacesMessage mensajeErrorA = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, mensajeErrorA);
        }
    }

    public void eliminarPersonas() {
        try {
            if (FPersona.eliminar(personasel)) {
                FacesMessage mensajeEliminar = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Eliminados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeEliminar);
                DefaultRequestContext.getCurrentInstance().execute("dlgEliminarPersonas.hide()");
                this.cargarPersonas();
            } else {
                FacesMessage mensajeErrorEliminar = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", "Datos no  Eliminados");
                FacesContext.getCurrentInstance().addMessage(null, mensajeErrorEliminar);
            }
        } catch (Exception e) {
            FacesMessage mensajeErrorE = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, mensajeErrorE);
        }
    }

    //Envío el parámetro a la vista
    RequestContext context = RequestContext.getCurrentInstance();

    //context.addCallbackParam ("datosOK", sonDatosCorrectos);  
    public boolean esCedulaValida(String cedula) {
        //verifica que tenga 10 dígitos y que contenga solo valores numéricos
        if (!((cedula.length() == 10) && cedula.matches("^[0-9]{10}$"))) {
            return false;
        }

        //verifica que los dos primeros dígitos correspondan a un valor entre 1 y NUMERO_DE_PROVINCIAS
        int prov = Integer.parseInt(cedula.substring(0, 2));

        if (!((prov > 0) && (prov <= 24))) {
            return false;
        }

        //verifica que el último dígito de la cédula sea válido
        int[] d = new int[10];

        //Asignamos el string a un array
        for (int i = 0; i < d.length; i++) {
            d[i] = Integer.parseInt(cedula.charAt(i) + "");
        }

        int imp = 0;
        int par = 0;

        //sumamos los duplos de posición impar
        for (int i = 0; i < d.length; i += 2) {
            d[i] = ((d[i] * 2) > 9) ? ((d[i] * 2) - 9) : (d[i] * 2);
            imp += d[i];
        }

        //sumamos los digitos de posición par
        for (int i = 1; i < (d.length - 1); i += 2) {
            par += d[i];
        }

        //Sumamos los dos resultados
        int suma = imp + par;

        //Restamos de la decena superior
        int d10 = Integer.parseInt(String.valueOf(suma + 10).substring(0, 1)
                + "0") - suma;

        //Si es diez el décimo dígito es cero        
        d10 = (d10 == 10) ? 0 : d10;

        //si el décimo dígito calculado es igual al digitado la cédula es correcta
        return d10 == d[9];
    }
}
