package co.edu.udea.iw.bl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.xml.crypto.dsig.spec.ExcC14NParameterSpec;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.udea.iw.dto.Tipo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:SpringConf.xml")
public class TipoBLTest {
	
	@Autowired
	TipoBL tipoBL;

	@Test
	public void testCrear() {
		String nombre = "Computador";
		try{
			tipoBL.crear(nombre);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Test
	public void testConsultarUno() {
		Tipo tipo = new Tipo();
		int id = 2;
		try{
			tipo = tipoBL.consultarUno(id);
			assertTrue(tipo != null);
		}catch(Exception e ){
			e.printStackTrace();
		}
	}

	@Test
	public void testConsultarTodos() {
		List<Tipo> tipo = new ArrayList<Tipo>();
		try{
			tipo = tipoBL.consultarTodos();
			assertTrue(tipo.size()>0);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
