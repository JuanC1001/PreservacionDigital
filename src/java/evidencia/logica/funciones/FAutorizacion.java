/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evidencia.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import evidencia.logica.clases.AutorizacionJuez;
import java.sql.SQLException;

import java.util.ArrayList;
import master.logica.funciones.FUsuarioRol;

/**
 *
 * @author 
 */
public class FAutorizacion {

    public static ArrayList<AutorizacionJuez> llenarAutorizacionJues(ConjuntoResultado rs)
            throws Exception {
        ArrayList<AutorizacionJuez> lst = new ArrayList();
        AutorizacionJuez autorizacion = null;
        try {
            while (rs.next()) {
                autorizacion = new AutorizacionJuez(rs.getInt("pcodigo"),
                        FUsuarioRol.ObtenerUsuarioRolDadoCodigo(rs.getInt("pcodigo_usuario_rol")),
                        FPersona.ObtenerPersonasDadoCodigo(rs.getInt("pcodigo_persona")),
                        rs.getString("pautorizacion_path"),
                        rs.getTimeStamp("pfecharegistro_autjuez"));
                lst.add(autorizacion);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<AutorizacionJuez> obtenerTodosAutorizacionJues()
            throws Exception {
        ArrayList<AutorizacionJuez> lst = new ArrayList();
        try {
            String sql = "select * from archivo_municipio.f_select_autorizacionjuez()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarAutorizacionJues(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static AutorizacionJuez ObtenerAutorizacionJuezDadoCodigo(int codigo) throws Exception {
        AutorizacionJuez lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from archivo_municipio.f_select_autorizacionjuez_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarAutorizacionJues(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

}
