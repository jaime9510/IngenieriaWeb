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

import co.edu.udea.iw.bl.DispositivoBL;
import co.edu.udea.iw.dto.Dispositivo;

/**
 * En esta clase se definen casos de prueba para los metodos de la clase 
 * Dispositivo en cuanto a la logica del negocio.
 * 
 * @author Carolina Isaza
 * @author Jaime Londono
 * @author Sebastian Jimenez
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:SpringConf.xml")
public class DispositivoBLImplTest {

	/**
	 * Objeto de la clase Dispositivo de la logica del negocio.
	 */
	@Autowired
	DispositivoBL dispositivoBL;

	/**
	 * Metodo para probar la consulta de todos los registros de Dispositivos en la base de datos.
	 */
	@Test
	public void testConsultarTodos() {
		List<Dispositivo> dispositivos = new ArrayList<Dispositivo>();
		try {
			dispositivos = dispositivoBL.consultarTodos();
			assertTrue(dispositivos.size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo para probar la creacion de un nuevo dispositivo en la base de datos.
	 */
	@Test
	public void testCrearDispositivo() {
		String referencia = "A0021R";
		String nombre = "Motorola G primera generacion";
		String descripcion = "1 GB de RAM";
		int tipo = 1;
		String foto = "url";
		String emailAdministrador = "sebasj14@gmail.com";
		try {
			dispositivoBL.crearDispositivo(referencia, nombre, descripcion, tipo, foto, emailAdministrador);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * Metodo para probar la actualizacion de datos de un dispositivo en la base de datos.
	 */
	@Test
	public void testActualizarDispositivo() {
		String referencia = "A0021R";
		String nombre = "Motorola G primera generacion";
		String descripcion = "1 GB de RAM";
		int tipo = 1;
		String foto = "url";
		boolean disponible = false;
		String emailAdministrador = "sebasj14@gmail.com";
		try {
			dispositivoBL.actualizarDispositivo(referencia, nombre, descripcion, tipo, foto, disponible,
					emailAdministrador);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo para probar la consulta de todos los dispositivos de un tipo en especifico.
	 */
	@Test
	public void testConsultarPorTipo() {
		List<Dispositivo> dispositivos = new ArrayList<Dispositivo>();
		int idTipo = 1;
		try {
			dispositivos = dispositivoBL.consultarPorTipo(idTipo);
			assertTrue(dispositivos.size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo para probar la consulta de un dispositivo en especifico.
	 */
	@Test
	public void testConsultarUno() {
		Dispositivo dispositivo = new Dispositivo();
		String referencia = "A0021R";
		try {
			dispositivo = dispositivoBL.consultarUno(referencia);
			assertTrue(dispositivo != null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Metodo para probar la consulta de todos los dispositivos que esten disponibles para prestamo.
	 */
	@Test
	public void testMostrarDispositivosDisponibles(){
		Date fechaInicio = new Date(2015,12,18,15,00);
		Date fechaFin = new Date(2015,12,18,16,00);
		List<Dispositivo> dispositivos = new ArrayList<Dispositivo>();
		try{
			dispositivos = dispositivoBL.mostrarDispositivosDisponibles(fechaInicio, fechaFin);
			assertTrue(dispositivos.size()>0);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
