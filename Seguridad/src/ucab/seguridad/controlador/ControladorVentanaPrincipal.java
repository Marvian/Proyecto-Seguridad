/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ucab.seguridad.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ucab.seguridad.modelo.Usuario;

import ucab.seguridad.vista.*;
import ucab.seguridad.modelo.*;

/**
 *Constructor que recibe la vista en la cual se va a devolver
 * @param VentanaPrincial
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
	
        /**
	 * Se manejan todas las acciones que puede realizar el cliente en esta vista.
	 */        
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
                    String captcha = ventanaPrincipal.lblCaptcha.getText();
                    String captchaUsuario = ventanaPrincipal.txtCaptcha.getText();
                    if(captcha.equals(captchaUsuario)){
                    
                        String contrasena = null;
                        try {
                             contrasena = Contrasena.calcularhash(ventanaPrincipal.txtContrasena.getText());
                            } catch (NoSuchAlgorithmException ex) {
                             Logger.getLogger(ControladorVentanaInscribirse.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        
                            Usuario usuario = new Usuario(ventanaPrincipal.txtNombre.getText() , contrasena, null);
                            Mensaje mensaje = new Mensaje();
                            mensaje.setUsuario(usuario);
                            mensaje.setOpcion(2);
                            Mensaje mensajeC = new Mensaje();
                            Usuario usuarioC = new Usuario();
                            try {
                                System.out.println("ANTES DE LA PETICION LOGIN");


                                mensajeC = Peticiones.peticionUsuario(mensaje);
                                usuarioC =  mensajeC.getUsuario();
                                System.out.println(mensajeC.getUsuario());
                                String contrasenaP = Contrasena.calcularhash(ventanaPrincipal.txtContrasena.getText());

                                if(contrasenaP.equals(usuarioC.getContrasena()) && (usuarioC.getUsuario().equals(ventanaPrincipal.txtNombre.getText()))){

                                    ventanaCertificado = new VentanaCertificado();
                                    ventanaCertificado.mostrarVentana();
                                    controladorVentanaCertificado = new ControladorVentanaCertificado(ventanaCertificado);
                                    ventanaCertificado.setControlador(controladorVentanaCertificado);
                                    ventanaPrincipal.dispose();

                                }
                                else if (mensajeC.getOpcion() == 400){System.out.println("del servidor" + mensajeC.getUsuario().getUsuario());
                                    JOptionPane.showMessageDialog(null,"Contraseña invalida");
                                }
                            
                            
                            } 
                            
                            catch (NoSuchAlgorithmException ex) {
                                Logger.getLogger(ControladorVentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                        
                        catch ( Exception exq){
                            JOptionPane.showMessageDialog(null,"No existe el ese usuario!");
                        }
                            
                    }
			
                        
                    }
                    else JOptionPane.showMessageDialog(null,"Captcha equivocado!");
                    
                    
                    
		
		}
        
	
	
}
