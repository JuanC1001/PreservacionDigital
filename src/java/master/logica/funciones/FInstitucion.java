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
import master.logica.clases.Institucion;

/**
 *
 * @author DiegoPalacios
 */
public class FInstitucion {
    
   public static boolean insertar(Institucion institucion) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master_movilizacion.f_insert_institucion(?,?,?,?,?,?)";
            lstP.add(new Parametro(1, institucion.getNombre()));
            lstP.add(new Parametro(2, institucion.getDireccion()));
            lstP.add(new Parametro(3,institucion.getCiudad()));
            lstP.add(new Parametro(4, institucion.getTelefono()));
            lstP.add(new Parametro(5, institucion.getRuc()));
            lstP.add(new Parametro(6, institucion.getGerente()));
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
   
   public static boolean actualizar(Institucion institucion) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master_movilizacion.f_update_institucion(?,?,?,?,?,?,?)";
            lstP.add(new Parametro(1, institucion.getNombre()));
            lstP.add(new Parametro(2, institucion.getDireccion()));
            lstP.add(new Parametro(3, institucion.getCiudad()));
            lstP.add(new Parametro(4, institucion.getTelefono()));
            lstP.add(new Parametro(5, institucion.getRuc()));
            lstP.add(new Parametro(6, institucion.getGerente()));
            lstP.add(new Parametro(7, institucion.getCodigo()));
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
   
   public static boolean eliminar(Institucion institucion) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master_movilizacion.f_delete_institucion(?)";
            lstP.add(new Parametro(1, institucion.getCodigo()));
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
   
 public static ArrayList<Institucion> llenarInstituciones(ConjuntoResultado rs) throws Exception
      {
          ArrayList<Institucion> lst = new ArrayList<Institucion>();
          Institucion grupo=null;
          try {
            while(rs.next())
            {
                     grupo= new Institucion(rs.getInt("pcodigo"),
                             rs.getString("pnombre"), rs.getString("pdireccion"), rs.getString("pciudad"),
                             rs.getString("ptelefono"), rs.getString("pruc"), rs.getString("pgerente"));
                     lst.add(grupo);
            }
            } catch (Exception e) {
                 lst.clear();
//                 integracion.auditoria.log ublog = new integracion.auditoria.log();
//                 ublog.write("Modulo", "llenarModulos", e.getClass().getName(), e.getMessage());
                 throw e;
          }
         return lst;
      }
    public static Institucion ObtenerInstitucionDadoCodigo(int codigo) throws Exception
    {
       Institucion lst;
          try
        {
         ArrayList<Parametro> lstP = new ArrayList<Parametro>();
         String sql = "select * from master_movilizacion.f_select_institucion_dado_codigo(?)";
         lstP.add(new Parametro(1,codigo));
         ConjuntoResultado rs= AccesoDatos.ejecutaQuery(sql,lstP);
         lst= new Institucion();
         lst= llenarInstituciones(rs).get(0);
         rs=null;
        } catch (SQLException exConec) {
               throw  new Exception(exConec.getMessage());
         }
          return lst;
    }
    
    public static  ArrayList<Institucion> ObtenerInstituciones() throws Exception
    {
       ArrayList<Institucion> lst = new ArrayList<Institucion>();
          try
        {
         String sql = "select * from master_movilizacion.f_select_institucion_todos()";
         ConjuntoResultado rs= AccesoDatos.ejecutaQuery(sql);
         lst= llenarInstituciones(rs);
          rs=null;

        } catch (SQLException exConec) {
               throw  new Exception(exConec.getMessage());
         }
          return lst;
    }
}
