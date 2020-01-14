/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evidencia.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import evidencia.logica.clases.Metadatos_Documento;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Janneth GS
 */
public class FMetadatos_Documentos {

    //llenar documentos      
    public static ArrayList<Metadatos_Documento> llenarMetadatosDocumentos(ConjuntoResultado rs) throws Exception {
        ArrayList<Metadatos_Documento> lst = new ArrayList<Metadatos_Documento>();
        Metadatos_Documento texto = null;
        try {
            while (rs.next()) {
                texto = new Metadatos_Documento(rs.getInt("pcodigo"),
                        rs.getString("pnombre"),
                        rs.getString("ptipo"),
                        rs.getLong("ptamanio"),
                        rs.getString("pperiodo"),
                        rs.getString("parea"),
                        rs.getString("pdetalle_sw"),
                        rs.getString("pdetalle_hw"));
                lst.add(texto);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    //Llenar metadatos dado codigo
        public static Metadatos_Documento ObtenerMetadatosDocumentoDadoCodigo(int codigo) throws Exception {
        Metadatos_Documento lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from archivos.f_select_metadatos_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarMetadatosDocumentos(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    

//        public static Metadatos_Documento obtenerMetadatos_Documento_CodigoDocumento(int codigo_documento) throws Exception {
//        Metadatos_Documento lst;
//        try {
//            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
//            String sql = "select * from archivo.f_select_metadato_dado_kcodigo_documento(?)";
//            lstP.add(new Parametro(1, codigo_documento));
//            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
//            lst = new Metadatos_Documento();
//            lst = llenarMetadatosDocumentos(rs).get(0);
//            rs = null;
//        } catch (SQLException exConec) {
//            throw new Exception(exConec.getMessage());
//        }
//        return lst;
//    }


}
