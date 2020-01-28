/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivo.logica.clases;

/**
 *
 * @author RUBEN
 */
public class Usuario_Departamento {

    private int codigo;
    private Persona codigo_persona;
    private Tipo_Usuario codigo_tipo_usuario;    
    private Departamento codigo_departamento;

    public Usuario_Departamento() {
    }

    public Usuario_Departamento(int codigo, Persona codigo_persona, Tipo_Usuario codigo_tipo_usuario, Departamento codigo_departamento) {
        this.codigo = codigo;
        this.codigo_persona = codigo_persona;
        this.codigo_tipo_usuario = codigo_tipo_usuario;
        this.codigo_departamento = codigo_departamento;
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

    public Departamento getCodigo_departamento() {
        return codigo_departamento;
    }

    public void setCodigo_departamento(Departamento codigo_departamento) {
        this.codigo_departamento = codigo_departamento;
    }

}
