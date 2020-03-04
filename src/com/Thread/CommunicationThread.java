package com.Thread;

import com.Comunication.Receiver;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * CommunicationThread is a Thread that runs 
 * the server while the program is working 
 * 
 * @author Isaac Herrera Monge
 */
public class CommunicationThread extends Thread {
    
        int port;
        
        ServerSocket server;
        Socket socket;
   
        /**
         * CommunicationThread runs the client in the background
         * so the program can go on without waiting a response from
         * the server
         * 
         * @param port is the network port that it's going to connect to
         */
        
    public CommunicationThread(int port){
     
        this.port = port;
        
    }
    
    /**
     * run is a method inherited from Thread
     * that runs whatever he has inside 
     * on the background
     */
    
    @Override
    public void run(){
        
            Receiver NewServer = new Receiver();
            NewServer.StartServer(port);
        
    }
    
}
