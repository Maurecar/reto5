package accessDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.UsuariosModel;
import utils.connectionDB;

/**
 * Con Este archivos se crean las consultas para la tabla usuarios de la base de
 * datos de la biblioteca Biblios Pro
 *
 * @author marco
 */
public class UsuariosDAO {

    private Connection conecta = null;

    public ArrayList<UsuariosModel> getAllUsuarios() {
        ArrayList<UsuariosModel> usuarios = new ArrayList();
        try {
            if (conecta == null) {
                conecta = connectionDB.getConnection();
            }
            String sql = "select * from usuarios";
            Statement statement = conecta.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                UsuariosModel usuario = new UsuariosModel(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getLong(5), result.getString(6), result.getString(7));
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : Algo pasa" + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return usuarios;
    }//cierra todos los usuarios

    public ArrayList<String> getAllIdsUsuarios() {
        ArrayList<String> usuarios = new ArrayList();
        try {
            if (conecta == null) {
                conecta = connectionDB.getConnection();
            }

            String sql = "SELECT usu_username FROM usuarios;";
            Statement statement = conecta.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                usuarios.add(result.getString(1));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return usuarios;
    }//cierra consulta por Id de usuarios

    public ArrayList<String> getAllNombreApellidoUsuarios() {
        ArrayList<String> usuarios = new ArrayList();
        try {
            if (conecta == null) {
                conecta = connectionDB.getConnection();
            }

            String sql = "SELECT usu_nombre, usu_apellido FROM usuarios where usu_username=?;";
            Statement statement = conecta.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                usuarios.add(result.getString(1) + " " + result.getString(2));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return usuarios;
    }//cierra extracción nombres y apellidos
    //Inserción de usuario nuevo

    public void insertUsuarios(UsuariosModel usuarios) {
        try {
            if (conecta == null) {
                conecta = connectionDB.getConnection();
            }

            String sql = "INSERT INTO usuarios(usu_username, usu_nombre, usu_apellido, usu_email, usu_celualr, usu_clave, usu_fecha_nacimiento) VALUES (?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement statement = conecta.prepareStatement(sql);
            statement.setString(1, usuarios.getUsu_username());
            statement.setString(2, usuarios.getUsu_nombre());
            statement.setString(3, usuarios.getUsu_apellido());
            statement.setString(4, usuarios.getUsu_email());
            statement.setLong(5, usuarios.getUsu_celular());
            statement.setString(6, usuarios.getUsu_clave());
            statement.setString(7, usuarios.getUsu_fecNacimiento());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "El registro fue agregado exitosamente !");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
    }  //cierra insertUsuarios
    //Actualización de Usurio

    public void updateUsuarios(UsuariosModel usuarios) {
        try {
            if (conecta == null) {
                conecta = connectionDB.getConnection();
            }

            String sql = "UPDATE usuarios SET usu_nombre= ?, usu_apellido= ?, usu_email= ?, usu_celualr= ?, usu_clave= ?, usu_fecha_nacimiento= ? WHERE usu_username=?;";
            PreparedStatement statement = conecta.prepareStatement(sql);
            statement.setString(1, usuarios.getUsu_nombre());
            statement.setString(2, usuarios.getUsu_apellido());
            statement.setString(3, usuarios.getUsu_email());
            statement.setLong(4, usuarios.getUsu_celular());
            statement.setString(5, usuarios.getUsu_clave());
            statement.setString(6, usuarios.getUsu_fecNacimiento());
            statement.setString(7, usuarios.getUsu_username());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "El registro fue actualizado exitosamente !");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
    }//cierra actualización usuario
    //Eliminacion de Usuario

    public void deleteUusarios(String usu_username) {
        try {
            if (conecta == null) {
                conecta = connectionDB.getConnection();
            }

            String sql = "DELETE FROM usuarios WHERE usu_username=?;";
            PreparedStatement statement = conecta.prepareStatement(sql);
            statement.setString(1, usu_username);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "El Usuario fue borrado exitosamente !");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
    }//cierra eliminar usuario
}//cierra class
