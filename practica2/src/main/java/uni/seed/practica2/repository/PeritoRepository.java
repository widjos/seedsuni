package uni.seed.practica2.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import uni.seed.practica2.entity.Perito;

@Repository("peritoRepository")
public interface PeritoRepository extends JpaRepository<Perito,Serializable> {

	public List<Perito> findByCiudadAndNumeroVia(String ciudad, String numeroVia);
	
	@Query(nativeQuery=true, 
			value="SELECT * FROM PERITO ORDER BY DNI_PERITO ASC",
			countQuery= "SELECT COUNT(1) FROM PERITO")
	public Page<Perito> buscarTodosEnOrden(Pageable paginador);
}
