/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package digitales.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import digitales.logica.clases.Texto;
import java.sql.SQLException;
import java.util.ArrayList;
import master.logica.funciones.FPersona;
/**
 *
 * @author icits
 */
public class FTexto {
    
    public static boolean insertar(Texto texto) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from digitales.f_insert_texto(?,?,?,?,?,?,?,?)";
            lstP.add(new Parametro(1, texto.getTitulo()));
            lstP.add(new Parametro(2, texto.getResumen()));
            lstP.add(new Parametro(3, texto.getContenido()));
            lstP.add(new Parametro(4, texto.getKeywords()));
            lstP.add(new Parametro(5, texto.getFecha_registro()));
            lstP.add(new Parametro(6, texto.getFecha_edicion()));
            lstP.add(new Parametro(7, texto.getEstado()));
            lstP.add(new Parametro(8, texto.getCodigo_persona().getCodigo_persona()));
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
    
    public static boolean actualizar(Texto texto) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from digitales.f_update_texto(?,?,?,?,?,?,?,?,?)";
            lstP.add(new Parametro(1, texto.getTitulo()));
            lstP.add(new Parametro(2, texto.getResumen()));
            lstP.add(new Parametro(3, texto.getContenido()));
            lstP.add(new Parametro(4, texto.getKeywords()));
            lstP.add(new Parametro(5, texto.getFecha_registro()));
            lstP.add(new Parametro(6, texto.getFecha_edicion()));
            lstP.add(new Parametro(7, texto.getEstado()));
            lstP.add(new Parametro(8, texto.getCodigo_persona().getCodigo_persona()));
            lstP.add(new Parametro(9, texto.getCodigo()));
            
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
    
    public static boolean eliminar(Texto texto) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from digitales.f_delete_texto(?)";
            lstP.add(new Parametro(1, texto.getCodigo()));
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
    
    public static ArrayList<Texto> llenarTexto(ConjuntoResultado rs) throws Exception {
        ArrayList<Texto> lst = new ArrayList<Texto>();
        Texto texto = null;
        try {
            while (rs.next()) {
                texto = new Texto(rs.getInt("pcodigo"),
                        rs.getString("ptitulo"), rs.getString("presumen"), rs.getString("pcontenido"),
                        rs.getString("pkeywords"),rs.getLong("pfecha_registro"),rs.getLong("pfecha_edicion"),
                        rs.getInt("pestado"),FPersona.ObtenerPersonaDadoCodigo(rs.getInt("pcodigo_persona")));
                lst.add(texto);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<Texto> obtenerTodos() throws Exception {
        ArrayList<Texto> lst = new ArrayList<Texto>();
        try {
            String sql = "select * from digitales.f_select_texto()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarTexto(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
     public static Texto obtenerTextoDadoCodigo(int codigo) throws Exception {
        Texto objCliente = new Texto();
        try {
            String sql = "select * from digitales.f_select_texto_dado_codigo(?)";
            ArrayList<Parametro> lstP = new ArrayList<Parametro>(); 
            lstP .add(new Parametro(1,codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql,lstP);
            objCliente = llenarTexto(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return objCliente;
    }
     
     public static Texto obtenerTextoDadoArticulo(int codigo) throws Exception {
        Texto objTexto = new Texto();
        try {
            String sql = "select * from digitales.f_select_texto_dado_articulo(?)";
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            objTexto = llenarTexto(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return objTexto;
    }
    
}
