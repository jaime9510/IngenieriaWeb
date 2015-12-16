package co.edu.udea.iw.bl;

import co.edu.udea.iw.dto.Tipo;
import co.edu.udea.iw.exception.MyException;

public interface TipoBL {

	public void crear(String nombre) throws MyException;
	public Tipo consultarUno(int id) throws MyException;
	
}
