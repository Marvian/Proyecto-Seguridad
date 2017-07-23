/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ucab.seguridad.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ucab.seguridad.vista.*;

/**
 *
 * @author Marvian
 */
public class ControladorVentanaPrincipal implements ActionListener {
	
	public VentanaPrincipal ventanaPrincipal;
	public VentanaInscribirse ventanaInscribirse;
	public ControladorVentanaInscribirse controladorVentanaInscribirse;
	public VentanaCertificado ventanaCertificado;
	public ControladorVentanaCertificado controladorVentanaCertificado;
	
	
	public ControladorVentanaPrincipal(VentanaPrincipal ventanaPrincipal) {
		
		this.ventanaPrincipal = ventanaPrincipal;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == ventanaPrincipal.btnInscribirse){
			
			ventanaInscribirse = new VentanaInscribirse();
			ventanaInscribirse.mostrarVentana();
			controladorVentanaInscribirse = new ControladorVentanaInscribirse(ventanaInscribirse);
			ventanaInscribirse.setControlador(controladorVentanaInscribirse);
			ventanaPrincipal.dispose();
			

		}
		
		if(e.getSource() == ventanaPrincipal.btnEntrar){
			
			ventanaCertificado = new VentanaCertificado();
			ventanaCertificado.mostrarVentana();
			controladorVentanaCertificado = new ControladorVentanaCertificado(ventanaCertificado);
			ventanaCertificado.setControlador(controladorVentanaCertificado);
			ventanaPrincipal.dispose();
		
		}
	
	}
}
