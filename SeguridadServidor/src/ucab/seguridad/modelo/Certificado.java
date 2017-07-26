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
public class Certificado implements Serializable {
    
    private String Pais;
    private String Estado;
    private String Localidad;
    private String Organizacion;
    private String Organizational;
    private String CommonName;
    private String Correo;
    
    public Certificado(String Pais, String Estado, String Localidad, 
            String Organizacion, String Organizational, String CommonName,
            String Correo){
        super();
        this.Pais = Pais;
        this.Estado = Estado;
        this.Localidad = Localidad;
        this.Organizacion = Organizacion;
        this.Organizational = Organizational;
        this.CommonName = CommonName;
        this.Correo = Correo;
    }
    
    public Certificado(){
        
        this.Pais = "";
        this.Estado = "";
        this.Localidad = "";
        this.Organizacion = "";
        this.Organizational = "";
        this.CommonName = "";
        this.Correo = "";
    }
    

    public String getPais() {
        return Pais;
    }

    public void setPais(String Pais) {
        this.Pais = Pais;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getLocalidad() {
        return Localidad;
    }

    public void setLocalidad(String Localidad) {
        this.Localidad = Localidad;
    }

    public String getOrganizacion() {
        return Organizacion;
    }

    public void setOrganizacion(String Organizacion) {
        this.Organizacion = Organizacion;
    }

    public String getOrganizational() {
        return Organizational;
    }

    public void setOrganizational(String Organizational) {
        this.Organizational = Organizational;
    }

    public String getCommonName() {
        return CommonName;
    }

    public void setCommonName(String CommonName) {
        this.CommonName = CommonName;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }
    
    
}
