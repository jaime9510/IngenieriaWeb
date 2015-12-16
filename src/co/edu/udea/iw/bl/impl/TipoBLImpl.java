package co.edu.udea.iw.bl.impl;

import co.edu.udea.iw.bl.TipoBL;
import co.edu.udea.iw.dao.TipoDao;
import co.edu.udea.iw.dto.Tipo;
import co.edu.udea.iw.exception.MyException;

public class TipoBLImpl implements TipoBL{

	TipoDao tipoDao;
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
		// TODO Auto-generated method stub
		return null;
	}

}
