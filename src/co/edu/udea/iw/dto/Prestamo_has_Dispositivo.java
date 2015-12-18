package co.edu.udea.iw.dto;

import java.io.Serializable;

/**
 * Esta clase contiene los atributos de un Dispositivo vinculado a un prestamo
 * del Laboratorio de Neurociencias y sus respectivos metodos de acceso (getters
 * and setters).
 * 
 * @author Carolina Isaza
 * @author Sebastian Jimenez
 * @author Jaime Londono
 *
 */
public class Prestamo_has_Dispositivo implements Serializable {

	/**
	 * Identificador del dispositivo dentro de un prestamo.
	 */
	private Prestamo_has_DispositivoId id;

	/**
	 * Metodo para obtener el identificador de un dispositivo dentro de un
	 * prestamo
	 * 
	 * @return Identificador del dispositivo asociado a un prestamo
	 */
	public Prestamo_has_DispositivoId getId() {
		return id;
	}

	/**
	 * Metodo para asignar el identificador de un dispositivo dentro de un
	 * prestamo
	 * 
	 * @param id
	 *            Identificador que se desea asignar al dispositivo dentro de un
	 *            prestamo
	 */
	public void setId(Prestamo_has_DispositivoId id) {
		this.id = id;
	}
}
