package uni.seed.practica2.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
	
	@Column(name="NUMERO_POLIZA")
	private Integer numeroPoliza;
	
	@Column(name="DNI_PERITO")
	private  Integer dniPerito;

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

	public Integer getNumeroPoliza() {
		return numeroPoliza;
	}

	public void setNumeroPoliza(Integer numeroPoliza) {
		this.numeroPoliza = numeroPoliza;
	}

	public Integer getDniPerito() {
		return dniPerito;
	}

	public void setDniPerito(Integer dniPerito) {
		this.dniPerito = dniPerito;
	}
	
	

}
