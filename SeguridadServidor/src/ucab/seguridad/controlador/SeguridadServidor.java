/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucab.seguridad.controlador;

import java.io.File;
import java.io.IOException;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import ucab.seguridad.modelo.Conexion;
import ucab.seguridad.modelo.Util;

/**
 * Clase principal en la que se reciben las peticiones de los usuarios y estas son
 * enviadas hacia la clase Util.
 * 
 */
public class SeguridadServidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        System.out.println("Servidor a la espera de peticiones");
        System.setProperty("javax.net.ssl.keyStore", "CosasKeytool/keystore.jks");
        System.setProperty("javax.net.ssl.keyStorePassword","123456");
        
        
        
         
        

        
        System.out.println("Antes De la conexion");
        //Process p = Runtime.getRuntime().exec("keytool -genkey -alias alias1 -keystore keystore1 -keyalg RSA"); 
        //System.setProperty("javax.net.ssl.trustStore", "CosasKeytool/AlmacenSR");
        //System.setProperty("javax.net.ssl.trustStorePassword", "almacen");
       
            //Conexion conexion = new Conexion(10999);
            try{
                SSLServerSocketFactory serverFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
                SSLServerSocket serverSocket = (SSLServerSocket) serverFactory.createServerSocket(10999);
                while (true){
                    serverSocket.setNeedClientAuth(false);
                    SSLSocket aClient = (SSLSocket) serverSocket.accept();
                    System.out.println("cliente aceptado");
                    Util.startServerWorking(serverSocket, aClient);
                }
            }
            catch(Exception e) {
                
            }
        
    }
    
}
