/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivo.logica.clases;

import java.sql.Timestamp;

/**
 *
 * @author RUBEN
 */
public class Autorizacion {

    private int codigo;
    private Persona codigo_usuarios;
    private String autorizacion_path;
    private String aceptado;
    private Timestamp fecha_registro;

    public Autorizacion() {
    }

    public Autorizacion(int codigo, Persona codigo_usuarios, String autorizacion_path, String aceptado, Timestamp fecha_registro) {
        this.codigo = codigo;
        this.codigo_usuarios = codigo_usuarios;
        this.autorizacion_path = autorizacion_path;
        this.aceptado = aceptado;
        this.fecha_registro = fecha_registro;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Persona getCodigo_usuarios() {
        return codigo_usuarios;
    }

    public void setCodigo_usuarios(Persona codigo_usuarios) {
        this.codigo_usuarios = codigo_usuarios;
    }

    public String getAutorizacion_path() {
        return autorizacion_path;
    }

    public void setAutorizacion_path(String autorizacion_path) {
        this.autorizacion_path = autorizacion_path;
    }

    public String getAceptado() {
        return aceptado;
    }

    public void setAceptado(String aceptado) {
        this.aceptado = aceptado;
    }

    public Timestamp getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Timestamp fecha_registro) {
        this.fecha_registro = fecha_registro;
    }
    

}
