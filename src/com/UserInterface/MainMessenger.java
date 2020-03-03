package com.UserInterface;

import com.Portip.VerifyPort;

/**
 *
 * @author Isaac Herrera Monge
 */
public class MainMessenger {
    
    public static void main(String[] args) {
        VerifyPort conectPort = new VerifyPort();
        conectPort.setIP("127.0.0.1");
    
        System.out.println(conectPort.getPort(args));
    
        
    }
    
    
}
