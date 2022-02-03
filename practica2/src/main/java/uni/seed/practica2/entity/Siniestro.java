package uni.seed.practica2.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name="SINIESTRO")
@Data
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


	
	
	

}
