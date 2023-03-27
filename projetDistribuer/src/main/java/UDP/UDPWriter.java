/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP;

import java.io.IOException;
import java.io.Writer;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author dylan
 */
public class UDPWriter extends Writer{
    private DatagramSocket ds;
    private InetAddress toIp;
    private int toPort;

    public UDPWriter(DatagramSocket ds, InetAddress toIp, int toPort) {
        super();
        this.ds = ds;
        this.toIp = toIp;
        this.toPort = toPort;
    }

    

    @Override
    public void write(char[] charData, int offset, int len) throws IOException {
        String s = new String(charData);
        byte[] data = s.getBytes("UTF-8");
        DatagramPacket dp = new DatagramPacket(data, offset, len);
        dp.setAddress(toIp);
        dp.setPort(toPort);
        ds.send(dp);
    }

    @Override
    public void flush() throws IOException {
        ds.disconnect();
    }

    @Override
    public void close() throws IOException {
        ds.close();
    }
    
}
