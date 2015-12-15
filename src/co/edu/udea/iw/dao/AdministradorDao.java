package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Administrador;
import co.edu.udea.iw.exception.MyException;

/**
 * Esta interaz contiene la definición de los métodos correspondientes a las
 * funciones que se podrán hacer para un Administrador en relación con el acceso
 * a la base de datos
 * 
 * @author Carolina Isaza
 * @author Jaime Londoño
 * @author Sebastián Jiménez
 *
 */
public interface AdministradorDao {
	/**
	 * Definición del método con el que se consultarán todos los administradores
	 * registrados en la base de datos
	 * 
	 * @return Lista de objetos del tipo Administrador
	 * @throws MyException
	 *             Si la operación con la base de datos falla y no se puede
	 *             realizar la consulta
	 */
	public List<Administrador> mostrarTodos() throws MyException;

	/**
	 * Definición del método encargado de almacenar en la BD los datos
	 * correspondientes a un nuevo administrador
	 * 
	 * @param admin
	 *            Objeto de la clase Administrador con todos los datos definidos
	 *            para el mismo
	 * @throws MyException
	 *             Si la operación con la base de datos falla y no puede
	 *             realizarse la inserción
	 */
	public void crear(Administrador admin) throws MyException;

	/**
	 * Definición del método encargado de realizar una actualización en la BD de
	 * los datos del administrador, el email no podrá ser actualizado
	 * 
	 * @param admin
	 *            Objeto de la clase Administrador con todos los datos definidos
	 *            para el mismo
	 * @throws MyException
	 *             Si la operación con la base de datos falla y no puede
	 *             realizarse la actualización de los datos
	 */
	public void actualizar(Administrador admin) throws MyException;

	/**
	 * Definición del método encargado de eliminar de la BD el administrador
	 * enviado como parámetro
	 * 
	 * @param admin
	 *            Objeto de la clase Administrador con todos los datos definidos
	 *            para el mismo
	 * @throws MyException
	 *             Si la operación con la base de datos falla y no puede
	 *             realizarse la eliminación de una fila en la BD
	 */
	public void eliminar(Administrador admin) throws MyException;

	/**
	 * Definición del método con el que se consultará desde la BD el
	 * administrador con el email enviado como parámetro
	 * 
	 * @param email
	 *            String con el correo electrónico del administrador
	 * @return Un Objeto del tipo Administrador con los datos del administrador
	 *         consultado
	 * @throws MyException
	 *             Si la operación con la base de datos falla y no puede
	 *             realizarse la consulta
	 */
	public Administrador consultarUno(String email) throws MyException;

}
