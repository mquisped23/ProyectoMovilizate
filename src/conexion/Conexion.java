package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static Connection conn;

    // Metodo para abrir la conexión a la base de datos
    public static Connection openConnection() {
        if (conn != null) {
            return conn;
        }

        try {
            //Aca se ingresa el nombre de tu base de datos
            String usuario = "miguel"; // el usuario
            String password = "miguelelmejor"; // tu password
            String url = "jdbc:mysql://localhost:3306/abuelobd?autoReconnect = true & useSSL = false";

            // Establecer el Driver de conexión
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, usuario, password);

            System.out.println("Conexion establecida");

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Conexion Fallida");
        }
        return conn;
    }
    // Metodo para cerrar la conexion a la Base de datos

    public static void closeConnection() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
