package co.edu.udea.iw.dto;

import java.io.Serializable;

public class Prestamo_has_DispositivoId implements Serializable{
	
	private Prestamo prestamo;
	private Dispositivo referencia;
	
	
	public Prestamo getPrestamo() {
		return prestamo;
	}
	public void setPrestamo(Prestamo prestamo) {
		this.prestamo = prestamo;
	}
	public Dispositivo getReferencia() {
		return referencia;
	}
	public void setReferencia(Dispositivo referencia) {
		this.referencia = referencia;
	}
	
	
}
