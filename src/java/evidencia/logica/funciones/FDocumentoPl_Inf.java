/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evidencia.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import evidencia.logica.clases.DocumentoPlInf;
import java.sql.SQLException;
import java.util.ArrayList;
import master.logica.funciones.FUsuarioRol;

/**
 *
 * @author ruben
 */
public class FDocumentoPl_Inf {
    public static boolean insertar(DocumentoPlInf documento) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from evidencia_juridicos.f_insert_documentoplaniinf(?,?,?,?,?,?,?)";
            lstP.add(new Parametro(1, documento.getCodigo_usuario_rol().getCodigo()));
            lstP.add(new Parametro(2, documento.getTitulo_ducumento()));
            lstP.add(new Parametro(3, documento.getDetalles()));
            lstP.add(new Parametro(4, documento.getTitulo()));
            lstP.add(new Parametro(5, documento.getPath()));
            lstP.add(new Parametro(6, documento.getTipo()));
            lstP.add(new Parametro(7, documento.getKeywords()));
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

    public static boolean actualizar(DocumentoPlInf documento) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from evidencia_juridicos.f_update_documentoplaniinf(?,?,?,?,?,?,?,?,?)";
            lstP.add(new Parametro(1, documento.getCodigo_usuario_rol().getCodigo()));
            lstP.add(new Parametro(2, documento.getTitulo_ducumento()));
            lstP.add(new Parametro(3, documento.getDetalles()));
            lstP.add(new Parametro(4, documento.getTitulo()));
            lstP.add(new Parametro(5, documento.getPath()));
            lstP.add(new Parametro(6, documento.getTipo()));
            lstP.add(new Parametro(7, documento.getKeywords()));
            lstP.add(new Parametro(8, documento.getFecha_registro()));
            lstP.add(new Parametro(9, documento.getCodigo()));

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

    public static boolean eliminar(DocumentoPlInf documento) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from evidencia_juridicos.f_delete_documentoplaniinf(?)";
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

    public static ArrayList<DocumentoPlInf> llenarDocumento(ConjuntoResultado rs) throws Exception {
        ArrayList<DocumentoPlInf> lst = new ArrayList<DocumentoPlInf>();
        DocumentoPlInf texto = null;
        try {
            while (rs.next()) {
                texto = new DocumentoPlInf(
                        rs.getInt("pcodigo"),
                        FUsuarioRol.ObtenerUsuarioRolDadoCodigo(rs.getInt("pcodigo_usuario_rol")),
                        rs.getString("ptitulo_ducumento"),
                        rs.getString("pdetalles"),
                        rs.getString("ptitulo"),
                        rs.getString("ppath"),
                        rs.getString("ptipo"),
                        rs.getString("pkeywords"),
                        rs.getDate("pfecha_registro"));
                lst.add(texto);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<DocumentoPlInf> obtenerTodos() throws Exception {
        ArrayList<DocumentoPlInf> lst = new ArrayList<DocumentoPlInf>();
        try {
            String sql = "select * from evidencia_juridicos.f_select_documentoplaniinf()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarDocumento(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
}
