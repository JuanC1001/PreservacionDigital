/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package master.logica.clases;

/**
 *
 * @author DiegoPalacios
 */
public class Usuario {
  private long codigo;
  private int estado;
  private String nick;
  private String clave;
  private String nombres;
  private String apellidos;
  private String mail;
  private long primer_acceso;
  private long utimo_acceso;
  private String ultima_ip;
  private long fecha_modificacion;
  private String codigo_salt;
  private boolean bool_imagen;

    public Usuario() {
    }

    public Usuario(long codigo, int estado, String nick, String clave, String nombres, String apellidos, String mail, long primer_acceso, long utimo_acceso, String ultima_ip, long fecha_modificacion, String codigo_salt, boolean bool_imagen) {
        this.codigo = codigo;
        this.estado = estado;
        this.nick = nick;
        this.clave = clave;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.mail = mail;
        this.primer_acceso = primer_acceso;
        this.utimo_acceso = utimo_acceso;
        this.ultima_ip = ultima_ip;
        this.fecha_modificacion = fecha_modificacion;
        this.codigo_salt = codigo_salt;
        this.bool_imagen = bool_imagen;
    }

    
    

    /**
     * @return the codigo
     */
    public long getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(long codigo) {
        this.codigo = codigo;
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

    /**
     * @return the nick
     */
    public String getNick() {
        return nick;
    }

    /**
     * @param nick the nick to set
     */
    public void setNick(String nick) {
        this.nick = nick;
    }

    /**
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * @return the nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * @param nombres the nombres to set
     */
    public void setNombres(String nombres) {
        this.nombres = nombres.toUpperCase();
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos.toUpperCase();
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

    /**
     * @return the primer_acceso
     */
    public long getPrimer_acceso() {
        return primer_acceso;
    }

    /**
     * @param primer_acceso the primer_acceso to set
     */
    public void setPrimer_acceso(long primer_acceso) {
        this.primer_acceso = primer_acceso;
    }

    /**
     * @return the utimo_acceso
     */
    public long getUtimo_acceso() {
        return utimo_acceso;
    }

    /**
     * @param utimo_acceso the utimo_acceso to set
     */
    public void setUtimo_acceso(long utimo_acceso) {
        this.utimo_acceso = utimo_acceso;
    }

    /**
     * @return the ultima_ip
     */
    public String getUltima_ip() {
        return ultima_ip;
    }

    /**
     * @param ultima_ip the ultima_ip to set
     */
    public void setUltima_ip(String ultima_ip) {
        this.ultima_ip = ultima_ip;
    }

    /**
     * @return the fecha_modificacion
     */
    public long getFecha_modificacion() {
        return fecha_modificacion;
    }

    /**
     * @param fecha_modificacion the fecha_modificacion to set
     */
    public void setFecha_modificacion(long fecha_modificacion) {
        this.fecha_modificacion = fecha_modificacion;
    }

    /**
     * @return the bool_imagen
     */
    public boolean isBool_imagen() {
        return bool_imagen;
    }

    /**
     * @param bool_imagen the bool_imagen to set
     */
    public void setBool_imagen(boolean bool_imagen) {
        this.bool_imagen = bool_imagen;
    }

    /**
     * @return the codigo_salt
     */
    public String getCodigo_salt() {
        return codigo_salt;
    }

    /**
     * @param codigo_salt the codigo_salt to set
     */
    public void setCodigo_salt(String codigo_salt) {
        this.codigo_salt = codigo_salt;
    }
    
    
}
