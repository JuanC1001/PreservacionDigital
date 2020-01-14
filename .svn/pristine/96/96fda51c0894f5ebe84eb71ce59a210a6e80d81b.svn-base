/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package master.logica.funciones;

import accesodatos.*;
import java.sql.SQLException;
import java.util.ArrayList;
import master.logica.clases.Funcion;
import master.logica.clases.UsuarioPersona;
import master.logica.clases.UsuarioRol;

/**
 *
 * @author DiegoPalacios
 */
public class FUsuarioPersona {
//<<<<<<< .mine

    public static boolean insertar(UsuarioPersona usuarioPersona) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master_movilizacion.f_insert_usuario_persona(?,?,?)";
            lstP.add(new Parametro(1, usuarioPersona.getCodigo_titular().getCodigo_persona()));
            lstP.add(new Parametro(2, usuarioPersona.getCodigo_usuario().getCodigo()));
            lstP.add(new Parametro(3, usuarioPersona.getEstado()));
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

    public static boolean actualizar(UsuarioPersona usuarioPersona) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master_movilizacion.f_update_usuario_persona(?,?,?,?)";
            lstP.add(new Parametro(1, usuarioPersona.getCodigo_titular().getCodigo_persona()));
            lstP.add(new Parametro(2, usuarioPersona.getCodigo_usuario().getCodigo()));
            lstP.add(new Parametro(3, usuarioPersona.getEstado()));
            lstP.add(new Parametro(4, usuarioPersona.getCodigo()));
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
    
     public static ArrayList<UsuarioPersona> llenarUsuarioPersona(ConjuntoResultado rs) throws Exception
      {
          ArrayList<UsuarioPersona> lst = new ArrayList<UsuarioPersona>();
          UsuarioPersona upersona=null;
          try {
            while(rs.next())
            {
                     upersona= new UsuarioPersona(rs.getInt("pcodigo"), 
                             FPersona.ObtenerPersonaDadoCodigo(rs.getLong("pcodigo_persona")), 
                             FUsuario.ObtenerUsuarioDadoCodigo(rs.getLong("pcodigo_usuario")), 
                             rs.getInt("pestado"));
                     lst.add(upersona);
            }
            } catch (Exception e) {
                 lst.clear();
                 throw e;
          }
         return lst;
      }
     
       public static  ArrayList<UsuarioPersona> obtenerUsuarioPersonas() throws Exception
    {
       ArrayList<UsuarioPersona> lst = new ArrayList<UsuarioPersona>();
        try
        {
         String sql = "select * from master_movilizacion.f_select_usuarios_personas()";
         ConjuntoResultado rs= AccesoDatos.ejecutaQuery(sql);
         lst= llenarUsuarioPersona(rs);
         rs=null;
        } catch (SQLException exConec) {
               throw  new Exception(exConec.getMessage());
         }
          return lst;
    }
       
    
    public static UsuarioPersona obtenerUsuarioPersonaDadoCodigo(int codigo) throws Exception
    {
       UsuarioPersona lst;
          try
        {
         ArrayList<Parametro> lstP = new ArrayList<Parametro>();
         String sql = "select * from master_movilizacion.f_select_usuarios_persona_dado_codigo(?)";
         lstP.add(new Parametro(1,codigo));
         ConjuntoResultado rs= AccesoDatos.ejecutaQuery(sql,lstP);
         lst= new UsuarioPersona();
         lst= llenarUsuarioPersona(rs).get(0);
         rs=null;
        } catch (SQLException exConec) {
               throw  new Exception(exConec.getMessage());
         }
          return lst;
    }
        
    public static UsuarioPersona obtenerUsuarioPersonaDadoCodigoUsuario(long codigo) throws Exception
    {
       UsuarioPersona lst;
          try
        {
         ArrayList<Parametro> lstP = new ArrayList<Parametro>();
         String sql = "select * from master_movilizacion.f_select_usuarios_persona_dado_cod_usuario(?)";
         lstP.add(new Parametro(1,codigo));
         ConjuntoResultado rs= AccesoDatos.ejecutaQuery(sql,lstP);
         lst= new UsuarioPersona();
         lst= llenarUsuarioPersona(rs).get(0);
         rs=null;
        } catch (SQLException exConec) {
               throw  new Exception(exConec.getMessage());
         }
          return lst;
    }
//=======
//
   
        public static UsuarioPersona obtenerUsuarioPersonaDadoCodigo(long codigo) throws Exception
    {
       UsuarioPersona lst;
          try
        {
         ArrayList<Parametro> lstP = new ArrayList<Parametro>();
         String sql = "select * from master_movilizacion.f_select_usuarios_persona_dado_codigo(?)";
         lstP.add(new Parametro(1,codigo));
         ConjuntoResultado rs= AccesoDatos.ejecutaQuery(sql,lstP);
         lst= new UsuarioPersona();
         lst= llenarUsuarioPersona(rs).get(0);
         rs=null;
        } catch (SQLException exConec) {
               throw  new Exception(exConec.getMessage());
         }
          return lst;
    }
        
    
}
