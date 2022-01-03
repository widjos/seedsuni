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



import uni.seed.practica2.repository.ClienteRepository;
import uni.seed.practica2.entity.Cliente;

@RestController
@RequestMapping("/cliente")
@CrossOrigin
public class ClienteServicio {
	
	@Autowired 
	ClienteRepository clienteRepository;
	
	@GetMapping(path = "/buscar")
	public List<Cliente> buscar(){
		return clienteRepository.findAll();
	}
	
	@PostMapping(path="/guardar")
	public Cliente guardar(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	
	@DeleteMapping(path="/eliminar/{dniCl}")
	public void eliminar(@PathVariable("dniCl") int dniCl) {
		Optional<Cliente> cliente = clienteRepository.findById(dniCl);
		if(cliente.isPresent()) {
			clienteRepository.delete(cliente.get());
		}
	}
	
}
