/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivo.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.Conexion;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import archivo.logica.clases.AutorizacionResponsable;
import archivo.logica.clases.Detalle_Archivo;
import archivo.logica.clases.Metadatos;
import archivo.logica.clases.Tecnicas;
import archivo.logica.clases.Entorno_sw_Recojido;
import archivo.logica.clases.Entorno_hw_Recojido;
import archivo.logica.clases.Archivo_Municipio;
import archivo.logica.clases.Procedimineto_Recojida;
import java.sql.SQLException;
import java.util.ArrayList;
//import master.logica.funciones.FUsuarioRol;

/**
 *
 * @author RUBENCHO
 */
public class FArchivoMunicipio {

    public static int insertar(Metadatos metadatos, Tecnicas tecnicas, Detalle_Archivo detallearchivo, AutorizacionResponsable autorizacionresponsable, Entorno_sw_Recojido entornoswrecojido, Entorno_hw_Recojido entornohwrecojido,
            Procedimineto_Recojida procediminetorecojida, Archivo_Municipio archivomunicipio
    ) throws Exception {
        int eje = 0;
        int eje1 = 0;
        int eje2 = 0;
        int eje3 = 0;
        int eje4 = 0;
        int eje5 = 0;
        int eje6 = 0;
        boolean eje7 = false;
        boolean ejefinal = false;
        Conexion con = new Conexion();
        if (con.getCon().getAutoCommit() == true) {
            con.getCon().setAutoCommit(false);
        }

        try {
            //            Isertar metadatos
            ArrayList<Parametro> lstMd = new ArrayList<Parametro>();
            String sql = "select * from archivo_municipio.f_insert_metadatos(?,?,?)";
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
            String sql1 = "select * from archivo_municipio.f_insert_tecnicas(?,?,?)";
            lstTec.add(new Parametro(1, tecnicas.getPath()));
            lstTec.add(new Parametro(2, tecnicas.getTecnica()));
            lstTec.add(new Parametro(3, tecnicas.getDetalle()));
            ConjuntoResultado rs1 = AccesoDatos.ejecutaQuery(sql1, lstTec);
            while (rs1.next()) {
                if (rs1.getInt(0) > 0);
                eje1 = rs1.getInt(0);
            }
            //Insertar Documento-Archivo
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql2 = "select * from archivo_municipio.f_insert_detalle_archivo(?,?,?,?,?,?,?,?,?)";
            lstP.add(new Parametro(1, detallearchivo.getCodigo_usuario_rol().getCodigo()));
            lstP.add(new Parametro(2, detallearchivo.getTipo_archivo()));
            lstP.add(new Parametro(3, detallearchivo.getTitulo()));
            lstP.add(new Parametro(4, detallearchivo.getNombre_responsable_reco()));
            lstP.add(new Parametro(5, detallearchivo.getFuete()));
            lstP.add(new Parametro(6, detallearchivo.getResumen_contexto_recojido()));
            lstP.add(new Parametro(7, detallearchivo.getResumen_contexto_contenido()));
            lstP.add(new Parametro(8, detallearchivo.getPath()));
            lstP.add(new Parametro(9, detallearchivo.getFecharegistro_detalles()));
            ConjuntoResultado rs2 = AccesoDatos.ejecutaQuery(sql2, lstP);
            while (rs2.next()) {
                if (rs2.getInt(0) > 0);
                eje2 = rs2.getInt(0);
            }
            //Insertar Autorizacion
            ArrayList<Parametro> lstAutResponsable = new ArrayList<Parametro>();
            String sql3 = "select * from archivo_municipio.f_insert_fautorizacion_responsable(?,?,?,?)";
            lstAutResponsable.add(new Parametro(1, autorizacionresponsable.getCodigo_usuario_rol().getCodigo()));
            lstAutResponsable.add(new Parametro(2, autorizacionresponsable.getCodigo_persona().getCodigo()));
            lstAutResponsable.add(new Parametro(3, autorizacionresponsable.getAutorizacion_path()));
            lstAutResponsable.add(new Parametro(4, autorizacionresponsable.getFecharegistro_autresponsable()));
            ConjuntoResultado rs3 = AccesoDatos.ejecutaQuery(sql3, lstAutResponsable);
            while (rs3.next()) {
                if (rs3.getInt(0) > 0);
                eje3 = rs3.getInt(0);
            }
            //Insertar sw recojida
            ArrayList<Parametro> lstEntSWReco = new ArrayList<Parametro>();
            String sql4 = "select * from archivo_municipio.f_insert_entorno_sw_recogido(?,?,?,?,?,?,?)";
            lstEntSWReco.add(new Parametro(1, entornoswrecojido.getCodigo_usuario_rol().getCodigo()));
            lstEntSWReco.add(new Parametro(2, entornoswrecojido.getNombre()));
            lstEntSWReco.add(new Parametro(3, entornoswrecojido.getVer_sion()));
            lstEntSWReco.add(new Parametro(4, entornoswrecojido.getSw_base()));
            lstEntSWReco.add(new Parametro(5, entornoswrecojido.getSw_aplicacion()));
            lstEntSWReco.add(new Parametro(6, entornoswrecojido.getObservacion()));
            lstEntSWReco.add(new Parametro(7, entornoswrecojido.getFecharegistro_entornoswreco()));
            ConjuntoResultado rs4 = AccesoDatos.ejecutaQuery(sql4, lstEntSWReco);
            while (rs4.next()) {
                if (rs4.getInt(0) > 0);
                eje4 = rs4.getInt(0);
            }
            //Insertar hw recojida
            ArrayList<Parametro> lstEntHWReco = new ArrayList<Parametro>();
            String sql5 = "select * from archivo_municipio.f_insert_entorno_hw_recogido(?,?,?,?,?,?,?)";
            lstEntHWReco.add(new Parametro(1, entornohwrecojido.getCodigo_usuario_rol().getCodigo()));
            lstEntHWReco.add(new Parametro(2, entornohwrecojido.getTipo()));
            lstEntHWReco.add(new Parametro(3, entornohwrecojido.getMarca()));
            lstEntHWReco.add(new Parametro(4, entornohwrecojido.getModelo()));
            lstEntHWReco.add(new Parametro(5, entornohwrecojido.getFoto()));
            lstEntHWReco.add(new Parametro(6, entornohwrecojido.getObservacion()));
            lstEntHWReco.add(new Parametro(7, entornohwrecojido.getFecharegistro_hwreco()));
            ConjuntoResultado rs5 = AccesoDatos.ejecutaQuery(sql5, lstEntHWReco);
            while (rs5.next()) {
                if (rs5.getInt(0) > 0);
                eje5 = rs5.getInt(0);
            }
            //Insertar Procedimiento recojida
            ArrayList<Parametro> lstEntPReco = new ArrayList<Parametro>();
            String sql6 = "select * from archivo_municipio.f_insert_procedimiento_recojida(?,?,?,?,?,?)";
            lstEntPReco.add(new Parametro(1, procediminetorecojida.getCodigo_usuario_rol().getCodigo()));
            lstEntPReco.add(new Parametro(2, procediminetorecojida.getHoja_ruta()));
            lstEntPReco.add(new Parametro(3, procediminetorecojida.getCadena_custudia()));
            lstEntPReco.add(new Parametro(4, procediminetorecojida.getRegistros()));
            lstEntPReco.add(new Parametro(5, procediminetorecojida.getObservacion()));
            lstEntPReco.add(new Parametro(6, procediminetorecojida.getFecharegistro_procereco()));
            ConjuntoResultado rs6 = AccesoDatos.ejecutaQuery(sql6, lstEntPReco);
            while (rs6.next()) {
                if (rs6.getInt(0) > 0);
                eje6 = rs6.getInt(0);
            }
            //Insertar Archivo_Municipio

            ArrayList<Parametro> lstEviJUR = new ArrayList<Parametro>();
            String sql7 = "select * from archivo_municipio.f_insert_archivo_municipio(?,?,?,?,?,?,?,?)";
            lstEviJUR.add(new Parametro(1, archivomunicipio.getCodigo_departamento().getCodigo()));
            lstEviJUR.add(new Parametro(2, eje3));
            lstEviJUR.add(new Parametro(3, eje4));
            lstEviJUR.add(new Parametro(4, eje5));
            lstEviJUR.add(new Parametro(5, eje6));
            lstEviJUR.add(new Parametro(6, eje));
            lstEviJUR.add(new Parametro(7, eje1));
            lstEviJUR.add(new Parametro(8, eje2));
            ConjuntoResultado rs7 = AccesoDatos.ejecutaQuery(sql7, lstEviJUR);
            while (rs7.next()) {
                if (rs7.getString(0).equals("true"));
                eje7 = true;
            }

            if ((eje > 0) && (eje1 > 0) && (eje2 > 0) && (eje3 > 0) && (eje4 > 0) && (eje5 > 0) && (eje6 > 0) && (eje7 == true)) {
                ejefinal = eje7;
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
    
    
}
