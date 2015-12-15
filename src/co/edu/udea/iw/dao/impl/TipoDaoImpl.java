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
			Criteria criteria = session.createCriteria(Tipo.class);
			tipos = criteria.list();
		} catch (HibernateException e) {
			throw new MyException(e);
		} finally {
			// session.close();
		}
		return tipos;
	}

	@Override
	public void crear(Tipo tipo) throws MyException {
		// Se crea una session con la que se obtendrá una conexión física con la
		// Base de datos
		Session session = null;
		try {
			session = getSession();
			Transaction tx = session.beginTransaction();
			session.save(tipo);
			tx.commit();
		} catch (TransactionException e) {
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
			Criteria criteria = session.createCriteria(Tipo.class).add(Restrictions.eq("id", id));
			tipo = (Tipo) criteria.uniqueResult();
		} catch (HibernateException e) {
			throw new MyException(e);
		} finally {
			// session.close();
		}
		return tipo;
	}

}
