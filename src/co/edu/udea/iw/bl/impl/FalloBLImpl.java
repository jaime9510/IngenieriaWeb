package co.edu.udea.iw.bl.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import co.edu.udea.iw.bl.FalloBL;
import co.edu.udea.iw.dao.DispositivoDao;
import co.edu.udea.iw.dao.FalloDao;
import co.edu.udea.iw.dto.Dispositivo;
import co.edu.udea.iw.dto.Fallo;
import co.edu.udea.iw.exception.MyException;

/**
 * @author Caro
 *
 */
public class FalloBLImpl implements FalloBL{
	
	FalloDao falloDao;
	DispositivoDao dispositivoDao;
	
	@Override
	public List<Fallo> consultarTodos() throws MyException {
		
		return null;
	}

	@Override
	public void crearFallo(int idFallo, String error, String referenciaDispositivo) throws MyException {
		Fallo fallo = new Fallo();
		Date fechaDeteccion = new Date();
		if(idFallo == 0 ){
			throw new MyException("Ingrese un identificador de fallo válido");
		}
		if(error == null || "".equals(error)){
			throw new MyException("El campo de error no puede ser nulo o vacío");
		}
		if(referenciaDispositivo == null || "".equals(referenciaDispositivo)){
			throw new MyException("La referencia no es válida");
		}
		Dispositivo dispositivo = dispositivoDao.consultarUno(referenciaDispositivo);
		if(dispositivo == null){
			throw new MyException("El dispositivo no existe");
		}
		Fallo falloExiste = falloDao.consultarUno(idFallo);
		if(falloExiste != null){
			throw new MyException("El fallo ya existe");
		}
		fallo.setIdFallo(idFallo);
		fallo.setDispositivo(dispositivo);
		fallo.setError(error);
		fallo.setFechaDeteccion(fechaDeteccion);
		fallo.setSolucionado(false);
		falloDao.crear(fallo);
		
	}

	@Override
	public void actualizarFallo(int idFallo, boolean solucionado) throws MyException {
		Fallo fallo = new Fallo();
		if(idFallo == 0){
			throw new MyException("Ingrese un identificador de fallo válido");
		}
		fallo = falloDao.consultarUno(idFallo);
		if(fallo == null){
			throw new MyException("El fallo a actualizar no existe");
		}
		fallo.setSolucionado(solucionado);
		falloDao.actualizar(fallo);
	}

	@Override
	public List<Fallo> consultarFalloPorDispositivo(String referenciaDispositivo) throws MyException {
		Dispositivo dispositivo = new Dispositivo();
		List<Fallo> fallos = new ArrayList<Fallo>();
		if(referenciaDispositivo == null || "".equals(referenciaDispositivo)){
			throw new MyException("Ingrese una referencia válida");
		}
		dispositivo = dispositivoDao.consultarUno(referenciaDispositivo);
		if(dispositivo == null){
			throw new MyException("El dipositivo no existe");
		}
		fallos = falloDao.consultarFalloPorDispositivo(dispositivo);
		
		return fallos;
	}

	@Override
	public List<Fallo> consultarDanosSinSolucion() throws MyException {
		List <Fallo>fallos = new ArrayList<Fallo>();
		fallos = falloDao.consultarDañosSinSolucion();
		return fallos;
	}

}
