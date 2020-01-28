/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivo.logica.clases;
import master.logica.clases.UsuarioRol;
/**
 *
 * @author RUBEN
 */
public class Documento_Usuario_Rol {
  private int codigo;
  private Documento codigo_documento;
  private UsuarioRol usuario_rol;

    public Documento_Usuario_Rol() {
    }

    public Documento_Usuario_Rol(int codigo, Documento codigo_documento, UsuarioRol usuario_rol) {
        this.codigo = codigo;
        this.codigo_documento = codigo_documento;
        this.usuario_rol = usuario_rol;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Documento getCodigo_documento() {
        return codigo_documento;
    }

    public void setCodigo_documento(Documento codigo_documento) {
        this.codigo_documento = codigo_documento;
    }

    public UsuarioRol getUsuario_rol() {
        return usuario_rol;
    }

    public void setUsuario_rol(UsuarioRol usuario_rol) {
        this.usuario_rol = usuario_rol;
    }
  
  
}
