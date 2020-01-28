/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivo.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import archivo.logica.clases.TecnicasIn;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ruben
 */
public class FTecnicasIn {
    
    public static ArrayList<TecnicasIn> llenarTecnicasIn(ConjuntoResultado rs) throws Exception {
        ArrayList<TecnicasIn> lst = new ArrayList<TecnicasIn>();
        TecnicasIn texto = null;
        try {
            while (rs.next()) {
                texto = new TecnicasIn(rs.getInt("pcodigo"),
                        rs.getString("ppath"),
                        rs.getString("ptecnica"),
                        rs.getString("pdetalle"));
                lst.add(texto);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<TecnicasIn> obtenerTecnicasIn() throws Exception {
        ArrayList<TecnicasIn> lst = new ArrayList<TecnicasIn>();
        try {
            //ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from archivo_municipio.f_select_tipo_departamentoin()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            // lst = new Persona();
            lst = llenarTecnicasIn(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static TecnicasIn ObtenerTecnicasInDadoCodigoin(int codigo) throws Exception {
        TecnicasIn lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from archivo_municipio.f_select_tecnicas_dado_codigoin(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarTecnicasIn(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
}
