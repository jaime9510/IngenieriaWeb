package co.edu.udea.iw.bl.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.edu.udea.iw.bl.DispositivoBL;
import co.edu.udea.iw.dao.AdministradorDao;
import co.edu.udea.iw.dao.DispositivoDao;
import co.edu.udea.iw.dao.TipoDao;
import co.edu.udea.iw.dto.Administrador;
import co.edu.udea.iw.dto.Dispositivo;
import co.edu.udea.iw.dto.Tipo;
import co.edu.udea.iw.exception.MyException;

/**
 * Clase en la que se implementan los metodos de la interface DispositivoBL. En
 * esta clase se implementaran todos los metodos correspondientes a la logica
 * del negocio definida para un Dispositivo
 * 
 * @author Carolina Isaza
 * @author Sebastian Jimenez
 * @author Jaime Londono
 *
 */
public class DispositivoBLImpl implements DispositivoBL {

	/**
	 * Objeto del tipo DispositivoDao, este objeto sera inyectado desde el
	 * archivo de configuracion de Spring
	 */
	DispositivoDao dispositivoDao;
	/**
	 * Objeto del tipo AdministradorDao, este objeto sera inyectado desde el
	 * archivo de configuracion de Spring
	 */
	AdministradorDao administradorDao;
	/**
	 * Objeto del tipo TipoDao, este objeto sera inyectado desde el archivo de
	 * configuracion de Spring
	 */
	TipoDao tipoDao;

	// Metodos Getters & Setters para la inyeccion de dependencias
	/**
	 * Metodo para acceder al objeto AdministradorDao
	 * 
	 * @return administradorDao Objeto de la clase AdministradorDao
	 */
	public AdministradorDao getAdministradorDao() {
		return administradorDao;
	}

