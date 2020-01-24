/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evidencia.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.Conexion;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import evidencia.logica.clases.Detalle_EvidenciaIn;
import evidencia.logica.clases.Entorno_hw_RecojidoIn;
import evidencia.logica.clases.Entorno_sw_RecojidoIn;
import evidencia.logica.clases.IncrementoEvidencias_Juridicos;
import evidencia.logica.clases.MetadatosIn;
import evidencia.logica.clases.Procedimineto_RecojidaIn;
import evidencia.logica.clases.TecnicasIn;
import java.sql.SQLException;
import java.util.ArrayList;
import master.logica.funciones.FUsuarioRol;

/**
 *
 * @author 
 */
public class FIncrementoEvidencias_Juridicos {

    //<editor-fold defaultstate="collapsed" desc="Insertar Datos de Incremento">
    public static int insertar(MetadatosIn metadatos, TecnicasIn tecnicas, Detalle_EvidenciaIn detalleevidencia,
            Entorno_sw_RecojidoIn entornoswrecojido, Entorno_hw_RecojidoIn entornohwrecojido,
            Procedimineto_RecojidaIn procediminetorecojida, IncrementoEvidencias_Juridicos incrementoEvi
    ) throws Exception {
        int eje = 0;
        int eje1 = 0;
        int eje2 = 0;
        int eje3 = 0;
        int eje4 = 0;
        int eje5 = 0;
        boolean eje6 = false;
        boolean ejefinal = false;
        Conexion con = new Conexion();
        if (con.getCon().getAutoCommit() == true) {
            con.getCon().setAutoCommit(false);
        }

        try {
            //            Isertar metadatos
            ArrayList<Parametro> lstMd = new ArrayList<Parametro>();
            String sql = "select * from archivo_municipio.f_insert_metadatosin(?,?,?)";
            lstMd.add(new Parametro(1, metadatos.getNombre()));
            lstMd.add(new Parametro(2, metadatos.getTipo()));
            lstMd.add(new Parametro(3, metadatos.getTamanio()));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstMd);
            while (rs.next()) {
                if (rs.getInt(0) > 0);
                eje = rs.getInt(0);

            }
            //            Isertar tecnicas
            ArrayList<Parametro> lstTec = new ArrayList<Parametro>();
            String sql1 = "select * from archivo_municipio.f_insert_tecnicasin(?,?,?)";
            lstTec.add(new Parametro(1, tecnicas.getPath()));
            lstTec.add(new Parametro(2, tecnicas.getTecnica()));
            lstTec.add(new Parametro(3, tecnicas.getDetalle()));
            ConjuntoResultado rs1 = AccesoDatos.ejecutaQuery(sql1, lstTec);
            while (rs1.next()) {
                if (rs1.getInt(0) > 0);
                eje1 = rs1.getInt(0);
            }
            //Insertar Documento-Evidencia
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql2 = "select * from archivo_municipio.f_insert_detalle_evidenciain(?,?,?,?,?,?,?,?,?)";
            lstP.add(new Parametro(1, detalleevidencia.getCodigo_usuario_rol().getCodigo()));
            lstP.add(new Parametro(2, detalleevidencia.getTipo_evidencia()));
            lstP.add(new Parametro(3, detalleevidencia.getTitulo()));
            lstP.add(new Parametro(4, detalleevidencia.getNombre_responsable_reco()));
            lstP.add(new Parametro(5, detalleevidencia.getFuete()));
            lstP.add(new Parametro(6, detalleevidencia.getResumen_contexto_recojido()));
            lstP.add(new Parametro(7, detalleevidencia.getResumen_contexto_contenido()));
            lstP.add(new Parametro(8, detalleevidencia.getPath()));
            lstP.add(new Parametro(9, detalleevidencia.getFecharegistro_detalles()));
            ConjuntoResultado rs2 = AccesoDatos.ejecutaQuery(sql2, lstP);
            while (rs2.next()) {
                if (rs2.getInt(0) > 0);
                eje2 = rs2.getInt(0);
            }

            //Insertar sw recojida
            ArrayList<Parametro> lstEntSWReco = new ArrayList<Parametro>();
            String sql3 = "select * from archivo_municipio.f_insert_entorno_sw_recogidoin(?,?,?,?,?,?,?)";
            lstEntSWReco.add(new Parametro(1, entornoswrecojido.getCodigo_usuario_rol().getCodigo()));
            lstEntSWReco.add(new Parametro(2, entornoswrecojido.getNombre()));
            lstEntSWReco.add(new Parametro(3, entornoswrecojido.getVer_sion()));
            lstEntSWReco.add(new Parametro(4, entornoswrecojido.getSw_base()));
            lstEntSWReco.add(new Parametro(5, entornoswrecojido.getSw_aplicacion()));
            lstEntSWReco.add(new Parametro(6, entornoswrecojido.getObservacion()));
            lstEntSWReco.add(new Parametro(7, entornoswrecojido.getFecharegistro_entornoswreco()));
            ConjuntoResultado rs3 = AccesoDatos.ejecutaQuery(sql3, lstEntSWReco);
            while (rs3.next()) {
                if (rs3.getInt(0) > 0);
                eje3 = rs3.getInt(0);
            }
            //Insertar hw recojida
            ArrayList<Parametro> lstEntHWReco = new ArrayList<Parametro>();
            String sql4 = "select * from archivo_municipio.f_insert_entorno_hw_recogidoin(?,?,?,?,?,?,?)";
            lstEntHWReco.add(new Parametro(1, entornohwrecojido.getCodigo_usuario_rol().getCodigo()));
            lstEntHWReco.add(new Parametro(2, entornohwrecojido.getTipo()));
            lstEntHWReco.add(new Parametro(3, entornohwrecojido.getMarca()));
            lstEntHWReco.add(new Parametro(4, entornohwrecojido.getModelo()));
            lstEntHWReco.add(new Parametro(5, entornohwrecojido.getFoto()));
            lstEntHWReco.add(new Parametro(6, entornohwrecojido.getObservacion()));
            lstEntHWReco.add(new Parametro(7, entornohwrecojido.getFecharegistro_hwreco()));
            ConjuntoResultado rs4 = AccesoDatos.ejecutaQuery(sql4, lstEntHWReco);
            while (rs4.next()) {
                if (rs4.getInt(0) > 0);
                eje4 = rs4.getInt(0);
            }
            //Insertar Procedimiento recojida
            ArrayList<Parametro> lstEntPReco = new ArrayList<Parametro>();
            String sql5 = "select * from archivo_municipio.f_insert_procedimiento_recojidain(?,?,?,?,?,?)";
            lstEntPReco.add(new Parametro(1, procediminetorecojida.getCodigo_usuario_rol().getCodigo()));
            lstEntPReco.add(new Parametro(2, procediminetorecojida.getHoja_ruta()));
            lstEntPReco.add(new Parametro(3, procediminetorecojida.getCadena_custudia()));
            lstEntPReco.add(new Parametro(4, procediminetorecojida.getRegistros()));
            lstEntPReco.add(new Parametro(5, procediminetorecojida.getObservacion()));
            lstEntPReco.add(new Parametro(6, procediminetorecojida.getFecharegistro_procereco()));
            ConjuntoResultado rs5 = AccesoDatos.ejecutaQuery(sql5, lstEntPReco);
            while (rs5.next()) {
                if (rs5.getInt(0) > 0);
                eje5 = rs5.getInt(0);
            }

            //Insertar Evidencia_Juridicos
            ArrayList<Parametro> lstEviJUR = new ArrayList<Parametro>();
            String sql6 = "select * from archivo_municipio.f_insert_incremento_archivo_municipio(?,?,?,?,?,?,?,?,?)";
            lstEviJUR.add(new Parametro(1, incrementoEvi.getNumero_incremento()));
            lstEviJUR.add(new Parametro(2, incrementoEvi.getCodigo_usuario_rol().getCodigo()));
            lstEviJUR.add(new Parametro(3, incrementoEvi.getCodigo_evidencias().getCodigo()));
            lstEviJUR.add(new Parametro(4, eje3));
            lstEviJUR.add(new Parametro(5, eje4));
            lstEviJUR.add(new Parametro(6, eje5));
            lstEviJUR.add(new Parametro(7, eje));
            lstEviJUR.add(new Parametro(8, eje1));
            lstEviJUR.add(new Parametro(9, eje2));
            ConjuntoResultado rs6 = AccesoDatos.ejecutaQuery(sql6, lstEviJUR);
            while (rs6.next()) {
                if (rs6.getString(0).equals("true"));
                eje6 = true;
            }
            if ((eje > 0) && (eje1 > 0) && (eje2 > 0) && (eje3 > 0) && (eje4 > 0) && (eje5 > 0) && (eje6 == true)) {
                ejefinal = eje6;
            } else {
                ejefinal = false;
                con.getCon().rollback();
            }

        } catch (SQLException exConec) {
            con.getCon().rollback();
            throw new Exception(exConec.getMessage());
        }
        return eje;
    }

    //</editor-fold>
    public static ArrayList<IncrementoEvidencias_Juridicos> llenarIncrementoEvidencias_Juridicos(ConjuntoResultado rs)
            throws Exception {
        ArrayList<IncrementoEvidencias_Juridicos> lst = new ArrayList();
        IncrementoEvidencias_Juridicos texto = null;
        try {
            while (rs.next()) {
                texto = new IncrementoEvidencias_Juridicos(rs.getInt("pcodigo"),
                        rs.getString("pnum_incrimento"),
                        FUsuarioRol.ObtenerUsuarioRolDadoCodigo(rs.getInt("pcodigo_usuario_rol")),
                        FEvidencia_Juridicos.ObtenerEvidecniaJuridicoDadoCodigo(rs.getInt("pcodigo_evidencia")),
                        FEntorno_sw_RecojidoIn.ObtenerEntorno_sw_RecojidoInDadoCodigo(rs.getInt("pcodigo_entorno_sw_recogido")),
                        FEntorno_hw_RecojidoIn.ObtenerEntorno_hw_RecojidoInDadoCodigo(rs.getInt("pcodigo_entorno_hw_recogido")),
                        FProcedimiento_RecojidaIn.ObtenerProcedimineto_RecojidaInDadoCodigo(rs.getInt("pcodigo_procedimiento_recojida")),
                        FMetadatosIn.ObtenerMetadatosInDadoCodigo(rs.getInt("pcodigo_metadatos")),
                        FTecnicasIn.ObtenerTecnicasInDadoCodigoin(rs.getInt("pcodigo_tecnicas")),
                        FDetalle_EvidenciaIn.ObtenerDetalle_EvidenciaInDadoCodigo(rs.getInt("pcodigo_detalle_evidencia")),
                        rs.getDate("pfecha_registro"));
                lst.add(texto);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<IncrementoEvidencias_Juridicos> obtenerTodosIncrementoEvidencias_Juridicos()
            throws Exception {
        ArrayList<IncrementoEvidencias_Juridicos> lst = new ArrayList();
        try {
            String sql = "select * from archivo_municipio.f_select_incremento_archivo_municipio()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarIncrementoEvidencias_Juridicos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static ArrayList<IncrementoEvidencias_Juridicos> obtenerIncreneto_Tipo(String tipo)
            throws Exception {
        ArrayList<IncrementoEvidencias_Juridicos> lst = new ArrayList();
        try {
            ArrayList<Parametro> lstP = new ArrayList();
            String sql = "select * from archivos.f_select_documento_incremento_dado_tipo(?)";
            lstP.add(new Parametro(1, tipo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarIncrementoEvidencias_Juridicos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
}
