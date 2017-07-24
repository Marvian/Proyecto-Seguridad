/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ucab.seguridad.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import ucab.seguridad.modelo.Json;
import ucab.seguridad.modelo.Usuario;

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
                        // Esto es un ejemplo para ver si el json se escribe.
                        Usuario user = new Usuario();
                        user.setUsuario(ventanaPrincipal.txtNombre.getText());
                        user.setCantidadIngresos(1);
                        user.setContrasena(ventanaPrincipal.txtContrasena.getText());
                        user.setDireccionIP("192.168.1.1");
                        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
                        listaUsuarios.add(user);
                        Json.Escribir(listaUsuarios);
                        //Esto es un ejemplo de su lectura.
                        listaUsuarios.clear();
                        try {
                            listaUsuarios = Json.Leer();
                        } catch (IOException ex) {
                            Logger.getLogger(ControladorVentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        System.out.println("Primer Dato:" + listaUsuarios.get(0).getUsuario());
			ventanaCertificado.setControlador(controladorVentanaCertificado);
			ventanaPrincipal.dispose();
		
		}
	
	}
}
