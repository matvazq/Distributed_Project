/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import chatSystem.Connexion;
import chatSystem.Controller;
import chatSystem.GUI;
import chatSystem.NetworkInterface;
import chatSystem.Personne;
import java.awt.event.WindowEvent;

/**
 *
 * @author matva
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Open the connection window */
        Connexion connexion = new Connexion();
        
        /* Create chatSystem Component */
        Controller controller = new Controller();
        NetworkInterface ni = new NetworkInterface(controller);
        controller.setNi(ni);
        
        /* Wait for user to enter his username */
        Personne objPers;
        while((objPers = connexion.getPersonne()) == null){
            System.out.println("je t'avais dis que ca marchais pas sans");
        }
        System.out.println(objPers.getUsername());

        connexion.setVisible(false);
        
        /* Display main window */
        GUI gui = new GUI(objPers,controller);
        controller.setGui(gui);
        controller.connection();

        return;
    }
    
}
