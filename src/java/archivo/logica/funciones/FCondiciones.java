/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivo.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import archivo.logica.clases.Condiciones;
import java.sql.SQLException;
import java.util.ArrayList;
import master.logica.funciones.FUsuarioRol;

/**
 *
 * @author RUBEN
 */
public class FCondiciones {

    public static boolean insertar(Condiciones condiciones)
            throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList();
            String sql = "select * from archivo.f_insert_condiciones(?,?,?,?)";
            lstP.add(new Parametro(1, condiciones.getCodigo_usuario_rol().getCodigo()));
            lstP.add(new Parametro(2, condiciones.getCondicion()));
            lstP.add(new Parametro(3, condiciones.getDetalle()));
            lstP.add(new Parametro(4, condiciones.getPath()));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            while (rs.next()) {
                if (rs.getString(0).equals("true")) {
                }
                eje = true;
            }
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return eje;
    }

    public static ArrayList<Condiciones> llenarCondiciones(ConjuntoResultado rs)
            throws Exception {
        ArrayList<Condiciones> lst = new ArrayList();
        Condiciones texto = null;
        try {
            while (rs.next()) {
                texto = new Condiciones(rs.getInt("pcodigo"),
                        FUsuarioRol.ObtenerUsuarioRolDadoCodigo(rs.getInt("pcodigo_usuario_rol")),
                        rs.getString("pcondicion"),
                        rs.getString("pdetalle"),
                        rs.getString("ppath"));
                lst.add(texto);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<Condiciones> obtenerTodosCondiciones()
            throws Exception {
        ArrayList<Condiciones> lst = new ArrayList();
        try {
            String sql = "select * from archivo.f_select_condiciones()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarCondiciones(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    
        public static Condiciones ObtenerCondicionesDadoCodigo(int codigo) throws Exception {
        Condiciones lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from archivo.f_select_condiciones_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarCondiciones(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

}
