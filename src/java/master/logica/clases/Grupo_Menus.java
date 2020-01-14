/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package master.logica.clases;

/**
 *
 * @author DiegoPalacios
 */
public class Grupo_Menus {
  private int codigo;
  private String nombre;
  private String titulo;
  private String descripcion;
  private int estado;
  private int orden;
  private int cod_padre;

    public Grupo_Menus() {
    }

    public Grupo_Menus(int codigo, String nombre, String titulo, String descripcion, int estado, int orden, int cod_padre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.orden = orden;
        this.cod_padre = cod_padre;
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre.toUpperCase();
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo.toUpperCase();
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion.toUpperCase();
    }

    /**
     * @return the estado
     */
    public int getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(int estado) {
        this.estado = estado;
    }

    /**
     * @return the orden
     */
    public int getOrden() {
        return orden;
    }

    /**
     * @param orden the orden to set
     */
    public void setOrden(int orden) {
        this.orden = orden;
    }

    /**
     * @return the cod_padre
     */
    public int getCod_padre() {
        return cod_padre;
    }

    /**
     * @param cod_padre the cod_padre to set
     */
    public void setCod_padre(int cod_padre) {
        this.cod_padre = cod_padre;
    }
  
  
}
