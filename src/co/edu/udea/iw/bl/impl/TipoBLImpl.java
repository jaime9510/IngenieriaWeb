package co.edu.udea.iw.bl.impl;

import java.util.ArrayList;
import java.util.List;

import co.edu.udea.iw.bl.TipoBL;
import co.edu.udea.iw.dao.TipoDao;
import co.edu.udea.iw.dto.Tipo;
import co.edu.udea.iw.exception.MyException;

/**
 * Clase en la que se implementan los metodos de la interface TipoBL. En esta
 * clase se implementaran todos los metodos correspondientes a la logica del
 * negocio definida para un Tipo
 * 
 * @author Carolina Isaza
 * @author Sebastian Jimenez
 * @author Jaime Londono
 *
 */
public class TipoBLImpl implements TipoBL {

	/**
	 * Objeto del tipo TipoDao, este objeto sera inyectado desde el archivo de
	 * configuracion de Spring
	 */
	TipoDao tipoDao;

	/**
	 * Metodo para acceder al objeto del tipo TipoDao
	 * 
	 * @return tipoDao Objeto con la informacion correspondiente a un objeto
	 *         TipoDao
	 */
	public TipoDao getTipoDao() {
		return tipoDao;
	}

	/**
	 * Metodo para asignar un dipositivoDao al objeto del tipo TipoDao de esta
	 * clase
	 * 
	 * @param tipoDao
	 *            objeto con la informacion concerniente a un objeto del tipo
	 *            TipoDao
	 */
	public void setTipoDao(TipoDao tipoDao) {
		this.tipoDao = tipoDao;
	}

	@Override
	public void crear(String nombre) throws MyException {
		// Crea un objeto del tipo Tipo
		Tipo tipoCrear = new Tipo();
		// Verifica que los campos ingresados sean validos para las reglas de
		// negocio
		if (nombre == null || "".equals(nombre)) {
			throw new MyException("El nombre no es valido");
		}
		// Verifca que no exista un tipo con el mismo nombre
		Tipo tipo = tipoDao.consultarPorNombre(nombre);
		if (tipo != null) {
			throw new MyException("El tipo ya existe");
		}
		// Asigna al objeto tipoCrear el nombre entregado como parametro
		tipoCrear.setNombre(nombre);
		// Envia el objeto tipoCrear al metodo crear de la clase TipoDao
		tipoDao.crear(tipoCrear);
	}

	@Override
	public Tipo consultarUno(int id) throws MyException {
		// Crea un objeto del tipo Dao
		Tipo tipo = new Tipo();
		// Verifica que los campos ingresados sean validos para las reglas de
		// negocio
		if (id == 0) {
			throw new MyException("El numero de identificacion no es valido");
		}
		// Verifica que exista un tipo con el id definido
		tipo = tipoDao.consultarUno(id);
		if (tipo == null) {
			throw new MyException("El tipo con el identificador ingresado no existe");
		}
		// Retorna el tipo encontrado
		return tipo;
	}

	@Override
	public List<Tipo> consultarTodos() throws MyException {
		List<Tipo> tipos = new ArrayList<Tipo>();
		// Almacena en la lista tipos la lista retornada por el metodo
		// consultarTodos de la clase TipoDao
		tipos = tipoDao.consultarTodos();
		// Retorna la lista de tipos
		return tipos;
	}

}
