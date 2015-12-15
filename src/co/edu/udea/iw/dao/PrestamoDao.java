package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Prestamo;
import co.edu.udea.iw.exception.MyException;

/**
 * Esta interaz contiene la definición de los métodos correspondientes a las
 * funciones que se podrán hacer para un Préstamo en relación con el acceso a la
 * base de datos
 * 
 * @author Carolina Isaza
 * @author Jaime Londoño
 * @author Sebastián Jiménez
 *
 */
public interface PrestamoDao {

	public List<Prestamo> consultarTodos() throws MyException;

	public void crear(Prestamo prestamo) throws MyException;

	public void modificar(Prestamo prestamo) throws MyException;

	public Prestamo consultarUno(int id) throws MyException;
}
