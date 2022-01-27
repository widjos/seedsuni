package uni.seed.practica2.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.library.dto.beans.CompaniaSeguroDto;

import uni.seed.practica2.common.ConversionDto;
import uni.seed.practica2.entity.Compania;
import uni.seed.practica2.entity.CompaniaSeguro;
import uni.seed.practica2.entity.Seguro;
import uni.seed.practica2.repository.CompaniaRepository;
import uni.seed.practica2.repository.CompaniaSeguroRepository;
import uni.seed.practica2.repository.SeguroRepository;
import uni.seed.practica2.service.CatalogoServicio;
import uni.seed.practica2.ws.CompaniaSeguroServicioInt;

@Component
public class CompaniaSeguroServicio implements CompaniaSeguroServicioInt{
	
	@Autowired
	CompaniaSeguroRepository companiaSeguroRepository;
	
	@Autowired
	SeguroRepository seguroRepository;
	
	@Autowired
	CompaniaRepository companiaRepository;
	
	@Autowired
	CatalogoServicio catalogoServicio;
	
	@Autowired
	ConversionDto conversionDto;
	
	@Override
	public List<CompaniaSeguro>  buscar(){
		return companiaSeguroRepository.findAll();
	}
	
	@Override
	public CompaniaSeguro guardar(CompaniaSeguroDto companiaSeguroDto, String nombreCompania,int numeroPoliza) {
		CompaniaSeguro companiaSeguro = conversionDto.convertirCompaniaSeguroToDtoVersion(companiaSeguroDto);
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
	public CompaniaSeguro guardarCompaniaYSeguro(CompaniaSeguroDto companiaSeguroDto) {
		CompaniaSeguro companiaSeguro = conversionDto.convertirCompaniaSeguroToDtoVersion(companiaSeguroDto);
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
	

	
	@Override
	public void eliminar(Integer id) {
		Optional<CompaniaSeguro> companiaSeguro = companiaSeguroRepository.findById(id);
		if(companiaSeguro.isPresent()) {
			companiaSeguroRepository.delete(companiaSeguro.get());
		}
	}
	
	@Override
	public List<CompaniaSeguro> buscarPorId(int id){
		return companiaSeguroRepository.findById(id);
	}

	@Override
	public int eliminarCompaniaSeguro(Integer id) {
		return  catalogoServicio.eliminarCompaniaSeguro(id);
	}

}
