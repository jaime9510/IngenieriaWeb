package co.edu.udea.iw.bl;

import java.util.List;

import co.edu.udea.iw.dto.Administrador;
import co.edu.udea.iw.exception.MyException;

/**
 * Esta interfaz contiene todas las funciones que permiten definir las
 * regras del negocio para el usuario administrador
 * @author Carolina Isaza
 * @author Jaime Londoño
 * @author Sebastián Jiménez
 * 
 *
 */
public interface AdministradorBL {

	public List<Administrador> mostrarTodos() throws MyException;

	public boolean login(String email, String pass) throws MyException;

	public void crearAdministrador(String email, String contrasena, String nombre, String apellido) throws MyException;

	public void actualizarAdministrador(String email, String contrasena, String nombre, String apellido)
			throws MyException;

	public void eliminarAdministrador(String email, String contrasena)throws MyException;
	
	
}
