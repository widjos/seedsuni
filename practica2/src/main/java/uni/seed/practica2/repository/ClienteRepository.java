package uni.seed.practica2.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uni.seed.practica2.entity.Cliente;

@Repository("clienteRepository")
public interface ClienteRepository  extends JpaRepository<Cliente, Serializable>{

	
}
