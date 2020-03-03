package com.Comunication;

/**
 *
 * @author Isaac Herrera Monge
 */
public class WalkieTalkie {
    
    public int ConectionPort;
    public String ConectionIP;
    
    public void setPort(int Port){
        
        ConectionPort=Port;
        
    }
    
    public void setIP(String IP){
        
        ConectionIP=IP;
        
    }
    
    public void Server(){
        
        Receiver Receptor = new Receiver();
        Receptor.StartServer(ConectionPort);
        
        
    }
    
}
