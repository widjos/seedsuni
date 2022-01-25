package uni.seed.practica2.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.library.dto.beans.CompaniaSeguroDto;
import com.library.dto.beans.SiniestroDto;

@Entity
@Table(name="SEGURO")
public class Seguro  implements Serializable{

	private static final long serialVersionUID = -6724631396193550050L;
	
	@Id
	@Column(name="NUMERO_POLIZA")
	private Integer numeroPoliza;
	
	@Column(name="RAMO")
	private String ramo;
	
	@Column(name="FECHA_INICIO")
	private Date fechaInicio;
	
	@Column(name="FECHA_VENCIMIENTO")
	private Date fechaVencimiento;
	
	@Column(name="CONDICIONES_PARTICULARES")
	private String condicionesParticulares;
	
	@Column(name="OBSERVACIONES")
	private String observaciones;
	

	@Column(name="DNI_CL")
	private Integer dniCl;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "seguro")
	private List<CompaniaSeguro> companiaSeguro;

	@JsonIgnore
	@OneToMany(mappedBy = "seguro")
	private List<Siniestro> siniestro;
	
	
	
	public List<Siniestro> getSiniestro() {
		return siniestro;
	}

	public void setSiniestro(List<Siniestro> siniestro) {
		this.siniestro = siniestro;
	}

	public List<CompaniaSeguro> getCompaniaSeguro() {
		return companiaSeguro;
	}

	public void setCompaniaSeguro(List<CompaniaSeguro> companiaSeguro) {
		this.companiaSeguro = companiaSeguro;
	}

	public Integer getNumeroPoliza() {
		return numeroPoliza;
	}

	public void setNumeroPoliza(Integer numeroPoliza) {
		this.numeroPoliza = numeroPoliza;
	}

	public String getRamo() {
		return ramo;
	}

	public void setRamo(String ramo) {
		this.ramo = ramo;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public String getCondicionesParticulares() {
		return condicionesParticulares;
	}

	public void setCondicionesParticulares(String condicionesParticulares) {
		this.condicionesParticulares = condicionesParticulares;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Integer getDniCl() {
		return dniCl;
	}

	public void setDniCl(Integer dniCl) {
		this.dniCl = dniCl;
	}
	
}
