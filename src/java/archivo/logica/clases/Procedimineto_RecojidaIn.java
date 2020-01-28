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
 * @author ruben
 */
public class Procedimineto_RecojidaIn {
     private int codigo;
    private UsuarioRol codigo_usuario_rol;
    private String hoja_ruta;
    private String cadena_custudia;
    private String registros;
    private String observacion;
    private Timestamp fecharegistro_procereco;

    public Procedimineto_RecojidaIn() {
    }

    public Procedimineto_RecojidaIn(int codigo, UsuarioRol codigo_usuario_rol, String hoja_ruta, String cadena_custudia, String registros, String observacion, Timestamp fecharegistro_procereco) {
        this.codigo = codigo;
        this.codigo_usuario_rol = codigo_usuario_rol;
        this.hoja_ruta = hoja_ruta;
        this.cadena_custudia = cadena_custudia;
        this.registros = registros;
        this.observacion = observacion;
        this.fecharegistro_procereco = fecharegistro_procereco;
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

    public String getHoja_ruta() {
        return hoja_ruta;
    }

    public void setHoja_ruta(String hoja_ruta) {
        this.hoja_ruta = hoja_ruta;
    }

    public String getCadena_custudia() {
        return cadena_custudia;
    }

    public void setCadena_custudia(String cadena_custudia) {
        this.cadena_custudia = cadena_custudia;
    }

    public String getRegistros() {
        return registros;
    }

    public void setRegistros(String registros) {
        this.registros = registros;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Timestamp getFecharegistro_procereco() {
        return fecharegistro_procereco;
    }

    public void setFecharegistro_procereco(Timestamp fecharegistro_procereco) {
        this.fecharegistro_procereco = fecharegistro_procereco;
    }
    
}
