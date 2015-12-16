package co.edu.udea.iw.bl;

import java.util.List;

import co.edu.udea.iw.dto.Dispositivo;
import co.edu.udea.iw.dto.Tipo;
import co.edu.udea.iw.exception.MyException;

public interface DispositivoBL {

	public List<Dispositivo> consultarTodos() throws MyException;

	public void crearDispositivo(String referencia, String nombre, String descripcion, int tipo, String foto,
			String emailAdministrador) throws MyException;

	public void actualizarDispositivo(String referencia, String nombre, String descripcion, int tipo, String foto,
			boolean disponible,String emailAdministrador) throws MyException;

	public void eliminarDispositivo(String referencia,String emailAdministrador) throws MyException;

	public List<Dispositivo> consultarPorTipo(int tipo) throws MyException;

	public List<Dispositivo> consultarDisponibles() throws MyException;

	public Dispositivo consultarUno(String referencia) throws MyException;
}
