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

import co.edu.udea.iw.bl.AdministradorBL;
import co.edu.udea.iw.dto.Administrador;
import co.edu.udea.iw.exception.MyException;
import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:SpringConf.xml")
@Transactional
public class AdministradorBLImplTest {

	@Autowired
	AdministradorBL administradorBL;
	@Test
	public void testMostrarTodos() {
		List<Administrador> lista = new ArrayList<Administrador>();
		try{
		lista = administradorBL.mostrarTodos();
		Assert.assertTrue(lista.size()> 0);
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Test
	public void testLogin() {
		String email = "sebasj14@gmail.com";
		String contrasena = "sebasj14";
		try{
			boolean logueado = administradorBL.login(email, contrasena);
			Assert.assertTrue(logueado);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Test
	public void testCrearAdministrador() {
		String nombre = "Sebastian";
		String apellidos = "Jimenez";
		String contrasena = "sebasj14";
		String email = "sebasj14@gmail.com";
		try{
		administradorBL.crearAdministrador(email, contrasena, nombre, apellidos);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	//@Test
	public void testActualizarAdministrador() {
		String nombre = "Sebastian";
		String apellidos = "Jimenez Caro";
		String contrasena = "sebasj14";
		String email = "sebasj14@gmail.com";
		try{
			administradorBL.actualizarAdministrador(email, contrasena, nombre, apellidos);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	//@Test
	public void testEliminarAdministrador() {
		String email = "sebasj14@gmail.com";
		String contrasena = "sebasj14";
		try{
		administradorBL.eliminarAdministrador(email, contrasena);
		}catch(MyException e){
			e.printStackTrace();
		}
	}

}
