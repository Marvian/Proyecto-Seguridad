/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucab.seguridad.modelo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

/**
 *
 * @author zedin
 */
public class Conexion {
    public SSLServerSocket serverSocket;
    public SSLSocket aClient;
    
    public Conexion(int puerto) throws IOException{
        
            System.out.println("ESPERANDO PETICION2");
            SSLServerSocketFactory serverFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) serverFactory.createServerSocket(puerto);
            serverSocket.setNeedClientAuth(false);
            aClient =  (SSLSocket) serverSocket.accept();
            System.out.println("cliente aceptado");
            start();
        
    }
    public void start() throws IOException {
      System.out.println("Metodo start");
        Util.startServerWorking(serverSocket, aClient);
      
    }
    
}
