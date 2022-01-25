package uni.seed.practica2.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="COMPANIA_SEGURO")
public class CompaniaSeguro implements Serializable{

	private static final long serialVersionUID = -5151080018907566487L;
	
	@Id
	@Column(name="ID")
	private Integer id;
	
	
	@ManyToOne
	@JoinColumn(name="numeroPoliza")
	private Seguro seguro;
	
	@ManyToOne
	@JoinColumn(name="nombreCompania")
	private Compania compania;
	

	public Seguro getSeguro() {
		return seguro;
	}

	public void setSeguro(Seguro seguro) {
		this.seguro = seguro;
	}

	public Compania getCompania() {
		return compania;
	}

	public void setCompania(Compania compania) {
		this.compania = compania;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	
	
		
}
