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
      
      if (args.length > 0) {
         IPaddress = args[0];
      }
      
      int i;
      
      for (i=1024; i<64000 ; i++) {
         try {
             
            socket = new Socket(IPaddress, i);
            
         }
         catch (UnknownHostException e) {
             
            System.out.println("Exception occured"+ e);
            break;
            
         }
         catch (IOException e) {
             
             return i;
             
         }
         
      }  
      
      return i;
      
    }
    
    
}
