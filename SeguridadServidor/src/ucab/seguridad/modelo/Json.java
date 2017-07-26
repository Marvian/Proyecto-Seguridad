package ucab.seguridad.modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import ucab.seguridad.modelo.*;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Clase en la cual se realiza el manejo de los archivos, tanto escritura 
 * como lectura.
 * 
 */
public class Json {
    static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    /**
     * Metodo estatico que se utiliza para escribir dentro del archivo.
     * @param listaUsuarios Recibe una lista con todos los usuarios que se desean escribir
     * dentro del archivo.
     */
    public static void Escribir(ArrayList<Usuario> listaUsuarios){
		File archivo = null;
		
                
		JSONObject usuariosJson = new JSONObject();
		JSONArray usuarios = new JSONArray();
		for (int i=0 ; i < listaUsuarios.size() ; i++){
			Usuario usuario = new Usuario();
			usuario.setUsuario(listaUsuarios.get(i).getUsuario());
			usuario.setContrasena(listaUsuarios.get(i).getContrasena());
			usuario.setDireccionIP(listaUsuarios.get(i).getDireccionIP());	
			JSONObject usuarioJson = new JSONObject();
			usuarioJson.put("Usuario",( listaUsuarios.get(i).getUsuario()));
			usuarioJson.put("Contrasena",(listaUsuarios.get(i).getContrasena()));
			usuarioJson.put("Direccion", (listaUsuarios.get(i).getDireccionIP()));
			usuarioJson.put("Cantidad",( listaUsuarios.get(i).getCantidadIngresos()));
			usuarios.add(usuarioJson);	
		}
		usuariosJson.put("Usuarios", usuarios);
		try{
			
			File miDir = new File (".");
			archivo = new File (miDir.getCanonicalPath()+"/Usuarios.Json");
			
			if (!archivo.exists())
				archivo.createNewFile();
			
			FileWriter fw = new FileWriter (archivo.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(usuariosJson.toJSONString());
			bw.close();
		}
		catch (IOException e){		
		}
    }

    /**
     * Metodo estatico que se utilizara cuando se desea leer del archivo json.
     * @return Devuelve una lista con todos los usuarios que se encuentran dentro del archivo.
     * @throws IOException Excepcion que puede ocurrir durante la lectura.
     */
    public static ArrayList<Usuario> Leer() throws IOException{
            File archivo = null;
		JSONParser parseando = new JSONParser();
		try{
		    File miDir = new File (".");
		    archivo = new File (miDir.getCanonicalPath() +"/Usuarios.Json");
		    FileInputStream fis = new FileInputStream(archivo);			 
		    Object objeto = parseando.parse(new InputStreamReader(fis));	
                    JSONObject objetoJson = (JSONObject) objeto;
                    JSONArray arregloUsuarios = (JSONArray)objetoJson.get("Usuarios");;
                    System.out.println("Tamaño Array LEYENDO: " + arregloUsuarios.size());
                    usuarios.clear();
			
		    try{   
			for (int i = 0; i < arregloUsuarios.size(); i++){
                            JSONObject usuarioJson = (JSONObject)arregloUsuarios.get(i);
			    usuarios.addAll(datosUsuarios(usuarioJson));
			    System.out.println("Tamaño Array TERMINE DE LEER: " + usuarios.size());
			    System.out.println(usuarios.get(i).getUsuario());
			}
			return usuarios;
	            }
	            catch(Exception e) {System.out.println(e);}
	}
	catch(ParseException e){
		System.out.println("Ha ocurrido un error"+e.getMessage());
		System.out.println(e);
	}
	return usuarios;
		
    }
        /**
         * Metodo de uso para lectura y escritura.
         * @param usuarioJson Recibe un objeto json en el cual se manejan los datos del usuario.
         * @return Devuelve una lista de usuarios.
         */
	public static ArrayList<Usuario> datosUsuarios(JSONObject usuarioJson){
		Usuario usuario = new Usuario();
		ArrayList<Usuario> usuarios = new ArrayList<>();
		usuario.setUsuario(((String) usuarioJson.get("Usuario")));
                usuario.setContrasena(((String) usuarioJson.get("Contrasena")));
                usuario.setDireccionIP(((String) usuarioJson.get("Direccion")));
                usuario.setUsuario(((String) usuarioJson.get("Usuario")));
                usuario.setCantidadIngresos(((Long) usuarioJson.get("Cantidad")));
                usuarios.add(usuario);
		return usuarios;
	}
	
    
    
}
