package model;

import java.util.Vector;

/**
 *
 * @author marco
 */
public class AutorModel {

    private int aut_id;
    private String aut_nombres;
    private String aut_apellidos;
    private String aut_nacionalidad;

    public AutorModel(int aut_id, String aut_nombres, String aut_apellidos, String aut_nacionalidad) {
        this.aut_id = aut_id;
        this.aut_nombres = aut_nombres;
        this.aut_apellidos = aut_apellidos;
        this.aut_nacionalidad = aut_nacionalidad;
    }

    public int getAut_id() {
        return aut_id;
    }

    public void setAut_id(int aut_id) {
        this.aut_id = aut_id;
    }

    public String getAut_nombres() {
        return aut_nombres;
    }

    public void setAut_nombres(String aut_nombres) {
        this.aut_nombres = aut_nombres;
    }

    public String getAut_apellidos() {
        return aut_apellidos;
    }

    public void setAut_apellidos(String aut_apellidos) {
        this.aut_apellidos = aut_apellidos;
    }

    public String getAut_nacionalidad() {
        return aut_nacionalidad;
    }

    public void setAut_nacionalidad(String aut_nacionalidad) {
        this.aut_nacionalidad = aut_nacionalidad;
    }

    @Override
    public String toString() {
        return "AutorModel{" + "aut_id=" + aut_id + ", aut_nombres=" + aut_nombres + ", aut_apellidos=" + aut_apellidos + ", aut_nacionalidad=" + aut_nacionalidad + '}';
    }

    public Object[] toArray() {
        Object[] data = {aut_id, aut_nombres, aut_apellidos, aut_nacionalidad};
        return data;
    }

}
