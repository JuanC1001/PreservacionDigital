/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package master.logica.clases;

/**
 *
 * @author DiegoPalacios
 */
public class Modulo {
  private int codigo;
  private String nombre;
  private String descripcion;
  private int estado;
  private Institucion codigo_inst;

    public Modulo() {
    }

    public Modulo(int codigo, String nombre, String descripcion, int estado, Institucion codigo_inst) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.codigo_inst = codigo_inst;
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
        this.nombre = nombre;
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
        this.descripcion = descripcion;
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
     * @return the codigo_inst
     */
    public Institucion getCodigo_inst() {
        return codigo_inst;
    }

    /**
     * @param codigo_inst the codigo_inst to set
     */
    public void setCodigo_inst(Institucion codigo_inst) {
        this.codigo_inst = codigo_inst;
    }
  
  
}
