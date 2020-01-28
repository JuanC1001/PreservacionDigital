/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivo.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import archivo.logica.clases.Persona;
import java.sql.SQLException;
import java.util.ArrayList;
import master.logica.funciones.FUsuarioRol;

/**
 *
 * @author RUBENCHO
 */
public class FPersona {

    public static boolean insertar(Persona persona) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from archivo_municipio.f_insert_personal(?,?,?,?,?,?)";
            lstP.add(new Parametro(1, persona.getCodigo_usuario_rol().getCodigo()));
            lstP.add(new Parametro(2, persona.getApellidos()));
            lstP.add(new Parametro(3, persona.getNombres()));
            lstP.add(new Parametro(4, persona.getCedula()));
            lstP.add(new Parametro(5, persona.getMail()));
            lstP.add(new Parametro(6, persona.getFecha_registro()));
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

    public static boolean actualizar(Persona persona) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from archivo_municipio.f_update_personas(?,?,?,?,?,?,?)";
            lstP.add(new Parametro(1, persona.getCodigo_usuario_rol().getCodigo()));
            lstP.add(new Parametro(2, persona.getApellidos()));
            lstP.add(new Parametro(3, persona.getNombres()));
            lstP.add(new Parametro(4, persona.getCedula()));
            lstP.add(new Parametro(5, persona.getMail()));
            lstP.add(new Parametro(6, persona.getFecha_registro()));
            lstP.add(new Parametro(7, persona.getCodigo()));
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

    public static boolean eliminar(Persona personas) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from archivo_municipio.f_delete_personas(?)";
            lstP.add(new Parametro(1, personas.getCodigo()));
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

    public static ArrayList<Persona> llenarPersonas(ConjuntoResultado rs) throws Exception {
        ArrayList<Persona> lst = new ArrayList<Persona>();
        Persona autor = null;
        try {
            while (rs.next()) {
                autor = new Persona(rs.getInt("pcodigo"),
                        FUsuarioRol.ObtenerUsuarioRolDadoCodigo(rs.getInt("pcodigo_usuario_rol")),
                        rs.getString("papellidos"),
                        rs.getString("pnombres"),
                        rs.getString("pcedula"),
                        rs.getString("pmail"),
                        rs.getDate("pfecha_registro"));
                lst.add(autor);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    //    Seleccionar Todo los Autores
    public static ArrayList<Persona> obtenerPersonas() throws Exception {
        ArrayList<Persona> lst = new ArrayList<Persona>();
        try {
            //ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from archivo_municipio.f_select_personal()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            // lst = new Persona();
            lst = llenarPersonas(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static Persona ObtenerPersonasDadoCodigo(int codigo) throws Exception {
        Persona lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from archivo_municipio.f_select_personas_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            //lst = new Autor();
            lst = llenarPersonas(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static Persona ObtenerPersonaDadoCedula(String cedula) throws Exception {
        Persona lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from archivo_municipio.f_select_personas_dado_cedula(?)";
            lstP.add(new Parametro(1, cedula));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Persona();
            lst = llenarPersonas(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    public static Persona ObtenerPersonaDadoApellidos(String apellidos) throws Exception {
        Persona lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from archivo_municipio.f_select_personas_dado_nombre_apellido(?)";
            lstP.add(new Parametro(1, apellidos));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Persona();
            lst = llenarPersonas(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;

    }

}
