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
        
        String[] parts = input.split(",");
        String message = parts[0].trim();
        String username = parts[1].trim();
        byte[] ipAddressBytes = parts[2].trim().getBytes(); // assuming the IP address is in byte array format
        
        Message msg = new Message(message, new Personne(username, ipAddressBytes));

        
        return msg;
    }


    
    
    
    
    
    
}
