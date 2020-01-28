/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivo.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.Conexion;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import archivo.logica.clases.Departamento;
import archivo.logica.clases.DepartamentoPersonaUsuario;
import archivo.logica.clases.Persona;
import archivo.logica.clases.Usuario_Departamento;
import java.sql.SQLException;
import java.util.ArrayList;
import master.logica.funciones.FUsuarioRol;

/**
 *
 * @author RUBEN
 */
public class FDepartamento {

    /*
    public static int insertar(Departamento departamento, ArrayList<DepartamentoPersonaUsuario> lstCPU) throws Exception {
        int eje = 0;
        boolean eje1 = false;
        boolean ejefinal = false;
        Conexion con = new Conexion();
        if (con.getCon().getAutoCommit() == true) {
            con.getCon().setAutoCommit(false);
        }

        try {
//Insertar Departamento
            ArrayList<Parametro> lstDepartamento = new ArrayList<Parametro>();
            String sql1 = "select * from archivo_municipio.f_insert_departamento(?,?,?,?,?,?,?,?,?,?,?)";
            lstDepartamento.add(new Parametro(1, departamento.getCodigo_usuario_rol().getCodigo()));
            lstDepartamento.add(new Parametro(2, departamento.getCodigo_institucional()));
            lstDepartamento.add(new Parametro(3, departamento.getCodigo_tipo_departamento().getCodigo()));
            lstDepartamento.add(new Parametro(4, departamento.getMateria()));
            lstDepartamento.add(new Parametro(5, departamento.getProvincia()));
            lstDepartamento.add(new Parametro(6, departamento.getCanton()));
            lstDepartamento.add(new Parametro(7, departamento.getJudicatura()));
            lstDepartamento.add(new Parametro(8, departamento.getCodigo_dependencia().getCodigo()));
            lstDepartamento.add(new Parametro(9, departamento.getAccion_infraccion()));
            lstDepartamento.add(new Parametro(10, departamento.getPoliticas()));
            lstDepartamento.add(new Parametro(11, departamento.getFecha_registro()));
            ConjuntoResultado rs1 = AccesoDatos.ejecutaQuery(sql1, lstDepartamento);
            while (rs1.next()) {
                if (rs1.getInt(0) > 0);
                eje = rs1.getInt(0);
            }

            for (DepartamentoPersonaUsuario objuser_departamento : lstCPU) {
                ArrayList<Parametro> lstV = new ArrayList<Parametro>();
                String sql2 = "select * from archivo_municipio.f_insert_departamentopersonausuario(?,?,?)";
                lstV.add(new Parametro(1, eje));
                lstV.add(new Parametro(2, (objuser_departamento.getCodigo_persona().getCodigo())));
                lstV.add(new Parametro(3, (objuser_departamento.getCodigo_tipo_usuario().getCodigo())));
                ConjuntoResultado rs2 = AccesoDatos.ejecutaQuery(sql2, lstV);
                while (rs2.next()) {
                    if (rs2.getString(0).equals("true"));
                    eje1 = true;
                }
            }

            if ((eje > 0) && (eje1 == true)) {
                ejefinal = eje1;
            } else {
                ejefinal = false;
                con.getCon().rollback();
            }

        } catch (SQLException exConec) {
            con.getCon().rollback();
            throw new Exception(exConec.getMessage());
        }
        return eje;
    }
     */
    public static int insertar(Departamento departamento) throws Exception {
        //boolean eje = false;
        int eje = 0;
        try {
            ArrayList<Parametro> lstDepartamento = new ArrayList<Parametro>();
            String sql1 = "select * from archivo_municipio.f_insert_departamento(?,?,?,?,?,?,?,?,?,?,?)";
            lstDepartamento.add(new Parametro(1, departamento.getCodigo_usuario_rol().getCodigo()));
            lstDepartamento.add(new Parametro(2, departamento.getCodigo_institucional()));
            lstDepartamento.add(new Parametro(3, departamento.getCodigo_tipo_departamento().getCodigo()));
            lstDepartamento.add(new Parametro(4, departamento.getMateria()));
            lstDepartamento.add(new Parametro(5, departamento.getProvincia()));
            lstDepartamento.add(new Parametro(6, departamento.getCanton()));
            lstDepartamento.add(new Parametro(7, departamento.getJudicatura()));
            lstDepartamento.add(new Parametro(8, departamento.getCodigo_dependencia().getCodigo()));
            lstDepartamento.add(new Parametro(9, departamento.getAccion_infraccion()));
            lstDepartamento.add(new Parametro(10, departamento.getPoliticas()));
            lstDepartamento.add(new Parametro(11, departamento.getFecha_registro()));
            ConjuntoResultado rs1 = AccesoDatos.ejecutaQuery(sql1, lstDepartamento);
            while (rs1.next()) {
                if (rs1.getInt(0) > 0);
                eje = rs1.getInt(0);
            }            
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return eje;
    }
    
    

    public static ArrayList<Departamento> llenarDepartamento(ConjuntoResultado rs) throws Exception {
        ArrayList<Departamento> lst = new ArrayList<Departamento>();
        Departamento departamento = null;
        try {
            while (rs.next()) {
                departamento = new Departamento(rs.getInt("pcodigo"),         
                        FUsuarioRol.ObtenerUsuarioRolDadoCodigo(rs.getInt("pcodigo_usuario_rol")),
                        rs.getString("pcodigo_institucional"),
                        FTipo_Departamento.ObtenerTipoDepartamentoDadoCodigo(rs.getInt("pcodigo_tipo_departamento")),
                        rs.getString("pmateria"),
                        rs.getString("pprovincia"),
                        rs.getString("pcanton"),
                        rs.getString("pjudicatura"),
                        FDependencia.ObtenerDependenciaDadoCodigo(rs.getInt("pcodigo_dependencia")),
                        rs.getString("paccion_infraccion"),
                        rs.getString("ppoliticas"),
                        rs.getTimeStamp("pfecha_registro"));
                lst.add(departamento);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }
    //Seleccionar todo los departamentos

    public static ArrayList<Departamento> obtenerDepartamentos() throws Exception {
        ArrayList<Departamento> lst = new ArrayList<Departamento>();
        try {
            //ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from archivo_municipio.f_select_departamento()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            // lst = new Persona();
            lst = llenarDepartamento(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static Departamento ObtenerDepartamentoDadoCodigo(int codigo) throws Exception {
        Departamento lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from archivo_municipio.f_select_departamento_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDepartamento(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
        
       public static Departamento ObtenerDepartamentoUltimo() throws Exception {
        Departamento lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from archivo_municipio.f_select_ultimodepartamento()";
            //lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDepartamento(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    

}
