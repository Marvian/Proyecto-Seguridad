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

/**
 *
 * @author zedin
 */
public class Conexion {
    private ServerSocket serverSocket;
    private Socket aClient;
    private SSLServerSocket ss;
    public Conexion(int puerto) throws IOException{
        SSLServerSocketFactory serverFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket serverSocket = (SSLServerSocket) serverFactory.createServerSocket(puerto);
        serverSocket.setNeedClientAuth(false);
        aClient = serverSocket.accept();
        System.out.println("cliente aceptado");
        start();
    }
    public void start() throws IOException {
      System.out.println("Metodo start");
        Util.startServerWorking(serverSocket, aClient);
      
    }
    
}
