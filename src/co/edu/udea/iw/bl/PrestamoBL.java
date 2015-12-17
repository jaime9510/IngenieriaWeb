package co.edu.udea.iw.bl;

import java.util.Date;
import java.util.List;

import co.edu.udea.iw.dto.Dispositivo;
import co.edu.udea.iw.dto.Prestamo;
import co.edu.udea.iw.exception.MyException;

/**
 * 
 * @author Sebastian Jimenez
 * @author Jaime Londono
 * @author Carolina Isaza
 */
public interface PrestamoBL {

	public void crear(String nombreUsuario, String cedulaUsuario, String correoUsuario, String correoAdmin,
			Date fechaInicio, Date fechaFin, String[] dispositivos) throws MyException;

	public void modificar(int id, String correoAdministrador, int estado) throws MyException;

	public List<Prestamo> consultarTodos() throws MyException;

	public Prestamo consultarUno(int id) throws MyException;

	public List<Prestamo> prestamosSinRevisar() throws MyException;
	
}
