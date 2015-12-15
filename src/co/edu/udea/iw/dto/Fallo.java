package co.edu.udea.iw.dto;

import java.io.Serializable;
import java.util.Date;

public class Fallo implements Serializable{
	
	private int idFallo;
	private String error;
	private Date fechaDeteccion;
	private boolean solucionado;
	private Dispositivo dispositivo;
	
	
	public int getIdFallo() {
		return idFallo;
	}
	public void setIdFallo(int idFallo) {
		this.idFallo = idFallo;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public Date getFechaDeteccion() {
		return fechaDeteccion;
	}
	public void setFechaDeteccion(Date fechaDeteccion) {
		this.fechaDeteccion = fechaDeteccion;
	}
	public boolean isSolucionado() {
		return solucionado;
	}
	public void setSolucionado(boolean solucionado) {
		this.solucionado = solucionado;
	}
	public Dispositivo getDispositivo() {
		return dispositivo;
	}
	public void setDispositivo(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;
	}
	
	
}
