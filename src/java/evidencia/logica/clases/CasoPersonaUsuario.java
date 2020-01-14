/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evidencia.logica.clases;
import java.util.Date;


/**
 *
 * @author ruben
 */
public class CasoPersonaUsuario {

    private int codigo;
    private Caso codigo_caso;
    private Persona codigo_persona;
    private Tipo_Usuario codigo_tipo_usuario;
    private Date fecha_registro;

    public CasoPersonaUsuario() {
    }

    public CasoPersonaUsuario(int codigo, Caso codigo_caso, Persona codigo_persona, Tipo_Usuario codigo_tipo_usuario, Date fecha_registro) {
        this.codigo = codigo;
        this.codigo_caso = codigo_caso;
        this.codigo_persona = codigo_persona;
        this.codigo_tipo_usuario = codigo_tipo_usuario;
        this.fecha_registro = fecha_registro;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Caso getCodigo_caso() {
        return codigo_caso;
    }

    public void setCodigo_caso(Caso codigo_caso) {
        this.codigo_caso = codigo_caso;
    }

    public Persona getCodigo_persona() {
        return codigo_persona;
    }

    public void setCodigo_persona(Persona codigo_persona) {
        this.codigo_persona = codigo_persona;
    }

    public Tipo_Usuario getCodigo_tipo_usuario() {
        return codigo_tipo_usuario;
    }

    public void setCodigo_tipo_usuario(Tipo_Usuario codigo_tipo_usuario) {
        this.codigo_tipo_usuario = codigo_tipo_usuario;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

 


}
