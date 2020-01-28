/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivo.logica.clases;

import java.sql.Date;
import java.sql.Timestamp;
import master.logica.clases.UsuarioRol;

/**
 *
 * @author RUBENCHO
 */
public class Documento {
  private int codigo;
  private UsuarioRol codigo_usuario_rol;
  private Metadatos_Documento codigo_metadatos;
  private Tecnicas codigo_tecnicas;
  private String tipo;
  private String titulo;
  private String keywords;
  private String resumen;
  private String path;
  private Timestamp fecha_registro;
  
  public Documento() {}
  
  public Documento(int codigo, UsuarioRol codigo_usuario_rol, Metadatos_Documento codigo_metadatos, Tecnicas codigo_tecnicas, String tipo, String titulo, String keywords, String resumen, String path, Timestamp fecha_registro)
  {
    this.codigo = codigo;
    this.codigo_usuario_rol = codigo_usuario_rol;
    this.codigo_metadatos = codigo_metadatos;
    this.codigo_tecnicas = codigo_tecnicas;
    this.tipo = tipo;
    this.titulo = titulo;
    this.keywords = keywords;
    this.resumen = resumen;
    this.path = path;
    this.fecha_registro = fecha_registro;
  }
  
  public int getCodigo()
  {
    return this.codigo;
  }
  
  public void setCodigo(int codigo)
  {
    this.codigo = codigo;
  }
  
  public UsuarioRol getCodigo_usuario_rol()
  {
    return this.codigo_usuario_rol;
  }
  
  public void setCodigo_usuario_rol(UsuarioRol codigo_usuario_rol)
  {
    this.codigo_usuario_rol = codigo_usuario_rol;
  }
  
  public Metadatos_Documento getCodigo_metadatos()
  {
    return this.codigo_metadatos;
  }
  
  public void setCodigo_metadatos(Metadatos_Documento codigo_metadatos)
  {
    this.codigo_metadatos = codigo_metadatos;
  }
  
  public Tecnicas getCodigo_tecnicas()
  {
    return this.codigo_tecnicas;
  }
  
  public void setCodigo_tecnicas(Tecnicas codigo_tecnicas)
  {
    this.codigo_tecnicas = codigo_tecnicas;
  }
  
  public String getTipo()
  {
    return this.tipo;
  }
  
  public void setTipo(String tipo)
  {
    this.tipo = tipo;
  }
  
  public String getTitulo()
  {
    return this.titulo;
  }
  
  public void setTitulo(String titulo)
  {
    this.titulo = titulo;
  }
  
  public String getKeywords()
  {
    return this.keywords;
  }
  
  public void setKeywords(String keywords)
  {
    this.keywords = keywords;
  }
  
  public String getResumen()
  {
    return this.resumen;
  }
  
  public void setResumen(String resumen)
  {
    this.resumen = resumen;
  }
  
  public String getPath()
  {
    return this.path;
  }
  
  public void setPath(String path)
  {
    this.path = path;
  }
  
  public Timestamp getFecha_registro()
  {
    return this.fecha_registro;
  }
  
  public void setFecha_registro(Timestamp fecha_registro)
  {
    this.fecha_registro = fecha_registro;
  }
}
