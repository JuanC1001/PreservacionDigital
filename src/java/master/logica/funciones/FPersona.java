/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package master.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.Conexion;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import java.sql.SQLException;
import java.util.ArrayList;
import master.logica.clases.*;
import master.logica.clases.Persona;

/**
 *
 * @author DiegoPalacios
 */
public class FPersona {
    
public static  boolean insertar (Persona persona) throws  Exception
    {
        boolean eje=false;
         try
        {
        ArrayList<Parametro> lstP = new ArrayList<Parametro>();
        String sql = "select * from master_movilizacion.f_insert_persona(?,?,?,?,?,?)";
        lstP.add(new Parametro(1,persona.getCodigo_global()));
        lstP.add(new Parametro(2,persona.getApellido()));
        lstP.add(new Parametro(3,persona.getNombre()));
        lstP.add(new Parametro(4,persona.getCedula()));
        lstP.add(new Parametro(5,persona.getPasaporte()));
        lstP.add(new Parametro(6,persona.getMail()));
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

public static boolean actualizar(Persona p) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master_movilizacion.f_update_persona(?,?,?,?,?,?,?)";
            lstP.add(new Parametro(1, p.getCodigo_global()));
            lstP.add(new Parametro(2, p.getApellido()));
            lstP.add(new Parametro(3, p.getNombre()));
            lstP.add(new Parametro(4, p.getCedula()));
            lstP.add(new Parametro(5, p.getPasaporte()));
            lstP.add(new Parametro(6, p.getMail()));
            lstP.add(new Parametro(7, p.getCodigo_persona()));
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

    public static boolean eliminar(long codigo) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master_movilizacion.f_delete_persona(?)";
            lstP.add(new Parametro(1, codigo));
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

    public static ArrayList<Persona> llenarPersona(ConjuntoResultado rs) throws Exception {
        ArrayList<Persona> lst = new ArrayList<Persona>();
        Persona persona = null;
        try {
            while (rs.next()) {
                persona = new Persona(rs.getLong("pcodigo_global"),
                        rs.getLong("pcodigo_persona"),
                        rs.getString("papellido"), 
                        rs.getString("pnombres"), rs.getString("pcedula"),
                        rs.getString("ppasaporte"), rs.getString("pmail"));
                lst.add(persona);

            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }
//
    
    public static Persona ObtenerPersonaDadoCodigo(long codigo) throws Exception {
        Persona lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master_movilizacion.f_select_persona_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Persona();
            lst = llenarPersona(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    public static  ArrayList<Persona> ObtenerPersonaDadoCedula(String cedula) throws Exception {
         ArrayList<Persona> lst = new ArrayList<Persona>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master_movilizacion.f_select_persona_dado_cedula(?)";
            lstP.add(new Parametro(1, cedula));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
         //  lst = new Persona();
            lst = llenarPersona(rs);
            rs = null;
           } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static  Persona  ObtenerPersonaDadoCedula1(String cedula) throws Exception 
    {
   Persona lst; 
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master_movilizacion.f_select_persona_dado_cedula1(?)";
            lstP.add(new Parametro(1, cedula));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
         //  lst = new Persona();
            lst = new Persona();
            lst= llenarPersona(rs).get(0);
            rs = null;
           } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    
      public static  ArrayList<Persona> ObtenerPersonaDadoApellido(String apellido) throws Exception {
         ArrayList<Persona> lst = new ArrayList<Persona>();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master_movilizacion.f_select_persona_dado_apellido(?)";
            lstP.add(new Parametro(1, apellido));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
           // lst = new Persona();
            lst = llenarPersona(rs);
            rs = null;
           } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
      
      public static  ArrayList<Persona> obtenerTodasPersonas() throws Exception {
         ArrayList<Persona> lst = new ArrayList<Persona>();
        try {
            //ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master_movilizacion.f_select_persona()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
           // lst = new Persona();
            lst= llenarPersona(rs);
            rs = null;
           } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
}
