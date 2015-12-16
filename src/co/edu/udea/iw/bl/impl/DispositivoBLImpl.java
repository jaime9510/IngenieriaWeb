package co.edu.udea.iw.bl.impl;

import java.util.ArrayList;
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

public class DispositivoBLImpl implements DispositivoBL {

	DispositivoDao dispositivoDao;
	AdministradorDao administradorDao;

	public AdministradorDao getAdministradorDao() {
		return administradorDao;
	}

	public void setAdministradorDao(AdministradorDao administradorDao) {
		this.administradorDao = administradorDao;
	}

	public DispositivoDao getDispositivoDao() {
		return dispositivoDao;
	}

	public void setDispositivoDao(DispositivoDao dispositivoDao) {
		this.dispositivoDao = dispositivoDao;
	}

	public TipoDao getTipoDao() {
		return tipoDao;
	}

	public void setTipoDao(TipoDao tipoDao) {
		this.tipoDao = tipoDao;
	}

	TipoDao tipoDao;

	@Override
	public List<Dispositivo> consultarTodos() throws MyException {
		List<Dispositivo> dispositivos = new ArrayList<Dispositivo>();
		dispositivos = dispositivoDao.consultarTodos();
		return dispositivos;
	}

	@Override
	public void crearDispositivo(String referencia, String nombre, String descripcion, int tipo, String foto,
			String emailAdministrador) throws MyException {
		Dispositivo disp = new Dispositivo();
		Tipo tp = new Tipo();
		if (referencia == null || "".equals(referencia)) {
			throw new MyException("La referencia no es válida");
		}
		if (nombre == null || "".equals(nombre)) {
			throw new MyException("El nombre no es válido");
		}
		if (tipo == 0) {
			throw new MyException("El tipo no es válido");
		}
		if (foto == null || "".equals(foto)) {
			throw new MyException("La url de la foto no es válida");
		}
		if(emailAdministrador == null || "".equals(emailAdministrador)){
			throw new MyException("Ingrese un administrador válido");
		}
		Administrador administrador = administradorDao.consultarUno(emailAdministrador);
		if(administrador == null){
			throw new MyException("El administrador no existe");
		}
		Dispositivo dispositivo = dispositivoDao.consultarUno(referencia);
		if (dispositivo != null) {
			throw new MyException("Ya existe un dispositivo con esa referencia");
		}
		Tipo tipoDispositivo = tipoDao.consultarUno(tipo);
		if (tipoDispositivo == null) {
			throw new MyException("Seleccione un tipo de dispositivo válido");
		}
		
		tp.setId(tipo);
		disp.setReferencia(referencia);
		disp.setDescripcion(descripcion);
		disp.setDisponible(true);
		disp.setFoto(foto);
		disp.setNombre(nombre);
		disp.setReferencia(referencia);
		disp.setTipo(tp);
		dispositivoDao.crear(disp);
	}

	@Override
	public void actualizarDispositivo(String referencia, String nombre, String descripcion, int tipo, String foto,
			boolean disponible, String emailAdministrador) throws MyException {
		Tipo tp = new Tipo();
		if (referencia == null || "".equals(referencia)) {
			throw new MyException("La referencia no es válida");
		}
		if (nombre == null || "".equals(nombre)) {
			throw new MyException("El nombre no es válido");
		}
		if (tipo == 0) {
			throw new MyException("El tipo no es válido");
		}
		if (foto == null || "".equals(foto)) {
			throw new MyException("La url de la foto no es válida");
		}
		if(emailAdministrador == null || "".equals(emailAdministrador)){
			throw new MyException("Ingrese un administrador válido");
		}
		Administrador administrador = administradorDao.consultarUno(emailAdministrador);
		if(administrador == null){
			throw new MyException("El administrador no existe");
		}
		Dispositivo dispositivo = dispositivoDao.consultarUno(referencia);
		if (dispositivo == null) {
			throw new MyException("El dispositvo no existe");
		}
		Tipo tipoDispositivo = tipoDao.consultarUno(tipo);
		if (tipoDispositivo == null) {
			throw new MyException("Seleccione un tipo de dispositivo válido");
		}
		tp.setId(tipo);
		dispositivo.setDescripcion(descripcion);
		dispositivo.setDisponible(disponible);
		dispositivo.setFoto(foto);
		dispositivo.setNombre(nombre);
		dispositivo.setReferencia(referencia);
		dispositivo.setTipo(tp);
		dispositivoDao.crear(dispositivo);
	}

	@Override
	public void eliminarDispositivo(String referencia, String emailAdministrador) throws MyException {
		if (referencia == null || "".equals(referencia)) {
			throw new MyException("La referencia no es válida");
		}
		if(emailAdministrador == null || "".equals(emailAdministrador)){
			throw new MyException("Ingrese un administrador válido");
		}
		Administrador administrador = administradorDao.consultarUno(emailAdministrador);
		if(administrador == null){
			throw new MyException("El administrador no existe");
		}
		Dispositivo dispositivo = dispositivoDao.consultarUno(referencia);
		if (dispositivo == null) {
			throw new MyException("No existe un dispositivo con esa referencia");
		}
		dispositivoDao.eliminar(dispositivo);

	}

	@Override
	public List<Dispositivo> consultarPorTipo(int idTipo) throws MyException {
		List<Dispositivo> dispositivos = new ArrayList<Dispositivo>();
		Tipo tipo = new Tipo();
		if (idTipo == 0) {
			throw new MyException("El tipo no es válido");
		}
		tipo = tipoDao.consultarUno(idTipo);
		if (tipo == null) {
			throw new MyException("El tipo ingresado no existe");
		}
		dispositivos = dispositivoDao.consultarPorTipo(tipo);
		return dispositivos;
	}

	@Override
	public List<Dispositivo> consultarDisponibles() throws MyException {
		List<Dispositivo> dispositivos = new ArrayList<Dispositivo>();
		dispositivos = dispositivoDao.consultarDisponibles();
		return dispositivos;
	}

	@Override
	public Dispositivo consultarUno(String referencia) throws MyException {
		Dispositivo dispositivo = new Dispositivo();
		if (referencia == null || "".equals(referencia)) {
			throw new MyException("La referencia no es válida");
		}
		dispositivo = dispositivoDao.consultarUno(referencia);
		return dispositivo;
	}

}
