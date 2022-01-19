package uni.seed.practica2.dto;

import java.io.Serializable;
import java.util.Date;

public class ProcedimientoClienteSeguroDto  implements Serializable{

	private static final long serialVersionUID = 6510484911370825312L;
	
	
	private String out_nombreCliente;
	private Date out_fechaInicio;

	
	public String getOut_nombreCliente() {
		return out_nombreCliente;
	}
	public void setOut_nombreCliente(String out_nombreCliente) {
		this.out_nombreCliente = out_nombreCliente;
	}

	public Date getOut_fechaInicio() {
		return out_fechaInicio;
	}
	public void setOut_fechaInicio(Date out_fechaInicio) {
		this.out_fechaInicio = out_fechaInicio;
	}
	
	
	

}
