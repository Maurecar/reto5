package model;

import java.util.Vector;

/**
 *
 * @author marco
 */
public class RevistaModel {
    private int rev_id;
    private int rev_volumen;
    private int rev_serie;

    public RevistaModel(int rev_id, int rev_volumen, int rev_serie) {
        this.rev_id = rev_id;
        this.rev_volumen = rev_volumen;
        this.rev_serie = rev_serie;
    }

    public int getRev_id() {
        return rev_id;
    }

    public void setRev_id(int rev_id) {
        this.rev_id = rev_id;
    }

    public int getRev_volumen() {
        return rev_volumen;
    }

    public void setRev_volumen(int rev_volumen) {
        this.rev_volumen = rev_volumen;
    }

    public int getRev_serie() {
        return rev_serie;
    }

    public void setRev_serie(int rev_serie) {
        this.rev_serie = rev_serie;
    }

    public Object[] toArray() {
         Object[] data = {rev_id, rev_volumen, rev_serie };
        return data;
    }
}//cierra Class
