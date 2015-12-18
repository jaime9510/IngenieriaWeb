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
 * Clase en la que se implementan los metodos definidos en la interface
 * AdministradorDao y se extiende de la clase HibernateDaoSupport que es la que
 * permite la integracion entre los frameworks de Hibernate y Spring, en esta
 * clase se realizaran las consultas, inserciones, borrados y actualizaciones de
 * los datos de un Administrador en la BD
 * 
 * @author Carolina Isaza
 * @author Jaime Londono
 * @author Sebastian Jimenez
 *
 */
public class AdministradorDaoImpl extends HibernateDaoSupport implements AdministradorDao {

	@Override
	public List<Administrador> mostrarTodos() throws MyException {
		// Crea la lista de administradores del tipo ArrayList
		List<Administrador> administradores = new ArrayList<Administrador>();
		// Se crea una session con la que se obtendra una conexion fisica con la
		// Base de datos
		Session session = null;
		try {
			session = getSession();
			// Se crea un objeto Criteria en la que se especifica una consulta
			// en base a la clase Administrador
			Criteria criteria = session.createCriteria(Administrador.class);
			// se almacena en la lista de administradores la lista devuelta por
			// la consulta realizada en la linea anterior
			administradores = criteria.list();
		} catch (HibernateException e) {
			// Si se presenta un fallo en la conexion a la base de datos o a la
			// consulta se lanza una excepcion propia (MyException) con el
			// mensaje de error correspondiente
			throw new MyException(e);
		} finally {
			// Se cierra la sesi�n
			// session.close();
		}
		// Retorna la lista con los administradores encontrados en la base de
		// datos
		return administradores;
	}

	@Override
	public void crear(Administrador admin) throws MyException {
		// Se crea una session con la que se obtendra una conexion fisica con la
		// Base de datos
		Session session = null;
		try {
			session = getSession();
			// Se crea un objeto del tipo Transaction y se le asigna la session,
			// lo anterior con el fin de comenzar operaciones en la base de
			// datos
			Transaction tx = session.beginTransaction();
			// Se envia al metodo de guardar, correspondiente a session, el
			// Objeto Administrador que se almacenara como nuevo registro en la
			// BD
			session.save(admin);
			// Se realiza el commit en la base de datos para que persistan los
			// objetos
			tx.commit();
		} catch (HibernateException e) {
			// Si se presenta un fallo en la conexion a la base de datos o en la
			// creacion de filas en la BD se lanza una excepcion propia
			// (MyException) con el mensaje de error correspondiente
			throw new MyException(e);
		} finally {
			if (session != null) {
				try {
					session.close();
				} catch (HibernateException e) {
					throw new MyException(e);
				}
			}
			// Se cierra la Sesion
			// session.close();
		}

	}

	@Override
	public void actualizar(Administrador admin) throws MyException {
		// Se crea una session con la que se obtendra una conexion fisica con la
		// Base de datos
		Session session = null;
		try {
			session = getSession();
			// Se crea un objeto del tipo Transaction y se le asigna la session,
			// lo anterior con el fin de comenzar operaciones en la base de
			// datos
			Transaction tx = session.beginTransaction();
			// Se envia al metodo de actualizar, correspondiente a session, el
			// Objeto Administrador al que se le actualizaran los datos
			session.update(admin);
			// Se realiza el commit en la base de datos para que persistan los
			// objetos
			tx.commit();
		} catch (HibernateException e) {
			// Si se presenta un fallo en la conexion a la base de datos o en la
			// actualizacion de la BD se lanza una excepcion propia
			// (MyException) con el mensaje de error correspondiente
			throw new MyException(e);
		} finally {
			// Se cierra la sesion
			// session.close();
		}

	}

	@Override
	public void eliminar(Administrador admin) throws MyException {
		// Se crea una session con la que se obtendra una conexion fisica con la
		// Base de datos
		Session session = null;
		try {
			session = getSession();
			// Se crea un objeto del tipo Transaction y se le asigna la session,
			// lo anterior con el fin de comenzar operaciones en la base de
			// datos
			Transaction tx = session.beginTransaction();
			// Se realiza un borrado fisico de la BD del administrador enviado
			// como parametro
			session.delete(admin);
			// Se realiza el commit en la base de datos para que persistan los
			// objetos
			tx.commit();
		} catch (HibernateException e) {
			// Si se presenta un fallo en la conexion a la base de datos o en la
			// eliminacion de la BD se lanza una excepcion propia
			// (MyException) con el mensaje de error correspondiente
			throw new MyException(e);
		} finally {
			// Se cierra la sesion
			// session.close();
		}

	}

	@Override
	public Administrador consultarUno(String email) throws MyException {
		// Se crea un objeto del tipo Administrador
		Administrador administrador;
		// Se crea una session con la que se obtendra una conexion fisica con la
		// Base de datos
		Session session = null;
		try {
			session = getSession();
			// Se crea un objeto Criteria en la que se especifica una consulta
			// en base a la clase Administrador y se anade una restriccion para
			// que se realice la busqueda por el campo de email
			Criteria criteria = session.createCriteria(Administrador.class).add(Restrictions.eq("email", email));
			// Se almacena en el objeto administrador el resultado unico de la
			// busqueda realizada
			administrador = (Administrador) criteria.uniqueResult();
		} catch (HibernateException e) {
			// Si se presenta un fallo en la conexion a la base de datos o en la
			// consulta de la BD se lanza una excepcion propia
			// (MyException) con el mensaje de error correspondiente
			throw new MyException(e);
		} finally {
			// Se cierra la sesion
			// session.close();
		}
		// Retorna el administrador resultante de la busqueda, si no existe
		// retorna nulo
		return administrador;
	}

}
