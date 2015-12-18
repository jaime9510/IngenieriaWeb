package co.edu.udea.iw.bl;

import java.util.List;

import co.edu.udea.iw.dto.Fallo;
import co.edu.udea.iw.exception.MyException;

/**
 * Esta interfaz contiene todas las funciones que permiten definir las reglas
 * del negocio con respecto a las operaciones con los fallos en dispositivos.
 * 
 * @author Carolina Isaza
 * @author Jaime Londono
 * @author Sebastian Jimenez
 *
 */
public interface FalloBL {

	/**
	 * Consulta todos los fallos registrados de todos los dispositivos en la
	 * base de datos.
	 * 
	 * @return Lista con todos los fallos encontrados.
	 * @throws MyException
	 *             Lanza excepcion cuando hay problema con la conexion a la base
	 *             de datos.
	 */
	public List<Fallo> consultarTodos() throws MyException;

	/**
	 * Crea un nuevo fallo para un dispositivo.
	 * 
	 * @param idFallo
	 *            Identificador del fallo.
	 * @param error
	 *            Descripcion del fallo y fecha de deteccion.
	 * @param referenciaDispositivo
	 *            Referencia del dispositivo en el cual fue encontrado el fallo.
	 * @throws MyException
	 *             Lanza excepcion cuando hay problema con la conexion a la base
	 *             de datos, cuando alguno de los campos contiene informacion no
	 *             valida, cuando el dispositivo al cual se le quiere asociar el
	 *             fallo no existe o cuando ya existe un fallo con el mismo
	 *             identificador.
	 */
	public void crearFallo(int idFallo, String error, String referenciaDispositivo) throws MyException;

	/**
	 * Actualiza el estado de un fallo, de acuerdo a si esta solucionado o no.
	 * 
	 * @param idFallo
	 *            Identificador del fallo a actualizar.
	 * @param solucionado
	 *            Boolean para especificar si el fallo ha sido solucionado o no.
	 * @throws MyException
	 *             Lanza excepcion cuando hay problema con la conexion a la base
	 *             de datos, cuando algun campo contiene informacion no valida o
	 *             cuando el fallo a actualizar no existe.
	 */
	public void actualizarFallo(int idFallo, boolean solucionado) throws MyException;

	/**
	 * Consulta todos los fallos registrados para un dispositivo en especifico.
	 * 
	 * @param referenciaDispositivo
	 *            Referencia del dispositivo del que se quieren conocer los
	 *            fallos.
	 * @return Lista con todos los fallos encontrados para el dispositivo
	 *         especificado.
	 * @throws MyException
	 *             Lanza excepcion cuando hay problema con la conexion a la base
	 *             de datos, cuando alguno de los campos contiene informacion no
	 *             valida o cuando el dispositivo especificado no existe.
	 */
	public List<Fallo> consultarFalloPorDispositivo(String referenciaDispositivo) throws MyException;

	/**
	 * Consulta todos los fallos registrados en la base de datos y que no esten
	 * solucionados.
	 * 
	 * @return Lista con todos los fallos encontrados.
	 * @throws MyException
	 *             Lanza excepcion cuando hay problema con la conexion a la base
	 *             de datos.
	 */
	public List<Fallo> consultarDanosSinSolucion() throws MyException;

	/**
	 * Consulta toda la informacion referente a un fallo en especifico.
	 * 
	 * @param id
	 *            Identificador del fallo a consultar.
	 * @return Objeto fallo con todos los atributos de este.
	 * @throws MyException
	 *             Lanza excepcion cuando hay problema con la conexion a la base
	 *             de datos, cuando algun campo contiene informacion no valida o
	 *             cuando el fallo especificado no existe.
	 */
	public Fallo consultarUno(int id) throws MyException;

}
