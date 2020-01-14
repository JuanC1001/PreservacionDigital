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
public class Metadatos {

    private int codigo;
    private String nombre;
    private String tipo;
    private long tamanio;

    public Metadatos() {
    }

    public Metadatos(int codigo, String nombre, String tipo, long tamanio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.tamanio = tamanio;
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

    

}
