package co.edu.udea.iw.bl.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import co.edu.udea.iw.bl.PrestamoBL;
import co.edu.udea.iw.dao.AdministradorDao;
import co.edu.udea.iw.dao.DispositivoDao;
import co.edu.udea.iw.dao.PrestamoDao;
import co.edu.udea.iw.dao.Prestamo_has_DispositivoDao;
import co.edu.udea.iw.dto.Administrador;
import co.edu.udea.iw.dto.Dispositivo;
import co.edu.udea.iw.dto.Prestamo;
import co.edu.udea.iw.dto.Prestamo_has_Dispositivo;
import co.edu.udea.iw.dto.Prestamo_has_DispositivoId;
import co.edu.udea.iw.exception.MyException;

/**
 * Clase en la que se implementan los metodos de la interface PrestamoBL. En
 * esta clase se implementaran todos los metodos correspondientes a la logica
 * del negocio definida para un Dispositivo
 * 
 * @author Carolina Isaza
 * @author Sebastian Jimenez
 * @author Jaime Londono
 *
 */
public class PrestamoBLImpl implements PrestamoBL {

	/**
	 * Objeto del tipo AdministradorDao, este objeto sera inyectado desde el
	 * archivo de configuracion de Spring
	 */
	AdministradorDao administradorDao;
	/**
	 * Objeto del tipo PrestamoDao, este objeto sera inyectado desde el archivo
	 * de configuracion de Spring
	 */
	PrestamoDao prestamoDao;
	/**
	 * Objeto del tipo Prestamo_has_DispositivoDao, este objeto sera inyectado
	 * desde el archivo de configuracion de Spring
	 */
	Prestamo_has_DispositivoDao prestamo_has_dispositivoDao;
	/**
	 * Objeto del tipo DispositivoDao, este objeto sera inyectado desde el
	 * archivo de configuracion de Spring
	 */
	DispositivoDao dispositivoDao;

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
	 * Metodo para acceder al objeto PrestamoDao
	 * 
	 * @return prestamoDao Objeto de la clase AdministradorDao
	 */
	public PrestamoDao getPrestamoDao() {
		return prestamoDao;
	}

	/**
	 * Metodo para asignar un prestamoDao al objeto del tipo PrestamoDao de esta
	 * clase
	 * 
	 * @param prestamoDao
	 *            Objeto del tipo PrestamoDao con todos los atributos
	 *            correspondientes a la misma
	 */
	public void setPrestamoDao(PrestamoDao prestamoDao) {
		this.prestamoDao = prestamoDao;
	}

	/**
	 * Metodo para acceder al objeto del tipo Prestamo_has_DispositivoDao
	 * 
	 * @return prestamo_has_dispositivoDao Objeto de la clase
	 *         Prestamo_has_DispositivoDao
	 */
	public Prestamo_has_DispositivoDao getPrestamo_has_dispositivoDao() {
		return prestamo_has_dispositivoDao;
	}

	/**
	 * Metodo para asignar un prestamo_has_dispositivoDao al objeto del tipo
	 * Prestamo_has_DispositivoDao de esta clase
	 * 
	 * @param prestamo_has_dispositivoDao
	 *            Objeto del tipo Prestamo_has_DispositivoDao con todos los
	 *            atributos correspondientes a la misma
	 */
	public void setPrestamo_has_dispositivoDao(Prestamo_has_DispositivoDao prestamo_has_dispositivoDao) {
		this.prestamo_has_dispositivoDao = prestamo_has_dispositivoDao;
	}

	/**
	 * Metodo para acceder al objeto del tipo DispositivoDao
	 * 
	 * @return dispositivoDao Objeto de la clase DispositivoDao
	 */
	public DispositivoDao getDispositivoDao() {
		return dispositivoDao;
	}

	/**
	 * Metodo para asignar un dispositivoDao al objeto del tipo DispositivoDao
	 * de esta clase
	 * 
	 * @param dispositivoDao
	 *            Objeto del tipo DispositivoDao con todos los atributos
	 *            correspondientes a la misma
	 */
	public void setDispositivoDao(DispositivoDao dispositivoDao) {
		this.dispositivoDao = dispositivoDao;
	}

