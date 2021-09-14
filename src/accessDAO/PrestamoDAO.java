package accessDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.PrestamoModel;
import utils.connectionDB;

/**
 * Aquí realizamos el CRUD de la tabla prestamo
 *
 * @author marco
 */
public class PrestamoDAO {

    private Connection conecta = null;

    //consulta prestamos
    public ArrayList<PrestamoModel> getAllPrestamo() {
        ArrayList<PrestamoModel> prestamos = new ArrayList();
        try {
            if (conecta == null) {
                conecta = connectionDB.getConnection();
            }

            String sql = "SELECT * FROM prestamo ORDER BY pre_id;";
            java.sql.Statement statement = conecta.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                PrestamoModel prestamo = new PrestamoModel(result.getInt(1), result.getString(2), result.getInt(3), result.getString(4));
                prestamos.add(prestamo);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return prestamos;
    }//cierra consulta todos los prestamos
    //Insertar prestamo

    public void insertPrestamo(PrestamoModel prestamo) {
        try {
            if (conecta == null) {
                conecta = connectionDB.getConnection();
            }

            String sql = "INSERT INTO prestamo (pre_id, pre_usuario, pre_rec, pre_fecha) VALUES (?, ?, ?, ?);";
            PreparedStatement statement = conecta.prepareStatement(sql);
            statement.setInt(1, prestamo.getPre_id());
            statement.setString(2, prestamo.getPre_usuario());
            statement.setInt(3, prestamo.getPre_rec());
            statement.setString(4, prestamo.getPre_fecha());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "El prestamo fue agregado exitosamente !");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código ..: " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
    }//cierra insert prestamo
    //Actualizar prstamo

    public void updatePrestamo(PrestamoModel prestamo) {
        try {
            if (conecta == null) {
                conecta = connectionDB.getConnection();
            }

            String sql = "UPDATE prestamo SET pre_usuario =?, pre_rec = ?, pre_fecha=? WHERE pre_id=?;";
            PreparedStatement statement = conecta.prepareStatement(sql);

            statement.setString(1, prestamo.getPre_usuario());
            statement.setInt(2, prestamo.getPre_rec());
            statement.setString(3, prestamo.getPre_fecha());
            statement.setInt(4, prestamo.getPre_id());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "El prestamo fue actualizado exitosamente !");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
    }//cierra update prestamo
    //Borrar Revista

    public void deletePrestamo(int id) {
        try {
            if (conecta == null) {
                conecta = connectionDB.getConnection();
            }
            String sql = "DELETE FROM prestamo WHERE pre_id=?;";
            PreparedStatement statement = conecta.prepareStatement(sql);
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "El prestamo fue borrado exitosamente !");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        
    }//Cierra borrar Libro
}//cierra class
