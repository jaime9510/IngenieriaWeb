package co.edu.udea.iw.bl.impl;

import java.util.ArrayList;
import java.util.Date;
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

public class PrestamoBLImpl implements PrestamoBL {

	AdministradorDao administradorDao;
	PrestamoDao prestamoDao;
	Prestamo_has_DispositivoDao prestamo_has_dispositivoDao;
	DispositivoDao dispositivoDao;
	
	public AdministradorDao getAdministradorDao() {
		return administradorDao;
	}

	public void setAdministradorDao(AdministradorDao administradorDao) {
		this.administradorDao = administradorDao;
	}

	public PrestamoDao getPrestamoDao() {
		return prestamoDao;
	}

	public void setPrestamoDao(PrestamoDao prestamoDao) {
		this.prestamoDao = prestamoDao;
	}

	public Prestamo_has_DispositivoDao getPrestamo_has_dispositivoDao() {
		return prestamo_has_dispositivoDao;
	}

	public void setPrestamo_has_dispositivoDao(Prestamo_has_DispositivoDao prestamo_has_dispositivoDao) {
		this.prestamo_has_dispositivoDao = prestamo_has_dispositivoDao;
	}

	public DispositivoDao getDispositivoDao() {
		return dispositivoDao;
	}

	public void setDispositivoDao(DispositivoDao dispositivoDao) {
		this.dispositivoDao = dispositivoDao;
	}



	public void crear(String nombreUsuario, String cedulaUsuario, String correoUsuario, String correoAdmin,
			Date fechaInicio, Date fechaFin, String[] dispositivos) throws MyException {
		Prestamo prestamo = new Prestamo();
		if (nombreUsuario == null || "".equals(nombreUsuario)) {
			throw new MyException("Ingrese un nombre de usuario valido");
		}
		if (cedulaUsuario == null || "".equals(cedulaUsuario)) {
			throw new MyException("Ingrese una cédula de usuario valida");
		}
		if (correoAdmin == null || "".equals(correoAdmin)) {
			throw new MyException("El correo del administrador no es valido");
		}
		if (fechaInicio == null || fechaInicio.getHours() < 8 || fechaInicio.getHours() > 18) {
			throw new MyException("Ingrese una fecha valida");
		}
		if (fechaFin == null || fechaFin.getHours() < 8 || fechaFin.getHours() > 18) {
			throw new MyException("Ingrese una fecha de fin de prestamo valida");
		}
		if (dispositivos.length < 1) {
			throw new MyException("Seleccione los dispositivos para el préstamo");
		}
		Administrador administrador = administradorDao.consultarUno(correoAdmin);
		if (administrador == null) {
			throw new MyException("El administrador no existe");
		}
		for (int i = 0; i < dispositivos.length; i++) {
			Dispositivo dispositivo = dispositivoDao.consultarUno(dispositivos[i]);
			if (dispositivo == null) {
				throw new MyException("Uno de los dispositivos no existe");
			}
			Boolean disponible = dispositivoDao.consultarDispositivoDisponible(fechaInicio, fechaFin,
					dispositivo.getReferencia());
			if (disponible == false) {
				throw new MyException(
						"El dispositivo" + dispositivos[i] + " no está disponible para el prestamo en esta fecha");
			}
		}
		prestamo.setAdministrador(administrador);
		prestamo.setCedulaUsuario(cedulaUsuario);
		prestamo.setCorreoUsuario(correoUsuario);
		prestamo.setEstado(0);
		prestamo.setFechaInicio(fechaInicio);
		prestamo.setFechaFin(fechaFin);
		prestamo.setNombreUsuario(nombreUsuario);
		prestamoDao.crear(prestamo);
		for(int i = 0; i< dispositivos.length;i++){
			Prestamo_has_Dispositivo pd = new Prestamo_has_Dispositivo();
			Prestamo_has_DispositivoId id= new Prestamo_has_DispositivoId();
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
		if (id == 0) {
			throw new MyException("Ingrese un identificador valido");
		}
		if (correoAdministrador == null || "".equals(correoAdministrador)) {
			throw new MyException("El administrador no es valido");
		}
		if (estado != 1 && estado != 2) {
			throw new MyException("Ingrese un estado valido");
		}
		Administrador admin = administradorDao.consultarUno(correoAdministrador);
		if (admin == null) {
			throw new MyException("El administrador no es valido");
		}
		Prestamo prestamo = prestamoDao.consultarUno(id);
		if (prestamo == null) {
			throw new MyException("No existe un prestamo con ese identificador");
		}
		prestamo.setEstado(estado);
		prestamoDao.modificar(prestamo);
	}

	@Override
	public List<Prestamo> consultarTodos() throws MyException {
		List<Prestamo> prestamos = new ArrayList<Prestamo>();
		prestamos= prestamoDao.consultarTodos();
		return prestamos;
	}

	@Override
	public Prestamo consultarUno(int id) throws MyException {
		Prestamo prestamo = new Prestamo();
		if(id ==0){
			throw new MyException("Ingrese un id valido");
		}
		prestamo = prestamoDao.consultarUno(id);
		if(prestamo== null){
			throw new MyException("No existe un prestamo con esta id");
		}
		return prestamo;
	}

	@Override
	public List<Prestamo> prestamosSinRevisar() throws MyException {
		List<Prestamo> prestamos = new ArrayList<Prestamo>();
		prestamos= prestamoDao.prestamosSinRevisar();
		return prestamos;
	}

}
