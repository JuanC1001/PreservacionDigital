/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evidencia.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import evidencia.logica.clases.CasoPersonaUsuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;


/**
 *
 * @author ruben
 */
public class FCasoPersonaUsuario {

    public static boolean insertar(CasoPersonaUsuario CPU) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from archivo_municipio.f_insert_casopersonausuario(?,?,?)";
            lstP.add(new Parametro(1, CPU.getCodigo_caso().getCodigo()));
            lstP.add(new Parametro(2, CPU.getCodigo_persona().getCodigo()));
            lstP.add(new Parametro(3, CPU.getCodigo_tipo_usuario().getCodigo()));
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

    public static ArrayList<CasoPersonaUsuario> llenarCPU(ConjuntoResultado rs) throws Exception {
        ArrayList<CasoPersonaUsuario> lst = new ArrayList<CasoPersonaUsuario>();
        CasoPersonaUsuario CPU = null;
        try {
            while (rs.next()) {
                CPU = new CasoPersonaUsuario(rs.getInt("pcodigo"),
                        FCaso.ObtenerCasoDadoCodigo(rs.getInt("pcodigo_caso")),
                        FPersona.ObtenerPersonasDadoCodigo(rs.getInt("pcodigo_personas")),
                        FTipo_Usuario.ObtenerTipoUsuarioDadoCodigo(rs.getInt("pcodigo_tipo_usuario")),
                        rs.getDate("pfecha_registro"));
                lst.add(CPU);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<CasoPersonaUsuario> obteneTodosCasoPersonaUsuario() throws Exception {
        ArrayList<CasoPersonaUsuario> lst = new ArrayList<CasoPersonaUsuario>();
        try {
            //ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from archivo_municipio.f_select_casopersonausuario()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            // lst = new Persona();
            lst = llenarCPU(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static ArrayList<CasoPersonaUsuario> ObtenerCPUdadoCodInst(String cdInst) throws Exception {
        //CasoPersonaUsuario lst;
        ArrayList<CasoPersonaUsuario> lst = new ArrayList();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from archivo_municipio.f_select_casopersonausuario_dado_codinst(?)";
            lstP.add(new Parametro(1, cdInst));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarCPU(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static ArrayList<CasoPersonaUsuario> ObtenerCPUdadoCodInstCedula(String cdInstCedula) throws Exception {
        //CasoPersonaUsuario lst;
        ArrayList<CasoPersonaUsuario> lst = new ArrayList();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from archivo_municipio.f_select_casopersonausuario_dado_codinst_cedula(?)";
            lstP.add(new Parametro(1, cdInstCedula));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarCPU(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static ArrayList<CasoPersonaUsuario> ObtenerCPUdadoCodFechas(Date fechaInicio, Date fechaFin) throws Exception {
        //CasoPersonaUsuario lst;
        ArrayList<CasoPersonaUsuario> lst = new ArrayList();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from archivo_municipio.f_select_casopersonausuario_dado_fechas1(?,?)";
            lstP.add(new Parametro(1, fechaInicio));
            lstP.add(new Parametro(2, fechaFin));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarCPU(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
/*
    //<editor-fold defaultstate="collapsed" desc="Listar Transacción Persona dada Fecha Inicio Fecha Fin">
    public static ArrayList<CasoPersonaUsuario> ListarCPUdadoCodFechas(Date dateFechaInicio, Date dateFechaFin) throws Exception {
        CasoPersonaUsuario cpu;
        
//        ArrayList<CasoPersonaUsuario> listado = new ArrayList<>();
        String sql = "select * from archivo_municipio.f_select_casopersonausuario_dado_fechas(?,?)";
        try {
          //  ArrayList<Parametro> parametros = new ArrayList<>();
            parametros.add(new Parametro(1, Util.FechaConvertir(dateFechaInicio)));
            parametros.add(new Parametro(2, Util.FechaConvertir(dateFechaFin)));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, parametros);
            while (rs.next()) {
                cpu = new CasoPersonaUsuario();
                cpu.getCodigo_caso();
                cpu.getCodigo_persona();
                cpu.getCodigo_tipo_usuario();
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                Date date = (Date) df.parse(rs.getString(12));
                java.sql.Timestamp timeStampDate = new Timestamp(date.getTime());
                cpu.setFecha_registro(timeStampDate);
                listado.add(cpu);
            }
        } catch (Exception exc) {
            throw exc;
        }
        return listado;
    }
    //</editor-fold>
*/  
}
