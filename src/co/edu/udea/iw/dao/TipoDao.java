package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Tipo;
import co.edu.udea.iw.exception.MyException;

/**
 * Esta interaz contiene la definición de los métodos correspondientes a las
 * funciones que se podrán hacer para un Tipo de dispositivo en relación con el
 * acceso a la base de datos
 * 
 * @author Carolina Isaza
 * @author Jaime Londoño
 * @author Sebastián Jiménez
 *
 */
public interface TipoDao {

	/**
	 * Definición del método con el que se consultarán todos los Tipos de
	 * dispositivos registrados en la base de datos
	 * 
	 * @return Lista de objetos de tipo Tipo
	 * @throws MyException
	 *             Si la operación con la base de datos falla y no se puede
	 *             realizar la consulta
	 */
	public List<Tipo> consultarTodos() throws MyException;

	/**
	 * Definición del método encargado de almacenar en la BD los datos
	 * correspondientes a un nuevo Tipo de dispositivo en el laboratorio
	 * 
	 * @param tipo
	 *            Objeto del tipo Tipo con los datos que serán almacenados en la
	 *            BD
	 * @throws MyException
	 *             Si la operación con la base de datos falla y no puede
	 *             realizarse la inserción
	 */
	public void crear(Tipo tipo) throws MyException;

	/**
	 * Definición del método con el que se consultará desde la BD el
	 * administrador con el id de Tipo enviado como parámetro
	 * 
	 * @param id
	 *            Entero que permite la identificación de un tipo de
	 *            dispositivo. Esta identificación es definida previamente por
	 *            el laboratorio
	 * @return Objeto de tipo Tipo con los datos del tipo al que le pertenece el
	 *         id consultado.
	 * @throws MyException
	 *             Si la operación con la base de datos falla y no puede
	 *             realizarse la consulta
	 */
	public Tipo consultarUno(int id) throws MyException;
	
	public Tipo consultarPorNombre(String nombre) throws MyException;
}
