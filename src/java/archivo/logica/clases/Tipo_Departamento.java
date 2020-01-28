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
 * @author RUBEN
 */
public class Tipo_Departamento {

    private int codigo;
    private UsuarioRol codigo_usuario_rol;
    private String nombre_tipoDepartamento;
    private String detalle;
    private Date fecha_registro;

    public Tipo_Departamento() {
    }

    public Tipo_Departamento(int codigo, UsuarioRol codigo_usuario_rol, String nombre_tipoDepartamento, String detalle, Date fecha_registro) {
        this.codigo = codigo;
        this.codigo_usuario_rol = codigo_usuario_rol;
        this.nombre_tipoDepartamento = nombre_tipoDepartamento;
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

    public String getNombre_tipoDepartamento() {
        return nombre_tipoDepartamento;
    }

    public void setNombre_tipoDepartamento(String nombre_tipoDepartamento) {
        this.nombre_tipoDepartamento = nombre_tipoDepartamento;
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
