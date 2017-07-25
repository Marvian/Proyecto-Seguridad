/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucab.seguridad.modelo;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author marvian
 */
public class Peticiones {
    
    public static String peticionSimple(Mensaje mensaje){
		try{
			
			
			Socket socket = new Socket("localhos", 10999);
			
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			
			oos.writeObject(mensaje);
			oos.flush();

			Mensaje recibido = (Mensaje) ois.readObject();
			
			oos.close();
			ois.close();
			
			return "ok";
		}
			catch(Exception e1){
				return "error";
			}
	}
    
    public static Usuario peticionUsuario(Mensaje mensaje){
try{
			
			
			Socket socket = new Socket("localhost", 10999);
			
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			
			oos.writeObject(mensaje);
			oos.flush();
			
			Mensaje recibido = (Mensaje) ois.readObject();
			System.out.println(recibido.getUsuario().getUsuario());
			oos.close();
			ois.close();
			return recibido.getUsuario();
		}
			catch(Exception e1){
				return null;
			}
	}
    
}
