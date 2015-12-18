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

import co.edu.udea.iw.dao.FalloDao;
import co.edu.udea.iw.dto.Dispositivo;
import co.edu.udea.iw.dto.Fallo;

/**
 * En esta clase se definen casos de prueba para los metodos de la clase
 * Fallo en cuanto al acceso a la base de datos.
 * 
 * @author Carolina Isaza
 * @author Jaime Londono
 * @author Sebastian Jimenez
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:SpringConf.xml")
public class FalloDaoImplTest {

	/**
	 * Objeto de la clase Fallo en cuanto al acceso a la base de datos
	 * (dao).
	 */
	@Autowired
	FalloDao falloDao;
	
	/**
	 * Metodo para probar la consulta de todos los fallos en la base de
	 * datos.
	 */
	@Test
	public void testConsultarTodos() {
		List<Fallo> fallos = new ArrayList<Fallo>();
		try{
			fallos = falloDao.consultarTodos();
			assertTrue(fallos.size()>0);
		}catch(Exception e ){
			e.printStackTrace();
		}
	}

	/**
	 * Metodo para probar la creacion de un nuevo fallo en la base de
	 * datos.
	 */
	@Test
	public void testCrear() {
		Fallo fallo = new Fallo();
		Date fecha = new Date();
		Dispositivo dispositivo = new Dispositivo();
		dispositivo.setReferencia("001");
		fallo.setIdFallo(01);
		fallo.setError("No enciende");
		fallo.setFechaDeteccion(fecha);
		fallo.setSolucionado(false);
		fallo.setDispositivo(dispositivo);
		try{
			falloDao.crear(fallo);
			assertTrue(true);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	
	/**
	 * Metodo para probar la actualizacion de informacion de un fallo.
	 */
	@Test
	public void testActualizar() {
		Fallo fallo = new Fallo();
		Date fecha = new Date();
		Dispositivo dispositivo = new Dispositivo();
		dispositivo.setReferencia("001");
		fallo.setIdFallo(01);
		fallo.setError("No enciende");
		fallo.setFechaDeteccion(fecha);
		fallo.setSolucionado(false);
		fallo.setDispositivo(dispositivo);
		try{
			falloDao.actualizar(fallo);;
			assertTrue(true);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * Metodo para probar la consulta de los fallos presentados por un dispositivo
	 */
	@Test
	public void testConsultarFalloPorDispositivo() {
		List<Fallo> fallos = new ArrayList<Fallo>();
		Dispositivo dispositivo = new Dispositivo();
		dispositivo.setReferencia("001");
		try{
			fallos = falloDao.consultarFalloPorDispositivo(dispositivo);
			assertTrue(fallos.size()>0);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * Metodo para probar la consulta de los fallos que no han sido solucionados
	 */
	@Test
	public void testConsultarDanosSinSolucion() {
		List<Fallo> fallos = new ArrayList<Fallo>();
		try{
			fallos = falloDao.consultarDanosSinSolucion();
			assertTrue(fallos.size()>0);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
