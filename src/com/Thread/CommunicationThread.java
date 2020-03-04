package com.Thread;

import com.Comunication.Receiver;

/**
 *
 * @author Isaac Herrera Monge
 */
public class CommunicationThread extends Thread {
    
        int port;
   
    public CommunicationThread(int port){
     
        this.port = port;
        
    }
    
    @Override
    public void run(){
        
        Receiver NewServer = new Receiver();
        NewServer.StartServer(port);
        
        
    }
    
}
