package uni.seed.practica2.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import uni.seed.practica2.dto.CompaniaDto;
import uni.seed.practica2.entity.Compania;
import uni.seed.practica2.repository.CompaniaRepository;
import uni.seed.practica2.repository.SeguroRepository;
import uni.seed.practica2.ws.CompaniaServicioInt;

@Component
public class CompaniaServicio implements CompaniaServicioInt {

	@Autowired
	CompaniaRepository companiaRepository;
	
	@Autowired
	SeguroRepository seguroRepository;
	
	@Override
	public List<Compania> buscar(){
		return companiaRepository.findAll();
	}
	
	@Override
	public Compania guardar(@RequestBody CompaniaDto companiaDto) {
		Compania compania = convertirCompaniaToCompaniaDto(companiaDto);
		return companiaRepository.save(compania);
	}

	
	private Compania convertirCompaniaToCompaniaDto(CompaniaDto companiaDto) {
		Compania compania = new  Compania();
		compania.setClaseVia(companiaDto.getClaseVia());
		compania.setCodPostal(companiaDto.getCodPostal());
		compania.setCompaniaSeguro(companiaDto.getCompaniaSeguro());
		compania.setNombreCompania(companiaDto.getNombreCompania());
		compania.setNombreVia(companiaDto.getNombreVia());
		compania.setNotas(companiaDto.getNotas());
		compania.setNumeroVia(companiaDto.getNumeroVia());
		compania.setNotas(companiaDto.getNotas());
		compania.setTelefonoContratacion(companiaDto.getTelefonoContratacion());
		compania.setTelefonoSiniestros(companiaDto.getTelefonoSiniestros());
		
		return compania;
	}
	
	
	@Override
	public void eliminar(@PathVariable String nombreCompania) {
		Optional<Compania> compania = companiaRepository.findById(nombreCompania);
		if(compania.isPresent()) {
			companiaRepository.delete(compania.get());
		}
	}
	
	@Override
	public List<Compania> buscarPorId(@PathVariable String nombreVia){
		return companiaRepository.findByNombreViaOrderByNombreCompaniaDesc(nombreVia);
	}
	
	
	@Override
	public List<Compania> buscarContieneNombre(@PathVariable String referencia){
		return companiaRepository.queryByNombreCompaniaContaining(referencia);
	}
}
