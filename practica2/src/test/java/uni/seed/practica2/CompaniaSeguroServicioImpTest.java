package uni.seed.practica2;


import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import uni.seed.practica2.dto.CompaniaDto;
import uni.seed.practica2.dto.CompaniaSeguroDto;
import uni.seed.practica2.dto.SeguroDto;
import uni.seed.practica2.entity.CompaniaSeguro;
import uni.seed.practica2.impl.CompaniaSeguroServicio;
import uni.seed.practica2.impl.CompaniaServicio;
import uni.seed.practica2.impl.SeguroServicio;

@SpringBootTest
class CompaniaSeguroServicioImpTest {

	@Autowired
	CompaniaSeguroServicio companiaSeguroServicio;
	
	@Autowired
	CompaniaServicio companiaServicio;
	
	@Autowired
	SeguroServicio seguroServicio;
	
	private static final Log LOG = LogFactory.getLog(CompaniaSeguroServicioImpTest.class);
	
	@Test
	void guardarCompaniaYSeguro() {
		
		CompaniaDto temporalCompania = new CompaniaDto();
		temporalCompania.setNombreCompania("compania28");
		temporalCompania.setClaseVia("test5");
		temporalCompania.setNombreVia("asdasd");
		temporalCompania.setNumeroVia(5);
		temporalCompania.setCodPostal(55555);
		temporalCompania.setTelefonoContratacion(58888896);
		temporalCompania.setTelefonoSiniestros(8885556);
		temporalCompania.setNotas("dddd");
	
	
		SeguroDto temporalSeguro = new SeguroDto();	
		temporalSeguro.setNumeroPoliza(55);
		temporalSeguro.setRamo("vida");
		temporalSeguro.setFechaInicio(java.sql.Date.valueOf("2001-02-02"));
		temporalSeguro.setFechaVencimiento(java.sql.Date.valueOf("2009-02-02"));
		temporalSeguro.setCondicionesParticulares("asdasd");
		temporalSeguro.setObservaciones("nada nada");
		temporalSeguro.setDniCl(2);
		
		
		CompaniaSeguroDto dtoCompania = new CompaniaSeguroDto();
		dtoCompania.setId(8);
		dtoCompania.setCompania(temporalCompania);
		dtoCompania.setSeguro(temporalSeguro);
		
		ResponseEntity<CompaniaSeguro> temporalCompaniaSeguro = companiaSeguroServicio.guardarCompaniaYSeguro(dtoCompania);
		

		LOG.info("SE crearon con exito su nueva entradad ahora toca eliminar todo de nuevo");
		
		companiaSeguroServicio.eliminar(dtoCompania.getId());
		LOG.info("SE elimino su registro ");
		companiaServicio.eliminar(temporalCompania.getNombreCompania());
		LOG.info("Se elimino la compania que se creo previamente ");
		seguroServicio.eliminar(temporalSeguro.getNumeroPoliza());
		LOG.info("Se  elimino el seguro");
		
		
		assertNotNull(temporalCompaniaSeguro, "Se creo con exito  su nueva compania y seguro");
		LOG.info("Hola");
		
		
	}
}
