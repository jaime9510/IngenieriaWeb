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
			Criteria criteria = session.createCriteria(Fallo.class);
			fallos = criteria.list();
		} catch (HibernateException e) {
			throw new MyException(e);
		} finally {
			// session.close();
		}
		return fallos;
	}

	@Override
	public void crear(Fallo fallo) throws MyException {
		// Se crea una session con la que se obtendrá una conexión física con la
		// Base de datos
		Session session = null;
		try {
			session = getSession();
			Transaction tx = session.beginTransaction();
			session.save(fallo);
			tx.commit();
		} catch (HibernateException e) {
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
			Transaction tx = session.beginTransaction();
			session.update(fallo);
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
			Criteria criteria = session.createCriteria(Fallo.class).add(Restrictions.eq("dispositivo", dispositivo));
			fallos = criteria.list();
		} catch (HibernateException e) {
			throw new MyException(e);
		} finally {
			// session.close();
		}
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
			Criteria criteria = session.createCriteria(Fallo.class).add(Restrictions.eq("solucionado", false));
			fallos = criteria.list();
		} catch (HibernateException e) {
			throw new MyException(e);
		} finally {
			// session.close();
		}
		return fallos;
	}

	@Override
	public Fallo consultarUno(int id) throws MyException {
		Fallo fallo;
		Session session = null;
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(Fallo.class)
					.add(Restrictions.eq("idFallo", id));
			fallo = (Fallo) criteria.uniqueResult();
		} catch (HibernateException e) {
			throw new MyException(e);
		} finally {
			// session.close();
		}
		return fallo;
	}

}
