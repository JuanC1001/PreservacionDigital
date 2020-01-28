/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivo.logica.clases;

import java.sql.Date;
import java.sql.Timestamp;
import master.logica.clases.UsuarioRol;

/**
 *
 * @author RUBENCHO
 */
public class IncrementoArchivos_Municipio {

    private int codigo;
    private String numero_incremento;
    private UsuarioRol codigo_usuario_rol;
    private Archivo_Municipio codigo_archivos;
    private Entorno_sw_RecojidoIn codigo_entorno_sw_recogido;
    private Entorno_hw_RecojidoIn codigo_entorno_hw_recogido;
    private Procedimineto_RecojidaIn codigo_procedimiento_recojida;
    private MetadatosIn codigo_metadatos;
    private TecnicasIn codigo_tecnicas;
    private Detalle_ArchivoIn codigo_detalle_archivo;
    private Date fecha_registro;

    public IncrementoArchivos_Municipio() {
    }

    public IncrementoArchivos_Municipio(int codigo, String numero_incremento, UsuarioRol codigo_usuario_rol, Archivo_Municipio codigo_archivos, Entorno_sw_RecojidoIn codigo_entorno_sw_recogido, Entorno_hw_RecojidoIn codigo_entorno_hw_recogido, Procedimineto_RecojidaIn codigo_procedimiento_recojida, MetadatosIn codigo_metadatos, TecnicasIn codigo_tecnicas, Detalle_ArchivoIn codigo_detalle_archivo, Date fecha_registro) {
        this.codigo = codigo;
        this.numero_incremento = numero_incremento;
        this.codigo_usuario_rol = codigo_usuario_rol;
        this.codigo_archivos = codigo_archivos;
        this.codigo_entorno_sw_recogido = codigo_entorno_sw_recogido;
        this.codigo_entorno_hw_recogido = codigo_entorno_hw_recogido;
        this.codigo_procedimiento_recojida = codigo_procedimiento_recojida;
        this.codigo_metadatos = codigo_metadatos;
        this.codigo_tecnicas = codigo_tecnicas;
        this.codigo_detalle_archivo = codigo_detalle_archivo;
        this.fecha_registro = fecha_registro;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNumero_incremento() {
        return numero_incremento;
    }

    public void setNumero_incremento(String numero_incremento) {
        this.numero_incremento = numero_incremento;
    }

    public UsuarioRol getCodigo_usuario_rol() {
        return codigo_usuario_rol;
    }

    public void setCodigo_usuario_rol(UsuarioRol codigo_usuario_rol) {
        this.codigo_usuario_rol = codigo_usuario_rol;
    }

    public Archivo_Municipio getCodigo_archivos() {
        return codigo_archivos;
    }

    public void setCodigo_archivos(Archivo_Municipio codigo_archivos) {
        this.codigo_archivos = codigo_archivos;
    }

    public Entorno_sw_RecojidoIn getCodigo_entorno_sw_recogido() {
        return codigo_entorno_sw_recogido;
    }

    public void setCodigo_entorno_sw_recogido(Entorno_sw_RecojidoIn codigo_entorno_sw_recogido) {
        this.codigo_entorno_sw_recogido = codigo_entorno_sw_recogido;
    }

    public Entorno_hw_RecojidoIn getCodigo_entorno_hw_recogido() {
        return codigo_entorno_hw_recogido;
    }

    public void setCodigo_entorno_hw_recogido(Entorno_hw_RecojidoIn codigo_entorno_hw_recogido) {
        this.codigo_entorno_hw_recogido = codigo_entorno_hw_recogido;
    }

    public Procedimineto_RecojidaIn getCodigo_procedimiento_recojida() {
        return codigo_procedimiento_recojida;
    }

    public void setCodigo_procedimiento_recojida(Procedimineto_RecojidaIn codigo_procedimiento_recojida) {
        this.codigo_procedimiento_recojida = codigo_procedimiento_recojida;
    }

    public MetadatosIn getCodigo_metadatos() {
        return codigo_metadatos;
    }

    public void setCodigo_metadatos(MetadatosIn codigo_metadatos) {
        this.codigo_metadatos = codigo_metadatos;
    }

    public TecnicasIn getCodigo_tecnicas() {
        return codigo_tecnicas;
    }

    public void setCodigo_tecnicas(TecnicasIn codigo_tecnicas) {
        this.codigo_tecnicas = codigo_tecnicas;
    }

    public Detalle_ArchivoIn getCodigo_detalle_archivo() {
        return codigo_detalle_archivo;
    }

    public void setCodigo_detalle_archivo(Detalle_ArchivoIn codigo_detalle_archivo) {
        this.codigo_detalle_archivo = codigo_detalle_archivo;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

 
}
