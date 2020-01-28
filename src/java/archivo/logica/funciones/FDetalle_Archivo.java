/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivo.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import archivo.logica.clases.Detalle_Archivo;
import java.sql.SQLException;
import java.util.ArrayList;
import master.logica.funciones.FUsuarioRol;

/**
 *
 * @author RUBEN
 */
public class FDetalle_Archivo {

    public static ArrayList<Detalle_Archivo> llenarDetalle_Archivo(ConjuntoResultado rs)
            throws Exception {
        ArrayList<Detalle_Archivo> lst = new ArrayList();
        Detalle_Archivo detalle_archivo = null;
        try {
            while (rs.next()) {
                detalle_archivo = new Detalle_Archivo(rs.getInt("pcodigo"),
                        FUsuarioRol.ObtenerUsuarioRolDadoCodigo(rs.getInt("pcodigo_usuario_rol")), 
                        rs.getString("ptipo_archivo"),
                        rs.getString("ptitulo"),
                        rs.getString("pnombre_responsable_reco"),
                        rs.getString("pfuete"),
                        rs.getString("presumen_contexto_recojido"),
                        rs.getString("presumen_contexto_contenido"),
                        rs.getString("ppath"),
                        rs.getTimeStamp("pfecharegistro_detalles"));
                lst.add(detalle_archivo);
            }

        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<Detalle_Archivo> obtenerDetalle_Archivo() throws Exception {
        ArrayList<Detalle_Archivo> lst = new ArrayList<Detalle_Archivo>();
        try {
            //ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from archivo_municipio.f_select_detalle_archivo()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            // lst = new Persona();
            lst = llenarDetalle_Archivo(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static Detalle_Archivo ObtenerDetalle_ArchivoDadoCodigo(int codigo) throws Exception {
        Detalle_Archivo lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from  archivo_municipio.f_select_detalle_archivo_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarDetalle_Archivo(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
}
