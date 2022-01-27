package uni.seed.practica2.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.library.dto.beans.SeguroDto;
import uni.seed.practica2.common.ConversionDto;
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
	public Seguro guardar(SeguroDto seguroDto) {
		Seguro seguro = conversionDto.converitSeguroToSeguroDto(seguroDto);
		return seguroRepository.save(seguro);
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
