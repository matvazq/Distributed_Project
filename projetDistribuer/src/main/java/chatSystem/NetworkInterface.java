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
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Enumeration;

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
            /* broadcast address harde coded for now */
            ipAdress = InetAddress.getByAddress("moi", new byte[] {(byte)192, (byte)168, (byte)0, (byte)255});


            DatagramSocket sender1 = new DatagramSocket();
            DatagramSocket receiver1 = new DatagramSocket(10000);//listen on port 10 000
            
            BufferedReader reader = new BufferedReader(new UDPReader(receiver1));
            BufferedWriter writer = new BufferedWriter(new UDPWriter(sender1, ipAdress, 20000));//write on port 20 000
            
            
            /* Create UDPListener for incoming message using UDP */
            Thread t = new Thread(new UDPListener(this.myController,reader));
            t.start();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    

    /* Send message to the broadcast address */
    public void send(Message msg) throws Exception{
        DatagramSocket sender = new DatagramSocket();
        BufferedWriter writer = new BufferedWriter(new UDPWriter(sender,ipAdress,10000));
        writer.write(msg.toString());
        
        writer.newLine();
        writer.flush();
        System.out.println("send with broadcast");
    }
    
    /* Send to the specified address */
    public void send(Message msg, byte[] address) throws Exception{
        InetAddress ip = InetAddress.getByAddress(address);
        DatagramSocket sender = new DatagramSocket();
        BufferedWriter writer = new BufferedWriter(new UDPWriter(sender,ip,10000));
        writer.write(msg.toString());
        
        writer.newLine();
        writer.flush();
    }
    
    public void broadcast(){
                
    }
    
    public int socketExist(InetAddress ipAdress){
        for(Socket s : sockets){
            if(s.getInetAddress() == ipAdress){
                return sockets.indexOf(s);
            }
        }
        return -1;
    }  
    
    /* get the ip of  the computer */
    public String getIp(){
        try{
            //get an array of all ip address
            String hostName = InetAddress.getLocalHost().getHostName();
            //System.out.println("hostname: " + hostName);
            InetAddress[] ip = InetAddress.getAllByName(hostName);
            for(InetAddress i: ip){
                System.out.println(i.getHostAddress());
            }
            return "";
        }catch(Exception e){
            e.printStackTrace();
        }
        return "";
    }
    
    /* WIP */
    public InetAddress getBroadcastAddress(InetAddress ipAdress){
        try{
            /* get all network interfaces */
            Enumeration<java.net.NetworkInterface> interfaces = java.net.NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) 
            {
                java.net.NetworkInterface networkInterface = interfaces.nextElement();
                if (networkInterface.isLoopback())
                    continue;    // check if it's the loopback address
                for (InterfaceAddress interfaceAddress : networkInterface.getInterfaceAddresses()) 
                {
                    InetAddress broadcast = interfaceAddress.getBroadcast();
                    if (broadcast == null)
                        continue;
                    System.out.println("broadcast : " + broadcast);
                    if(false){//check if it's the broadcast address of the local address
                        //subnet mask
                        
                        
                        return broadcast;
                    }
                }
            }
            return null;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    
    @Override
    public void run() {
        //listen to incoming tcp connection
        
        
    }
    
}
