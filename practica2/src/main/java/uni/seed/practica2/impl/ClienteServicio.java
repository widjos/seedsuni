package uni.seed.practica2.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.library.dto.beans.ClienteDto;


import uni.seed.practica2.repository.ClienteRepository;
import uni.seed.practica2.repository.SeguroRepository;
import uni.seed.practica2.service.CatalogoServicio;
import uni.seed.practica2.ws.ClienteServicioInt;
import uni.seed.practica2.common.ConversionDto;
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
	
	@Autowired
	ConversionDto conversionDto;
	
	@Override
	public List<Cliente> buscar(){
		return clienteRepository.findAll();
	}
	
	@Override
	public Cliente guardar(ClienteDto clienteDto) {
		Cliente cliente = conversionDto.convertirClienteToClienteDto(clienteDto);
		return clienteRepository.save(cliente);
	}
	


	@Override
	public Cliente guardarSeguro(ClienteDto clienteDto) {
		Cliente cliente = conversionDto.convertirClienteToClienteDto(clienteDto);
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
	public void eliminar( int dniCl) {
		Optional<Cliente> cliente = clienteRepository.findById(dniCl);
		if(cliente.isPresent()) {
			clienteRepository.delete(cliente.get());
		}
	}
	
	@Override
	public List<Cliente> buscarNombreYApellido1( String nombreCl, String apellido1){
		return clienteRepository.findByNombreClAndApellido1(nombreCl, apellido1);
	}
	
	@Override
	public List<Cliente> buscarApellido2OCiudad( String apellido2, String  ciudad){
		return clienteRepository.findByApellido2OrCiudad(apellido2, ciudad);
	}

	@Override
	public Cliente buscarNombreLike(String nombreIniciales) {
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
