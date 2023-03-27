/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chatSystem;

/**
 *
 * @author dylan
 */
public class Controller {
    private GUI gui;
    private NetworkInterface ni;
 
    
    public void displayMsg(Message msg){
        gui.displayMsg(msg);
    }
    
    public void sendMsg(Message msg) {
        
        try{
            ni.send(msg);
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }

    public GUI getGui() {
        return gui;
    }

    public void setGui(GUI gui) {
        this.gui = gui;
    }

    public NetworkInterface getNi() {
        return ni;
    }

    public void setNi(NetworkInterface ni) {
        this.ni = ni;
    }
    
}
