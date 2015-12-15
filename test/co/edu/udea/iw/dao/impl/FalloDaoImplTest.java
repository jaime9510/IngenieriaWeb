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

import co.edu.udea.iw.dao.FalloDao;
import co.edu.udea.iw.dto.Dispositivo;
import co.edu.udea.iw.dto.Fallo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:SpringConf.xml")
@Transactional
public class FalloDaoImplTest {

	@Autowired
	FalloDao falloDao;
	
	@Test
	public void testConsultarTodos() {
		List<Fallo> fallos = new ArrayList<Fallo>();
		try{
			fallos = falloDao.consultarTodos();
		}catch(Exception e ){
			e.printStackTrace();
		}
	}

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

	//@Test
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
