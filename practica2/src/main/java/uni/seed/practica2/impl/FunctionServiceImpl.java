package uni.seed.practica2.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.library.dto.beans.SeguroDto;
import uni.seed.practica2.common.ConversionDto;
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
	public int nuevoSeguro(SeguroDto seguro) {
		Seguro convertido = conversionDto.converitSeguroToSeguroDto(seguro);
		return functionService.nuevoSeguro(convertido);
	}

}
