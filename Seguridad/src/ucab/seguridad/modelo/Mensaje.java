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
public class Mensaje implements Serializable {
    
    private Usuario usuario;
    private Certificado certificado;
    private int ipServidor;
    private int puertoEscucha;
    
    public Mensaje (Usuario usuario, Certificado certificado, int ipServidor, int puertoEscucha ){
    
        super();
        this.usuario = usuario;
        this.certificado = certificado;
        this.ipServidor = ipServidor;
        this.puertoEscucha = puertoEscucha;
    }
    
    public Mensaje(){
        usuario = null;
        certificado = null;
        ipServidor = -1;
        puertoEscucha = -1;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Certificado getCertificado() {
        return certificado;
    }

    public void setCertificado(Certificado certificado) {
        this.certificado = certificado;
    }

    public int getIpServidor() {
        return ipServidor;
    }

    public void setIpServidor(int ipServidor) {
        this.ipServidor = ipServidor;
    }

    public int getPuertoEscucha() {
        return puertoEscucha;
    }

    public void setPuertoEscucha(int puertoEscucha) {
        this.puertoEscucha = puertoEscucha;
    }
    
    
    
    
}
