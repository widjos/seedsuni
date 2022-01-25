package uni.seed.practica2.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
import uni.seed.practica2.service.FunctionService;
import uni.seed.practica2.ws.FunctionInt;

@Component
public class FunctionServiceImpl implements FunctionInt {

	@Autowired
	FunctionService functionService;

	@Override
	public int nuevoSeguro(SeguroDto seguro) {
		Seguro convertido = converitSeguroToSeguroDto(seguro);
		return functionService.nuevoSeguro(convertido);
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

	private List<Siniestro> convertirListSiniestroDtoToListSiniestro(List<SiniestroDto> siniestroDtoList) {
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
		siniestro.setPerito(convertirPeritoDtoToPerito(siniestroDto.getPerito()));
		siniestro.setSeguro(converitSeguroToSeguroDto(siniestroDto.getSeguro()));
		siniestro.setIndenmizacion(siniestroDto.getIndenmizacion());
		return siniestro;
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
	

}
