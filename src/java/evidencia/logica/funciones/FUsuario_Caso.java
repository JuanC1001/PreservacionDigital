/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evidencia.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import evidencia.logica.clases.Usuario_Caso;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author 
 */
public class FUsuario_Caso {

//    public static ArrayList<Usuario_Caso> llenarUsuarioCaso(ConjuntoResultado rs)
//            throws Exception {
//        ArrayList<Usuario_Caso> lst = new ArrayList();
//        Usuario_Caso texto = null;
//        try {
//            while (rs.next()) {
//                texto = new Usuario_Caso(rs.getInt("pcodigo"),
//                        FPersona.ObtenerPersonasDadoCodigo(rs.getInt("pcodigo_persona")),
//                        FTipo_Usuario.ObtenerTipoUsuarioDadoCodigo(rs.getInt("pcodigo_tipo_usuario")),
//                        FCaso.ObtenerCasoDadoCodigo(rs.getInt("pcodigo_caso")));
//                lst.add(texto);
//            }
//        } catch (Exception e) {
//            lst.clear();
//            throw e;
//        }
//        return lst;
//    }
//
//    public static ArrayList<Usuario_Caso> obtenerUsuarioCaso()
//            throws Exception {
//        ArrayList<Usuario_Caso> lst = new ArrayList();
//        try {
//            String sql = "select * from evidencia.f_select_usuario_caso()";
//            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
//
//            lst = llenarUsuarioCaso(rs);
//            rs = null;
//        } catch (SQLException exConec) {
//            throw new Exception(exConec.getMessage());
//        }
//        return lst;
//    }
//
//    
//    
//    //REVISAR porque posiblemente el esquema EVIDENCIA  no esta siendo usadas
//    
//    
//        public static Usuario_Caso ObtenerUsuarioCasoDadoCodigo(String codigo_caso) throws Exception {
//        Usuario_Caso lst;
//        try {
//            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
//            String sql = "select * from evidencia.f_select_usuario_caso_caso_codigo(?)";
//            lstP.add(new Parametro(1, codigo_caso));
//            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
//            lst = new Usuario_Caso();
//            lst = llenarUsuarioCaso(rs).get(0);
//            rs = null;
//        } catch (SQLException exConec) {
//            throw new Exception(exConec.getMessage());
//        }
//        return lst;
//        
//    }
//    
    

}
