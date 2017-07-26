/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucab.seguridad.modelo;

import java.io.Serializable;

/**
 * Objeto uilizado para identificar a cada usuario.
 * Es usado en la clase Mensaje.
 * 
 */
public class Usuario implements Serializable {
    
    private String usuario;
	private String contrasena;
	private String direccionIP;
	private long cantidadIngresos;
	/**
         * Constructor de clase con atributos a llenar.
         * @param usuario Recibe el nombre del usuario que se desea iniciar.
         * @param contrasena Recibe la contraseña que tendra el usuario.
         * @param direccionIP Recibe la direccion IP del usuario.
         */
	public Usuario(String usuario, String contrasena, String direccionIP) {
		super();
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.direccionIP = direccionIP;
	}
	/**
         * Constructor vacion que inicia los valoes del usuario por defecto.
         */
	public Usuario(){
		this.usuario = "";
		this.contrasena = "";
		this.direccionIP = "";
		this.cantidadIngresos = 0;
	}
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getDireccionIP() {
		return direccionIP;
	}

	public void setDireccionIP(String direccionIP) {
		this.direccionIP = direccionIP;
	}

	public long getCantidadIngresos() {
		return cantidadIngresos;
	}

	public void setCantidadIngresos(long cantidadIngresos) {
		this.cantidadIngresos = cantidadIngresos;
	}


}
    

