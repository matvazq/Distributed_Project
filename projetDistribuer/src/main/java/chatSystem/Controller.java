/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chatSystem;

import java.util.HashMap;

/**
 *
 * @author dylan
 */
public class Controller {
    private GUI gui;
    private NetworkInterface ni;
    private HashMap users;
 
    
    public void messageReceived(Message msg){
        String userName = msg.getSender().getUsername();
        byte[] userIp = msg.getSender().getIpAdress();

        /* if the user doesn't exist yet, add it to the users map */
        if(!users.containsKey(userName)){
            users.put(userName, userIp);
        }
        
        gui.displayMsg(userName + ": " + msg.getMsg()); //Display Username: message
    }
    
    public void sendMsg(Message msg) {
        try{
            ni.send(msg);
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }

    
    /* SETTER ; GETTER */
    public GUI getGui() {
        return gui;
    }

    public void setGui(GUI gui) {
        this.gui = gui;
    }

    public NetworkInterface getNi() {
        return ni;
    }

    public void setNi(NetworkInterface ni) {
        this.ni = ni;
    }
    
}
