package co.edu.udea.iw.bl.impl;

import java.util.ArrayList;
import java.util.List;

import co.edu.udea.iw.bl.AdministradorBL;
import co.edu.udea.iw.dao.AdministradorDao;
import co.edu.udea.iw.dto.Administrador;
import co.edu.udea.iw.encode.Cifrar;
import co.edu.udea.iw.exception.MyException;
import co.edu.udea.iw.validations.Validaciones;

public class AdministradorBLImpl implements AdministradorBL {

	AdministradorDao administradorDao;

	public AdministradorDao getAdministradorDao() {
		return administradorDao;
	}

	public void setAdministradorDao(AdministradorDao administradorDao) {
		this.administradorDao = administradorDao;
	}

	

	@Override
	public boolean login(String email, String pass) throws MyException {
		Administrador admin = new Administrador();
		Validaciones validar = new Validaciones();
		Cifrar cifrar = new Cifrar();
		if (email == null || "".equals(email)) {
			if (!validar.isEmail(email)) {
				throw new MyException("EL Email no es válido");
			}
		}
		if (pass == null || "".equals(pass)) {
			throw new MyException("Ingrese una contraseña");
		}
		admin = administradorDao.consultarUno(email);
		if (admin != null) {
			if (cifrar.encrypt(pass).equals(admin.getContrasena())) {
				return Boolean.TRUE;
			} else {
				return Boolean.FALSE;
			}
		} else {
			return Boolean.FALSE;
		}
	}

	@Override
	public void crearAdministrador(String email, String contrasena, String nombre, String apellido) throws MyException {
		Administrador admin = new Administrador();
		Validaciones validar = new Validaciones();
		Cifrar cifrar = new Cifrar();
		if (email == null || "".equals(email)) {
			if (!validar.isEmail(email)) {
				throw new MyException("EL Email no es válido");
			}
		}
		if (contrasena == null || "".equals(contrasena)) {
			throw new MyException("La contraseña no es válida");
		}
		if (nombre == null || "".equals(nombre)) {
			throw new MyException("El nombre no es válido");
		}
		if (apellido == null || "".equals(apellido)) {
			throw new MyException("El apellido no es válido");
		}
		Administrador administrador = administradorDao.consultarUno(email);
		if (administrador != null) {
			throw new MyException("Ya existe un administrador con este email");
		}
		
		admin.setApellidos(apellido);
		admin.setEmail(email);
		admin.setNombre(nombre);
		admin.setContrasena(cifrar.encrypt(contrasena));
		administradorDao.crear(admin);
	}

	@Override
	public void actualizarAdministrador(String email, String contrasena, String nombre, String apellido)
			throws MyException {
		Administrador admin = new Administrador();
		Validaciones validar = new Validaciones();
		Cifrar cifrar = new Cifrar();
		if (email == null || "".equals(email)) {
			if (!validar.isEmail(email)) {
				throw new MyException("EL Email no es válido");
			}
		}
		if (contrasena == null || "".equals(contrasena)) {
			throw new MyException("La contraseña no es válida");
		}
		if (nombre == null || "".equals(nombre)) {
			throw new MyException("El nombre no es válido");
		}
		if (apellido == null || "".equals(apellido)) {
			throw new MyException("El apellido no es válido");
		}
		admin = administradorDao.consultarUno(email);
		if(admin == null){
			throw new MyException("No existe un administrador con ese email");
		}
		admin.setApellidos(apellido);
		admin.setNombre(nombre);
		admin.setContrasena(cifrar.encrypt(contrasena));
		
		administradorDao.actualizar(admin);

	}

	@Override
	public void eliminarAdministrador(String email, String contrasena) throws MyException {
		Administrador admin = new Administrador();
		Validaciones validar = new Validaciones();
		Cifrar cifrar = new Cifrar();
		if (email == null || "".equals(email)) {
			if (!validar.isEmail(email)) {
				throw new MyException("EL Email no es válido");
			}
		}
		if (contrasena == null || "".equals(contrasena)) {
			throw new MyException("La contraseña no es válida");
		}
		admin = administradorDao.consultarUno(email);
		if(admin == null){
			throw new MyException("No existe un administrador con este email");
		}
		if(admin.getContrasena().equals(cifrar.encrypt(contrasena))){
			administradorDao.eliminar(admin);
		}else{
			throw new MyException("Contraseña érronea");
		}

	}

}
