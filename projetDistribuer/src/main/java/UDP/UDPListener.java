/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP;

import chatSystem.Controller;
import chatSystem.Message;
import java.io.BufferedReader;
import java.io.Reader;

/**
 *
 * @author matva
 */
public class UDPListener implements Runnable {
    Controller controller;
    BufferedReader reader;

    public UDPListener(Controller controller, BufferedReader r) {
        this.controller = controller;
        this.reader = r;
    }

    @Override
    public void run() {
       
        try{
            Message strCurrentLine;
            while (true) {
                strCurrentLine = new Message(this.reader.readLine());
                System.out.println(strCurrentLine);
                controller.displayMsg(strCurrentLine);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
