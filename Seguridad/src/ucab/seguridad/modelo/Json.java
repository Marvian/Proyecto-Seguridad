package ucab.seguridad.modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import ucab.seguridad.modelo.*;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marvian
 */
public class Json {
    
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
    
    
}
