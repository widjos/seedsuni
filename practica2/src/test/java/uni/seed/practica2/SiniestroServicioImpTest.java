package uni.seed.practica2;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import uni.seed.practica2.entity.Siniestro;
import uni.seed.practica2.impl.SiniestroServicio;

@SpringBootTest
class SiniestroServicioImpTest {

	@Autowired
	SiniestroServicio siniestroServicio;
	
	@Test
	void buscar() {
		
		List<Siniestro> siniestroList =  siniestroServicio.buscar();
		
		assertNotEquals(0,siniestroList.size(), "Se encontraron los siniestros");
	}
}
