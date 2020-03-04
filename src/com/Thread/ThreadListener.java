/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Thread;

import com.Comunication.Receiver;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author isaac
 */
public class ThreadListener extends Thread {
    
    BufferedReader entrada;
    
    Receiver Listen = new Receiver();

        String message;
   
    public ThreadListener(String message){
     
        this.message = message;
    }
        
    @Override
    public void run(){
        
      while(true){
          
          try {
              message = entrada.readLine();
              System.out.println(message);
          } catch (IOException ex) {
              
              System.out.println("No message");
              
          }
          
      }  
        
    }
    
}
