/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package master.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import java.sql.SQLException;
import java.util.ArrayList;
import master.logica.clases.Accion;

/**
 *
 * @author DiegoPalacios
 */
public class FAccion {

    public static boolean Insertar(Accion accion) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master_movilizacion.f_insert_accion(?,?,?,?)";
            lstP.add(new Parametro(1, accion.getUrl()));
            lstP.add(new Parametro(2, accion.isEstado()));
            lstP.add(new Parametro(3, accion.getTitulo()));
            lstP.add(new Parametro(4, accion.getDescripcion()));
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

    public static ArrayList<Accion> llenarAcciones(ConjuntoResultado rs) throws Exception {
        ArrayList<Accion> lst = new ArrayList<Accion>();
        Accion accion = null;
        try {
            while (rs.next()) {
                accion = new Accion(rs.getInt("pcodigo"), rs.getString("purl"), rs.getBoolean("pestado"), rs.getString("ptitulo"), rs.getString("pdescripcion"));
                lst.add(accion);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<Accion> ObtenerAcciones() throws Exception {
        ArrayList<Accion> lst = new ArrayList<Accion>();
        try {
            String sql = "select * from master_movilizacion.f_select_acciones()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarAcciones(rs);
            rs = null;

        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static Accion ObtenerAccionDadoCodigo(int codigo) throws Exception {
        Accion lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master_movilizacion.f_select_acciones_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Accion();
            lst = llenarAcciones(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static boolean actualizar(Accion accion) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master_movilizacion.f_update_accion(?,?,?,?,?)";
            lstP.add(new Parametro(1, accion.getUrl()));
            lstP.add(new Parametro(2, accion.isEstado()));
            lstP.add(new Parametro(3, accion.getTitulo()));
            lstP.add(new Parametro(4, accion.getDescripcion()));
            lstP.add(new Parametro(5, accion.getCodigo()));
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
    
       public static  boolean eliminar (int codigo) throws  Exception
    {
        boolean eje=false;
         try
        {
        ArrayList<Parametro> lstP = new ArrayList<Parametro>();
        String sql = "select * from master_movilizacion.f_delete_accion(?)";
        lstP.add(new Parametro(1,codigo));
        ConjuntoResultado rs= AccesoDatos.ejecutaQuery(sql,lstP);
        while(rs.next() )
            {
              if(rs.getString(0).equals("true"));
                   eje=true;
            }
            } catch (SQLException exConec) {
               throw  new Exception(exConec.getMessage());
         }
          return eje;
    }
}
