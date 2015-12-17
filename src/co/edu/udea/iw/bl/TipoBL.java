package co.edu.udea.iw.bl;

import java.util.List;

import co.edu.udea.iw.dto.Tipo;
import co.edu.udea.iw.exception.MyException;

/**
 * Esta interfaz contiene todas las funciones que permiten definir las reglas
 * del negocio con respecto a las operaciones referentes a los tipos de
 * dispositivos.
 * 
 * @author Carolina Isaza
 * @author Jaime Londono
 * @author Sebastian Jimenez
 *
 */
public interface TipoBL {

	/**
	 * Crea un nuevo tipo de dispositivo.
	 * 
	 * @param nombre
	 *            Nombre del tipo de dispositivo a crear.
	 * @throws MyException
	 *             Lanza excepcion cuando existe un problema en la conexion con
	 *             la base de datos, cuando alguno de los campos contiene
	 *             informacion no valida o cuando ya existe un tipo de
	 *             dispositivo con el nombre especificado.
	 */
	public void crear(String nombre) throws MyException;

	/**
	 * Consulta un tipo de dispositivo, especificando el identificador.
	 * 
	 * @param id
	 *            Identificador del tipo de dispositivo a consultar.
	 * @return Objeto Tipo con los atributos del tipo de dispositivo encontrado.
	 * @throws MyException
	 *             Lanza excepcion cuando existe un problema en la conexion con
	 *             la base de datos, cuando alguno de los campos contiene
	 *             informacion no valida o cuando no existe un tipo de
	 *             dispositivo con el identificador especificado.
	 */
	public Tipo consultarUno(int id) throws MyException;

	/**
	 * Consulta todos los tipos de dispositivos almacenados en la base de datos.
	 * 
	 * @return Lista con todos los tipos de dispositivo encontrados.
	 * @throws MyException
	 *             Lanza excepcion cuando existe un problema en la conexion con
	 *             la base de datos o cuando no se encuentran tipos de
	 *             dispositivo.
	 */
	public List<Tipo> consultarTodos() throws MyException;

}
