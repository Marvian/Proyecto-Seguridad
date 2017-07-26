/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucab.seguridad.modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;

/**
 *Clase Util realiza la peticion para el registro.
 */
public class Util {
    public static void startClientWorking(final SSLSocket socket, Mensaje mensaje) throws ClassNotFoundException{
      System.out.println("client start");
      
      new Thread() {
          public void run() {
            try {
                        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			
			oos.writeObject(mensaje);
                        System.out.println("holis, ya la envie");
			oos.flush();

			Mensaje recibido = (Mensaje) ois.readObject();
			
			oos.close();
			ois.close();    
            } catch (IOException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            } catch (ClassNotFoundException ex) {
                  Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
      
              }.start();
              }
              

}
