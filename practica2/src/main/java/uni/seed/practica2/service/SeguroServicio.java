package uni.seed.practica2.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uni.seed.practica2.dto.SeguroDto;
import uni.seed.practica2.entity.Seguro;
import uni.seed.practica2.repository.SeguroRepository;

@RestController
@RequestMapping("seguro")
@CrossOrigin
public class SeguroServicio {

	@Autowired
	SeguroRepository seguroRepository;
	
	
	@GetMapping(path="/buscar")
	public List<Seguro> buscar(){
		return seguroRepository.findAll();
	}
	
	@PostMapping(path="/guardar")
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
	
	@DeleteMapping(path="/eliminar/{numeroPoliza}")
	public void eliminar(@PathVariable int numeroPoliza) {
		Optional<Seguro>  seguro = seguroRepository.findById(numeroPoliza);
		if(seguro.isPresent()) {
			seguroRepository.delete(seguro.get());
		}
	}
	
	@GetMapping(path="/buscar/fechaInicio/despuesde/{fechaInicio}")
	public List<Seguro> buscarPorFechaDespues(@PathVariable Date fechaInicio){
		return seguroRepository.findByFechaInicioAfter(fechaInicio);
	}
	
	@GetMapping(path="/buscar/fechaInicio/{fechaInicio}")
	public List<Seguro> buscarFechaiInicio(@PathVariable Date fechaInicio){
		return seguroRepository.findByFechaInicio(fechaInicio);
	}
	
	
	@GetMapping(path="/buscar/poliza/{numeroPoliza}")
	public List<Seguro> buscarPorCompaniaAsc(@PathVariable int numeroPoliza){
		return seguroRepository.findByNumeroPoliza(numeroPoliza);
	}

}
