package co.edu.udea.iw.dao.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:SpringConf.xml")
public class DispositivoDaoImplTest {

	@Autowired
	DispositivoDao dispositivoDao;
	//@Test
	public void testConsultarTodos() {
		List<Dispositivo> dispositivos = new ArrayList<Dispositivo>();
		try{
			dispositivos = dispositivoDao.consultarDisponibles();
			Assert.assertTrue(dispositivos.size() >0);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	//@Test
	public void testCrear() {
		Dispositivo dispositivo = new Dispositivo();
		dispositivo.setReferencia("001");
		dispositivo.setDescripcion("hola");
		dispositivo.setDisponible(true);
		dispositivo.setNombre("Note 10.1");
		dispositivo.setFoto("link");
		Tipo tipo = new Tipo();
		tipo.setId(1);
		//tipo.setNombre("Tablet");
		dispositivo.setTipo(tipo);
		try{
			dispositivoDao.crear(dispositivo);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	//@Test
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
		try{
			dispositivoDao.actualizar(dispositivo);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	//@Test
	public void testEliminar() {
		Dispositivo dispositivo = new Dispositivo();
		dispositivo.setReferencia("001");
		
		try{
			dispositivoDao.eliminar(dispositivo);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Test
	public void testConsultarPorTipo() {
		List<Dispositivo> dispositivos = new ArrayList<Dispositivo>();
		Tipo tipo = new Tipo();
		tipo.setId(1);
		try{
			dispositivos = dispositivoDao.consultarPorTipo(tipo);
			Assert.assertTrue(dispositivos.size()>0);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	//@Test
	public void testConsultarDisponibles() {
		List<Dispositivo> dispositivos = new ArrayList<Dispositivo>();
		try{
			dispositivos = dispositivoDao.consultarDisponibles();
			Assert.assertTrue(dispositivos.size()>0);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	//@Test
	public void testConsultarUno() {
		Dispositivo dispositivo ;
		String referencia = "001";
		try{
			dispositivo = dispositivoDao.consultarUno(referencia);
			Assert.assertTrue(dispositivo != null);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
