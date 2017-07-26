/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ucab.seguridad.modelo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Marvian
 */
public class Contrasena {
	
	
	public static boolean ValidarContrasena (String contrasena){
		
		boolean validado = false;
                char clave;
                byte  contLetraMay = 0, contEspeciales=0;
		
		
		for (byte i = 0; i < contrasena.length(); i++) {

                    clave = contrasena.charAt(i);
                    String passValue = String.valueOf(clave);

                    if (passValue.matches("[A-Z]")) {

                        contLetraMay++;

                    } 

                    else if (passValue.matches("[@#$%&.,]")) {

                        contEspeciales++;

                    }

                }
                       
                if(contLetraMay >= 1 & contEspeciales >= 1 & contrasena.length() >= 8 ) validado =true;                  
                       
                else JOptionPane.showMessageDialog(null,"La contraseña debe tener una mayuscula, un caracter especial y 8 caracteres");

		System.out.println("Contraseña validada = " + validado);
                               
                
		return validado;	
	

        }
        
        public static String calcularhash (String contrasena) throws NoSuchAlgorithmException {
            
            String hash = null;
            
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            //Carga los valores al MessageDigest
            md5.update(contrasena.getBytes());           
            // La contraseña ya cifrada y lo pasa hexadecimal 
            StringBuilder sb = new StringBuilder();
            for (byte b : md5.digest())
                  sb.append(Integer.toHexString(0x100 + (b & 0xff)).substring(1));
            
            hash = sb.toString();
            System.out.println(hash);

          return hash;
        }
        
        public static String Captcha(){ 
            
            String captcha = null;
            
            char[] numeros = {'0','1','2','3','4','5','6','7','8','9'};
            char[] letras = {'a','b','c','d','e','f','g','h','i','j','k','l','m',
                'n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C',
                'D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S',
                'T','U','V','W','X','Y','Z'};
            char[] caracteres ={'0','1','2','3','4','5','6','7','8','9',
           'a','b','c','d','e','f','g','h','i','j','k','l','m',
                'n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C',
                'D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S',
                'T','U','V','W','X','Y','Z'};
            
            char[] conjunto = new char[8];
            
            for(int i=0;i<8;i++){  
            
                if(i % 2 == 0 ){
                    int seleccionado = (int)(Math.random()*10);
                    conjunto[i] = numeros[seleccionado];
            }
                else{
                    int seleccionado = (int)(Math.random()*52);
                    conjunto[i] = letras[seleccionado];
                }}
                    
            
            captcha = new String(conjunto);
            
        return captcha;
        }
        
}

