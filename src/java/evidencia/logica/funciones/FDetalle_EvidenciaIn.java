/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evidencia.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import evidencia.logica.clases.Detalle_EvidenciaIn;
import java.sql.SQLException;
import java.util.ArrayList;
import master.logica.funciones.FUsuarioRol;

/**
 *
 * @author 
 */
public class FDetalle_EvidenciaIn {
    public static ArrayList<Detalle_EvidenciaIn> llenarDetalle_EvidenciaIn(ConjuntoResultado rs)
            throws Exception {
        ArrayList<Detalle_EvidenciaIn> lst = new ArrayList();
        Detalle_EvidenciaIn detalle_evidenciain = null;
        try {
            while (rs.next()) {
                detalle_evidenciain = new Detalle_EvidenciaIn(rs.getInt("pcodigo"),
                        FUsuarioRol.ObtenerUsuarioRolDadoCodigo(rs.getInt("pcodigo_usuario_rol")), 
                        rs.getString("ptipo_evidencia"),
                        rs.getString("ptitulo"),
                        rs.getString("pnombre_responsable_reco"),
                        rs.getString("pfuete"),
                        rs.getString("presumen_contexto_recojido"),
                        rs.getString("presumen_contexto_contenido"),
                        rs.getString("ppath"),
                        rs.getTimeStamp("pfecharegistro_detalles"));
                lst.add(detalle_evidenciain);
            }

        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<Detalle_EvidenciaIn> obtenerDetalle_EvidenciaIn() throws Exception {
        ArrayList<Detalle_EvidenciaIn> lst = new ArrayList<Detalle_EvidenciaIn>();
        try {
            String sql = "select * from archivo_municipio.f_select_detalle_evidenciain()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarDetalle_EvidenciaIn(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static Detalle_EvidenciaIn ObtenerDetalle_EvidenciaInDadoCodigo(int codigo) throws Exception {
        Detalle_EvidenciaIn lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from  archivo_municipio.f_select_detalle_evidencia_dado_codigoin(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDetalle_EvidenciaIn(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
}
