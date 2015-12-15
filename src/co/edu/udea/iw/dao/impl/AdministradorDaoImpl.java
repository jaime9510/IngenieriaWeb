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
 * Clase en la que se implementan los m�todos definidos en la interface
 * AdministradorDao y se extiende de la clase HibernateDaoSupport que es la que
 * permite la integraci�n entre los frameworks de Hibernate y Spring, en esta
 * clase se realizar�n las consultas, inserciones, borrados y actualizaciones de
 * los datos de un Administrador en la BD
 * 
 * @author Carolina Isaza
 * @author Jaime Londo�o
 * @author Sebasti�n Jim�nez
 *
 */
public class AdministradorDaoImpl extends HibernateDaoSupport implements AdministradorDao {

	@Override
	public List<Administrador> mostrarTodos() throws MyException {
		// Crea la lista de administradores del tipo ArrayList 
		List<Administrador> administradores = new ArrayList<Administrador>();
		// Se crea una session con la que se obtendr� una conexi�n f�sica con la
		// Base de datos
		Session session = null;
		try {
			session = getSession();
			// Se crea un objeto Criteria en la que se especifica una consulta
			// en base a la clase Administrador
			Criteria criteria = session.createCriteria(Administrador.class);
			// se almacena en la lista de administradores la lista devuelta por
			// la consulta realizada en la l�nea anterior
			administradores = criteria.list();
		} catch (HibernateException e) {
			// Si se presenta un fallo en la conexi�n a la base de datos o a la
			// consulta se lanza una excepci�n propia (MyException) con el
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
		// Se crea una session con la que se obtendr� una conexi�n f�sica con la
		// Base de datos
		Session session = null;
		try {
			session = getSession();
			// Se crea un objeto del tipo Transaction y se le asigna la session,
			// lo anterior con el fin de comenzar operaciones en la base de
			// datos
			Transaction tx = session.beginTransaction();
			// Se env�a al m�todo de guardar, correspondiente a session, el
			// Objeto Administrador que se almacenar� como nuevo registro en la
			// BD
			session.save(admin);
			// Se realiza el commit en la base de datos para que persistan los
			// objetos
			tx.commit();
		} catch (HibernateException e) {
			// Si se presenta un fallo en la conexi�n a la base de datos o en la
			// creaci�n de filas en la BD se lanza una excepci�n propia
			// (MyException) con el mensaje de error correspondiente
			throw new MyException(e);
		} finally {
			if(session!=null) {
				try {
					session.close();
				} catch(HibernateException e) {
					throw new MyException(e);
				}
			}
			// Se cierra la Sesi�n
			// session.close();
		}

	}

	@Override
	public void actualizar(Administrador admin) throws MyException {
		// Se crea una session con la que se obtendr� una conexi�n f�sica con la
		// Base de datos
		Session session = null;
		try {
			session = getSession();
			// Se crea un objeto del tipo Transaction y se le asigna la session,
			// lo anterior con el fin de comenzar operaciones en la base de
			// datos
			Transaction tx = session.beginTransaction();
			// Se env�a al m�todo de actualizar, correspondiente a session, el
			// Objeto Administrador al que se le actualizar�n los datos
			session.update(admin);
			// Se realiza el commit en la base de datos para que persistan los
			// objetos
			tx.commit();
		} catch (HibernateException e) {
			// Si se presenta un fallo en la conexi�n a la base de datos o en la
			// actualizaci�n de la BD se lanza una excepci�n propia
			// (MyException) con el mensaje de error correspondiente
			throw new MyException(e);
		} finally {
			// Se cierra la sesi�n
			// session.close();
		}

	}

	@Override
	public void eliminar(Administrador admin) throws MyException {
		// Se crea una session con la que se obtendr� una conexi�n f�sica con la
		// Base de datos
		Session session = null;
		try {
			session = getSession();
			// Se crea un objeto del tipo Transaction y se le asigna la session,
			// lo anterior con el fin de comenzar operaciones en la base de
			// datos
			Transaction tx = session.beginTransaction();
			// Se realiza un borrado f�sico de la BD del administrador enviado
			// como par�metro
			session.delete(admin);
			// Se realiza el commit en la base de datos para que persistan los
			// objetos
			tx.commit();
		} catch (HibernateException e) {
			// Si se presenta un fallo en la conexi�n a la base de datos o en la
			// eliminaci�n de la BD se lanza una excepci�n propia
			// (MyException) con el mensaje de error correspondiente
			throw new MyException(e);
		} finally {
			// Se cierra la sesi�n
			// session.close();
		}

	}

	@Override
	public Administrador consultarUno(String email) throws MyException {
		// Se crea un objeto del tipo Administrador
		Administrador administrador;
		// Se crea una session con la que se obtendr� una conexi�n f�sica con la
		// Base de datos
		Session session = null;
		try {
			session = getSession();
			// Se crea un objeto Criteria en la que se especifica una consulta
			// en base a la clase Administrador y se a�ade una restricci�n para
			// que se realice la b�squeda por el campo de email
			Criteria criteria = session.createCriteria(Administrador.class).add(Restrictions.eq("email", email));
			// Se almacena en el objeto administrador el resultado �nico de la
			// b�squeda realizada
			administrador = (Administrador) criteria.uniqueResult();
		} catch (HibernateException e) {
			// Si se presenta un fallo en la conexi�n a la base de datos o en la
			// consulta de la BD se lanza una excepci�n propia
			// (MyException) con el mensaje de error correspondiente
			throw new MyException(e);
		} finally {
			// Se cierra la sesi�n
			// session.close();
		}
		//Retorna el administrador resultante de la b�squeda, si no existe retorna nulo
		return administrador;
	}

}
