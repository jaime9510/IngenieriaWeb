package co.edu.udea.iw.dao.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.udea.iw.dao.PrestamoDao;
import co.edu.udea.iw.dto.Administrador;
import co.edu.udea.iw.dto.Prestamo;
/**
 * En esta clase se definen casos de prueba para los metodos de la clase
 * Prestamo en cuanto al acceso a la base de datos.
 * 
 * @author Carolina Isaza
 * @author Jaime Londono
 * @author Sebastian Jimenez
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:SpringConf.xml")
public class PrestamoDaoImplTest {

	/**
	 * Objeto de la clase Prestamo en cuanto al acceso a la base de datos (dao).
	 */
	@Autowired
	PrestamoDao prestamoDao;

	/**
	 * Metodo para probar la consulta de todos los prestamos en la base de
	 * datos.
	 */
	@Test
	public void testConsultarTodos() {
		List<Prestamo> prestamos = new ArrayList<Prestamo>();
		try {
			prestamos = prestamoDao.consultarTodos();
			assertTrue(prestamos.size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo para probar la creacion de un nuevo prestamo en la base de datos.
	 */
	@Test
	public void testCrear() {
		Prestamo prestamo = new Prestamo();
		Administrador admin = new Administrador();
		Date fechaIn = new Date();
		Date fechaFin = new Date(2015, 12, 18);
		admin.setEmail("carito9994@gmail.com");
		prestamo.setAdministrador(admin);
		prestamo.setCedulaUsuario("1017238258");
		prestamo.setCorreoUsuario("Jessi@gmail.com");
		prestamo.setEstado(0);
		prestamo.setFechaInicio(fechaIn);
		prestamo.setFechaFin(fechaFin);
		prestamo.setNombreUsuario("Jessica");
		try {
			prestamoDao.crear(prestamo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo para probar la actualizacion de informacion de un prestamo.
	 */
	@Test
	public void testModificar() {
		Prestamo prestamo = new Prestamo();
		Administrador admin = new Administrador();
		Date fechaIn = new Date();
		Date fechaFin = new Date();
		admin.setEmail("carito9994@gmail.com");
		prestamo.setEstado(1);
		prestamo.setAdministrador(admin);
		prestamo.setCedulaUsuario("1017238258");
		prestamo.setCorreoUsuario("Jessi@gmail.com");
		prestamo.setFechaInicio(fechaIn);
		prestamo.setFechaFin(fechaFin);
		prestamo.setNombreUsuario("Jessica");
		try {
			prestamoDao.crear(prestamo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo para probar la consulta de un unico prestamo segun su
	 * identificador
	 */
	@Test
	public void testConsultarUno() {
		Prestamo prestamo = new Prestamo();
		int id = 1;
		try {
			prestamo = prestamoDao.consultarUno(id);
			assertTrue(prestamo != null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo para probar la consulta de los prestamos sin revisar.
	 */
	@Test
	public void testPrestamosSinRevisar() {
		List<Prestamo> prestamos = new ArrayList<Prestamo>();
		try {
			prestamos = prestamoDao.prestamosSinRevisar();
			assertTrue(prestamos.size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo para probar la consulta de los prestamos realizados por un usuario.
	 */
	@Test
	public void testPrestamoPorUsuario() {
		List<Prestamo> prestamos = new ArrayList<Prestamo>();
		String email = "Jessi@gmail.com";
		try {
			prestamos = prestamoDao.prestamoPorUsuario(email);
			assertTrue(prestamos.size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
