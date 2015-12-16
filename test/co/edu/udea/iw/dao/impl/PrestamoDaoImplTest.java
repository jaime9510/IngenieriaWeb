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

import co.edu.udea.iw.dao.PrestamoDao;
import co.edu.udea.iw.dto.Administrador;
import co.edu.udea.iw.dto.Prestamo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:SpringConf.xml")

public class PrestamoDaoImplTest {

	@Autowired
	PrestamoDao prestamoDao;
	
	@Test
	public void testConsultarTodos() {
		List<Prestamo> prestamos = new ArrayList<Prestamo>();
		try{
			prestamos= prestamoDao.consultarTodos();
			assertTrue(prestamos.size()>0);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Test
	public void testCrear() {
		Prestamo prestamo = new Prestamo();
		Administrador admin = new Administrador();
		Date fechaIn = new Date();
		Date fechaFin = new Date(2015, 12, 18);
		admin.setEmail("carito9994@gmail.com");
		prestamo.setAdministrador(admin);
		prestamo.setCedulaUsuario("1017238258");
		prestamo.setCorreoUsuario("Jessi@gmail.com");
		prestamo.setFechaInicio(fechaIn);
		prestamo.setFechaFin(fechaFin);
		prestamo.setNombreUsuario("Jessica");
		try{
			prestamoDao.crear(prestamo);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	//@Test
	public void testModificar() {
		Prestamo prestamo = new Prestamo();
		Administrador admin = new Administrador();
		Date fechaIn = new Date();
		Date fechaFin = new Date();
		admin.setEmail("carito9994@gmail.com");
		prestamo.setAceptada(true);
		prestamo.setAdministrador(admin);
		prestamo.setCedulaUsuario("1017238258");
		prestamo.setCorreoUsuario("Jessi@gmail.com");
		prestamo.setFechaInicio(fechaIn);
		prestamo.setFechaFin(fechaFin);
		prestamo.setNombreUsuario("Jessica");
		try{
			prestamoDao.crear(prestamo);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Test
	public void testConsultarUno() {
		Prestamo prestamo = new Prestamo();
		int id= 1;
		try{
			prestamo = prestamoDao.consultarUno(id);
			assertTrue(prestamo != null);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
