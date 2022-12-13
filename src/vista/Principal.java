/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import com.toedter.calendar.JDateChooser;
import dao.ReservaDao;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import modelo.Reserva;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Martín Gutiérrez Fernández
 */
public class Principal implements ActionListener, KeyListener {

    private JFrame ventana;
    private JLabel jblNombre, jblApellido, jblEdad, jblFecha, jblHora, jblRut, jblUbicacionPartida, jblUbicacionDestino, jblTitulo, jblImagen;
    private JTextField txtId, txtNombre, txtApellido, txtEdad, txtHora, txtRut, txtUbicacionPartida, txtUbicacionDestino;
    private JDateChooser jFecha;
    private JButton btnGuardar, btnReiniciar, btnEliminar, btnEditar, btnActualizar;
    private JTable table;
    private JScrollPane scroll;
    private ReservaDao dao = new ReservaDao();
    Reserva reser = new Reserva();

    public Principal() {

        //configuracion de la ventana
        ventana = new JFrame();

        //configuracion del label
        //Label de Nombre
        jblNombre = new JLabel("Nombre:");
        jblNombre.setBounds(30, 30, 100, 30);
        jblNombre.setFont(new Font("Serif", Font.PLAIN, 25));
        ventana.add(jblNombre);
        //Label de apellido
        jblApellido = new JLabel("Apellido:");
        jblApellido.setBounds(250, 30, 100, 30);
        jblApellido.setFont(new Font("Serif", Font.PLAIN, 25));
        ventana.add(jblApellido);
        //Label de edad
        jblEdad = new JLabel("Edad:");
        jblEdad.setBounds(490, 30, 100, 30);
        jblEdad.setFont(new Font("Serif", Font.PLAIN, 25));
        ventana.add(jblEdad);
        //Label de edad
        jblFecha = new JLabel("Fecha de Reserva:");
        jblFecha.setBounds(30, 80, 200, 30);
        jblFecha.setFont(new Font("Serif", Font.PLAIN, 25));
        ventana.add(jblFecha);
        //Label de hora
        jblHora = new JLabel("Hora de Reserva:");
        jblHora.setBounds(380, 80, 180, 30);
        jblHora.setFont(new Font("Serif", Font.PLAIN, 25));
        ventana.add(jblHora);
        //Label de rut
        jblRut = new JLabel("Rut:");
        jblRut.setBounds(30, 130, 180, 30);
        jblRut.setFont(new Font("Serif", Font.PLAIN, 25));
        ventana.add(jblRut);
        //Label de ubicacionPartida
        jblUbicacionPartida = new JLabel("Ubicacion de Partida:");
        jblUbicacionPartida.setBounds(230, 130, 220, 30);
        jblUbicacionPartida.setFont(new Font("Serif", Font.PLAIN, 25));
        ventana.add(jblUbicacionPartida);
        //Label de Ubicaciondestino
        jblUbicacionDestino = new JLabel("Ubicacion de Destino:");
        jblUbicacionDestino.setBounds(30, 180, 230, 30);
        jblUbicacionDestino.setFont(new Font("Serif", Font.PLAIN, 25));
        ventana.add(jblUbicacionDestino);
        //Label de titulo
        jblTitulo = new JLabel("Movilizate Abuelit@");
        jblTitulo.setBounds(750, 30, 350, 50);
        jblTitulo.setFont(new Font("Serif", Font.BOLD, 40));
        ventana.add(jblTitulo);
        //Label de Imagen
        ImageIcon icon = new ImageIcon("src/imagenes/abue.png");
        Image img = icon.getImage();

        jblImagen = new JLabel();
        jblImagen.setBounds(850, 100, 128, 128);
        jblImagen.setIcon(icon);
        ventana.add(jblImagen);

        //JtextFields
        //Configuracion de los jtextfield
        //jtextfield de id
        txtId = new JTextField();
        txtId.setBounds(0, 0, 0, 0);
        ventana.add(txtId);
        //jtextfield de nombre
        txtNombre = new JTextField();
        txtNombre.setBounds(130, 30, 100, 30);
        ventana.add(txtNombre);
        txtNombre.addKeyListener(this);
        //jtextfield de Apellido
        txtApellido = new JTextField();
        txtApellido.setBounds(350, 30, 100, 30);
        ventana.add(txtApellido);
        txtApellido.addKeyListener(this);
        //jtextfield de edad
        txtEdad = new JTextField();
        txtEdad.setBounds(560, 30, 100, 30);
        ventana.add(txtEdad);
        txtEdad.addKeyListener(this);

        //jtextfield de fecha de reserva
        jFecha = new JDateChooser();
        jFecha.setBounds(230, 80, 100, 30);
        ventana.add(jFecha);
        //jtextfield de hora de reserva
        txtHora = new JTextField();
        txtHora.setBounds(560, 80, 100, 30);
        ventana.add(txtHora);
        //jtextfield de rut
        txtRut = new JTextField();
        txtRut.setBounds(100, 130, 100, 30);
        ventana.add(txtRut);
        txtRut.addKeyListener(this);
        //jtextfield de ubicacionPartida
        txtUbicacionPartida = new JTextField();
        txtUbicacionPartida.setBounds(450, 130, 210, 30);
        ventana.add(txtUbicacionPartida);
        // txtRuc.addKeyListener(this);
        //jtextfield de ubicacionDestino
        txtUbicacionDestino = new JTextField();
        txtUbicacionDestino.setBounds(260, 180, 170, 30);
        ventana.add(txtUbicacionDestino);
        //txtRuc.addKeyListener(this);

        //Boton para ingresar
        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(30, 230, 90, 30);
        ventana.add(btnGuardar);
        btnGuardar.addActionListener(this);
        //Boton para reiniciar
        btnReiniciar = new JButton("Reiniciar");
        btnReiniciar.setBounds(140, 230, 90, 30);
        ventana.add(btnReiniciar);
        btnReiniciar.addActionListener(this);
        //Boton para eliminar
        btnEliminar = new JButton("Elimnar");
        btnEliminar.setBounds(250, 230, 90, 30);
        ventana.add(btnEliminar);
        btnEliminar.addActionListener(this);
        //Boton para Editar
        btnEditar = new JButton("Editar");
        btnEditar.setBounds(360, 230, 90, 30);
        ventana.add(btnEditar);
        btnEditar.addActionListener(this);
        //Boton para Actualizar
        btnActualizar = new JButton("Actualizar");
        btnActualizar.setBounds(470, 230, 110, 30);
        ventana.add(btnActualizar);
        btnActualizar.addActionListener(this);
        //Creacion de scroll y tabla
        table = new JTable();
        scroll = new JScrollPane(table);

        table.setBounds(30, 280, 1120, 300);
        scroll.setBounds(30, 280, 1120, 300);
        ventana.add(scroll);

        //esta configuracion de la ventana va al ultimo ya que sino no tomara la configuracion
        ventana.setSize(1200, 700);
        ventana.setLayout(null);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(3);
        ventana.setVisible(true);
        this.mostrarDatos();
    }

