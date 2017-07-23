/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ucab.seguridad.modelo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Marvian
 */
public class Contrasena {
	
	
	public static boolean ValidarContrasena (String contrasena){
		
		boolean validado;
		validado = false;
		
		Pattern minusculas = Pattern.compile("([A-Z]{8})");
		Pattern especiales = Pattern.compile("[$@$!%*?&]");
		
		Matcher longitud = minusculas.matcher(contrasena);
		
		 if (longitud.matches()==true){
							  
			Matcher especial = especiales.matcher(contrasena); 
			if (especial.matches()==true) validado = true;
			
		 }
		 
		return validado;	
	}

}
