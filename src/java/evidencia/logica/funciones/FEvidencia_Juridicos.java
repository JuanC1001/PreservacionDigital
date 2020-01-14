/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evidencia.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import evidencia.logica.clases.Evidencia_Juridicos;
import evidencia.logica.funciones.FAutorizacion;
import evidencia.logica.funciones.FDetalle_Evidencia;
import evidencia.logica.funciones.FEntorno_hw_Recojido;
import evidencia.logica.funciones.FEntorno_sw_Recojido;
import evidencia.logica.funciones.FMetadatos;
import evidencia.logica.funciones.FProcedimiento_Recojida;
import evidencia.logica.funciones.FTecnicas;
import evidencia.logica.funciones.FUsuario_Caso;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author RUBEN
 */
public class FEvidencia_Juridicos {

    public static ArrayList<Evidencia_Juridicos> llenarEvidencia_Juridicos(ConjuntoResultado rs)
            throws Exception {
        ArrayList<Evidencia_Juridicos> lst = new ArrayList();
        Evidencia_Juridicos texto = null;
        try {
            while (rs.next()) {
                texto = new Evidencia_Juridicos(
                        rs.getInt("pcodigo"),
                        FCaso.ObtenerCasoDadoCodigo(rs.getInt("pcodigo_caso")),
                        FAutorizacion.ObtenerAutorizacionJuezDadoCodigo(rs.getInt("pcodigo_autorizacion_juez")),
                        FEntorno_sw_Recojido.ObtenerEntorno_sw_RecojidoDadoCodigo(rs.getInt("pcodigo_entorno_sw_recogido")),
                        FEntorno_hw_Recojido.ObtenerEntorno_hw_RecojidoDadoCodigo(rs.getInt("pcodigo_entorno_hw_recogido")),
                        FProcedimiento_Recojida.ObtenerProcedimineto_RecojidaDadoCodigo(rs.getInt("pcodigo_procedimiento_recojida")),
                        FMetadatos.ObtenerMetadatosDadoCodigo(rs.getInt("pcodigo_metadatos")),
                        FTecnicas.ObtenerTecnicasDocumentoDadoCodigo(rs.getInt("pcodigo_tecnicas")),
                        FDetalle_Evidencia.ObtenerDetalle_EvidenciaDadoCodigo(rs.getInt("pcodigo_detalle_evidencia")),
                        rs.getDate("pfecha_registro"));

                lst.add(texto);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<Evidencia_Juridicos> obtenerEvidencia_Juridicos()
            throws Exception {
        ArrayList<Evidencia_Juridicos> lst = new ArrayList();
        try {
            String sql = "select * from evidencia_juridicos.f_select_evidencias_juridicos()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarEvidencia_Juridicos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    //Llenar metadatos dado codigo
    public static Evidencia_Juridicos ObtenerEvidecniaJuridicoDadoCodigo(int codigo) throws Exception {
        Evidencia_Juridicos lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from evidencia_juridicos.f_select_evidencias_juridicos_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarEvidencia_Juridicos(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
        //Llenar metadatos dado codigo_caso
    public static Evidencia_Juridicos ObtenerEvidecniaJuridicoDadoCodigoCaso(int codigoCaso) throws Exception {
        Evidencia_Juridicos lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from evidencia_juridicos.f_select_evidencias_juridicos_dado_codigo_caso(?)";
            lstP.add(new Parametro(1, codigoCaso));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarEvidencia_Juridicos(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
        public static ArrayList<Evidencia_Juridicos> ObtenerEvidenciadadoCodFechas(Date fechaInicio, Date fechaFin) throws Exception {
        //CasoPersonaUsuario lst;
        ArrayList<Evidencia_Juridicos> lst = new ArrayList();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from evidencia_juridicos.f_select_evidencias_juridicos_dado_fechas(?,?)";
            lstP.add(new Parametro(1, fechaInicio));
            lstP.add(new Parametro(2, fechaFin));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarEvidencia_Juridicos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    

}
