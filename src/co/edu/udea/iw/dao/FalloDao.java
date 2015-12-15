package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Dispositivo;
import co.edu.udea.iw.dto.Fallo;
import co.edu.udea.iw.exception.MyException;

/**
 * Esta interaz contiene la definición de los métodos correspondientes a las
 * funciones que se podrán hacer para un Fallo de un dispositivo en relación con
 * el acceso a la base de datos
 * 
 * @author Carolina Isaza
 * @author Jaime Londoño
 * @author Sebastián Jiménez
 *
 */
public interface FalloDao {

	/**
	 * Definición del método con el que se consultarán todos los fallos
	 * registrados en la base de datos
	 * 
	 * @return Lista de objetos de tipo Fallo
	 * @throws MyException
	 *             Si la operación con la base de datos falla y no se puede
	 *             realizar la consulta
	 */
	public List<Fallo> consultarTodos() throws MyException;

	/**
	 * Definición del método encargado de almacenar en la BD los datos
	 * correspondientes a un nuevo Fallo reportado
	 * 
	 * @param fallo
	 *            Objeto con todos los datos correspondientes a un fallo en un
	 *            dispositivo
	 * @throws MyException
	 *             Si la operación con la base de datos falla y no puede
	 *             realizarse la inserción
	 */
	public void crear(Fallo fallo) throws MyException;

	/**
	 * Definición del método encargado de realizar una actualización en la BD de
	 * los datos del fallo, el número de identificación del fallo no podrá ser
	 * actualizado
	 * 
	 * @param fallo
	 *            Objeto con los datos correspondientes a un Fallo
	 * @throws MyException
	 *             Si la operación con la base de datos falla y no puede
	 *             realizarse la actualización de los datos
	 */
	public void actualizar(Fallo fallo) throws MyException;

	/**
	 * Definición del método con el que se consultarán los Fallos que estén
	 * reportados en la BD para un dispositvo enviado como parámetro
	 * 
	 * @param dispositivo
	 *            Objeto del tipo Dispositivo con el que se realizará la
	 *            búsqueda
	 * @return Lista con los fallos encontrados en la base de datos para el
	 *         dispositivo especificado
	 * @throws MyException
	 *             Si la operación con la base de datos falla y no puede
	 *             realizarse la consulta
	 */
	public List<Fallo> consultarFalloPorDispositivo(Dispositivo dispositivo) throws MyException;

	/**
	 * Definición del método con el que se consultarán los Fallos que estén
	 * reportados en la BD y para los cuales no se ha dado una solución
	 * 
	 * @return Lista con los Fallos que no han sido solucionados
	 * @throws MyException
	 *             Si la operación con la base de datos falla y no puede
	 *             realizarse la consulta
	 */
	public List<Fallo> consultarDanosSinSolucion() throws MyException;
	
	public Fallo consultarUno(int id) throws MyException;
}
