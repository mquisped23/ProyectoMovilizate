/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.List;

/**
 * @author Martín Gutiérrez Fernández
 *
 */
public class Reserva {

    private int id;
    //Variable para almacenar los nombres
    private String nombres;
    //Variable para almacenar los apellidos
    private String apellidos;
    //Variable para almacenar las edades
    private String edad;
    //Variable para almacenar las fechas de reserva
    private String fechaReserva;
    //Variable para almacenar la hora de reserva
    private String horaReserva;
    //Variable para almacenar el rut
    private String rutReserva;
    //Variable para almacenar la ub de partida
    private String ubicacionPartida;
    //Variable para almacenar el rut
    private String ubicacionDestino;

    public Reserva() {
    }

    public Reserva(String nombres, String apellidos, String edad, String fechaReserva, String horaReserva, String rutReserva, String ubicacionPartida, String ubicacionDestino) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.fechaReserva = fechaReserva;
        this.horaReserva = horaReserva;
        this.rutReserva = rutReserva;
        this.ubicacionPartida = ubicacionPartida;
        this.ubicacionDestino = ubicacionDestino;
    }

    public Reserva(int id, String nombres, String apellidos, String edad, String fechaReserva, String horaReserva, String rutReserva, String ubicacionPartida, String ubicacionDestino) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.fechaReserva = fechaReserva;
        this.horaReserva = horaReserva;
        this.rutReserva = rutReserva;
        this.ubicacionPartida = ubicacionPartida;
        this.ubicacionDestino = ubicacionDestino;
    }

    public Reserva(String horaReserva) {
        this.horaReserva = horaReserva;
    }

 
  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public String getHoraReserva() {
        return horaReserva;
    }

    public void setHoraReserva(String horaReserva) {
        this.horaReserva = horaReserva;
    }

    public String getRutReserva() {
        return rutReserva;
    }

    public void setRutReserva(String rucReserva) {
        this.rutReserva = rucReserva;
    }

    public String getUbicacionPartida() {
        return ubicacionPartida;
    }

    public void setUbicacionPartida(String ubicacionPartida) {
        this.ubicacionPartida = ubicacionPartida;
    }

    public String getUbicacionDestino() {
        return ubicacionDestino;
    }

    public void setUbicacionDestino(String ubicacionDestino) {
        this.ubicacionDestino = ubicacionDestino;
    }

    @Override
    public String toString() {
        return "Reserva{" + "id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", edad=" + edad + ", fechaReserva=" + fechaReserva + ", horaReserva=" + horaReserva + ", rutReserva=" + rutReserva +",ubicacionPartida="+ubicacionPartida +",ubicacionDestino"+ubicacionDestino+ '}';
    }

}
