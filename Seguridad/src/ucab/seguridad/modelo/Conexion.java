/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucab.seguridad.modelo;

import java.net.Socket;
import javax.net.ssl.SSLSocketFactory;

/**
 *
 * @author marvian
 */
public class Conexion {
    
   
SSLSocketFactory clientFactory = (SSLSocketFactory) 
SSLSocketFactory.getDefault();
Socket client = clientFactory.createSocket(server, port);
   
}
