package co.edu.udea.iw.bl.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.udea.iw.bl.AdministradorBL;
import co.edu.udea.iw.exception.MyException;


/**
 * En esta clase se definen casos de prueba para los metodos de la clase 
 * Administrador en cuanto a la logica del negocio.
 * 
 * @author Carolina Isaza
 * @author Jaime Londono
 * @author Sebastian Jimenez
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:SpringConf.xml")
public class AdministradorBLImplTest {

	/**
	 * Objeto de la clase Administrador de la logica del negocio.
	 */
	@Autowired
	AdministradorBL administradorBL;

	/**
	 * Metodo para probar el login de un administrador.
	 */
	@Test
	public void testLogin() {
		String email = "sebasj14@gmail.com";
		String contrasena = "sebasj14";
		try {
			boolean logueado = administradorBL.login(email, contrasena);
			assertTrue(logueado);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo para probar la creacion de un nuevo administrador en la base de datos.
	 */
	@Test
	public void testCrearAdministrador() {
		String nombre = "Sebastian";
		String apellidos = "Jimenez";
		String contrasena = "sebasj14";
		String email = "sebasj14@gmail.com";
		try {
			administradorBL.crearAdministrador(email, contrasena, nombre,
					apellidos);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * Metodo para probar la actualizacion de informacion de un administrador.
	 */
	@Test
	public void testActualizarAdministrador() {
		String contrasenaNueva = "sebas";
		String contrasenaVieja = "sebasj14";
		String email = "sebasj14@gmail.com";
		try {
			administradorBL.actualizarPassAdministrador(email, contrasenaNueva,
					contrasenaVieja);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * Metodo para probar la eliminacion de informacion de un administrador.
	 */
	@Test
	public void testEliminarAdministrador() {
		String email = "sebasj14@gmail.com";
		String contrasena = "sebasj14";
		try {
			administradorBL.eliminarAdministrador(email, contrasena);
		} catch (MyException e) {
			e.printStackTrace();
		}
	}

}
