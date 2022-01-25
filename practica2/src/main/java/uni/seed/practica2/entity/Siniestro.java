package uni.seed.practica2.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.library.dto.beans.PeritoDto;
import com.library.dto.beans.SeguroDto;

@Entity
@Table(name="SINIESTRO")
public class Siniestro  implements Serializable{

	private static final long serialVersionUID = 4400187197284680580L;
	
	@Id
	@Column(name="ID_SINIESTRO")
	private Integer idSiniestro;
	
	@Column(name="FECHA_SINIESTRO")
	private Date fechaSiniestro;
	
	@Column(name="CAUSAS")
	private String causas;
	
	@Column(name="ACEPTADO")
	private char aceptado;
	
	@Column(name="INDENMIZACION")
	private String indenmizacion;
	
	@ManyToOne
	@JoinColumn(name="numeroPoliza")
	private Seguro seguro;
	
	@ManyToOne
	@JoinColumn(name="dniPerito")
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
