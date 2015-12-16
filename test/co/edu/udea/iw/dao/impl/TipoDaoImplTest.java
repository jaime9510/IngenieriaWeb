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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:SpringConf.xml")

public class TipoDaoImplTest {

	@Autowired
	TipoDao tipoDao;
	
	@Test
	public void testConsultarTodos() {
		List<Tipo> tipos = null;
		try{
			tipos = tipoDao.consultarTodos();
			Assert.assertTrue(tipos.size()>0);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	//@Test
	public void testCrear() {
		Tipo tipo = new Tipo();
		tipo.setNombre("Tablet");
		try{
			tipoDao.crear(tipo);
			Assert.assertTrue(true);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Test
	public void testConsultarUno() {
		Tipo tipo = new Tipo();
		int id = 1;
		try{
			tipo= tipoDao.consultarUno(id);
			Assert.assertTrue(tipo !=null);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void testConsultarPorNombre(){
		Tipo tipo = new Tipo();
		String nombre = "Tablet";
		try{
			tipo = tipoDao.consultarPorNombre(nombre);
			assertTrue(tipo != null);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
