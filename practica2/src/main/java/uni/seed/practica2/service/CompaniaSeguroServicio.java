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
import uni.seed.practica2.entity.CompaniaSeguro;
import uni.seed.practica2.entity.Seguro;
import uni.seed.practica2.repository.CompaniaRepository;
import uni.seed.practica2.repository.CompaniaSeguroRepository;
import uni.seed.practica2.repository.SeguroRepository;

@RestController
@RequestMapping("/companiaseguro")
@CrossOrigin
public class CompaniaSeguroServicio {
	
	@Autowired
	CompaniaSeguroRepository companiaSeguroRepository;
	
	@Autowired
	SeguroRepository seguroRepository;
	
	@Autowired
	CompaniaRepository companiaRepository;
	
	@GetMapping(path="/buscar")
	public List<CompaniaSeguro>  buscar(){
		return companiaSeguroRepository.findAll();
	}
	
	@PostMapping(path="/guardar/compania/{nombreCompania}/seguro/{numeroPoliza}")
	public CompaniaSeguro guardar(@RequestBody CompaniaSeguro companiaSeguro, @PathVariable String nombreCompania, @PathVariable int numeroPoliza) {
		
		List<Compania> compania = companiaRepository.findAll();
		List<Seguro> seguro = seguroRepository.findAll();
		for(Compania com : compania) {
			if(com.getNombreCompania().equals(nombreCompania)) {
				companiaSeguro.setCompania(com);
			}
		}
		for(Seguro  seg : seguro) {
			if(seg.getNumeroPoliza() == numeroPoliza) {
				companiaSeguro.setSeguro(seg);
			}
		}
		
		if(companiaSeguro.getCompania() != null && companiaSeguro.getSeguro() != null) {
			return companiaSeguroRepository.save(companiaSeguro);
		}else {
			return null;
		}
		
	}
	
	@PostMapping(path="/guardar/compania/y/seguro")
	public CompaniaSeguro guardarCompaniaYSeguro(@RequestBody CompaniaSeguro companiaSeguro) {
		Seguro seguro = companiaSeguro.getSeguro();
		companiaSeguro.setSeguro(null);
		seguroRepository.save(seguro);
		Compania compania = companiaSeguro.getCompania();
		companiaSeguro.setCompania(null);
		companiaRepository.save(compania);
		companiaSeguro.setCompania(compania);
		companiaSeguro.setSeguro(seguro);
		return companiaSeguroRepository.save(companiaSeguro);
		
	}
	
	
	@DeleteMapping(path="/eliminar/{id}")
	public void eliminar(@PathVariable Integer id) {
		Optional<CompaniaSeguro> companiaSeguro = companiaSeguroRepository.findById(id);
		if(companiaSeguro.isPresent()) {
			companiaSeguroRepository.delete(companiaSeguro.get());
		}
	}
	
	@GetMapping(path="/buscar/{id}")
	public List<CompaniaSeguro> buscarPorId(@PathVariable int id){
		return companiaSeguroRepository.findById(id);
	}

}
