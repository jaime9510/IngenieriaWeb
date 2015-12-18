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
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.DispositivoDao;
import co.edu.udea.iw.dto.Dispositivo;
import co.edu.udea.iw.dto.Tipo;
import junit.framework.Assert;

/**
 * En esta clase se definen casos de prueba para los metodos de la clase
 * Dispositivo en cuanto al acceso a la base de datos.
 * 
 * @author Carolina Isaza
 * @author Jaime Londono
 * @author Sebastian Jimenez
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:SpringConf.xml")
public class DispositivoDaoImplTest {

	/**
	 * Objeto de la clase Dispositivo en cuanto al acceso a la base de datos
	 * (dao).
	 */
	@Autowired
	DispositivoDao dispositivoDao;

	/**
	 * Metodo para probar la consulta de todos los dispositivos registrados en
	 * la base de datos.
	 */
	@Test
	public void testConsultarTodos() {
		List<Dispositivo> dispositivos = new ArrayList<Dispositivo>();
		try {
			dispositivos = dispositivoDao.consultarTodos();
			Assert.assertTrue(dispositivos.size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo para probar la creacion de un nuevo dispositivo en la base de
	 * datos.
	 */
	@Test
	public void testCrear() {
		Dispositivo dispositivo = new Dispositivo();
		dispositivo.setReferencia("001");
		dispositivo.setDescripcion("hola");
		dispositivo.setDisponible(true);
		dispositivo.setNombre("Note 10.1");
		dispositivo.setFoto("link");
		Tipo tipo = new Tipo();
		tipo.setId(1);
		// tipo.setNombre("Tablet");
		dispositivo.setTipo(tipo);
		try {
			dispositivoDao.crear(dispositivo);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Metodo para probar la actualizacion de informacion de un dispositivo.
	 */
	@Test
	public void testActualizar() {
		Dispositivo dispositivo = new Dispositivo();
		dispositivo.setReferencia("001");
		dispositivo.setDescripcion("10 pulgadas, 1 GB de RAM");
		dispositivo.setDisponible(true);
		dispositivo.setNombre("Note 10.1");
		dispositivo.setFoto("link");
		Tipo tipo = new Tipo();
		tipo.setId(1);
		dispositivo.setTipo(tipo);
		try {
			dispositivoDao.actualizar(dispositivo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo para probar la eliminacion de informacion de un dispositivo.
	 */
	@Test
	public void testEliminar() {
		Dispositivo dispositivo = new Dispositivo();
		dispositivo.setReferencia("001");

		try {
			dispositivoDao.eliminar(dispositivo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo para probar la consulta de todos los dispositivos de un tipo en
	 * especifico.
	 */
	@Test
	public void testConsultarPorTipo() {
		List<Dispositivo> dispositivos = new ArrayList<Dispositivo>();
		Tipo tipo = new Tipo();
		tipo.setId(1);
		try {
			dispositivos = dispositivoDao.consultarPorTipo(tipo);
			Assert.assertTrue(dispositivos.size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo para probar la consulta de un unico dispositivo segun su
	 * referencia.
	 */
	@Test
	public void testConsultarUno() {
		Dispositivo dispositivo;
		String referencia = "001";
		try {
			dispositivo = dispositivoDao.consultarUno(referencia);
			Assert.assertTrue(dispositivo != null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo para probar la consulta de disponibilidad de un dispositivo en un
	 * rango de fechas especifico.
	 */
	@Test
	public void testConsultarDispositivoDisponible() {
		Boolean disponible;
		Date fechaInicio = new Date();
		Date fechaFin = new Date();
		String referencia = "001";
		try {
			disponible = dispositivoDao.consultarDispositivoDisponible(
					fechaInicio, fechaFin, referencia);
			Assert.assertTrue(disponible);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo para probar la consulta de todos los dipositivos en la base de
	 * datos que esten disponibles para prestamo.
	 */
	@Test
	public void testConsultarDisponibles() {
		List<String> dispositivos = new ArrayList<String>();
		Date fechaInicio = new Date();
		Date fechaFin = new Date();

		try {
			dispositivos = dispositivoDao.consultarDisponibles(fechaInicio,
					fechaFin);
			Assert.assertTrue(dispositivos.size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
