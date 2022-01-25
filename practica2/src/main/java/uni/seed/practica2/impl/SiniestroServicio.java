package uni.seed.practica2.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.library.dto.beans.CompaniaDto;
import com.library.dto.beans.CompaniaSeguroDto;
import com.library.dto.beans.PeritoDto;
import com.library.dto.beans.SeguroDto;
import com.library.dto.beans.SiniestroDto;

import uni.seed.practica2.entity.Compania;
import uni.seed.practica2.entity.CompaniaSeguro;
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
	
	
	private List<CompaniaSeguro> convertirListCompaniSeguroToListCompaniaSeguro(List<CompaniaSeguroDto> companiaSeguroDtoList){
		List<CompaniaSeguro> conversion = new ArrayList<>();
		for (CompaniaSeguroDto companiaSeguro : companiaSeguroDtoList) {
			conversion.add(convertirCompaniaSeguroToDtoVersion(companiaSeguro));
		}
		return conversion;
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
	
	private List<Siniestro> convertirListSiniestroDtoToListSiniestro(List<SiniestroDto> siniestroDtoList){
		List<Siniestro> conversion = new ArrayList<>();
		for (SiniestroDto siniestro : siniestroDtoList) {
			conversion.add(convertirSiniestroToSiniestroDto(siniestro));
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
