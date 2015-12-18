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
 * Clase en la que se implementan los metodos definidos en la interface
 * Prestamo_has_DispositivoDao y se extiende de la clase HibernateDaoSupport que
 * es la que permite la integracion entre los frameworks de Hibernate y Spring,
 * en esta clase se realizaran las consultas, inserciones, borrados y
 * actualizaciones de los datos de un Prestamo_has_Dispositivo en la BD
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
			// Se crea un objeto Criteria en la que se especifica una consulta
			// en base a la clase Prestamo_has_Dispositivo
			Criteria criteria = session.createCriteria(Prestamo_has_Dispositivo.class);
			// se almacena en la lista de pres_disp la lista devuelta por
			// la consulta realizada en la linea anterior
			pres_disp = criteria.list();
		} catch (HibernateException e) {
			// Si se presenta un fallo en la conexion a la base de datos o a la
			// consulta se lanza una excepcion propia (MyException) con el
			// mensaje de error correspondiente
			throw new MyException(e);
		} finally {
			// session.close();
		}
		// Retorna la lista de Prestamos_has_Dispositivos
		return pres_disp;
	}

	@Override
	public void crear(Prestamo_has_Dispositivo pd) throws MyException {
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
			// Objeto Prestamo_has_Dispositivo que se almacenara como nuevo
			// registro en la BD
			session.save(pd);
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

}
