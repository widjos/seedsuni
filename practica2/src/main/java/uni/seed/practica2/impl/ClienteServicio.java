package uni.seed.practica2.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.library.dto.beans.ClienteDto;
import com.library.dto.beans.CompaniaDto;
import com.library.dto.beans.CompaniaSeguroDto;
import com.library.dto.beans.PeritoDto;
import com.library.dto.beans.SeguroDto;
import com.library.dto.beans.SiniestroDto;

import uni.seed.practica2.repository.ClienteRepository;
import uni.seed.practica2.repository.SeguroRepository;
import uni.seed.practica2.service.CatalogoServicio;
import uni.seed.practica2.ws.ClienteServicioInt;
import uni.seed.practica2.entity.Cliente;
import uni.seed.practica2.entity.Compania;
import uni.seed.practica2.entity.CompaniaSeguro;
import uni.seed.practica2.entity.Perito;
import uni.seed.practica2.entity.Seguro;
import uni.seed.practica2.entity.Siniestro;

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
		cliente.setSeguro(convertirListSeguroDtoToListSeguro( clienteDto.getSeguro()));
		cliente.setTelefono(clienteDto.getTelefono());
		return cliente;
	}
	
	private List<Seguro> convertirListSeguroDtoToListSeguro(List<SeguroDto> seguroDtoList){
		List<Seguro> conversion = new ArrayList<>();
		if(seguroDtoList != null) {
			for (SeguroDto seguro : seguroDtoList) {
				conversion.add(converitSeguroToSeguroDto(seguro));
			}
		}
		return conversion;
	}
	
	private Seguro converitSeguroToSeguroDto(SeguroDto seguroDto) {
		Seguro seguro = new Seguro();
		seguro.setCompaniaSeguro(convertirListCompaniSeguroToListCompaniaSeguro(seguroDto.getCompaniaSeguro()));
		seguro.setCondicionesParticulares(seguroDto.getCondicionesParticulares());
		seguro.setDniCl(seguroDto.getDniCl());
		seguro.setFechaInicio(seguroDto.getFechaInicio());
		seguro.setFechaVencimiento(seguroDto.getFechaVencimiento());
		seguro.setNumeroPoliza(seguroDto.getNumeroPoliza());
		seguro.setObservaciones(seguroDto.getObservaciones());
		seguro.setRamo(seguro.getRamo());
		seguro.setSiniestro(convertirListSiniestroDtoToListSiniestro(seguroDto.getSiniestro()));
		
		return seguro;
	}
	
	private CompaniaSeguro convertirCompaniaSeguroToDtoVersion(CompaniaSeguroDto companiaSeguroDto) {
		CompaniaSeguro companiaSeguro = new CompaniaSeguro();
		companiaSeguro.setCompania(convertirCompaniaToCompaniaDto(companiaSeguroDto.getCompania()));
		companiaSeguro.setId(companiaSeguroDto.getId());
		companiaSeguro.setSeguro(converitSeguroToSeguroDto(companiaSeguroDto.getSeguro()));
		return companiaSeguro;
	}
	
	private Compania convertirCompaniaToCompaniaDto(CompaniaDto companiaDto) {
		Compania compania = new  Compania();
		compania.setClaseVia(companiaDto.getClaseVia());
		compania.setCodPostal(companiaDto.getCodPostal());
		compania.setCompaniaSeguro(convertirListCompaniSeguroToListCompaniaSeguro(companiaDto.getCompaniaSeguro()));
		compania.setNombreCompania(companiaDto.getNombreCompania());
		compania.setNombreVia(companiaDto.getNombreVia());
		compania.setNotas(companiaDto.getNotas());
		compania.setNumeroVia(companiaDto.getNumeroVia());
		compania.setNotas(companiaDto.getNotas());
		compania.setTelefonoContratacion(companiaDto.getTelefonoContratacion());
		compania.setTelefonoSiniestros(companiaDto.getTelefonoSiniestros());
		
		return compania;
	}
	
	
	private List<CompaniaSeguro> convertirListCompaniSeguroToListCompaniaSeguro(List<CompaniaSeguroDto> companiaSeguroDtoList){
		List<CompaniaSeguro> conversion = new ArrayList<>();
		if(companiaSeguroDtoList != null) {
			for (CompaniaSeguroDto companiaSeguro : companiaSeguroDtoList) {
				conversion.add(convertirCompaniaSeguroToDtoVersion(companiaSeguro));
			}
		} 
			
		return conversion;
	}
	private List<Siniestro> convertirListSiniestroDtoToListSiniestro(List<SiniestroDto> siniestroDtoList){
		List<Siniestro> conversion = new ArrayList<>();
		if(siniestroDtoList != null) {
			for (SiniestroDto siniestro : siniestroDtoList) {
				conversion.add(convertirSiniestroToSiniestroDto(siniestro));
			}
		}

		return conversion;
	}
	
	private Siniestro convertirSiniestroToSiniestroDto(SiniestroDto siniestroDto) {
		
		Siniestro siniestro = new Siniestro();
		siniestro.setAceptado(siniestroDto.getAceptado());
		siniestro.setCausas(siniestroDto.getCausas());
		siniestro.setFechaSiniestro(siniestroDto.getFechaSiniestro());
		siniestro.setIdSiniestro(siniestroDto.getIdSiniestro());
		siniestro.setPerito(convertirPeritoDtoToPerito(siniestroDto.getPerito()));
		siniestro.setSeguro(converitSeguroToSeguroDto(siniestroDto.getSeguro()));
		siniestro.setIndenmizacion(siniestroDto.getIndenmizacion());
		return  siniestro;
	}
	
	private Perito convertirPeritoDtoToPerito(PeritoDto peritoDto) {
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
		perito.setSiniestro(convertirListSiniestroDtoToListSiniestro(peritoDto.getSiniestro()));
		perito.setTelefonoContacto(peritoDto.getTelefonoContacto());
		perito.setTelefonoOficina(peritoDto.getTelefonoOficina());
		return perito;
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
