package co.edu.udea.iw.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.iw.dao.PrestamoDao;
import co.edu.udea.iw.dto.Prestamo;
import co.edu.udea.iw.exception.MyException;

/**
 * Clase en la que se implementan los metodos definidos en la interface
 * PrestamoDao y se extiende de la clase HibernateDaoSupport que es la que
 * permite la integracion entre los frameworks de Hibernate y Spring, en esta
 * clase se realizaran las consultas, inserciones, borrados y actualizaciones de
 * los datos de un Prestamo en la BD
 * 
 * @author Carolina Isaza
 * @author Jaime Londono
 * @author Sebastien Jimenez
 *
 */
public class PrestamoDaoImpl extends HibernateDaoSupport implements PrestamoDao {

	@Override
	public List<Prestamo> consultarTodos() throws MyException {
		// Crea la lista de prestamos del tipo ArrayList
		List<Prestamo> prestamos = new ArrayList<Prestamo>();
		// Se crea una session con la que se obtendra una conexion fisica con la
		// Base de datos
		Session session = null;
		try {
			session = getSession();
			// Se crea un objeto Criteria en la que se especifica una consulta
			// en base a la clase Prestamo
			Criteria criteria = session.createCriteria(Prestamo.class);
			// se almacena en la lista de prestamos la lista devuelta por
			// la consulta realizada en la linea anterior
			prestamos = criteria.list();
		} catch (HibernateException e) {
			// Si se presenta un fallo en la conexion a la base de datos o a la
			// consulta se lanza una excepcion propia (MyException) con el
			// mensaje de error correspondiente
			throw new MyException(e);
		} finally {
			// session.close();
		}
		// Retorna la lista con los prestamos alojados en la base de datos
		return prestamos;
	}

	@Override
	public void crear(Prestamo prestamo) throws MyException {
		// Se crea una session con la que se obtendra una conexion fisica con la
		// Base de datos
		Session session = null;
		try {
			session = getSession();
			// Se crea un objeto del tipo Transaction y se le asigna la session,
			// lo anterior con el fin de comenzar operaciones en la base de
			// datos
			Transaction tx = session.beginTransaction();
			//// Se envia al metodo de guardar, correspondiente a session, el
			// Objeto Prestamo que se almacenara como nuevo registro en la
			// BD
			session.save(prestamo);
			// Se realiza el commit en la base de datos para que persistan los
			// objetos
			tx.commit();
		} catch (HibernateException e) {
			// Si se presenta un fallo en la conexion a la base de datos o en la
			// creacion de filas en la BD se lanza una excepcion propia
			// (MyException) con el mensaje de error correspondiente
			throw new MyException(e);
		} finally {
			// session.close();
		}

	}

	@Override
	public void modificar(Prestamo prestamo) throws MyException {
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
			// Objeto Prestamo al que se le actualizaran los datos
			session.update(prestamo);
			// Se realiza el commit en la base de datos para que persistan los
			// objetos
			tx.commit();
		} catch (HibernateException e) {
			// Si se presenta un fallo en la conexion a la base de datos o en la
			// actualizacion de la BD se lanza una excepcion propia
			// (MyException) con el mensaje de error correspondiente
			throw new MyException(e);
		} finally {
			// session.close();
		}

	}

	@Override
	public Prestamo consultarUno(int id) throws MyException {
		Prestamo prestamo;
		// Se crea una session con la que se obtendra una conexion fisica con la
		// Base de datos
		Session session = null;
		try {
			session = getSession();
			// Se crea un objeto Criteria en la que se especifica una consulta
			// en base a la clase Prestamo y se anade una restriccion para
			// que se realice la busqueda por el campo de idPrestamo
			Criteria criteria = session.createCriteria(Prestamo.class).add(Restrictions.eq("idPrestamo", id));
			// Se almacena en el objeto prestamo el resultado unico de la
			// busqueda realizada
			prestamo = (Prestamo) criteria.uniqueResult();
		} catch (HibernateException e) {
			// Si se presenta un fallo en la conexion a la base de datos o en la
			// consulta de la BD se lanza una excepcion propia
			// (MyException) con el mensaje de error correspondiente
			throw new MyException(e);
		} finally {
			// session.close();
		}
		// Retorna el prestamo resultante de la busqueda, si no hay
		// coincidencias retorna null
		return prestamo;
	}

	@Override
	public List<Prestamo> prestamosSinRevisar() throws MyException {
		List<Prestamo> prestamos = new ArrayList<Prestamo>();
		// Se crea una session con la que se obtendra una conexion fisica con la
		// Base de datos
		Session session = null;
		try {
			session = getSession();
			// Se crea un objeto Criteria en la que se especifica una consulta
			// en base a la clase Prestamo y se anade una restriccion para
			// que se realice la busqueda por el campo de estado
			Criteria criteria = session.createCriteria(Prestamo.class).add(Restrictions.eq("estado", 0));
			// se almacena en la lista de prestamos la lista devuelta por
			// la consulta realizada en la linea anterior
			prestamos = criteria.list();
		} catch (HibernateException e) {
			// Si se presenta un fallo en la conexion a la base de datos o en la
			// consulta de la BD se lanza una excepcion propia
			// (MyException) con el mensaje de error correspondiente
			throw new MyException(e);
		} finally {
			// session.close();
		}
		// Retorna los prestamos sin revisar
		return prestamos;
	}

	@Override
	public List<Prestamo> prestamoPorUsuario(String correoUsuario) throws MyException {
		List<Prestamo> prestamos = new ArrayList<Prestamo>();
		// Se crea una session con la que se obtendra una conexion fisica con la
		// Base de datos
		Session session = null;
		try {
			session = getSession();
			// Se crea un objeto Criteria en la que se especifica una consulta
			// en base a la clase Prestamo y se anade una restriccion para
			// que se realice la busqueda por el campo de correoUsuario
			Criteria criteria = session.createCriteria(Prestamo.class)
					.add(Restrictions.eq("correoUsuario", correoUsuario));
			// se almacena en la lista de prestamos la lista devuelta por
			// la consulta realizada en la linea anterior
			prestamos = criteria.list();
		} catch (HibernateException e) {
			// Si se presenta un fallo en la conexion a la base de datos o en la
			// consulta de la BD se lanza una excepcion propia
			// (MyException) con el mensaje de error correspondiente
			throw new MyException(e);
		} finally {
			// session.close();
		}
		// Retorna la lista de prestamos de un usuario dado
		return prestamos;
	}

}
