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

    public Message(String msg, Personne sender, Personne receiver) {
        this.msg = msg;
        this.sender = sender;
        this.receiver = receiver;
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
    
    
    
    
    
}