	public void crear(String nombreUsuario, String cedulaUsuario, String correoUsuario, Date fechaInicio, Date fechaFin,
			String[] dispositivos) throws MyException {
		// Se crea un objeto del tipo Prestamo
		Prestamo prestamo = new Prestamo();
		Calendar calendarInicio = GregorianCalendar.getInstance();
		Calendar calendarFin = GregorianCalendar.getInstance();
		calendarInicio.setTime(fechaInicio);
		calendarFin.setTime(fechaFin);
		Calendar fechaActual = GregorianCalendar.getInstance();
		// // Verifica que los campos ingresados sean validos para las reglas de
		// negocio
		if (nombreUsuario == null || "".equals(nombreUsuario)) {
			throw new MyException("Ingrese un nombre de usuario valido");
		}
		if (cedulaUsuario == null || "".equals(cedulaUsuario)) {
			throw new MyException("Ingrese una cedula de usuario valida");
		}
		if (fechaInicio == null || calendarInicio.get(Calendar.HOUR_OF_DAY) < 8
				|| calendarInicio.get(Calendar.HOUR_OF_DAY) >= 18) {
			throw new MyException("Ingrese una fecha valida");
		}
		if (fechaFin == null || calendarFin.get(Calendar.HOUR_OF_DAY) < 8
				|| calendarFin.get(Calendar.HOUR_OF_DAY) >= 18) {
			throw new MyException("Ingrese una fecha de fin de prestamo valida");
		}
		long msInicio = fechaInicio.getTime();
		long msFin = fechaFin.getTime();
		if (msFin - msInicio > 8 * 3600 * 1000) {
			throw new MyException("El prestamo no puede ser realizado por mas de 8 horas");
		}
		if (calendarInicio.before(fechaActual)) {
			throw new MyException("La fecha de inicio ingresada es anterior al dia de hoy");
		}
		if (calendarFin.before(fechaActual)) {
			throw new MyException("La fecha de fin ingresada es anterior al dia de hoy");
		}
		if (calendarFin.before(calendarInicio)) {
			throw new MyException("La fecha de fin ingresada es anterior a la fecha de inicio");
		}
		if (dispositivos.length < 1) {
			throw new MyException("Seleccione los dispositivos para el prestamo");
		}
		// Verifica que cada uno de los dispositivos seleccionados exista y este
		// disponible para prestamo en el horario especificado
		for (int i = 0; i < dispositivos.length; i++) {
			System.out.println(dispositivos[i]);
			Dispositivo dispositivo = dispositivoDao.consultarUno(dispositivos[i]);
			if (dispositivo == null) {

				throw new MyException("Uno de los dispositivos no existe");
			}
			Boolean prestado = prestamo_has_dispositivoDao.dispositivoPrestado(dispositivo);
			if (prestado == true) {
				Boolean disponible = dispositivoDao.consultarDispositivoDisponible(fechaInicio, fechaFin,
						dispositivo.getReferencia());
				if (disponible == false) {
					throw new MyException(
							"El dispositivo" + dispositivos[i] + " no esta disponible para el prestamo en esta fecha");
				}
			} else {
				if (!dispositivo.isDisponible()) {
					throw new MyException(
							"El dispositivo " + dispositivo.getReferencia() + "no se encuentra disponible");
				}
			}
		}
		// Asigna los valores entregados al objeto prestamo, ademas asigna el
		// numero 0 al estado que se refiere a que el prestamo no ha sido
		// aprobado
		prestamo.setCedulaUsuario(cedulaUsuario);
		prestamo.setCorreoUsuario(correoUsuario);
		prestamo.setEstado(0);
		prestamo.setFechaInicio(fechaInicio);
		prestamo.setFechaFin(fechaFin);
		prestamo.setNombreUsuario(nombreUsuario);
		// Se envia el objeto prestamo al metodo crear de la clase PrestamoDao
		prestamoDao.crear(prestamo);
		// Registra cada uno de los dispositivos seleccionados dentro del
		// prestamo en la tabla prestamo_has_dispositivo
		for (int i = 0; i < dispositivos.length; i++) {
			Prestamo_has_Dispositivo pd = new Prestamo_has_Dispositivo();
			Prestamo_has_DispositivoId id = new Prestamo_has_DispositivoId();
			Dispositivo dispositivoPrestamo = new Dispositivo();
			dispositivoPrestamo.setReferencia(dispositivos[i]);
			id.setPrestamo(prestamo);
			id.setReferencia(dispositivoPrestamo);
			pd.setId(id);
			prestamo_has_dispositivoDao.crear(pd);
		}

	}

	@Override
	public void modificar(int id, String correoAdministrador, int estado) throws MyException {
		// Verifica que los campos ingresados sean validos para las reglas de
		// negocio
		if (id == 0) {
			throw new MyException("Ingrese un identificador valido");
		}
		if (correoAdministrador == null || "".equals(correoAdministrador)) {
			throw new MyException("El administrador no es valido");
		}
		if (estado != 1 && estado != 2) {
			throw new MyException("Ingrese un estado valido");
		}
		// Verifica que el administrador indicado existe
		Administrador admin = administradorDao.consultarUno(correoAdministrador);
		if (admin == null) {
			throw new MyException("El administrador no es valido");
		}
		// Verifica que el prestamo con el id seleccionado existe
		Prestamo prestamo = prestamoDao.consultarUno(id);
		if (prestamo == null) {
			throw new MyException("No existe un prestamo con ese identificador");
		}
		// Asigna el nuevo estado al prestamo con el id especificado
		prestamo.setEstado(estado);
		//Asigna el administrador que acepto o rechazo la solicitud
		prestamo.setAdministrador(admin);
		// Envia el objeto prestamo al metodo modificar de la clase PrestamoDao
		prestamoDao.modificar(prestamo);
	}

	@Override
	public List<Prestamo> consultarTodos() throws MyException {
		List<Prestamo> prestamos = new ArrayList<Prestamo>();
		// Almacena en la lista de prestamos la lista retornada por el metodo
		// consultarTodo de la clase PrestamoDao
		prestamos = prestamoDao.consultarTodos();
		// Retorna la lista de prestamos
		return prestamos;
	}

	@Override
	public Prestamo consultarUno(int id) throws MyException {
		// Crea un objeto del tipo Prestamo
		Prestamo prestamo = new Prestamo();
		// Verifica que los campos ingresados sean validos para las reglas de
		// negocio
		if (id == 0) {
			throw new MyException("Ingrese un id valido");
		}
		// Verifica que existe el prestamo con el id especificado
		prestamo = prestamoDao.consultarUno(id);
		if (prestamo == null) {
			throw new MyException("No existe un prestamo con esta id");
		}
		// Retorna el prestamo
		return prestamo;
	}

	@Override
	public List<Prestamo> prestamosSinRevisar() throws MyException {
		List<Prestamo> prestamos = new ArrayList<Prestamo>();
		// Almacena en la lista de prestamos la lista retornada por el metodo
		// prestamoSinRevisar de la clase PrestamoDao
		prestamos = prestamoDao.prestamosSinRevisar();
		return prestamos;
	}

}
