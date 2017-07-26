/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucab.seguridad.modelo;

import java.io.Serializable;

/**
 *
 * @author marvian
 */
public class Usuario implements Serializable {
    
    private String usuario;
	private String contrasena;
	private String direccionIP;
	private long cantidadIngresos;
	
	public Usuario(String usuario, String contrasena, String direccionIP) {
		super();
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.direccionIP = direccionIP;
	}
	
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
    

