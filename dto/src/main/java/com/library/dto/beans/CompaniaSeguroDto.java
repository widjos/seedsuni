package com.library.dto.beans;

import java.io.Serializable;


public class CompaniaSeguroDto implements Serializable{

	private static final long serialVersionUID = -1665062942499715169L;
	private Integer id;
	private SeguroDto seguro;
	private CompaniaDto compania;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public SeguroDto getSeguro() {
		return seguro;
	}
	public void setSeguro(SeguroDto seguro) {
		this.seguro = seguro;
	}
	public CompaniaDto getCompania() {
		return compania;
	}
	public void setCompania(CompaniaDto compania) {
		this.compania = compania;
	}
	
	
	

}
