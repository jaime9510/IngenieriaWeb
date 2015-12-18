package co.edu.udea.iw.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.AdministradorDao;
import co.edu.udea.iw.dto.Administrador;
import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:SpringConf.xml")
public class AdministradorDaoImplTest {

	@Autowired
	AdministradorDao administradorDao;
	
	@Test
	public void testMostrarTodos() {
		List<Administrador> administradores = null;
		try{
			administradores = administradorDao.mostrarTodos();
			Assert.assertTrue(administradores.size()>0);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Test	public void testCrear() {
		Administrador admin= new Administrador();
		admin.setEmail("carito9994@gmail.com");
		admin.setNombre("Carolina");
		admin.setApellidos("Isaza");
		admin.setContrasena("123");
		try{
			administradorDao.crear(admin);
			Assert.assertTrue(true);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	//@Test
	public void testActualizar() {
		Administrador admin= new Administrador();
		admin.setEmail("carito9994@gmail.com");
		admin.setNombre("Carolina");
		admin.setApellidos("Isaza");
		admin.setContrasena("caro");
		try{
			administradorDao.actualizar(admin);
			Assert.assertTrue(true);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	//@Test
	public void testEliminar() {
		Administrador admin= new Administrador();
		admin.setEmail("carito9994@gmail.com");
		
		try{
			administradorDao.eliminar(admin);
			Assert.assertTrue(true);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Test
	public void testConsultarUno() {
		Administrador admin;
		String email = "carito9994@gmail.com";
		try{
			admin = administradorDao.consultarUno(email);
			Assert.assertTrue(admin != null);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
