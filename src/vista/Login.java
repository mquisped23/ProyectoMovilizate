/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vista;

import dao.LoginDao;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.Usuario;

/**
 *
 * @author Martín Gutiérrez Fernández
 */
public class Login implements KeyListener {

    public Usuario user = new Usuario();
    public JFrame ventana;
    public JLabel jlbNombre, jlbPassword;
    public JTextField txtUsuario, txtPassword;
    public JButton btnCargar;
 

    public Login() {

        //configuracion de la ventana
        ventana = new JFrame();

        //configuracion del label
        //Label de usuario
        jlbNombre = new JLabel("Usuario");
        jlbNombre.setBounds(141, 100, 100, 30);
        jlbNombre.setFont(new Font("Serif", Font.PLAIN, 25));
        ventana.add(jlbNombre);
        //Label de contraseña
        jlbPassword = new JLabel("Contraseña");
        jlbPassword.setBounds(117, 200, 150, 30);
        jlbPassword.setFont(new Font("Serif", Font.PLAIN, 25));
        ventana.add(jlbPassword);

        //Configuracion de los jtextfield
        //jtextfield de nombre
        txtUsuario = new JTextField();
        txtUsuario.setBounds(80, 150, 200, 30);
        ventana.add(txtUsuario);
        txtUsuario.addKeyListener(this);
        //jtextfield de password
        txtPassword = new JTextField();
        txtPassword.setBounds(80, 250, 200, 30);
        ventana.add(txtPassword);
        txtPassword.setEnabled(false);
        txtPassword.addKeyListener(this);
        //Boton para ingresar
        btnCargar = new JButton("Ingresar");
        btnCargar.setBounds(130, 350, 110, 60);
        ventana.add(btnCargar);
        btnCargar.setEnabled(false);
        //esta configuracion de la ventana va al ultimo ya que sino no tomara la configuracion
        ventana.setSize(380, 600);
        ventana.setLayout(null);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(3);
        ventana.setVisible(true);

    }

    public void ingresar() {
        //guardamos los valores capturados en los jtextfield en los campos de la clase Usuario
       
        String usuario = txtUsuario.getText();
        String password = txtPassword.getText();
        LoginDao dao = new LoginDao();
        boolean respuesta = dao.findByUsername(usuario, password);
        //Hacemos una condicion para ver si coinciden los valores 
        if (respuesta == true) {
            JOptionPane.showMessageDialog(null, "Ingreso correctamente");
            //esto es para que se cierre la ventana despues de que se logue correctamente y solo muestre la pantalla principal
            this.ventana.dispose();
            Principal principal = new Principal();
        } else {
            JOptionPane.showMessageDialog(null, "Error al ingresar!! Escriba correctamente su usuario o password");
        }
    }

    public static void main(String[] args) {
        Login controlLogin = new Login();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource().equals(this.txtUsuario)) {
            txtPassword.setEnabled(this.txtUsuario.getText().length() != 0);

        } else if (e.getSource().equals(this.txtPassword)) {
            btnCargar.setEnabled(this.txtPassword.getText().length() != 0);
        }

    }

}
