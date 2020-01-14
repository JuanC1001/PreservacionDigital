/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evidencia.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import evidencia.logica.clases.Dependencia;
import java.sql.SQLException;
import java.util.ArrayList;
import master.logica.funciones.FUsuarioRol;

/**
 *
 * @author RUBEN
 */
public class FDependencia {
        public static boolean insertar(Dependencia dependencia) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from evidencia_juridicos.f_insert_dependencia(?,?,?,?)";
            lstP.add(new Parametro(1, dependencia.getCodigo_usuario_rol().getCodigo()));
            lstP.add(new Parametro(2, dependencia.getNombre_dependencia()));
            lstP.add(new Parametro(3, dependencia.getDetalle()));
            lstP.add(new Parametro(4, dependencia.getFecha_registro()));
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
        
            public static boolean actualizar(Dependencia dependencia) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from evidencia_juridicos.f_update_dependencia(?,?,?,?,?)";
            lstP.add(new Parametro(1, dependencia.getCodigo_usuario_rol().getCodigo()));
            lstP.add(new Parametro(2, dependencia.getNombre_dependencia()));
            lstP.add(new Parametro(3, dependencia.getDetalle()));
            lstP.add(new Parametro(4, dependencia.getFecha_registro()));
            lstP.add(new Parametro(5, dependencia.getCodigo()));
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
            
                public static boolean eliminar(Dependencia dependencia) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from evidencia_juridicos.f_delete_dependencia(?)";
            lstP.add(new Parametro(1, dependencia.getCodigo()));
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
    public static ArrayList<Dependencia> llenarDependencia(ConjuntoResultado rs) throws Exception {
        ArrayList<Dependencia> lst = new ArrayList<Dependencia>();
        Dependencia dependencia = null;
        try {
            while (rs.next()) {
                dependencia = new Dependencia(rs.getInt("pcodigo"),
                        FUsuarioRol.ObtenerUsuarioRolDadoCodigo(rs.getInt("pcodigo_usuario_rol")),
                        rs.getString("pnombre_dependencia"),
                        rs.getString("pdetalles"),
                        rs.getDate("pfecha_registro"));
                lst.add(dependencia);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    //    Seleccionar Todo los Politicas
    public static ArrayList<Dependencia> obtenerDependencia() throws Exception {
        ArrayList<Dependencia> lst = new ArrayList<Dependencia>();
        try {
            //ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from evidencia_juridicos.f_select_dependencia()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            // lst = new Persona();
            lst = llenarDependencia(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
            public static Dependencia ObtenerDependenciaDadoCodigo(int codigo) throws Exception {
        Dependencia lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from  evidencia_juridicos.f_select_dependencia_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDependencia(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
                
}
