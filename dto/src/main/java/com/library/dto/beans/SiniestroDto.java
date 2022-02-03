package com.library.dto.beans;

import java.io.Serializable;
import java.sql.Date;

import lombok.Data;

@Data
public class SiniestroDto implements Serializable{

	private static final long serialVersionUID = 2450849770751145737L;

	private Integer idSiniestro;
	private Date fechaSiniestro;
	private String causas;
	private char aceptado;
	private String indenmizacion;
	private SeguroDto seguro;
	private  PeritoDto perito;

}
