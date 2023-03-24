/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chatSystem;

/**
 *
 * @author matva
 */
public class Personne {
    private String username;
    private byte[] ipAdress;

    public Personne(String username, byte[] ipAdress) {
        this.username = username;
        this.ipAdress = ipAdress;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public byte[] getIpAdress() {
        return ipAdress;
    }

    public void setIpAdress(byte[] ipAdress) {
        this.ipAdress = ipAdress;
    }
    
    
    
}
