package com.Portip;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author isaac
 */
public class VerifyPort {

    
    String IPaddress;
    int Port;

    public VerifyPort() {
        this.IPaddress = "127.0.0.1";
    }

    public void setIP(String IP){
        
        IPaddress = IP;
        
    }

    
    public int getPort(String [] args){
        
        
      Socket socket;
      boolean founded = false;
      
      if (args.length > 0) {
         IPaddress = args[0];
      }
      
      for (int i = 1024; founded=true ; i++) {
         try {
             
            System.out.println("Looking for "+ i);
            socket = new Socket(IPaddress, i);
            
            if (socket.isConnected()){
                
                Port=i;
                
                founded=true;
                
            }
            else{
                
                System.out.println("There is a server on port " + i + " of " + IPaddress);
                
            }
            
            System.out.println("There is a server on port " + i + " of " + IPaddress);
            
         }
         catch (UnknownHostException e) {
             
            System.out.println("Exception occured"+ e);
            break;
            
         }
         catch (IOException e) {
             
         }
         
      }
        
      
      return Port;
      
      
    }
    
    
}
