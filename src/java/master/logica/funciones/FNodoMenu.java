/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package master.logica.funciones;

import java.util.ArrayList;
import master.logica.clases.Funcion;
import master.logica.clases.Grupo_Menus;
import master.logica.clases.NodoMenu;
import recursos.Util;

/**
 *
 * @author escorpionDJ
 */
public class FNodoMenu {

    ArrayList<NodoMenu> menu;

    public FNodoMenu() {
    }

    public FNodoMenu(ArrayList<NodoMenu> menu) {
        this.menu = menu;
    }

    public ArrayList<NodoMenu> getMenu() {
        return menu;
    }

    public void setMenu(ArrayList<NodoMenu> menu) {
        this.menu = menu;
    }

    public int numeroGrupoMenuCeroDadoModulo(int op) {
        switch (op) {
            case 3:
                return 9;
            case 5:
                return 78;
            case 4:
                return 26;
            default:
                return 0;
        }
    }

    public ArrayList<NodoMenu> generarMenuUsuario(int unCodigoRol) {
        ArrayList<NodoMenu> grupos = new ArrayList<NodoMenu>();
        try {
            //obtener solo los grupos menu que tienen funcion
            ArrayList<Grupo_Menus> grupoMenu = FGrupo_Menus.obtenerGruposMenusNivelCeroDadoRol(unCodigoRol);
            for (Grupo_Menus grupo0 : grupoMenu) {
                //if (numeroGrupoMenuCeroDadoModulo(FRoles.ObtenerRolDadoCodigo(unCodigoRol).getCodigo_modulo().getCodigo()) == grupo0.getCodigo()) {
                if(FModuloGrupoMenu.obtenerModuloGrupoMenuDadoCodigo(FRoles.ObtenerRolDadoCodigo(unCodigoRol).getCodigo_modulo().getCodigo()).getCodigo_grupo_menu().getCodigo() == grupo0.getCodigo()){
                    NodoMenu nodo = new NodoMenu();
                    nodo.setCodigo(grupo0.getCodigo());
                    nodo.setNombre(grupo0.getTitulo());
                    nodo.setUrl("#");
                    nodo.setHijos(this.getHijos(grupo0.getCodigo(), unCodigoRol));
                    grupos.add(nodo);
                }
            }
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
        this.menu = grupos;
        return grupos;
    }

    public ArrayList<NodoMenu> getHijos(int unCodPadre, int unCodigoRol) {
        ArrayList<NodoMenu> hijos = new ArrayList<NodoMenu>();
        try {
            ArrayList<Grupo_Menus> grupoMenu = FGrupo_Menus.ObtenerGruposMenusDadoPadre(unCodPadre);
            if (!grupoMenu.isEmpty()) {
                for (Grupo_Menus grupo0 : grupoMenu) {
                    NodoMenu nodo = new NodoMenu();
                    nodo.setCodigo(grupo0.getCodigo());
                    nodo.setNombre(grupo0.getTitulo());
                    nodo.setUrl("#");
                    nodo.setHijos(this.getHijos(grupo0.getCodigo(), unCodigoRol));
                    hijos.add(nodo);
                }
            } else {
                ArrayList<Funcion> funciones = FFuncion.ObtenerFuncionesDadoRol_PadreGruposMenus(unCodigoRol, unCodPadre);
                for (Funcion funcion0 : funciones) {
                    NodoMenu nodo = new NodoMenu();
                    nodo.setCodigo(funcion0.getCodigo_accion().getCodigo());
                    nodo.setNombre(funcion0.getCodigo_accion().getTitulo());
                    nodo.setUrl(funcion0.getCodigo_accion().getUrl());
                    hijos.add(nodo);
                }
            }
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
        return hijos;
    }
}