    //Metodo para poner formato a la hora
    public String fecha() {
        String dia, mes, year;
        if (jFecha.getDate() != null) {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            String fecha = formato.format(jFecha.getDate());
            return fecha;

        } else {
            dia = "00";
            mes = "00";
            year = "0000";
            String fecha = dia + "-" + mes + "-" + year;
            return fecha;
        }
    }

    //Metodo para listar las reservas
    public void listaReserva() {
        try {
            if (dao.validFecha(fecha()) == true || dao.validRut(txtRut.getText()) == true) {
                
            } else {
                //aqui guardo los datos en la base de datos
                dao.insert(new Reserva(txtNombre.getText(), txtApellido.getText(), txtEdad.getText(), fecha(), txtHora.getText(), txtRut.getText(), txtUbicacionPartida.getText(), txtUbicacionDestino.getText()));

            }
            
        } catch (Exception e) {
            e.printStackTrace();
           
        }

    }



    //Mostrar tabla al inciar el sistema
    //Metodo para llenar la tabla
    public void mostrarDatos() {
        try {
            DefaultTableModel modelo = new DefaultTableModel(new String[]{"id", "Nombre", "Apellido", "Edad", "Fecha", "Hora", "Rut", "Ubicacion de Partida", "Ubicacion de Destino"}, dao.list().size());
            table.setModel(modelo);

            TableModel modeloDatos = table.getModel();
            for (int i = 0; i < dao.list().size(); i++) {
                Reserva res = dao.list().get(i);
                modeloDatos.setValueAt(res.getId(), i, 0);
                modeloDatos.setValueAt(res.getNombres(), i, 1);
                modeloDatos.setValueAt(res.getApellidos(), i, 2);
                modeloDatos.setValueAt(res.getEdad(), i, 3);
                modeloDatos.setValueAt(res.getFechaReserva(), i, 4);
                modeloDatos.setValueAt(res.getHoraReserva(), i, 5);
                modeloDatos.setValueAt(res.getRutReserva(), i, 6);
                modeloDatos.setValueAt(res.getUbicacionPartida(), i, 7);
                modeloDatos.setValueAt(res.getUbicacionDestino(), i, 8);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

    }

    ///metodo para eliminar
    public void eliminarDatoTabla() {
        int fila = table.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una reserva para poder eliminar");
        } else {
            int id = Integer.parseInt((String) table.getValueAt(fila, 0).toString());
            dao.eliminar(id);
            JOptionPane.showMessageDialog(null, "Se a eliminado correctamente");
        }

    }

    public void editar() throws ParseException {
        int fila = this.table.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccionar una fila a editar");
        } else {
            int id = Integer.parseInt((String) table.getValueAt(fila, 0).toString());
            String nombre = (String) this.table.getValueAt(fila, 1);
            String apellido = (String) this.table.getValueAt(fila, 2);
            String edad = (String) this.table.getValueAt(fila, 3);
            String fechaReserva = (String) this.table.getValueAt(fila, 4);
            String horaReserva = (String) this.table.getValueAt(fila, 5);
            String rutReserva = (String) this.table.getValueAt(fila, 6);
            String ubicacionPartida = (String) this.table.getValueAt(fila, 7);
            String ubicacionDestino = (String) this.table.getValueAt(fila, 8);

            this.txtId.setText("" + id);
            this.txtNombre.setText(nombre);
            this.txtApellido.setText(apellido);
            this.txtEdad.setText(edad);
            Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(fechaReserva);
            this.jFecha.setDate(date2);
            this.txtHora.setText(horaReserva);
            this.txtRut.setText(rutReserva);
            this.txtUbicacionPartida.setText(ubicacionPartida);
            this.txtUbicacionDestino.setText(ubicacionDestino);

        }
    }

