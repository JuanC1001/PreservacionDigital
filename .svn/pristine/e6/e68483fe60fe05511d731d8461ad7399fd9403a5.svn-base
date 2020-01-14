/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package digitales.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import java.sql.SQLException;
import java.util.ArrayList;
import digitales.logica.clases.Categoria;

/**
 *
 * @author icits
 */
public class FCategoria {
    
    public static boolean insertar(Categoria categoria) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from digitales.f_insert_categoria(?,?,?,?,?)";
            lstP.add(new Parametro(1, categoria.getNombre()));
            lstP.add(new Parametro(2, categoria.getDescripcion()));
            lstP.add(new Parametro(3, categoria.getOrden()));
            lstP.add(new Parametro(4, categoria.getEstado()));
            lstP.add(new Parametro(5, categoria.getCodigo_padre()));
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
    
    public static boolean actualizar(Categoria categoria) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from digitales.f_update_categoria(?,?,?,?,?,?)";
            lstP.add(new Parametro(1, categoria.getNombre()));
            lstP.add(new Parametro(2, categoria.getDescripcion()));
            lstP.add(new Parametro(3, categoria.getOrden()));
            lstP.add(new Parametro(4, categoria.getEstado()));
            lstP.add(new Parametro(5, categoria.getCodigo_padre()));
            lstP.add(new Parametro(6, categoria.getCodigo()));
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
    
    public static boolean eliminar(Categoria categoria) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from digitales.f_delete_categoria(?)";
            lstP.add(new Parametro(1, categoria.getCodigo()));
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
    
    public static ArrayList<Categoria> llenarCategoria(ConjuntoResultado rs) throws Exception {
        ArrayList<Categoria> lst = new ArrayList<Categoria>();
        Categoria categoria = null;
        try {
            while (rs.next()) {
                categoria = new Categoria(rs.getInt("pcodigo"),
                        rs.getString("pnombre"), rs.getString("pdescripcion"), rs.getInt("porden"),
                        rs.getInt("pestado"),rs.getInt("pcodigo_padre"));
                lst.add(categoria);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<Categoria> obtenerTodos() throws Exception {
        ArrayList<Categoria> lst = new ArrayList<Categoria>();
        try {
            String sql = "select * from digitales.f_select_categoria()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarCategoria(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
     public static Categoria obtenerCategoriaDadoCodigo(int codigo) throws Exception {
        Categoria objCliente = new Categoria();
        try {
            String sql = "select * from digitales.f_select_categoria_dado_codigo(?)";
            ArrayList<Parametro> lstP = new ArrayList<Parametro>(); 
            lstP .add(new Parametro(1,codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql,lstP);
            objCliente = llenarCategoria(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return objCliente;
    }
}
