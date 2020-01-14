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
public class Tipo_Caso {

    private int codigo;
    private UsuarioRol codigo_usuario_rol;
    private String nombre_tipoCaso;
    private String detalle;
    private Date fecha_registro;

    public Tipo_Caso() {
    }

    public Tipo_Caso(int codigo, UsuarioRol codigo_usuario_rol, String nombre_tipoCaso, String detalle, Date fecha_registro) {
        this.codigo = codigo;
        this.codigo_usuario_rol = codigo_usuario_rol;
        this.nombre_tipoCaso = nombre_tipoCaso;
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

    public String getNombre_tipoCaso() {
        return nombre_tipoCaso;
    }

    public void setNombre_tipoCaso(String nombre_tipoCaso) {
        this.nombre_tipoCaso = nombre_tipoCaso;
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
