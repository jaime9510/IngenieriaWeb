package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Dispositivo;
import co.edu.udea.iw.dto.Fallo;
import co.edu.udea.iw.exception.MyException;

/**
 * Esta interaz contiene la definici�n de los m�todos correspondientes a las
 * funciones que se podr�n hacer para un Fallo de un dispositivo en relaci�n con
 * el acceso a la base de datos
 * 
 * @author Carolina Isaza
 * @author Jaime Londo�o
 * @author Sebasti�n Jim�nez
 *
 */
public interface FalloDao {

	/**
	 * Definici�n del m�todo con el que se consultar�n todos los fallos
	 * registrados en la base de datos
	 * 
	 * @return Lista de objetos de tipo Fallo
	 * @throws MyException
	 *             Si la operaci�n con la base de datos falla y no se puede
	 *             realizar la consulta
	 */
	public List<Fallo> consultarTodos() throws MyException;

	/**
	 * Definici�n del m�todo encargado de almacenar en la BD los datos
	 * correspondientes a un nuevo Fallo reportado
	 * 
	 * @param fallo
	 *            Objeto con todos los datos correspondientes a un fallo en un
	 *            dispositivo
	 * @throws MyException
	 *             Si la operaci�n con la base de datos falla y no puede
	 *             realizarse la inserci�n
	 */
	public void crear(Fallo fallo) throws MyException;

	/**
	 * Definici�n del m�todo encargado de realizar una actualizaci�n en la BD de
	 * los datos del fallo, el n�mero de identificaci�n del fallo no podr� ser
	 * actualizado
	 * 
	 * @param fallo
	 *            Objeto con los datos correspondientes a un Fallo
	 * @throws MyException
	 *             Si la operaci�n con la base de datos falla y no puede
	 *             realizarse la actualizaci�n de los datos
	 */
	public void actualizar(Fallo fallo) throws MyException;

	/**
	 * Definici�n del m�todo con el que se consultar�n los Fallos que est�n
	 * reportados en la BD para un dispositvo enviado como par�metro
	 * 
	 * @param dispositivo
	 *            Objeto del tipo Dispositivo con el que se realizar� la
	 *            b�squeda
	 * @return Lista con los fallos encontrados en la base de datos para el
	 *         dispositivo especificado
	 * @throws MyException
	 *             Si la operaci�n con la base de datos falla y no puede
	 *             realizarse la consulta
	 */
	public List<Fallo> consultarFalloPorDispositivo(Dispositivo dispositivo) throws MyException;

	/**
	 * Definici�n del m�todo con el que se consultar�n los Fallos que est�n
	 * reportados en la BD y para los cuales no se ha dado una soluci�n
	 * 
	 * @return Lista con los Fallos que no han sido solucionados
	 * @throws MyException
	 *             Si la operaci�n con la base de datos falla y no puede
	 *             realizarse la consulta
	 */
	public List<Fallo> consultarDanosSinSolucion() throws MyException;
	
	public Fallo consultarUno(int id) throws MyException;
}
