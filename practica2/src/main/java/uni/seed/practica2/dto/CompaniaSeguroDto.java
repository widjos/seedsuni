package uni.seed.practica2.dto;

import java.io.Serializable;

import uni.seed.practica2.entity.Compania;
import uni.seed.practica2.entity.Seguro;

public class CompaniaSeguroDto implements Serializable{

	private static final long serialVersionUID = -1665062942499715169L;
	private Integer id;
	private Seguro seguro;
	private Compania compania;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
	
	
	

}
