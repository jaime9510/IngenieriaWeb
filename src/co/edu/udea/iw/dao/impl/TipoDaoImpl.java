package co.edu.udea.iw.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.TransactionException;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.iw.dao.TipoDao;
import co.edu.udea.iw.dto.Prestamo;
import co.edu.udea.iw.dto.Tipo;
import co.edu.udea.iw.exception.MyException;

/**
 * Clase en la que se implementan los metodos definidos en la interface TipoDao
 * y se extiende de la clase HibernateDaoSupport que es la que permite la
 * integracion entre los frameworks de Hibernate y Spring, en esta clase se
 * realizaran las consultas, inserciones, borrados y actualizaciones de los
 * datos de un Tipo en la BD
 * 
 * @author Carolina Isaza
 * @author Jaime Londoño
 * @author Sebastián Jiménez
 *
 */
public class TipoDaoImpl extends HibernateDaoSupport implements TipoDao {

	@Override
	public List<Tipo> consultarTodos() throws MyException {
		// Crea la lista de tipos del tipo ArrayList
		List<Tipo> tipos = new ArrayList<Tipo>();
		// Se crea una session con la que se obtendrá una conexión física con la
		// Base de datos
		Session session = null;
		try {
			session = getSession();
			// Se crea un objeto Criteria en la que se especifica una consulta
			// en base a la clase Tipo
			Criteria criteria = session.createCriteria(Tipo.class);
			// se almacena en la lista de tipos la lista devuelta por
			// la consulta realizada en la linea anterior
			tipos = criteria.list();
		} catch (HibernateException e) {
			// Si se presenta un fallo en la conexion a la base de datos o a la
			// consulta se lanza una excepcion propia (MyException) con el
			// mensaje de error correspondiente
			throw new MyException(e);
		} finally {
			// session.close();
		}
		// Retorna la lista de tipos
		return tipos;
	}

	@Override
	public void crear(Tipo tipo) throws MyException {
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
			// Objeto Tipo que se almacenara como nuevo registro en la
			// BD
			session.save(tipo);
			// Se realiza el commit en la base de datos para que persistan los
			// objetos
			tx.commit();
		} catch (TransactionException e) {
			// Si se presenta un fallo en la conexion a la base de datos o en la
			// creacion de filas en la BD se lanza una excepcion propia
			// (MyException) con el mensaje de error correspondiente
			throw new MyException(e);
		} finally {
			// session.close();
		}

	}

	@Override
	public Tipo consultarUno(int id) throws MyException {
		Tipo tipo;
		// Se crea una session con la que se obtendrá una conexión física con la
		// Base de datos
		Session session = null;
		try {
			session = getSession();
			// Se crea un objeto Criteria en la que se especifica una consulta
			// en base a la clase Tipo y se anade una restriccion para
			// que se realice la busqueda por el campo de id
			Criteria criteria = session.createCriteria(Tipo.class).add(Restrictions.eq("id", id));
			// Se almacena en el objeto tipo el resultado unico de la
			// busqueda realizada
			tipo = (Tipo) criteria.uniqueResult();
		} catch (HibernateException e) {
			// Si se presenta un fallo en la conexion a la base de datos o en la
			// consulta de la BD se lanza una excepcion propia
			// (MyException) con el mensaje de error correspondiente
			throw new MyException(e);
		} finally {
			// session.close();
		}
		// Retorna el tipo especificado
		return tipo;
	}

	@Override
	public Tipo consultarPorNombre(String nombre) throws MyException {
		Tipo tipo;
		// Se crea una session con la que se obtendrá una conexión física con la
		// Base de datos
		Session session = null;
		try {
			session = getSession();
			// Se crea un objeto Criteria en la que se especifica una consulta
			// en base a la clase Tipo y se anade una restriccion para
			// que se realice la busqueda por el campo de nombre
			Criteria criteria = session.createCriteria(Tipo.class).add(Restrictions.eq("nombre", nombre));
			// Se almacena en el objeto tipo el resultado unico de la
			// busqueda realizada
			tipo = (Tipo) criteria.uniqueResult();
		} catch (HibernateException e) {
			// Si se presenta un fallo en la conexion a la base de datos o en la
			// consulta de la BD se lanza una excepcion propia
			// (MyException) con el mensaje de error correspondiente
			throw new MyException(e);
		} finally {
			// session.close();
		}
		// Retorna el tipo con el nombre especificado
		return tipo;
	}

}
