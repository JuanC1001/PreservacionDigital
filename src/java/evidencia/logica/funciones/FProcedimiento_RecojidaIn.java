/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evidencia.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import evidencia.logica.clases.Procedimineto_RecojidaIn;
import java.sql.SQLException;
import java.util.ArrayList;
import master.logica.funciones.FUsuarioRol;

/**
 *
 * @author 
 */
public class FProcedimiento_RecojidaIn {
    public static ArrayList<Procedimineto_RecojidaIn> llenarProcedimineto_Recojida(ConjuntoResultado rs)
            throws Exception {
        ArrayList<Procedimineto_RecojidaIn> lst = new ArrayList();
        Procedimineto_RecojidaIn procedimineto_recojidain = null;
        try {
            while (rs.next()) {
                procedimineto_recojidain = new Procedimineto_RecojidaIn(rs.getInt("pcodigo"),
                        FUsuarioRol.ObtenerUsuarioRolDadoCodigo(rs.getInt("pcodigo_usuario_rol")),
                        rs.getString("phoja_ruta"),
                        rs.getString("pcadena_custudia"),
                        rs.getString("pregistros"),
                        rs.getString("pobservacion"),
                        rs.getTimeStamp("pfecharegistro_procereco"));
                lst.add(procedimineto_recojidain);
            }

        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<Procedimineto_RecojidaIn> obtenerProcedimineto_RecojidaIn() throws Exception {
        ArrayList<Procedimineto_RecojidaIn> lst = new ArrayList<Procedimineto_RecojidaIn>();
        try {
            String sql = "select * from archivo_municipio.f_select_procedimiento_recogidain()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarProcedimineto_Recojida(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static Procedimineto_RecojidaIn ObtenerProcedimineto_RecojidaInDadoCodigo(int codigo) throws Exception {
        Procedimineto_RecojidaIn lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from  archivo_municipio.f_select_procedimiento_recogida_dado_codigoin(?)";
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
