package co.edu.udea.iw.bl.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.udea.iw.bl.FalloBL;
import co.edu.udea.iw.dto.Fallo;
import co.edu.udea.iw.exception.MyException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:SpringConf.xml")
public class FalloBLImplTest {

	@Autowired
	FalloBL falloBL;
	@Test
	public void testCrearFallo() {
		int idFallo = 001;
		String error = "El dispositivo no enciende";
		String referenciaDispositivo = "A0021R";
		try{
		falloBL.crearFallo(idFallo, error, referenciaDispositivo);
		}catch(MyException e){
			e.printStackTrace();
		}
	}

	//@Test
	public void testActualizarFallo() {
		int idFallo = 001;
		boolean solucionado = true;
		try{
			falloBL.actualizarFallo(idFallo, solucionado);
			assertTrue(true);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Test
	public void testConsultarFalloPorDispositivo() {
		List<Fallo> fallo = new ArrayList<Fallo>();
		String referenciaDispositivo = "A0021R";
		try{
			fallo = falloBL.consultarFalloPorDispositivo(referenciaDispositivo);
			assertTrue(fallo.size()>0);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Test
	public void testConsultarDanosSinSolucion() {
		List<Fallo> fallos = new ArrayList<Fallo>();
		try{
			fallos = falloBL.consultarDanosSinSolucion();
			assertTrue(fallos.size()>0);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void TestConsultarUno(){
		int id = 1;
		Fallo fallo = new Fallo();
		try{
		falloBL.consultarUno(id);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
