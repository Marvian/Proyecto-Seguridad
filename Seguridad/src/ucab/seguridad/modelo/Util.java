/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucab.seguridad.modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author zedin
 */
public class Util {
    public static void startClientWorking(final Socket client){
      System.out.println("client start");
      
            try {
               PrintWriter output = new PrintWriter(client.getOutputStream());
               output.println("Federico");
               output.flush();
               System.out.println("Federico sent");
               BufferedReader input = new BufferedReader(new InputStreamReader(
                     client.getInputStream()));
               String received = input.readLine();
               System.out.println("Received : " + received);
               client.close();
            } catch (IOException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }
         }

}
