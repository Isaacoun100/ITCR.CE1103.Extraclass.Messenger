package com.Comunication;

/**
 * WalkieTalkie is the father of Receiver
 * and Transmitter, stores the values
 * of both IP and Ports to connect both
 * client and server
 * 
 * @author Isaac Herrera Monge
 */
public class WalkieTalkie {
    
    public int ConectionPort;
    public String ConectionIP;
    
    /**
     * setPort initializes the variable port
     * for further use in the server and client
     * 
     * @param Port is the port in which the 
     * server is going to be allocated
     */
    
    public void setPort(int Port){
        
        ConectionPort=Port;
        
    }
    
    /**
     * setIP initializes the ip string
     * for further use in the client
     * 
     * @param IP is the ipv4 direction that the
     * client is going to use in other to communicate
     */
    
    public void setIP(String IP){
        
        ConectionIP=IP;
        
    }
    
    /**
     * 
     * Server calls a method allocated in his son class
     * Receiver to initialize the server with the given
     * parameters from the father
     * 
     */
    
    public void Server(){
        
        Receiver Receptor = new Receiver();
        Receptor.StartServer(ConectionPort);
        
        
    }
    
    /**
     * 
     * Client calls a method allocated in his son class
     * Transmitter to initialize the client to server
     * communication
     * 
     */
    
     public void Client(){
        
        Transmitter Sender = new Transmitter();
        Sender.start(ConectionIP,ConectionPort);
        
        
    }
    
}
