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
public class Detalle_ArchivoIn {
    private int codigo;
    private UsuarioRol codigo_usuario_rol ;
    private String tipo_archivo;
    private String titulo;
    private String nombre_responsable_reco;
    private String fuete;
    private String resumen_contexto_recojido;
    private String resumen_contexto_contenido;
    private String path;
    private Timestamp fecharegistro_detalles;

    public Detalle_ArchivoIn() {
    }

    public Detalle_ArchivoIn(int codigo, UsuarioRol codigo_usuario_rol, String tipo_archivo, String titulo, String nombre_responsable_reco, String fuete, String resumen_contexto_recojido, String resumen_contexto_contenido, String path, Timestamp fecharegistro_detalles) {
        this.codigo = codigo;
        this.codigo_usuario_rol = codigo_usuario_rol;
        this.tipo_archivo = tipo_archivo;
        this.titulo = titulo;
        this.nombre_responsable_reco = nombre_responsable_reco;
        this.fuete = fuete;
        this.resumen_contexto_recojido = resumen_contexto_recojido;
        this.resumen_contexto_contenido = resumen_contexto_contenido;
        this.path = path;
        this.fecharegistro_detalles = fecharegistro_detalles;
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

    public String getTipo_archivo() {
        return tipo_archivo;
    }

    public void setTipo_archivo(String tipo_archivo) {
        this.tipo_archivo = tipo_archivo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNombre_responsable_reco() {
        return nombre_responsable_reco;
    }

    public void setNombre_responsable_reco(String nombre_responsable_reco) {
        this.nombre_responsable_reco = nombre_responsable_reco;
    }

    public String getFuete() {
        return fuete;
    }

    public void setFuete(String fuete) {
        this.fuete = fuete;
    }

    public String getResumen_contexto_recojido() {
        return resumen_contexto_recojido;
    }

    public void setResumen_contexto_recojido(String resumen_contexto_recojido) {
        this.resumen_contexto_recojido = resumen_contexto_recojido;
    }

    public String getResumen_contexto_contenido() {
        return resumen_contexto_contenido;
    }

    public void setResumen_contexto_contenido(String resumen_contexto_contenido) {
        this.resumen_contexto_contenido = resumen_contexto_contenido;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Timestamp getFecharegistro_detalles() {
        return fecharegistro_detalles;
    }

    public void setFecharegistro_detalles(Timestamp fecharegistro_detalles) {
        this.fecharegistro_detalles = fecharegistro_detalles;
    }
    
    
}
