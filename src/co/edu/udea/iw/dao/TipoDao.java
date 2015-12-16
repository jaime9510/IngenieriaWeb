package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Tipo;
import co.edu.udea.iw.exception.MyException;

/**
 * Esta interaz contiene la definici�n de los m�todos correspondientes a las
 * funciones que se podr�n hacer para un Tipo de dispositivo en relaci�n con el
 * acceso a la base de datos
 * 
 * @author Carolina Isaza
 * @author Jaime Londo�o
 * @author Sebasti�n Jim�nez
 *
 */
public interface TipoDao {

	/**
	 * Definici�n del m�todo con el que se consultar�n todos los Tipos de
	 * dispositivos registrados en la base de datos
	 * 
	 * @return Lista de objetos de tipo Tipo
	 * @throws MyException
	 *             Si la operaci�n con la base de datos falla y no se puede
	 *             realizar la consulta
	 */
	public List<Tipo> consultarTodos() throws MyException;

	/**
	 * Definici�n del m�todo encargado de almacenar en la BD los datos
	 * correspondientes a un nuevo Tipo de dispositivo en el laboratorio
	 * 
	 * @param tipo
	 *            Objeto del tipo Tipo con los datos que ser�n almacenados en la
	 *            BD
	 * @throws MyException
	 *             Si la operaci�n con la base de datos falla y no puede
	 *             realizarse la inserci�n
	 */
	public void crear(Tipo tipo) throws MyException;

	/**
	 * Definici�n del m�todo con el que se consultar� desde la BD el
	 * administrador con el id de Tipo enviado como par�metro
	 * 
	 * @param id
	 *            Entero que permite la identificaci�n de un tipo de
	 *            dispositivo. Esta identificaci�n es definida previamente por
	 *            el laboratorio
	 * @return Objeto de tipo Tipo con los datos del tipo al que le pertenece el
	 *         id consultado.
	 * @throws MyException
	 *             Si la operaci�n con la base de datos falla y no puede
	 *             realizarse la consulta
	 */
	public Tipo consultarUno(int id) throws MyException;
	
	public Tipo consultarPorNombre(String nombre) throws MyException;
}
