/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucab.seguridad.modelo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocketFactory;

/**
 *
 * @author zedin
 */
public class Conexion {
    private ServerSocket serverSocket;
    private Socket aClient;
    public Conexion(int puerto) throws IOException{
        SSLServerSocketFactory serverFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        ServerSocket serverSocket = serverFactory.createServerSocket(puerto);
        aClient = serverSocket.accept();
        System.out.println("cliente aceptado");
        start();
    }
    public void start() throws IOException {
      Util.startServerWorking(serverSocket, aClient);
    }
    
}
