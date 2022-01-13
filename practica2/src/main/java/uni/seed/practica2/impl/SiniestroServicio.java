package uni.seed.practica2.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import uni.seed.practica2.dto.SiniestroDto;
import uni.seed.practica2.entity.Perito;
import uni.seed.practica2.entity.Seguro;
import uni.seed.practica2.entity.Siniestro;
import uni.seed.practica2.repository.PeritoRepository;
import uni.seed.practica2.repository.SeguroRepository;
import uni.seed.practica2.repository.SiniestroRepository;
import uni.seed.practica2.ws.SiniestroServicioInt;

@Component
public class SiniestroServicio implements SiniestroServicioInt{

	@Autowired
	SiniestroRepository siniestroRepository;
	
	@Autowired
	SeguroRepository seguroRepository;
	
	@Autowired
	PeritoRepository peritoRepository;
	
	@Override
	public List<Siniestro> buscar(){
		return siniestroRepository.findAll();
	}
	
	@Override
	public Siniestro guardar(@RequestBody SiniestroDto  siniestroDto, @PathVariable int numeroPoliza , @PathVariable int dniPerito) {
		Siniestro siniestro = convertirSiniestroToSiniestroDto(siniestroDto);
		List<Perito> peritoList = peritoRepository.findAll();
		List<Seguro> seguroList = seguroRepository.findAll();
		
		for(Perito  per : peritoList) {
			if(per.getDniPerito() == dniPerito) {
				siniestro.setPerito(per);
			}
		}
		
		for(Seguro seg : seguroList) {
			if(seg.getNumeroPoliza() == numeroPoliza) {
				siniestro.setSeguro(seg);
			}
		}
		
		if(siniestro.getPerito() != null && siniestro.getSeguro() != null) {
			return siniestroRepository.save(siniestro);
		}else {
			return null;
		}
		
	}
	
	@Override
	public Siniestro guardarSeguroPerito(@RequestBody SiniestroDto siniestroDto) {
		Siniestro siniestro = convertirSiniestroToSiniestroDto(siniestroDto);
		Seguro seguro = siniestro.getSeguro();
		siniestro.setSeguro(null);
		seguroRepository.save(seguro);
		Perito perito = siniestro.getPerito();
		siniestro.setPerito(null);
		seguroRepository.save(seguro);
		siniestro.setSeguro(seguro);
		siniestro.setPerito(perito);
		return siniestroRepository.save(siniestro);
		
	}
	
	
	private Siniestro convertirSiniestroToSiniestroDto(SiniestroDto siniestroDto) {
	
		Siniestro siniestro = new Siniestro();
		siniestro.setAceptado(siniestroDto.getAceptado());
		siniestro.setCausas(siniestroDto.getCausas());
		siniestro.setFechaSiniestro(siniestroDto.getFechaSiniestro());
		siniestro.setIdSiniestro(siniestroDto.getIdSiniestro());
		siniestro.setPerito(siniestroDto.getPerito());
		siniestro.setSeguro(siniestroDto.getSeguro());
		siniestro.setIndenmizacion(siniestroDto.getIndenmizacion());
		return  siniestro;
	}
	
	@Override
	public void eliminar(@PathVariable int idSiniestro) {
		Optional<Siniestro> siniestro = siniestroRepository.findById(idSiniestro);
		if(siniestro.isPresent()) {
			siniestroRepository.delete(siniestro.get());
		}
	}
	
	@Override
	public List<Siniestro> buscarPorDniPerito(@PathVariable int dniPerito){
		return siniestroRepository.findByPeritoDniPerito(dniPerito);
	}
	
	@Override
	public List<Siniestro> buscarAceptados(@PathVariable char aceptado){
		return siniestroRepository.queryByAceptadoLike(aceptado);
	}
}
