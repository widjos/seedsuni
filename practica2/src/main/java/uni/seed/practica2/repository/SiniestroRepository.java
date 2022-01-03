package uni.seed.practica2.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uni.seed.practica2.entity.Siniestro;

@Repository("siniestroRepository")
public interface SiniestroRepository extends JpaRepository<Siniestro, Serializable> {

	
}
