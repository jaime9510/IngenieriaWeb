package co.edu.udea.iw.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.iw.dao.FalloDao;
import co.edu.udea.iw.dto.Dispositivo;
import co.edu.udea.iw.dto.Fallo;
import co.edu.udea.iw.exception.MyException;

/**
 * Clase en la que se implementan los metodos definidos en la interface
 * FalloDao y se extiende de la clase HibernateDaoSupport que es la que
 * permite la integracion entre los frameworks de Hibernate y Spring, en esta
 * clase se realizaran las consultas, inserciones, borrados y actualizaciones de
 * los datos de un Fallo en la BD
 * 
 * @author Carolina Isaza
 * @author Jaime Londoño
 * @author Sebastián Jiménez
 *
 */
public class FalloDaoImpl extends HibernateDaoSupport implements FalloDao {

	@Override
	public List<Fallo> consultarTodos() throws MyException {
		// Crea la lista de fallos del tipo ArrayList
		List<Fallo> fallos = new ArrayList<Fallo>();
		// Se crea una session con la que se obtendrá una conexión física con la
		// Base de datos
		Session session = null;
		try {
			session = getSession();
			// Se crea un objeto Criteria en la que se especifica una consulta
			// en base a la clase Fallo
			Criteria criteria = session.createCriteria(Fallo.class);
			// se almacena en la lista de fallos la lista devuelta por
			// la consulta realizada en la linea anterior
			fallos = criteria.list();
		} catch (HibernateException e) {
			// Si se presenta un fallo en la conexion a la base de datos o a la
			// consulta se lanza una excepcion propia (MyException) con el
			// mensaje de error correspondiente
			throw new MyException(e);
		} finally {
			// session.close();
		}
		// Retorna la lista de fallos
		return fallos;
	}

	@Override
	public void crear(Fallo fallo) throws MyException {
		// Se crea una session con la que se obtendrá una conexión física con la
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
			session.save(fallo);
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
	public void actualizar(Fallo fallo) throws MyException {
		// Se crea una session con la que se obtendrá una conexión física con la
		// Base de datos
		Session session = null;
		try {
			session = getSession();
			// Se crea un objeto del tipo Transaction y se le asigna la session,
			// lo anterior con el fin de comenzar operaciones en la base de
			// datos
			Transaction tx = session.beginTransaction();
			// Se envia al metodo de actualizar, correspondiente a session, el
			// Objeto Fallo al que se le actualizaran los datos
			session.update(fallo);
			// Se realiza el commit en la base de datos para que persistan los
			// objetos
			tx.commit();
		} catch (HibernateException e) {
			throw new MyException(e);
		} finally {
			// session.close();
		}

	}

	@Override
	public List<Fallo> consultarFalloPorDispositivo(Dispositivo dispositivo) throws MyException {
		List<Fallo> fallos = new ArrayList<Fallo>();
		// Se crea una session con la que se obtendrá una conexión física con la
		// Base de datos
		Session session = null;
		try {
			session = getSession();
			// Se crea un objeto Criteria en la que se especifica una consulta
			// en base a la clase Administrador y se anade una restriccion para
			// que se realice la busqueda por el campo de dispositivo
			Criteria criteria = session.createCriteria(Fallo.class).add(Restrictions.eq("dispositivo", dispositivo));
			// se almacena en la lista de fallos la lista devuelta por
			// la consulta realizada en la linea anterior
			fallos = criteria.list();
		} catch (HibernateException e) {
			// Si se presenta un fallo en la conexion a la base de datos o en la
			// consulta de la BD se lanza una excepcion propia
			// (MyException) con el mensaje de error correspondiente
			throw new MyException(e);
		} finally {
			// session.close();
		}
		// Retorna la lista de Fallos del dispositivo especifico
		return fallos;
	}

	@Override
	public List<Fallo> consultarDanosSinSolucion() throws MyException {
		List<Fallo> fallos = new ArrayList<Fallo>();
		// Se crea una session con la que se obtendrá una conexión física con la
		// Base de datos
		Session session = null;
		try {
			session = getSession();
			// Se crea un objeto Criteria en la que se especifica una consulta
			// en base a la clase Administrador y se anade una restriccion para
			// que se realice la busqueda por el campo de solucionado
			Criteria criteria = session.createCriteria(Fallo.class).add(Restrictions.eq("solucionado", false));
			// se almacena en la lista de fallos la lista devuelta por
			// la consulta realizada en la linea anterior
			fallos = criteria.list();
		} catch (HibernateException e) {
			// Si se presenta un fallo en la conexion a la base de datos o en la
			// consulta de la BD se lanza una excepcion propia
			// (MyException) con el mensaje de error correspondiente
			throw new MyException(e);
		} finally {
			// session.close();
		}
		// Retorna la lista de fallos sin solucion
		return fallos;
	}

	@Override
	public Fallo consultarUno(int id) throws MyException {
		Fallo fallo;
		// Se crea una session con la que se obtendra una conexion fisica con la
		// Base de datos
		Session session = null;
		try {
			session = getSession();
			// Se crea un objeto Criteria en la que se especifica una consulta
			// en base a la clase Fallo y se anade una restriccion para
			// que se realice la busqueda por el campo de idFallo
			Criteria criteria = session.createCriteria(Fallo.class).add(Restrictions.eq("idFallo", id));
			// Se almacena en el objeto administrador el resultado unico de la
			// busqueda realizada
			fallo = (Fallo) criteria.uniqueResult();
		} catch (HibernateException e) {
			// Si se presenta un fallo en la conexion a la base de datos o en la
			// consulta de la BD se lanza una excepcion propia
			// (MyException) con el mensaje de error correspondiente
			throw new MyException(e);
		} finally {
			// session.close();
		}
		//Retorna el fallo
		return fallo;
	}

}
