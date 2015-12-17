package co.edu.udea.iw.dto;

import java.io.Serializable;

/**
 * Esta clase contiene los atributos de un Administrador del Laboratiorio de
 * Neurociencias y sus respectivos métodos de acceso (getters & setters)
 * 
 * @author Carolina
 * @author Sebastián
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
	 * Contraseña cifrada del administrador
	 */
	private String contrasena;
	/**
	 * Correo electrónico del administrador
	 */
	private String email;

	// Métodos Getters y Setters

	/**
	 * Método para acceder al nombre del administrador
	 * 
	 * @return nombre del objeto administrador
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Método para asignar un valor al atributo nombre
	 * 
	 * @param nombre
	 *            Nombre a asignar al objeto administrador
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Método para acceder al apellido del administrador
	 * 
	 * @return apellido del objeto administrador existente
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * Método para asignar un valor al atributo apellido
	 * 
	 * @param apellido
	 *            Apellido a asignar al objeto administrador
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * Método para acceder a la contraseña del administrador
	 * 
	 * @return contrasena cifrada del objeto administrador
	 */
	public String getContrasena() {
		return contrasena;
	}

	/**
	 * Método para asignar un valor al atributo contraseña
	 * 
	 * @param contrasena
	 *            Contraseña cifrada que se asignará al administrador
	 */
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	/**
	 * Método para acceder al correo electrónico del administrador
	 * 
	 * @return email asociado al objeto administrador
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Método para asignar un valor al atributo email
	 * 
	 * @param email
	 *            Email a asignar al administrador
	 */
	public void setEmail(String email) {
		this.email = email;
	}

}
