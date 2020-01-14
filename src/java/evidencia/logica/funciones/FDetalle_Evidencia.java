/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evidencia.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import evidencia.logica.clases.Detalle_Evidencia;
import java.sql.SQLException;
import java.util.ArrayList;
import master.logica.funciones.FUsuarioRol;

/**
 *
 * @author RUBEN
 */
public class FDetalle_Evidencia {

    public static ArrayList<Detalle_Evidencia> llenarDetalle_Evidencia(ConjuntoResultado rs)
            throws Exception {
        ArrayList<Detalle_Evidencia> lst = new ArrayList();
        Detalle_Evidencia detalle_evidencia = null;
        try {
            while (rs.next()) {
                detalle_evidencia = new Detalle_Evidencia(rs.getInt("pcodigo"),
                        FUsuarioRol.ObtenerUsuarioRolDadoCodigo(rs.getInt("pcodigo_usuario_rol")), 
                        rs.getString("ptipo_evidencia"),
                        rs.getString("ptitulo"),
                        rs.getString("pnombre_responsable_reco"),
                        rs.getString("pfuete"),
                        rs.getString("presumen_contexto_recojido"),
                        rs.getString("presumen_contexto_contenido"),
                        rs.getString("ppath"),
                        rs.getTimeStamp("pfecharegistro_detalles"));
                lst.add(detalle_evidencia);
            }

        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<Detalle_Evidencia> obtenerDetalle_Evidencia() throws Exception {
        ArrayList<Detalle_Evidencia> lst = new ArrayList<Detalle_Evidencia>();
        try {
            //ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from evidencia_juridicos.f_select_detalle_evidencia()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            // lst = new Persona();
            lst = llenarDetalle_Evidencia(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static Detalle_Evidencia ObtenerDetalle_EvidenciaDadoCodigo(int codigo) throws Exception {
        Detalle_Evidencia lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from  evidencia_juridicos.f_select_detalle_evidencia_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDetalle_Evidencia(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
}
