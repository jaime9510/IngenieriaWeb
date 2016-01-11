package co.edu.udea.iw.bl;

import java.util.Date;
import java.util.List;

import co.edu.udea.iw.dto.Prestamo;
import co.edu.udea.iw.exception.MyException;

/**
 * Esta interfaz contiene todas las funciones que permiten definir las reglas
 * del negocio con respecto a las operaciones con los prestamos de dispositivos.
 * 
 * @author Carolina Isaza
 * @author Jaime Londono
 * @author Sebastian Jimenez
 *
 */
public interface PrestamoBL {

	/**
	 * Crea un nuevo prestamo en la base de datos.
	 * 
	 * @param nombreUsuario
	 *            Nombre del usuario que realiza el prestamo.
	 * @param cedulaUsuario
	 *            Cedula del usuario que realiza el prestamo.
	 * @param correoUsuario
	 *            Correo electronico del usuario que realiza el prestamo.
	 * @param fechaInicio
	 *            Fecha en la que inicia el prestamo.
	 * @param fechaFin
	 *            Fecha en la que finaliza en prestamo.
	 * @param dispositivos
	 *            Arreglo que contiene los dispositivos a prestar.
	 * @throws MyException
	 *             Lanza excepcion cuando existe un problema en la conexion con
	 *             la base de datos, cuando alguno de los campos contiene
	 *             informacion no valida, cuando no se han seleccionado
	 *             dispositivos para prestar, cuando el administrador cuyo
	 *             correo se especifica no existe o cuando alguno de los
	 *             dispositivos no esta disponible para prestamo en las fechas
	 *             especificadas.
	 */
	public void crear(String nombreUsuario, String cedulaUsuario, String correoUsuario, Date fechaInicio, Date fechaFin,
			String[] dispositivos) throws MyException;

	/**
	 * Modifica el estado de un prestamo en especifico.
	 * 
	 * @param id
	 *            Identificador del prestamo que se desea modificar.
	 * @param correoAdministrador
	 *            Correo del administrador a cargo de dicho prestamo.
	 * @param estado
	 *            Nuevo estado a asignar al prestamo.
	 * @throws MyException
	 *             Lanza excepcion cuando existe un problema en la conexion con
	 *             la base de datos, cuando alguno de los campos contiene
	 *             informacion no valida o cuando el prestamo o el administrador
	 *             no existen.
	 */
	public void modificar(int id, String correoAdministrador, int estado) throws MyException;

	/**
	 * Consulta todos los prestamos registrados en la base de datos.
	 * 
	 * @return Lista con todos los prestamos encontrados.
	 * @throws MyException
	 *             Lanza excepcion cuando hay un problema en la conexion con la
	 *             base de datos.
	 */
	public List<Prestamo> consultarTodos() throws MyException;

	/**
	 * Consulta toda la informacion de un prestamo en especifico.
	 * 
	 * @param id
	 *            Identificador del prestamo que se quiere buscar.
	 * @return Objeto prestamo con todos los atributos correspondientes.
	 * @throws MyException
	 *             Lanza excepcion cuando existe un problema en la conexion con
	 *             la base de datos, cuando alguno de los campos contiene
	 *             informacion no valida o cuando no existe un prestamo con el
	 *             identificador especificado.
	 */
	public Prestamo consultarUno(int id) throws MyException;

	/**
	 * Consulta todos los prestamos registrados en la base de datos y que no
	 * hayan sido atendidos.
	 * 
	 * @return Lista con todos los prestamos encontrados que no hayan sido
	 *         revisados.
	 * @throws MyException
	 *             Lanza excepcion cuando existe un problema en la conexion con
	 *             la base de datos.
	 */
	public List<Prestamo> prestamosSinRevisar() throws MyException;

}
