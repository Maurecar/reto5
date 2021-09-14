
package accessDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.LibroModel;
import utils.connectionDB;

/**
 * Aquí creamo el CRUD para la tabla libro
 * @author marco
 */
public class LibroDAO {
    private Connection conecta = null;
    //consulta mixta entre recurso y libro
    public ArrayList<LibroModel> getAllLibro() {
        ArrayList<LibroModel> libros = new ArrayList();
        try {
            if (conecta == null) {
                conecta = connectionDB.getConnection();
            }

            //String sql = "SELECT libro.lib_id, recurso.rec_titulo, libro.lib_anio, autor.aut_nombres FROM recurso INNER JOIN libro on recurso.rec_id = libro.lib_id INNER JOIN autor on autor.aut_id = libro.lib_autor ORDER BY lib_id;";
            String sql = "select * from libro;";
            java.sql.Statement statement = conecta.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                LibroModel libro = new LibroModel(result.getInt(1), result.getString(2), result.getInt(3), result.getInt(4));
                libros.add(libro);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return libros;
    }//cierra consulta todos los libros
    //consulta por id de libros
    public LibroModel getLibros(int id) {
        LibroModel libros = null;
        try {
            if (conecta == null) {
                conecta = connectionDB.getConnection();
            }

            String sql = "SELECT lib_resumen, lib_anio, lib_autor FROM libro WHERE lib_id=?;";
            java.sql.Statement statement = conecta.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                libros = new LibroModel(result.getInt(1), result.getString(2), result.getInt(3), result.getInt(4));
                break;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return libros;
    }//cierra consulta libros por ID
    //Insertar libro
    public void insertLibro(LibroModel libro) {
        try {
            if (conecta == null) {
                conecta = connectionDB.getConnection();
            }

            String sql = "INSERT INTO libro (lib_id, lib_resumen, lib_anio, lib_autor) VALUES (?, ?, ?, ?);";
            PreparedStatement statement = conecta.prepareStatement(sql);
            statement.setInt(1, libro.getLib_id());
            statement.setString(2, libro.getLib_resumen());
            statement.setInt(3, libro.getLib_anio());
            statement.setInt(4, libro.getLib_autor());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "El libro fue agregado exitosamente !");
            }else{
            JOptionPane.showMessageDialog(null,"No se agrego el registro");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código ..: " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
    }//cierra insert libro
    //Actualizar Libro
    public void updateLibro(LibroModel libro) {
        try {
            if (conecta == null) {
                conecta = connectionDB.getConnection();
            }

            String sql = "UPDATE libro SET lib_resumen =?, lib_anio = ?, lib_autor=? WHERE lib_id=?;";
            PreparedStatement statement = conecta.prepareStatement(sql);
            
            statement.setString(1, libro.getLib_resumen());
            statement.setInt(2, libro.getLib_anio());
            statement.setInt(3, libro.getLib_autor());
            statement.setInt(4, libro.getLib_id());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "El libro fue actualizado exitosamente !");
            }else{
            JOptionPane.showMessageDialog(null,"No se actualizó el registro");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
    }//cierra update Libro
    //Borrar Revista
    public void deleteLibro(int id) {
        try {
            if (conecta == null) {
                conecta = connectionDB.getConnection();
            }

            String sql = "DELETE FROM libro WHERE lib_id=?;";
            PreparedStatement statement = conecta.prepareStatement(sql);
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "El libro fue borrado exitosamente !");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
    }//Cierra borrar Libro
    
}//cierra class
