/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ucab.seguridad.controlador;

import java.io.IOException;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import ucab.seguridad.vista.*;
import ucab.seguridad.controlador.*;
import ucab.seguridad.modelo.Conexion;

/**
 *
 * @author Marvian
 */
public class Main {
	
    
    
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
                
               //System.setProperty("javax.net.ssl.keyStore", "CosasKeytool/AlmacenCL");
               //System.setProperty("javax.net.ssl.keyStorePassword","almacen");
               System.setProperty("javax.net.ssl.trustStore", "CosasKeytool/cacerts.jks");
               System.setProperty("javax.net.ssl.trustStorePassword", "123456");
               
               

		try {
			   UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			//   UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			  }
			  catch (UnsupportedLookAndFeelException e) {
			  }
			  catch (ClassNotFoundException e) {
			  }
			  catch (InstantiationException e) {
			  }
			  catch (IllegalAccessException e) {
			  }
		VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
		ventanaPrincipal.mostrarVentana();
		ControladorVentanaPrincipal controladorventanaPrincipal = new ControladorVentanaPrincipal(ventanaPrincipal);
		ventanaPrincipal.setControlador(controladorventanaPrincipal);
		
	}
        
}
	

