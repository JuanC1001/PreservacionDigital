/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivo.logica.clases;

/**
 *
 * @author ruben
 */
public class TecnicasIn {

    private int codigo;
    private String path;
    private String tecnica;
    private String detalle;

    public TecnicasIn() {
    }

    public TecnicasIn(int codigo, String path, String tecnica, String detalle) {
        this.codigo = codigo;
        this.path = path;
        this.tecnica = tecnica;
        this.detalle = detalle;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTecnica() {
        return tecnica;
    }

    public void setTecnica(String tecnica) {
        this.tecnica = tecnica;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

}
