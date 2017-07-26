/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucab.seguridad.modelo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

/**
 * Clase que se utilizara para ver la sesion del servidor (aun no se utiliza).
 * 
 */
public class Sesion {
    /**
     * Constructor de clase vacia en el cual se verifica el estado de la sesion.
     * @throws SSLPeerUnverifiedException Excepcion que puede ocurrir.
     * @throws CertificateEncodingException Excepcion que puede ocurrir.
     * @throws FileNotFoundException Excepcion que puede ocurrir.
     * @throws IOException  Excepcion que puede ocurrir.
     */
    public Sesion() throws SSLPeerUnverifiedException, CertificateEncodingException, FileNotFoundException, IOException{
        SSLSocket ss = null;
        SSLSession sesion = ss.getSession();
    

        System.out.println("Host: " + sesion.getPeerHost());

        X509Certificate certificate = (X509Certificate)sesion.getPeerCertificates()[0];

        System.out.println("Propietario: " + certificate.getSubjectDN());

        System.out.println("Emisor: " + certificate.getIssuerDN());

        System.out.println("Numero Serie:" + certificate.getSerialNumber());

        System.out.println("to string: " +certificate.toString());

        byte[] buf = certificate.getEncoded();
        FileOutputStream os = new FileOutputStream("cliente.cer");

        os.write(buf);
        os.close();
    }
    
}
