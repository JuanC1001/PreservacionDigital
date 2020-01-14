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
 * @author ruben
 */
public class DocumentoDisponibilidad {
    private int codigo;
    private UsuarioRol codigo_usuario_rol;
    private String titulo_ducumento;
    private String detalles;
    private String titulo;
    private String path;
    private String tipo;
    private String keywords;
    private Date fecha_registro;

    public DocumentoDisponibilidad() {
    }

    public DocumentoDisponibilidad(int codigo, UsuarioRol codigo_usuario_rol, String titulo_ducumento, String detalles, String titulo, String path, String tipo, String keywords, Date fecha_registro) {
        this.codigo = codigo;
        this.codigo_usuario_rol = codigo_usuario_rol;
        this.titulo_ducumento = titulo_ducumento;
        this.detalles = detalles;
        this.titulo = titulo;
        this.path = path;
        this.tipo = tipo;
        this.keywords = keywords;
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

    public String getTitulo_ducumento() {
        return titulo_ducumento;
    }

    public void setTitulo_ducumento(String titulo_ducumento) {
        this.titulo_ducumento = titulo_ducumento;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }
    
    
}
