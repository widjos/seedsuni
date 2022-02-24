package uni.seed.practica2.ws;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uni.seed.practica2.dto.SeguroDto;

@RestController
@RequestMapping("/funcion")
@CrossOrigin
public interface FunctionInt {

	@PostMapping(path="/nuevo/seguro")
	public ResponseEntity<Integer> nuevoSeguro(@RequestBody SeguroDto seguro);
}
