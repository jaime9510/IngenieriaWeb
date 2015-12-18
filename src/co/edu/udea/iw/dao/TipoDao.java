package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Tipo;
import co.edu.udea.iw.exception.MyException;

/**
 * Esta interfaz contiene la definicion de los metodos correspondientes a las
 * funciones que se podran hacer para un Tipo de Dispositivo en relacion con el
 * acceso a la base de datos.
 * 
 * @author Carolina Isaza
 * @author Jaime Londono
 * @author Sebastian Jimenez
 *
 */
public interface TipoDao {

	/**
	 * Consulta todos los Tipos de dispositivos registrados en la base de datos.
	 * 
	 * @return Lista de objetos de tipo Tipo.
	 * @throws MyException
	 *             Si la operacion con la base de datos falla y no se puede
	 *             realizar la consulta.
	 */
	public List<Tipo> consultarTodos() throws MyException;

	/**
	 * Almacena en la base de datos los datos correspondientes a un nuevo Tipo
	 * de dispositivo.
	 * 
	 * @param tipo
	 *            Objeto Tipo con los datos que seran almacenados en la base de
	 *            datos.
	 * @throws MyException
	 *             Si la operacion con la base de datos falla y no puede
	 *             realizarse la insercion.
	 */
	public void crear(Tipo tipo) throws MyException;

	/**
	 * Consulta desde la base de datos el Tipo cuyo id es enviado como
	 * parametro.
	 * 
	 * @param id
	 *            Entero que permite la identificacion de un tipo de
	 *            dispositivo.
	 * @return Objeto Tipo con los datos del tipo al que le pertenece el id
	 *         consultado.
	 * @throws MyException
	 *             Si la operacion con la base de datos falla y no puede
	 *             realizarse la consulta.
	 */
	public Tipo consultarUno(int id) throws MyException;

	/**
	 * Consulta en la base de datos el tipo de dispositivo cuyo nombre es
	 * enviado como parametro.
	 * 
	 * @param nombre
	 *            Nombre del tipo de dispositivo que quiere encontrarse.
	 * @return Objeto Tipo con los datos del tipo de dispositivo cuyo nombre fue
	 *         especificado.
	 * @throws MyException
	 *             Si la operacion con la base de datos falla y no puede
	 *             realizarse la consulta.
	 */
	public Tipo consultarPorNombre(String nombre) throws MyException;
}
