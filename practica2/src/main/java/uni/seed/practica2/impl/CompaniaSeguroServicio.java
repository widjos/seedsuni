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
	

	
	
	private List<CompaniaSeguro> convertirListCompaniSeguroToListCompaniaSeguro(List<CompaniaSeguroDto> companiaSeguroDtoList){
		List<CompaniaSeguro> conversion = new ArrayList<>();
		for (CompaniaSeguroDto companiaSeguro : companiaSeguroDtoList) {
			conversion.add(convertirCompaniaSeguroToDtoVersion(companiaSeguro));
		}
		return conversion;
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
	
	private CompaniaSeguro convertirCompaniaSeguroToDtoVersion(CompaniaSeguroDto companiaSeguroDto) {
		CompaniaSeguro companiaSeguro = new CompaniaSeguro();
		companiaSeguro.setCompania(convertirCompaniaToCompaniaDto(companiaSeguroDto.getCompania()));
		companiaSeguro.setId(companiaSeguroDto.getId());
		companiaSeguro.setSeguro(converitSeguroToSeguroDto(companiaSeguroDto.getSeguro()));
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

	@Override
	public int eliminarCompaniaSeguro(@PathVariable Integer id) {
		return  catalogoServicio.eliminarCompaniaSeguro(id);
	}

}
