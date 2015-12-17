package co.edu.udea.iw.dao.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
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
	@Override
	public Boolean consultarDispositivoDisponible(Date fechaInicio, Date fechaFin, String referencia)
			throws MyException {
		// Se crea una session con la que se obtendrá una conexión física con la
		// Base de datos
		Session session = null;
		DateFormat fechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String fechaInicioString = fechaHora.format(fechaInicio);
		String fechaFinString = fechaHora.format(fechaFin);
		try {
			session = getSession();
			Query query = (Query) session
					.createSQLQuery("SELECT distinct disp.referencia FROM dispositivo as disp, prestamo_has_dispositivo as pd, prestamo pres "
							+ "Where disp.referencia ='"+ referencia +"' and disp.referencia = pd.referencia and "
							+ "pd.prestamo = pres.idPrestamo and pres.fechaInicio not between '" + fechaInicioString
							+ "'and '" + fechaFinString + "' and pres.fechaFin not between '" + fechaInicioString
							+ "' and '"+fechaFinString+"'and pres.estado = '0' or pres.estado = '2' and disp.disponible = '1'");

			String dispositivo =  (String) query.uniqueResult();
			if(dispositivo == null){
				return false;
			}
		} catch (HibernateException e) {
			throw new MyException(e);
		} finally {
			// session.close();
		}
		return true;
	}
	@Override
	public List<String> consultarDisponibles(Date fechaInicio, Date fechaFin) throws MyException {
		List<String> dispositivos = new ArrayList<String>();
		Session session = null;
		DateFormat fechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String fechaInicioString = fechaHora.format(fechaInicio);
		String fechaFinString = fechaHora.format(fechaFin);
		try {
			session = getSession();
			Query query = (Query) session
					.createSQLQuery("SELECT disp.referencia FROM dispositivo as disp, prestamo_has_dispositivo as pd, prestamo pres "
							+ "Where disp.referencia = pd.referencia and "
							+ "pd.prestamo = pres.idPrestamo and pres.fechaInicio not between '" + fechaInicioString
							+ "'and '" + fechaFinString + "' and pres.fechaFin not between '" + fechaInicioString
							+ "' and '"+fechaFinString+"'and pres.estado = '0' or pres.estado = '2' and disp.disponible = '1'");
			dispositivos = query.list();
			//dispositivo = (Dispositivo) query.uniqueResult();
		} catch (HibernateException e) {
			throw new MyException(e);
		} finally {
			// session.close();
		}
		return dispositivos;
	}
}
