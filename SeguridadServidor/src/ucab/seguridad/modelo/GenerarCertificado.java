/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucab.seguridad.modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.security.tools.keytool.Main;

/**
 *
 * @author zedin
 */
public class GenerarCertificado {
    public static int generarClave( Certificado certificado ){
        String comando = "-genkey "
                + "-alias claveCliente "
                + "-keyalg RSA "
                + "-keysize 2048 "
                + "-keystore cliente.jks "
                + "-storepass 123456 "
                + "-keypass 123456 "
                + "-dname CN="+ certificado.getCommonName() + ","
                + "OU=" + certificado.getOrganizational() + ","
                + "O=" + certificado.getOrganizacion() + ","
                + "L=" + certificado.getLocalidad() + ","
                + "ST=" + certificado.getEstado() + ","
                + "C=" + certificado.getPais();
        execute(comando);
        
        return 1;
    }
    public static int generarPeticion (){
        String comando = "-certreq "
                + "-alias claveCliente "
                + "-file peticionCliente.csr "
                + "-keystore cliente.jks "
                + "-storepass 123456 "
                + "-keypass 123456";
        execute(comando);
        return 1;
    }
    public static int firmarPeticion(){
        String comando = "-gencert "
                + "-alias cliente "
                + "-keystore certificadoCliente.jks "
                + "-storepass 123456 "
                + "-keypass 123456 "
                + "-rfc "
                + "-infile peticionCliente.csr "
                + "-outfile peticionCliente.crt";
        execute(comando);
        return 1;
    }
    public static boolean execute(String comando){
        try {
            System.out.println(comando);
            String[] c = comando.trim().split("\\s+");
            for (int i=0; i<c.length; i++){
                System.out.println(c[i]);
            }
            Main.main(comando.trim().split("\\s+"));
            
        } catch (Exception ex) {
            Logger.getLogger(GenerarCertificado.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    public static void enviarCertificado( String nombreCertificado , ObjectOutputStream oos ){
        File archivo = null;
	File miDir = new File (".");
	Mensaje envio = new Mensaje();
	int total = 0;
	try {
            archivo = new File (miDir.getCanonicalPath()+"/"+nombreCertificado+".jks");
            @SuppressWarnings("resource")
            FileInputStream fis = new FileInputStream(archivo);
            FileInputStream fisDos = new FileInputStream(archivo);
            System.out.println("Direccion del archivo: " +miDir.getCanonicalPath()+"/"+nombreCertificado+".jks");
            System.out.println("Lo que puedo cargar" +envio.getContenidoFichero());
            int contador = 0;
            while (!envio.isBytesFinales()){
		int bytesLeidos = fis.read();
		System.out.println(bytesLeidos);
		if (bytesLeidos == -1)
                    envio.setBytesFinales(true);
                contador++;		
            }
            envio.setBytesFinales(false);
            int bytesEntrada[] = new int[contador];
            contador = 0;
            while (!envio.isBytesFinales()){
		int bytesLeidos = fisDos.read();
		if (bytesLeidos != -1){
                    bytesEntrada[contador] = bytesLeidos;
                    total = contador;
		}
		else{
                    envio.setBytesFinales(true);
		}
		contador++;
            }
            System.out.println("Valor total: " +total);
            envio.setOpcion(total);
            envio.setContenidoFichero(bytesEntrada);
            System.out.println("Estoy enviando este array: " +envio.getContenidoFichero());
            oos.writeObject(envio);
            fis.close();
            fisDos.close();
            oos.close();
        } 
        catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
    }
    
}
