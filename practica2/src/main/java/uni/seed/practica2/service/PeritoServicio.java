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

import uni.seed.practica2.entity.Perito;
import uni.seed.practica2.repository.PeritoRepository;

@RestController
@RequestMapping("/perito")
@CrossOrigin
public class PeritoServicio {

	@Autowired
	PeritoRepository peritoRepository;
	
	@GetMapping(path="/buscar")
	public List<Perito> buscar(){
		return peritoRepository.findAll();
	}
	
	@PostMapping(path="/guardar")
	public Perito guardar(@RequestBody Perito perito){
		return peritoRepository.save(perito);
	}
	
	@DeleteMapping(path="/eliminar/{dniPerito}")
	public void eliminar(@PathVariable Integer dniPerito){
		Optional<Perito> perito = peritoRepository.findById(dniPerito);
		if(perito.isPresent()) {
			peritoRepository.delete(perito.get());
		}
	}
	
	@GetMapping(path="/buscar/{ciudad}/y/numerovia/{numeroVia}")
	public List<Perito> buscarCiudadYNumeroVia(@PathVariable String  ciudad, @PathVariable Integer numeroVia){
		return peritoRepository.findByCiudadAndNumeroVia(ciudad, numeroVia);
	}
}
