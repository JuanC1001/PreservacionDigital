/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evidencia.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import evidencia.logica.clases.Auditoria_I_U_D;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author 
 */
public class FAuditoria_I_U_D {

    public static ArrayList<Auditoria_I_U_D> llenarAuditoriaIUD(ConjuntoResultado rs) throws Exception {
        ArrayList<Auditoria_I_U_D> lst = new ArrayList();       
        Auditoria_I_U_D auditoriaiud = null;
        try {
            while (rs.next()) {
                auditoriaiud = new Auditoria_I_U_D(rs.getInt("ppk_audit"),
                        rs.getString("pTableName"),
                        rs.getString("pOperation"),
                        rs.getString("pOldValue"),
                        rs.getString("pNewValue"),
                        rs.getTimeStamp("pUpdateDate"),
                        rs.getString("pUserName"));
                lst.add(auditoriaiud);
            }
        } catch (Exception e) {
//            lst.clear();
//            throw e;
return lst;
        }
        return lst;
    }

    public static ArrayList<Auditoria_I_U_D> obtenerAuditoriaIUD() throws Exception {
        ArrayList<Auditoria_I_U_D> lst = new ArrayList();
        try {
            String sql = "select * from archivo_municipio.f_select_auditoria_iud()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarAuditoriaIUD(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

}
