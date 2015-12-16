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
import co.edu.udea.iw.dto.Administrador;
import co.edu.udea.iw.dto.Prestamo;
import co.edu.udea.iw.exception.MyException;

/**
 * 
 * @author Carolina Isaza
 * @author Jaime Londoño
 * @author Sebastián Jiménez
 *
 */
public class PrestamoDaoImpl extends HibernateDaoSupport implements PrestamoDao {

	@Override
	public List<Prestamo> consultarTodos() throws MyException {
		// Crea la lista de préstamos del tipo ArrayList
		List<Prestamo> prestamos = new ArrayList<Prestamo>();
		// Se crea una session con la que se obtendrá una conexión física con la
		// Base de datos
		Session session = null;
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(Prestamo.class);
			prestamos = criteria.list();
		} catch (HibernateException e) {
			throw new MyException(e);
		} finally {
			// session.close();
		}
		return prestamos;
	}

	@Override
	public void crear(Prestamo prestamo) throws MyException {
		// Se crea una session con la que se obtendrá una conexión física con la
		// Base de datos
		Session session = null;
		try {
			session = getSession();
			Transaction tx = session.beginTransaction();
			session.save(prestamo);
			tx.commit();
		} catch (HibernateException e) {
			throw new MyException(e);
		} finally {
			// session.close();
		}

	}

	@Override
	public void modificar(Prestamo prestamo) throws MyException {
		// Se crea una session con la que se obtendrá una conexión física con la
		// Base de datos
		Session session = null;
		try {
			session = getSession();
			Transaction tx = session.beginTransaction();
			session.update(prestamo);
			tx.commit();
		} catch (HibernateException e) {
			throw new MyException(e);
		} finally {
			// session.close();
		}

	}

	@Override
	public Prestamo consultarUno(int id) throws MyException {
		Prestamo prestamo;
		// Se crea una session con la que se obtendrá una conexión física con la
		// Base de datos
		Session session = null;
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(Prestamo.class).add(Restrictions.eq("idPrestamo", id));
			prestamo = (Prestamo) criteria.uniqueResult();
		} catch (HibernateException e) {
			throw new MyException(e);
		} finally {
			// session.close();
		}
		return prestamo;
	}

	@Override
	public List<Prestamo> prestamosSinRevisar() throws MyException {
		List<Prestamo> prestamos = new ArrayList<Prestamo>();
		// Se crea una session con la que se obtendrá una conexión física con la
		// Base de datos
		Session session = null;
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(Prestamo.class).add(Restrictions.eq("estado", 0));
			prestamos = criteria.list();
		} catch (HibernateException e) {
			throw new MyException(e);
		} finally {
			// session.close();
		}
		return prestamos;
	}

	@Override
	public List<Prestamo> prestamoPorUsuario(String correoUsuario) throws MyException {
		List<Prestamo> prestamos = new ArrayList<Prestamo>();
		// Se crea una session con la que se obtendrá una conexión física con la
		// Base de datos
		Session session = null;
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(Prestamo.class)
					.add(Restrictions.eq("correoUsuario", correoUsuario));
			prestamos = criteria.list();
		} catch (HibernateException e) {
			throw new MyException(e);
		} finally {
			// session.close();
		}
		return prestamos;
	}

}
