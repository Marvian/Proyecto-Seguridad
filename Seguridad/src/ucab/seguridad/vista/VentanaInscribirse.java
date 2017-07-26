/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ucab.seguridad.vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import ucab.seguridad.controlador.*;
import ucab.seguridad.modelo.*;

/**
 *
 * @author Marvian
 */
public class VentanaInscribirse extends JFrame {
	
	public JPanel contentPanel;
	public JTextField txtNombre;
	public JTextField txtCorreo;
	public JTextField txtContrasena;
	public JTextField txtCaptcha;
	private JLabel lblNombre;
	private JLabel lblCorreo;
	private JLabel Contrasena;	
        public JLabel lblCaptcha;
	public JMenuBar menuBar;		
	public JButton btnAceptar;
	public JButton btnCancelar;
	
	
	public VentanaInscribirse() {
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);		
		
		JSeparator separator = new JSeparator();
		separator.setBackground(UIManager.getColor("Menu.background"));
		menuBar.add(separator);		    
		
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(70, 25, 75, 25);
		contentPanel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(210, 25, 150, 30);
		contentPanel.add(txtNombre);
		txtNombre.setColumns(8);
		
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setSize(50, 25);
		lblCorreo.setLocation(76, 60);
		lblCorreo.setBounds(70, 60, 50, 25);
		contentPanel.add(lblCorreo);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(210, 60, 150, 30);
		contentPanel.add(txtCorreo);
		txtCorreo.setColumns(8);
		
		JLabel lblContrasena = new JLabel("Contraseña");
		lblContrasena.setBounds(70, 95, 85, 25);
		contentPanel.add(lblContrasena);
		
		txtContrasena = new JTextField();
		txtContrasena.setBounds(210, 95, 150, 30);
		contentPanel.add(txtContrasena);
		txtContrasena.setColumns(8);
                
                
                lblCaptcha = new JLabel("");                
                lblCaptcha.setText(ucab.seguridad.modelo.Contrasena.Captcha());
		lblCaptcha.setBounds(70, 140, 75, 25);
		contentPanel.add(lblCaptcha);
		
		txtCaptcha = new JTextField();
		txtCaptcha.setBounds(210, 140, 150, 30);
		contentPanel.add(txtCaptcha);
		txtCaptcha.setColumns(10);
		
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(65, 200, 130, 25);
		contentPanel.add(btnAceptar);
		
		btnCancelar= new JButton("Cancelar");
		btnCancelar.setBounds(250, 200, 130, 25);
		contentPanel.add(btnCancelar);
		
	}
	
	public void setControlador(ControladorVentanaInscribirse c){;
	
		btnAceptar.addActionListener(c);
		btnCancelar.addActionListener(c);
		txtNombre.addActionListener(c);
		txtCorreo.addActionListener(c);
		txtCaptcha.addActionListener(c);
		txtContrasena.addActionListener(c);
                
 
	}

	public void mostrarVentana(){			
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 522, 334);
		setVisible(true);		
		
	}
}
