/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package master.logica.clases;

/**
 *
 * @author DiegoPalacios
 */
public class Persona {
  private long codigo_global;
  private long codigo_persona; 
  private String apellido;
  private String nombre;
  private String cedula;
  private String pasaporte;
  private String mail;

    public Persona() {
    }

    public Persona(long codigo_global, long codigo_persona, String apellido, String nombre, String cedula, String pasaporte, String mail) {
        this.codigo_global = codigo_global;
        this.codigo_persona = codigo_persona;
        this.apellido = apellido;
        this.nombre = nombre;
        this.cedula = cedula;
        this.pasaporte = pasaporte;
        this.mail = mail;
    }

    /**
     * @return the codigo_global
     */
    public long getCodigo_global() {
        return codigo_global;
    }

    /**
     * @param codigo_global the codigo_global to set
     */
    public void setCodigo_global(long codigo_global) {
        this.codigo_global = codigo_global;
    }

    /**
     * @return the codigo_persona
     */
    public long getCodigo_persona() {
        return codigo_persona;
    }

    /**
     * @param codigo_persona the codigo_persona to set
     */
    public void setCodigo_persona(long codigo_persona) {
        this.codigo_persona = codigo_persona;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
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
     * @return the cedula
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * @param cedula the cedula to set
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * @return the pasaporte
     */
    public String getPasaporte() {
        return pasaporte;
    }

    /**
     * @param pasaporte the pasaporte to set
     */
    public void setPasaporte(String pasaporte) {
        this.pasaporte = pasaporte;
    }

    /**
     * @return the mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * @param mail the mail to set
     */
    public void setMail(String mail) {
        this.mail = mail;
    }
  
}
