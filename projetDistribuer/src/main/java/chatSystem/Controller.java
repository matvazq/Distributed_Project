/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chatSystem;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author dylan
 */
public class Controller {
    private GUI gui;
    private NetworkInterface ni;
    private HashMap<String, byte[]> users;
    private Personne localUser;

    public Controller() {
        this.users = new HashMap();
    }
    
 
    
    public void messageReceived(Message msg){
        String userName = msg.getSender().getUsername();
        byte[] userIp = msg.getSender().getIpAdress();
        

        /* Don't display local user's message */
        if(localUser.equals(msg.getSender())){
            System.out.println("same user");
            return;
        }
        
        /* if the user doesn't exist yet, add it to the users map */
        if(!users.containsKey(userName)){
            users.put(userName, userIp);
            gui.addListElement(userName);
            try{
                System.out.println("Sender ip = " + InetAddress.getByAddress(userIp));              
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        
        gui.displayMsg(userName + ": " + msg.getMsg()); //Display Username: message
        
        if(msg.getReply()){

            Message replyMsg = new Message("hello", this.localUser, false);
            this.sendMsg(replyMsg, userName);


        }
    }
    
    /* Send to every user connected */
    public void sendMsg(Message msg) {
        try{
            ni.send(msg);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    /* Send to multiple users */
    public void sendMsg(Message msg, ArrayList<String> userSelected) {
        try{
            byte[] userByteAddress;
            for(String userName : userSelected){
                userByteAddress = users.get(userName);
                ni.send(msg, userByteAddress);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    /* Send to only one user */
    public void sendMsg(Message msg, String userSelected) {
        try{
            byte[] userByteAddress = users.get(userSelected);
            InetAddress userIp = InetAddress.getByAddress(userByteAddress);
            ni.send(msg, userByteAddress);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    public void connection(){
        Message connectionMessage = new Message("Hello ", this.localUser, true);
        gui.displayOwnMsg(connectionMessage.getMsg());
        this.sendMsg(connectionMessage);
    }

    
    /* SETTER ; GETTER */
    public GUI getGui() {
        return gui;
    }

    public void setGui(GUI gui) {
        this.gui = gui;
        this.localUser = gui.getPersonne();
    }

    public NetworkInterface getNi() {
        return ni;
    }

    public void setNi(NetworkInterface ni) {
        this.ni = ni;
    }
    
}
