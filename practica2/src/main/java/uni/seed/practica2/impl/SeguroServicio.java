package uni.seed.practica2.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import uni.seed.practica2.common.ConversionDto;
import uni.seed.practica2.dto.SeguroDto;
import uni.seed.practica2.entity.Seguro;
import uni.seed.practica2.repository.SeguroRepository;
import uni.seed.practica2.ws.SeguroServicioInt;

@Component
public class SeguroServicio implements SeguroServicioInt {

	@Autowired
	SeguroRepository seguroRepository;
	
	@Autowired
	ConversionDto conversionDto;
	
	
	@Override
	public List<Seguro> buscar(){
		return seguroRepository.findAll();
	}
	
	@Override
	public ResponseEntity<Seguro> guardar(SeguroDto seguroDto) {
		
		try {
			Seguro seguro = conversionDto.converitSeguroToSeguroDto(seguroDto);
			return  new ResponseEntity<>(seguroRepository.save(seguro),null,HttpStatus.OK);
		}catch(Exception exp) {
			return new ResponseEntity<>(null,null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	@Override
	public void eliminar(int numeroPoliza) {
		Optional<Seguro>  seguro = seguroRepository.findById(numeroPoliza);
		if(seguro.isPresent()) {
			seguroRepository.delete(seguro.get());
		}
	}
	
	@Override
	public List<Seguro> buscarPorFechaDespues(Date fechaInicio){
		return seguroRepository.findByFechaInicioAfter(fechaInicio);
	}
	
	@Override
	public List<Seguro> buscarFechaiInicio(Date fechaInicio){
		return seguroRepository.findByFechaInicio(fechaInicio);
	}
	
	
	@Override
	public List<Seguro> buscarPorCompaniaAsc(int numeroPoliza){
		return seguroRepository.findByNumeroPoliza(numeroPoliza);
	}

}
