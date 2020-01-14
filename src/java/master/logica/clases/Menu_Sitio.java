/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package master.logica.clases;

/**
 *
 * @author icits
 */
public class Menu_Sitio {

    private int codigo;
    private String nombre;
    private String descripcion;
    private String url;
    private int estado;
    private int orden;
    private int codigo_padre;

    public Menu_Sitio() {
    }

    public Menu_Sitio(int codigo, String nombre, String descripcion, String url, int estado, int orden, int codigo_padre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.url = url;
        this.estado = estado;
        this.orden = orden;
        this.codigo_padre = codigo_padre;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public int getCodigo_padre() {
        return codigo_padre;
    }

    public void setCodigo_padre(int codigo_padre) {
        this.codigo_padre = codigo_padre;
    }
}
