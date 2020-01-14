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
import evidencia.logica.clases.AutorizacionJuez;
//import evidencia.logica.clases.Evidencia;
import evidencia.logica.clases.Detalle_Evidencia;
import evidencia.logica.clases.Metadatos;
import evidencia.logica.clases.Tecnicas;
//import evidencia.logica.clases.Documento_Autor;
import evidencia.logica.clases.Entorno_sw_Recojido;
import evidencia.logica.clases.Entorno_hw_Recojido;
import evidencia.logica.clases.Evidencia_Juridicos;
import evidencia.logica.clases.Procedimineto_Recojida;
import java.sql.SQLException;
import java.util.ArrayList;
//import master.logica.funciones.FUsuarioRol;

/**
 *
 * @author RUBENCHO
 */
public class FEvidenciaJuridicos {

    public static int insertar(Metadatos metadatos, Tecnicas tecnicas, Detalle_Evidencia detalleevidencia, AutorizacionJuez autorizacionjuez, Entorno_sw_Recojido entornoswrecojido, Entorno_hw_Recojido entornohwrecojido,
            Procedimineto_Recojida procediminetorecojida, Evidencia_Juridicos evidenciajuridicos
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
            String sql = "select * from evidencia_juridicos.f_insert_metadatos(?,?,?)";
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
            String sql1 = "select * from evidencia_juridicos.f_insert_tecnicas(?,?,?)";
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
            String sql2 = "select * from evidencia_juridicos.f_insert_detalle_evidencia(?,?,?,?,?,?,?,?,?)";
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
            //Insertar Autorizacion
            ArrayList<Parametro> lstAutJuez = new ArrayList<Parametro>();
            String sql3 = "select * from evidencia_juridicos.f_insert_fautorizacion_juez(?,?,?,?)";
            lstAutJuez.add(new Parametro(1, autorizacionjuez.getCodigo_usuario_rol().getCodigo()));
            lstAutJuez.add(new Parametro(2, autorizacionjuez.getCodigo_persona().getCodigo()));
            lstAutJuez.add(new Parametro(3, autorizacionjuez.getAutorizacion_path()));
            lstAutJuez.add(new Parametro(4, autorizacionjuez.getFecharegistro_autjuez()));
            ConjuntoResultado rs3 = AccesoDatos.ejecutaQuery(sql3, lstAutJuez);
            while (rs3.next()) {
                if (rs3.getInt(0) > 0);
                eje3 = rs3.getInt(0);
            }
            //Insertar sw recojida
            ArrayList<Parametro> lstEntSWReco = new ArrayList<Parametro>();
            String sql4 = "select * from evidencia_juridicos.f_insert_entorno_sw_recogido(?,?,?,?,?,?,?)";
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
            String sql5 = "select * from evidencia_juridicos.f_insert_entorno_hw_recogido(?,?,?,?,?,?,?)";
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
            String sql6 = "select * from evidencia_juridicos.f_insert_procedimiento_recojida(?,?,?,?,?,?)";
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
            //Insertar Evidencia_Juridicos

            ArrayList<Parametro> lstEviJUR = new ArrayList<Parametro>();
            String sql7 = "select * from evidencia_juridicos.f_insert_evidencia_juridicos(?,?,?,?,?,?,?,?)";
            lstEviJUR.add(new Parametro(1, evidenciajuridicos.getCodigo_caso().getCodigo()));
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
