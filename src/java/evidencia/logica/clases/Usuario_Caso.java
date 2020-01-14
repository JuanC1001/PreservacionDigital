/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evidencia.logica.clases;

/**
 *
 * @author RUBEN
 */
public class Usuario_Caso {

    private int codigo;
    private Persona codigo_persona;
    private Tipo_Usuario codigo_tipo_usuario;    
    private Caso codigo_caso;

    public Usuario_Caso() {
    }

    public Usuario_Caso(int codigo, Persona codigo_persona, Tipo_Usuario codigo_tipo_usuario, Caso codigo_caso) {
        this.codigo = codigo;
        this.codigo_persona = codigo_persona;
        this.codigo_tipo_usuario = codigo_tipo_usuario;
        this.codigo_caso = codigo_caso;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public Caso getCodigo_caso() {
        return codigo_caso;
    }

    public void setCodigo_caso(Caso codigo_caso) {
        this.codigo_caso = codigo_caso;
    }

}
