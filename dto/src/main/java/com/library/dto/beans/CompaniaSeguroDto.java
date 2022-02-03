package com.library.dto.beans;

import java.io.Serializable;

import lombok.Data;

@Data
public class CompaniaSeguroDto implements Serializable{

	private static final long serialVersionUID = -1665062942499715169L;
	private Integer id;
	private SeguroDto seguro;
	private CompaniaDto compania;

}
