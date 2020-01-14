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
import master.logica.clases.Modulo;

/**
 *
 * @author DiegoPalacios
 */
public class FModulo {
    
    public static boolean insertar(Modulo modulo) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master_movilizacion.f_insert_modulo(?,?,?,?)";
            lstP.add(new Parametro(1, modulo.getNombre()));
            lstP.add(new Parametro(2, modulo.getDescripcion()));
            lstP.add(new Parametro(3, modulo.getEstado()));
            lstP.add(new Parametro(4, modulo.getCodigo_inst().getCodigo()));
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
    
    public static boolean actualizar(Modulo modulo) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master_movilizacion.f_update_modulo(?,?,?,?,?)";
           lstP.add(new Parametro(1, modulo.getNombre()));
            lstP.add(new Parametro(2, modulo.getDescripcion()));
            lstP.add(new Parametro(3, modulo.getEstado()));
            lstP.add(new Parametro(4, modulo.getCodigo_inst().getCodigo()));
            lstP.add(new Parametro(5, modulo.getCodigo()));
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
    
    public static boolean eliminar(Modulo modulo) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master_movilizacion.f_delete_modulo(?)";
            lstP.add(new Parametro(1, modulo.getCodigo()));
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
    
      public static ArrayList<Modulo> llenarModulo(ConjuntoResultado rs) throws Exception
      {
          ArrayList<Modulo> lst = new ArrayList<Modulo>();
          Modulo modulo=null;
          try {
            while(rs.next())
            {
                     modulo= new Modulo(rs.getInt("pcodigo"), rs.getString("pnombre"), rs.getString("pdescripcion"),
                             rs.getInt("pestado"), FInstitucion.ObtenerInstitucionDadoCodigo(rs.getInt("pcodigo_inst")));
                     lst.add(modulo);
            }
            } catch (Exception e) {
                 lst.clear();
                 throw e;
          }
         return lst;
      }
       
         public static  ArrayList<Modulo> ObtenerModulos() throws Exception
    {
       ArrayList<Modulo> lst = new ArrayList<Modulo>();
          try
        {
         String sql = "select * from master_movilizacion.f_select_modulos()";
         ConjuntoResultado rs= AccesoDatos.ejecutaQuery(sql);
         lst= llenarModulo(rs);
          rs=null;

        } catch (SQLException exConec) {
               throw  new Exception(exConec.getMessage());
         }
          return lst;
    }
         
    public static Modulo ObtenerModuloDadoCodigo(int codigo) throws Exception
    {
       Modulo lst;
          try

        {
         ArrayList<Parametro> lstP = new ArrayList<Parametro>();
         String sql = "select * from master_movilizacion.f_select_modulo_dado_codigo(?)";
         lstP.add(new Parametro(1,codigo));
         ConjuntoResultado rs= AccesoDatos.ejecutaQuery(sql,lstP);
         lst= new Modulo();
         lst= llenarModulo(rs).get(0);
         rs=null;
        } catch (SQLException exConec) {
               throw  new Exception(exConec.getMessage());
         }
          return lst;
    }
}
