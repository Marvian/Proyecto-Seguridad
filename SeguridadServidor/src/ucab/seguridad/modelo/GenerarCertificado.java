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
 * Clase en la cual se maneja la creacion y envio de certificados al cliente.
 * 
 */
public class GenerarCertificado {
    /**
     * Metodo en el cual se genera la clave para el cliente.
     * @param certificado Recibe los datos con los que el cliente desea generar su
     * certificado.
     * @return Devuelve un numero entero con el cual se compara en la clase Util (opcion 3)
     */
    public static int generarClave( Certificado certificado ){
        String comando = "-genkey "
                + "-alias claveCliente "
                + "-keyalg RSA "
                + "-keysize 2048 "
                + "-keystore cliente.jks "
                + "-storepass 123456 "
                + "-keypass 123456 "
                + "-storepass 123456 "
                + "-dname CN="+ certificado.getCommonName() + ","
                + "OU=" + certificado.getOrganizational() + ","
                + "O=" + certificado.getOrganizacion() + ","
                + "L=" + certificado.getLocalidad() + ","
                + "ST=" + certificado.getEstado() + ","
                + "C=" + certificado.getPais();
        execute(comando);
        
        return 1;
    }
    /**
     * Metodo con el que se genera la peticion (archivo .csr) para crear el certificado 
     * del cliente
     * @return Devuelve un numero entero con el cual se compara en la clase Util (opcion 3).
     */
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
    /**
     * Metodo en el cual se genera el certificado al cliente.
     * @return Devuelve un numero entero con el cual se compara en la clase Util (opcion 3)
     */
    public static int firmarPeticion(){
        String comando = "-gencert "
                + "-alias cliente "
                + "-keystore certificadoCliente.jks "
                + "-storepass 123456 "
                + "-keypass 123456 "
                + "-storepass 123456 "
                + "-rfc "
                + "-infile peticionCliente.csr "
                + "-outfile peticionCliente.crt";
        execute(comando);
        return 1;
    }
    /**
     * Metodo que ejecuta los comandos en tiempo de ejecucion
     * @param comando recibe el string que se va a ejecutar
     * @return Devuelve un booleano con el cual se compara en la clase Util (opcion 3)
     */
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
    /**
     * Metodo mediante el cual el servidor envia el certificado generado al cliente.
     * @param nombreCertificado Recibe el nombre del certificado a enviar.
     * @param oos Recibe el stream que se usa para enviar el objeto con el certificado.
     */
    public static void enviarCertificado( String nombreCertificado , ObjectOutputStream oos ){
        File archivo = null;
	File miDir = new File (".");
	Mensaje envio = new Mensaje();
	int total = 0;
	try {
            archivo = new File (miDir.getCanonicalPath()+"/"+nombreCertificado+".crt");
            @SuppressWarnings("resource")
            FileInputStream fis = new FileInputStream(archivo);
            FileInputStream fisDos = new FileInputStream(archivo);
            System.out.println("Direccion del archivo: " +miDir.getCanonicalPath()+"/"+nombreCertificado+".crt");
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
            envio.setPuertoEscucha(3);
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
