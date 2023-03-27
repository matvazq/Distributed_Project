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
        // TODO code application logic here
        Connexion connexion = new Connexion();
        Controller controller = new Controller();
        NetworkInterface ni = new NetworkInterface(controller);
        controller.setNi(ni);
        
                Personne objPers;
        while((objPers = connexion.getPersonne()) == null){
            System.out.println("espion while");
        }
        System.out.println(objPers.getUsername());
        //connexion.dispatchEvent(new WindowEvent(connexion,WindowEvent.WINDOW_CLOSING));
        connexion.setVisible(false);
        GUI gui = new GUI(objPers.getUsername(),controller);
        controller.setGui(gui);

        
        

        return;
    }
    
}
