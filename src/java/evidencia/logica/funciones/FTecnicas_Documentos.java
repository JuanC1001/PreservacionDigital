/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evidencia.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import evidencia.logica.clases.Tecnicas;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author 
 * //    
 * //revisar posblemente no esta siendo usado el esquema ARCHIVOS

 */
public class FTecnicas_Documentos {
        //llenar documentos      
//    public static ArrayList<Tecnicas> llenarTecnicasDocumentos(ConjuntoResultado rs) throws Exception {
//        ArrayList<Tecnicas> lst = new ArrayList<Tecnicas>();
//        Tecnicas texto = null;
//        try {
//            while (rs.next()) {
//                texto = new Tecnicas(rs.getInt("pcodigo"),
//                        rs.getString("ppath"),
//                        rs.getString("ptecnica"),
//                        rs.getString("pdetalle"));
//                lst.add(texto);
//            }
//        } catch (Exception e) {
//            lst.clear();
//            throw e;
//        }
//        return lst;
//    }
//    
//            public static Tecnicas ObtenerTecnicasDocumentoDadoCodigo(int codigo) throws Exception {
//        Tecnicas lst;
//        try {
//            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
//            String sql = "select * from archivos.f_select_tecnicas_dado_codigo(?)";
//            lstP.add(new Parametro(1, codigo));
//            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
//            lst = llenarTecnicasDocumentos(rs).get(0);
//            rs = null;
//        } catch (SQLException exConec) {
//            throw new Exception(exConec.getMessage());
//        }
//        return lst;
//    }
    
}
