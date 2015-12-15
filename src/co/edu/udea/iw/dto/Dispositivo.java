package co.edu.udea.iw.dto;

import java.io.Serializable;

/**
 * Esta clase contiene los atributos de un Dispositivo del Laboratiorio
 * de Neurociencias y sus respectivos m�todos de acceso (getters & setters)
 * @author Carolina
 * @author Sebasti�n
 * @author Jaime
 *
 */
public class Dispositivo implements Serializable{

	//Atributos del Dispositivo
	
	/**
	 * Tipo de dispositivo
	 */
	private Tipo tipo;
	/**
	 * Referencia �nica del dispositivo
	 */
	private String referencia;
	/**
	 * Nombre del dispositivo
	 */
	private String nombre;
	/**
	 * Atributo que indica si el dispositivo est� disponible para 
	 * su pr�stamo
	 */
	private boolean disponible;
	/**
	 * Descripci�n del dispositivo
	 */
	private String descripcion;
	/**
	 * Foto del dispositivo
	 */
	private String foto;
	
	//M�todos Getters y Setters
	
	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	/**
	 * M�todo para acceder al tipo al que pernetece el Dispositivo 
	 * @return tipo Objeto de la clase tipo
	 */
	public Tipo getTipo() {
		return tipo;
	}
	
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
