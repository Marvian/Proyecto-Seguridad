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

/**
 *
 * @author Marvian
 */
public class VentanaPrincipal extends JFrame {
	
		public JPanel contentPanel;
		public JMenuBar menuBar;	
		public JTextField txtNombre;
		public JTextField txtContrasena;
		private JLabel lblNombre;
		private JLabel lblContrasena;
		public JButton btnInscribirse;
		public JButton btnEntrar;
		
		public VentanaPrincipal() {
			
			menuBar = new JMenuBar();
			setJMenuBar(menuBar);		
			
			JSeparator separator = new JSeparator();
			separator.setBackground(UIManager.getColor("Menu.background"));
			menuBar.add(separator);		    
			
			contentPanel = new JPanel();
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPanel);
			contentPanel.setLayout(null);
			
			txtNombre = new JTextField();
			txtNombre.setBounds(210, 25, 150, 30);
			contentPanel.add(txtNombre);
			txtNombre.setColumns(8);
			
			JLabel lblNombre = new JLabel("Nombre");
			lblNombre.setSize(50, 25);
			lblNombre.setLocation(76, 25);
			lblNombre.setBounds(70, 25, 75, 25);
			contentPanel.add(lblNombre);
			
			txtContrasena = new JTextField();
			txtContrasena.setBounds(210, 60, 150, 30);
			contentPanel.add(txtContrasena);
			txtContrasena.setColumns(8);
			
			JLabel lblContrasena = new JLabel("Contraseña");
			lblContrasena.setBounds(70, 60, 85, 25);
			contentPanel.add(lblContrasena);
			
			btnInscribirse = new JButton("Inscribirse");
			btnInscribirse.setBounds(235, 135, 110, 25);
			contentPanel.add(btnInscribirse);
			
			btnEntrar = new JButton("Entrar");
			btnEntrar.setBounds(75, 135, 110, 25);
			contentPanel.add(btnEntrar);
		
	}
		
		public void setControlador(ControladorVentanaPrincipal c){;
		
		btnInscribirse.addActionListener(c);
		btnEntrar.addActionListener(c);
		txtNombre.addActionListener(c);
		txtContrasena.addActionListener(c);
	 
	}
	
		public void mostrarVentana(){			
		
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 522, 334);
			setVisible(true);		
			
		}
				
}
