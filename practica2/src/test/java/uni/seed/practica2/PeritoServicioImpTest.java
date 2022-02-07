package uni.seed.practica2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import uni.seed.practica2.dto.PeritoDto;
import uni.seed.practica2.entity.Perito;
import uni.seed.practica2.impl.PeritoServicio;

@SpringBootTest
class PeritoServicioImpTest {

	@Autowired
	PeritoServicio peritoServicio;
	
	@Test
	void buscar() {
		
		List<Perito> listaPerito =  peritoServicio.buscar();
		assertNotEquals(0, listaPerito.size(), "Se obtuvieron todos los peritos ");
		
	}
	
	
	@Test
	void guardar() {
		
		PeritoDto peritoDto = new PeritoDto();
		peritoDto.setDniPerito(85);
		peritoDto.setNombrePerito("eMANUELA");
		peritoDto.setApellidoPerito1("rAES");
		peritoDto.setApellidoPerito2("Lucas");
		peritoDto.setTelefonoContacto(585646);
		peritoDto.setTelefonoOficina(58562246);
		peritoDto.setClaseVia("asdasd");
		peritoDto.setNombreVia("asdeeeeee");
		peritoDto.setNumeroVia("555");
		peritoDto.setCodPostal(5555);
		peritoDto.setCiudad("asdsada");
			
		Perito temporalPerito = peritoServicio.guardar(peritoDto);
		
		assertNotNull(temporalPerito,"Se ccreo un nuevo perito");
		
		peritoServicio.eliminar(peritoDto.getDniPerito());
		
	}
	
	
	@Test
	void buscarCiudadYNumeroVia() {
		
		List<Perito> peritoList = peritoServicio.buscarCiudadYNumeroVia("carmen", "888");	
		assertEquals(0, peritoList.size(), "No se encontro lo que buscabamos");
	}
	
	
	
}
