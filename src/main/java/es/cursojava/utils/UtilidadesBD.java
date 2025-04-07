package es.cursojava.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UtilidadesBD {
    private static final String URL_DB_ORACLE = "jdbc:oracle:thin:@localhost:1522:XE";
    private static final String USER_DB_ORACLE = "getafesql";
    private static final String PASSWORD_DB_ORACLE="password";
    private static Connection conn = null;

    public static Connection crearConexion (){
        conn = crearConexion(URL_DB_ORACLE, USER_DB_ORACLE, PASSWORD_DB_ORACLE);

        return conn;
    }

    public static Connection crearConexion (String url, String user, String password){

        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.err.println("Error crear la sesión"+ e.getMessage());
        }

        return conn;
    }

    public static void cierraConexion(Connection connection){

        try {
            connection.close();
        } catch (SQLException e) {
            System.err.println("Error al cerrar la sesión "+ e.getMessage());
        }

    }

}

