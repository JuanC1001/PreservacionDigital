/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evidencia.logica.clases;

import master.logica.clases.UsuarioRol;
import evidencia.logica.clases.Persona;

import java.sql.Timestamp;

/**
 *
 * @author RUBEN
 */
public class Caso {
    private int codigo;
    private UsuarioRol codigo_usuario_rol;
    private String codigo_institucional;
    private Tipo_Caso codigo_tipo_caso;
    private String materia;
    private String provincia;
    private String canton;
    private String judicatura;
    private Dependencia codigo_dependencia;
    private String accion_infraccion;
    private String politicas;
    private Timestamp fecha_registro;

    public Caso() {
    }

    public Caso(int codigo, UsuarioRol codigo_usuario_rol, String codigo_institucional, Tipo_Caso codigo_tipo_caso, String materia, String provincia, String canton, String judicatura, Dependencia codigo_dependencia, String accion_infraccion, String politicas, Timestamp fecha_registro) {
        this.codigo = codigo;
        this.codigo_usuario_rol = codigo_usuario_rol;
        this.codigo_institucional = codigo_institucional;
        this.codigo_tipo_caso = codigo_tipo_caso;
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

    public Tipo_Caso getCodigo_tipo_caso() {
        return codigo_tipo_caso;
    }

    public void setCodigo_tipo_caso(Tipo_Caso codigo_tipo_caso) {
        this.codigo_tipo_caso = codigo_tipo_caso;
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
