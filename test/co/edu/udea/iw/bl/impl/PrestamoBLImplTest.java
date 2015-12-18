package co.edu.udea.iw.bl.impl;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.udea.iw.bl.PrestamoBL;
import co.edu.udea.iw.dto.Dispositivo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:SpringConf.xml")
public class PrestamoBLImplTest {

	@Autowired
	PrestamoBL prestamoBL;

	@Test
	public void testCrear() {
		String nombreUsuario = "jaime";
		String cedulaUsuario = "125448";
		String correoUsuario = "jaime951@gmail.com";
		String correoAdmin = "sebasj14@gmail.com";
		Date fechaInicio = new Date();
		Date fechaFin = new Date(2015,12,18,15,30,00);
		String[] dispositivos  = new String[1];
		//dispositivos[0] = "001";
		dispositivos[0] = "A0021R";
		try{
		prestamoBL.crear(nombreUsuario, cedulaUsuario, correoUsuario, correoAdmin, fechaInicio, fechaFin, dispositivos);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Test
	public void testModificar() {
		fail("Not yet implemented");
	}

	@Test
	public void testConsultarTodos() {
		fail("Not yet implemented");
	}

	@Test
	public void testConsultarUno() {
		fail("Not yet implemented");
	}

	@Test
	public void testPrestamosSinRevisar() {
		fail("Not yet implemented");
	}

}
