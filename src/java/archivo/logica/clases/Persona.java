/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivo.logica.clases;

import java.sql.Date;
import master.logica.clases.UsuarioRol;

/**
 *
 * @author RUBENCHO
 */
public class Persona {

    private int codigo;
    private UsuarioRol codigo_usuario_rol;
    private String apellidos;
    private String nombres;
    private String cedula;
    private String mail;
    private Date fecha_registro;
    private boolean selected;

    public Persona() {
    }

    public Persona(int codigo, UsuarioRol codigo_usuario_rol, String apellidos, String nombres, String cedula, String mail, Date fecha_registro) {
        this.codigo = codigo;
        this.codigo_usuario_rol = codigo_usuario_rol;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.cedula = cedula;
        this.mail = mail;
        this.fecha_registro = fecha_registro;
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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    
}
