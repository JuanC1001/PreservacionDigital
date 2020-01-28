/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivo.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import archivo.logica.clases.Tipo_Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import master.logica.funciones.FUsuarioRol;

/**
 *
 * @author RUBEN
 */
public class FTipo_Usuario {

    public static boolean insertar(Tipo_Usuario tipousuario) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from archivo_municipio.f_insert_tipo_usuario(?,?,?,?)";
            lstP.add(new Parametro(1, tipousuario.getCodigo_usuario_rol().getCodigo()));
            lstP.add(new Parametro(2, tipousuario.getNombre_usuario()));
            lstP.add(new Parametro(3, tipousuario.getDetalle()));
            lstP.add(new Parametro(4, tipousuario.getFecha_registro()));
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

    public static boolean actualizar(Tipo_Usuario tipousuario) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from archivo_municipio.f_update_tipo_usuario(?,?,?,?,?)";
            lstP.add(new Parametro(1, tipousuario.getCodigo_usuario_rol().getCodigo()));
            lstP.add(new Parametro(2, tipousuario.getNombre_usuario()));
            lstP.add(new Parametro(3, tipousuario.getDetalle()));
            lstP.add(new Parametro(4, tipousuario.getFecha_registro()));
            lstP.add(new Parametro(5, tipousuario.getCodigo()));
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

    public static boolean eliminar(Tipo_Usuario tipousuario) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from archivo_municipio.f_delete_tipo_usuario(?)";
            lstP.add(new Parametro(1, tipousuario.getCodigo()));
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

    public static ArrayList<Tipo_Usuario> llenarTipoUsuario(ConjuntoResultado rs) throws Exception {
        ArrayList<Tipo_Usuario> lst = new ArrayList<Tipo_Usuario>();
        Tipo_Usuario tipousuario = null;
        try {
            while (rs.next()) {
                tipousuario = new Tipo_Usuario(rs.getInt("pcodigo"),
                        FUsuarioRol.ObtenerUsuarioRolDadoCodigo(rs.getInt("pcodigo_usuario_rol")),
                        rs.getString("pnombre_usuario"),
                        rs.getString("pdetalles"),
                        rs.getDate("pfecha_registro"));
                lst.add(tipousuario);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    //    Seleccionar Todo los Politicas
    public static ArrayList<Tipo_Usuario> obtenerTipoUsuario() throws Exception {
        ArrayList<Tipo_Usuario> lst = new ArrayList<Tipo_Usuario>();
        try {
            //ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from archivo_municipio.f_select_tipo_usuario()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            // lst = new Persona();
            lst = llenarTipoUsuario(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static Tipo_Usuario ObtenerTipoUsuarioDadoCodigo(int codigo) throws Exception {
        Tipo_Usuario lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from  archivo_municipio.f_select_tipo_usuario_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = llenarTipoUsuario(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

}
