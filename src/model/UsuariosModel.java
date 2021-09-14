package model;

import java.sql.Date;




public class UsuariosModel {
   private String usu_username; 
   private String usu_nombre;
   private String usu_apellido;
   private String usu_email;
   private long usu_celular;
   private String usu_clave;
   private String usu_fecNacimiento;

    public UsuariosModel(String usu_username, String usu_nombre, String usu_apellido, String usu_email, long usu_celular, String usu_clave, String usu_fecNacimiento) {
        this.usu_username = usu_username;
        this.usu_nombre = usu_nombre;
        this.usu_apellido = usu_apellido;
        this.usu_email = usu_email;
        this.usu_celular = usu_celular;
        this.usu_clave = usu_clave;
        this.usu_fecNacimiento = usu_fecNacimiento;
    }

    public String getUsu_username() {
        return usu_username;
    }

    public void setUsu_username(String usu_username) {
        this.usu_username = usu_username;
    }

    public String getUsu_nombre() {
        return usu_nombre;
    }

    public void setUsu_nombre(String usu_nombre) {
        this.usu_nombre = usu_nombre;
    }

    public String getUsu_apellido() {
        return usu_apellido;
    }

    public void setUsu_apellido(String usu_apellido) {
        this.usu_apellido = usu_apellido;
    }

    public String getUsu_email() {
        return usu_email;
    }

    public void setUsu_email(String usu_email) {
        this.usu_email = usu_email;
    }

    public long getUsu_celular() {
        return usu_celular;
    }

    public void setUsu_celular(long usu_celular) {
        this.usu_celular = usu_celular;
    }

    public String getUsu_clave() {
        return usu_clave;
    }

    public void setUsu_clave(String usu_clave) {
        this.usu_clave = usu_clave;
    }

    public String getUsu_fecNacimiento() {
        return usu_fecNacimiento;
    }

    public void setUsu_fecNacimiento(String usu_fecNacimiento) {
        this.usu_fecNacimiento = usu_fecNacimiento;
    }

    @Override
    public String toString() {
        return "UsuariosModel{" + "usu_username=" + usu_username + ", usu_nombre=" + usu_nombre + ", usu_apellido=" + usu_apellido + ", usu_email=" + usu_email + ", usu_celular=" + usu_celular + ", usu_clave=" + usu_clave + ", usu_fecNacimiento=" + usu_fecNacimiento + '}';
    }

    public Object[] toArray() {
        Object[] data = {usu_username, usu_nombre, usu_apellido, usu_email, usu_celular, usu_clave, usu_fecNacimiento};
        return data;
    }

    
   
   
}
