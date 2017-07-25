/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucab.seguridad.controlador;

import java.io.IOException;
import ucab.seguridad.modelo.Conexion;

/**
 *
 * @author zedin
 */
public class SeguridadServidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        System.out.println("Servidor a la espera de peticiones");
        System.setProperty("javax.net.ssl.keyStore", "CosasKeytool/AlmacenSRTust");
        System.setProperty("javax.net.ssl.keyStorePassword","almacen");
        System.setProperty("javax.net.ssl.trustStore", "CosasKeytool/AlmacenSR");
        //System.setProperty("javax.net.ssl.trustStorePassword", "almacen");
        Conexion conexion = new Conexion(10999);
        
    }
    
}
