package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Prestamo;
import co.edu.udea.iw.exception.MyException;

/**
 * Esta interfaz contiene la definicion de los metodos correspondientes a las
 * funciones que se podran hacer para un prestamo en relacion con el acceso a la
 * base de datos.
 * 
 * @author Carolina Isaza
 * @author Jaime Londono
 * @author Sebastian Jimenez
 *
 */
public interface PrestamoDao {

	/**
	 * Consulta todos los prestamos registrados en la base de datos.
	 * 
	 * @return Lista con los prestamos encontrados.
	 * @throws MyException
	 *             Lanza excepcion cuando hay problema con la conexion a la base
	 *             de datos y no ha podido realizarse la cosulta.
	 */
	public List<Prestamo> consultarTodos() throws MyException;

	/**
	 * Almacena un nuevo prestamo en la base de datos, con todos los atributos
	 * correspondientes.
	 * 
	 * @param prestamo
	 *            Objeto tipo prestamo que se desea almacenar y que contiene
	 *            todos los datos del prestamo.
	 * @throws MyException
	 *             Lanza excepcion cuando hay problema con la conexion a la base
	 *             de datos y no ha podido realizarse la insercion.
	 */
	public void crear(Prestamo prestamo) throws MyException;

	/**
	 * Modifica informacion del prestamo especificado como parametro.
	 * 
	 * @param prestamo
	 *            Objeto Prestamo al que se realizaran modificaciones.
	 * @throws MyException
	 *             Lanza excepcion cuando hay problema con la conexion a la base
	 *             de datos y no ha podido realizarse la actualizacion.
	 */
	public void modificar(Prestamo prestamo) throws MyException;

	/**
	 * Consulta un prestamo en especifico determinado por el identificador
	 * enviado como parametro.
	 * 
	 * @param id
	 *            Identificador del prestamo que se quiere encontrar.
	 * @return Objeto tipo Prestamo encontrado.
	 * @throws MyException
	 *             Lanza excepcion cuando hay problema con la conexion a la base
	 *             de datos y no ha podido realizarse la consulta.
	 */
	public Prestamo consultarUno(int id) throws MyException;

	/**
	 * Consulta todos los prestamos registrados en la base de datos que esten
	 * sin atender.
	 * 
	 * @return Lista con los prestamos que no han sido revisados.
	 * @throws MyException
	 *             Lanza excepcion cuando hay problema con la base de datos y no
	 *             ha podido realizarse la consulta.
	 */
	public List<Prestamo> prestamosSinRevisar() throws MyException;

	/**
	 * Consulta todos los prestamos registrados en la base de datos que esten
	 * asosciados a un usuario en especifico enviado como parametro.
	 * 
	 * @param correoUsuario
	 *            Correo electronico del usuario del que se quiere conocer los
	 *            prestamos realizados.
	 * @return Lista con los prestamos realizados por el usuario especificado.
	 * @throws MyException
	 *             Lanza excepcion cuando hay problema con la base de datos y no
	 *             ha podido realizarse la consulta.
	 */
	public List<Prestamo> prestamoPorUsuario(String correoUsuario) throws MyException;
}
