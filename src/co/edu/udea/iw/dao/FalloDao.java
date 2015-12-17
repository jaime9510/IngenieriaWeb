package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Dispositivo;
import co.edu.udea.iw.dto.Fallo;
import co.edu.udea.iw.exception.MyException;

/**
 * Esta interfaz contiene la definicion de los metodos correspondientes a las
 * funciones que se podran hacer para un Fallo en relacion con el acceso a la
 * base de datos.
 * 
 * @author Carolina Isaza
 * @author Jaime Londono
 * @author Sebastian Jimenez
 *
 */
public interface FalloDao {

	/**
	 * Consulta todos los fallos registrados en la base de datos.
	 * 
	 * @return Lista de objetos de tipo Fallo.
	 * @throws MyException
	 *             Si la operacion con la base de datos falla y no se puede
	 *             realizar la consulta.
	 */
	public List<Fallo> consultarTodos() throws MyException;

	/**
	 * Almacena en la base de datos los datos correspondientes a un nuevo Fallo
	 * reportado.
	 * 
	 * @param fallo
	 *            Objeto con todos los datos correspondientes a un fallo en un
	 *            dispositivo.
	 * @throws MyException
	 *             Si la operacion con la base de datos falla y no puede
	 *             realizarse la insercion.
	 */
	public void crear(Fallo fallo) throws MyException;

	/**
	 * Actualiza en la base de datos de los datos del fallo, el numero de
	 * identificación del fallo no podra ser actualizado.
	 * 
	 * @param fallo
	 *            Objeto con los datos correspondientes a un Fallo.
	 * @throws MyException
	 *             Si la operacion con la base de datos falla y no puede
	 *             realizarse la actualizacion de los datos.
	 */
	public void actualizar(Fallo fallo) throws MyException;

	/**
	 * Consulta los Fallos que esten reportados en la base de datos para un
	 * dispositivo especifico enviado como parametro.
	 * 
	 * @param dispositivo
	 *            Objeto del tipo Dispositivo con el que se realizara la
	 *            búsqueda.
	 * @return Lista con los fallos encontrados en la base de datos para el
	 *         dispositivo especificado.
	 * @throws MyException
	 *             Si la operacion con la base de datos falla y no puede
	 *             realizarse la consulta.
	 */
	public List<Fallo> consultarFalloPorDispositivo(Dispositivo dispositivo) throws MyException;

	/**
	 * Consulta los Fallos que esten reportados en la base de datos y para los
	 * cuales no se ha dado una solucion.
	 * 
	 * @return Lista con los Fallos que no han sido solucionados.
	 * @throws MyException
	 *             Si la operacion con la base de datos falla y no puede
	 *             realizarse la consulta.
	 */
	public List<Fallo> consultarDanosSinSolucion() throws MyException;

	/**
	 * Consulta un fallo en especifico, con el identificador enviado como
	 * parametro.
	 * 
	 * @param id
	 *            Identificador con el cual se quiere realizar la busqueda.
	 * @return Fallo encontrado.
	 * @throws MyException
	 *             Si la operacion con la base de datos falla y no puede
	 *             realizarse la consulta.
	 */
	public Fallo consultarUno(int id) throws MyException;
}
