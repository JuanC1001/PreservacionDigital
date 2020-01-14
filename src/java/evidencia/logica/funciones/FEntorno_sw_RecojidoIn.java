/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evidencia.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import evidencia.logica.clases.Entorno_sw_RecojidoIn;
import java.sql.SQLException;
import java.util.ArrayList;
import master.logica.funciones.FUsuarioRol;

/**
 *
 * @author ruben
 */
public class FEntorno_sw_RecojidoIn {
    public static ArrayList<Entorno_sw_RecojidoIn> llenarEntorno_sw_RecojidoIn(ConjuntoResultado rs)
            throws Exception {
        ArrayList<Entorno_sw_RecojidoIn> lst = new ArrayList();
        Entorno_sw_RecojidoIn entorno_sw_recojidoin = null;
        try {
            while (rs.next()) {
                entorno_sw_recojidoin = new Entorno_sw_RecojidoIn(rs.getInt("pcodigo"),
                        FUsuarioRol.ObtenerUsuarioRolDadoCodigo(rs.getInt("pcodigo_usuario_rol")),
                        rs.getString("pnombre"),
                        rs.getString("pver_sion"),
                        rs.getString("psw_base"),
                        rs.getString("psw_aplicacion"),
                        rs.getString("pobservacion"),
                        rs.getTimeStamp("pfecharegistro_swreco"));
                lst.add(entorno_sw_recojidoin);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<Entorno_sw_RecojidoIn> obtenerEntorno_sw_RecojidoIn() throws Exception {
        ArrayList<Entorno_sw_RecojidoIn> lst = new ArrayList<Entorno_sw_RecojidoIn>();
        try {
            //ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from evidencia_juridicos.f_select_entorno_sw_recogidoin()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            // lst = new Persona();
            lst = llenarEntorno_sw_RecojidoIn(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static Entorno_sw_RecojidoIn ObtenerEntorno_sw_RecojidoInDadoCodigo(int codigo) throws Exception {
        Entorno_sw_RecojidoIn lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from  evidencia_juridicos.f_select_entorno_sw_recogido_dado_codigoin(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarEntorno_sw_RecojidoIn(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
}
