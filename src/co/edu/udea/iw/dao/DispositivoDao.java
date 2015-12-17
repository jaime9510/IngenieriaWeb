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
	 * Definicion del metodo con el que se consultaran todos los dispositivos
	 * registrados en la base de datos.
	 * 
	 * @return Lista de objetos del tipo dispositivo.
	 * @throws MyException
	 *             Si la operacion con la base de datos falla y no se puede
	 *             realizar la consulta.
	 */
	public List<Dispositivo> consultarTodos() throws MyException;

	/**
	 * Definicion del metodo encargado de almacenar en la BD los datos
	 * correspondientes a un nuevo dispositivo.
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
	 * Definicion del metodo encargado de realizar una actualizacion en la BD de
	 * los datos del dispositivo, el email no podrá ser actualizado.
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
	 * Definicion del metodo encargado de eliminar de la BD el dispositivo
	 * enviado como parametro.
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
	 * Definicion del metodo con el que se consultaran los Dispositivos que
	 * tengan asignado el tipo enviado como parametro.
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
	 * Definicion del metodo con el que se consultara desde la BD el dispositivo
	 * con la referencia enviada como parametro.
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

	public List<String> consultarDisponibles(Date fechaInicio, Date fechaFin) throws MyException;

	public Boolean consultarDispositivoDisponible(Date fechaInicio, Date fechaFin, String referencia)
			throws MyException;
}
