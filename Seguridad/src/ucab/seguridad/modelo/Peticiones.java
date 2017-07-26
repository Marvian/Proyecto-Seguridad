/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucab.seguridad.modelo;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.swing.JOptionPane;

/**
 *
 * @author marvian
 */
public class Peticiones {
    
    public static String peticionSimple(Mensaje mensaje){
		try{
			
			                 System.out.println("HOLIS, ANTES DE HACER LA PETICION");
			//SSLSocket socket = new SSLSocket("localhost", 10999) {};
			Conexion conex = new Conexion( "localhost", 10999, mensaje );
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
    
    public static Usuario peticionUsuario(Mensaje mensaje){
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
                        SSLSocket sslSocket = (SSLSocket) clientFactory.createSocket("localhost", 10999);
                        ObjectOutputStream oos = new ObjectOutputStream(sslSocket.getOutputStream());

			ObjectInputStream ois = new ObjectInputStream(sslSocket.getInputStream());
			
			oos.writeObject(mensaje);
                        System.out.println("holis, ya la envie");
			oos.flush();

			Mensaje recibido = (Mensaje) ois.readObject();
			int i = 3;
			if (recibido.getOpcion() == 400){
                            JOptionPane.showMessageDialog(null,"Contraseña Erronea, le quedan"+ i-- + "intentos");
                            
                        }
			oos.close();
			ois.close();    
			return mensaje.getUsuario();
		}
			catch(Exception e1){
				return null;
			}
	}
    
}
