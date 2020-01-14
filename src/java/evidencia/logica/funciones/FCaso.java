/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evidencia.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.Conexion;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import evidencia.logica.clases.Caso;
import evidencia.logica.clases.CasoPersonaUsuario;
import evidencia.logica.clases.Persona;
import evidencia.logica.clases.Usuario_Caso;
import java.sql.SQLException;
import java.util.ArrayList;
import master.logica.funciones.FUsuarioRol;

/**
 *
 * @author RUBEN
 */
public class FCaso {

    /*
    public static int insertar(Caso caso, ArrayList<CasoPersonaUsuario> lstCPU) throws Exception {
        int eje = 0;
        boolean eje1 = false;
        boolean ejefinal = false;
        Conexion con = new Conexion();
        if (con.getCon().getAutoCommit() == true) {
            con.getCon().setAutoCommit(false);
        }

        try {
//Insertar Caso
            ArrayList<Parametro> lstCaso = new ArrayList<Parametro>();
            String sql1 = "select * from evidencia_juridicos.f_insert_caso(?,?,?,?,?,?,?,?,?,?,?)";
            lstCaso.add(new Parametro(1, caso.getCodigo_usuario_rol().getCodigo()));
            lstCaso.add(new Parametro(2, caso.getCodigo_institucional()));
            lstCaso.add(new Parametro(3, caso.getCodigo_tipo_caso().getCodigo()));
            lstCaso.add(new Parametro(4, caso.getMateria()));
            lstCaso.add(new Parametro(5, caso.getProvincia()));
            lstCaso.add(new Parametro(6, caso.getCanton()));
            lstCaso.add(new Parametro(7, caso.getJudicatura()));
            lstCaso.add(new Parametro(8, caso.getCodigo_dependencia().getCodigo()));
            lstCaso.add(new Parametro(9, caso.getAccion_infraccion()));
            lstCaso.add(new Parametro(10, caso.getPoliticas()));
            lstCaso.add(new Parametro(11, caso.getFecha_registro()));
            ConjuntoResultado rs1 = AccesoDatos.ejecutaQuery(sql1, lstCaso);
            while (rs1.next()) {
                if (rs1.getInt(0) > 0);
                eje = rs1.getInt(0);
            }

            for (CasoPersonaUsuario objuser_caso : lstCPU) {
                ArrayList<Parametro> lstV = new ArrayList<Parametro>();
                String sql2 = "select * from evidencia_juridicos.f_insert_casopersonausuario(?,?,?)";
                lstV.add(new Parametro(1, eje));
                lstV.add(new Parametro(2, (objuser_caso.getCodigo_persona().getCodigo())));
                lstV.add(new Parametro(3, (objuser_caso.getCodigo_tipo_usuario().getCodigo())));
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
    public static int insertar(Caso caso) throws Exception {
        //boolean eje = false;
        int eje = 0;
        try {
            ArrayList<Parametro> lstCaso = new ArrayList<Parametro>();
            String sql1 = "select * from evidencia_juridicos.f_insert_caso(?,?,?,?,?,?,?,?,?,?,?)";
            lstCaso.add(new Parametro(1, caso.getCodigo_usuario_rol().getCodigo()));
            lstCaso.add(new Parametro(2, caso.getCodigo_institucional()));
            lstCaso.add(new Parametro(3, caso.getCodigo_tipo_caso().getCodigo()));
            lstCaso.add(new Parametro(4, caso.getMateria()));
            lstCaso.add(new Parametro(5, caso.getProvincia()));
            lstCaso.add(new Parametro(6, caso.getCanton()));
            lstCaso.add(new Parametro(7, caso.getJudicatura()));
            lstCaso.add(new Parametro(8, caso.getCodigo_dependencia().getCodigo()));
            lstCaso.add(new Parametro(9, caso.getAccion_infraccion()));
            lstCaso.add(new Parametro(10, caso.getPoliticas()));
            lstCaso.add(new Parametro(11, caso.getFecha_registro()));
            ConjuntoResultado rs1 = AccesoDatos.ejecutaQuery(sql1, lstCaso);
            while (rs1.next()) {
                if (rs1.getInt(0) > 0);
                eje = rs1.getInt(0);
            }            
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return eje;
    }
    
    

    public static ArrayList<Caso> llenarCaso(ConjuntoResultado rs) throws Exception {
        ArrayList<Caso> lst = new ArrayList<Caso>();
        Caso caso = null;
        try {
            while (rs.next()) {
                caso = new Caso(rs.getInt("pcodigo"),         
                        FUsuarioRol.ObtenerUsuarioRolDadoCodigo(rs.getInt("pcodigo_usuario_rol")),
                        rs.getString("pcodigo_institucional"),
                        FTipo_Caso.ObtenerTipoCasoDadoCodigo(rs.getInt("pcodigo_tipo_caso")),
                        rs.getString("pmateria"),
                        rs.getString("pprovincia"),
                        rs.getString("pcanton"),
                        rs.getString("pjudicatura"),
                        FDependencia.ObtenerDependenciaDadoCodigo(rs.getInt("pcodigo_dependencia")),
                        rs.getString("paccion_infraccion"),
                        rs.getString("ppoliticas"),
                        rs.getTimeStamp("pfecha_registro"));
                lst.add(caso);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }
    //Seleccionar todo los casos

    public static ArrayList<Caso> obtenerCasos() throws Exception {
        ArrayList<Caso> lst = new ArrayList<Caso>();
        try {
            //ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from evidencia_juridicos.f_select_caso()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            // lst = new Persona();
            lst = llenarCaso(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static Caso ObtenerCasoDadoCodigo(int codigo) throws Exception {
        Caso lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from evidencia_juridicos.f_select_caso_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarCaso(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
        
       public static Caso ObtenerCasoUltimo() throws Exception {
        Caso lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from evidencia_juridicos.f_select_ultimocaso()";
            //lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarCaso(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    

}
