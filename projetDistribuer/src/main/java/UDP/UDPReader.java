/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;

/**
 *
 * @author dylan
 */
public class UDPReader extends Reader{
    private DatagramSocket ds;
    
    public UDPReader(DatagramSocket ds){
        this.ds = ds;
    }
    
    @Override
    public int read(char[] charData, int offset, int len) throws IOException{
        byte[] data = new byte[len];
        DatagramPacket dp = new DatagramPacket(data, offset, len);
        ds.receive(dp);
        String s = new String(dp.getData());
        char[] arrayChars = s.toCharArray();
        for(int i=0; i<dp.getLength(); i++){
            charData[i]=arrayChars[i];
        }
        return dp.getLength();
    }
    
    @Override
    public void close(){
        ds.close();
    }
    
}
    
    

