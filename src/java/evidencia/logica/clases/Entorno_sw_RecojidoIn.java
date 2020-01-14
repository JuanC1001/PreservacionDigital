/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evidencia.logica.clases;

import java.sql.Timestamp;
import master.logica.clases.UsuarioRol;

/**
 *
 * @author ruben
 */
public class Entorno_sw_RecojidoIn {
    private int codigo;
      private UsuarioRol codigo_usuario_rol;
    private String nombre;
    private String ver_sion;
    private String sw_base;
    private String sw_aplicacion;
    private String observacion;
    private Timestamp fecharegistro_entornoswreco;

    public Entorno_sw_RecojidoIn() {
    }

    public Entorno_sw_RecojidoIn(int codigo, UsuarioRol codigo_usuario_rol, String nombre, String ver_sion, String sw_base, String sw_aplicacion, String observacion, Timestamp fecharegistro_entornoswreco) {
        this.codigo = codigo;
        this.codigo_usuario_rol = codigo_usuario_rol;
        this.nombre = nombre;
        this.ver_sion = ver_sion;
        this.sw_base = sw_base;
        this.sw_aplicacion = sw_aplicacion;
        this.observacion = observacion;
        this.fecharegistro_entornoswreco = fecharegistro_entornoswreco;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getVer_sion() {
        return ver_sion;
    }

    public void setVer_sion(String ver_sion) {
        this.ver_sion = ver_sion;
    }

    public String getSw_base() {
        return sw_base;
    }

    public void setSw_base(String sw_base) {
        this.sw_base = sw_base;
    }

    public String getSw_aplicacion() {
        return sw_aplicacion;
    }

    public void setSw_aplicacion(String sw_aplicacion) {
        this.sw_aplicacion = sw_aplicacion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Timestamp getFecharegistro_entornoswreco() {
        return fecharegistro_entornoswreco;
    }

    public void setFecharegistro_entornoswreco(Timestamp fecharegistro_entornoswreco) {
        this.fecharegistro_entornoswreco = fecharegistro_entornoswreco;
    }
    
}
