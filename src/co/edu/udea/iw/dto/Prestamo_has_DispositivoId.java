package co.edu.udea.iw.dto;

import java.io.Serializable;

/**
 * Esta clase contiene los atributos de la relacion de un dispositivo asociado a
 * un prestamo del Laboratorio de Neurociencias y sus respectivos metodos de
 * acceso (getters & setters).
 * 
 * @author Carolina Isaza
 * @author Sebastian Jimenez
 * @author Jaime Londono
 *
 */
public class Prestamo_has_DispositivoId implements Serializable {

	/**
	 * Objeto tipo prestamo al que se esta haciendo la relacion con dispositivo
	 */
	private Prestamo prestamo;
	/**
	 * Objeto tipo dispositivo del que se esta haciendo la relacion con prestamo
	 */
	private Dispositivo referencia;

	/**
	 * Metodo para obtener el objeto prestamo en la relacion
	 * 
	 * @return Objeto tipo prestamo
	 */
	public Prestamo getPrestamo() {
		return prestamo;
	}

	/**
	 * Metodo para asignar el objeto prestamo en la relacion
	 * 
	 * @param prestamo
	 *            Objeto tipo prestamo que se desea asignar
	 */
	public void setPrestamo(Prestamo prestamo) {
		this.prestamo = prestamo;
	}

	/**
	 * Metodo para obtener el objeto dispositivo en la relacion
	 * 
	 * @return Objeto tipo dispositivo
	 */
	public Dispositivo getReferencia() {
		return referencia;
	}

	/**
	 * Metodo para asignar el objeto dispositivo en la relacion
	 * 
	 * @param referencia
	 *            Objeto tipo dispositivo que se desea asignar
	 */
	public void setReferencia(Dispositivo referencia) {
		this.referencia = referencia;
	}

}
