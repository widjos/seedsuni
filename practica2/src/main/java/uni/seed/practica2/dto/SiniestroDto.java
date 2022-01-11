package uni.seed.practica2.dto;

import java.io.Serializable;
import java.sql.Date;

import uni.seed.practica2.entity.Perito;
import uni.seed.practica2.entity.Seguro;

public class SiniestroDto implements Serializable{

	private static final long serialVersionUID = 2450849770751145737L;

	private Integer idSiniestro;
	private Date fechaSiniestro;
	private String causas;
	private char aceptado;
	private String indenmizacion;
	private Seguro seguro;
	private  Perito perito;
	public Integer getIdSiniestro() {
		return idSiniestro;
	}
	public void setIdSiniestro(Integer idSiniestro) {
		this.idSiniestro = idSiniestro;
	}
	public Date getFechaSiniestro() {
		return fechaSiniestro;
	}
	public void setFechaSiniestro(Date fechaSiniestro) {
		this.fechaSiniestro = fechaSiniestro;
	}
	public String getCausas() {
		return causas;
	}
	public void setCausas(String causas) {
		this.causas = causas;
	}
	public char getAceptado() {
		return aceptado;
	}
	public void setAceptado(char aceptado) {
		this.aceptado = aceptado;
	}
	public String getIndenmizacion() {
		return indenmizacion;
	}
	public void setIndenmizacion(String indenmizacion) {
		this.indenmizacion = indenmizacion;
	}
	public Seguro getSeguro() {
		return seguro;
	}
	public void setSeguro(Seguro seguro) {
		this.seguro = seguro;
	}
	public Perito getPerito() {
		return perito;
	}
	public void setPerito(Perito perito) {
		this.perito = perito;
	}
	
	

}
