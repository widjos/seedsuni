package uni.seed.practica2.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import lombok.Data;

@Data
public class SeguroDto implements Serializable{

	private static final long serialVersionUID = 6095850943243650918L;

	private Integer numeroPoliza;
	private String ramo;
	private Date fechaInicio;
	private Date fechaVencimiento;
	private String condicionesParticulares;
	private String observaciones;
	private Integer dniCl;
	private List<CompaniaSeguroDto> companiaSeguro;
	private List<SiniestroDto> siniestro;
		

}
