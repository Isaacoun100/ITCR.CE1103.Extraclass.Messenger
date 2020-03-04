package com.Comunication;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Isaac Herrera Monge
 */
public class Receiver extends WalkieTalkie {
    
    ServerSocket server;
    Socket socket;
    DataOutputStream salida;
    BufferedReader entrada;
       
    
    public void StopServer(){
        
        try {
            socket.close();
            salida.writeUTF("Fin de la conexión");
        } catch (Exception ex) {
            System.out.println("Error, no hay servidor inicializado");
        }
        
    }
    
    @SuppressWarnings("empty-statement")
    public void StartServer(int port){
        
        
        
        try{

            System.out.println("Conexión establecida por el puerto"+port);

            server = new ServerSocket(port);
            socket = new Socket();
            socket = server.accept();

            entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String mensaje = entrada.readLine();;
            System.out.println(mensaje);

            salida = new DataOutputStream(socket.getOutputStream()); 

            }
        catch(IOException e){

            System.out.println("Conexión fallida");
            
        }
    
    }
}
