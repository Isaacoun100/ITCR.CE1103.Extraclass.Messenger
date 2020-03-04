package com.Portip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
/**
 *
 * @author isaac
 */

public class VerifyPort {

    
    String IPaddress;
    int Port;

    
    @SuppressWarnings("UseSpecificCatch")
    public String getIP() throws IOException{
        try{
            URL whatismyip = new URL("http://checkip.amazonaws.com");
            BufferedReader in = new BufferedReader(new InputStreamReader(whatismyip.openStream()));
            
            String ip = in.readLine(); 
            
            return ip;
        }
        catch(Exception e){
            
            return "127.0.0.1";
           
        }
    }
    
    public VerifyPort() {
        this.IPaddress = "127.0.0.1";
    }

    public void setIP(String IP){
        
        IPaddress = IP;
        
    }

    
    public int getPort(){
        
        
      Socket socket;

      
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
