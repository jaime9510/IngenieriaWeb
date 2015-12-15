package co.edu.udea.iw.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import co.edu.udea.iw.dao.AdministradorDao;
import co.edu.udea.iw.dto.Administrador;
import co.edu.udea.iw.exception.MyException;

/**
 * Clase en la que se implementan los métodos definidos en la interface
 * AdministradorDao y se extiende de la clase HibernateDaoSupport que es la que
 * permite la integración entre los frameworks de Hibernate y Spring, en esta
 * clase se realizarán las consultas, inserciones, borrados y actualizaciones de
 * los datos de un Administrador en la BD
 * 
 * @author Carolina Isaza
 * @author Jaime Londoño
 * @author Sebastián Jiménez
 *
 */
public class AdministradorDaoImpl extends HibernateDaoSupport implements AdministradorDao {

	@Override
	public List<Administrador> mostrarTodos() throws MyException {
		// Crea la lista de administradores del tipo ArrayList 
		List<Administrador> administradores = new ArrayList<Administrador>();
		// Se crea una session con la que se obtendrá una conexión física con la
		// Base de datos
		Session session = null;
		try {
			session = getSession();
			// Se crea un objeto Criteria en la que se especifica una consulta
			// en base a la clase Administrador
			Criteria criteria = session.createCriteria(Administrador.class);
			// se almacena en la lista de administradores la lista devuelta por
			// la consulta realizada en la línea anterior
			administradores = criteria.list();
		} catch (HibernateException e) {
			// Si se presenta un fallo en la conexión a la base de datos o a la
			// consulta se lanza una excepción propia (MyException) con el
			// mensaje de error correspondiente
			throw new MyException(e);
		} finally {
			// Se cierra la sesión
			// session.close();
		}
		// Retorna la lista con los administradores encontrados en la base de
		// datos
		return administradores;
	}

	@Override
	public void crear(Administrador admin) throws MyException {
		// Se crea una session con la que se obtendrá una conexión física con la
		// Base de datos
		Session session = null;
		try {
			session = getSession();
			// Se crea un objeto del tipo Transaction y se le asigna la session,
			// lo anterior con el fin de comenzar operaciones en la base de
			// datos
			Transaction tx = session.beginTransaction();
			// Se envía al método de guardar, correspondiente a session, el
			// Objeto Administrador que se almacenará como nuevo registro en la
			// BD
			session.save(admin);
			// Se realiza el commit en la base de datos para que persistan los
			// objetos
			tx.commit();
		} catch (HibernateException e) {
			// Si se presenta un fallo en la conexión a la base de datos o en la
			// creación de filas en la BD se lanza una excepción propia
			// (MyException) con el mensaje de error correspondiente
			throw new MyException(e);
		} finally {
			// Se cierra la Sesión
			// session.close();
		}

	}

	@Override
	public void actualizar(Administrador admin) throws MyException {
		// Se crea una session con la que se obtendrá una conexión física con la
		// Base de datos
		Session session = null;
		try {
			session = getSession();
			// Se crea un objeto del tipo Transaction y se le asigna la session,
			// lo anterior con el fin de comenzar operaciones en la base de
			// datos
			Transaction tx = session.beginTransaction();
			// Se envía al método de actualizar, correspondiente a session, el
			// Objeto Administrador al que se le actualizarán los datos
			session.update(admin);
			// Se realiza el commit en la base de datos para que persistan los
			// objetos
			tx.commit();
		} catch (HibernateException e) {
			// Si se presenta un fallo en la conexión a la base de datos o en la
			// actualización de la BD se lanza una excepción propia
			// (MyException) con el mensaje de error correspondiente
			throw new MyException(e);
		} finally {
			// Se cierra la sesión
			// session.close();
		}

	}

	@Override
	public void eliminar(Administrador admin) throws MyException {
		// Se crea una session con la que se obtendrá una conexión física con la
		// Base de datos
		Session session = null;
		try {
			session = getSession();
			// Se crea un objeto del tipo Transaction y se le asigna la session,
			// lo anterior con el fin de comenzar operaciones en la base de
			// datos
			Transaction tx = session.beginTransaction();
			// Se realiza un borrado físico de la BD del administrador enviado
			// como parámetro
			session.delete(admin);
			// Se realiza el commit en la base de datos para que persistan los
			// objetos
			tx.commit();
		} catch (HibernateException e) {
			// Si se presenta un fallo en la conexión a la base de datos o en la
			// eliminación de la BD se lanza una excepción propia
			// (MyException) con el mensaje de error correspondiente
			throw new MyException(e);
		} finally {
			// Se cierra la sesión
			// session.close();
		}

	}

	@Override
	public Administrador consultarUno(String email) throws MyException {
		// Se crea un objeto del tipo Administrador
		Administrador administrador;
		// Se crea una session con la que se obtendrá una conexión física con la
		// Base de datos
		Session session = null;
		try {
			session = getSession();
			// Se crea un objeto Criteria en la que se especifica una consulta
			// en base a la clase Administrador y se añade una restricción para
			// que se realice la búsqueda por el campo de email
			Criteria criteria = session.createCriteria(Administrador.class).add(Restrictions.eq("email", email));
			// Se almacena en el objeto administrador el resultado único de la
			// búsqueda realizada
			administrador = (Administrador) criteria.uniqueResult();
		} catch (HibernateException e) {
			// Si se presenta un fallo en la conexión a la base de datos o en la
			// consulta de la BD se lanza una excepción propia
			// (MyException) con el mensaje de error correspondiente
			throw new MyException(e);
		} finally {
			// Se cierra la sesión
			// session.close();
		}
		//Retorna el administrador resultante de la búsqueda, si no existe retorna nulo
		return administrador;
	}

}
