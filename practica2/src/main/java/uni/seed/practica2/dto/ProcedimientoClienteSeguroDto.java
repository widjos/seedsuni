package uni.seed.practica2.dto;

import java.io.Serializable;
import java.util.Date;

public class ProcedimientoClienteSeguroDto  implements Serializable{

	private static final long serialVersionUID = 6510484911370825312L;
	
	
	private String outNombreCliente;
	private Date outFechaInicio;

	
	public String getOutNombreCliente() {
		return outNombreCliente;
	}
	public void setOutNombreCliente(String outNombreCliente) {
		this.outNombreCliente = outNombreCliente;
	}

	public Date getOutFechaInicio() {
		return outFechaInicio;
	}
	public void setOutfechaInicio(Date outFechaInicio) {
		this.outFechaInicio = outFechaInicio;
	}
	
	
	

}
