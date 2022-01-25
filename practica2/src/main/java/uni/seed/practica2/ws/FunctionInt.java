package uni.seed.practica2.ws;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.dto.beans.SeguroDto;

@RestController
@RequestMapping("/funcion")
@CrossOrigin
public interface FunctionInt {

	@PostMapping(path="/nuevo/seguro")
	public int nuevoSeguro(@RequestBody SeguroDto seguro);
}
