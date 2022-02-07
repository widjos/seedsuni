package uni.seed.practica2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import uni.seed.practica2.dto.ClienteDto;
import uni.seed.practica2.entity.Cliente;
import uni.seed.practica2.impl.ClienteServicio;

@SpringBootTest
class ClienteServicioImpTest {
	
	@Autowired 
	ClienteServicio clienteServicio;
	
	private static final Log LOG = LogFactory.getLog(ClienteServicioImpTest.class);
		
	@Test
	void buscar() {
		
		List<Cliente>  listaClientes = clienteServicio.buscar();		
		assertNotNull(listaClientes, "Se encontraron todos los clientes de la base de datos");
		LOG.info("Se encontraron todos los clientes");
	}
	
	
	@Test
	void guardar(){
		
		ClienteDto nuevoClienteDto = new ClienteDto();
		nuevoClienteDto.setNombreCl("Jose");
		nuevoClienteDto.setApellido1("loes");
		nuevoClienteDto.setApellido2("sILVES");
		nuevoClienteDto.setClaseVia("vida");
		nuevoClienteDto.setNombreVia("assda");
		nuevoClienteDto.setNumeroVia(54);
		nuevoClienteDto.setCodPostal(4566);
		nuevoClienteDto.setCiudad("san amrcos");
		nuevoClienteDto.setTelefono(47885);
		nuevoClienteDto.setObservaciones("ASDASDA");
	
		Cliente clienteCreado = clienteServicio.guardar(nuevoClienteDto);
		
		assertNotNull(clienteCreado, "Se creo un cliente");
		clienteServicio.eliminar(clienteCreado.getDniCl()); 
		
		LOG.info("SE creo y elimino un nuevo cliente en la base de datos.");
		
		
	}
	
	
	@Test
	void buscarApellido2OCiudad() {
		
		List<Cliente> listaCliente = clienteServicio.buscarApellido2OCiudad("wee", "ciudad");
		int tamano = listaCliente.size();
		
		assertEquals(0,tamano,"No existe el cliente que buscamos por eso ");
		
	}
	
	
	@Test 
	void buscarNombreYApellido1(){
		
		List<Cliente> listaCliente = clienteServicio.buscarNombreYApellido1("tony", "serrano");
		assertEquals(0, listaCliente.size(), "No existe cliente con el nombre que busca ");
	}

	
	@Test
	void buscarNombreLike() {
		
		Cliente clienteNuevo = clienteServicio.buscarNombreLike("xirer");
		assertNull(clienteNuevo,  "No se encontro ningun cliente con esas iniciales");
	}
	
	@Test 
	void buscarClienteSeguro() {
		List<Map<String, Object>> temporal = clienteServicio.buscarClienteSeguro();
		
		assertNotNull(temporal, "Se encontraron todos los clientes con sus seguros");
	}
	
	
	@Test
	void updateClienteCodigoPostal() {
		int result = clienteServicio.updateClienteCodigoPostal(1,88888);
		
		assertEquals(0,result,"Se cambio el codigopostal del cliente");
	}
}
