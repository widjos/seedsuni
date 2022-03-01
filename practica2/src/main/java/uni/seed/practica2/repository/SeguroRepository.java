package uni.seed.practica2.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uni.seed.practica2.entity.Seguro;

@Repository("seguroRepository")
public interface SeguroRepository  extends JpaRepository<Seguro, Serializable>{

	public List<Seguro> findByFechaInicioAfter(Date fechaInicio);
	
	public List<Seguro> findByFechaInicio(Date fechaInicio);
	
	public List<Seguro> findByNumeroPoliza(int numeroPoliza);
	

}
