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
import master.logica.clases.Funcion;

/**
 *
 * @author DiegoPalacios
 */
public class FFuncion {
    public static  boolean Insertar (Funcion funcion) throws  Exception
    {
        boolean eje=false;
         try
        {
        ArrayList<Parametro> lstP = new ArrayList<Parametro>();
        String sql = "select * from master_movilizacion.f_insert_funcion(?,?,?,?,?,?,?,?,?)";
        lstP.add(new Parametro(1,funcion.getCodigo_accion().getCodigo()));
        lstP.add(new Parametro(2,funcion.getCodigo_rol().getCodigo()));
        lstP.add(new Parametro(3,funcion.getCodigo_grupo_menus().getCodigo()));
        lstP.add(new Parametro(4,funcion.getOrden()));
        lstP.add(new Parametro(5,funcion.getEstado()));
        lstP.add(new Parametro(6,funcion.isInsertar()));
        lstP.add(new Parametro(7,funcion.isActualizar()));
        lstP.add(new Parametro(8,funcion.isEliminar()));
        lstP.add(new Parametro(9,funcion.isVer()));
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
    
     public static  boolean Actualizar (Funcion funcion) throws  Exception
    {
        boolean eje=false;
         try
        {
        ArrayList<Parametro> lstP = new ArrayList<Parametro>();
        String sql = "select * from master_movilizacion.f_update_funcion(?,?,?,?,?,?,?,?,?,?)";
        lstP.add(new Parametro(1,funcion.getCodigo_accion().getCodigo()));
        lstP.add(new Parametro(2,funcion.getCodigo_rol().getCodigo()));
        lstP.add(new Parametro(3,funcion.getCodigo_grupo_menus().getCodigo()));
        lstP.add(new Parametro(4,funcion.getOrden()));
        lstP.add(new Parametro(5,funcion.getEstado()));
        lstP.add(new Parametro(6,funcion.isInsertar()));
        lstP.add(new Parametro(7,funcion.isActualizar()));
        lstP.add(new Parametro(8,funcion.isEliminar()));
        lstP.add(new Parametro(9,funcion.isVer()));
        lstP.add(new Parametro(10,funcion.getCodigo()));
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
     
        public static  boolean Eliminar (int codigo) throws  Exception
    {
        boolean eje=false;
         try
        {
        ArrayList<Parametro> lstP = new ArrayList<Parametro>();
        String sql = "select * from master_movilizacion.f_delete_funcion(?)";
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
        
          public static ArrayList<Funcion> llenarFunciones(ConjuntoResultado rs) throws Exception
      {
          ArrayList<Funcion> lst = new ArrayList<Funcion>();
          Funcion funcion=null;
          try {
            while(rs.next())
            {
                     funcion= new Funcion(rs.getInt("pcodigo"), FAccion.ObtenerAccionDadoCodigo(rs.getInt("pcodigo_accion")),
                             FRoles.ObtenerRolDadoCodigo(rs.getInt("pcodigo_rol")), FGrupo_Menus.ObtenerGrupoMenuDadoCodigo(rs.getInt("pcodigo_grupo_menus")),
                             rs.getInt("porden"), rs.getInt("pestado"), rs.getBoolean("pinsertar"),rs.getBoolean("pactualizar"),
                             rs.getBoolean("peliminar"),rs.getBoolean("pver"));
                     lst.add(funcion);
            }
            } catch (Exception e) {
                 lst.clear();
               //  integracion.auditoria.log ublog = new integracion.auditoria.log();
                // ublog.write("Modulo", "llenarModulos", e.getClass().getName(), e.getMessage());
                 throw e;
          }
         return lst;
      }
          
    public static  ArrayList<Funcion> ObtenerFunciones() throws Exception
    {
       ArrayList<Funcion> lst = new ArrayList<Funcion>();
        try
        {
         String sql = "select * from master_movilizacion.f_select_funciones()";
         ConjuntoResultado rs= AccesoDatos.ejecutaQuery(sql);
         lst= llenarFunciones(rs);
         rs=null;
        } catch (SQLException exConec) {
               throw  new Exception(exConec.getMessage());
         }
          return lst;
    }
    public static Funcion ObtenerFuncionDadoCodigo(int codigo) throws Exception
    {
       Funcion lst;
          try

        {
         ArrayList<Parametro> lstP = new ArrayList<Parametro>();
         String sql = "select * from master_movilizacion.f_select_funciones_dado_codigo(?)";
         lstP.add(new Parametro(1,codigo));
         ConjuntoResultado rs= AccesoDatos.ejecutaQuery(sql,lstP);
         lst= new Funcion();
         lst= llenarFunciones(rs).get(0);
         rs=null;
        } catch (SQLException exConec) {
               throw  new Exception(exConec.getMessage());
         }
          return lst;
    }
     public static  ArrayList<Funcion> ObtenerFuncionesDadoRol_PadreGruposMenus(int cod_rol, int cod_padre) throws Exception
    {
       ArrayList<Funcion> lst = new ArrayList<Funcion>();
        try
        {
         ArrayList<Parametro> lstP = new ArrayList<Parametro>();
         String sql = "select * from master_movilizacion.f_select_funciones_dado_rol_padre_grupo_menu(?,?)";
         lstP.add(new Parametro(1,cod_rol));
         lstP.add(new Parametro(2,cod_padre));
         ConjuntoResultado rs= AccesoDatos.ejecutaQuery(sql,lstP);
         lst= llenarFunciones(rs);
         rs=null;
        } catch (SQLException exConec) {
               throw  new Exception(exConec.getMessage());
         }
          return lst;
    }
}
