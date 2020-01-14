/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evidencia.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import evidencia.logica.clases.Tipo_Caso;
import java.sql.SQLException;
import java.util.ArrayList;
import master.logica.funciones.FUsuarioRol;

/**
 *
 * @author RUBEN
 */
public class FTipo_Caso {

    public static boolean insertar(Tipo_Caso tipoCaso) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from evidencia_juridicos.f_insert_tipo_caso(?,?,?,?)";
            lstP.add(new Parametro(1, tipoCaso.getCodigo_usuario_rol().getCodigo()));
            lstP.add(new Parametro(2, tipoCaso.getNombre_tipoCaso()));
            lstP.add(new Parametro(3, tipoCaso.getDetalle()));
            lstP.add(new Parametro(4, tipoCaso.getFecha_registro()));
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

    public static boolean actualizar(Tipo_Caso tipoCaso) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from evidencia_juridicos.f_update_tipo_caso(?,?,?,?,?)";
            lstP.add(new Parametro(1, tipoCaso.getCodigo_usuario_rol().getCodigo()));
            lstP.add(new Parametro(2, tipoCaso.getNombre_tipoCaso()));
            lstP.add(new Parametro(3, tipoCaso.getDetalle()));
            lstP.add(new Parametro(4, tipoCaso.getFecha_registro()));
            lstP.add(new Parametro(5, tipoCaso.getCodigo()));
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

    public static boolean eliminar(Tipo_Caso tipoCaso) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from evidencia_juridicos.f_delete_tipo_caso(?)";
            lstP.add(new Parametro(1, tipoCaso.getCodigo()));
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

    public static ArrayList<Tipo_Caso> llenartipoCasos(ConjuntoResultado rs) throws Exception {
        ArrayList<Tipo_Caso> lst = new ArrayList<Tipo_Caso>();
        Tipo_Caso tipoCaso = null;
        try {
            while (rs.next()) {
                tipoCaso = new Tipo_Caso(rs.getInt("pcodigo"),
                        FUsuarioRol.ObtenerUsuarioRolDadoCodigo(rs.getInt("pcodigo_usuario_rol")),
                        rs.getString("pnombre_tipo_caso"),
                        rs.getString("pdetalles"),
                        rs.getDate("pfecha_registro"));
                lst.add(tipoCaso);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    //    Seleccionar Todo los Tipo de casos
    public static ArrayList<Tipo_Caso> obtenerTipoCasos() throws Exception {
        ArrayList<Tipo_Caso> lst = new ArrayList<Tipo_Caso>();
        try {
            //ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from evidencia_juridicos.f_select_tipo_caso()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            // lst = new Persona();
            lst = llenartipoCasos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
        public static Tipo_Caso ObtenerTipoCasoDadoCodigo(int codigo) throws Exception {
        Tipo_Caso lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from  evidencia_juridicos.f_select_tipo_caso_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenartipoCasos(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
}
