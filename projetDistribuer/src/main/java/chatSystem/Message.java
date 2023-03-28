/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chatSystem;

import java.io.Serializable;


/**
 *
 * @author dylan
 */
public class Message implements Serializable{
    private String msg;
    private Personne sender;
    private Personne receiver;
    private boolean reply;

    
    public Message(String msg, Personne sender, Personne receiver) {
        this.msg = msg;
        this.sender = sender;
        this.receiver = receiver;
    }

    public Message(String msg, Personne sender, Boolean reply) {
        this.msg = msg;
        this.sender = sender;
        this.reply = reply;
    }
    
    public Message(String msg) {
        this.msg = msg;
    }
    
    
    
    public String getMsg(){
        return this.msg;
    }

    public Personne getSender() {
        return sender;
    }

    public Personne getReceiver() {
        return receiver;
    }

    public boolean getReply() {
        return reply;
    }
    
    

    @Override
    public String toString() {
        return msg + "," + sender + "," + reply;
    }
    
    
   
       
    public static Message extractValues(String input) {
        /* Extracts values from String */
        String[] parts = input.split(",");
        String message = parts[0].trim();
        String username = parts[1].trim();
        String ipAddressString = parts[2].trim(); //format 192.168.0.1
        Boolean reply = Boolean.parseBoolean(parts[3].trim());

        /* Display extracted values */
        System.out.println("Extracting values... ");
        System.out.println("    message: " + message);
        System.out.println("    username: " + username);
        System.out.println("    ipAdress: " + ipAddressString);
        System.out.println("    reply: " + reply + "\n");

        /* Split ipAddressString into 4 int */
        String[] ipTabString = ipAddressString.split("\\.");
        int[] ipTab = new int[4];
        for(int i = 0; i < 4; i++){
            ipTab[i] = Integer.parseInt(ipTabString[i]);
        }
        
        /* Build Byte array from previous ip parts*/
        byte[] ipAddressBytes = {(byte)ipTab[0], (byte)ipTab[1], (byte)ipTab[2], (byte)ipTab[3] };
        Message msg = new Message(message, new Personne(username, ipAddressBytes), reply);
        
        return msg;
    }


    
    
    
    
    
    
}
