package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Administrador;
import co.edu.udea.iw.exception.MyException;

/**
 * Esta interaz contiene la definici�n de los m�todos correspondientes a las
 * funciones que se podr�n hacer para un Administrador en relaci�n con el acceso
 * a la base de datos
 * 
 * @author Carolina Isaza
 * @author Jaime Londo�o
 * @author Sebasti�n Jim�nez
 *
 */
public interface AdministradorDao {
	/**
	 * Definici�n del m�todo con el que se consultar�n todos los administradores
	 * registrados en la base de datos
	 * 
	 * @return Lista de objetos del tipo Administrador
	 * @throws MyException
	 *             Si la operaci�n con la base de datos falla y no se puede
	 *             realizar la consulta
	 */
	public List<Administrador> mostrarTodos() throws MyException;

	/**
	 * Definici�n del m�todo encargado de almacenar en la BD los datos
	 * correspondientes a un nuevo administrador
	 * 
	 * @param admin
	 *            Objeto de la clase Administrador con todos los datos definidos
	 *            para el mismo
	 * @throws MyException
	 *             Si la operaci�n con la base de datos falla y no puede
	 *             realizarse la inserci�n
	 */
	public void crear(Administrador admin) throws MyException;

	/**
	 * Definici�n del m�todo encargado de realizar una actualizaci�n en la BD de
	 * los datos del administrador, el email no podr� ser actualizado
	 * 
	 * @param admin
	 *            Objeto de la clase Administrador con todos los datos definidos
	 *            para el mismo
	 * @throws MyException
	 *             Si la operaci�n con la base de datos falla y no puede
	 *             realizarse la actualizaci�n de los datos
	 */
	public void actualizar(Administrador admin) throws MyException;

	/**
	 * Definici�n del m�todo encargado de eliminar de la BD el administrador
	 * enviado como par�metro
	 * 
	 * @param admin
	 *            Objeto de la clase Administrador con todos los datos definidos
	 *            para el mismo
	 * @throws MyException
	 *             Si la operaci�n con la base de datos falla y no puede
	 *             realizarse la eliminaci�n de una fila en la BD
	 */
	public void eliminar(Administrador admin) throws MyException;

	/**
	 * Definici�n del m�todo con el que se consultar� desde la BD el
	 * administrador con el email enviado como par�metro
	 * 
	 * @param email
	 *            String con el correo electr�nico del administrador
	 * @return Un Objeto del tipo Administrador con los datos del administrador
	 *         consultado
	 * @throws MyException
	 *             Si la operaci�n con la base de datos falla y no puede
	 *             realizarse la consulta
	 */
	public Administrador consultarUno(String email) throws MyException;

}
