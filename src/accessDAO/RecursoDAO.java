package accessDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.RecursoModel;
import utils.connectionDB;
import java.sql.Statement;
import javax.swing.JOptionPane;


/**
 *
 * @author marco
 */
public class RecursoDAO {

    private Connection conecta = null;
    //consulta recurso

    public ArrayList<RecursoModel> getAllRecursos() {

        ArrayList<RecursoModel> recursos = new ArrayList();
        try {
            if (conecta == null) {
                conecta = connectionDB.getConnection();
            }

            String sql = "SELECT * FROM recurso;";
            Statement statement = conecta.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                RecursoModel recurso = new RecursoModel(result.getInt(1), result.getString(2));
                recursos.add(recurso);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return recursos;
    }//cierra consulta tabla recurso
    //consulta por Id de Recursos
    public RecursoModel getCurso(int id) {
        RecursoModel curso = null;
        try {
            if (conecta == null) {
                conecta = connectionDB.getConnection();
            }

            String sql = "SELECT rec_titulo FROM recurso WHERE rec_id=?;";
            PreparedStatement statement = conecta.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                curso = new RecursoModel(id, result.getString(1));
                break;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return curso;
    }//cierra consulta por Id de recurso
    //agrega recurso
    public void insertRecurso(RecursoModel recurso) {
        try {
            if (conecta == null) {
                conecta = connectionDB.getConnection();
            }

            String sql = "INSERT INTO recurso(rec_id, rec_titulo) VALUES (?, ?);";
            PreparedStatement statement = conecta.prepareStatement(sql);
            statement.setInt(1, recurso.getRec_id());
            statement.setString(2, recurso.getRec_titulo());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "El Recurso fue agregado exitosamente !");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
    }//cierra agregar recurso
    //actualiza recurso
    public void updateCurso(RecursoModel recurso) {
        try {
            if (conecta == null) {
                conecta = connectionDB.getConnection();
            }

            String sql = "UPDATE recurso SET rec_titulo =? WHERE rec_id=?;";
            PreparedStatement statement = conecta.prepareStatement(sql);
            statement.setString(1, recurso.getRec_titulo());
            statement.setInt(2, recurso.getRec_id());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "El Recurso fue actualizado exitosamente !");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
    }//cierra actualización de recurso
    //elimina recurso
    public void deleteRecurso(int id) {
        System.out.println("id " + id);
        try {
            if (conecta == null) {
                conecta = connectionDB.getConnection();
            }

            String sql = "DELETE FROM recurso WHERE rec_id=?;";
            PreparedStatement statement = conecta.prepareStatement(sql);
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "El Recurso fue borrado exitosamente !");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
    }//cierra eliminar recurso
// Consulta de ID por limitada por los id de Revista
    public ArrayList<Integer> getAllIdRecursos() {
        ArrayList<Integer> recursos = new ArrayList();
        try {
            if (conecta == null) {
                conecta = connectionDB.getConnection();
            }

            String sql = "SELECT rec_id FROM recurso;";
            Statement statement = conecta.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                recursos.add(result.getInt(1));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return recursos;
    }//Cierra consulata id filtrada con revista
}//cierra class
