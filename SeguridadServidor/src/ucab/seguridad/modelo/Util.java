/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucab.seguridad.modelo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author zedin
 */
public class Util {
    public static void startServerWorking(final ServerSocket serverSocket, Socket aClient) {
      
      
      new Thread() {
         public void run() {
            try {
               
               BufferedReader input = new BufferedReader(new InputStreamReader(
                     aClient.getInputStream()));
               String recibido = input.readLine();
               System.out.println("Recibido " + recibido);
               PrintWriter output = new PrintWriter(aClient.getOutputStream());
               output.println("Hello, " + recibido);
               output.flush();
               aClient.close();
            } catch (Exception e) {
               e.printStackTrace();
            }

         }
      }.start();
}
}
