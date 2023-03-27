/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chatSystem;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author dylan
 */
public class Message implements Serializable{
    private String msg;
    private Personne sender;
    private Personne receiver;

    
    public Message(String msg, Personne sender, Personne receiver) {
        this.msg = msg;
        this.sender = sender;
        this.receiver = receiver;
    }

    public Message(String msg, Personne sender) {
        this.msg = msg;
        this.sender = sender;
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

    @Override
    public String toString() {
        return msg + "," + sender;
    }
    
   
       
    public static Message extractValues(String input) {
        /* Extracts values from String */
        String[] parts = input.split(",");
        String message = parts[0].trim();
        String username = parts[1].trim();
        String ipAddressString = parts[2].trim(); //format 192.168.0.1

        /* Display extracted values */
        System.out.println("Extracting values... ");
        System.out.println("    message: " + message);
        System.out.println("    username: " + username);
        System.out.println("    ipAdress: " + ipAddressString);

        /* Split ipAddressString into 4 int */
        String[] ipTabString = ipAddressString.split("\\.");
        int[] ipTab = new int[4];
        for(int i = 0; i < 4; i++){
            ipTab[i] = Integer.parseInt(ipTabString[i]);
        }
        
        /* Build Byte array from previous ip parts*/
        byte[] ipAddressBytes = {(byte)ipTab[0], (byte)ipTab[1], (byte)ipTab[2], (byte)ipTab[3] };
        Message msg = new Message(message, new Personne(username, ipAddressBytes));
        
        return msg;
    }


    
    
    
    
    
    
}
