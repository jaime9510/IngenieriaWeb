package co.edu.udea.iw.bl;

import java.util.List;

import co.edu.udea.iw.dto.Dispositivo;
import co.edu.udea.iw.dto.Tipo;
import co.edu.udea.iw.exception.MyException;

public interface DispositivoBL {

	/**
	 * @return
	 * @throws MyException
	 */
	public List<Dispositivo> consultarTodos() throws MyException;

	/**
	 * @param referencia
	 * @param nombre
	 * @param descripcion
	 * @param tipo
	 * @param foto
	 * @param emailAdministrador
	 * @throws MyException
	 */
	public void crearDispositivo(String referencia, String nombre, String descripcion, int tipo, String foto,
			String emailAdministrador) throws MyException;

	/**
	 * @param referencia
	 * @param nombre
	 * @param descripcion
	 * @param tipo
	 * @param foto
	 * @param disponible
	 * @param emailAdministrador
	 * @throws MyException
	 */
	public void actualizarDispositivo(String referencia, String nombre, String descripcion, int tipo, String foto,
			boolean disponible,String emailAdministrador) throws MyException;

	/**
	 * @param referencia
	 * @param emailAdministrador
	 * @throws MyException
	 */
	public void eliminarDispositivo(String referencia,String emailAdministrador) throws MyException;

	/**
	 * @param tipo
	 * @return
	 * @throws MyException
	 */
	public List<Dispositivo> consultarPorTipo(int tipo) throws MyException;


	/**
	 * @param referencia
	 * @return
	 * @throws MyException
	 */
	public Dispositivo consultarUno(String referencia) throws MyException;
}
