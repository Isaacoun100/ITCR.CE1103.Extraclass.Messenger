package com.Comunication;

import com.UserInterface.ChatUI;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This class stops and initialize
 * the server that's going to work
 * as a bridge between both clients
 * 
 * @version 1.0
 * @author Isaac Herrera Monge
 */

public class Receiver extends WalkieTalkie {
    
    ServerSocket server;
    Socket socket;
    DataOutputStream salida;
    BufferedReader entrada;
    String mensaje;
    ChatUI Chat;
    
    /**
     * StartServer initializes the server using the ServerSocket and
     * Socket class from java.net package
     * 
     * @param port The port in which the server is going to be hosted
     */
    
    @SuppressWarnings("empty-statement")
    public void StartServer(int port){
        
        
        
        try{

            System.out.println("Conexión establecida por el puerto"+port);

            server = new ServerSocket(port);
            socket = new Socket();
            socket = server.accept();
            
            while (!"FIN".equals(mensaje)){

            entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            mensaje = entrada.readLine();
            System.out.println(mensaje);
            Chat = new ChatUI();
            Chat.newMessage(mensaje);
            
            salida = new DataOutputStream(socket.getOutputStream());
            
            
            }

            socket.close();
            salida.writeUTF("Fin de la conexión");
            
            }
        catch(IOException e){

            System.out.println("Fin de la conexión");
            
        }
    
    }
}
