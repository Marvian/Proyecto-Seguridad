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
public class VentanaCertificado extends JFrame {
	
	public JPanel contentPanel;
	public JMenuBar menuBar;	
	public JTextField txtPais;
	public JTextField txtEstado;
	public JTextField txtLocalidad;
	public JTextField txtOrganizacion;
	public JTextField txtOrganizational;
	public JTextField txtCommonName;
	public JTextField txtCorreo;	
	private JLabel lblPais;
	private JLabel lblEstado;
	private JLabel lblLocalidad;
	private JLabel lblOrganizacion;
	private JLabel lblOrganizational;
	private JLabel lblCommonName;
	private JLabel lblCorreo;	
	public JButton btnEnviar;
	public JButton btnSalir;
	
	public VentanaCertificado() {
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);		
		
		JSeparator separator = new JSeparator();
		separator.setBackground(UIManager.getColor("Menu.background"));
		menuBar.add(separator);		    
		
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel lblPais = new JLabel("Pais");
		lblPais.setBounds(30, 25, 50, 25);
		contentPanel.add(lblPais);
		
		txtPais = new JTextField();
		txtPais.setBounds(80, 25, 100, 30);
		contentPanel.add(txtPais);
		txtPais.setColumns(8);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(230, 25, 50, 25);
		contentPanel.add(lblEstado);
		
		txtEstado = new JTextField();
		txtEstado.setBounds(290, 25, 100, 30);
		contentPanel.add(txtEstado);
		txtEstado.setColumns(8);
		
		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setBounds(30, 60, 50, 25);
		contentPanel.add(lblLocalidad);
		
		txtLocalidad = new JTextField();
		txtLocalidad.setBounds(80, 60, 100, 30);
		contentPanel.add(txtLocalidad);
		txtLocalidad.setColumns(8);
		
		
		JLabel lblOrganizacion = new JLabel("Organizacion");
		lblOrganizacion.setBounds(230, 60, 65, 25);
		contentPanel.add(lblOrganizacion);
		
		txtOrganizacion = new JTextField();
		txtOrganizacion.setBounds(290, 60, 100, 30);
		contentPanel.add(txtOrganizacion);
		txtOrganizacion.setColumns(8);
		
		JLabel lblOrganizational = new JLabel("Organizational");
		lblOrganizational.setBounds(30, 95, 66, 25);
		contentPanel.add(lblOrganizational);
		
		txtOrganizational = new JTextField();
		txtOrganizational.setBounds(80, 95, 100, 30);
		contentPanel.add(txtOrganizational);
		txtOrganizational.setColumns(8);
		
		JLabel lblCommonName = new JLabel("Nombre");
		lblCommonName.setBounds(230, 95, 50, 30);
		contentPanel.add(lblCommonName);
		
		txtCommonName = new JTextField();
		txtCommonName.setBounds(290, 95, 100, 30);
		contentPanel.add(txtCommonName);
		txtCommonName.setColumns(8);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setBounds(30, 130, 50, 25);
		contentPanel.add(lblCorreo);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(80, 130, 310, 30);
		contentPanel.add(txtCorreo);
		txtCorreo.setColumns(8);
		
		btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(65, 185, 130, 25);
		contentPanel.add(btnEnviar);
		
		btnSalir= new JButton("Salir");
		btnSalir.setBounds(250, 185, 130, 25);
		contentPanel.add(btnSalir);	
		
	}
	
	public void setControlador(ControladorVentanaCertificado c){;
	
            btnEnviar.addActionListener(c);
            btnSalir.addActionListener(c);
            txtPais.addActionListener(c);
            txtEstado.addActionListener(c);
            txtLocalidad.addActionListener(c);
            txtOrganizacion.addActionListener(c);
            txtOrganizational.addActionListener(c);
            txtCommonName.addActionListener(c);
            txtCorreo.addActionListener(c);
 
}

	public void mostrarVentana(){			
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 522, 334);
		setVisible(true);		
		
	}

}
