/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evidencia.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import evidencia.logica.clases.Procedimineto_Recojida;
import java.sql.SQLException;
import java.util.ArrayList;
import master.logica.funciones.FUsuarioRol;

/**
 *
 * @author RUBEN
 */
public class FProcedimiento_Recojida {

    public static ArrayList<Procedimineto_Recojida> llenarProcedimineto_Recojida(ConjuntoResultado rs)
            throws Exception {
        ArrayList<Procedimineto_Recojida> lst = new ArrayList();
        Procedimineto_Recojida procedimineto_recojida = null;
        try {
            while (rs.next()) {
                procedimineto_recojida = new Procedimineto_Recojida(rs.getInt("pcodigo"),
                        FUsuarioRol.ObtenerUsuarioRolDadoCodigo(rs.getInt("pcodigo_usuario_rol")),
                        rs.getString("phoja_ruta"),
                        rs.getString("pcadena_custudia"),
                        rs.getString("pregistros"),
                        rs.getString("pobservacion"),
                        rs.getTimeStamp("pfecharegistro_procereco"));
                lst.add(procedimineto_recojida);
            }

        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<Procedimineto_Recojida> obtenerProcedimineto_Recojida() throws Exception {
        ArrayList<Procedimineto_Recojida> lst = new ArrayList<Procedimineto_Recojida>();
        try {
            //ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from evidencia_juridicos.f_select_procedimiento_recogida()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            // lst = new Persona();
            lst = llenarProcedimineto_Recojida(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static Procedimineto_Recojida ObtenerProcedimineto_RecojidaDadoCodigo(int codigo) throws Exception {
        Procedimineto_Recojida lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from  evidencia_juridicos.f_select_procedimiento_recogida_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarProcedimineto_Recojida(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
}
