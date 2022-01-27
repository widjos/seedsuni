package uni.seed.practica2.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.library.dto.beans.CompaniaDto;

import uni.seed.practica2.common.ConversionDto;
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
	
	@Autowired
	ConversionDto conversionDto;
	
	@Override
	public List<Compania> buscar(){
		return companiaRepository.findAll();
	}
	
	@Override
	public Compania guardar(CompaniaDto companiaDto) {
		Compania compania = conversionDto.convertirCompaniaToCompaniaDto(companiaDto);
		return companiaRepository.save(compania);
	}

	

	@Override
	public void eliminar(String nombreCompania) {
		Optional<Compania> compania = companiaRepository.findById(nombreCompania);
		if(compania.isPresent()) {
			companiaRepository.delete(compania.get());
		}
	}
	
	@Override
	public List<Compania> buscarPorId(String nombreVia){
		return companiaRepository.findByNombreViaOrderByNombreCompaniaDesc(nombreVia);
	}
	
	
	@Override
	public List<Compania> buscarContieneNombre(String referencia){
		return companiaRepository.queryByNombreCompaniaContaining(referencia);
	}
}
