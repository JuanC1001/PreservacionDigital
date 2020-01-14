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
import master.logica.clases.TipoUsuario;

/**
 *
 * @author DiegoPalacios
 */
public class FTipoUsuario {
  private int codigo;
  private String nombre;
  private String descripcion;
  private int estado;

  
    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the estado
     */
    public int getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(int estado) {
        this.estado = estado;
    }
 public static ArrayList<TipoUsuario> llenarTiposUsuarios(ConjuntoResultado rs) throws Exception
      {
          ArrayList<TipoUsuario> lst = new ArrayList<TipoUsuario>();
          TipoUsuario tipoUsuario=null;
          try {
            while(rs.next())
            {
                     tipoUsuario= new TipoUsuario(rs.getInt("pcodigo"), rs.getString("pnombre"), rs.getString("pdescripcion"),
                             rs.getInt("pestado"));
                     lst.add(tipoUsuario);
            }
            } catch (Exception e) {
                 lst.clear();
                 throw e;
          }
         return lst;
      }
     public static TipoUsuario ObtenerTipoUsuarioDadoCodigo(int codigo) throws Exception
    {
       TipoUsuario lst;
          try

        {
         ArrayList<Parametro> lstP = new ArrayList<Parametro>();
         String sql = "select * from master_movilizacion.f_select_tipo_usuario_dado_codigo(?)";
         lstP.add(new Parametro(1,codigo));
         ConjuntoResultado rs= AccesoDatos.ejecutaQuery(sql,lstP);
         lst= new TipoUsuario();
         lst= llenarTiposUsuarios(rs).get(0);
         rs=null;
        } catch (SQLException exConec) {
               throw  new Exception(exConec.getMessage());
         }
          return lst;
    }
}
