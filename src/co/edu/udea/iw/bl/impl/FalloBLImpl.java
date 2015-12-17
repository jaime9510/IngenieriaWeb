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
 * Clase en la que se implementan los metodos de la interface FalloBL. En esta
 * clase se implementaran todos los metodos correspondientes a la logica del
 * negocio definida para un Fallo
 * 
 * @author Carolina Isaza
 * @author Jaime Londono
 * @author Sebastian Jimenez
 *
 */
public class FalloBLImpl implements FalloBL {
	/**
	 * Objeto del tipo FalloDao, este objeto sera injectado desde el archivo de
	 * configuracion de Spring
	 */
	FalloDao falloDao;
	/**
	 * Objeto del tipo DispositivoDao, este objeto sera injectado desde el
	 * archivo de configuracion de Spring
	 */
	DispositivoDao dispositivoDao;

	/**
	 * Metodo para acceder al objeto del tipo FalloDao
	 * 
	 * @return falloDao bjeto con la informacion concerniente a un objeto del
	 *         tipo FalloDao
	 */
	public FalloDao getFalloDao() {
		return falloDao;
	}

	/**
	 * Metodo para asignar un falloDao al objeto del tipo FalloDao de esta clase
	 * 
	 * @param falloDao
	 *            objeto con la informacion concerniente a un objeto del tipo
	 *            FalloDao
	 */
	public void setFalloDao(FalloDao falloDao) {
		this.falloDao = falloDao;
	}

	/**
	 * Metodo para acceder al objeto del tipo DispositivoDao
	 * 
	 * @return dispositivoDao objeto con la informacion concerniente a un objeto
	 *         del tipo DispositivoDao
	 */
	public DispositivoDao getDispositivoDao() {
		return dispositivoDao;
	}

	/**
	 * Metodo para asignar un dipositivoDao al objeto del tipo DispositivoDao de
	 * esta clase
	 * 
	 * @param dispositivoDao
	 *            objeto con la informacion concerniente a un objeto del tipo
	 *            DispositivoDao
	 */
	public void setDispositivoDao(DispositivoDao dispositivoDao) {
		this.dispositivoDao = dispositivoDao;
	}

	@Override
	public List<Fallo> consultarTodos() throws MyException {
		// Crea una lista con los fallos
		List<Fallo> fallos = new ArrayList<Fallo>();
		try {
			// Almacena en la lista la lista retornada por el metodo
			// consultarTodos de la clase FalloDao
			fallos = falloDao.consultarTodos();
		} catch (MyException e) {
			e.getMessage();
		}
		// Retorna la lista de fallos
		return fallos;
	}

	@Override
	public void crearFallo(int idFallo, String error, String referenciaDispositivo) throws MyException {
		// Se crea un objeto del tipo Fallo
		Fallo fallo = new Fallo();
		// Se crea un objeto del tipo Date con la fecha actual del sistema
		Date fechaDeteccion = new Date();
		// Verifica que los campos ingresados sean validos para las reglas de
		// negocio
		if (idFallo == 0) {
			throw new MyException("Ingrese un identificador de fallo válido");
		}
		if (error == null || "".equals(error)) {
			throw new MyException("El campo de error no puede ser nulo o vacío");
		}
		if (referenciaDispositivo == null || "".equals(referenciaDispositivo)) {
			throw new MyException("La referencia no es válida");
		}
		// Verifica que el dispositivo con la referencia especificada exista
		Dispositivo dispositivo = dispositivoDao.consultarUno(referenciaDispositivo);
		if (dispositivo == null) {
			throw new MyException("El dispositivo no existe");
		}
		// Vaerifica que el fallo no exista en la base de datos
		Fallo falloExiste = falloDao.consultarUno(idFallo);
		if (falloExiste != null) {
			throw new MyException("El fallo ya existe");
		}
		// Asigna los datos diligenciados y la fecha al objeto fallo
		fallo.setIdFallo(idFallo);
		fallo.setDispositivo(dispositivo);
		fallo.setError(error);
		fallo.setFechaDeteccion(fechaDeteccion);
		fallo.setSolucionado(false);
		// Envia el objeto fallo al metodo crear de la clase FalloDao
		falloDao.crear(fallo);

	}

	@Override
	public void actualizarFallo(int idFallo, boolean solucionado) throws MyException {
		// Crea un objeto del tipo Fallo
		Fallo fallo = new Fallo();
		// Verifica que los campos ingresados sean validos para las reglas de
		// negocio
		if (idFallo == 0) {
			throw new MyException("Ingrese un identificador de fallo válido");
		}
		// Verifica que el fallo con el identificador especificado exista
		fallo = falloDao.consultarUno(idFallo);
		if (fallo == null) {
			throw new MyException("El fallo a actualizar no existe");
		}
		// Actualiza en el objeto del tipo fallo el atributo de solucionado
		fallo.setSolucionado(solucionado);
		// Envia el objeto fallo con toda la informacion al metodo actualizar de
		// la clase FalloDao
		falloDao.actualizar(fallo);
	}

	@Override
	public List<Fallo> consultarFalloPorDispositivo(String referenciaDispositivo) throws MyException {
		// Se crea un objeto del tipo Dispositivo
		Dispositivo dispositivo = new Dispositivo();
		// Se crea una lista de fallos
		List<Fallo> fallos = new ArrayList<Fallo>();
		// Verifica que los campos ingresados sean validos para las reglas de
		// negocio
		if (referenciaDispositivo == null || "".equals(referenciaDispositivo)) {
			throw new MyException("Ingrese una referencia válida");
		}
		// Verifica que el dispositivo exista en la base de datos
		dispositivo = dispositivoDao.consultarUno(referenciaDispositivo);
		if (dispositivo == null) {
			throw new MyException("El dipositivo no existe");
		}
		// Almacena en la lista de fallos la lista retornada por el metodo
		// consultarFallosPorDispositivo que recibe el dispositivo que queremos
		// consultar
		fallos = falloDao.consultarFalloPorDispositivo(dispositivo);
		// Retorna la lista de fallos
		return fallos;
	}

	@Override
	public List<Fallo> consultarDanosSinSolucion() throws MyException {
		List<Fallo> fallos = new ArrayList<Fallo>();
		// Almacena en la lista de fallos la lista retornada por el metodo
		// consutarDanosSinSolucion
		fallos = falloDao.consultarDanosSinSolucion();
		// Retorna la lista de fallos
		return fallos;
	}

	@Override
	public Fallo consultarUno(int id) throws MyException {
		// Crea un objeto del tipo Fallo
		Fallo fallo = new Fallo();
		// Verifica que los campos ingresados sean validos para las reglas de
		// negocio
		if (id == 0) {
			throw new MyException("Ingrese un identificador valido");
		}
		//Verifica que el fallo exista
		fallo = falloDao.consultarUno(id);
		if (fallo == null) {
			throw new MyException("No existe un fallo con dicho identificador");
		}
		//Retorna el fallo
		return fallo;
	}

}
