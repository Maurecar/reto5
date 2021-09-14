
package model;

import java.util.Date;
import java.util.Vector;

/**
 *
 * @author marco
 */
public class PrestamoModel {
    private int pre_id;
    private String pre_usuario;
    private int pre_rec;
    private String pre_fecha;

    public PrestamoModel(int pre_id, String pre_usuario, int pre_rec, String pre_fecha) {
        this.pre_id = pre_id;
        this.pre_usuario = pre_usuario;
        this.pre_rec = pre_rec;
        this.pre_fecha = pre_fecha;
    }

    public int getPre_id() {
        return pre_id;
    }

    public void setPre_id(int pre_id) {
        this.pre_id = pre_id;
    }

    public String getPre_usuario() {
        return pre_usuario;
    }

    public void setPre_usuario(String pre_usuario) {
        this.pre_usuario = pre_usuario;
    }

    public int getPre_rec() {
        return pre_rec;
    }

    public void setPre_rec(int pre_rec) {
        this.pre_rec = pre_rec;
    }

    public String getPre_fecha() {
        return pre_fecha;
    }

    public void setPre_fecha(String pre_fecha) {
        this.pre_fecha = pre_fecha;
    }

    @Override
    public String toString() {
        return "PretamoModel{" + "pre_id=" + pre_id + ", pre_usuario=" + pre_usuario + ", pre_rec=" + pre_rec + ", pre_fecha=" + pre_fecha + '}';
    }

    public Object[] toArray() {
        Object[] data = {pre_id, pre_usuario, pre_rec, pre_fecha};
        return data;
    }
    
    
}
