package uni.seed.practica2.ws;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.dto.beans.ProcedimientoClienteSeguroDto;

@RestController
@RequestMapping("/procedure")
@CrossOrigin
public interface ProcedimientoServicioInt {
	
	@GetMapping(path="/cliente/{dniCl}/cambiar/numero/{telefono}")
	public int cambiarNumeroCliente(@PathVariable Integer dniCl, @PathVariable Integer telefono);

	@GetMapping(path="/cliente/{dniCl}/seguro/{numeroPoliza}")
	public ProcedimientoClienteSeguroDto  buscarClienteSeguros(@PathVariable Integer dniCl, @PathVariable Integer numeroPoliza);

	@GetMapping(path="/calculo/{valor}")
	public double conversionTasa(@PathVariable Double valor);

}
