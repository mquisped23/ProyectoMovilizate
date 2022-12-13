package dao;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Reserva;
import modelo.Usuario;

public class ReservaDao {

    //esta clase se encarga en hacer la conexion a la base de datos
    private Connection conn;
    private PreparedStatement ps;

    public ReservaDao() {

        conn = Conexion.openConnection();
    }

    //Metodos CRUD
    //Este va a ser el Create
    public void insert(Reserva reserva) {

        try {
            //Estos nombres vienen de la base de datos ,son las columnas
            String sql = "INSERT INTO reserva(nombre, apellido, edad, fecha_reserva, hora_reserva, rut_reserva, ubicacion_partida, ubicacion_destino) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            try ( PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setString(1, reserva.getNombres());
                ps.setString(2, reserva.getApellidos());
                ps.setString(3, reserva.getEdad());
                ps.setString(4, reserva.getFechaReserva());
                ps.setString(5, reserva.getHoraReserva());
                ps.setString(6, reserva.getRutReserva());
                ps.setString(7, reserva.getUbicacionPartida());
                ps.setString(8, reserva.getUbicacionDestino());

                ps.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Metodo para listar
    public List<Reserva> list() {
        List<Reserva> reservas = new ArrayList<>();
        try {
            String sql = "SELECT id_reserva, nombre, apellido, edad, fecha_reserva, hora_reserva, rut_reserva, ubicacion_partida, ubicacion_destino FROM  reserva ";
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Reserva reserva = new Reserva(rs.getInt("id_reserva"), rs.getString("nombre"),
                        rs.getString("apellido"), rs.getString("edad"), rs.getString("fecha_reserva"),
                        rs.getString("hora_reserva"), rs.getString("rut_reserva"), rs.getString("ubicacion_partida"),
                        rs.getString("ubicacion_destino")
                );

                reservas.add(reserva);
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return reservas;
    }

    public void eliminar(int id) {

        try {
            String sql = "delete from reserva where id_reserva=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void actualizar(Reserva reserva) {
        try {
            String sql = "update reserva set nombre=?, apellido=?, edad=?, fecha_reserva=?, hora_reserva=?, rut_reserva=?, ubicacion_partida=?,ubicacion_destino=? where id_reserva=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, reserva.getNombres());
            ps.setString(2, reserva.getApellidos());
            ps.setString(3, reserva.getEdad());
            ps.setString(4, reserva.getFechaReserva());
            ps.setString(5, reserva.getHoraReserva());
            ps.setString(6, reserva.getRutReserva());
            ps.setString(7, reserva.getUbicacionPartida());
            ps.setString(8, reserva.getUbicacionDestino());
            ps.setInt(9, reserva.getId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public boolean validFecha(String fecha) {
        try {
            String sql = "SELECT fecha_reserva FROM reserva WHERE fecha_reserva = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, fecha);
            ResultSet rs = ps.executeQuery();
            int numeroFilas = 0;
            while (rs.next()) {
                numeroFilas++;
            }
            
            if (numeroFilas < 2) {
                ps.close();
                rs.close();
                System.out.println("Aun puede registrar ");
                return false;
            } else {
                ps.close();
                rs.close();
                System.out.println("No se puede registrar mas de dos fechas iguales ");
                return true;
            }
        } catch (SQLException e) {
            return true;
        }
    }
    
     public boolean validRut(String rut){
        try {
            String sql = "SELECT rut_reserva FROM reserva WHERE rut_reserva = ?";
            ps= conn.prepareStatement(sql);
            ps.setString(1, rut);
            ResultSet rs = ps.executeQuery();
            int numeroFilas = 0;
            while (rs.next()) {
               numeroFilas++;
            }
            if (numeroFilas < 2) {
                ps.close();
                rs.close();
                 System.out.println("El rut a reservado menos de dos fechas, aun puede registrar");
                return false;
            } else {
                ps.close();
                rs.close();
                 System.out.println("El rut a reservado ya  dos fechas, no puede registrar");
                return true;
            }
        } catch (SQLException e) {
            return true;
        }
    }



   

}
