/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.basicos.modelo.conexion;

/**
 *
 * @author Aprendiz
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static Connection cnn;

    public static Connection getConexionBD() throws ClassNotFoundException, SQLException {
        if (cnn == null) {
            Class.forName("com.mysql.jdbc.Driver");
            cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HomeWork", "root", "");
            cnn.setAutoCommit(false);
        }
        return cnn;
    }

    public static void desconectarBD() throws SQLException {
        if (cnn != null) {
            cnn.commit();
            cnn.close();
            cnn = null;
        }
    }

    public static void regresarBD() throws SQLException {
        if (cnn != null) {
            cnn.rollback();
            cnn.close();
        }
    }

}
