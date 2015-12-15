package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Prestamo_has_Dispositivo;
import co.edu.udea.iw.exception.MyException;

/**
 * Esta interaz contiene la definici�n de los m�todos correspondientes a las
 * funciones que se podr�n hacer para el registro de todos los dispositivos
 * asociados a un pr�stamo en relaci�n con el acceso a la base de datos
 * 
 * @author Carolina Isaza
 * @author Jaime Londo�o
 * @author Sebasti�n Jim�nez
 *
 */
public interface Prestamo_has_DispositivoDao {

	/**
	 * Definici�n del m�todo con el que se consultar�n todos los dispositivos
	 * prestados y su respectiva orden de pr�stamo registrados en la base de
	 * datos
	 * 
	 * @return Lista de objetos de tipo Prestamo_has_Dispositivo
	 * @throws MyException
	 *             Si la operaci�n con la base de datos falla y no se puede
	 *             realizar la consulta
	 */
	public List<Prestamo_has_Dispositivo> consultarTodos() throws MyException;

	/**
	 * Definici�n del m�todo encargado de almacenar en la BD los datos
	 * correspondientes a un nuevo dispositivo prestado y su respectiva orden de
	 * pr�stamo
	 * 
	 * @param pd
	 *            Objeto del tipo Prestamo_has_Dispositivo con todos los datos
	 *            definidos para este objeto
	 * @throws MyException
	 *             Si la operaci�n con la base de datos falla y no puede
	 *             realizarse la inserci�n
	 */
	public void crear(Prestamo_has_Dispositivo pd) throws MyException;

}
