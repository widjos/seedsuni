package uni.seed.practica2.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import uni.seed.practica2.dto.CompaniaSeguroDto;
import uni.seed.practica2.entity.Compania;
import uni.seed.practica2.entity.CompaniaSeguro;
import uni.seed.practica2.entity.Seguro;
import uni.seed.practica2.repository.CompaniaRepository;
import uni.seed.practica2.repository.CompaniaSeguroRepository;
import uni.seed.practica2.repository.SeguroRepository;
import uni.seed.practica2.ws.CompaniaSeguroServicioInt;

@Component
public class CompaniaSeguroServicio implements CompaniaSeguroServicioInt{
	
	@Autowired
	CompaniaSeguroRepository companiaSeguroRepository;
	
	@Autowired
	SeguroRepository seguroRepository;
	
	@Autowired
	CompaniaRepository companiaRepository;
	
	@Override
	public List<CompaniaSeguro>  buscar(){
		return companiaSeguroRepository.findAll();
	}
	
	@Override
	public CompaniaSeguro guardar(@RequestBody CompaniaSeguroDto companiaSeguroDto, @PathVariable String nombreCompania, @PathVariable int numeroPoliza) {
		CompaniaSeguro companiaSeguro = convertirCompaniaSeguroToDtoVersion(companiaSeguroDto);
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
	
	@Override
	public CompaniaSeguro guardarCompaniaYSeguro(@RequestBody CompaniaSeguroDto companiaSeguroDto) {
		CompaniaSeguro companiaSeguro = convertirCompaniaSeguroToDtoVersion(companiaSeguroDto);
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
	
	
	private CompaniaSeguro convertirCompaniaSeguroToDtoVersion(CompaniaSeguroDto companiaSeguroDto) {
		CompaniaSeguro companiaSeguro = new CompaniaSeguro();
		companiaSeguro.setCompania(companiaSeguroDto.getCompania());
		companiaSeguro.setId(companiaSeguroDto.getId());
		companiaSeguro.setSeguro(companiaSeguroDto.getSeguro());
		return companiaSeguro;
	}
	
	
	@Override
	public void eliminar(@PathVariable Integer id) {
		Optional<CompaniaSeguro> companiaSeguro = companiaSeguroRepository.findById(id);
		if(companiaSeguro.isPresent()) {
			companiaSeguroRepository.delete(companiaSeguro.get());
		}
	}
	
	@Override
	public List<CompaniaSeguro> buscarPorId(@PathVariable int id){
		return companiaSeguroRepository.findById(id);
	}

}
