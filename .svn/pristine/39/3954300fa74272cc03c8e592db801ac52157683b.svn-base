/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package master.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import java.sql.SQLException;
import java.util.ArrayList;
import master.logica.clases.ModuloGrupoMenu;
import master.logica.clases.Persona;

/**
 *
 * @author icits
 */
public class FModuloGrupoMenu {
    
    public static  boolean insertar(ModuloGrupoMenu moduloGrupoMenu) throws  Exception
    {
        boolean eje=false;
         try
        {
        ArrayList<Parametro> lstP = new ArrayList<Parametro>();
        String sql = "select * from master_movilizacion.f_insert_modulo_grupo_menu_cero(?,?,?)";
        lstP.add(new Parametro(1,moduloGrupoMenu.getCodigo_modulo().getCodigo()));
        lstP.add(new Parametro(2,moduloGrupoMenu.getCodigo_grupo_menu().getCodigo()));
        lstP.add(new Parametro(3,moduloGrupoMenu.getEstado()));
        ConjuntoResultado rs= AccesoDatos.ejecutaQuery(sql,lstP);
        while(rs.next() )
            {
              if(rs.getString(0).equals("true"));
                   eje=true;
            }
            } catch (SQLException exConec) {
               throw  new Exception(exConec.getMessage());
         }
          return eje;
    }
    
        public static boolean actualizar(ModuloGrupoMenu moduloGrupoMenu) throws Exception{
        boolean eje =false;
        try {
            ArrayList<Parametro> lstP =new ArrayList<Parametro>();
            String sql ="select * from master_movilizacion.f_update_modulo_grupo_menu_cero(?,?,?,?)";
            lstP.add(new Parametro(1,moduloGrupoMenu.getCodigo_modulo().getCodigo()) );
            lstP.add(new Parametro(2,moduloGrupoMenu.getCodigo_grupo_menu().getCodigo()));
            lstP.add(new Parametro(3,moduloGrupoMenu.getEstado()));
            lstP.add(new Parametro(4,moduloGrupoMenu.getCodigo()));
            
            ConjuntoResultado rs =AccesoDatos.ejecutaQuery(sql,lstP);
            while (rs.next()){
                if (rs.getString(0).equals("true"));
                eje=true;
            }
                                                                                                                                                                                                                        
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return eje;
    }
    
        public static boolean eliminar(ModuloGrupoMenu moduloGrupoMenu) throws Exception{
        boolean eje =false;
        try {
            ArrayList<Parametro> lstP =new ArrayList<Parametro>();
            String sql ="select * from master_movilizacion.f_delete_modulo_grupo_menu_cero(?)";
            lstP.add(new Parametro(1,moduloGrupoMenu.getCodigo()) );
            
            ConjuntoResultado rs =AccesoDatos.ejecutaQuery(sql,lstP);
            while (rs.next()){
                if (rs.getString(0).equals("true"));
                eje=true;
            }
                                                                                                                                                                                                                        
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return eje;
    }
        
        public static ArrayList<ModuloGrupoMenu> llenarModuloGrupoMenu(ConjuntoResultado rs) throws Exception {
        ArrayList<ModuloGrupoMenu> lst = new ArrayList<ModuloGrupoMenu>();
        ModuloGrupoMenu moduloGrupoMenu = null;
        try {
            while (rs.next()) {
                moduloGrupoMenu = new ModuloGrupoMenu(rs.getInt("pcodigo"),
                                                FModulo.ObtenerModuloDadoCodigo(rs.getInt("pcodigo_modulo")),
                                                FGrupo_Menus.ObtenerGrupoMenuDadoCodigo(rs.getInt("pcodigo_grupo_menu")),
                                                rs.getInt("pestado"));
                lst.add(moduloGrupoMenu);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }
        public static ArrayList<ModuloGrupoMenu> obtenerTodosModuloGrupoMenu() throws Exception {
        ArrayList<ModuloGrupoMenu> lst = new ArrayList<ModuloGrupoMenu>();
        try {
            String sql = "select * from master_movilizacion.f_select_modulo_grupo_menu_cero_todos()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarModuloGrupoMenu(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
        
        public static ModuloGrupoMenu obtenerModuloGrupoMenuDadoCodigo(int codigo) throws Exception {
        ModuloGrupoMenu objModuloGrupoMenu = new ModuloGrupoMenu();
        try {
            String sql = "select * from master_movilizacion.f_select_numero_grupo_menu_dado_modulo(?)";
            ArrayList<Parametro> lstP = new ArrayList<Parametro>(); 
            lstP .add(new Parametro(1,codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql,lstP);
            objModuloGrupoMenu = llenarModuloGrupoMenu(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return objModuloGrupoMenu;
    }
}
