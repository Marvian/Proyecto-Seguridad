/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucab.seguridad.modelo;

import java.io.Serializable;

/**
 * Clase que se utiliza para el envio de objetos entre cliente y servidor.
 * 
 */
public class Mensaje implements Serializable {
    
    private Usuario usuario;
    private Certificado certificado;
    private int ipServidor;
    private int puertoEscucha;
    private int opcion;
    private int respuesta;
    private int bytesAEnviar;
    private int[] contenidoFichero;
    private boolean bytesFinales;
    /**
     * Constructor de clase con atributos a llenar.
     * @param usuario recibe el objeto usuario que contiene los datos del mismo.
     * @param certificado recibe el objeto certificado que contiene los datos del mismo.
     * @param ipServidor recibe la ip del servidor (no se usa)
     * @param puertoEscucha recibe el puerto de escucha (no se usa)
     * @param opcion recibe la opcion mediante la cual el servidor entiende que debe hacer.
     * @param respuesta recibe la respuesta dle servidor.
     */
    public Mensaje (Usuario usuario, Certificado certificado, int ipServidor, 
            int puertoEscucha, int opcion, int respuesta ){
    
        super();
        this.usuario = usuario;
        this.certificado = certificado;
        this.ipServidor = ipServidor;
        this.puertoEscucha = puertoEscucha;
        this.opcion = opcion;
        this.respuesta = respuesta;
        this.bytesAEnviar = 0;
        this.bytesFinales = false;
    }
    /**
     * Constructor de clase vacio mediante el cual se inicializan los valores por
     * defecto del objeto.
     */
    public Mensaje(){
        this.usuario = null;
        this.certificado = null;
        this.ipServidor = -1;
        this.puertoEscucha = -1;
        this.opcion = -1;
        this.respuesta = -1;
        this.bytesAEnviar = 0;
        this.bytesFinales = false;
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

    public int getOpcion() {
        return opcion;
    }

    public void setOpcion(int opcion) {
        this.opcion = opcion;
    }

    /**
     * @return the bytesAEnviar
     */
    public int getBytesAEnviar() {
        return bytesAEnviar;
    }

    /**
     * @param bytesAEnviar the bytesAEnviar to set
     */
    public void setBytesAEnviar(int bytesAEnviar) {
        this.bytesAEnviar = bytesAEnviar;
    }

    /**
     * @return the contenidoFichero
     */
    public int[] getContenidoFichero() {
        return contenidoFichero;
    }

    /**
     * @param contenidoFichero the contenidoFichero to set
     */
    public void setContenidoFichero(int[] contenidoFichero) {
        this.contenidoFichero = contenidoFichero;
    }

    /**
     * @return the bytesFinales
     */
    public boolean isBytesFinales() {
        return bytesFinales;
    }

    /**
     * @param bytesFinales the bytesFinales to set
     */
    public void setBytesFinales(boolean bytesFinales) {
        this.bytesFinales = bytesFinales;
    }
    
    
    
    
    
    
}
