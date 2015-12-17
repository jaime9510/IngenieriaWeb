package co.edu.udea.iw.bl;

import java.util.List;

import co.edu.udea.iw.dto.Dispositivo;
import co.edu.udea.iw.dto.Fallo;
import co.edu.udea.iw.exception.MyException;

public interface FalloBL {


	/**
	 * @return
	 * @throws MyException
	 */
	public List<Fallo> consultarTodos() throws MyException;

	/**
	 * @param idFallo
	 * @param error
	 * @param referenciaDispositivo
	 * @throws MyException
	 */
	public void crearFallo(int idFallo, String error, String referenciaDispositivo) throws MyException;

	/**
	 * @param idFallo
	 * @param solucionado
	 * @throws MyException
	 */
	public void actualizarFallo(int idFallo, boolean solucionado) throws MyException;

	/**
	 * @param referenciaDispositivo
	 * @return
	 * @throws MyException
	 */
	public List<Fallo> consultarFalloPorDispositivo(String referenciaDispositivo) throws MyException;

	/**
	 * @return
	 * @throws MyException
	 */
	public List<Fallo> consultarDanosSinSolucion() throws MyException;
	
	public Fallo consultarUno(int id) throws MyException;

}
