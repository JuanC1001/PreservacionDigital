/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivo.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import archivo.logica.clases.Tipo_Departamento;
import java.sql.SQLException;
import java.util.ArrayList;
import master.logica.funciones.FUsuarioRol;

/**
 *
 * @author RUBEN
 */
public class FTipo_Departamento {

    public static boolean insertar(Tipo_Departamento tipoDepartamento) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from archivo_municipio.f_insert_tipo_departamento(?,?,?,?)";
            lstP.add(new Parametro(1, tipoDepartamento.getCodigo_usuario_rol().getCodigo()));
            lstP.add(new Parametro(2, tipoDepartamento.getNombre_tipoDepartamento()));
            lstP.add(new Parametro(3, tipoDepartamento.getDetalle()));
            lstP.add(new Parametro(4, tipoDepartamento.getFecha_registro()));
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

    public static boolean actualizar(Tipo_Departamento tipoDepartamento) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from archivo_municipio.f_update_tipo_departamento(?,?,?,?,?)";
            lstP.add(new Parametro(1, tipoDepartamento.getCodigo_usuario_rol().getCodigo()));
            lstP.add(new Parametro(2, tipoDepartamento.getNombre_tipoDepartamento()));
            lstP.add(new Parametro(3, tipoDepartamento.getDetalle()));
            lstP.add(new Parametro(4, tipoDepartamento.getFecha_registro()));
            lstP.add(new Parametro(5, tipoDepartamento.getCodigo()));
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

    public static boolean eliminar(Tipo_Departamento tipoDepartamento) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from archivo_municipio.f_delete_tipo_departamento(?)";
            lstP.add(new Parametro(1, tipoDepartamento.getCodigo()));
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

    public static ArrayList<Tipo_Departamento> llenartipoDepartamentos(ConjuntoResultado rs) throws Exception {
        ArrayList<Tipo_Departamento> lst = new ArrayList<Tipo_Departamento>();
        Tipo_Departamento tipoDepartamento = null;
        try {
            while (rs.next()) {
                tipoDepartamento = new Tipo_Departamento(rs.getInt("pcodigo"),
                        FUsuarioRol.ObtenerUsuarioRolDadoCodigo(rs.getInt("pcodigo_usuario_rol")),
                        rs.getString("pnombre_tipo_departamento"),
                        rs.getString("pdetalles"),
                        rs.getDate("pfecha_registro"));
                lst.add(tipoDepartamento);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    //    Seleccionar Todo los Tipo de departamentos
    public static ArrayList<Tipo_Departamento> obtenerTipoDepartamentos() throws Exception {
        ArrayList<Tipo_Departamento> lst = new ArrayList<Tipo_Departamento>();
        try {
            //ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from archivo_municipio.f_select_tipo_departamento()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            // lst = new Persona();
            lst = llenartipoDepartamentos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
        public static Tipo_Departamento ObtenerTipoDepartamentoDadoCodigo(int codigo) throws Exception {
        Tipo_Departamento lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from  archivo_municipio.f_select_tipo_departamento_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenartipoDepartamentos(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
}
