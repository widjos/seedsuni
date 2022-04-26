package uni.seed.practica2.ws;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uni.seed.practica2.dto.SiniestroDto;
import uni.seed.practica2.entity.Siniestro;

@RestController
@RequestMapping("/siniestro")
@CrossOrigin
public interface SiniestroServicioInt {

	@GetMapping(path="/buscar")
	public List<Siniestro> buscar();
	
	@PostMapping(path="/guardar/seguro/{numeroPoliza}/perito/{dniPerito}")
	public ResponseEntity<Siniestro> guardar(@RequestBody SiniestroDto  siniestroDto, @PathVariable int numeroPoliza , @PathVariable int dniPerito);
	
	@PostMapping(path="/guardar/seguro/perito")
	public ResponseEntity<Siniestro> guardarSeguroPerito(@RequestBody SiniestroDto siniestroDto);
	
	@DeleteMapping(path="/eliminar")
	public void eliminar(@RequestParam int idSiniestro);
	
	@GetMapping(path="/buscar/perito/{dniPerito}")
	public List<Siniestro> buscarPorDniPerito(@PathVariable int dniPerito);
	
	@GetMapping(path="/buscar/aceptado/{aceptado}")
	public List<Siniestro> buscarAceptados(@PathVariable char aceptado);
	
}
