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

import lombok.Data;

@Entity
@Table(name="SEGURO")
@Data
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
	
	

}
