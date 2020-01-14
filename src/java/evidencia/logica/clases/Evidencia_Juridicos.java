/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evidencia.logica.clases;
import java.util.Date;

/**
 *
 * @author RUBEN
 */
public class Evidencia_Juridicos {

    private int codigo;
    private Caso codigo_caso;
    private AutorizacionJuez codigo_autorizacion_juez;
    private Entorno_sw_Recojido codigo_entorno_sw_recogido;
    private Entorno_hw_Recojido codigo_entorno_hw_recogido;
    private Procedimineto_Recojida codigo_procedimiento_recojida;
    private Metadatos codigo_metadatos;
    private Tecnicas codigo_tecnicas;
    private Detalle_Evidencia codigo_detalle_evidencia;
    private Date fecha_registro;

    public Evidencia_Juridicos() {
    }

    public Evidencia_Juridicos(int codigo, Caso codigo_caso, AutorizacionJuez codigo_autorizacion_juez, Entorno_sw_Recojido codigo_entorno_sw_recogido, Entorno_hw_Recojido codigo_entorno_hw_recogido, Procedimineto_Recojida codigo_procedimiento_recojida, Metadatos codigo_metadatos, Tecnicas codigo_tecnicas, Detalle_Evidencia codigo_detalle_evidencia, Date fecha_registro) {
        this.codigo = codigo;
        this.codigo_caso = codigo_caso;
        this.codigo_autorizacion_juez = codigo_autorizacion_juez;
        this.codigo_entorno_sw_recogido = codigo_entorno_sw_recogido;
        this.codigo_entorno_hw_recogido = codigo_entorno_hw_recogido;
        this.codigo_procedimiento_recojida = codigo_procedimiento_recojida;
        this.codigo_metadatos = codigo_metadatos;
        this.codigo_tecnicas = codigo_tecnicas;
        this.codigo_detalle_evidencia = codigo_detalle_evidencia;
        this.fecha_registro = fecha_registro;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Caso getCodigo_caso() {
        return codigo_caso;
    }

    public void setCodigo_caso(Caso codigo_caso) {
        this.codigo_caso = codigo_caso;
    }

    public AutorizacionJuez getCodigo_autorizacion_juez() {
        return codigo_autorizacion_juez;
    }

    public void setCodigo_autorizacion_juez(AutorizacionJuez codigo_autorizacion_juez) {
        this.codigo_autorizacion_juez = codigo_autorizacion_juez;
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

    public Detalle_Evidencia getCodigo_detalle_evidencia() {
        return codigo_detalle_evidencia;
    }

    public void setCodigo_detalle_evidencia(Detalle_Evidencia codigo_detalle_evidencia) {
        this.codigo_detalle_evidencia = codigo_detalle_evidencia;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }
}
