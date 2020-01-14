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
 * @author RUBEN
 */
public class Entorno_hw_Recojido {

    private int codigo;
    private UsuarioRol codigo_usuario_rol;
    private String tipo;
    private String marca;
    private String modelo;
    private String foto;
    private String observacion;
    private Timestamp fecharegistro_hwreco;

    public Entorno_hw_Recojido() {
    }

    public Entorno_hw_Recojido(int codigo, UsuarioRol codigo_usuario_rol, String tipo, String marca, String modelo, String foto, String observacion, Timestamp fecharegistro_hwreco) {
        this.codigo = codigo;
        this.codigo_usuario_rol = codigo_usuario_rol;
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.foto = foto;
        this.observacion = observacion;
        this.fecharegistro_hwreco = fecharegistro_hwreco;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Timestamp getFecharegistro_hwreco() {
        return fecharegistro_hwreco;
    }

    public void setFecharegistro_hwreco(Timestamp fecharegistro_hwreco) {
        this.fecharegistro_hwreco = fecharegistro_hwreco;
    }

}
