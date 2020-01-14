/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evidencia.logica.clases;

import java.sql.Date;
import master.logica.clases.UsuarioRol;

/**
 *
 * @author RUBEN
 */
public class Dependencia {
    private int codigo;
    private UsuarioRol codigo_usuario_rol;
    private String nombre_dependencia;
    private String detalle;
    private Date fecha_registro;

    public Dependencia() {
    }

    public Dependencia(int codigo, UsuarioRol codigo_usuario_rol, String nombre_dependencia, String detalle, Date fecha_registro) {
        this.codigo = codigo;
        this.codigo_usuario_rol = codigo_usuario_rol;
        this.nombre_dependencia = nombre_dependencia;
        this.detalle = detalle;
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

    public String getNombre_dependencia() {
        return nombre_dependencia;
    }

    public void setNombre_dependencia(String nombre_dependencia) {
        this.nombre_dependencia = nombre_dependencia;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }
    
}
