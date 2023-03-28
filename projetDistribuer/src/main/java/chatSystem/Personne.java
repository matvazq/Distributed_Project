/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chatSystem;

import java.net.InetAddress;
import java.util.Arrays;
import java.util.Objects;

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

    @Override
    public String toString() {
        try{
            InetAddress ip = InetAddress.getByAddress(this.ipAdress); //format: 192.168.0.1

            //System.out.println("Personne ipAdress: " + ip.getHostAddress());
            return username + "," + ip.getHostAddress();
        }catch(Exception e){
            e.printStackTrace();
        }
        return "erreur";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Personne other = (Personne) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return Arrays.equals(this.ipAdress, other.ipAdress);
    }
    
    
    
}
