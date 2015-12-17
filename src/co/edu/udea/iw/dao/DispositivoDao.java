package co.edu.udea.iw.dao;

import java.util.Date;
import java.util.List;

import co.edu.udea.iw.dto.Dispositivo;
import co.edu.udea.iw.dto.Tipo;
import co.edu.udea.iw.exception.MyException;

/**
 * Esta interfaz contiene la definicion de los metodos correspondientes a las
 * funciones que se podran hacer para un Dispositivo en relacion con el acceso a
 * la base de datos.
 * 
 * @author Carolina Isaza
 * @author Jaime Londono
 * @author Sebastian Jimenez
 *
 */
public interface DispositivoDao {

	/**
	 * Consulta todos los dispositivos registrados en la base de datos.
	 * 
	 * @return Lista de objetos del tipo dispositivo.
	 * @throws MyException
	 *             Si la operacion con la base de datos falla y no se puede
	 *             realizar la consulta.
	 */
	public List<Dispositivo> consultarTodos() throws MyException;

	/**
	 * Almacena en la base de datos la informacion correspondiente a un nuevo
	 * dispositivo.
	 * 
	 * @param dispositivo
	 *            Objeto del tipo Dispositivo con todos los datos definidos para
	 *            el mismo.
	 * @throws MyException
	 *             Si la operacion con la base de datos falla y no puede
	 *             realizarse la insercion.
	 */
	public void crear(Dispositivo dispositivo) throws MyException;

	/**
	 * Actualiza en la base de datos la informacion del dispositivo, el email no
	 * podra ser actualizado.
	 * 
	 * @param dispositivo
	 *            Objeto de la clase Dispositivo con todos los datos definidos
	 *            para el mismo.
	 * @throws MyException
	 *             Si la operacion con la base de datos falla y no puede
	 *             realizarse la actualizacion de los datos.
	 */
	public void actualizar(Dispositivo dispositivo) throws MyException;

	/**
	 * Elimina de la base de datos el dispositivo enviado como parametro.
	 * 
	 * @param dispositivo
	 *            Objeto de la clase Dispositivo con todos los datos definidos
	 *            para el mismo.
	 * @throws MyException
	 *             Si la operacion con la base de datos falla y no puede
	 *             realizarse la eliminacion de una fila en la BD.
	 */
	public void eliminar(Dispositivo dispositivo) throws MyException;

	/**
	 * Consulta todos los Dispositivos que tengan asignado el tipo enviado como
	 * parametro.
	 * 
	 * @param tipo
	 *            Objeto de la clase Tipo.
	 * @return Lista de Dispositivos del tipo enviado como parametro.
	 * @throws MyException
	 *             Si la operacion con la base de datos falla y no puede
	 *             realizarse la consulta.
	 */
	public List<Dispositivo> consultarPorTipo(Tipo tipo) throws MyException;

	/**
	 * Consulta desde la base de datos el dispositivo con la referencia enviada
	 * como parametro.
	 * 
	 * @param referencia
	 *            String con la referencia asignada a un dispositivo especifico.
	 * @return Objeto del tipo Dispositivo con toda la informacion relacionada
	 *         con el dispositivo a consultar.
	 * @throws MyException
	 *             Si la operacion con la base de datos falla y no puede
	 *             realizarse la consulta.
	 */
	public Dispositivo consultarUno(String referencia) throws MyException;

	/**
	 * Consulta todos los dispositivos disponibles para prestamo en un rango de
	 * fechas especificado.
	 * 
	 * @param fechaInicio
	 *            Fecha inicial para la que se desea saber los dispositivos
	 *            disponibles.
	 * @param fechaFin
	 *            Fecha final del rango para saber dispositivos disponibles.
	 * @return Lista con todos los dispositivos encontrados que estan
	 *         disponibles para prestamo.
	 * @throws MyException
	 *             Lanza excepcion si hay un problema en la conexion con a base
	 *             de datos o si la consulta no se ha realizado correctamente.
	 */
	public List<String> consultarDisponibles(Date fechaInicio, Date fechaFin) throws MyException;

	/**
	 * Consulta si un dispositivo en especifico esta disponible para prestamo en
	 * un rango de fechas determinado.
	 * 
	 * @param fechaInicio
	 *            Fecha inicial del rango en que se desea saber si hay
	 *            disponibilidad del dispositivo.
	 * @param fechaFin
	 *            Fecha final del rango en que se desea saber si hay
	 *            disponibilidad del dispositivo.
	 * @param referencia
	 *            Referencia del dispositivo del que se quiere consultar la
	 *            disponibilidad.
	 * @return True, si el dispositivo esta disponible en el rango de fechas.
	 *         False, de lo contrario.
	 * @throws MyException
	 */
	public Boolean consultarDispositivoDisponible(Date fechaInicio, Date fechaFin, String referencia)
			throws MyException;
}
