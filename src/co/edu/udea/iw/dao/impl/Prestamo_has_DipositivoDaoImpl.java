package co.edu.udea.iw.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.iw.dao.DispositivoDao;
import co.edu.udea.iw.dao.Prestamo_has_DispositivoDao;
import co.edu.udea.iw.dto.Administrador;
import co.edu.udea.iw.dto.Prestamo_has_Dispositivo;
import co.edu.udea.iw.exception.MyException;

/**
 * 
 * @author Carolina Isaza
 * @author Jaime Londoño
 * @author Sebastián Jiménez
 *
 */
public class Prestamo_has_DipositivoDaoImpl extends HibernateDaoSupport implements Prestamo_has_DispositivoDao {

	@Override
	public List<Prestamo_has_Dispositivo> consultarTodos() throws MyException {
		// Crea la lista de prestamo_has_dispositivos del tipo ArrayList
		List<Prestamo_has_Dispositivo> pres_disp = new ArrayList<Prestamo_has_Dispositivo>();
		// Se crea una session con la que se obtendrá una conexión física con la
		// Base de datos
		Session session = null;
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(Prestamo_has_Dispositivo.class);
			pres_disp = criteria.list();
		} catch (HibernateException e) {
			throw new MyException(e);
		} finally {
			// session.close();
		}
		return pres_disp;
	}

	@Override
	public void crear(Prestamo_has_Dispositivo pd) throws MyException {
		// Se crea una session con la que se obtendrá una conexión física con la
		// Base de datos
		Session session = null;
		try {
			session = getSession();
			Transaction tx = session.beginTransaction();
			session.save(pd);
			tx.commit();
		} catch (HibernateException e) {
			throw new MyException(e);
		} finally {
			// session.close();
		}

	}

}
