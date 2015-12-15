package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Dispositivo;
import co.edu.udea.iw.dto.Tipo;
import co.edu.udea.iw.exception.MyException;

/**
 * Esta interaz contiene la definici�n de los m�todos correspondientes a las
 * funciones que se podr�n hacer para un Dispositivo en relaci�n con el acceso a
 * la base de datos
 * 
 * @author Carolina Isaza
 * @author Jaime Londo�o
 * @author Sebasti�n Jim�nez
 *
 */
public interface DispositivoDao {

	/**
	 * Definici�n del m�todo con el que se consultar�n todos los administradores
	 * registrados en la base de datos
	 * 
	 * @return Lista de objetos del tipo dispositivo
	 * @throws MyException
	 *             Si la operaci�n con la base de datos falla y no se puede
	 *             realizar la consulta
	 */
	public List<Dispositivo> consultarTodos() throws MyException;

	/**
	 * Definici�n del m�todo encargado de almacenar en la BD los datos
	 * correspondientes a un nuevo dispositivo
	 * 
	 * @param dispositivo
	 *            Objeto del tipo Dispositivo con todos los datos definidos para
	 *            el mismo
	 * @throws MyException
	 *             Si la operaci�n con la base de datos falla y no puede
	 *             realizarse la inserci�n
	 */
	public void crear(Dispositivo dispositivo) throws MyException;

	/**
	 * Definici�n del m�todo encargado derealizar una actualizaci�n en la BD de
	 * los datos del dispositivo, el email no podr� ser actualizado
	 * 
	 * @param dispositivo
	 *            Objeto de la clase Dispositivo con todos los datos definidos
	 *            para el mismo
	 * @throws MyException
	 *             Si la operaci�n con la base de datos falla y no puede
	 *             realizarse la actualizaci�n de los datos
	 */
	public void actualizar(Dispositivo dispositivo) throws MyException;

	/**
	 * Definici�n del m�todo encargado de eliminar de la BD el administrador
	 * enviado como par�metro
	 * 
	 * @param dispositivo
	 *            Objeto de la clase Dispositivo con todos los datos definidos
	 *            para el mismo
	 * @throws MyException
	 *             Si la operaci�n con la base de datos falla y no puede
	 *             realizarse la eliminaci�n de una fila en la BD
	 */
	public void eliminar(Dispositivo dispositivo) throws MyException;

	/**
	 * Definici�n del m�todo con el que se consultar�n los Dispositivos que
	 * tengan asignado el tipo enviado como par�metro
	 * 
	 * @param tipo
	 *            Objeto del tipo Tipo
	 * @return Lista de Dispositivos del tipo enviado como par�metro
	 * @throws MyException
	 *             Si la operaci�n con la base de datos falla y no puede
	 *             realizarse la consulta
	 */
	public List<Dispositivo> consultarPorTipo(Tipo tipo) throws MyException;

	/**
	 * Definici�n del m�todo con el que se consultar�n los Dispositivos que
	 * est�n reportados en la BD como disponibles
	 * 
	 * @return Lista de Dispositivos disponibles para pr�stamo
	 * @throws MyException
	 *             Si la operaci�n con la base de datos falla y no puede
	 *             realizarse la consulta
	 */
	public List<Dispositivo> consultarDisponibles() throws MyException;

	/**
	 * Definici�n del m�todo con el que se consultar� desde la BD el dispositivo
	 * con la referencia enviada como par�metro
	 * 
	 * @param referencia
	 *            String con la referencia asignada a un dispositivo espec�fico
	 * @return Objeto del tipo Dispositivo con toda la informaci�n relacionada
	 *         con el dispositivo a consultar
	 * @throws MyException
	 *             Si la operaci�n con la base de datos falla y no puede
	 *             realizarse la consulta
	 */
	public Dispositivo consultarUno(String referencia) throws MyException;
}
