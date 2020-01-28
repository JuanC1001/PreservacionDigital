/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivo.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import archivo.logica.clases.Detalle_ArchivoIn;
import java.sql.SQLException;
import java.util.ArrayList;
import master.logica.funciones.FUsuarioRol;

/**
 *
 * @author ruben
 */
public class FDetalle_ArchivoIn {
    public static ArrayList<Detalle_ArchivoIn> llenarDetalle_ArchivoIn(ConjuntoResultado rs)
            throws Exception {
        ArrayList<Detalle_ArchivoIn> lst = new ArrayList();
        Detalle_ArchivoIn detalle_archivoin = null;
        try {
            while (rs.next()) {
                detalle_archivoin = new Detalle_ArchivoIn(rs.getInt("pcodigo"),
                        FUsuarioRol.ObtenerUsuarioRolDadoCodigo(rs.getInt("pcodigo_usuario_rol")), 
                        rs.getString("ptipo_archivo"),
                        rs.getString("ptitulo"),
                        rs.getString("pnombre_responsable_reco"),
                        rs.getString("pfuete"),
                        rs.getString("presumen_contexto_recojido"),
                        rs.getString("presumen_contexto_contenido"),
                        rs.getString("ppath"),
                        rs.getTimeStamp("pfecharegistro_detalles"));
                lst.add(detalle_archivoin);
            }

        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<Detalle_ArchivoIn> obtenerDetalle_ArchivoIn() throws Exception {
        ArrayList<Detalle_ArchivoIn> lst = new ArrayList<Detalle_ArchivoIn>();
        try {
            //ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from archivo_municipio.f_select_detalle_archivoin()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            // lst = new Persona();
            lst = llenarDetalle_ArchivoIn(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static Detalle_ArchivoIn ObtenerDetalle_ArchivoInDadoCodigo(int codigo) throws Exception {
        Detalle_ArchivoIn lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from  archivo_municipio.f_select_detalle_archivo_dado_codigoin(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDetalle_ArchivoIn(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
}
