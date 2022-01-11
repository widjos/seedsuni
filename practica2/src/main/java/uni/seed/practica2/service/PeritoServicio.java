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

import uni.seed.practica2.dto.PeritoDto;
import uni.seed.practica2.entity.Perito;
import uni.seed.practica2.entity.Siniestro;
import uni.seed.practica2.repository.PeritoRepository;
import uni.seed.practica2.repository.SiniestroRepository;

@RestController
@RequestMapping("/perito")
@CrossOrigin
public class PeritoServicio {

	@Autowired
	PeritoRepository peritoRepository;
	
	@Autowired
	SiniestroRepository siniestroRepository;
	
	@GetMapping(path="/buscar")
	public List<Perito> buscar(){
		return peritoRepository.findAll();
	}
	
	@PostMapping(path="/guardar")
	public Perito guardar(@RequestBody PeritoDto peritoDto){
		Perito perito = convertirPeritoToPeritoDto(peritoDto);
		return peritoRepository.save(perito);
	}
	
	private Perito convertirPeritoToPeritoDto(PeritoDto peritoDto) {
		Perito perito = new Perito();
		perito.setApellidoPerito1(peritoDto.getApellidoPerito1());
		perito.setApellidoPerito2(peritoDto.getApellidoPerito2());
		perito.setCiudad(peritoDto.getCiudad());
		perito.setClaseVia(peritoDto.getClaseVia());
		perito.setCodPostal(peritoDto.getCodPostal());
		perito.setDniPerito(peritoDto.getDniPerito());
		perito.setNombrePerito(peritoDto.getNombrePerito());
		perito.setNombreVia(peritoDto.getNombreVia());
		perito.setNumeroVia(peritoDto.getNumeroVia());
		perito.setSiniestro(peritoDto.getSiniestro());
		perito.setTelefonoContacto(peritoDto.getTelefonoContacto());
		perito.setTelefonoOficina(peritoDto.getTelefonoOficina());
		return perito;
	}
	
	@DeleteMapping(path="/eliminar/{dniPerito}")
	public void eliminar(@PathVariable Integer dniPerito){
		Optional<Perito> perito = peritoRepository.findById(dniPerito);
		if(perito.isPresent()) {
			peritoRepository.delete(perito.get());
		}
	}
	
	@GetMapping(path="/buscar/{ciudad}/numerovia/{numeroVia}")
	public List<Perito> buscarCiudadYNumeroVia(@PathVariable String  ciudad, @PathVariable String numeroVia){
		return peritoRepository.findByCiudadAndNumeroVia(ciudad, numeroVia);
	}
	
	@GetMapping(path="/buscar/{dniPerito}/siniestro")
	public List<Siniestro> buscarSiniestroPerito(@PathVariable int dniPerito){
		List<Siniestro> siniestro = siniestroRepository.findAll();
		for(Siniestro sin : siniestro) {
			if(sin.getPerito().getDniPerito() != dniPerito) {
				siniestro.remove(sin);
			}
		}
		return siniestro;
	}
}
