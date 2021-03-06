/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucab.seguridad.modelo;

import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.swing.JOptionPane;

/**
 *
 * Clase Peticiones contienen los metodos para que el cliente pida al servidor 
 * lo que necesita.
 */
public class Peticiones {
    
    /**
     * Metodo utilizado para realizar el registro del cliente y sea guardado en
     * un documento con sus respectivos atributos
     * @param mensaje
     * @return String
     */
    public static String peticionSimple(Mensaje mensaje){
		try{
			
			                 System.out.println("HOLIS, ANTES DE HACER LA PETICION");
			//SSLSocket socket = new SSLSocket("localhost", 10999) {};
			Conexion conex = new Conexion( "186.90.153.124", 10999, mensaje );
			/*ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			
			oos.writeObject(mensaje);
                        System.out.println("holis, ya la envie");
			oos.flush();

			Mensaje recibido = (Mensaje) ois.readObject();
			
			oos.close();
			ois.close();*/
			
			return "ok";
		}
			catch(Exception e1){
				return "error";
			}
	}
    
    /**
     * Metodo para autenticar el usuario
     * @param mensaje
     * @return recibido
     */
    public static Mensaje peticionUsuario(Mensaje mensaje){
try{
			                 System.out.println("HOLIS, ANTES DE HACER LA PETICION");
			//SSLSocket socket = new SSLSocket("localhost", 10999) {};
			//Conexion conex = new Conexion( "localhost", 10999, mensaje );
			
			/*Socket socket = new Socket("localhost", 10999);
			
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			
			oos.writeObject(mensaje);
			oos.flush();
			
			Mensaje recibido = (Mensaje) ois.readObject();
			System.out.println(recibido.getUsuario().getUsuario());
			oos.close();
			ois.close();*/
                        SSLSocketFactory clientFactory = (SSLSocketFactory) SSLSocketFactory
                        .getDefault();
                        SSLSocket sslSocket = (SSLSocket) clientFactory.createSocket("186.90.153.124", 10999);
                        ObjectOutputStream oos = new ObjectOutputStream(sslSocket.getOutputStream());

			ObjectInputStream ois = new ObjectInputStream(sslSocket.getInputStream());
			
			oos.writeObject(mensaje);
                        System.out.println("holis, ya la envie");
			oos.flush();
                                
			Mensaje recibido = (Mensaje) ois.readObject();
			
			
			oos.close();
			ois.close();    
                        System.out.println("del servidor" + recibido.getUsuario().getUsuario());

			return recibido;
		}
			catch(Exception e1){
				return null;
			}
	}
    
    /**
     * Metodo para pedir al servidor el certificado
     * @param mensaje
     * @return recibido
     */
    
    public static Mensaje peticionCertificado ( Mensaje mensaje ){
        try{
            SSLSocketFactory clientFactory = (SSLSocketFactory) SSLSocketFactory
                            .getDefault();
            SSLSocket sslSocket = (SSLSocket) clientFactory.createSocket("186.90.153.124", 10999);
            ObjectOutputStream oos = new ObjectOutputStream(sslSocket.getOutputStream());

            ObjectInputStream ois = new ObjectInputStream(sslSocket.getInputStream());

            oos.writeObject(mensaje);
            System.out.println("holis, ya la envie");
            oos.flush();
            
            Mensaje recibido = (Mensaje) ois.readObject();
            FileOutputStream fos = new FileOutputStream("certificadoCliente.crt");
            long hola = recibido.getOpcion();
			for (int i = 0; i < recibido.getContenidoFichero().length-1; i++){ 
				fos.write(recibido.getContenidoFichero()[i]);
				
				System.out.println("Van " + i + " de " + hola);
			}
			fos.close();
			oos.close();
			ois.close();  
            

            return recibido;
        }
        catch(Exception e1){
            return null;
        }
    }
    
}
