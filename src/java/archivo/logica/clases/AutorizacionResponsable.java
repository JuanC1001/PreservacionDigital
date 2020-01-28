/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivo.logica.clases;

import java.sql.Timestamp;
import master.logica.clases.UsuarioRol;

/**
 *
 * @author RUBEN
 */
public class AutorizacionResponsable {

    private int codigo;
    private UsuarioRol codigo_usuario_rol;
    private Persona codigo_persona;
    private String autorizacion_path;
    private Timestamp fecharegistro_autresponsable;

    public AutorizacionResponsable() {
    }

    public AutorizacionResponsable(int codigo, UsuarioRol codigo_usuario_rol, Persona codigo_persona, String autorizacion_path, Timestamp fecharegistro_autresponsable) {
        this.codigo = codigo;
        this.codigo_usuario_rol = codigo_usuario_rol;
        this.codigo_persona = codigo_persona;
        this.autorizacion_path = autorizacion_path;
        this.fecharegistro_autresponsable = fecharegistro_autresponsable;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public UsuarioRol getCodigo_usuario_rol() {
        return codigo_usuario_rol;
    }

    public void setCodigo_usuario_rol(UsuarioRol codigo_usuario_rol) {
        this.codigo_usuario_rol = codigo_usuario_rol;
    }

    public Persona getCodigo_persona() {
        return codigo_persona;
    }

    public void setCodigo_persona(Persona codigo_persona) {
        this.codigo_persona = codigo_persona;
    }

    public String getAutorizacion_path() {
        return autorizacion_path;
    }

    public void setAutorizacion_path(String autorizacion_path) {
        this.autorizacion_path = autorizacion_path;
    }

    public Timestamp getFecharegistro_autresponsable() {
        return fecharegistro_autresponsable;
    }

    public void setFecharegistro_autresponsable(Timestamp fecharegistro_autresponsable) {
        this.fecharegistro_autresponsable = fecharegistro_autresponsable;
    }

   



}
