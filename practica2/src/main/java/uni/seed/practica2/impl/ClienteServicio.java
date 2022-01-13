package uni.seed.practica2.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import uni.seed.practica2.repository.ClienteRepository;
import uni.seed.practica2.repository.SeguroRepository;
import uni.seed.practica2.service.CatalogoServicio;
import uni.seed.practica2.ws.ClienteServicioInt;
import uni.seed.practica2.dto.ClienteDto;
import uni.seed.practica2.entity.Cliente;
import uni.seed.practica2.entity.Seguro;

@Component
public class ClienteServicio implements ClienteServicioInt {
	
	@Autowired 
	ClienteRepository clienteRepository;
	
	@Autowired
	SeguroRepository seguroRepository;
	
	@Autowired
	CatalogoServicio catalogoServicio;
	
	@Override
	public List<Cliente> buscar(){
		return clienteRepository.findAll();
	}
	
	@Override
	public Cliente guardar(@RequestBody ClienteDto clienteDto) {
		Cliente cliente = convertirClienteToClienteDto(clienteDto);
		return clienteRepository.save(cliente);
	}
	
	private  Cliente convertirClienteToClienteDto(ClienteDto clienteDto) {
		Cliente cliente = new Cliente();
		cliente.setApellido1(clienteDto.getApellido1());
		cliente.setApellido2(clienteDto.getApellido2());
		cliente.setCiudad(clienteDto.getCiudad());
		cliente.setClaseVia(clienteDto.getClaseVia());
		cliente.setCodPostal(clienteDto.getCodPostal());
		cliente.setDniCl(clienteDto.getDniCl());
		cliente.setNombreCl(clienteDto.getNombreCl());
		cliente.setNombreVia(clienteDto.getNombreVia());
		cliente.setNumeroVia(clienteDto.getNumeroVia());
		cliente.setObservaciones(clienteDto.getObservaciones());
		cliente.setSeguro(clienteDto.getSeguro());
		cliente.setTelefono(clienteDto.getTelefono());
		return cliente;
	}
	
	
	@Override
	public Cliente guardarSeguro(@RequestBody ClienteDto clienteDto) {
		Cliente cliente = convertirClienteToClienteDto(clienteDto);
		List<Seguro> seguro = cliente.getSeguro();
		cliente.setSeguro(null);
		clienteRepository.save(cliente);
		for(Seguro seg : seguro ) 
			seg.setDniCl(cliente.getDniCl());  
		
		seguroRepository.saveAll(seguro);
		cliente.setSeguro(seguro);
		return cliente;
	}
	
	@Override
	public void eliminar(@PathVariable("dniCl") int dniCl) {
		Optional<Cliente> cliente = clienteRepository.findById(dniCl);
		if(cliente.isPresent()) {
			clienteRepository.delete(cliente.get());
		}
	}
	
	@Override
	public List<Cliente> buscarNombreYApellido1(@PathVariable String nombreCl, @PathVariable String apellido1){
		return clienteRepository.findByNombreClAndApellido1(nombreCl, apellido1);
	}
	
	@Override
	public List<Cliente> buscarApellido2OCiudad(@PathVariable String apellido2, @PathVariable String  ciudad){
		return clienteRepository.findByApellido2OrCiudad(apellido2, ciudad);
	}

	@Override
	public Cliente buscarNombreLike(@PathVariable String nombreIniciales) {
		return clienteRepository.findByNombreClStartingWith(nombreIniciales);
	}

	@Override
	public List<Map<String, Object>> buscarClienteSeguro() {
		return catalogoServicio.buscarClienteSeguro();
	}

	@Override
	public int updateClienteCodigoPostal(int codPostal, int dniCl) {
		return catalogoServicio.updateClienteCodigoPostal(codPostal, dniCl);
	}
	
}
