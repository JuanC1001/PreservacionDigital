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
import master.logica.clases.Menu_Sitio;

/**
 *
 * @author icits
 */
public class FMenu_Sitio {

    public static boolean Insertar(Menu_Sitio menuSitio) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master_movilizacion.f_insert_menu_sitio(?,?,?,?,?,?)";
            lstP.add(new Parametro(1, menuSitio.getNombre()));
            lstP.add(new Parametro(2, menuSitio.getDescripcion()));
            lstP.add(new Parametro(3, menuSitio.getUrl()));
            lstP.add(new Parametro(4, menuSitio.getEstado()));
            lstP.add(new Parametro(5, menuSitio.getOrden()));
            lstP.add(new Parametro(6, menuSitio.getCodigo_padre()));
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

    public static ArrayList<Menu_Sitio> llenarMenuSitio(ConjuntoResultado rs) throws Exception {
        ArrayList<Menu_Sitio> lst = new ArrayList<Menu_Sitio>();
        Menu_Sitio accion = null;
        try {
            while (rs.next()) {
                accion = new Menu_Sitio(rs.getInt("pcodigo"), rs.getString("pnombre"), rs.getString("pdescripcion"), rs.getString("purl"), rs.getInt("pestado"), rs.getInt("porden"), rs.getInt("pcodigo_padre"));
                lst.add(accion);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<Menu_Sitio> ObtenerMenuSitio() throws Exception {
        ArrayList<Menu_Sitio> lst = new ArrayList<Menu_Sitio>();
        try {
            String sql = "select * from master_movilizacion.f_select_menu_sitio()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarMenuSitio(rs);
            rs = null;

        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static boolean actualizar(Menu_Sitio menuSitio) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master_movilizacion.f_update_menu_sitio(?,?,?,?,?,?,?)";
            lstP.add(new Parametro(1, menuSitio.getNombre()));
            lstP.add(new Parametro(2, menuSitio.getDescripcion()));
            lstP.add(new Parametro(3, menuSitio.getUrl()));
            lstP.add(new Parametro(4, menuSitio.getEstado()));
            lstP.add(new Parametro(5, menuSitio.getOrden()));
            lstP.add(new Parametro(6, menuSitio.getCodigo_padre()));
            lstP.add(new Parametro(7, menuSitio.getCodigo()));
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
            String sql = "select * from master_movilizacion.f_delete_menu_sitio(?)";
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
