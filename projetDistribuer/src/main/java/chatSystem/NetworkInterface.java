/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chatSystem;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author dylan
 */
public class NetworkInterface implements Runnable{
    Controller myController;
    ArrayList<Socket> sockets;

    /* Constructor */
    public NetworkInterface(Controller controller) {
        myController = controller;
        sockets = new ArrayList<Socket>();
    }
    
    public int socketExist(InetAddress ipAdress){
        for(Socket s : sockets){
            if(s.getInetAddress() == ipAdress){
                return sockets.indexOf(s);
            }
        }
        return -1;
    }
    
    public void send(Message msg) throws Exception{
        int index;
        Socket s;
        InetAddress ipAdress = InetAddress.getByAddress(msg.getReceiver().getIpAdress());//throw exception
        
        //Check if a socket to this adress already exist
        if((index = socketExist(ipAdress)) != -1){
            s = sockets.get(index);
        }else{
            s = new Socket(ipAdress, 10000);
            sockets.add(s);
        }
        
        //send message
        //bufferWriter
    }

    @Override
    public void run() {
        //listen to incoming tcp connection
        
    }
    
}
