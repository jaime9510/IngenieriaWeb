package co.edu.udea.iw.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.iw.dao.DispositivoDao;
import co.edu.udea.iw.dto.Dispositivo;
import co.edu.udea.iw.dto.Tipo;
import co.edu.udea.iw.exception.MyException;

/**
 * 
 * @author Carolina Isaza
 * @author Jaime Londoño
 * @author Sebastián Jiménez
 *
 */
public class DispositivoDaoImpl extends HibernateDaoSupport implements DispositivoDao {

	@Override
	public List<Dispositivo> consultarTodos() throws MyException {
		// Crea la lista de dispositivos del tipo ArrayList 
		List<Dispositivo> dispositivos = new ArrayList<Dispositivo>();
		// Se crea una session con la que se obtendrá una conexión física con la
		// Base de datos
		Session session = null;
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(Dispositivo.class);
			dispositivos = criteria.list();
		} catch (HibernateException e) {
			throw new MyException(e);
		} finally {
			// session.close();
		}
		return dispositivos;
	}

	@Override
	public void crear(Dispositivo dispositivo) throws MyException {
		// Se crea una session con la que se obtendrá una conexión física con la
		// Base de datos
		Session session = null;
		try {
			session = getSession();
			Transaction tx = session.beginTransaction();
			session.save(dispositivo);
			tx.commit();
		} catch (HibernateException e) {
			throw new MyException(e);
		} finally {
			// session.close();
		}

	}

	@Override
	public void actualizar(Dispositivo dispositivo) throws MyException {
		// Se crea una session con la que se obtendrá una conexión física con la
		// Base de datos
		Session session = null;
		try {
			session = getSession();
			Transaction tx = session.beginTransaction();
			session.update(dispositivo);
			tx.commit();
		} catch (HibernateException e) {
			throw new MyException(e);
		} finally {
			// session.close();
		}

	}

	@Override
	public void eliminar(Dispositivo dispositivo) throws MyException {
		// Se crea una session con la que se obtendrá una conexión física con la
		// Base de datos
		Session session = null;
		try {
			session = getSession();
			Transaction tx = session.beginTransaction();
			session.delete(dispositivo);
			tx.commit();
		} catch (HibernateException e) {
			throw new MyException(e);
		}

	}

	@Override
	public List<Dispositivo> consultarPorTipo(Tipo tipo) throws MyException {
		List<Dispositivo> dispositivos = new ArrayList<Dispositivo>();
		// Se crea una session con la que se obtendrá una conexión física con la
		// Base de datos
		Session session = null;
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(Dispositivo.class).add(Restrictions.eq("tipo", tipo));
			dispositivos = criteria.list();
		} catch (HibernateException e) {
			throw new MyException(e);
		} finally {
			// session.close();
		}
		return dispositivos;
	}

	@Override
	public List<Dispositivo> consultarDisponibles() throws MyException {
		List<Dispositivo> dispositivos = new ArrayList<Dispositivo>();
		// Se crea una session con la que se obtendrá una conexión física con la
		// Base de datos
		Session session = null;
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(Dispositivo.class).add(Restrictions.eq("disponible", true));
			dispositivos = criteria.list();
		} catch (HibernateException e) {
			throw new MyException(e);
		} finally {
			// session.close();
		}
		return dispositivos;
	}

	@Override
	public Dispositivo consultarUno(String referencia) throws MyException {
		Dispositivo dispositivo;
		// Se crea una session con la que se obtendrá una conexión física con la
		// Base de datos
		Session session = null;
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(Dispositivo.class)
					.add(Restrictions.eq("referencia", referencia));
			dispositivo = (Dispositivo) criteria.uniqueResult();
		} catch (HibernateException e) {
			throw new MyException(e);
		} finally {
			// session.close();
		}
		return dispositivo;
	}

}
