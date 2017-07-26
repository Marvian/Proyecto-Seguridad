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
 * Clase en la que se maneja la conexion con el cliente (no se usa por los momentos) 
 * 
 */
public class Conexion {
    public SSLServerSocket serverSocket;
    public SSLSocket aClient;
    /**
     * Consrtuctor de la clase, este se encarga de inicializar la conexion
     * @param puerto Recibe el puerto mediante el cual se establece la conexion
     * @throws IOException  Posible excepcion
     */
    public Conexion(int puerto) throws IOException{
        
            System.out.println("ESPERANDO PETICION2");
            SSLServerSocketFactory serverFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) serverFactory.createServerSocket(puerto);
            serverSocket.setNeedClientAuth(false);
            aClient =  (SSLSocket) serverSocket.accept();
            System.out.println("cliente aceptado");
            start();
        
    }
    /**
     * Metodo que inicia el hilo del cliente.
     * @throws IOException Posible excepcion
     */
    public void start() throws IOException {
      System.out.println("Metodo start");
        Util.startServerWorking(serverSocket, aClient);
      
    }
    
}
