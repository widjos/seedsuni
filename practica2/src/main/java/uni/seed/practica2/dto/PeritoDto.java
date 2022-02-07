package uni.seed.practica2.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class PeritoDto implements Serializable{


	private static final long serialVersionUID = -4385176580870250493L;

	private Integer dniPerito;
	private String nombrePerito;
	private String apellidoPerito1;
	private String apellidoPerito2;
	private Integer telefonoContacto;
	private Integer telefonoOficina;
	private String claseVia;
	private String nombreVia;
	private CompaniaDto compania;
	private Integer codPostal;
	private String ciudad;
	private String numeroVia;
	private List<SiniestroDto> siniestro;
	
	
	
}
