package com.Comunication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Transmitter is the son of WalkieTalkie
 * stores the value of both IP and Ports 
 * to connect both client and server
 * 
 * @author Isaac Herrera Monge
 */
public class Transmitter extends WalkieTalkie {
    
    Socket cliente;
    BufferedReader entrada;
    BufferedReader teclado;
    PrintStream salida;
    String msg;
    
    /**
     * start initializes the client so that the server
     * and client can communicate freely
     * 
     * @param ip is the IP address that the serves has, 127.0.0.1 if local
     * @param puerto is the port in which the messages are going through
     */
    
    public void start(String ip, int puerto){
        
        try
        {
            
            cliente = new Socket(ip,puerto);
            entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            teclado = new BufferedReader(new InputStreamReader(System.in));
            
            System.out.println("Conexión exitosa");
            
            String tec = teclado.readLine();
            salida = new PrintStream(cliente.getOutputStream());
            salida.println(tec);
            
            while(!"FIN".equals(msg)){
            
                msg = entrada.readLine();
                System.out.print(msg);
                
                
            }
            
        }
        catch(IOException e)
        {
        
            System.out.println("Conexión fallida");
        
        }

        
        
        
    }
   
    
}
