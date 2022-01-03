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

import uni.seed.practica2.entity.CompaniaSeguro;
import uni.seed.practica2.repository.CompaniaSeguroRepository;

@RestController
@RequestMapping(name="/companiaseguro")
@CrossOrigin
public class CompaniaSeguroServicio {
	
	@Autowired
	CompaniaSeguroRepository companiaSeguroRepository;
	
	@GetMapping(path="/buscar")
	public List<CompaniaSeguro>  buscar(){
		return companiaSeguroRepository.findAll();
	}
	
	@PostMapping(path="/guardar")
	public CompaniaSeguro guardar(@RequestBody CompaniaSeguro companiaSeguro) {
		return companiaSeguroRepository.save(companiaSeguro);
	}
	
	@DeleteMapping(path="delete/{id}")
	public void eliminar(@PathVariable Integer id) {
		Optional<CompaniaSeguro> companiaSeguro = companiaSeguroRepository.findById(id);
		if(companiaSeguro.isPresent()) {
			companiaSeguroRepository.delete(companiaSeguro.get());
		}
	}

}
