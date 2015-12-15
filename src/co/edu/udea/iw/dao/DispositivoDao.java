package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Dispositivo;
import co.edu.udea.iw.dto.Tipo;
import co.edu.udea.iw.exception.MyException;

/**
 * Esta interaz contiene la definición de los métodos correspondientes a las
 * funciones que se podrán hacer para un Dispositivo en relación con el acceso a
 * la base de datos
 * 
 * @author Carolina Isaza
 * @author Jaime Londoño
 * @author Sebastián Jiménez
 *
 */
public interface DispositivoDao {

	/**
	 * Definición del método con el que se consultarán todos los administradores
	 * registrados en la base de datos
	 * 
	 * @return Lista de objetos del tipo dispositivo
	 * @throws MyException
	 *             Si la operación con la base de datos falla y no se puede
	 *             realizar la consulta
	 */
	public List<Dispositivo> consultarTodos() throws MyException;

	/**
	 * Definición del método encargado de almacenar en la BD los datos
	 * correspondientes a un nuevo dispositivo
	 * 
	 * @param dispositivo
	 *            Objeto del tipo Dispositivo con todos los datos definidos para
	 *            el mismo
	 * @throws MyException
	 *             Si la operación con la base de datos falla y no puede
	 *             realizarse la inserción
	 */
	public void crear(Dispositivo dispositivo) throws MyException;

	/**
	 * Definición del método encargado derealizar una actualización en la BD de
	 * los datos del dispositivo, el email no podrá ser actualizado
	 * 
	 * @param dispositivo
	 *            Objeto de la clase Dispositivo con todos los datos definidos
	 *            para el mismo
	 * @throws MyException
	 *             Si la operación con la base de datos falla y no puede
	 *             realizarse la actualización de los datos
	 */
	public void actualizar(Dispositivo dispositivo) throws MyException;

	/**
	 * Definición del método encargado de eliminar de la BD el administrador
	 * enviado como parámetro
	 * 
	 * @param dispositivo
	 *            Objeto de la clase Dispositivo con todos los datos definidos
	 *            para el mismo
	 * @throws MyException
	 *             Si la operación con la base de datos falla y no puede
	 *             realizarse la eliminación de una fila en la BD
	 */
	public void eliminar(Dispositivo dispositivo) throws MyException;

	/**
	 * Definición del método con el que se consultarán los Dispositivos que
	 * tengan asignado el tipo enviado como parámetro
	 * 
	 * @param tipo
	 *            Objeto del tipo Tipo
	 * @return Lista de Dispositivos del tipo enviado como parámetro
	 * @throws MyException
	 *             Si la operación con la base de datos falla y no puede
	 *             realizarse la consulta
	 */
	public List<Dispositivo> consultarPorTipo(Tipo tipo) throws MyException;

	/**
	 * Definición del método con el que se consultarán los Dispositivos que
	 * estén reportados en la BD como disponibles
	 * 
	 * @return Lista de Dispositivos disponibles para préstamo
	 * @throws MyException
	 *             Si la operación con la base de datos falla y no puede
	 *             realizarse la consulta
	 */
	public List<Dispositivo> consultarDisponibles() throws MyException;

	/**
	 * Definición del método con el que se consultará desde la BD el dispositivo
	 * con la referencia enviada como parámetro
	 * 
	 * @param referencia
	 *            String con la referencia asignada a un dispositivo específico
	 * @return Objeto del tipo Dispositivo con toda la información relacionada
	 *         con el dispositivo a consultar
	 * @throws MyException
	 *             Si la operación con la base de datos falla y no puede
	 *             realizarse la consulta
	 */
	public Dispositivo consultarUno(String referencia) throws MyException;
}
