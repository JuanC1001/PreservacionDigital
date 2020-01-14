/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package digitales.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import digitales.logica.clases.Sonido;
import java.sql.SQLException;
import java.util.ArrayList;
import master.logica.funciones.FPersona;

/**
 *
 * @author icits
 */
public class FSonido {
    
       
    public static boolean insertar(Sonido sonido) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from digitales.f_insert_sonido(?,?,?,?,?,?,?)";
            lstP.add(new Parametro(1, sonido.getTitulo()));
            lstP.add(new Parametro(2, sonido.getPath()));
            lstP.add(new Parametro(3, sonido.getTipo()));
            lstP.add(new Parametro(4, sonido.getKeywords()));
            lstP.add(new Parametro(5, sonido.getFecha_registro()));
            lstP.add(new Parametro(6, sonido.getEstado()));
            lstP.add(new Parametro(7, sonido.getCodigo_persona().getCodigo_persona()));
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
    
    public static boolean actualizar(Sonido sonido) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from digitales.f_update_sonido(?,?,?,?,?,?,?,?)";
             lstP.add(new Parametro(1, sonido.getTitulo()));
             lstP.add(new Parametro(2, sonido.getPath()));
             lstP.add(new Parametro(3, sonido.getTipo()));
             lstP.add(new Parametro(4, sonido.getKeywords()));
             lstP.add(new Parametro(5, sonido.getFecha_registro()));
             lstP.add(new Parametro(6, sonido.getEstado()));
             lstP.add(new Parametro(7, sonido.getCodigo_persona().getCodigo_persona()));
             lstP.add(new Parametro(8, sonido.getCodigo()));
            
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
    
    public static boolean eliminar(Sonido sonido) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from digitales.f_delete_sonido(?)";
            lstP.add(new Parametro(1, sonido.getCodigo()));
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
    
    public static ArrayList<Sonido> llenarSonido(ConjuntoResultado rs) throws Exception {
        ArrayList<Sonido> lst = new ArrayList<Sonido>();
        Sonido texto = null;
        try {
            while (rs.next()) {
                texto = new Sonido(rs.getInt("pcodigo"),
                        rs.getString("ptitulo"), rs.getString("ppath"), rs.getString("ptipo"),
                        rs.getString("pkeywords"),rs.getLong("pfecha_registro"),
                        rs.getInt("pestado"),FPersona.ObtenerPersonaDadoCodigo(rs.getInt("pcodigo_persona")));
                lst.add(texto);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<Sonido> obtenerTodos() throws Exception {
        ArrayList<Sonido> lst = new ArrayList<Sonido>();
        try {
            String sql = "select * from digitales.f_select_sonido()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarSonido(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
     public static Sonido obtenerSonidoDadoCodigo(int codigo) throws Exception {
        Sonido objCliente = new Sonido();
        try {
            String sql = "select * from digitales.f_select_sonido_dado_codigo(?)";
            ArrayList<Parametro> lstP = new ArrayList<Parametro>(); 
            lstP .add(new Parametro(1,codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql,lstP);
            objCliente = llenarSonido(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return objCliente;
    }
     
     public static Sonido obtenerSonidoDadoArticulo(int codigo) throws Exception {
        Sonido objSonido = new Sonido();
        try {
            String sql = "select * from digitales.f_select_sonido_dado_articulo(?)";
            ArrayList<Parametro> lstP = new ArrayList<Parametro>(); 
            lstP .add(new Parametro(1,codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql,lstP);
            objSonido = llenarSonido(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return objSonido;
    }
     
     public static ArrayList<Sonido> obtenerListaSonidoDadoArticulo(int codigo) throws Exception {
        ArrayList<Sonido> lstSonido = new ArrayList<Sonido>();
        try {
            String sql = "select * from digitales.f_select_sonido_dado_articulo(?)";
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lstSonido = llenarSonido(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lstSonido;
    }
}
