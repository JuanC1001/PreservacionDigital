/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package master.logica.clases;

/**
 *
 * @author icits
 */
public class ModuloGrupoMenu {
   private int codigo;
   private Modulo codigo_modulo;
   private Grupo_Menus codigo_grupo_menu;
   private int estado;

    public ModuloGrupoMenu() {
    }

public ModuloGrupoMenu(int codigo, Modulo codigo_modulo, Grupo_Menus codigo_grupo_menu, int estado){
this.codigo=codigo;
this.codigo_modulo=codigo_modulo;
this.codigo_grupo_menu=codigo_grupo_menu;
this.estado = estado;
}

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Modulo getCodigo_modulo() {
        return codigo_modulo;
    }

    public void setCodigo_modulo(Modulo codigo_modulo) {
        this.codigo_modulo = codigo_modulo;
    }

    public Grupo_Menus getCodigo_grupo_menu() {
        return codigo_grupo_menu;
    }

    public void setCodigo_grupo_menu(Grupo_Menus codigo_grupo_menu) {
        this.codigo_grupo_menu = codigo_grupo_menu;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
      
}
