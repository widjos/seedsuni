package uni.seed.practica2.service;

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

import uni.seed.practica2.dto.SiniestroDto;
import uni.seed.practica2.entity.Perito;
import uni.seed.practica2.entity.Seguro;
import uni.seed.practica2.entity.Siniestro;
import uni.seed.practica2.repository.PeritoRepository;
import uni.seed.practica2.repository.SeguroRepository;
import uni.seed.practica2.repository.SiniestroRepository;

@RestController
@RequestMapping("/siniestro")
@CrossOrigin
public class SiniestroServicio {

	@Autowired
	SiniestroRepository siniestroRepository;
	
	@Autowired
	SeguroRepository seguroRepository;
	
	@Autowired
	PeritoRepository peritoRepository;
	
	@GetMapping(path="/buscar")
	public List<Siniestro> buscar(){
		return siniestroRepository.findAll();
	}
	
	@PostMapping(path="/guardar/seguro/{numeroPoliza}/perito/{dniPerito}")
	public Siniestro guardar(@RequestBody SiniestroDto  siniestroDto, @PathVariable int numeroPoliza , @PathVariable int dniPerito) {
		Siniestro siniestro = convertirSiniestroToSiniestroDto(siniestroDto);
		List<Perito> peritoList = peritoRepository.findAll();
		List<Seguro> seguroList = seguroRepository.findAll();
		
		for(Perito  per : peritoList) {
			if(per.getDniPerito() == dniPerito) {
				siniestro.setPerito(per);
			}
		}
		
		for(Seguro seg : seguroList) {
			if(seg.getNumeroPoliza() == numeroPoliza) {
				siniestro.setSeguro(seg);
			}
		}
		
		if(siniestro.getPerito() != null && siniestro.getSeguro() != null) {
			return siniestroRepository.save(siniestro);
		}else {
			return null;
		}
		
	}
	
	@PostMapping(path="/guardar/seguro/perito")
	public Siniestro guardarSeguroPerito(@RequestBody SiniestroDto siniestroDto) {
		Siniestro siniestro = convertirSiniestroToSiniestroDto(siniestroDto);
		Seguro seguro = siniestro.getSeguro();
		siniestro.setSeguro(null);
		seguroRepository.save(seguro);
		Perito perito = siniestro.getPerito();
		siniestro.setPerito(null);
		seguroRepository.save(seguro);
		siniestro.setSeguro(seguro);
		siniestro.setPerito(perito);
		return siniestroRepository.save(siniestro);
		
	}
	
	
	private Siniestro convertirSiniestroToSiniestroDto(SiniestroDto siniestroDto) {
	
		Siniestro siniestro = new Siniestro();
		siniestro.setAceptado(siniestroDto.getAceptado());
		siniestro.setCausas(siniestroDto.getCausas());
		siniestro.setFechaSiniestro(siniestroDto.getFechaSiniestro());
		siniestro.setIdSiniestro(siniestroDto.getIdSiniestro());
		siniestro.setPerito(siniestroDto.getPerito());
		siniestro.setSeguro(siniestroDto.getSeguro());
		siniestro.setIndenmizacion(siniestroDto.getIndenmizacion());
		return  siniestro;
	}
	
	@DeleteMapping(path="/eliminar/{idSiniestro}")
	public void eliminar(@PathVariable int idSiniestro) {
		Optional<Siniestro> siniestro = siniestroRepository.findById(idSiniestro);
		if(siniestro.isPresent()) {
			siniestroRepository.delete(siniestro.get());
		}
	}
	
	@GetMapping(path="/buscar/perito/{dniPerito}")
	public List<Siniestro> buscarPorDniPerito(@PathVariable int dniPerito){
		return siniestroRepository.findByPeritoDniPerito(dniPerito);
	}
	
	@GetMapping(path="/buscar/aceptado/{aceptado}")
	public List<Siniestro> buscarAceptados(@PathVariable char aceptado){
		return siniestroRepository.queryByAceptadoLike(aceptado);
	}
}
