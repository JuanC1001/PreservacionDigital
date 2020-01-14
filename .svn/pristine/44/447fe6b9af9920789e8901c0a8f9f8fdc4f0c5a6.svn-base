/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package digitales.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import digitales.logica.clases.Imagen;
import java.sql.SQLException;
import java.util.ArrayList;
import master.logica.funciones.FPersona;

/**
 *
 * @author icits
 */
public class FImagen {
    
    public static boolean insertar(Imagen imagen) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from digitales.f_insert_imagen(?,?,?,?,?,?,?)";
            lstP.add(new Parametro(1, imagen.getTitulo()));
            lstP.add(new Parametro(2, imagen.getPath()));
            lstP.add(new Parametro(3, imagen.getTipo()));
            lstP.add(new Parametro(4, imagen.getKeywords()));
            lstP.add(new Parametro(5, imagen.getFecha_registro()));
            lstP.add(new Parametro(6, imagen.getEstado()));
            lstP.add(new Parametro(7, imagen.getCodigo_persona().getCodigo_persona()));
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
    
    public static boolean actualizar(Imagen imagen) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from digitales.f_update_imagen(?,?,?,?,?,?,?,?)";
             lstP.add(new Parametro(1, imagen.getTitulo()));
             lstP.add(new Parametro(2, imagen.getPath()));
             lstP.add(new Parametro(3, imagen.getTipo()));
             lstP.add(new Parametro(4, imagen.getKeywords()));
             lstP.add(new Parametro(5, imagen.getFecha_registro()));
             lstP.add(new Parametro(6, imagen.getEstado()));
             lstP.add(new Parametro(7, imagen.getCodigo_persona().getCodigo_persona()));
             lstP.add(new Parametro(8, imagen.getCodigo()));
            
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
    
    public static boolean eliminar(Imagen imagen) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from digitales.f_delete_imagen(?)";
            lstP.add(new Parametro(1, imagen.getCodigo()));
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
    
    public static ArrayList<Imagen> llenarImagen(ConjuntoResultado rs) throws Exception {
        ArrayList<Imagen> lst = new ArrayList<Imagen>();
        Imagen texto = null;
        try {
            while (rs.next()) {
                texto = new Imagen(rs.getInt("pcodigo"),
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

    public static ArrayList<Imagen> obtenerTodos() throws Exception {
        ArrayList<Imagen> lst = new ArrayList<Imagen>();
        try {
            String sql = "select * from digitales.f_select_imagen()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarImagen(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
     public static Imagen obtenerImagenDadoCodigo(int codigo) throws Exception {
        Imagen objImagen = new Imagen();
        try {
            String sql = "select * from digitales.f_select_imagen_dado_codigo(?)";
            ArrayList<Parametro> lstP = new ArrayList<Parametro>(); 
            lstP .add(new Parametro(1,codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql,lstP);
            objImagen = llenarImagen(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return objImagen;
    }
     
     public static Imagen obtenerImagenDadoArticulo(int codigo) throws Exception {
        Imagen objImagen = new Imagen();
        try {
            String sql = "select * from digitales.f_select_imagen_dado_articulo(?)";
            ArrayList<Parametro> lstP = new ArrayList<Parametro>(); 
            lstP .add(new Parametro(1,codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql,lstP);
            objImagen = llenarImagen(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return objImagen;
    }
     
     public static ArrayList<Imagen> obtenerListaImagenDadoArticulo(int codigo) throws Exception {
        ArrayList<Imagen> lstImagen = new ArrayList<Imagen>();
        try {
            String sql = "select * from digitales.f_select_imagen_dado_articulo(?)";
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lstImagen = llenarImagen(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lstImagen;
    }
     
}
