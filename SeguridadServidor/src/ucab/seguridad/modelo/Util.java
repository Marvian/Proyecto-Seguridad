/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucab.seguridad.modelo;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

/**
 *
 * @author zedin
 */
public class Util {
    static ArrayList<Usuario> usuarios = new ArrayList<>();
    
    public static void startServerWorking(SSLServerSocket serverSocket, SSLSocket socket) {
        
      
      new Thread() {
         public void run() {
            
            try {
                Mensaje mensaje;
                ObjectOutputStream oos;
                ObjectInputStream ois;
               
               ois = new ObjectInputStream( socket.getInputStream() );
               
               oos = new ObjectOutputStream( socket.getOutputStream() );
                
               while(true){
               mensaje = ( Mensaje ) ois.readObject();
                
                if(mensaje.getOpcion() == 1){
                   
                    try{
                        System.err.println("Json Vacio ERROR TAN TAN TAN");
                        usuarios = Json.Leer();
                    }
                    catch(FileNotFoundException e){
                        System.out.println("Archivo vacio.");
                    }
                    catch (EOFException ex){
                        ex.printStackTrace();
                    }   
                    
                    if (usuarios.isEmpty()){
                        mensaje.getUsuario().setDireccionIP(socket.getInetAddress().getHostAddress());
                        usuarios.add(mensaje.getUsuario());
                        System.out.println(mensaje.getUsuario().getUsuario());
                        System.err.println("Json Vacio ERROR");
                        Json.Escribir(usuarios);
                        oos.writeObject(mensaje);
                        oos.flush();
                        }
                        else {
                            int i = 0;
                            while ( i < usuarios.size()){
                                if ((usuarios.get(i).getUsuario().equals(mensaje.getUsuario().getUsuario())) || (usuarios.get(i).getContrasena().equals(mensaje.getUsuario().getContrasena())) ){
                                break;
                                }
                                else{
                                    i++;
                                }
                            }
                            if (i == usuarios.size()){
                                usuarios.clear();
                                try{
                                    System.err.println("Json Vacio ERROR lolazo");
                                    usuarios = Json.Leer();
                                
                                mensaje.getUsuario().setDireccionIP(socket.getInetAddress().toString());	
                                usuarios.add(i, mensaje.getUsuario());
                                System.err.println("Expoloto aqui :(");
                                Json.Escribir(usuarios);	
                                oos.writeObject(mensaje);
                                oos.flush();
                                
                                }catch (EOFException ex){
                                    System.err.println("Expoloto aqui :(adsasdasd");
                        ex.printStackTrace();                              
                    }
                                 catch(FileNotFoundException e){
                                    System.out.println("Archivo vacio.");
                                }            
                                
                            }
                    }
                }
               
                if(mensaje.getOpcion() == 2){
                    Usuario usuario = new Usuario();
                    usuario = BuscaUsuario.buscarUsuario(mensaje.getUsuario());
                    if (usuario != null){
                            Mensaje respuesta = new Mensaje();
                            respuesta.setUsuario(usuario);
                            oos.writeObject(respuesta);
                                    oos.flush();
                    }
                    if (usuario == null){
                        
                        Mensaje respuesta = new Mensaje();
                        respuesta.setOpcion(400);
                        oos.writeObject(respuesta);
                        oos.flush();
                    }
                    if (usuario.getDireccionIP() == "INVALIDO"){
                        BuscaUsuario.buscarUsuarioEdita(mensaje.getUsuario());
                        Mensaje respuesta = new Mensaje();
                        respuesta.setOpcion(400);
                        oos.writeObject(respuesta);
                        oos.flush();
                    }
                }
                if ( mensaje.getOpcion() == 3 ){
                    int i = 1;
                    if ( i == GenerarCertificado.generarClave( mensaje.getCertificado() ) ){
                        if ( i == GenerarCertificado.generarPeticion() ){
                            if ( i == GenerarCertificado.firmarPeticion() ){
                                String nombreCertificado = "certificadoCliente";
                                GenerarCertificado.enviarCertificado(nombreCertificado, oos);
                            }
                        }
                    }
                }
              
               }   
            } catch (Exception e) {
               e.printStackTrace();
            }
             
            
            
            
             
               
               
         }
         
      }.start();
      
}
    
}
