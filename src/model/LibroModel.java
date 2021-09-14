package model;

/**
 *
 * @author marco
 */
public class LibroModel {
   private int lib_id ;
   private String lib_resumen;
   private int lib_anio;
   private int lib_autor;

    public LibroModel(int lib_id, String lib_resumen, int lib_anio, int lib_autor) {
        this.lib_id = lib_id;
        this.lib_resumen = lib_resumen;
        this.lib_anio = lib_anio;
        this.lib_autor = lib_autor;
    }

    public int getLib_id() {
        return lib_id;
    }

    public void setLib_id(int lib_id) {
        this.lib_id = lib_id;
    }

    public String getLib_resumen() {
        return lib_resumen;
    }

    public void setLib_resumen(String lib_resumen) {
        this.lib_resumen = lib_resumen;
    }

    public int getLib_anio() {
        return lib_anio;
    }

    public void setLib_anio(int lib_anio) {
        this.lib_anio = lib_anio;
    }

    public int getLib_autor() {
        return lib_autor;
    }

    public void setLib_autor(int lib_autor) {
        this.lib_autor = lib_autor;
    }

    @Override
    public String toString() {
        return "LibroModel{" + "lib_id=" + lib_id + ", lib_resumen=" + lib_resumen + ", lib_anio=" + lib_anio + ", lib_autor=" + lib_autor + '}';
    }

    public Object[] toArray() {
        Object[] data = {lib_id, lib_resumen, lib_anio, lib_autor};
        return data;
    }
   
   
}
