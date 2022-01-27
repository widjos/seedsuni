package uni.seed.practica2;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.library.dto.beans.CompaniaDto;

import uni.seed.practica2.entity.Compania;
import uni.seed.practica2.impl.CompaniaServicio;

@SpringBootTest
class CompaniaServicioImpTest {

	@Autowired
	CompaniaServicio companiaServicio;
	
	
	@Test
	void buscar() {
		
		List<Compania> companiaResult = companiaServicio.buscar();
		assertNotEquals(0,companiaResult.size(), "Se encontraron todas las companias de nuestra lista");
		
	}
	
	@Test
	void guardar() {
		
		CompaniaDto temporalCompania = new CompaniaDto();
		temporalCompania.setNombreCompania("compania29");
		temporalCompania.setClaseVia("test5");
		temporalCompania.setNombreVia("asdasd");
		temporalCompania.setNumeroVia(5);
		temporalCompania.setCodPostal(55555);
		temporalCompania.setTelefonoContratacion(58888896);
		temporalCompania.setTelefonoSiniestros(8885556);
		temporalCompania.setNotas("dddd");
		
		Compania resultCompania = companiaServicio.guardar(temporalCompania);
		
		
		assertNotNull(resultCompania, "La nueva compania fue creeada");
		
		companiaServicio.eliminar(temporalCompania.getNombreCompania());
			
		
	}
	
	@Test 
	void buscarPorId() {
		
		List<Compania> companiaList = companiaServicio.buscarPorId("compania2");
		assertEquals(0, companiaList.size(), "Se encontro la compania con ese Id");
	}

	@Test
	void buscarContieneNombre() {
		List<Compania> companiaList = companiaServicio.buscarContieneNombre("errrrr");
		assertEquals(0, companiaList.size(), "No existe ninguna compania con ese nombre");
	}
	
}
