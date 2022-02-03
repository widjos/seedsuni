package uni.seed.practica2.common;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.library.dto.beans.ClienteDto;
import com.library.dto.beans.CompaniaDto;
import com.library.dto.beans.CompaniaSeguroDto;
import com.library.dto.beans.PeritoDto;
import com.library.dto.beans.SeguroDto;
import com.library.dto.beans.SiniestroDto;

import uni.seed.practica2.entity.Cliente;
import uni.seed.practica2.entity.Compania;
import uni.seed.practica2.entity.CompaniaSeguro;
import uni.seed.practica2.entity.Perito;
import uni.seed.practica2.entity.Seguro;
import uni.seed.practica2.entity.Siniestro;

@Component
public class ConversionDto {
	
	
	private static final ModelMapper MP= new ModelMapper();

	public  Cliente convertirClienteToClienteDto(ClienteDto clienteDto) {
		return MP.map(clienteDto, Cliente.class);
	}
	
	public List<Seguro> convertirListSeguroDtoToListSeguro(List<SeguroDto> seguroDtoList){
		List<Seguro> conversion = new ArrayList<>();
		if(seguroDtoList != null) {
			for (SeguroDto seguro : seguroDtoList) {
				conversion.add(converitSeguroToSeguroDto(seguro));
			}
		}
		return conversion;
	}
	
	public Seguro converitSeguroToSeguroDto(SeguroDto seguroDto) {
		return MP.map(seguroDto, Seguro.class);

	}
	
	public CompaniaSeguro convertirCompaniaSeguroToDtoVersion(CompaniaSeguroDto companiaSeguroDto) {
		return MP.map(companiaSeguroDto, CompaniaSeguro.class);
	}
	
	public Compania convertirCompaniaToCompaniaDto(CompaniaDto companiaDto) {
		return MP.map(companiaDto,Compania.class);
	}
	
	
	public List<CompaniaSeguro> convertirListCompaniSeguroToListCompaniaSeguro(List<CompaniaSeguroDto> companiaSeguroDtoList){
		List<CompaniaSeguro> conversion = new ArrayList<>();
		if(companiaSeguroDtoList != null) {
			for (CompaniaSeguroDto companiaSeguro : companiaSeguroDtoList) {
				conversion.add(convertirCompaniaSeguroToDtoVersion(companiaSeguro));
			}
		} 			
		return conversion;
	}
	
	public List<Siniestro> convertirListSiniestroDtoToListSiniestro(List<SiniestroDto> siniestroDtoList){
		List<Siniestro> conversion = new ArrayList<>();
		if(siniestroDtoList != null) {
			for (SiniestroDto siniestro : siniestroDtoList) {
				conversion.add(convertirSiniestroToSiniestroDto(siniestro));
			}
		}

		return conversion;
	}
	
	public Siniestro convertirSiniestroToSiniestroDto(SiniestroDto siniestroDto) {
		
		return MP.map(siniestroDto, Siniestro.class);
	}
	
	public Perito convertirPeritoDtoToPerito(PeritoDto peritoDto) {
		return MP.map(peritoDto, Perito.class);
	}
	

	
}
