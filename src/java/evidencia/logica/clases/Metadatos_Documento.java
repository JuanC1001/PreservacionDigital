/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evidencia.logica.clases;

/**
 *
 * @author RUBENCHO
 */
public class Metadatos_Documento {

    private int codigo;
    private String nombre;
    private String tipo;
    private long tamanio;
    private String periodo;
    private String area;
    private String detalle_sw;
    private String detalle_hw;

    public Metadatos_Documento() {
    }

    public Metadatos_Documento(int codigo, String nombre, String tipo, long tamanio, String periodo, String area, String detalle_sw, String detalle_hw) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.tamanio = tamanio;
        this.periodo = periodo;
        this.area = area;
        this.detalle_sw = detalle_sw;
        this.detalle_hw = detalle_hw;
    }



    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public long getTamanio() {
        return tamanio;
    }

    public void setTamanio(long tamanio) {
        this.tamanio = tamanio;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDetalle_sw() {
        return detalle_sw;
    }

    public void setDetalle_sw(String detalle_sw) {
        this.detalle_sw = detalle_sw;
    }

    public String getDetalle_hw() {
        return detalle_hw;
    }

    public void setDetalle_hw(String detalle_hw) {
        this.detalle_hw = detalle_hw;
    }

}
