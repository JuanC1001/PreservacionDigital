/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivo.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import archivo.logica.clases.MetadatosIn;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ruben
 */
public class FMetadatosIn {
     public static ArrayList<MetadatosIn> llenarMetadatosIn(ConjuntoResultado rs) throws Exception {
        ArrayList<MetadatosIn> lst = new ArrayList<MetadatosIn>();
        MetadatosIn texto = null;
        try {
            while (rs.next()) {
                texto = new MetadatosIn(rs.getInt("pcodigo"),
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

    public static ArrayList<MetadatosIn> obtenerMetadatosIn() throws Exception {
        ArrayList<MetadatosIn> lst = new ArrayList<MetadatosIn>();
        try {
            //ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from archivo_municipio.f_select_metadatosin()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            // lst = new Persona();
            lst = llenarMetadatosIn(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static MetadatosIn ObtenerMetadatosInDadoCodigo(int codigo) throws Exception {
        MetadatosIn lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from  archivo_municipio.f_select_metadatos_dado_codigoin(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarMetadatosIn(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
}
