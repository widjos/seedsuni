package uni.seed.practica2.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import uni.seed.practica2.entity.Cliente;

@Repository("clienteRepository")
public interface ClienteRepository  extends JpaRepository<Cliente, Serializable>{

	public List<Cliente> findByNombreClAndApellido1(String nombreCl, String apellido1);
	
	public List<Cliente> findByApellido2OrCiudad(String apellido2, String ciudad);
	
	public Cliente findByNombreClStartingWith(String nombreIniciales);
	
	public List<Cliente> findByApellido1OrApellido2(String apellido1, String apellido2);
}
