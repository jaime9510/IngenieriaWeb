package co.edu.udea.iw.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.AdministradorDao;
import co.edu.udea.iw.dto.Administrador;
import junit.framework.Assert;

/**
 * En esta clase se definen casos de prueba para los metodos de la clase
 * Administrador en cuanto al acceso a la base de datos.
 * 
 * @author Carolina Isaza
 * @author Jaime Londono
 * @author Sebastian Jimenez
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:SpringConf.xml")
public class AdministradorDaoImplTest {

	/**
	 * Objeto de la clase Administrador en cuanto al acceso a la base de datos
	 * (dao).
	 */
	@Autowired
	AdministradorDao administradorDao;

	/**
	 * Metodo para probar la consulta de todos los administradores en la base de
	 * datos.
	 */
	@Test
	public void testMostrarTodos() {
		List<Administrador> administradores = null;
		try {
			administradores = administradorDao.mostrarTodos();
			Assert.assertTrue(administradores.size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo para probar la creacion de un nuevo administrador en la base de
	 * datos.
	 */
	@Test
	public void testCrear() {
		Administrador admin = new Administrador();
		admin.setEmail("carito9994@gmail.com");
		admin.setNombre("Carolina");
		admin.setApellidos("Isaza");
		admin.setContrasena("123");
		try {
			administradorDao.crear(admin);
			Assert.assertTrue(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo para probar la actualizacion de informacion de un administrador.
	 */
	@Test
	public void testActualizar() {
		Administrador admin = new Administrador();
		admin.setEmail("carito9994@gmail.com");
		admin.setNombre("Carolina");
		admin.setApellidos("Isaza");
		admin.setContrasena("caro");
		try {
			administradorDao.actualizar(admin);
			Assert.assertTrue(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo para probar la eliminacion de informacion de un administrador.
	 */
	@Test
	public void testEliminar() {
		Administrador admin = new Administrador();
		admin.setEmail("carito9994@gmail.com");

		try {
			administradorDao.eliminar(admin);
			Assert.assertTrue(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo para probar la consulta de un unico administrador segun su correo
	 * electronico.
	 */
	@Test
	public void testConsultarUno() {
		Administrador admin;
		String email = "carito9994@gmail.com";
		try {
			admin = administradorDao.consultarUno(email);
			Assert.assertTrue(admin != null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
