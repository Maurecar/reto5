package accessDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.RevistaModel;
import utils.connectionDB;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *  Aquí realizamos el CRUD para la tabla revista
 * @author marco
 */
public class RevistaDAO {
     private Connection conecta = null;
     //consulta mezclada con recurso y revista , donde adicional se trae el titulo de la tabla recurso
    public ArrayList<RevistaModel> getAllRevistas() {
        ArrayList<RevistaModel> revista = new ArrayList();
        try {
            if (conecta == null) {
                conecta = connectionDB.getConnection();
            }

            String sql = "SELECT * FROM revista ;";
            Statement statement = conecta.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                RevistaModel revistas = new RevistaModel(result.getInt(1), result.getInt(2),result.getInt(3));
                revista.add(revistas);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return revista;
    }//cierra consulta mezclada
    //consulta por ID de revista
    public RevistaModel getRevistas(int id) {
        RevistaModel revistas = null;
        try {
            if (conecta == null) {
                conecta = connectionDB.getConnection();
            }

            String sql = "SELECT lib_volumen, lib_serie FROM revista WHERE rev_id=?;";
            Statement statement = conecta.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                revistas = new RevistaModel(result.getInt(1), result.getInt(2), result.getInt(3));
                break;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return revistas;
    }//cierra consulta revistas por ID
    //Insertar revista
    public void insertRevista(RevistaModel revista) {
        try {
            if (conecta == null) {
                conecta = connectionDB.getConnection();
            }

            String sql = "INSERT INTO revista (rev_id, lib_volumen, lib_serie) VALUES (?, ?, ?);";
            PreparedStatement statement = conecta.prepareStatement(sql);
            statement.setInt(1, revista.getRev_id());
            statement.setInt(2, revista.getRev_volumen());
            statement.setInt(3, revista.getRev_serie());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "La revista fue agregado exitosamente !");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código ..: " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
    }//cierra insert revistas
    //Actualizar revista
    public void updateRevista(RevistaModel revista) {
        try {
            if (conecta == null) {
                conecta = connectionDB.getConnection();
            }

            String sql = "UPDATE revista SET lib_volumen =?, lib_serie = ? WHERE rev_id=?;";
            PreparedStatement statement = conecta.prepareStatement(sql);
            statement.setInt(1, revista.getRev_volumen());
            statement.setInt(2, revista.getRev_serie());
            statement.setInt(3, revista.getRev_id());
            

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "La revista fue actualizado exitosamente !");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
    }//cierra update revista
    //Borrar Revista
    public void deleteRevista(int id) {
        try {
            if (conecta == null) {
                conecta = connectionDB.getConnection();
            }

            String sql = "DELETE FROM revista WHERE rev_id=?;";
            PreparedStatement statement = conecta.prepareStatement(sql);
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "La revista  fue borrado exitosamente !");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
    }//Cierra borrar revista
    //extracción de nombre de recurso
    public String getNombreRecurso(int idRecurso) {
        String nombre = "";
            if (conecta == null) {
                conecta = connectionDB.getConnection();
            }
        String sql = "SELECT cur_nombre FROM cursos WHERE cur_id="+ idRecurso +" LIMIT 1;"; //Limit 1 recupera un solo registro
        Statement statement;
        try {
            statement = conecta.createStatement();
            ResultSet result = statement.executeQuery(sql);
            
            while (result.next()) {
                nombre = result.getString(1);
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RevistaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }       

        return nombre;
    }//cierra obtener nombre desde recurso
}
