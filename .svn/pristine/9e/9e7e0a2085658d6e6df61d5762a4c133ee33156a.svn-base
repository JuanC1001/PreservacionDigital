/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package digitales.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import digitales.logica.clases.Documento;
import java.sql.SQLException;
import java.util.ArrayList;
import master.logica.funciones.FPersona;

/**
 *
 * @author icits
 */
public class FDocumento {
    
     public static boolean insertar(Documento documento) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from digitales.f_insert_documento(?,?,?,?,?,?,?)";
            lstP.add(new Parametro(1, documento.getTitulo()));
            lstP.add(new Parametro(2, documento.getPath()));
            lstP.add(new Parametro(3, documento.getTipo()));
            lstP.add(new Parametro(4, documento.getKeywords()));
            lstP.add(new Parametro(5, documento.getFecha_registro()));
            lstP.add(new Parametro(6, documento.getEstado()));
            lstP.add(new Parametro(7, documento.getCodigo_persona().getCodigo_persona()));
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
    
    public static boolean actualizar(Documento documento) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from digitales.f_update_documento(?,?,?,?,?,?,?,?,?)";
             lstP.add(new Parametro(1, documento.getTitulo()));
             lstP.add(new Parametro(2, documento.getPath()));
             lstP.add(new Parametro(3, documento.getTipo()));
             lstP.add(new Parametro(4, documento.getKeywords()));
             lstP.add(new Parametro(5, documento.getFecha_registro()));
             lstP.add(new Parametro(6, documento.getEstado()));
             lstP.add(new Parametro(7, documento.getCodigo_persona().getCodigo_persona()));
             lstP.add(new Parametro(8, documento.getCodigo()));
            
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
    
    public static boolean eliminar(Documento documento) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from digitales.f_delete_documento(?)";
            lstP.add(new Parametro(1, documento.getCodigo()));
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
    
    public static ArrayList<Documento> llenarDocumento(ConjuntoResultado rs) throws Exception {
        ArrayList<Documento> lst = new ArrayList<Documento>();
        Documento texto = null;
        try {
            while (rs.next()) {
                texto = new Documento(rs.getInt("pcodigo"),
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

    public static ArrayList<Documento> obtenerTodos() throws Exception {
        ArrayList<Documento> lst = new ArrayList<Documento>();
        try {
            String sql = "select * from digitales.f_select_documento()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarDocumento(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
     public static Documento obtenerDocumentoDadoCodigo(int codigo) throws Exception {
        Documento objCliente = new Documento();
        try {
            String sql = "select * from digitales.f_select_documento_dado_codigo(?)";
            ArrayList<Parametro> lstP = new ArrayList<Parametro>(); 
            lstP .add(new Parametro(1,codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql,lstP);
            objCliente = llenarDocumento(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return objCliente;
    }
     
     public static Documento obtenerDocumentoDadoArticulo(int codigo) throws Exception {
        Documento objDocumento = new Documento();
        try {
            String sql = "select * from digitales.f_select_documento_dado_articulo(?)";
            ArrayList<Parametro> lstP = new ArrayList<Parametro>(); 
            lstP .add(new Parametro(1,codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql,lstP);
            objDocumento = llenarDocumento(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return objDocumento;
    }
     
     public static ArrayList<Documento> obtenerListaDocumentoDadoArticulo(int codigo) throws Exception {
        ArrayList<Documento> lstDocumento = new ArrayList<Documento>();
        try {
            String sql = "select * from digitales.f_select_documento_dado_articulo(?)";
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lstDocumento = llenarDocumento(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lstDocumento;
    }
}
