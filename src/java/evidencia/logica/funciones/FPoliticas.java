/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evidencia.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import evidencia.logica.clases.Politicas;
import java.sql.SQLException;
import java.util.ArrayList;
import master.logica.funciones.FUsuarioRol;

/**
 *
 * @author 
 */
public class FPoliticas {

    public static boolean insertar(Politicas politicas) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from archivo_municipio.f_insert_politicas(?,?,?,?)";
            lstP.add(new Parametro(1, politicas.getCodigo_usuario_rol().getCodigo()));
            lstP.add(new Parametro(2, politicas.getNombre_politica()));
            lstP.add(new Parametro(3, politicas.getDetalle()));
            lstP.add(new Parametro(4, politicas.getFecha_registro()));
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

    public static boolean actualizar(Politicas politicas) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from archivo_municipio.f_update_politicas(?,?,?,?,?)";
            lstP.add(new Parametro(1, politicas.getCodigo_usuario_rol().getCodigo()));
            lstP.add(new Parametro(2, politicas.getNombre_politica()));
            lstP.add(new Parametro(3, politicas.getDetalle()));
            lstP.add(new Parametro(4, politicas.getFecha_registro()));
            lstP.add(new Parametro(5, politicas.getCodigo()));
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

    public static boolean eliminar(Politicas politicas) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from archivo_municipio.f_delete_politicas(?)";
            lstP.add(new Parametro(1, politicas.getCodigo()));
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

    public static ArrayList<Politicas> llenarPoliticas(ConjuntoResultado rs) throws Exception {
        ArrayList<Politicas> lst = new ArrayList<Politicas>();
        Politicas politicas = null;
        try {
            while (rs.next()) {
                politicas = new Politicas(rs.getInt("pcodigo"),
                        FUsuarioRol.ObtenerUsuarioRolDadoCodigo(rs.getInt("pcodigo_usuario_rol")),
                        rs.getString("pnombre_politica"),
                        rs.getString("pdetalles"),
                        rs.getDate("pfecha_registro"));
                lst.add(politicas);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    //    Seleccionar Todo los Politicas
    public static ArrayList<Politicas> obtenerPoliticas() throws Exception {
        ArrayList<Politicas> lst = new ArrayList<Politicas>();
        try {
            String sql = "select * from archivo_municipio.f_select_politicas()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarPoliticas(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
}
