/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evidencia.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import evidencia.logica.clases.Entorno_hw_RecojidoIn;
import java.sql.SQLException;
import java.util.ArrayList;
import master.logica.funciones.FUsuarioRol;

/**
 *
 * @author ruben
 */
public class FEntorno_hw_RecojidoIn {
    
    public static ArrayList<Entorno_hw_RecojidoIn> llenarEntorno_hw_RecojidoIn(ConjuntoResultado rs)
            throws Exception {
        ArrayList<Entorno_hw_RecojidoIn> lst = new ArrayList();
        Entorno_hw_RecojidoIn entorno_hw_recojidoin = null;
        try {
            while (rs.next()) {
                entorno_hw_recojidoin = new Entorno_hw_RecojidoIn(rs.getInt("pcodigo"),
                        FUsuarioRol.ObtenerUsuarioRolDadoCodigo(rs.getInt("pcodigo_usuario_rol")),
                        rs.getString("ptipo"),
                        rs.getString("pmarca"),
                        rs.getString("pmodelo"),
                        rs.getString("pfoto"),
                        rs.getString("pobservacion"),
                        rs.getTimeStamp("pfecharegistro_hwreco"));
                lst.add(entorno_hw_recojidoin);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<Entorno_hw_RecojidoIn> obtenerEntorno_hw_RecojidoIn() throws Exception {
        ArrayList<Entorno_hw_RecojidoIn> lst = new ArrayList<Entorno_hw_RecojidoIn>();
        try {
            //ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from evidencia_juridicos.f_select_entorno_hw_recogidoin()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            // lst = new Persona();
            lst = llenarEntorno_hw_RecojidoIn(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

        public static Entorno_hw_RecojidoIn ObtenerEntorno_hw_RecojidoInDadoCodigo(int codigo) throws Exception {
        Entorno_hw_RecojidoIn lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from  evidencia_juridicos.f_select_entorno_hw_recogido_dado_codigoin(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarEntorno_hw_RecojidoIn(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
}
