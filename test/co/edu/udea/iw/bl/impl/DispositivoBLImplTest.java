package co.edu.udea.iw.bl.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.bl.DispositivoBL;
import co.edu.udea.iw.dto.Dispositivo;
import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:SpringConf.xml")

public class DispositivoBLImplTest {

	@Autowired
	DispositivoBL dispositivoBL;

	@Test
	public void testConsultarTodos() {
		List<Dispositivo> dispositivos = new ArrayList<Dispositivo>();
		try {
			dispositivos = dispositivoBL.consultarTodos();
			Assert.assertTrue(dispositivos.size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testCrearDispositivo() {
		String referencia = "A0021R";
		String nombre = "Motorola G primera generación";
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

	// @Test
	public void testActualizarDispositivo() {
		String referencia = "A0021R";
		String nombre = "Motorola G primera generación";
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

	@Test
	public void testEliminarDispositivo() {

	}

	@Test
	public void testConsultarPorTipo() {
		List<Dispositivo> dispositivos = new ArrayList<Dispositivo>();
		int idTipo = 1;
		try {
			dispositivos = dispositivoBL.consultarPorTipo(idTipo);
			Assert.assertTrue(dispositivos.size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testConsultarDisponibles() {
		List<Dispositivo> dispositivos = new ArrayList<Dispositivo>();
		try {
			dispositivos = dispositivoBL.consultarDisponibles();
			Assert.assertTrue(dispositivos.size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testConsultarUno() {
		Dispositivo dispositivo = new Dispositivo();
		String referencia = "A0021R";
		try {
			dispositivo = dispositivoBL.consultarUno(referencia);
			Assert.assertTrue(dispositivo != null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
