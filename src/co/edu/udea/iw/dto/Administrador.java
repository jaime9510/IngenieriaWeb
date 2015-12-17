package co.edu.udea.iw.dto;

import java.io.Serializable;

/**
 * Esta clase contiene los atributos de un Administrador del Laboratiorio de
 * Neurociencias y sus respectivos m�todos de acceso (getters & setters)
 * 
 * @author Carolina
 * @author Sebasti�n
 * @author Jaime
 *
 */
public class Administrador implements Serializable {

	// Atributos de tipo privado definidos para el Administrador
	/**
	 * Nombre del administrador
	 */
	private String nombre;
	/**
	 * Apellido del administrador
	 */
	private String apellidos;
	/**
	 * Contrase�a cifrada del administrador
	 */
	private String contrasena;
	/**
	 * Correo electr�nico del administrador
	 */
	private String email;

	// M�todos Getters y Setters

	/**
	 * M�todo para acceder al nombre del administrador
	 * 
	 * @return nombre del objeto administrador
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * M�todo para asignar un valor al atributo nombre
	 * 
	 * @param nombre
	 *            Nombre a asignar al objeto administrador
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * M�todo para acceder al apellido del administrador
	 * 
	 * @return apellido del objeto administrador existente
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * M�todo para asignar un valor al atributo apellido
	 * 
	 * @param apellido
	 *            Apellido a asignar al objeto administrador
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * M�todo para acceder a la contrase�a del administrador
	 * 
	 * @return contrasena cifrada del objeto administrador
	 */
	public String getContrasena() {
		return contrasena;
	}

	/**
	 * M�todo para asignar un valor al atributo contrase�a
	 * 
	 * @param contrasena
	 *            Contrase�a cifrada que se asignar� al administrador
	 */
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	/**
	 * M�todo para acceder al correo electr�nico del administrador
	 * 
	 * @return email asociado al objeto administrador
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * M�todo para asignar un valor al atributo email
	 * 
	 * @param email
	 *            Email a asignar al administrador
	 */
	public void setEmail(String email) {
		this.email = email;
	}

}
