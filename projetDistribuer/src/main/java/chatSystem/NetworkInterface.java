/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chatSystem;

import UDP.UDPListener;
import UDP.UDPReader;
import UDP.UDPWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.DatagramSocket;
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
    InetAddress ipAdress;

    /* Constructor */
    public NetworkInterface(Controller controller) {
        myController = controller;
        sockets = new ArrayList<Socket>();
        try{
            ipAdress = InetAddress.getByAddress("moi", new byte[] {(byte)10, (byte)8, (byte)32, (byte)241});


            
            //socket for window A
            DatagramSocket sender1 = new DatagramSocket();
            DatagramSocket receiver1 = new DatagramSocket(10000);//listen on port 10 000
            
            BufferedReader reader = new BufferedReader(new UDPReader(receiver1));
            BufferedWriter writer = new BufferedWriter(new UDPWriter(sender1, ipAdress, 20000));//write on port 20 000
            
            Thread t = new Thread(new UDPListener(this.myController,reader));
            t.start();
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
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
        DatagramSocket sender = new DatagramSocket();
        BufferedWriter writer = new BufferedWriter(new UDPWriter(sender,ipAdress,10000));
        writer.write(msg.getMsg());
        
        writer.newLine();
        writer.flush();
    }
    
    public void broadcast(){
                

    }
    @Override
    public void run() {
        //listen to incoming tcp connection
        
        
    }
    
}
