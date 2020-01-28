/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivo.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import archivo.logica.clases.Archivo_Municipio;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author RUBEN
 */
public class FArchivo_Municipio {

    public static ArrayList<Archivo_Municipio> llenarArchivo_Municipio(ConjuntoResultado rs)
            throws Exception {
        ArrayList<Archivo_Municipio> lst = new ArrayList();
        Archivo_Municipio texto = null;
        try {
            while (rs.next()) {
                texto = new Archivo_Municipio(
                        rs.getInt("pcodigo"),
                        FDepartamento.ObtenerDepartamentoDadoCodigo(rs.getInt("pcodigo_departamento")),
                        FAutorizacion.ObtenerAutorizacionResponsableDadoCodigo(rs.getInt("pcodigo_autorizacion_responsable")),
                        FEntorno_sw_Recojido.ObtenerEntorno_sw_RecojidoDadoCodigo(rs.getInt("pcodigo_entorno_sw_recogido")),
                        FEntorno_hw_Recojido.ObtenerEntorno_hw_RecojidoDadoCodigo(rs.getInt("pcodigo_entorno_hw_recogido")),
                        FProcedimiento_Recojida.ObtenerProcedimineto_RecojidaDadoCodigo(rs.getInt("pcodigo_procedimiento_recojida")),
                        FMetadatos.ObtenerMetadatosDadoCodigo(rs.getInt("pcodigo_metadatos")),
                        FTecnicas.ObtenerTecnicasDocumentoDadoCodigo(rs.getInt("pcodigo_tecnicas")),
                        FDetalle_Archivo.ObtenerDetalle_ArchivoDadoCodigo(rs.getInt("pcodigo_detalle_archivo")),
                        rs.getDate("pfecha_registro"));

                lst.add(texto);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<Archivo_Municipio> obtenerArchivo_Municipio()
            throws Exception {
        ArrayList<Archivo_Municipio> lst = new ArrayList();
        try {
            String sql = "select * from archivo_municipio.f_select_archivos_municipio()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarArchivo_Municipio(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    //Llenar metadatos dado codigo
    public static Archivo_Municipio ObtenerEvidecniaJuridicoDadoCodigo(int codigo) throws Exception {
        Archivo_Municipio lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from archivo_municipio.f_select_archivos_municipio_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarArchivo_Municipio(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
        //Llenar metadatos dado codigo_departamento
    public static Archivo_Municipio ObtenerEvidecniaJuridicoDadoCodigoDepartamento(int codigoDepartamento) throws Exception {
        Archivo_Municipio lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from archivo_municipio.f_select_archivos_municipio_dado_codigo_departamento(?)";
            lstP.add(new Parametro(1, codigoDepartamento));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarArchivo_Municipio(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
        public static ArrayList<Archivo_Municipio> ObtenerArchivodadoCodFechas(Date fechaInicio, Date fechaFin) throws Exception {
        //DepartamentoPersonaUsuario lst;
        ArrayList<Archivo_Municipio> lst = new ArrayList();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from archivo_municipio.f_select_archivos_municipio_dado_fechas(?,?)";
            lstP.add(new Parametro(1, fechaInicio));
            lstP.add(new Parametro(2, fechaFin));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarArchivo_Municipio(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    

}
