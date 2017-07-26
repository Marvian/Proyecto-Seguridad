/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ucab.seguridad.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ucab.seguridad.vista.*;
import ucab.seguridad.controlador.*;
import ucab.seguridad.modelo.*;


/**
 *
 * @author Marvian
 */
public class ControladorVentanaCertificado implements ActionListener {
	
	public VentanaPrincipal ventanaPrincipal;
	public ControladorVentanaPrincipal controladorVentanaPrincipal;
	public VentanaCertificado ventanaCertificado;
	
	public ControladorVentanaCertificado  (VentanaCertificado ventanaCertificado){
		
		this.ventanaCertificado = ventanaCertificado;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == ventanaCertificado.btnEnviar){
                    
                    Certificado Certificado = new Certificado (ventanaCertificado.txtPais.getText(),
                    ventanaCertificado.txtEstado.getText(), ventanaCertificado.txtLocalidad.getText(),
                    ventanaCertificado.txtOrganizacion.getText(), ventanaCertificado.txtOrganizational.getText(),
                    ventanaCertificado.txtCommonName.getText(), ventanaCertificado.txtCorreo.getText());
                    Mensaje mensaje = new Mensaje();
                    mensaje.setOpcion(3);
                    mensaje.setCertificado(Certificado);

		}
		
		if(e.getSource() == ventanaCertificado.btnSalir){
			
			ventanaPrincipal = new VentanaPrincipal();
			ventanaPrincipal.mostrarVentana();
			controladorVentanaPrincipal = new ControladorVentanaPrincipal(ventanaPrincipal);
			ventanaPrincipal.setControlador(controladorVentanaPrincipal);
			ventanaCertificado.dispose();
			
		}
		
	}

}

