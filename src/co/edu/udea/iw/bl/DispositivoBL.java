package co.edu.udea.iw.bl;

import java.util.Date;
import java.util.List;

import co.edu.udea.iw.dto.Dispositivo;
import co.edu.udea.iw.exception.MyException;

/**
 * Esta interfaz contiene todas las funciones que permiten definir las reglas
 * del negocio con respecto a las operaciones con dispositivos.
 * 
 * @author Carolina Isaza
 * @author Jaime Londono
 * @author Sebastian Jimenez
 *
 */
public interface DispositivoBL {

	/**
	 * Consulta todos los dipositivos registrados en la base de datos.
	 * 
	 * @return Lista de los dispositivos encontrados.
	 * @throws MyException
	 *             Lanza excepcion cuando cuando alguno de los campos contiene
	 *             informacion no valida.
	 */
	public List<Dispositivo> consultarTodos() throws MyException;

	/**
	 * Crea un nuevo dispositivo en la base de datos.
	 * 
	 * @param referencia
	 *            String con el identificador del dispositivo a crear.
	 * @param nombre
	 *            Nombre del dispositivo.
	 * @param descripcion
	 *            Descripcion y caracteristicas tecnicas del dispositivo a
	 *            crear.
	 * @param tipo
	 *            Describe el tipo de dispositivo (proyector, ordenador, movil,
	 *            etc).
	 * @param foto
	 *            Enlace a internet con una foto del dispositivo.
	 * @param emailAdministrador
	 *            Correo electronico del administrador que agrega el
	 *            dispositivo.
	 * @throws MyException
	 *             Lanza excepcion cuando cuando alguno de los campos contiene
	 *             informacion no valida o ya existe un dispositivo con la
	 *             referencia especificada.
	 */
	public void crearDispositivo(String referencia, String nombre,
			String descripcion, int tipo, String foto, String emailAdministrador)
			throws MyException;

	/**
	 * Actualiza la informacion de un dispositivo almacenado en la base datos, a
	 * excepcion de la referencia del dispositivo.
	 * 
	 * @param referencia
	 *            String con el identificador del dispositivo a actualizar.
	 * @param nombre
	 *            Nuevo nombre a asignar al dispositivo.
	 * @param descripcion
	 *            Descripcion y caracteristicas nuevos del dispositivo.
	 * @param tipo
	 *            Tipo del dispositivo que se quiere actualizar.
	 * @param foto
	 *            Nuevo enlace a la foto del dispositivo.
	 * @param disponible
	 *            Boolean especificando si el dispositivo esta disponible a
	 *            prestamo.
	 * @param emailAdministrador
	 *            Correo electronico del administrador que realiza la
	 *            actualizacion de datos.
	 * @throws MyException
	 *             Lanza excepcion cuando cuando alguno de los campos contiene
	 *             informacion no valida o no existe un dispositivo con la
	 *             referencia especificada.
	 */
	public void actualizarDispositivo(String referencia, String nombre,
			String descripcion, int tipo, String foto, boolean disponible,
			String emailAdministrador) throws MyException;

	/**
	 * Elimina un dispositivo registrado en la base de datos.
	 * 
	 * @param referencia
	 *            String con la referencia del dispositivo que se desea
	 *            eliminar.
	 * @param emailAdministrador
	 *            Correo electronico del administrador que realiza la operacion.
	 * @throws MyException
	 *             Lanza excepcion cuando cuando alguno de los campos contiene
	 *             informacion no valida o no existe el dispositivo que se
	 *             quiere eliminar.
	 */
	public void eliminarDispositivo(String referencia, String emailAdministrador)
			throws MyException;

	/**
	 * Consulta todos los dispositivos almacenados en la base de datos, cuyo
	 * tipo sea el especificado como parametro.
	 * 
	 * @param tipo
	 *            Entero que especifica el tipo de dispositivos que se quiere
	 *            encontrar.
	 * @return Lista con todos los dispositivos del tipo especificado.
	 * @throws MyException
	 *             Lanza excepcion cuando alguno de los campos contiene
	 *             informacion no valida o no existen dispositivos del tipo
	 *             especificado.
	 */
	public List<Dispositivo> consultarPorTipo(int tipo) throws MyException;

	/**
	 * Consulta toda la informacion del dispositivo cuya referencia es enviada
	 * como parametro.
	 * 
	 * @param referencia
	 *            String con la referencia del dispositivo que se quiere buscar.
	 * @return Objeto dispositivo encontrado.
	 * @throws MyException
	 *             Lanza excepcion cuando alguno de los campos contiene
	 *             informacion no valida o el dispositivo no existe.
	 */
	public Dispositivo consultarUno(String referencia) throws MyException;

	/**
	 * Muestra los dispositivos disponibles para prestamo en un rango de fechas
	 * especificado.
	 * 
	 * @param fechaInicio
	 *            Fecha inicial en la que se desea hacer la consulta de
	 *            disponibilidad de dispositivos.
	 * @param fechaFin
	 *            Fecha final en la que se desea hacer la consulta de
	 *            disponibilidad de dispositivos.
	 * @return Lista de dispositivos que esten disponibles en las fechas
	 *         indicadas.
	 */
	public List<Dispositivo> mostrarDispositivosDisponibles(Date fechaInicio,
			Date fechaFin);
}
