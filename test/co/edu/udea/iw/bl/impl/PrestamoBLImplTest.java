package co.edu.udea.iw.bl.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.udea.iw.bl.PrestamoBL;
import co.edu.udea.iw.dto.Prestamo;

/**
 * En esta clase se definen casos de prueba para los metodos de la clase
 * Prestamo en cuanto a la logica del negocio.
 * 
 * @author Carolina Isaza
 * @author Jaime Londono
 * @author Sebastian Jimenez
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:SpringConf.xml")
public class PrestamoBLImplTest {

	/**
	 * Objeto de la clase Prestamo de la logica del negocio.
	 */
	@Autowired
	PrestamoBL prestamoBL;

	/**
	 * Metodo para probar la creacion de un nuevo registro de un Prestamo en la
	 * base de datos.
	 */
	@Test
	public void testCrear() {
		String nombreUsuario = "jaime";
		String cedulaUsuario = "125448";
		String correoUsuario = "jaime951@gmail.com";
		Date fechaInicio = new Date(2016, 01, 12,9 , 00, 00);
		Date fechaFin = new Date(2016, 01, 12, 16, 00, 00);
		String[] dispositivos = new String[1];
		// dispositivos[0] = "001";
		dispositivos[0] = "A0021R";
		try {
			prestamoBL.crear(nombreUsuario, cedulaUsuario, correoUsuario, fechaInicio, fechaFin, dispositivos);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo para probar la modificacion del estado de un prestamo en la base
	 * de datos.
	 */
	// @Test
	public void testModificar() {
		int id = 1;
		String correoAdministrador = "sebasj14@gmail.com";
		int estado = 1;
		try {
			prestamoBL.modificar(id, correoAdministrador, estado);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo para probar la consulta de todos los prestamos en la base de
	 * datos.
	 */
	// @Test
	public void testConsultarTodos() {
		List<Prestamo> prestamos = new ArrayList<Prestamo>();
		try {
			prestamos = prestamoBL.consultarTodos();
			assertTrue(prestamos.size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo para probar la consulta de un unico prestamo segun su
	 * identificador.
	 */
	// @Test
	public void testConsultarUno() {
		int idPrestamo = 1;
		Prestamo prestamo = new Prestamo();
		try {
			prestamo = prestamoBL.consultarUno(idPrestamo);
			assertTrue(prestamo != null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo para probar la consulta de todos los prestamos en la base de datos
	 * que no hayan sido aprobados o rechazados.
	 */
	// @Test
	public void testPrestamosSinRevisar() {
		List<Prestamo> prestamos = new ArrayList<Prestamo>();
		try {
			prestamos = prestamoBL.prestamosSinRevisar();
			assertTrue(prestamos.size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
