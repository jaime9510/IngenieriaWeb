package co.edu.udea.iw.bl;

import co.edu.udea.iw.exception.MyException;

/**
 * Esta interfaz contiene todas las funciones que permiten definir las reglas
 * del negocio para el rol administrador
 * 
 * @author Carolina Isaza
 * @author Jaime Londono
 * @author Sebastian Jimenez
 *
 */
public interface AdministradorBL {

	/**
	 * Realiza la validacion del inicio de sesion de un administrador,
	 * comparando el email y la contrasena con los de la base de datos,
	 * incluyendo el cifrado necesario.
	 * 
	 * @param email
	 *            String que contiene el correo electronico introducido por el
	 *            administrador.
	 * @param pass
	 *            String que contiene la contrasena introducida por el
	 *            adminsitrador.
	 * @return true si los datos son correctos, false de lo contrario.
	 * @throws MyException
	 *             Lanza excepcion cuando alguno de los campos genera
	 *             informacion no valida.
	 */
	public boolean login(String email, String pass) throws MyException;

	/**
	 * Realiza las validaciones de los parametros para garantizar que se guarde
	 * informacion no valida o repetida en la base de datos al momento de crear
	 * una cuenta de administrador.
	 * 
	 * @param email
	 *            String que contiene el correo electronico introducido para el
	 *            registro del administrador.
	 * @param contrasena
	 *            String que contiene la contrasena que se desea para el
	 *            registro del adminsitrador.
	 * @param nombre
	 *            String que contiene el nombre que se desea registrar para el
	 *            administrador.
	 * @param apellido
	 *            String que contiene el nombre que se desea registrar para el
	 *            administrador.
	 * @throws MyException
	 *             Lanza excepcion cuando alguno de los campos genera
	 *             informacion no valida.
	 */
	public void crearAdministrador(String email, String contrasena,
			String nombre, String apellido) throws MyException;

	/**
	 * Realiza las validaciones de los campos que se desean actualizar para
	 * garantizar que no se guarde informacion no valida en la base de datos, y
	 * no se actualice informacion de un administrador que no exista.
	 * 
	 * @param email
	 *            String que contiene el correo electronico introducido del
	 *            administrador que se desea actualizar.
	 * @param contrasenaNueva
	 *            String que contiene la nueva contrasena que se desea para el
	 *            administrador.
	 * @param contrasenaVieja
	 *            String que contiene la contrasena actual del administrador que
	 *            se desea actualizar.
	 * @throws MyException
	 *             Lanza excepcion cuando alguno de los campos genera
	 *             informacion no valida.
	 */
	public void actualizarPassAdministrador(String email,
			String contrasenaNueva, String contrasenaVieja) throws MyException;

	/**
	 * Realiza las validaciones de campos necesarias para la eliminacion de la
	 * cuenta de un administrador, comprobando que no sean campos vacios y que
	 * el email y contrasena sean los datos correctos.
	 * 
	 * @param email
	 *            String que contiene el email del administrador, cuya cuenta se
	 *            desea eliminar.
	 * @param contrasena
	 *            String que contiene la contrasena de la cuenta del
	 *            administrador que se desea eliminar.
	 * @throws MyException
	 *             Lanza excepcion cuando alguno de los campos genera
	 *             informacion no valida.
	 */
	public void eliminarAdministrador(String email, String contrasena)
			throws MyException;

}
