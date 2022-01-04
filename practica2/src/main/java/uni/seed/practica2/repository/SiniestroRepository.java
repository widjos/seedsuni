package uni.seed.practica2.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uni.seed.practica2.entity.Siniestro;

@Repository("siniestroRepository")
public interface SiniestroRepository extends JpaRepository<Siniestro, Serializable> {

	public List<Siniestro>  findByPeritoDniPerito(int dniPerito);
	
	public List<Siniestro> queryByAceptadoLike(char aceptado);

}
