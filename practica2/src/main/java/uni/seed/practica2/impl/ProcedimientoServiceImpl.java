package uni.seed.practica2.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import uni.seed.practica2.dto.ProcedimientoClienteSeguroDto;
import uni.seed.practica2.service.ProcedimientoServicio;
import uni.seed.practica2.ws.ProcedimientoServicioInt;

@Component
public class ProcedimientoServiceImpl  implements ProcedimientoServicioInt{

	@Autowired
	ProcedimientoServicio procedimientoServicio;
	
	@Override
	public int cambiarNumeroCliente(Integer dniCl, Integer telefono) {
		return procedimientoServicio.cambiarNumeroCliente(dniCl, telefono);
	}

	

	@Override
	public double conversionTasa(Double valor) {
		return procedimientoServicio.conversionTasa(valor);
	}



	@Override
	public ProcedimientoClienteSeguroDto buscarClienteSeguros(Integer dniCl, Integer numeroPoliza) {
		
		return procedimientoServicio.buscarClienteSeguros(dniCl, numeroPoliza);
	}

}
