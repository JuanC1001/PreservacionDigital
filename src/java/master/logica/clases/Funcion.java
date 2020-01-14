/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package master.logica.clases;

/**
 *
 * @author DiegoPalacios
 */
public class Funcion {
  private int codigo;
  private Accion codigo_accion;
  private Rol codigo_rol;
  private Grupo_Menus codigo_grupo_menus;
  private int orden;
  private int estado;
  private boolean insertar;
  private boolean actualizar;
  private boolean eliminar;
  private boolean ver;

    public Funcion() {
    }

    public Funcion(int codigo, Accion codigo_accion, Rol codigo_rol, Grupo_Menus codigo_grupo_menus, int orden, int estado, boolean insertar, boolean actualizar, boolean eliminar, boolean ver) {
        this.codigo = codigo;
        this.codigo_accion = codigo_accion;
        this.codigo_rol = codigo_rol;
        this.codigo_grupo_menus = codigo_grupo_menus;
        this.orden = orden;
        this.estado = estado;
        this.insertar = insertar;
        this.actualizar = actualizar;
        this.eliminar = eliminar;
        this.ver = ver;
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
     * @return the codigo_accion
     */
    public Accion getCodigo_accion() {
        return codigo_accion;
    }

    /**
     * @param codigo_accion the codigo_accion to set
     */
    public void setCodigo_accion(Accion codigo_accion) {
        this.codigo_accion = codigo_accion;
    }

    /**
     * @return the codigo_rol
     */
    public Rol getCodigo_rol() {
        return codigo_rol;
    }

    /**
     * @param codigo_rol the codigo_rol to set
     */
    public void setCodigo_rol(Rol codigo_rol) {
        this.codigo_rol = codigo_rol;
    }

    /**
     * @return the codigo_grupo_menus
     */
    public Grupo_Menus getCodigo_grupo_menus() {
        return codigo_grupo_menus;
    }

    /**
     * @param codigo_grupo_menus the codigo_grupo_menus to set
     */
    public void setCodigo_grupo_menus(Grupo_Menus codigo_grupo_menus) {
        this.codigo_grupo_menus = codigo_grupo_menus;
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
     * @return the insertar
     */
    public boolean isInsertar() {
        return insertar;
    }

    /**
     * @param insertar the insertar to set
     */
    public void setInsertar(boolean insertar) {
        this.insertar = insertar;
    }

    /**
     * @return the actualizar
     */
    public boolean isActualizar() {
        return actualizar;
    }

    /**
     * @param actualizar the actualizar to set
     */
    public void setActualizar(boolean actualizar) {
        this.actualizar = actualizar;
    }

    /**
     * @return the eliminar
     */
    public boolean isEliminar() {
        return eliminar;
    }

    /**
     * @param eliminar the eliminar to set
     */
    public void setEliminar(boolean eliminar) {
        this.eliminar = eliminar;
    }

    /**
     * @return the ver
     */
    public boolean isVer() {
        return ver;
    }

    /**
     * @param ver the ver to set
     */
    public void setVer(boolean ver) {
        this.ver = ver;
    }
  
}
