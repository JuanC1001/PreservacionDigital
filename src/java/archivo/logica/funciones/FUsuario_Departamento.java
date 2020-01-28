/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivo.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import archivo.logica.clases.Usuario_Departamento;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author RUBEN
 */
public class FUsuario_Departamento {

    public static ArrayList<Usuario_Departamento> llenarUsuarioDepartamento(ConjuntoResultado rs)
            throws Exception {
        ArrayList<Usuario_Departamento> lst = new ArrayList();
        Usuario_Departamento texto = null;
        try {
            while (rs.next()) {
                texto = new Usuario_Departamento(rs.getInt("pcodigo"),
                        FPersona.ObtenerPersonasDadoCodigo(rs.getInt("pcodigo_persona")),
                        FTipo_Usuario.ObtenerTipoUsuarioDadoCodigo(rs.getInt("pcodigo_tipo_usuario")),
                        FDepartamento.ObtenerDepartamentoDadoCodigo(rs.getInt("pcodigo_departamento")));
                lst.add(texto);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<Usuario_Departamento> obtenerUsuarioDepartamento()
            throws Exception {
        ArrayList<Usuario_Departamento> lst = new ArrayList();
        try {
            String sql = "select * from archivo.f_select_usuario_departamento()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);

            lst = llenarUsuarioDepartamento(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

   /* public static ArrayList<Usuario_Departamento> obtenerUsuarioDepartamentoCodigo_Departamento(String codigo_departamento)
            throws Exception {
        ArrayList<Usuario_Departamento> lst = new ArrayList();
        try {
            ArrayList<Parametro> lstP = new ArrayList();
            String sql = "select * from archivos.f_select_documento_autor_dado_tipo(?)";
            lstP.add(new Parametro(1, codigo_departamento));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarUsuarioDepartamento(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }*/
    
        public static Usuario_Departamento ObtenerUsuarioDepartamentoDadoCodigo(String codigo_departamento) throws Exception {
        Usuario_Departamento lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from archivo.f_select_usuario_departamento_departamento_codigo(?)";
            lstP.add(new Parametro(1, codigo_departamento));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Usuario_Departamento();
            lst = llenarUsuarioDepartamento(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
        
    }
    
    

}