    public void actualizar() {
        try {
            int id = Integer.parseInt(this.txtId.getText());
            String nombre = this.txtNombre.getText();
            String apellido = this.txtApellido.getText();
            String edad = this.txtEdad.getText();
            String fechaReserva = this.fecha();
            String horaReserva = this.txtHora.getText();
            String rutReserva = this.txtRut.getText();
            String ubicacionPartida = this.txtUbicacionPartida.getText();
            String ubicacionDestino = this.txtUbicacionDestino.getText();
            dao.actualizar(new Reserva(id, nombre, apellido, edad, fechaReserva, horaReserva, rutReserva, ubicacionPartida, ubicacionDestino));

        } catch (Exception e) {
        }
    }

    public void reiniciar() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtEdad.setText("");
        jFecha.setCalendar(null);
        txtHora.setText("");
        txtRut.setText("");
        txtUbicacionPartida.setText("");
        txtUbicacionDestino.setText("");
    }

    public static void main(String[] args) {
        Principal vista = new Principal();

    }

    //Eventos de Reinicio y Guardado
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.btnReiniciar)) {
            this.reiniciar();
        }
        if (e.getSource().equals(this.btnEliminar)) {
            this.eliminarDatoTabla();
            System.out.println("Se a eliminado la reserva");
            this.mostrarDatos();
        }
        if (e.getSource().equals(this.btnEditar)) {
            try {
                this.editar();
            } catch (ParseException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource().equals(this.btnActualizar)) {
            this.actualizar();
            JOptionPane.showMessageDialog(null, "Datos actualizados correctamente");
            System.out.println("Datos actualizados correctamente");
            this.reiniciar();
            this.mostrarDatos();
        }
        if (e.getSource().equals(this.btnGuardar)) {
            if (txtNombre.getText().isEmpty() || txtApellido.getText().isEmpty() || txtEdad.getText().isEmpty() || jFecha.getDate() == null
                    || txtHora.getText().isEmpty() || txtRut.getText().isEmpty() || txtUbicacionPartida.getText().isEmpty() || txtUbicacionDestino.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Reserva Incompleta");
            } else {
                if (dao.validFecha(fecha()) == true) {
                    JOptionPane.showMessageDialog(null, "La reserva ya se agendo 2 veces");
                } else if (dao.validRut(txtRut.getText()) == true) {
                    JOptionPane.showMessageDialog(null, "El usuario solo puede registrar dos veces por dia");
                } else {
                    System.out.println("Se a guardado la reserva");
                    JOptionPane.showMessageDialog(null, "Reserva exitosa");
                    listaReserva();
                    this.mostrarDatos();
                    
                }

            }

        }
    }
    //Validaciones de solo text/ solo numeros / max 12carac

    @Override
    public void keyTyped(KeyEvent e) {
        char key = e.getKeyChar();
        //validacion para que acepte solo numero el campo de edad
        if (e.getSource().equals(this.txtEdad)) {
            if (Character.isAlphabetic(key)) {
                e.consume();
                JOptionPane.showMessageDialog(null, "Ingrese Solo Numeros");
            }
        } else if (e.getSource().equals(this.txtNombre)) {
            if (Character.isDigit(key)) {
                e.consume();
                JOptionPane.showMessageDialog(null, "Ingrese Solo Letras");
            }
        } else if (e.getSource().equals(this.txtApellido)) {
            if (Character.isDigit(key)) {
                e.consume();
                JOptionPane.showMessageDialog(null, "Ingrese Solo Letras");
            }
        } else if (e.getSource().equals(this.txtRut)) {
            if (txtRut.getText().length() > 11) {
                e.consume();
                JOptionPane.showMessageDialog(null, "caracteres maximo de 12");
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
