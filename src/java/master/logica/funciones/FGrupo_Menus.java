/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package master.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import java.sql.SQLException;
import java.util.ArrayList;
import master.logica.clases.Grupo_Menus;

/**
 *
 * @author DiegoPalacios
 */
public class FGrupo_Menus {

    public static boolean Insertar(Grupo_Menus grupo_m) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master_movilizacion.f_insert_grupo_menus(?,?,?,?,?,?)";
            lstP.add(new Parametro(1, grupo_m.getNombre()));
            lstP.add(new Parametro(2, grupo_m.getTitulo()));
            lstP.add(new Parametro(3, grupo_m.getDescripcion()));
            lstP.add(new Parametro(4, grupo_m.getEstado()));
            lstP.add(new Parametro(5, grupo_m.getOrden()));
            lstP.add(new Parametro(6, grupo_m.getCod_padre()));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            while (rs.next()) {
                if (rs.getString(0).equals("true"));
                eje = true;
            }
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return eje;
    }

    public static ArrayList<Grupo_Menus> llenarGruposMenus(ConjuntoResultado rs) throws Exception {
        ArrayList<Grupo_Menus> lst = new ArrayList<Grupo_Menus>();
        Grupo_Menus grupo_menus = null;
        try {
            while (rs.next()) {
                grupo_menus = new Grupo_Menus(rs.getInt("pcodigo"), rs.getString("pnombre"),
                        rs.getString("ptitulo"), rs.getString("pdescripcion"),
                        rs.getInt("pestado"), rs.getInt("porden"), rs.getInt("pcod_padre"));
                lst.add(grupo_menus);
            }
        } catch (Exception e) {
            lst.clear();
            //  integracion.auditoria.log ublog = new integracion.auditoria.log();
            // ublog.write("Modulo", "llenarModulos", e.getClass().getName(), e.getMessage());
            throw e;
        }
        return lst;
    }

    public static ArrayList<Grupo_Menus> ObtenerGruposMenus() throws Exception {
        ArrayList<Grupo_Menus> lst = new ArrayList<Grupo_Menus>();
        try {
            String sql = "select * from master_movilizacion.f_select_grupos_menus()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarGruposMenus(rs);
            rs = null;

        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static Grupo_Menus ObtenerGrupoMenuDadoCodigo(int codigo) throws Exception {
        Grupo_Menus lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master_movilizacion.f_select_grupos_menus_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Grupo_Menus();
            lst = llenarGruposMenus(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }

        return lst;
    }

    public static ArrayList<Grupo_Menus> ObtenerGruposMenusDadoPadre(int cod_padre) throws Exception {
        ArrayList<Grupo_Menus> lst = new ArrayList<Grupo_Menus>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master_movilizacion.f_select_grupos_menus_dado_padre(?)";
            lstP.add(new Parametro(1, cod_padre));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarGruposMenus(rs);
            rs = null;

        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static ArrayList<Grupo_Menus> obtenerGruposMenusNivelCeroDadoRol(int codRol) throws Exception {
        ArrayList<Grupo_Menus> lst = new ArrayList<Grupo_Menus>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master_movilizacion.f_select_grupos_menus_nivel_cero_dado_rol(?)";
            lstP.add(new Parametro(1, codRol));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarGruposMenus(rs);
            rs = null;

        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    public static ArrayList<Grupo_Menus> obtenerGruposMenusNivelCero() throws Exception {
        ArrayList<Grupo_Menus> lst = new ArrayList<Grupo_Menus>();
        try {
            String sql = "select * from master.f_select_grupos_menus_nivel_cero()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarGruposMenus(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static int ObtenerGruposMenusDadoPadre(String valorPadreSeleccionado) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public static boolean actualizar(Grupo_Menus grupoMenu) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master_movilizacion.f_update_grupo_menus(?,?,?,?,?)";
            lstP.add(new Parametro(1, grupoMenu.getNombre()));
            lstP.add(new Parametro(2, grupoMenu.getTitulo()));
            lstP.add(new Parametro(3, grupoMenu.getDescripcion()));
            lstP.add(new Parametro(4, grupoMenu.getEstado()));
            lstP.add(new Parametro(5, grupoMenu.getCodigo()));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            while (rs.next()) {
                if (rs.getString(0).equals("true"));
                eje = true;
            }

        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }

        return eje;
    }

    public static boolean eliminar(int codigo) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master_movilizacion.f_delete_grupo_menu(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            while (rs.next()) {
                if (rs.getString(0).equals("true"));
                eje = true;
            }
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return eje;
    }
}