	/**
	 * Metodo para asignar un administradorDao al objeto del tipo
	 * AdministradorDao de esta clase
	 * 
	 * @param administradorDao
	 *            Objeto del tipo AdministradorDao con todos los atributos
	 *            correspondientes a la misma
	 */
	public void setAdministradorDao(AdministradorDao administradorDao) {
		this.administradorDao = administradorDao;
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

	/**
	 * Metodo para acceder al objeto del tipo TipoDao
	 * 
	 * @return tipoDao Objeto con la informacion correspondiente a un objeto
	 *         TipoDao
	 */
	public TipoDao getTipoDao() {
		return tipoDao;
	}

	/**
	 * Metodo para asignar un dipositivoDao al objeto del tipo TipoDao de esta
	 * clase
	 * 
	 * @param tipoDao
	 *            objeto con la informacion concerniente a un objeto del tipo
	 *            TipoDao
	 */
	public void setTipoDao(TipoDao tipoDao) {
		this.tipoDao = tipoDao;
	}

	@Override
	public List<Dispositivo> consultarTodos() throws MyException {
		List<Dispositivo> dispositivos = new ArrayList<Dispositivo>();
		// Almacena en una lista de dispositivos la lista retornada por el
		// metodo consultarTodos de la clase DispositivoDao
		dispositivos = dispositivoDao.consultarTodos();
		return dispositivos;
	}

	@Override
	public void crearDispositivo(String referencia, String nombre, String descripcion, int tipo, String foto,
			String emailAdministrador) throws MyException {
		// Crea un objeto del tipo Dispositivo y un objeto del tipo Tipo
		Dispositivo disp = new Dispositivo();
		Tipo tp = new Tipo();
		// Verifica que los campos ingresados sean validos para las reglas de
		// negocio
		if (referencia == null || "".equals(referencia)) {
			throw new MyException("La referencia no es v�lida");
		}
		if (nombre == null || "".equals(nombre)) {
			throw new MyException("El nombre no es v�lido");
		}
		if (tipo == 0) {
			throw new MyException("El tipo no es v�lido");
		}
		if (foto == null || "".equals(foto)) {
			throw new MyException("La url de la foto no es v�lida");
		}
		if (emailAdministrador == null || "".equals(emailAdministrador)) {
			throw new MyException("Ingrese un administrador v�lido");
		}
		// Verifica que el administrador que realiza la operacion esta
		// registrado en la base de datos
		Administrador administrador = administradorDao.consultarUno(emailAdministrador);
		if (administrador == null) {
			throw new MyException("El administrador no existe");
		}
		// Verifica que no exista un dispositivo con la referencia especificada
		Dispositivo dispositivo = dispositivoDao.consultarUno(referencia);
		if (dispositivo != null) {
			throw new MyException("Ya existe un dispositivo con esa referencia");
		}
		// Verifica que exista el tipo de dispositivo especificado
		Tipo tipoDispositivo = tipoDao.consultarUno(tipo);
		if (tipoDispositivo == null) {
			throw new MyException("Seleccione un tipo de dispositivo v�lido");
		}

		// Asigna al objeto de tipo Tipo el id de tipo especificado
		tp.setId(tipo);
		// Asigna los valores ingresados al objeto disp
		disp.setReferencia(referencia);
		disp.setDescripcion(descripcion);
		disp.setDisponible(true);
		disp.setFoto(foto);
		disp.setNombre(nombre);
		disp.setReferencia(referencia);
		disp.setTipo(tp);
		// Envia al metodo crear de la clase DispositivoDao el nuevo dispositivo
		dispositivoDao.crear(disp);
	}

	@Override
	public void actualizarDispositivo(String referencia, String nombre, String descripcion, int tipo, String foto,
			boolean disponible, String emailAdministrador) throws MyException {
		// Crea un objeto del tipo Tipo
		Tipo tp = new Tipo();
		// Verifica que los campos ingresados sean validos para las reglas de
		// negocio
		if (referencia == null || "".equals(referencia)) {
			throw new MyException("La referencia no es v�lida");
		}
		if (nombre == null || "".equals(nombre)) {
			throw new MyException("El nombre no es v�lido");
		}
		if (tipo == 0) {
			throw new MyException("El tipo no es v�lido");
		}
		if (foto == null || "".equals(foto)) {
			throw new MyException("La url de la foto no es v�lida");
		}
		if (emailAdministrador == null || "".equals(emailAdministrador)) {
			throw new MyException("Ingrese un administrador v�lido");
		}
		// Verifica que el administrador que realiza la operacion esta
		// registrado en la base de datos
		Administrador administrador = administradorDao.consultarUno(emailAdministrador);
		if (administrador == null) {
			throw new MyException("El administrador no existe");
		}
		// Verifica que el dispositivo especificado si exista
		Dispositivo dispositivo = dispositivoDao.consultarUno(referencia);
		if (dispositivo == null) {
			throw new MyException("El dispositvo no existe");
		}
		// Verifica que exista el tipo de dispositivo especificado
		Tipo tipoDispositivo = tipoDao.consultarUno(tipo);
		if (tipoDispositivo == null) {
			throw new MyException("Seleccione un tipo de dispositivo v�lido");
		}
		// Envia al metodo crear de la clase DispositivoDao el nuevo dispositivo
		tp.setId(tipo);
		// Asigna los valores ingresados al objeto dispositivo
		dispositivo.setDescripcion(descripcion);
		dispositivo.setDisponible(disponible);
		dispositivo.setFoto(foto);
		dispositivo.setNombre(nombre);
		dispositivo.setReferencia(referencia);
		dispositivo.setTipo(tp);
		// Envia al objeto dispositivo al metodo actualizar de la clase
		// DispositivoDao
		dispositivoDao.actualizar(dispositivo);
	}

	@Override
	public void eliminarDispositivo(String referencia, String emailAdministrador) throws MyException {
		// Verifica que los campos ingresados sean validos para las reglas de
		// negocio
		if (referencia == null || "".equals(referencia)) {
			throw new MyException("La referencia no es v�lida");
		}
		if (emailAdministrador == null || "".equals(emailAdministrador)) {
			throw new MyException("Ingrese un administrador v�lido");
		}
		// Verifica que el administrador que realiza la operacion esta
		// registrado en la base de datos
		Administrador administrador = administradorDao.consultarUno(emailAdministrador);
		if (administrador == null) {
			throw new MyException("El administrador no existe");
		}
		// Verifica que el dispositivo especificado si exista
		Dispositivo dispositivo = dispositivoDao.consultarUno(referencia);
		if (dispositivo == null) {
			throw new MyException("No existe un dispositivo con esa referencia");
		}
		// Envia el objeto dispositivo al metodo eliminar de la clase
		// DispositivoDao
		dispositivoDao.eliminar(dispositivo);

	}

	@Override
	public List<Dispositivo> consultarPorTipo(int idTipo) throws MyException {
		// Crea una lista de dispositivos
		List<Dispositivo> dispositivos = new ArrayList<Dispositivo>();
		// Crea un objeto de la clase Tipo
		Tipo tipo = new Tipo();
		// Verifica que los campos ingresados sean validos para las reglas de
		// negocio
		if (idTipo == 0) {
			throw new MyException("El tipo no es v�lido");
		}
		// Verifica que si exista un dispositivo con la identificacion
		// especificada
		tipo = tipoDao.consultarUno(idTipo);
		if (tipo == null) {
			throw new MyException("El tipo ingresado no existe");
		}
		// Envia el objeto tipo al metodo consultarPorTipo de la clase
		// dispositivoDao
		dispositivos = dispositivoDao.consultarPorTipo(tipo);
		return dispositivos;
	}

	@Override
	public Dispositivo consultarUno(String referencia) throws MyException {
		// Crea un objeto del tipo Dispositivo
		Dispositivo dispositivo = new Dispositivo();
		// Verifica que los campos ingresados sean validos para las reglas de
		// negocio
		if (referencia == null || "".equals(referencia)) {
			throw new MyException("La referencia no es v�lida");
		}
		// Almacena en el objeto dispositivo el objeto devuelto por el metodo
		// consultar uno de la clase DispositivoDao
		dispositivo = dispositivoDao.consultarUno(referencia);
		return dispositivo;
	}

	@Override
	public List<Dispositivo> mostrarDispositivosDisponibles(Date fechaInicio, Date fechaFin) {
		// Crea una lista de dispositivos
		List<Dispositivo> dispositivos = new ArrayList<Dispositivo>();
		try {
			// Recorre la lista de referencias retornada por el metodo
			// consultarDisponibles entre las fechas especificadas y consulta
			// cada uno de las referencias para crear la lista de dispositivos
			for (String referencia : dispositivoDao.consultarDisponibles(fechaInicio, fechaFin)) {
				Dispositivo dispositivo = dispositivoDao.consultarUno(referencia);
				dispositivos.add(dispositivo);
			}
		} catch (MyException e) {
			e.getMessage();
		}
		// Retorna la lista de dispositivos disponibles
		return dispositivos;
	}

}
