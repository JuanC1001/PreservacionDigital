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
import master.logica.clases.Rol;

/**
 *
 * @author DiegoPalacios
 */
public class FRoles {

    public static boolean Insertar(Rol rol) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master_movilizacion.f_insert_rol(?,?,?,?)";
            lstP.add(new Parametro(1, rol.getNombre()));
            lstP.add(new Parametro(2, rol.getDescripcion()));
            lstP.add(new Parametro(3, rol.getEstado()));
            lstP.add(new Parametro(4, rol.getCodigo_modulo().getCodigo()));
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

    public static boolean Actualizar(Rol rol) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master_movilizacion.f_update_rol(?,?,?,?,?)";
            lstP.add(new Parametro(1, rol.getNombre()));
            lstP.add(new Parametro(2, rol.getDescripcion()));
            lstP.add(new Parametro(3, rol.getEstado()));
            lstP.add(new Parametro(4, rol.getCodigo_modulo().getCodigo()));
            lstP.add(new Parametro(5, rol.getCodigo()));
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

    public static boolean Eliminar(int codigo) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master_movilizacion.f_delete_rol(?)";
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

    public static ArrayList<Rol> llenarRol(ConjuntoResultado rs) throws Exception {
        ArrayList<Rol> lst = new ArrayList<Rol>();
        Rol rol = null;
        try {
            while (rs.next()) {
                rol = new Rol(rs.getInt("pcodigo"), rs.getString("pnombre"), rs.getString("pdescripcion"), rs.getInt("pestado"),
                        FModulo.ObtenerModuloDadoCodigo(rs.getInt("pcodigo_modulo")));
                lst.add(rol);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<Rol> ObtenerRoles() throws Exception {
        ArrayList<Rol> lst = new ArrayList<Rol>();
        try {
            String sql = "select * from master_movilizacion.f_select_roles()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarRol(rs);
            rs = null;

        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static ArrayList<Rol> obtenerRolesDadoModulo(int codModulo) throws Exception {
        ArrayList<Rol> lst = new ArrayList<Rol>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master_movilizacion.f_select_roles_dado_modulo(?)";
            lstP.add(new Parametro(1, codModulo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarRol(rs);
            rs = null;

        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static Rol ObtenerRolDadoCodigo(int codigo) throws Exception {
        Rol lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master_movilizacion.f_select_rol_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Rol();
            lst = llenarRol(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
}
