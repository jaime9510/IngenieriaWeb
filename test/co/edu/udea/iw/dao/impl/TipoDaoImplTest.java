package co.edu.udea.iw.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.TipoDao;
import co.edu.udea.iw.dto.Administrador;
import co.edu.udea.iw.dto.Tipo;
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
public class TipoDaoImplTest {

	/**
	 * Objeto de la clase Tipo en cuanto al acceso a la base de datos (dao).
	 */
	@Autowired
	TipoDao tipoDao;

	/**
	 * Metodo para probar la consulta de todos los tipos de dispositivos en la
	 * base de datos.
	 */
	@Test
	public void testConsultarTodos() {
		List<Tipo> tipos = null;
		try {
			tipos = tipoDao.consultarTodos();
			Assert.assertTrue(tipos.size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo para probar la creacion de un nuevo tipo en la base de datos.
	 */
	@Test
	public void testCrear() {
		Tipo tipo = new Tipo();
		tipo.setNombre("Tablet");
		try {
			tipoDao.crear(tipo);
			Assert.assertTrue(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo para probar la consulta de un unico tipo de dispositivo segun su
	 * correo electronico.
	 */
	@Test
	public void testConsultarUno() {
		Tipo tipo = new Tipo();
		int id = 1;
		try {
			tipo = tipoDao.consultarUno(id);
			Assert.assertTrue(tipo != null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo para probar la consulta de un unico tipo de dispositivo segun su
	 * nombre
	 */
	@Test
	public void testConsultarPorNombre() {
		Tipo tipo = new Tipo();
		String nombre = "Tablet";
		try {
			tipo = tipoDao.consultarPorNombre(nombre);
			assertTrue(tipo != null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
