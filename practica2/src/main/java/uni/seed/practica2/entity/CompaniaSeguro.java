package uni.seed.practica2.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COMPANIA_SEGURO")
public class CompaniaSeguro implements Serializable{

	private static final long serialVersionUID = -5151080018907566487L;
	
	@Id
	@Column(name="ID")
	private Integer id;
	
	@Column(name="NUMERO_POLIZA")
	private Integer numeroPoliza;
	
	@Column(name="NOMBRE_COMPANIA")
	private String nombreCompania;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumeroPoliza() {
		return numeroPoliza;
	}

	public void setNumeroPoliza(Integer numeroPoliza) {
		this.numeroPoliza = numeroPoliza;
	}

	public String getNombreCompania() {
		return nombreCompania;
	}

	public void setNombreCompania(String nombreCompania) {
		this.nombreCompania = nombreCompania;
	}
	
	
		
}
