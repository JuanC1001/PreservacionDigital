/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivo.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import archivo.logica.clases.Entorno_sw_Recojido;
import java.sql.SQLException;
import java.util.ArrayList;
import master.logica.funciones.FUsuarioRol;

/**
 *
 * @author RUBEN
 */
public class FEntorno_sw_Recojido {

    public static ArrayList<Entorno_sw_Recojido> llenarEntorno_sw_Recojido(ConjuntoResultado rs)
            throws Exception {
        ArrayList<Entorno_sw_Recojido> lst = new ArrayList();
        Entorno_sw_Recojido entorno_sw_recojido = null;
        try {
            while (rs.next()) {
                entorno_sw_recojido = new Entorno_sw_Recojido(rs.getInt("pcodigo"),
                        FUsuarioRol.ObtenerUsuarioRolDadoCodigo(rs.getInt("pcodigo_usuario_rol")),
                        rs.getString("pnombre"),
                        rs.getString("pver_sion"),
                        rs.getString("psw_base"),
                        rs.getString("psw_aplicacion"),
                        rs.getString("pobservacion"),
                        rs.getTimeStamp("pfecharegistro_swreco"));
                lst.add(entorno_sw_recojido);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<Entorno_sw_Recojido> obtenerEntorno_sw_Recojido() throws Exception {
        ArrayList<Entorno_sw_Recojido> lst = new ArrayList<Entorno_sw_Recojido>();
        try {
            //ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from archivo_municipio.f_select_entorno_sw_recogido()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            // lst = new Persona();
            lst = llenarEntorno_sw_Recojido(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static Entorno_sw_Recojido ObtenerEntorno_sw_RecojidoDadoCodigo(int codigo) throws Exception {
        Entorno_sw_Recojido lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from  archivo_municipio.f_select_entorno_sw_recogido_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarEntorno_sw_Recojido(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

}
