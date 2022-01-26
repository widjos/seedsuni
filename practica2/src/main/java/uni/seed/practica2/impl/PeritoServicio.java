package uni.seed.practica2.impl;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


import com.library.dto.beans.PeritoDto;

import uni.seed.practica2.common.ConversionDto;
import uni.seed.practica2.entity.Perito;
import uni.seed.practica2.entity.Siniestro;
import uni.seed.practica2.repository.PeritoRepository;
import uni.seed.practica2.repository.SiniestroRepository;
import uni.seed.practica2.service.CatalogoServicio;
import uni.seed.practica2.ws.PeritoServicioInt;

@Component
public class PeritoServicio implements PeritoServicioInt{

	@Autowired
	PeritoRepository peritoRepository;
	
	@Autowired
	SiniestroRepository siniestroRepository;
	
	@Autowired
	CatalogoServicio catalogoServicio;
	
	@Autowired
	ConversionDto conversionDto;
	
	@Override
	public List<Perito> buscar(){
		return peritoRepository.findAll();
	}
	
	@Override
	public Perito guardar(@RequestBody PeritoDto peritoDto){
		Perito perito =  conversionDto.convertirPeritoDtoToPerito(peritoDto);
		return peritoRepository.save(perito);
	}
	
	
	@Override
	public void eliminar(@PathVariable Integer dniPerito){
		Optional<Perito> perito = peritoRepository.findById(dniPerito);
		if(perito.isPresent()) {
			peritoRepository.delete(perito.get());
		}
	}
	
	@Override
	public List<Perito> buscarCiudadYNumeroVia(@PathVariable String  ciudad, @PathVariable String numeroVia){
		return peritoRepository.findByCiudadAndNumeroVia(ciudad, numeroVia);
	}
	
	@Override
	public List<Siniestro> buscarSiniestroPerito(@PathVariable int dniPerito){
		List<Siniestro> siniestro = siniestroRepository.findAll();
		for(Siniestro sin : siniestro) {
			if(sin.getPerito().getDniPerito() != dniPerito) {
				siniestro.remove(sin);
			}
		}
		return siniestro;
	}

	@Override
	public int nuevoPerito(PeritoDto peritoDto) {
		return 1;
		
	}


}
