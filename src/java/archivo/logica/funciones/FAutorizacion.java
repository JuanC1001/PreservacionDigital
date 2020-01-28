/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivo.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import archivo.logica.clases.AutorizacionResponsable;
import java.sql.SQLException;

import java.util.ArrayList;
import master.logica.funciones.FUsuarioRol;

/**
 *
 * @author RUBEN
 */
public class FAutorizacion {

    public static ArrayList<AutorizacionResponsable> llenarAutorizacionJues(ConjuntoResultado rs)
            throws Exception {
        ArrayList<AutorizacionResponsable> lst = new ArrayList();
        AutorizacionResponsable autorizacion = null;
        try {
            while (rs.next()) {
                autorizacion = new AutorizacionResponsable(rs.getInt("pcodigo"),
                        FUsuarioRol.ObtenerUsuarioRolDadoCodigo(rs.getInt("pcodigo_usuario_rol")),
                        FPersona.ObtenerPersonasDadoCodigo(rs.getInt("pcodigo_persona")),
                        rs.getString("pautorizacion_path"),
                        rs.getTimeStamp("pfecharegistro_autresponsable"));
                lst.add(autorizacion);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<AutorizacionResponsable> obtenerTodosAutorizacionJues()
            throws Exception {
        ArrayList<AutorizacionResponsable> lst = new ArrayList();
        try {
            String sql = "select * from archivo_municipio.f_select_autorizacionresponsable()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarAutorizacionJues(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static AutorizacionResponsable ObtenerAutorizacionResponsableDadoCodigo(int codigo) throws Exception {
        AutorizacionResponsable lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from archivo_municipio.f_select_autorizacionresponsable_dado_codigo(?)";
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
