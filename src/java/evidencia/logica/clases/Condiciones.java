/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evidencia.logica.clases;

import master.logica.clases.UsuarioRol;

/**
 *
 * @author RUBEN
 */
public class Condiciones {

    private int codigo;
    private UsuarioRol codigo_usuario_rol;
    private String condicion;
    private String detalle;
    private String path;

    public Condiciones() {
    }

    public Condiciones(int codigo, UsuarioRol codigo_usuario_rol, String condicion, String detalle, String path) {
        this.codigo = codigo;
        this.codigo_usuario_rol = codigo_usuario_rol;
        this.condicion = condicion;
        this.detalle = detalle;
        this.path = path;
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

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    

}
