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

import co.edu.udea.iw.dao.Prestamo_has_DispositivoDao;
import co.edu.udea.iw.dto.Dispositivo;
import co.edu.udea.iw.dto.Prestamo;
import co.edu.udea.iw.dto.Prestamo_has_Dispositivo;
import co.edu.udea.iw.dto.Prestamo_has_DispositivoId;

/**
 * En esta clase se definen casos de prueba para los metodos de la clase
 * Prestamo_has_Dispositivo en cuanto al acceso a la base de datos.
 * 
 * @author Carolina Isaza
 * @author Jaime Londono
 * @author Sebastian Jimenez
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:SpringConf.xml")

public class Prestamo_has_DipositivoDaoImplTest {

	/**
	 * Objeto de la clase Prestamo_has_Dispositivo en cuanto al acceso a la base de datos
	 * (dao).
	 */
	@Autowired
	Prestamo_has_DispositivoDao prestamo_has_dispositivoDao;
	
	/**
	 * Metodo para probar la consulta de todos los prestamos por dispositivo en la base de
	 * datos.
	 */
	@Test
	public void testConsultarTodos() {
		List<Prestamo_has_Dispositivo> prestamos_dispositivos = new ArrayList<Prestamo_has_Dispositivo>();
		try{
			prestamos_dispositivos= prestamo_has_dispositivoDao.consultarTodos();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * Metodo para probar la creacion de un nuevo prestamo por dispositivo en la base de
	 * datos.
	 */
	@Test
	public void testCrear() {
		Prestamo_has_Dispositivo pres_disp = new Prestamo_has_Dispositivo();
		Prestamo_has_DispositivoId pres_dispId = new Prestamo_has_DispositivoId();
		Prestamo prestamo = new Prestamo();
		Dispositivo dispositivo = new Dispositivo();
		prestamo.setIdPrestamo(1);
		dispositivo.setReferencia("001");
		pres_dispId.setPrestamo(prestamo);
		pres_dispId.setReferencia(dispositivo);
		pres_disp.setId(pres_dispId);
		try{
			prestamo_has_dispositivoDao.crear(pres_disp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
