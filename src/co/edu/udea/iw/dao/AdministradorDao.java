package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Administrador;
import co.edu.udea.iw.exception.MyException;

/**
 * Esta interfaz contiene la definicion de los metodos correspondientes a las
 * funciones que se podran hacer para un Administrador en relacion con el acceso
 * a la base de datos
 * 
 * @author Carolina Isaza
 * @author Jaime Londono
 * @author Sebastian Jimenez
 *
 */
public interface AdministradorDao {
	/**
	 * Definición del metodo con el que se consultaran todos los administradores
	 * registrados en la base de datos
	 * 
	 * @return Lista de objetos del tipo Administrador
	 * @throws MyException
	 *             Si la operación con la base de datos falla y no se puede
	 *             realizar la consulta
	 */
	public List<Administrador> mostrarTodos() throws MyException;

	/**
	 * Definicion del metodo encargado de almacenar en la BD los datos
	 * correspondientes a un nuevo administrador
	 * 
	 * @param admin
	 *            Objeto de la clase Administrador con todos los datos definidos
	 *            para el mismo
	 * @throws MyException
	 *             Si la operacion con la base de datos falla y no puede
	 *             realizarse la insercion
	 */
	public void crear(Administrador admin) throws MyException;

	/**
	 * Definicion del metodo encargado de realizar una actualizacion en la BD de
	 * los datos del administrador, el email no podra ser actualizado
	 * 
	 * @param admin
	 *            Objeto de la clase Administrador con todos los datos definidos
	 *            para el mismo
	 * @throws MyException
	 *             Si la operacion con la base de datos falla y no puede
	 *             realizarse la actualizacion de los datos
	 */
	public void actualizar(Administrador admin) throws MyException;

	/**
	 * Definicion del metodo encargado de eliminar de la BD el administrador
	 * enviado como parametro
	 * 
	 * @param admin
	 *            Objeto de la clase Administrador con todos los datos definidos
	 *            para el mismo
	 * @throws MyException
	 *             Si la operacion con la base de datos falla y no puede
	 *             realizarse la eliminacion de una fila en la BD
	 */
	public void eliminar(Administrador admin) throws MyException;

	/**
	 * Definicion del metodo con el que se consultara desde la BD el
	 * administrador con el email enviado como parametro
	 * 
	 * @param email
	 *            String con el correo electronico del administrador
	 * @return Un Objeto del tipo Administrador con los datos del administrador
	 *         consultado
	 * @throws MyException
	 *             Si la operacion con la base de datos falla y no puede
	 *             realizarse la consulta
	 */
	public Administrador consultarUno(String email) throws MyException;

}
