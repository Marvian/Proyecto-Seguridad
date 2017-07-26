/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucab.seguridad.modelo;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase en la que se maneja la busqueda del Usuario.
 * 
 */
public class BuscaUsuario {
	/**
         * Metodo que es llamado cuando es necesario buscar la existencia de un usuario.
         * 
         * @param usuario Recibe el usuario que se desea buscar.
         * @return Devuelve un objeto del tipo mensaje.
         */
	public static Mensaje buscarUsuario(Usuario usuario){
		ArrayList<Usuario> listaUsuarios = new ArrayList<>();
		listaUsuarios = leyendo();
                Mensaje respuestaBusqueda = new Mensaje();
		Usuario usuarioFinal = new Usuario();
		for (int i = 0; i < listaUsuarios.size(); i++){
                    if ((listaUsuarios.get(i).getUsuario().equals(usuario.getUsuario())) &&
                            (listaUsuarios.get(i).getContrasena().equals(usuario.getContrasena()))){
				usuarioFinal = usuario;
                                respuestaBusqueda.setOpcion(1);
				System.out.println("Consegui al usuario en el archivo");
				break;              
			
                                                           
                        }
			if((listaUsuarios.get(i).getUsuario().equals(usuario.getUsuario())) &&
                            (listaUsuarios.get(i).getContrasena() != (usuario.getContrasena()))){
				usuarioFinal.setDireccionIP("INVALIDO");
				System.out.println("Nombre de usuario si, contraseña no");
                                respuestaBusqueda.setOpcion(2);
                        }
                        else{
                            respuestaBusqueda.setOpcion(3);
                        }
                       
                }
                
                respuestaBusqueda.setUsuario(usuarioFinal);
            return respuestaBusqueda;
	}
		
		
	
	
	
	
	/**
	 *  En este modulo se maneja el registro del usuario, se recibe del formulario, se compara que no exista.
	 * De no existir es agregado al archivo de todos los usuarios, si no, hay error y no se registra el mismo.
	 * @param usuario Recibe el usuario que se desea verificar,
	 * @return Devuelve un objeto del tipo usuario.
	 * 
	 *
	 */
	public static Usuario verificarUsuario(Usuario usuario){
		ArrayList<Usuario> listaUsuarios = new ArrayList<>();
		listaUsuarios = leyendo();
		Usuario usuarioFinal = new Usuario();
		if (listaUsuarios.isEmpty()){
			listaUsuarios.add(usuario);
			Json.Escribir(listaUsuarios);
		}
		else{
			int i = 0;
			while ( i < listaUsuarios.size()){
				if ((listaUsuarios.get(i).getUsuario()) == usuario.getUsuario()){
					break;
					
				}
				else{
					i++;
					
				}
			}
			if (i == listaUsuarios.size()){
				listaUsuarios.clear();
				listaUsuarios = leyendo();
				listaUsuarios.add(i, usuarioFinal);
				Json.Escribir(listaUsuarios);
			}
		}
		
		
		
		
		return usuarioFinal;
	}
	/**
         * Metodo que se usa para agregar cantidad de intentos de ingreso fallidos
         * en caso de que el cliente introduzca contraseñas erradas.
         * @param usuario Recibe el usuario que coloco mal la contraseña.
         */
	public static void buscarUsuarioEdita(Usuario usuario){
		ArrayList<Usuario> listaUsuarios = new ArrayList<>();
		listaUsuarios = leyendo();
		System.out.println("Tamaño Array: " + listaUsuarios.size());
		for (int i = 0; i < listaUsuarios.size(); i++){
			if (listaUsuarios.get(i).getUsuario().equals(usuario.getUsuario())){
				listaUsuarios.get(i).setCantidadIngresos(listaUsuarios.get(i).getCantidadIngresos() + 1);
				Json.Escribir(listaUsuarios);
				break;
			}
			else{
			System.out.println("No lo consegui");
			}
		}			
		System.out.println("Tamaño Array: " + listaUsuarios.size());
	}
	
	
	/**
     * Metodo de uso repetido para leer del archivo json de usuarios.
     * @return Devuelve un arraylist con la lista de los usuarios.
     * 
     */
    public static ArrayList<Usuario> leyendo(){
    	ArrayList<Usuario> auxiliar = new ArrayList<>();
    	try {
			auxiliar = Json.Leer();
			System.out.println("Tamaño Array: " + auxiliar.size());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Archivo vacio.");
		}
    	return auxiliar;
    }

}
