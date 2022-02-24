package uni.seed.practica2.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import uni.seed.practica2.common.ConversionDto;
import uni.seed.practica2.dto.SeguroDto;
import uni.seed.practica2.entity.Seguro;
import uni.seed.practica2.service.FunctionService;
import uni.seed.practica2.ws.FunctionInt;

@Component
public class FunctionServiceImpl implements FunctionInt {

	@Autowired
	FunctionService functionService;
	
	@Autowired
	ConversionDto conversionDto;

	@Override
	public ResponseEntity<Integer> nuevoSeguro(SeguroDto seguro) {
		
		try {
			Seguro convertido = conversionDto.converitSeguroToSeguroDto(seguro);			
			return new ResponseEntity<>(functionService.nuevoSeguro(convertido),null,HttpStatus.OK);
			
		}catch(Exception exp) {
			return new ResponseEntity<>(null,null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		

	}

}
