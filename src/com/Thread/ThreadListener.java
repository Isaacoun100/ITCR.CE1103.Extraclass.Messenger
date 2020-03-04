/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Thread;

import com.Comunication.Transmitter;
/**
 *ThreadListener waits for a response from
 * either the server or the client to give an
 * output(message)
 * 
 * @author Isaac Herrera Monge
 */
public class ThreadListener extends Thread {
Transmitter SendClient;   

int Port;

    /**
     * ThreadListener() initializes the variables
     * to get them ready once the Thread is running
     * and reduce errors
     * 
     * @param Port is the port in which the connection is going to be held
     * @param IP is the IP in which the connection is going to be held
     */

    public ThreadListener(int Port, String IP) {
        this.Port = Port;
        this.IP = IP;
    }
String IP;        

    /**
     * run is a method inherited from Thread
     * that runs whatever he has inside 
     * on the background
     */
@Override
    public void run(){
        
        SendClient = new Transmitter();
        SendClient.start(IP, Port);
    }
        
}
