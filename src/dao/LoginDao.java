package dao;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Usuario;

public class LoginDao {

    private Connection conn;
    private PreparedStatement ps;
     Usuario usuario;
    public LoginDao() {
        conn = Conexion.openConnection();
    }

    public boolean findByUsername(String username, String password) {
        

        try {
            //llamamos a la tabla login y buscamos la columna usuario y password
            String sql = "SELECT id_login, usuario, password, rol FROM login WHERE usuario = ? and password = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                 usuario = new Usuario(
                        rs.getInt("id_login"),
                        rs.getString("usuario"),
                        rs.getString("password"),
                        rs.getInt("rol"));
                return true;
            }
            ps.close();
            rs.close();
            return false;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }

    }

}
