package co.edu.udea.iw.bl.impl;

import co.edu.udea.iw.bl.AdministradorBL;
import co.edu.udea.iw.dao.AdministradorDao;
import co.edu.udea.iw.dto.Administrador;
import co.edu.udea.iw.encode.Cifrar;
import co.edu.udea.iw.exception.MyException;
import co.edu.udea.iw.validations.Validaciones;

/**
 * Clase en la que se implementan los metodos de la interface AdministradorBL.
 * En esta clase se implementaran todos los metodos correspondientes a la logica
 * del negocio definida para el Rol Administrador.
 * 
 * @author Carolina Isaza
 * @author Jaime Londono
 * @author Sebastian Jimenez
 *
 */
public class AdministradorBLImpl implements AdministradorBL {

	/**
	 * Objeto de la capa Dao definido para un administrador, este objeto sera
	 * inyectado desde el archivo de configuracion de Spring.
	 */
	AdministradorDao administradorDao;

	// Getters & Setters inyeccion de dependencias
	/**
	 * Metodo para acceder al objeto AdministradorDao.
	 * 
	 * @return administradorDao Objeto de la clase administradorDao.
	 */
	public AdministradorDao getAdministradorDao() {
		return administradorDao;
	}

	/**
	 * Metodo para asignar un valor de tipo administradorDao al objeto
	 * administradorDao de esta clase.
	 * 
	 * @param administradorDao
	 *            Objeto del tipo administradorDao con los atributos definidos
	 *            para la misma.
	 */
	public void setAdministradorDao(AdministradorDao administradorDao) {
		this.administradorDao = administradorDao;
	}

	@Override
	public boolean login(String email, String pass) throws MyException {
		// Crea objetos del tipo Administrador, Validaciones y Cifrar
		Administrador admin = new Administrador();
		Validaciones validar = new Validaciones();
		Cifrar cifrar = new Cifrar();

		// Verifica que los campos ingresados sean validos para las reglas de
		// negocio
		if (email == null || "".equals(email)) {
			throw new MyException("EL Email no es valido");
		}
		if (!validar.isEmail(email)) {
			// Valida que el email tenga la estructura "email@servidor.com"
			throw new MyException("EL Email no es valido");
		}
		if (pass == null || "".equals(pass)) {
			throw new MyException("Ingrese una contrasena");
		}
		// Verifica que exista un administrador con el email ingresado
		admin = administradorDao.consultarUno(email);
		if (admin != null) {
			// Si el administrador existe verifica que la contrasena ingresada
			// coincida con la de la base de datos
			if (cifrar.encrypt(pass).equals(admin.getContrasena())) {
				// Devuelve true si la contrasena coincide
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
		// Crea objetos del tipo Administrador, Validaciones y Cifrar
		Administrador admin = new Administrador();
		Validaciones validar = new Validaciones();
		Cifrar cifrar = new Cifrar();
		// Verifica que los campos ingresados sean validos para las reglas de
		// negocio
		if (email == null || "".equals(email)) {
			// Valida que el email tenga la estructura "email@servidor.com"
			if (!validar.isEmail(email)) {
				throw new MyException("EL Email no es valido");
			}
		}
		if (contrasena == null || "".equals(contrasena)) {
			throw new MyException("La contrasena no es valida");
		}
		if (nombre == null || "".equals(nombre)) {
			throw new MyException("El nombre no es valida");
		}
		if (apellido == null || "".equals(apellido)) {
			throw new MyException("El apellido no es valida");
		}
		// Verifica que no exista un administrador con el mismo email definido
		// para la creacion del administrador
		Administrador administrador = administradorDao.consultarUno(email);
		if (administrador != null) {
			throw new MyException("Ya existe un administrador con este email");
		}
		// Asigna los datos proporcionados por el administrador al objeto admin
		admin.setApellidos(apellido);
		admin.setEmail(email);
		admin.setNombre(nombre);
		admin.setContrasena(cifrar.encrypt(contrasena));
		// Llama al metodo crear de la clase AdministradorDao con el objeto
		// admin
		administradorDao.crear(admin);
	}

	@Override
	public void actualizarPassAdministrador(String email, String contrasenaNueva, String contrasenaVieja)
			throws MyException {
		// Crea objetos del tipo Administrador, Validaciones y Cifrar
		Administrador admin = new Administrador();
		Validaciones validar = new Validaciones();
		Cifrar cifrar = new Cifrar();
		// Verifica que los campos ingresados sean validos para las reglas de
		// negocio
		if (email == null || "".equals(email)) {
			// Valida que el email tenga la estructura "email@servidor.com"
			if (!validar.isEmail(email)) {
				throw new MyException("EL Email no es valido");
			}
		}
		if (contrasenaNueva == null || "".equals(contrasenaNueva)) {
			throw new MyException("La contrasena no es valida");
		}
		if (contrasenaVieja == null || "".equals(contrasenaVieja)) {
			throw new MyException("La contrasena no es valida");
		}
		// Verifica que exista el administrador con el email enviado al metodo
		admin = administradorDao.consultarUno(email);
		if (admin == null) {
			throw new MyException("No existe un administrador con ese email");
		}
		// Verifica que la contrasena enviada como anterior sea igual a la que
		// se encuentra en la base de datos
		if (cifrar.encrypt(contrasenaVieja).equals(admin.getContrasena())) {
			// Si la contrasena vieja es correcta, asigna al objeto admin la
			// nueva contrasena
			admin.setContrasena(cifrar.encrypt(contrasenaNueva));
			// Envia al metodo actualizar de la clase AdministradorDao el objeto
			// admin con la nueva contrasena
			administradorDao.actualizar(admin);
		} else {
			throw new MyException("La contrasena no es correcta");
		}

	}

	@Override
	public void eliminarAdministrador(String email, String contrasena) throws MyException {
		// Crea objetos del tipo Administrador, Validaciones y Cifrar
		Administrador admin = new Administrador();
		Validaciones validar = new Validaciones();
		Cifrar cifrar = new Cifrar();
		// Verifica que los campos ingresados sean validos para las reglas de
		// negocio
		if (email == null || "".equals(email)) {
			// Valida que el email tenga la estructura "email@servidor.com"
			if (!validar.isEmail(email)) {
				throw new MyException("EL Email no es valido");
			}
		}
		if (contrasena == null || "".equals(contrasena)) {
			throw new MyException("La contrasena no es valida");
		}
		// Valida que exista un administrador con el email ingresado
		admin = administradorDao.consultarUno(email);
		if (admin == null) {
			throw new MyException("No existe un administrador con este email");
		}
		// Verifica que la contrasena ingresada es igual a la registrada en la
		// base de datos
		if (admin.getContrasena().equals(cifrar.encrypt(contrasena))) {
			// Si las contrasenas coinciden se llama al metodo eliminar de la
			// clase AdministradorDao con los datos del admin
			administradorDao.eliminar(admin);
		} else {
			throw new MyException("Contrasena erronea");
		}

	}

}
