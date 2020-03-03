package com.Comunication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 *
 * @author Isaac Herrera Monge
 */
public class Transmitter extends WalkieTalkie {
    
    Socket cliente;
    int puerto;
    String ip;
    BufferedReader entrada;
    BufferedReader teclado;
    PrintStream salida;

    public Transmitter() {
        this.ip = ConectionIP;
        this.puerto = ConectionPort;
    }
    
    public void iniciar()
    {
        
        try
        {
            
            
            
            cliente = new Socket(ip,puerto);
            entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            teclado = new BufferedReader(new InputStreamReader(System.in));
            
            System.out.println("Conexión exitosa");
            
            String tec = teclado.readLine();
            salida = new PrintStream(cliente.getOutputStream());
            salida.println(tec);
            String msg = entrada.readLine();
            System.out.print(msg);
            
            
            entrada.close();
            salida.close();
            teclado.close();
            cliente.close();
            
        }
        catch(IOException e)
        {
        
            System.out.println("Conexión fallida");
        
        }

        
        
        
    }
   
    
}
