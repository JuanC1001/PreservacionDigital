/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package master.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.Conexion;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import java.sql.SQLException;
import java.util.ArrayList;
import master.logica.clases.Usuario;

/**   0967875827
 *
 * @author DiegoPalacios
 */
public class FUsuario {

    public static long Insertar(Usuario usuario, long codigoTitular) throws Exception {
        long eje = 0;
        boolean eje1 = false;
        boolean ejef = false;
        Conexion con = new Conexion();
        try {
            if (con.getCon().getAutoCommit()) {
                con.getCon().setAutoCommit(false);
            }
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master_movilizacion.f_insert_usuario(?,?,?,?,?,?,?,?,?,?,?,?)";
            lstP.add(new Parametro(1, usuario.getEstado()));
            lstP.add(new Parametro(2, usuario.getNick()));
            lstP.add(new Parametro(3, usuario.getClave()));
            lstP.add(new Parametro(4, usuario.getNombres()));
            lstP.add(new Parametro(5, usuario.getApellidos()));
            lstP.add(new Parametro(6, usuario.getMail()));
            lstP.add(new Parametro(7, usuario.getPrimer_acceso()));
            lstP.add(new Parametro(8, usuario.getUtimo_acceso()));
            lstP.add(new Parametro(9, usuario.getUltima_ip()));
            lstP.add(new Parametro(10, usuario.getFecha_modificacion()));
            lstP.add(new Parametro(11, usuario.getCodigo_salt()));
            lstP.add(new Parametro(12, usuario.isBool_imagen()));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            while (rs.next()) {
                if (rs.getLong(0) > 0);
                eje = rs.getLong(0);
            }

            ArrayList<Parametro> lstP1 = new ArrayList<Parametro>();
            String sql1 = "select * from master_movilizacion.f_insert_usuario_persona(?,?,?)";
            lstP1.add(new Parametro(1, codigoTitular));
            lstP1.add(new Parametro(2, eje));
            lstP1.add(new Parametro(3, 1));
            ConjuntoResultado rs1 = AccesoDatos.ejecutaQuery(sql1, lstP1);
            while (rs1.next()) {
                if (rs1.getString(0).equals("true"));
                eje1 = true;
            }

            if ((eje > 0) && (eje1 == true)) {
                ejef = true;
            } else {
                ejef = false;
            }
            con.getCon().commit();
        } catch (SQLException exConec) {
            con.getCon().rollback();
            throw new Exception(exConec.getMessage());
        }
        return eje;
    }

    public static boolean Actualizar(Usuario usuario) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master_movilizacion.f_update_usuario(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            lstP.add(new Parametro(1, usuario.getEstado()));
            lstP.add(new Parametro(2, usuario.getNick()));
            lstP.add(new Parametro(3, usuario.getClave()));
            lstP.add(new Parametro(4, usuario.getNombres()));
            lstP.add(new Parametro(5, usuario.getApellidos()));
            lstP.add(new Parametro(6, usuario.getMail()));
            lstP.add(new Parametro(7, usuario.getPrimer_acceso()));
            lstP.add(new Parametro(8, usuario.getUtimo_acceso()));
            lstP.add(new Parametro(9, usuario.getUltima_ip()));
            lstP.add(new Parametro(10, usuario.getFecha_modificacion()));
            lstP.add(new Parametro(11, usuario.getCodigo_salt()));
            lstP.add(new Parametro(12, usuario.isBool_imagen()));
            lstP.add(new Parametro(13, usuario.getCodigo()));
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

    public static boolean Eliminar(long codigo) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master_movilizacion.f_delete_usuario(?)";
            lstP.add(new Parametro(1, codigo));
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
    //obtener por cedula

    public static Usuario ObtenerUsuarioDadoCodigo(long codigo) throws Exception {
        Usuario lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master_movilizacion.f_select_usuario_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Usuario();
            lst = llenarUsuarios(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    //autenticar

    public static Usuario AutenticarUsuario(String nick, String password) throws Exception {
        Usuario lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master_movilizacion.f_select_usuario_dado_nick_y_clave(?,?)";
            lstP.add(new Parametro(1, nick));
            lstP.add(new Parametro(2, password));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Usuario();
            lst = llenarUsuarios(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static ArrayList<Usuario> llenarUsuarios(ConjuntoResultado rs) throws Exception {
        ArrayList<Usuario> lst = new ArrayList<Usuario>();
        Usuario usuario = null;
        try {
            while (rs.next()) {
                usuario = new Usuario(rs.getLong("pcodigo"),
                        rs.getInt("pestado"),
                        rs.getString("pnick"),
                        rs.getString("pclave"),
                        rs.getString("pnombres"),
                        rs.getString("papellidos"),
                        rs.getString("pmail"), rs.getLong("pprimer_acceso"), rs.getLong("putimo_acceso"), rs.getString("pultima_ip"),
                        rs.getLong("pfecha_modificacion"), rs.getString("pcodigo_salt"), rs.getBoolean("pimagen"));
                lst.add(usuario);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static Usuario ObtenerUsuarioDadoNick(String nick) throws Exception {
        Usuario lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from master_movilizacion.f_select_usuario_dado_nick(?)";
            lstP.add(new Parametro(1, nick));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Usuario();
            lst = llenarUsuarios(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static ArrayList<Usuario> ObtenerUsuarios() throws Exception {
        ArrayList<Usuario> lst = new ArrayList<Usuario>();
        try {
            String sql = "select * from master_movilizacion.f_select_usuarios()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarUsuarios(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
    
}

