package co.edu.udea.iw.bl;

import java.util.List;

import co.edu.udea.iw.dto.Dispositivo;
import co.edu.udea.iw.dto.Fallo;
import co.edu.udea.iw.exception.MyException;

public interface FalloBL {

	public List<Fallo> consultarTodos() throws MyException;

	public void crearFallo(int idFallo, String error, String referenciaDispositivo) throws MyException;

	public void actualizarFallo(int idFallo, boolean solucionado) throws MyException;

	public List<Fallo> consultarFalloPorDispositivo(String referenciaDispositivo) throws MyException;

	public List<Fallo> consultarDañosSinSolucion() throws MyException;

}
