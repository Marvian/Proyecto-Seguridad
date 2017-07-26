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
 *Conexion del lado del cliente para generar el canal seguro con SSLSocket
 * 
 */
public class Conexion {
    public SSLSocket sslSocket;
    public Mensaje mensajeRec;
    public Conexion(String server, int port, Mensaje mensaje) throws IOException, ClassNotFoundException{
        SSLSocketFactory clientFactory = (SSLSocketFactory) SSLSocketFactory
            .getDefault();
        sslSocket = (SSLSocket) clientFactory.createSocket(server, port);
        this.mensajeRec = mensaje;
        start();
    }
    public void start() throws ClassNotFoundException{
        Util.startClientWorking(sslSocket, mensajeRec);
    }
}
