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
 * Clase en la que se implementan los metodos definidos en la interface
 * DispositivoDao y se extiende de la clase HibernateDaoSupport que es la que
 * permite la integracion entre los frameworks de Hibernate y Spring, en esta
 * clase se realizaran las consultas, inserciones, borrados y actualizaciones de
 * los datos de un Dispositivo en la BD
 * 
 * @author Carolina Isaza
 * @author Jaime Londo�o
 * @author Sebasti�n Jim�nez
 *
 */
public class DispositivoDaoImpl extends HibernateDaoSupport implements DispositivoDao {

	@Override
	public List<Dispositivo> consultarTodos() throws MyException {
		// Crea la lista de dispositivos del tipo ArrayList
		List<Dispositivo> dispositivos = new ArrayList<Dispositivo>();
		// Se crea una session con la que se obtendr� una conexi�n f�sica con la
		// Base de datos
		Session session = null;
		try {
			session = getSession();
			// Se crea un objeto Criteria en la que se especifica una consulta
			// en base a la clase Dispositivo
			Criteria criteria = session.createCriteria(Dispositivo.class);
			// se almacena en la lista de dispositivos la lista devuelta por
			// la consulta realizada en la linea anterior
			dispositivos = criteria.list();
		} catch (HibernateException e) {
			// Si se presenta un fallo en la conexion a la base de datos o a la
			// consulta se lanza una excepcion propia (MyException) con el
			// mensaje de error correspondiente
			throw new MyException(e);
		} finally {
			// Se cierra Sesion
			// session.close();
		}
		return dispositivos;
	}

	@Override
	public void crear(Dispositivo dispositivo) throws MyException {
		// Se crea una session con la que se obtendr� una conexi�n f�sica con la
		// Base de datos
		Session session = null;
		try {
			session = getSession();
			// Se crea un objeto del tipo Transaction y se le asigna la session,
			// lo anterior con el fin de comenzar operaciones en la base de
			// datos
			Transaction tx = session.beginTransaction();
			// Se envia al metodo de guardar, correspondiente a session, el
			// Objeto Dispositio que se almacenara como nuevo registro en la
			// BD
			session.save(dispositivo);
			// Se realiza el commit en la base de datos para que persistan los
			// objetos
			tx.commit();
		} catch (HibernateException e) {
			// Si se presenta un fallo en la conexion a la base de datos o en la
			// creacion de filas en la BD se lanza una excepcion propia
			// (MyException) con el mensaje de error correspondiente
			throw new MyException(e);
		} 

	}

	@Override
	public void actualizar(Dispositivo dispositivo) throws MyException {
		// Se crea una session con la que se obtendr� una conexi�n f�sica con la
		// Base de datos
		Session session = null;
		try {
			session = getSession();
			// Se crea un objeto del tipo Transaction y se le asigna la session,
			// lo anterior con el fin de comenzar operaciones en la base de
			// datos
			Transaction tx = session.beginTransaction();
			// Se envia al metodo de actualizar, correspondiente a session, el
			// Objeto Dispositivo al que se le actualizaran los datos
			session.update(dispositivo);
			// Se realiza el commit en la base de datos para que persistan los
			// objetos
			tx.commit();
		} catch (HibernateException e) {
			// Si se presenta un fallo en la conexion a la base de datos o en la
			// actualizacion de la BD se lanza una excepcion propia
			// (MyException) con el mensaje de error correspondiente
			throw new MyException(e);
		} finally {
			// Se cierra Sesion
			// session.close();
		}

	}

	@Override
	public void eliminar(Dispositivo dispositivo) throws MyException {
		// Se crea una session con la que se obtendr� una conexi�n f�sica con la
		// Base de datos
		Session session = null;
		try {
			session = getSession();
			// Se crea un objeto del tipo Transaction y se le asigna la session,
			// lo anterior con el fin de comenzar operaciones en la base de
			// datos
			Transaction tx = session.beginTransaction();
			// Se envia al metodo de eliminar, correspondiente a session, el
			// Objeto Dispositivo al que ser� eliminado fisicamente
			session.delete(dispositivo);
			// Se realiza el commit en la base de datos para que persistan los
			// objetos
			tx.commit();
		} catch (HibernateException e) {
			// Si se presenta un fallo en la conexion a la base de datos o en la
			// actualizacion de la BD se lanza una excepcion propia
			// (MyException) con el mensaje de error correspondiente
			throw new MyException(e);
		}

	}

