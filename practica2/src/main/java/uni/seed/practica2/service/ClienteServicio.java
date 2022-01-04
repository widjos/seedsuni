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
import uni.seed.practica2.repository.SeguroRepository;
import uni.seed.practica2.entity.Cliente;
import uni.seed.practica2.entity.Seguro;

@RestController
@RequestMapping("/cliente")
@CrossOrigin
public class ClienteServicio {
	
	@Autowired 
	ClienteRepository clienteRepository;
	
	@Autowired
	SeguroRepository seguroRepository;
	
	@GetMapping(path = "/buscar")
	public List<Cliente> buscar(){
		return clienteRepository.findAll();
	}
	
	@PostMapping(path="/guardar")
	public Cliente guardar(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	@PostMapping(path="/guardar/seguro")
	public Cliente guardarSeguro(@RequestBody Cliente cliente) {
		
		List<Seguro> seguro = cliente.getSeguro();
		cliente.setSeguro(null);
		clienteRepository.save(cliente);
		for(Seguro seg : seguro ) 
			seg.setDniCl(cliente.getDniCl());  
		
		seguroRepository.saveAll(seguro);
		cliente.setSeguro(seguro);
		return cliente;
	}
	
	@DeleteMapping(path="/eliminar/{dniCl}")
	public void eliminar(@PathVariable("dniCl") int dniCl) {
		Optional<Cliente> cliente = clienteRepository.findById(dniCl);
		if(cliente.isPresent()) {
			clienteRepository.delete(cliente.get());
		}
	}
	
	@GetMapping(path="/buscar/nombre/{nombreCl}/and/{apellido1}")
	public List<Cliente> buscarNombreYApellido1(@PathVariable String nombreCl, @PathVariable String apellido1){
		return clienteRepository.findByNombreClAndApellido1(nombreCl, apellido1);
	}
	
	@GetMapping(path="/buscar/apellido2/{apellido2}/or/ciudad/{ciudad}")
	public List<Cliente> buscarApellido2OCiudad(@PathVariable String apellido2, @PathVariable String  ciudad){
		return clienteRepository.findByApellido2OrCiudad(apellido2, ciudad);
	}

	
}
