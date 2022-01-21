package uni.seed.practica2.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import uni.seed.practica2.dto.SeguroDto;
import uni.seed.practica2.entity.Seguro;
import uni.seed.practica2.service.FunctionService;
import uni.seed.practica2.ws.FunctionInt;

@Component
public class FunctionServiceImpl implements FunctionInt {

	@Autowired
	FunctionService functionService;
	
	
	@Override
	public int nuevoSeguro(SeguroDto seguro) {
		Seguro convertido = converitSeguroToSeguroDto(seguro);			
		return functionService.nuevoSeguro(convertido);
	}
	
	private Seguro converitSeguroToSeguroDto(SeguroDto seguroDto) {
		Seguro seguro = new Seguro();
		seguro.setCompaniaSeguro(seguroDto.getCompaniaSeguro());
		seguro.setCondicionesParticulares(seguroDto.getCondicionesParticulares());
		seguro.setDniCl(seguroDto.getDniCl());
		seguro.setFechaInicio(seguroDto.getFechaInicio());
		seguro.setFechaVencimiento(seguroDto.getFechaVencimiento());
		seguro.setNumeroPoliza(seguroDto.getNumeroPoliza());
		seguro.setObservaciones(seguroDto.getObservaciones());
		seguro.setRamo(seguro.getRamo());
		seguro.setSiniestro(seguroDto.getSiniestro());
		
		return seguro;
	}

}
