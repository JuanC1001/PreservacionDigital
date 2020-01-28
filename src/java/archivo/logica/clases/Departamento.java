/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivo.logica.clases;

import master.logica.clases.UsuarioRol;

import java.sql.Timestamp;

/**
 *
 * @author RUBEN
 */
public class Departamento {
    private int codigo;
    private UsuarioRol codigo_usuario_rol;
    private String codigo_institucional;
    private Tipo_Departamento codigo_tipo_departamento;
    private String materia;
    private String provincia;
    private String canton;
    private String judicatura;
    private Dependencia codigo_dependencia;
    private String accion_infraccion;
    private String politicas;
    private Timestamp fecha_registro;

    public Departamento() {
    }

    public Departamento(int codigo, UsuarioRol codigo_usuario_rol, String codigo_institucional, Tipo_Departamento codigo_tipo_departamento, String materia, String provincia, String canton, String judicatura, Dependencia codigo_dependencia, String accion_infraccion, String politicas, Timestamp fecha_registro) {
        this.codigo = codigo;
        this.codigo_usuario_rol = codigo_usuario_rol;
        this.codigo_institucional = codigo_institucional;
        this.codigo_tipo_departamento = codigo_tipo_departamento;
        this.materia = materia;
        this.provincia = provincia;
        this.canton = canton;
        this.judicatura = judicatura;
        this.codigo_dependencia = codigo_dependencia;
        this.accion_infraccion = accion_infraccion;
        this.politicas = politicas;
        this.fecha_registro = fecha_registro;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public UsuarioRol getCodigo_usuario_rol() {
        return codigo_usuario_rol;
    }

    public void setCodigo_usuario_rol(UsuarioRol codigo_usuario_rol) {
        this.codigo_usuario_rol = codigo_usuario_rol;
    }

    public String getCodigo_institucional() {
        return codigo_institucional;
    }

    public void setCodigo_institucional(String codigo_institucional) {
        this.codigo_institucional = codigo_institucional;
    }

    public Tipo_Departamento getCodigo_tipo_departamento() {
        return codigo_tipo_departamento;
    }

    public void setCodigo_tipo_departamento(Tipo_Departamento codigo_tipo_departamento) {
        this.codigo_tipo_departamento = codigo_tipo_departamento;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getJudicatura() {
        return judicatura;
    }

    public void setJudicatura(String judicatura) {
        this.judicatura = judicatura;
    }

    public Dependencia getCodigo_dependencia() {
        return codigo_dependencia;
    }

    public void setCodigo_dependencia(Dependencia codigo_dependencia) {
        this.codigo_dependencia = codigo_dependencia;
    }

    public String getAccion_infraccion() {
        return accion_infraccion;
    }

    public void setAccion_infraccion(String accion_infraccion) {
        this.accion_infraccion = accion_infraccion;
    }

    public String getPoliticas() {
        return politicas;
    }

    public void setPoliticas(String politicas) {
        this.politicas = politicas;
    }

    public Timestamp getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Timestamp fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

   
   
}
