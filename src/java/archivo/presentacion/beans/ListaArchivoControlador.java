/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivo.presentacion.beans;

import archivo.logica.clases.Archivo_Municipio;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import recursos.Util;

/**
 *
 * @author RUBENCHO
 */
@ManagedBean
@ViewScoped
public class ListaArchivoControlador {
  private ArrayList<Archivo_Municipio> lstdocumento;
  private Archivo_Municipio selDoc_Aut;
  private String tipo;
  private String cedula;
  private int codigo_documento;
  
  public void ListaArchivoControlador()
  {
    reinit();
  }
  
  private void reinit()
  {
    this.lstdocumento = new ArrayList();
    this.selDoc_Aut = new Archivo_Municipio();
    this.tipo = " ";
    this.cedula = " ";
    cargarDocumentosAutores();
  }
  
  @PostConstruct
  public void posListaArchivoControlador()
  {
    cargarDocumentosAutores();
  }
  
  public ArrayList<Archivo_Municipio> getLstdocumento()
  {
    return this.lstdocumento;
  }
  
  public void setLstdocumento(ArrayList<Archivo_Municipio> lstdocumento)
  {
    this.lstdocumento = lstdocumento;
  }
  
  public Archivo_Municipio getSelDoc_Aut()
  {
    return this.selDoc_Aut;
  }
  
  public void setSelDoc_Aut(Archivo_Municipio selDoc_Aut)
  {
    this.selDoc_Aut = selDoc_Aut;
  }
  
  public String getTipo()
  {
    return this.tipo;
  }
  
  public void setTipo(String tipo)
  {
    this.tipo = tipo;
  }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
  
  public int getCodigo_documento()
  {
    return this.codigo_documento;
  }
  
  public void setCodigo_documento(int codigo_documento)
  {
    this.codigo_documento = codigo_documento;
  }
  
  public void cargarDocumentosAutores()
  {
    try
    {
    //  this.lstdocumento = FDocumento_Autor.obtenerDocumento_Autores();
    }
    catch (Exception e)
    {
      Util.addErrorMessage(e, "Ingrese su cédula para ver sus archivos");
    }
  }
  
  // Documentos x tipo
  public void buscarDucumento()
  {
    try
    {
     // this.lstdocumento = FDocumento_Autor.obtenerDocumento_Autores_Tipo(this.tipo);
    }
    catch (Exception e)
    {
      FacesMessage mensajeErrorIngreso = new FacesMessage(FacesMessage.SEVERITY_FATAL, "No se a Registrado Archivos y Documntos", e.getMessage());
      FacesContext.getCurrentInstance().addMessage(null, mensajeErrorIngreso);
    }
  }
  
    // Documentos x cedula
  public void buscarDucumetoAutorCedula()
  {
    try
    {
//      this.lstdocumento = FDocumento_Autor.obtenerDocumento_Autores_cedula(this.cedula);
    }
    catch (Exception e)
    {
      FacesMessage mensajeErrorIngreso = new FacesMessage(FacesMessage.SEVERITY_FATAL, "No se a Registrado Archivos y Documntos", e.getMessage());
      FacesContext.getCurrentInstance().addMessage(null, mensajeErrorIngreso);
    }
  }
  
}
