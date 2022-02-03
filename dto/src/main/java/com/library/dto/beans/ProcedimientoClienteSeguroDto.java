package com.library.dto.beans;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class ProcedimientoClienteSeguroDto  implements Serializable{

	private static final long serialVersionUID = 6510484911370825312L;
	
	
	private String outNombreCliente;
	private Date outFechaInicio;

	

}
