package com.library.dto.beans;

import java.io.Serializable;
import java.sql.Date;

public class SiniestroDto implements Serializable{

	private static final long serialVersionUID = 2450849770751145737L;

	private Integer idSiniestro;
	private Date fechaSiniestro;
	private String causas;
	private char aceptado;
	private String indenmizacion;
	private SeguroDto seguro;
	private  PeritoDto perito;
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
	public SeguroDto getSeguro() {
		return seguro;
	}
	public void setSeguro(SeguroDto seguro) {
		this.seguro = seguro;
	}
	public PeritoDto getPerito() {
		return perito;
	}
	public void setPerito(PeritoDto perito) {
		this.perito = perito;
	}
	
	

}
