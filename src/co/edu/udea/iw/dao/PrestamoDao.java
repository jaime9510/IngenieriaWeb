package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Prestamo;
import co.edu.udea.iw.exception.MyException;

/**
 * Esta interaz contiene la definici�n de los m�todos correspondientes a las
 * funciones que se podr�n hacer para un Pr�stamo en relaci�n con el acceso a la
 * base de datos
 * 
 * @author Carolina Isaza
 * @author Jaime Londo�o
 * @author Sebasti�n Jim�nez
 *
 */
public interface PrestamoDao {

	public List<Prestamo> consultarTodos() throws MyException;

	public void crear(Prestamo prestamo) throws MyException;

	public void modificar(Prestamo prestamo) throws MyException;

	public Prestamo consultarUno(int id) throws MyException;
}
