package com.Portip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
/**
 *
 * VerifyPort checks for the available ports
 * to start a server
 * 
 * @author Isaac Herrera Monge
 */

public class VerifyPort {

    
    String IPaddress;
    int Port;

    /**
     * 
     * @return the IP Address of the host if 
     * there's no connection, throws the local host
     * @throws IOException if network error
     */
    
    @SuppressWarnings("UseSpecificCatch")
    public String getIP() throws IOException{
        
        String localhost= "127.0.0.1";
        
        try{
            URL whatismyip = new URL("http://checkip.amazonaws.com");
            BufferedReader in = new BufferedReader(new InputStreamReader(whatismyip.openStream()));
            
            String ip = in.readLine(); 
            
            return ip;
        }
        catch(Exception e){
            
            return localhost;
           
        }
    }
    
    /**
     * 
     * VerifyPort initializes the IPaddress variable
     * 
     */
    
    public VerifyPort() {
        this.IPaddress = "127.0.0.1";
    }
    
    /**
     * Assigns the IP String to the already initialized
     * IPaddress that has a default method of local host
     * 
     * @param IP  refers to the IP that is going to connect to
     */

    public void setIP(String IP){
        
        IPaddress = IP;
        
    }

    /**
     * This method searches for the available ports, and
     * gives the lower port available, if the port is busy then
     * it will search for the second nearest
     * 
     * @return i that contains the port integer that is available
     */
    
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
