package uni.seed.practica2.ws;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uni.seed.practica2.dto.PeritoDto;
import uni.seed.practica2.entity.Perito;
import uni.seed.practica2.entity.Siniestro;

@RestController
@RequestMapping("/perito")
@CrossOrigin
public interface PeritoServicioInt {
	

	
	@GetMapping(path="/buscar")
	public List<Perito> buscar();
	
	@PostMapping(path="/guardar")
	public Perito guardar(@RequestBody PeritoDto peritoDto);
	
	@DeleteMapping(path="/eliminar/{dniPerito}")
	public void eliminar(@PathVariable Integer dniPerito);
	
	@GetMapping(path="/buscar/{ciudad}/numerovia/{numeroVia}")
	public List<Perito> buscarCiudadYNumeroVia(@PathVariable String  ciudad, @PathVariable String numeroVia);
	
	@GetMapping(path="/buscar/{dniPerito}/siniestro")
	public List<Siniestro> buscarSiniestroPerito(@PathVariable int dniPerito);
	
	@PostMapping(path="/nuevo")
	public int  nuevoPerito(@RequestBody PeritoDto peritoDto);
	


}
