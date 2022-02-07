package uni.seed.practica2;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import uni.seed.practica2.dto.SeguroDto;
import uni.seed.practica2.entity.Seguro;
import uni.seed.practica2.impl.SeguroServicio;

@SpringBootTest
class SeguroServicioImpTest {

	@Autowired
	SeguroServicio seguroServicio;
	
	@Test
	void buscar(){
		
		List<Seguro> seguroList =  seguroServicio.buscar();
		assertNotEquals(0, seguroList.size(), "Se encontraron todos los seguros");
	}
	
	
	@Test 
	void guardar() {
		
		SeguroDto temporalSeguro = new SeguroDto();	
		temporalSeguro.setNumeroPoliza(98);
		temporalSeguro.setRamo("vida");
		temporalSeguro.setFechaInicio(java.sql.Date.valueOf("2001-02-02"));
		temporalSeguro.setFechaVencimiento(java.sql.Date.valueOf("2009-02-02"));
		temporalSeguro.setCondicionesParticulares("asdasd");
		temporalSeguro.setObservaciones("nada nada");
		temporalSeguro.setDniCl(2);
		
		Seguro result =  seguroServicio.guardar(temporalSeguro);
		assertNotNull(result, "Se guardo unnuevo seguro");
		
		seguroServicio.eliminar(temporalSeguro.getNumeroPoliza());
		
	}
	
}
