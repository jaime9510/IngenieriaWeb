package co.edu.udea.iw.bl.impl;

import java.util.Date;

import co.edu.udea.iw.bl.PrestamoBL;
import co.edu.udea.iw.dao.AdministradorDao;
import co.edu.udea.iw.dao.DispositivoDao;
import co.edu.udea.iw.dao.PrestamoDao;
import co.edu.udea.iw.dao.Prestamo_has_DispositivoDao;
import co.edu.udea.iw.dto.Administrador;
import co.edu.udea.iw.dto.Dispositivo;
import co.edu.udea.iw.dto.Prestamo;
import co.edu.udea.iw.exception.MyException;

public class PrestamoBLImpl implements PrestamoBL {

	AdministradorDao administradorDao;
	PrestamoDao prestamoDao;
	Prestamo_has_DispositivoDao prestamo_has_dispositivoDao;
	DispositivoDao dispositivoDao;
	
	public void crear(String nombreUsuario, String cedulaUsuario, String correoUsuario, String correoAdmin,
			Date fechaInicio, Date fechaFin, String[] dispositivos) throws MyException {
		if (nombreUsuario == null || "".equals(nombreUsuario)) {
			throw new MyException("Ingrese un nombre de usuario valido");
		}
		if (cedulaUsuario == null || "".equals(cedulaUsuario)) {
			throw new MyException("Ingrese una cédula de usuario valida");
		}
		if (correoAdmin == null || "".equals(correoAdmin)) {
			throw new MyException("El correo del administrador no es valido");
		}
		if(fechaInicio == null || fechaInicio.getHours()< 8 || fechaInicio.getHours()> 18){
			throw new MyException("Ingrese una fecha valida");
		}
		if(fechaFin == null || fechaFin.getHours()<8 || fechaFin.getHours()> 18){
			throw new MyException("Ingrese una fecha de fin de prestamo valida");
		}
		if(dispositivos.length < 1){
			throw new MyException("Seleccione los dispositivos para el préstamo");
		}
		Administrador administrador = administradorDao.consultarUno(correoAdmin);
		if(administrador == null){
			throw new MyException("El administrador no existe");
		}
		for(int i= 0; i<= dispositivos.length; i++){
			Dispositivo dispositivo = dispositivoDao.consultarUno(dispositivos[i]);
			if(dispositivo == null){
				throw new MyException("Uno de los dispositivos no existe");
			}
		}
		
		

	}

	@Override
	public void modificar(int id,String correoAdministrador, int estado) throws MyException {
		if(id == 0){
			throw new MyException("Ingrese un identificador valido");
		}
		if(correoAdministrador == null || "".equals(correoAdministrador)){
			throw new MyException("El administrador no es valido");
		}
		if(estado != 1 || estado!=2){
			throw new MyException("Ingrese un estado valido");
		}
		Administrador admin = administradorDao.consultarUno(correoAdministrador);
		if(admin == null){
			throw new MyException("El administrador no es valido");
		}
		Prestamo prestamo = prestamoDao.consultarUno(id);
		if(prestamo == null){
			throw new MyException("No existe un prestamo con ese identificador");
		}
		prestamo.setEstado(estado);
	}

}
