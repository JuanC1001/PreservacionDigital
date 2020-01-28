/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivo.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import archivo.logica.clases.DepartamentoPersonaUsuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;


/**
 *
 * @author ruben
 */
public class FDepartamentoPersonaUsuario {

    public static boolean insertar(DepartamentoPersonaUsuario CPU) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from archivo_municipio.f_insert_departamentopersonausuario(?,?,?)";
            lstP.add(new Parametro(1, CPU.getCodigo_departamento().getCodigo()));
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

    public static ArrayList<DepartamentoPersonaUsuario> llenarCPU(ConjuntoResultado rs) throws Exception {
        ArrayList<DepartamentoPersonaUsuario> lst = new ArrayList<DepartamentoPersonaUsuario>();
        DepartamentoPersonaUsuario CPU = null;
        try {
            while (rs.next()) {
                CPU = new DepartamentoPersonaUsuario(rs.getInt("pcodigo"),
                        FDepartamento.ObtenerDepartamentoDadoCodigo(rs.getInt("pcodigo_departamento")),
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

    public static ArrayList<DepartamentoPersonaUsuario> obteneTodosDepartamentoPersonaUsuario() throws Exception {
        ArrayList<DepartamentoPersonaUsuario> lst = new ArrayList<DepartamentoPersonaUsuario>();
        try {
            //ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from archivo_municipio.f_select_departamentopersonausuario()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            // lst = new Persona();
            lst = llenarCPU(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static ArrayList<DepartamentoPersonaUsuario> ObtenerCPUdadoCodInst(String cdInst) throws Exception {
        //DepartamentoPersonaUsuario lst;
        ArrayList<DepartamentoPersonaUsuario> lst = new ArrayList();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from archivo_municipio.f_select_departamentopersonausuario_dado_codinst(?)";
            lstP.add(new Parametro(1, cdInst));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarCPU(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static ArrayList<DepartamentoPersonaUsuario> ObtenerCPUdadoCodInstCedula(String cdInstCedula) throws Exception {
        //DepartamentoPersonaUsuario lst;
        ArrayList<DepartamentoPersonaUsuario> lst = new ArrayList();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from archivo_municipio.f_select_departamentopersonausuario_dado_codinst_cedula(?)";
            lstP.add(new Parametro(1, cdInstCedula));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarCPU(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static ArrayList<DepartamentoPersonaUsuario> ObtenerCPUdadoCodFechas(Date fechaInicio, Date fechaFin) throws Exception {
        //DepartamentoPersonaUsuario lst;
        ArrayList<DepartamentoPersonaUsuario> lst = new ArrayList();
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from archivo_municipio.f_select_departamentopersonausuario_dado_fechas1(?,?)";
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
    public static ArrayList<DepartamentoPersonaUsuario> ListarCPUdadoCodFechas(Date dateFechaInicio, Date dateFechaFin) throws Exception {
        DepartamentoPersonaUsuario cpu;
        
//        ArrayList<DepartamentoPersonaUsuario> listado = new ArrayList<>();
        String sql = "select * from archivo_municipio.f_select_departamentopersonausuario_dado_fechas(?,?)";
        try {
          //  ArrayList<Parametro> parametros = new ArrayList<>();
            parametros.add(new Parametro(1, Util.FechaConvertir(dateFechaInicio)));
            parametros.add(new Parametro(2, Util.FechaConvertir(dateFechaFin)));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, parametros);
            while (rs.next()) {
                cpu = new DepartamentoPersonaUsuario();
                cpu.getCodigo_departamento();
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
