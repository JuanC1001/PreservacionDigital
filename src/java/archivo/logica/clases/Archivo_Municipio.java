/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivo.logica.clases;
import java.util.Date;

/**
 *
 * @author RUBEN
 */
public class Archivo_Municipio {

    private int codigo;
    private Departamento codigo_departamento;
    private AutorizacionResponsable codigo_autorizacion_responsable;
    private Entorno_sw_Recojido codigo_entorno_sw_recogido;
    private Entorno_hw_Recojido codigo_entorno_hw_recogido;
    private Procedimineto_Recojida codigo_procedimiento_recojida;
    private Metadatos codigo_metadatos;
    private Tecnicas codigo_tecnicas;
    private Detalle_Archivo codigo_detalle_archivo;
    private Date fecha_registro;

    public Archivo_Municipio() {
    }

    public Archivo_Municipio(int codigo, Departamento codigo_departamento, AutorizacionResponsable codigo_autorizacion_responsable, Entorno_sw_Recojido codigo_entorno_sw_recogido, Entorno_hw_Recojido codigo_entorno_hw_recogido, Procedimineto_Recojida codigo_procedimiento_recojida, Metadatos codigo_metadatos, Tecnicas codigo_tecnicas, Detalle_Archivo codigo_detalle_archivo, Date fecha_registro) {
        this.codigo = codigo;
        this.codigo_departamento = codigo_departamento;
        this.codigo_autorizacion_responsable = codigo_autorizacion_responsable;
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

    public Departamento getCodigo_departamento() {
        return codigo_departamento;
    }

    public void setCodigo_departamento(Departamento codigo_departamento) {
        this.codigo_departamento = codigo_departamento;
    }

    public AutorizacionResponsable getCodigo_autorizacion_responsable() {
        return codigo_autorizacion_responsable;
    }

    public void setCodigo_autorizacion_responsable(AutorizacionResponsable codigo_autorizacion_responsable) {
        this.codigo_autorizacion_responsable = codigo_autorizacion_responsable;
    }

    public Entorno_sw_Recojido getCodigo_entorno_sw_recogido() {
        return codigo_entorno_sw_recogido;
    }

    public void setCodigo_entorno_sw_recogido(Entorno_sw_Recojido codigo_entorno_sw_recogido) {
        this.codigo_entorno_sw_recogido = codigo_entorno_sw_recogido;
    }

    public Entorno_hw_Recojido getCodigo_entorno_hw_recogido() {
        return codigo_entorno_hw_recogido;
    }

    public void setCodigo_entorno_hw_recogido(Entorno_hw_Recojido codigo_entorno_hw_recogido) {
        this.codigo_entorno_hw_recogido = codigo_entorno_hw_recogido;
    }

    public Procedimineto_Recojida getCodigo_procedimiento_recojida() {
        return codigo_procedimiento_recojida;
    }

    public void setCodigo_procedimiento_recojida(Procedimineto_Recojida codigo_procedimiento_recojida) {
        this.codigo_procedimiento_recojida = codigo_procedimiento_recojida;
    }

    public Metadatos getCodigo_metadatos() {
        return codigo_metadatos;
    }

    public void setCodigo_metadatos(Metadatos codigo_metadatos) {
        this.codigo_metadatos = codigo_metadatos;
    }

    public Tecnicas getCodigo_tecnicas() {
        return codigo_tecnicas;
    }

    public void setCodigo_tecnicas(Tecnicas codigo_tecnicas) {
        this.codigo_tecnicas = codigo_tecnicas;
    }

    public Detalle_Archivo getCodigo_detalle_archivo() {
        return codigo_detalle_archivo;
    }

    public void setCodigo_detalle_archivo(Detalle_Archivo codigo_detalle_archivo) {
        this.codigo_detalle_archivo = codigo_detalle_archivo;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }
}
