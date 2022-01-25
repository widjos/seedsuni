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
	
	@Override
	public List<Perito> buscar(){
		return peritoRepository.findAll();
	}
	
	@Override
	public Perito guardar(@RequestBody PeritoDto peritoDto){
		Perito perito = convertirPeritoToPeritoDto(peritoDto);
		return peritoRepository.save(perito);
	}
	
	private Perito convertirPeritoToPeritoDto(PeritoDto peritoDto) {
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
	
	private List<CompaniaSeguro> convertirListCompaniSeguroToListCompaniaSeguro(
			List<CompaniaSeguroDto> companiaSeguroDtoList) {
		List<CompaniaSeguro> conversion = new ArrayList<>();
		for (CompaniaSeguroDto companiaSeguro : companiaSeguroDtoList) {
			conversion.add(convertirCompaniaSeguroToDtoVersion(companiaSeguro));
		}
		return conversion;
	}
	
	private Siniestro convertirSiniestroToSiniestroDto(SiniestroDto siniestroDto) {
		
		Siniestro siniestro = new Siniestro();
		siniestro.setAceptado(siniestroDto.getAceptado());
		siniestro.setCausas(siniestroDto.getCausas());
		siniestro.setFechaSiniestro(siniestroDto.getFechaSiniestro());
		siniestro.setIdSiniestro(siniestroDto.getIdSiniestro());
		siniestro.setPerito(convertirPeritoToPeritoDto(siniestroDto.getPerito()));
		siniestro.setSeguro(converitSeguroToSeguroDto(siniestroDto.getSeguro()));
		siniestro.setIndenmizacion(siniestroDto.getIndenmizacion());
		return  siniestro;
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
	
	private CompaniaSeguro convertirCompaniaSeguroToDtoVersion(CompaniaSeguroDto companiaSeguroDto) {
		CompaniaSeguro companiaSeguro = new CompaniaSeguro();
		companiaSeguro.setCompania(convertirCompaniaToCompaniaDto(companiaSeguroDto.getCompania()));
		companiaSeguro.setId(companiaSeguroDto.getId());
		companiaSeguro.setSeguro(converitSeguroToSeguroDto(companiaSeguroDto.getSeguro()));
		return companiaSeguro;
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
