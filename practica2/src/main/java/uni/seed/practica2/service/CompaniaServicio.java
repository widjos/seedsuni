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

import uni.seed.practica2.entity.Compania;
import uni.seed.practica2.repository.CompaniaRepository;
import uni.seed.practica2.repository.SeguroRepository;

@RestController
@RequestMapping("/compania")
@CrossOrigin
public class CompaniaServicio {

	@Autowired
	CompaniaRepository companiaRepository;
	
	@Autowired
	SeguroRepository seguroRepository;
	
	@GetMapping(path="/buscar")
	public List<Compania> buscar(){
		return companiaRepository.findAll();
	}
	
	@PostMapping(path="/guardar")
	public Compania guardar(@RequestBody Compania compania) {
		return companiaRepository.save(compania);
	}

	
	@DeleteMapping(path="/eliminar/{nombreCompania}")
	public void eliminar(@PathVariable String nombreCompania) {
		Optional<Compania> compania = companiaRepository.findById(nombreCompania);
		if(compania.isPresent()) {
			companiaRepository.delete(compania.get());
		}
	}
	
	@GetMapping(path="/buscar/{nombreVia}")
	public List<Compania> buscarPorId(@PathVariable String nombreVia){
		return companiaRepository.findByNombreViaOrderByNombreCompaniaDesc(nombreVia);
	}
	
	
	@GetMapping(path="/buscar/nombre/contiene/{referencia}")
	public List<Compania> buscarContieneNombre(@PathVariable String referencia){
		return companiaRepository.queryByNombreCompaniaContaining(referencia);
	}
}