	@Override
	public List<Dispositivo> consultarPorTipo(Tipo tipo) throws MyException {
		List<Dispositivo> dispositivos = new ArrayList<Dispositivo>();
		// Se crea una session con la que se obtendr� una conexi�n f�sica con la
		// Base de datos
		Session session = null;
		try {
			session = getSession();
			// Se crea un objeto Criteria en la que se especifica una consulta
			// en base a la clase Dispositivo y se anade una restriccion para
			// que se realice la busqueda por el campo de tipo
			Criteria criteria = session.createCriteria(Dispositivo.class).add(Restrictions.eq("tipo", tipo));
			// se almacena en la lista de dispositivos la lista devuelta por
			// la consulta realizada en la linea anterior
			dispositivos = criteria.list();
		} catch (HibernateException e) {
			// Si se presenta un fallo en la conexion a la base de datos o a la
			// consulta se lanza una excepcion propia (MyException) con el
			// mensaje de error correspondiente
			throw new MyException(e);
		} finally {
			// Se cierra Sesion
			// session.close();
		}
		// Retorna la lista de dispositivos del tipo especificado
		return dispositivos;
	}

	@Override
	public Dispositivo consultarUno(String referencia) throws MyException {
		Dispositivo dispositivo;
		// Se crea una session con la que se obtendr� una conexi�n f�sica con la
		// Base de datos
		Session session = null;
		try {
			session = getSession();
			// Se crea un objeto Criteria en la que se especifica una consulta
			// en base a la clase Dispositivo y se anade una restriccion para
			// que se realice la busqueda por el campo de referencia
			Criteria criteria = session.createCriteria(Dispositivo.class)
					.add(Restrictions.eq("referencia", referencia));
			// Se almacena en el objeto administrador el resultado unico de la
			// busqueda realizada
			dispositivo = (Dispositivo) criteria.uniqueResult();
		} catch (HibernateException e) {
			// Si se presenta un fallo en la conexion a la base de datos o en la
			// consulta de la BD se lanza una excepcion propia
			// (MyException) con el mensaje de error correspondiente
			throw new MyException(e);
		} finally {
			// Cierra Sesion
			//session.close();
		}
		// Retorna el dispositivo con la referencia especificada
		return dispositivo;
	}

	@Override
	public Boolean consultarDispositivoDisponible(Date fechaInicio, Date fechaFin, String referencia)
			throws MyException {
		// Se crea una session con la que se obtendr� una conexi�n f�sica con la
		// Base de datos
		Session session = null;
		// Se hace la conversion del tipo Date a String
		DateFormat fechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String fechaInicioString = fechaHora.format(fechaInicio);
		String fechaFinString = fechaHora.format(fechaFin);
		try {
			session = getSession();
			// Se realiza una consulta en lenguaje SQL en la que se seleccionan
			// la referencia del dispositivo disponible
			Query query = (Query) session.createSQLQuery(
					"SELECT distinct disp.referencia FROM Dispositivo as disp, Prestamo_has_Dispositivo as pd, Prestamo pres "
							+ "Where disp.referencia ='" + referencia + "' and disp.referencia = pd.referencia and "
							+ "pd.prestamo = pres.idPrestamo and pres.fechaInicio not between '" + fechaInicioString
							+ "'and '" + fechaFinString + "' and pres.fechaFin not between '" + fechaInicioString
							+ "' and '" + fechaFinString
							+ "'and pres.estado = '0' or pres.estado = '2' and disp.disponible = '1'");
			// Se almacena en una variable de tipo String el resultado unico de
			// la consulta
			String dispositivo = (String) query.uniqueResult();
			// Se verifica si la consulta devolvio un String diferente de nulo
			if (dispositivo == null) {
				// Se retorna falso
				return false;
			}
		} catch (HibernateException e) {
			throw new MyException(e);
		} finally {
			// session.close();
		}
		// Retorna true
		return true;
	}

	@Override
	public List<String> consultarDisponibles(Date fechaInicio, Date fechaFin) throws MyException {
		List<String> dispositivos = new ArrayList<String>();
		// Se crea una session con la que se obtendr� una conexi�n f�sica con la
		// Base de datos
		Session session = null;
		// Se hace la conversion del tipo Date a String
		DateFormat fechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String fechaInicioString = fechaHora.format(fechaInicio);
		String fechaFinString = fechaHora.format(fechaFin);
		try {
			session = getSession();
			// Se realiza una consulta en SQL en la que se devuelve la
			// referencia de los dispositivos que esten disponibles para
			// prestamo en las fechas indicadas
			Query query = (Query) session.createSQLQuery(
					"SELECT disp.referencia FROM Dispositivo as disp, Prestamo_has_Dispositivo as pd, Prestamo pres "
							+ "Where disp.referencia = pd.referencia and "
							+ "pd.prestamo = pres.idPrestamo and pres.fechaInicio not between '" + fechaInicioString
							+ "'and '" + fechaFinString + "' and pres.fechaFin not between '" + fechaInicioString
							+ "' and '" + fechaFinString
							+ "'and pres.estado = '0' or pres.estado = '2' and disp.disponible = '1'");
			//Almacena en dispositivos la lista de resultados del query
			dispositivos = query.list();
		} catch (HibernateException e) {
			throw new MyException(e);
		} finally {
			// session.close();
		}
		//Retorna la lista de dispositivos disponibles
		return dispositivos;
	}
}
