
package accessDAO;

/**
 *
 * @author marco
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.AutorModel;
import utils.connectionDB;
public class AutorDAO {
     private Connection conecta = null;
     //consulta todos los autores
     public ArrayList<AutorModel> getAllAutores() {
        ArrayList<AutorModel> autores = new ArrayList();
        try {
            if (conecta == null) {
                conecta = connectionDB.getConnection();
            }

            String sql = "SELECT * FROM autor;";
            Statement statement = conecta.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                AutorModel autor = new AutorModel(result.getInt(1), result.getString(2), result.getString(3), result.getString(4));
                autores.add(autor);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return autores;
    }//cierra consulta todos los autores
     //Consultar Autor por Id
     public AutorModel getAutor(int id) {
        AutorModel estudiante = null;
        try {
            if (conecta == null) {
                conecta = connectionDB.getConnection();
            }

            String sql = "SELECT aut_nombres, aut_apellidos, aut_nacionalidad FROM autor WHERE aut_id=" + id;
            Statement statement = conecta.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                estudiante = new AutorModel(id, result.getString(1), result.getString(2), result.getString(3));
                break;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return estudiante;
    }//cierra consulta Autor por ID
     //Agregar Autor
     public void insertAutor(AutorModel autor) {
        try {
            if (conecta == null) {
                conecta = connectionDB.getConnection();
            }

            String sql = "INSERT INTO autor(aut_id, aut_nombres, aut_apellidos, aut_nacinalidad) VALUES (?, ?, ?, ?);";
            PreparedStatement statement = conecta.prepareStatement(sql);
            statement.setInt(1, autor.getAut_id());
            statement.setString(2, autor.getAut_nombres());
            statement.setString(3, autor.getAut_apellidos());
            statement.setString(4, autor.getAut_nacionalidad());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "El Autor fue agregado exitosamente !");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
    }//Cierra insertar Autor
     //Actualizar Autor 
     public void updateAutor(AutorModel autor) {
        try {
            if (conecta == null) {
                conecta = connectionDB.getConnection();
            }

            String sql = "UPDATE autor SET aut_nombres = ?, aut_apellidos = ?, aut_nacinalidad = ? WHERE aut_id=?;";
            PreparedStatement statement = conecta.prepareStatement(sql);
            statement.setString(1, autor.getAut_nombres());
            statement.setString(2, autor.getAut_apellidos());
            statement.setString(3, autor.getAut_nacionalidad());
            statement.setInt(4, autor.getAut_id());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "El Autor fue actualizado exitosamente !");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
    }//Cierra Actualizar Autor
     //Eliminar Autor
     public void deleteAuotr(int id) {
        try {
            if (conecta == null) {
                conecta = connectionDB.getConnection();
            }

            String sql = "DELETE FROM autor WHERE aut_id=?;";
            PreparedStatement statement = conecta.prepareStatement(sql);
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "El Autor fue borrado exitosamente !");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
    }//Cierra eliminar Autor
    //consulta Id de Autores
    public ArrayList<Integer> getAllIdAutores() {
        ArrayList<Integer> autores = new ArrayList();
        try {
            if (conecta == null) {
                conecta = connectionDB.getConnection();
            }

            String sql = "SELECT aut_id FROM autor;";
            Statement statement = conecta.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                autores.add(result.getInt(1));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return autores;//cierra consulta Id autores
    }
}//cierra class
