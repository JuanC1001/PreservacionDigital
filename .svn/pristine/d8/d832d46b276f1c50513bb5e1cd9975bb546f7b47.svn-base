/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package digitales.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import digitales.logica.clases.Video;
import java.sql.SQLException;
import java.util.ArrayList;
import master.logica.funciones.FPersona;

/**
 *
 * @author icits
 */
public class FVideo {
    
    public static boolean insertar(Video video) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from digitales.f_insert_video(?,?,?,?,?,?,?)";
            lstP.add(new Parametro(1, video.getTitulo()));
            lstP.add(new Parametro(2, video.getPath()));
            lstP.add(new Parametro(3, video.getTipo()));
            lstP.add(new Parametro(4, video.getKeywords()));
            lstP.add(new Parametro(5, video.getFecha_registro()));
            lstP.add(new Parametro(6, video.getEstado()));
            lstP.add(new Parametro(7, video.getCodigo_persona().getCodigo_persona()));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            while (rs.next()) {
                if (rs.getString(0).equals("true"));
                eje = true;
            }
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return eje;
    }
    
    public static boolean actualizar(Video video) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from digitales.f_update_video(?,?,?,?,?,?,?,?)";
             lstP.add(new Parametro(1, video.getTitulo()));
             lstP.add(new Parametro(2, video.getPath()));
             lstP.add(new Parametro(3, video.getTipo()));
             lstP.add(new Parametro(4, video.getKeywords()));
             lstP.add(new Parametro(5, video.getFecha_registro()));
             lstP.add(new Parametro(6, video.getEstado()));
             lstP.add(new Parametro(7, video.getCodigo_persona().getCodigo_persona()));
             lstP.add(new Parametro(8, video.getCodigo()));
            
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            while (rs.next()) {
                if (rs.getString(0).equals("true"));
                eje = true;
            }
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return eje;
    }
    
    public static boolean eliminar(Video video) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from digitales.f_delete_video(?)";
            lstP.add(new Parametro(1, video.getCodigo()));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            while (rs.next()) {
                if (rs.getString(0).equals("true"));
                eje = true;
            }
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return eje;
    }
    
    public static ArrayList<Video> llenarVideo(ConjuntoResultado rs) throws Exception {
        ArrayList<Video> lst = new ArrayList<Video>();
        Video texto = null;
        try {
            while (rs.next()) {
                texto = new Video(rs.getInt("pcodigo"),
                        rs.getString("ptitulo"), rs.getString("ppath"), rs.getString("ptipo"),
                        rs.getString("pkeywords"),rs.getLong("pfecha_registro"),
                        rs.getInt("pestado"),FPersona.ObtenerPersonaDadoCodigo(rs.getInt("pcodigo_persona")));
                lst.add(texto);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<Video> obtenerTodos() throws Exception {
        ArrayList<Video> lst = new ArrayList<Video>();
        try {
            String sql = "select * from digitales.f_select_video()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarVideo(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
     public static Video obtenerVideoDadoCodigo(int codigo) throws Exception {
        Video objCliente = new Video();
        try {
            String sql = "select * from digitales.f_select_video_dado_codigo(?)";
            ArrayList<Parametro> lstP = new ArrayList<Parametro>(); 
            lstP .add(new Parametro(1,codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql,lstP);
            objCliente = llenarVideo(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return objCliente;
    }
     
     public static Video obtenerVideoDadoArticulo(int codigo) throws Exception {
        Video objVideo = new Video();
        try {
            String sql = "select * from digitales.f_select_video_dado_articulo(?)";
            ArrayList<Parametro> lstP = new ArrayList<Parametro>(); 
            lstP .add(new Parametro(1,codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql,lstP);
            objVideo = llenarVideo(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return objVideo;
    }
     
     public static ArrayList<Video> obtenerListaVideoDadoArticulo(int codigo) throws Exception {
        ArrayList<Video> lstVideo = new ArrayList<Video>();
        try {
            String sql = "select * from digitales.f_select_video_dado_articulo(?)";
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lstVideo = llenarVideo(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lstVideo;
    }
}
