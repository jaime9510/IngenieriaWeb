package co.edu.udea.iw.bl.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.xml.crypto.dsig.spec.ExcC14NParameterSpec;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.udea.iw.bl.TipoBL;
import co.edu.udea.iw.dto.Tipo;

/**
 * En esta clase se definen casos de prueba para los metodos de la clase Tipo de
 * Dispositivo en cuanto a la logica del negocio.
 * 
 * @author Carolina Isaza
 * @author Jaime Londono
 * @author Sebastian Jimenez
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:SpringConf.xml")
public class TipoBLTestImpl {

	/**
	 * Objeto de la clase Administrador de la logica del negocio.
	 */
	@Autowired
	TipoBL tipoBL;

	/**
	 * Metodo para probar la creacion de un nuevo tipo de dispositivo en la base
	 * de datos.
	 */
	@Test
	public void testCrear() {
		String nombre = "Computador";
		try {
			tipoBL.crear(nombre);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo para probar la consulta de un tipo de dispositivo segun su
	 * identificador.
	 */
	@Test
	public void testConsultarUno() {
		Tipo tipo = new Tipo();
		int id = 2;
		try {
			tipo = tipoBL.consultarUno(id);
			assertTrue(tipo != null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo para probar la consulta de todos los tipos de dispositivo
	 * existentes en la base de datos del laboratorio.
	 */
	@Test
	public void testConsultarTodos() {
		List<Tipo> tipo = new ArrayList<Tipo>();
		try {
			tipo = tipoBL.consultarTodos();
			assertTrue(tipo.size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
