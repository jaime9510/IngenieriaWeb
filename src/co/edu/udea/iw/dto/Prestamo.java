package co.edu.udea.iw.dto;

import java.io.Serializable;
import java.util.Date;

public class Prestamo implements Serializable{

	private int idPrestamo;
	private String nombreUsuario;
	private String cedulaUsuario;
	private Date fechaInicio;
	private Date fechaFin;
	private Date fechaEntrega;
	private Administrador administrador;
	private int estado;
	private String correoUsuario;
	
	
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public String getCorreoUsuario() {
		return correoUsuario;
	}
	public void setCorreoUsuario(String correoUsuario) {
		this.correoUsuario = correoUsuario;
	}
	public Date getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
		
	public int getIdPrestamo() {
		return idPrestamo;
	}
	public void setIdPrestamo(int idPrestamo) {
		this.idPrestamo = idPrestamo;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getCedulaUsuario() {
		return cedulaUsuario;
	}
	public void setCedulaUsuario(String cedulaUsuario) {
		this.cedulaUsuario = cedulaUsuario;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public Administrador getAdministrador() {
		return administrador;
	}
	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}
	
	
}
