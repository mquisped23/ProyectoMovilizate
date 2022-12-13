/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.Login;
import vista.Principal;

/**
 *
 * @author Martín Gutiérrez Fernández
 */
public class ControladorLogin implements ActionListener{
    Login login;
    
    //Constructor
    public ControladorLogin(){
        login = new Login();
         this.login.btnCargar.addActionListener(this);
    }
    
    public static void main(String[] args) {
        ControladorLogin control = new ControladorLogin();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(login.btnCargar)){
            login.ingresar();
        }
    }
    
}
