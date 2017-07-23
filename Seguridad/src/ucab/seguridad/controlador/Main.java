/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ucab.seguridad.controlador;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import ucab.seguridad.vista.*;
import ucab.seguridad.controlador.*;

/**
 *
 * @author Marvian
 */
public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
	

