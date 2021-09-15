package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 *
 * @author marco
 */
public class connectionDB {

    public static Connection getConnection() {
        Connection conn = null;
        String host = "localhost";
        String user = "root";
        String password = "xxxxxx";
        String port = "3306";
        String db = "reto4";
        String dbURL = "jdbc:mysql://" + host + ":" + port + "/" + db;
        try {
            conn = DriverManager.getConnection(dbURL, user, password);
        } catch (SQLException ex) {
            Logger.getLogger(connectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }//cierra connection retornando conn
    public static void main(String[] args){
        getConnection();
    }
}//cierra class
