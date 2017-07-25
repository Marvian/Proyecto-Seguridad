/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucab.seguridad.modelo;

import java.io.IOException;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/**
 *
 * @author marvian
 */
public class Conexion {
    private SSLSocket sslSocket;
    public Conexion(String server, int port) throws IOException{
        SSLSocketFactory clientFactory = (SSLSocketFactory) SSLSocketFactory
            .getDefault();
        sslSocket = (SSLSocket) clientFactory.createSocket(server, port);
        start();
    }
    public void start(){
        Util.startClientWorking(sslSocket);
    }
}
