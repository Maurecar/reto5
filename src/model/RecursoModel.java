package model;

import java.util.Vector;

/**
 *
 * @author marco
 */
public class RecursoModel {
   private int rec_id;
   private String rec_titulo;

    public RecursoModel(int rec_id, String rec_titulo) {
        this.rec_id = rec_id;
        this.rec_titulo = rec_titulo;
    }

    public int getRec_id() {
        return rec_id;
    }

    public void setRec_id(int rec_id) {
        this.rec_id = rec_id;
    }

    public String getRec_titulo() {
        return rec_titulo;
    }

    public void setRec_titulo(String rec_titulo) {
        this.rec_titulo = rec_titulo;
    }

    @Override
    public String toString() {
        return "RecursoModel{" + "rec_id=" + rec_id + ", rec_titulo=" + rec_titulo + '}';
    }

    public Object[] toArray() {
         Object[] data = {rec_id, rec_titulo};
        return data;
    }
   
   
}
