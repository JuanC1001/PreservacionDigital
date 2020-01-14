/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evidencia.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import evidencia.logica.clases.Metadatos;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author RUBEN
 */
public class FMetadatos {

    public static ArrayList<Metadatos> llenarMetadatos(ConjuntoResultado rs) throws Exception {
        ArrayList<Metadatos> lst = new ArrayList<Metadatos>();
        Metadatos texto = null;
        try {
            while (rs.next()) {
                texto = new Metadatos(rs.getInt("pcodigo"),
                        rs.getString("pnombre"),
                        rs.getString("ptipo"),
                        rs.getLong("ptamanio"));
                lst.add(texto);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<Metadatos> obtenerMetadatos() throws Exception {
        ArrayList<Metadatos> lst = new ArrayList<Metadatos>();
        try {
            //ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from evidencia_juridicos.f_select_metadatos()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            // lst = new Persona();
            lst = llenarMetadatos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static Metadatos ObtenerMetadatosDadoCodigo(int codigo) throws Exception {
        Metadatos lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from  evidencia_juridicos.f_select_metadatos_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarMetadatos(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
}
