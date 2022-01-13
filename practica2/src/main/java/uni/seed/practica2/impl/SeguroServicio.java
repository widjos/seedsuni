package uni.seed.practica2.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import uni.seed.practica2.dto.SeguroDto;
import uni.seed.practica2.entity.Seguro;
import uni.seed.practica2.repository.SeguroRepository;
import uni.seed.practica2.ws.SeguroServicioInt;

@Component
public class SeguroServicio implements SeguroServicioInt {

	@Autowired
	SeguroRepository seguroRepository;
	
	
	@GetMapping(path="/buscar")
	public List<Seguro> buscar(){
		return seguroRepository.findAll();
	}
	
	@Override
	public Seguro guardar(@RequestBody SeguroDto seguroDto) {
		Seguro seguro = converitSeguroToSeguroDto(seguroDto);
		return seguroRepository.save(seguro);
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
	
	@Override
	public void eliminar(@PathVariable int numeroPoliza) {
		Optional<Seguro>  seguro = seguroRepository.findById(numeroPoliza);
		if(seguro.isPresent()) {
			seguroRepository.delete(seguro.get());
		}
	}
	
	@Override
	public List<Seguro> buscarPorFechaDespues(@PathVariable Date fechaInicio){
		return seguroRepository.findByFechaInicioAfter(fechaInicio);
	}
	
	@Override
	public List<Seguro> buscarFechaiInicio(@PathVariable Date fechaInicio){
		return seguroRepository.findByFechaInicio(fechaInicio);
	}
	
	
	@Override
	public List<Seguro> buscarPorCompaniaAsc(@PathVariable int numeroPoliza){
		return seguroRepository.findByNumeroPoliza(numeroPoliza);
	}

}
