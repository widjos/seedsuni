package uni.seed.practica2;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.library.dto.beans.SeguroDto;

import uni.seed.practica2.impl.FunctionServiceImpl;
import uni.seed.practica2.impl.SeguroServicio;

@SpringBootTest
class FunctionServiceImpTest {
	
	@Autowired
	FunctionServiceImpl functionServiceImpl;
	
	@Autowired
	SeguroServicio seguroService;
	
	@Test
	void nuevoSeguro() {
		
		SeguroDto temporalSeguro = new SeguroDto();	
		temporalSeguro.setNumeroPoliza(899);
		temporalSeguro.setRamo("vida");
		temporalSeguro.setFechaInicio(java.sql.Date.valueOf("2001-02-02"));
		temporalSeguro.setFechaVencimiento(java.sql.Date.valueOf("2008-02-02"));
		temporalSeguro.setCondicionesParticulares("asdasd");
		temporalSeguro.setObservaciones("nada nada");
		temporalSeguro.setDniCl(2);
		
		assertNotEquals(0, functionServiceImpl.nuevoSeguro(temporalSeguro), "Se creo el nuevo seguro");
		
		seguroService.eliminar(temporalSeguro.getNumeroPoliza());
	
		
	}

}
