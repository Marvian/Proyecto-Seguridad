/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ucab.seguridad.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ucab.seguridad.controlador.*;
import ucab.seguridad.vista.*;
import ucab.seguridad.modelo.*;

/**
 *
 * @author Marvian
 */
public class ControladorVentanaInscribirse implements ActionListener   {
	
	public VentanaPrincipal ventanaPrincipal;
	public ControladorVentanaPrincipal controladorVentanaPrincipal;
	public VentanaInscribirse ventanaInscribirse;
	public VentanaCertificado ventanaCertificado;
	public ControladorVentanaCertificado controladorVentanaCertificado;
	
	
	public ControladorVentanaInscribirse(VentanaInscribirse ventanaInscribirse) {
			
			this.ventanaInscribirse = ventanaInscribirse;
			
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == ventanaInscribirse.btnAceptar){
			
			if (Contrasena.ValidarContrasena(ventanaInscribirse.txtContrasena.getText()) == true){
				ventanaCertificado = new VentanaCertificado();
				ventanaCertificado.mostrarVentana();
				controladorVentanaCertificado = new ControladorVentanaCertificado(ventanaCertificado);
				ventanaCertificado.setControlador(controladorVentanaCertificado);
				ventanaInscribirse.dispose();
			}
		}
		
		if(e.getSource() == ventanaInscribirse.btnCancelar){
			
			ventanaPrincipal = new VentanaPrincipal();
			ventanaPrincipal.mostrarVentana();
			controladorVentanaPrincipal = new ControladorVentanaPrincipal(ventanaPrincipal);
			ventanaPrincipal.setControlador(controladorVentanaPrincipal);
			ventanaInscribirse.dispose();
			
		}
		
	}

}

