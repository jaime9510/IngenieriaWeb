package co.edu.udea.iw.bl.impl;

import java.util.ArrayList;
import java.util.List;

import co.edu.udea.iw.bl.TipoBL;
import co.edu.udea.iw.dao.TipoDao;
import co.edu.udea.iw.dto.Tipo;
import co.edu.udea.iw.exception.MyException;

public class TipoBLImpl implements TipoBL{

	TipoDao tipoDao;
	public TipoDao getTipoDao() {
		return tipoDao;
	}

	public void setTipoDao(TipoDao tipoDao) {
		this.tipoDao = tipoDao;
	}

	@Override
	public void crear(String nombre) throws MyException {
		Tipo tipoCrear = new Tipo();
		if(nombre == null || "".equals(nombre)){
			throw new MyException("El nombre no es válido");
		}
		 Tipo tipo = tipoDao.consultarPorNombre(nombre);
		if(tipo != null){
			throw new MyException("El tipo ya existe");
		}
		tipoCrear.setNombre(nombre);
		tipoDao.crear(tipoCrear);
	}

	@Override
	public Tipo consultarUno(int id) throws MyException {
		Tipo tipo = new Tipo();
		if(id == 0){
			throw new MyException("El número de identificación no es válido");
		}
		tipo = tipoDao.consultarUno(id);
		if(tipo == null){
			throw new MyException("El tipo con el identificador ingresado no existe");
		}
		return tipo;
	}

	@Override
	public List<Tipo> consultarTodos() throws MyException {
		List<Tipo> tipos = new ArrayList<Tipo>();
		tipos = tipoDao.consultarTodos();
		return tipos;
	}
	

}
