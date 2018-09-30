/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.basicos.modelo.conexion;

/**
 *
 * @author darkc
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author darkc
 */
public class Conexion1 {

    private static Connection cnn;

    public static Connection getConexionBD() throws NamingException, SQLException {
        InitialContext contexto = new InitialContext();
        DataSource origenDatos = (DataSource) contexto.lookup("jdbc/Homework");
        Connection cnn = origenDatos.getConnection();
        cnn.setAutoCommit(false);
        return cnn;
    }

    public static void desconectarBD(Connection cnn) throws SQLException {
        if (cnn != null) {
            cnn.commit();
            cnn.close();
            cnn = null;
        }
    }

    public static void regresarBD(Connection cnn) throws SQLException {
        if (cnn != null) {
            cnn.rollback();
            cnn.close();
        }
    }

}

