package co.edu.udea.iw.bl;

import java.util.List;

import co.edu.udea.iw.dto.Administrador;
import co.edu.udea.iw.exception.MyException;

/**
 * Esta interfaz contiene todas las funciones que permiten definir las
 * reglas del negocio para el usuario administrador
 * @author Carolina Isaza
 * @author Jaime Londo�o
 * @author Sebasti�n Jim�nez
 * 
 *
 */
public interface AdministradorBL {


	/**
	 * Realiza la validacion del inicio de sesion de un administrador, 
	 * comparando el email y la contrasena con los de la base de datos, 
	 * incluyendo el cifrado necesario.
	 * @param email String que contiene el correo electronico introducido por el administrador.
	 * @param pass String que contiene la contrasena introducida por el adminsitrador.
	 * @return true si los datos son correctos, false de lo contrario.
	 * @throws MyException
	 */
	public boolean login(String email, String pass) throws MyException;

	/**
	 * 
	 * @param email
	 * @param contrasena
	 * @param nombre
	 * @param apellido
	 * @throws MyException
	 */
	public void crearAdministrador(String email, String contrasena, String nombre, String apellido) throws MyException;

	/**
	 * @param email
	 * @param contrasena
	 * @param nombre
	 * @param apellido
	 * @throws MyException
	 */
	public void actualizarAdministrador(String email, String contrasena, String nombre, String apellido)
			throws MyException;

	/**
	 * @param email
	 * @param contrasena
	 * @throws MyException
	 */
	public void eliminarAdministrador(String email, String contrasena)throws MyException;
	
	
}
