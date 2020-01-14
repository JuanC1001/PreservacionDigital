/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evidencia.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import evidencia.logica.clases.Entorno_hw_Recojido;
import java.sql.SQLException;
import java.util.ArrayList;
import master.logica.funciones.FUsuarioRol;

/**
 *
 * @author RUBEN
 */
public class FEntorno_hw_Recojido {

    public static ArrayList<Entorno_hw_Recojido> llenarEntorno_hw_Recojido(ConjuntoResultado rs)
            throws Exception {
        ArrayList<Entorno_hw_Recojido> lst = new ArrayList();
        Entorno_hw_Recojido entorno_hw_recojido = null;
        try {
            while (rs.next()) {
                entorno_hw_recojido = new Entorno_hw_Recojido(rs.getInt("pcodigo"),
                        FUsuarioRol.ObtenerUsuarioRolDadoCodigo(rs.getInt("pcodigo_usuario_rol")),
                        rs.getString("ptipo"),
                        rs.getString("pmarca"),
                        rs.getString("pmodelo"),
                        rs.getString("pfoto"),
                        rs.getString("pobservacion"),
                        rs.getTimeStamp("pfecharegistro_hwreco"));
                lst.add(entorno_hw_recojido);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<Entorno_hw_Recojido> obtenerEntorno_hw_Recojido() throws Exception {
        ArrayList<Entorno_hw_Recojido> lst = new ArrayList<Entorno_hw_Recojido>();
        try {
            //ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from evidencia_juridicos.f_select_entorno_hw_recogido()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            // lst = new Persona();
            lst = llenarEntorno_hw_Recojido(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

        public static Entorno_hw_Recojido ObtenerEntorno_hw_RecojidoDadoCodigo(int codigo) throws Exception {
        Entorno_hw_Recojido lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from  evidencia_juridicos.f_select_entorno_hw_recogido_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarEntorno_hw_Recojido(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
}
