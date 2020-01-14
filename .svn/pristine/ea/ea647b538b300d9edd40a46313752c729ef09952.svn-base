/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package digitales.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.Conexion;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import digitales.logica.clases.Articulo;
import digitales.logica.clases.ArticuloIndex;
import digitales.logica.clases.Documento;
import digitales.logica.clases.Imagen;
import digitales.logica.clases.Sonido;
import digitales.logica.clases.Texto;
import digitales.logica.clases.Video;
import java.sql.SQLException;
import java.util.ArrayList;
import master.logica.funciones.FPersona;

/**
 *
 * @author icits
 */
public class FArticulo {

    public static int insertar(Articulo articulo, Texto texto, ArrayList<Imagen> lstImagenes, ArrayList<Video> lstVideos,
            ArrayList<Sonido> lstSonidos, ArrayList<Documento> lstDocumentos) throws Exception {
        int eje = 0;
        int eje1 = 0;
        int eje2 = 0;
        int eje3 = 0;
        int eje4 = 0;
        int eje5 = 0;
        int ejef = 0;
        Conexion con = new Conexion();
        if (con.getCon().getAutoCommit() == true) {
            con.getCon().setAutoCommit(false);
        }
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from digitales.f_insert_articulo(?,?,?,?,?,?,?)";
            lstP.add(new Parametro(1, articulo.getTitulo()));
            lstP.add(new Parametro(2, articulo.getIntroduccion()));
            lstP.add(new Parametro(3, articulo.getEstado()));
            lstP.add(new Parametro(4, articulo.getFecha_registro()));
            lstP.add(new Parametro(5, articulo.getFecha_edicion()));
            lstP.add(new Parametro(6, articulo.getCodigo_categoria().getCodigo()));
            lstP.add(new Parametro(7, articulo.getCodigo_persona().getCodigo_persona()));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            while (rs.next()) {
                if (rs.getInt(0) > 0);
                eje = rs.getInt(0);
            }

            if (texto.getCodigo() > 0) {
                ArrayList<Parametro> lstT = new ArrayList<Parametro>();
                String sql1 = "select * from digitales.f_insert_articulo_texto(?,?)";
                lstT.add(new Parametro(1, (eje)));
                lstT.add(new Parametro(2, texto.getCodigo()));
                ConjuntoResultado rs1 = AccesoDatos.ejecutaQuery(sql1, lstT);
                while (rs1.next()) {
                    if (rs1.getInt(0) > 0);
                    eje1 = rs1.getInt(0);
                }
            }
            if (lstImagenes.size() > 0) {
                for (Imagen objImg : lstImagenes) {
                    ArrayList<Parametro> lstI = new ArrayList<Parametro>();
                    String sql2 = "select * from digitales.f_insert_articulo_imagen(?,?)";
                    lstI.add(new Parametro(1, (eje)));
                    lstI.add(new Parametro(2, objImg.getCodigo()));
                    ConjuntoResultado rs2 = AccesoDatos.ejecutaQuery(sql2, lstI);
                    while (rs2.next()) {
                        if (rs2.getInt(0) > 0);
                        eje2 = rs2.getInt(0);
                    }
                }
            }

            if (lstVideos.size() > 0) {
                for (Video objVideo : lstVideos) {
                    ArrayList<Parametro> lstV = new ArrayList<Parametro>();
                    String sql3 = "select * from digitales.f_insert_articulo_video(?,?)";
                    lstV.add(new Parametro(1, (eje)));
                    lstV.add(new Parametro(2, objVideo.getCodigo()));
                    ConjuntoResultado rs3 = AccesoDatos.ejecutaQuery(sql3, lstV);
                    while (rs3.next()) {
                        if (rs3.getInt(0) > 0);
                        eje3 = rs3.getInt(0);
                    }
                }
            }

            if (lstSonidos.size() > 0) {
                for (Sonido objSonido : lstSonidos) {
                    ArrayList<Parametro> lstS = new ArrayList<Parametro>();
                    String sql4 = "select * from digitales.f_insert_articulo_sonido(?,?)";
                    lstS.add(new Parametro(1, (eje)));
                    lstS.add(new Parametro(2, objSonido.getCodigo()));
                    ConjuntoResultado rs4 = AccesoDatos.ejecutaQuery(sql4, lstS);
                    while (rs4.next()) {
                        if (rs4.getInt(0) > 0);
                        eje4 = rs4.getInt(0);
                    }
                }
            }
            if (lstDocumentos.size() > 0) {
                for (Documento objDoc : lstDocumentos) {
                    ArrayList<Parametro> lstD = new ArrayList<Parametro>();
                    String sql5 = "select * from digitales.f_insert_articulo_documento(?,?)";
                    lstD.add(new Parametro(1, (eje)));
                    lstD.add(new Parametro(2, objDoc.getCodigo()));
                    ConjuntoResultado rs5 = AccesoDatos.ejecutaQuery(sql5, lstD);
                    while (rs5.next()) {
                        if (rs5.getInt(0) > 0);
                        eje5 = rs5.getInt(0);
                    }
                }
            }
            if ((eje > 0) && (eje1 == eje) && (eje2 == eje) && (eje3 == eje) && (eje4 == eje) && (eje5 == eje)) {
                ejef = eje;
                con.getCon().commit();
            } else {
                ejef = -1;
                con.getCon().rollback();
            }

        } catch (SQLException exConec) {
            con.getCon().rollback();
            throw new Exception(exConec.getMessage());

        }
        return ejef;

    }

    public static boolean actualizar(Articulo articulo, Texto texto, ArrayList<Imagen> lstImagenes, ArrayList<Video> lstVideos,
            ArrayList<Sonido> lstSonidos, ArrayList<Documento> lstDocumentos) throws Exception {
        int eje = 0;
        int eje1 = 0;
        int eje2 = 0;
        int eje3 = 0;
        int eje4 = 0;
        int eje5 = 0;
        boolean ejef = false;
        Conexion con = new Conexion();
        if (con.getCon().getAutoCommit() == true) {
            con.getCon().setAutoCommit(false);
        }
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from digitales.f_update_articulo(?,?,?,?,?,?,?,?)";
            lstP.add(new Parametro(1, articulo.getTitulo()));
            lstP.add(new Parametro(2, articulo.getIntroduccion()));
            lstP.add(new Parametro(3, articulo.getEstado()));
            lstP.add(new Parametro(4, articulo.getFecha_registro()));
            lstP.add(new Parametro(5, articulo.getFecha_edicion()));
            lstP.add(new Parametro(6, articulo.getCodigo_categoria().getCodigo()));
            lstP.add(new Parametro(7, articulo.getCodigo_persona().getCodigo_persona()));
            lstP.add(new Parametro(8, articulo.getCodigo()));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            while (rs.next()) {
                if (rs.getInt(0) > 0);
                eje = rs.getInt(0);
            }

            if (texto.getCodigo() > 0) {
                ArrayList<Parametro> lstT = new ArrayList<Parametro>();
                String sql1 = "select * from digitales.f_update_articulo_texto_dado_codigo_articulo(?,?)";
                lstT.add(new Parametro(1, (eje)));
                lstT.add(new Parametro(2, texto.getCodigo()));
                ConjuntoResultado rs1 = AccesoDatos.ejecutaQuery(sql1, lstT);
                while (rs1.next()) {
                    if (rs1.getInt(0) > 0);
                    eje1 = rs1.getInt(0);
                }
            }
            if (lstImagenes.size() > 0) {
                String sql2 = "select * from digitales.f_delete_articulo_imagen_dado_codigo_articulo(?)";
                ArrayList<Parametro> lstI = new ArrayList<Parametro>();
                lstI.add(new Parametro(1, articulo.getCodigo()));
                ConjuntoResultado resultado = AccesoDatos.ejecutaQuery(sql2, lstI);
                while (resultado.next()) {
                    if (resultado.getString(0).equals("true")) {
                        for (Imagen objImg : lstImagenes) {
                            ArrayList<Parametro> lstIm = new ArrayList<Parametro>();
                            String sql3 = "select * from digitales.f_insert_articulo_imagen(?,?)";
                            lstIm.add(new Parametro(1, (eje)));
                            lstIm.add(new Parametro(2, objImg.getCodigo()));
                            ConjuntoResultado rs2 = AccesoDatos.ejecutaQuery(sql3, lstIm);
                            while (rs2.next()) {
                                if (rs2.getInt(0) > 0);
                                eje2 = rs2.getInt(0);
                            }
                        }
                    } else {
                        eje2 = 0;
                    }
                }
            }




            if (lstVideos.size() > 0) {
                String sql2 = "select * from digitales.f_delete_articulo_video_dado_codigo_articulo(?)";
                ArrayList<Parametro> lstI = new ArrayList<Parametro>();
                lstI.add(new Parametro(1, articulo.getCodigo()));
                ConjuntoResultado resultado = AccesoDatos.ejecutaQuery(sql2, lstI);

                for (Video objVideo : lstVideos) {
                    ArrayList<Parametro> lstV = new ArrayList<Parametro>();
                    String sql3 = "select * from digitales.f_insert_articulo_video(?,?)";
                    lstV.add(new Parametro(1, (eje)));
                    lstV.add(new Parametro(2, objVideo.getCodigo()));
                    ConjuntoResultado rs3 = AccesoDatos.ejecutaQuery(sql3, lstV);
                    while (rs3.next()) {
                        if (rs3.getInt(0) > 0);
                        eje3 = rs3.getInt(0);
                    }
                }
            }

            if (lstSonidos.size() > 0) {
                String sql2 = "select * from digitales.f_delete_articulo_sonido_dado_codigo_articulo(?)";
                ArrayList<Parametro> lstI = new ArrayList<Parametro>();
                lstI.add(new Parametro(1, articulo.getCodigo()));
                ConjuntoResultado resultado = AccesoDatos.ejecutaQuery(sql2, lstI);

                for (Sonido objSonido : lstSonidos) {
                    ArrayList<Parametro> lstS = new ArrayList<Parametro>();
                    String sql4 = "select * from digitales.f_insert_articulo_sonido(?,?)";
                    lstS.add(new Parametro(1, (eje)));
                    lstS.add(new Parametro(2, objSonido.getCodigo()));
                    ConjuntoResultado rs4 = AccesoDatos.ejecutaQuery(sql4, lstS);
                    while (rs4.next()) {
                        if (rs4.getInt(0) > 0);
                        eje4 = rs4.getInt(0);
                    }
                }
            }
            if (lstDocumentos.size() > 0) {
                String sql2 = "select * from digitales.f_delete_articulo_documento_dado_codigo_articulo(?)";
                ArrayList<Parametro> lstI = new ArrayList<Parametro>();
                lstI.add(new Parametro(1, articulo.getCodigo()));
                ConjuntoResultado resultado = AccesoDatos.ejecutaQuery(sql2, lstI);

                for (Documento objDoc : lstDocumentos) {
                    ArrayList<Parametro> lstD = new ArrayList<Parametro>();
                    String sql5 = "select * from digitales.f_insert_articulo_documento(?,?)";
                    lstD.add(new Parametro(1, (eje)));
                    lstD.add(new Parametro(2, objDoc.getCodigo()));
                    ConjuntoResultado rs5 = AccesoDatos.ejecutaQuery(sql5, lstD);
                    while (rs5.next()) {
                        if (rs5.getInt(0) > 0);
                        eje5 = rs5.getInt(0);
                    }
                }
            }
            if ((eje > 0) && (eje1 == eje) && (eje2 == eje) && (eje3 == eje) && (eje4 == eje) && (eje5 == eje)) {
                ejef = true;
                con.getCon().commit();
            } else {
                ejef = false;
                con.getCon().rollback();
            }

        } catch (SQLException exConec) {
            con.getCon().rollback();
            throw new Exception(exConec.getMessage());

        }
        return ejef;

    }

    public static boolean eliminar(Articulo articulo) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from digitales.f_delete_articulo(?)";
            lstP.add(new Parametro(1, articulo.getCodigo()));
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

    public static ArrayList<Articulo> llenarArticulo(ConjuntoResultado rs) throws Exception {
        ArrayList<Articulo> lst = new ArrayList<Articulo>();
        Articulo articulo = null;
        try {
            while (rs.next()) {
                articulo = new Articulo(rs.getInt("pcodigo"),
                        rs.getString("ptitulo"), rs.getString("pintroduccion"), rs.getInt("pestado"),
                        rs.getLong("pfecha_registro"), rs.getLong("pfecha_edicion"),
                        FCategoria.obtenerCategoriaDadoCodigo(rs.getInt("pcodigo_categoria")),
                        FPersona.ObtenerPersonaDadoCodigo(rs.getInt("pcodigo_persona")));
                lst.add(articulo);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<ArticuloIndex> llenarArticuloIndex(ConjuntoResultado rs) throws Exception {
        ArrayList<ArticuloIndex> lst = new ArrayList<ArticuloIndex>();
        ArticuloIndex articulo = null;
        try {
            while (rs.next()) {
                articulo = new ArticuloIndex(rs.getInt("pcodigo"),
                        rs.getString("ptitulo"), rs.getString("pintroduccion"), rs.getInt("pestado"),
                        rs.getLong("pfecha_registro"), rs.getLong("pfecha_edicion"),
                        FCategoria.obtenerCategoriaDadoCodigo(rs.getInt("pcodigo_categoria")),
                        FPersona.ObtenerPersonaDadoCodigo(rs.getInt("pcodigo_persona")),
                        FImagen.obtenerImagenDadoArticulo(rs.getInt("pcodigo")));
                lst.add(articulo);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<Articulo> obtenerTodos() throws Exception {
        ArrayList<Articulo> lst = new ArrayList<Articulo>();
        try {
            String sql = "select * from digitales.f_select_articulo()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarArticulo(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static Articulo obtenerArticuloDadoCodigo(int codigo) throws Exception {
        Articulo objArticulo = new Articulo();
        try {
            String sql = "select * from digitales.f_select_articulo_dado_codigo(?)";
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            objArticulo = llenarArticulo(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return objArticulo;
    }

    public static ArrayList<Articulo> obtenerArticuloDadoCategoria(int codigo_categoria) throws Exception {
        ArrayList<Articulo> lstArticulo = new ArrayList<Articulo>();
        try {
            String sql = "select * from digitales.f_select_articulo_dado_categoria(?)";
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            lstP.add(new Parametro(1, codigo_categoria));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lstArticulo = llenarArticulo(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lstArticulo;
    }

    public static ArrayList<ArticuloIndex> obtenerArticuloDadoCategoriaIndex(int codigo_categoria) throws Exception {
        ArrayList<ArticuloIndex> lstArticulo = new ArrayList<ArticuloIndex>();
        try {
            String sql = "select * from digitales.f_select_articulo_dado_categoria(?)";
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            lstP.add(new Parametro(1, codigo_categoria));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lstArticulo = llenarArticuloIndex(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lstArticulo;
    }
}
