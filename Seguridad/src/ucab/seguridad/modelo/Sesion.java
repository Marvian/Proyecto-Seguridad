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
import javax.net.ssl.SSLSession;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;

/**
 *
 * @author marvian
 */
public class Sesion {
    
     public Sesion() 
             
        throws SSLPeerUnverifiedException, CertificateEncodingException, FileNotFoundException, IOException{
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
