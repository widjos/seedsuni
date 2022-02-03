package uni.seed.practica2.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Entity
@Table(name="COMPANIA")
@Data
public class Compania implements Serializable{

	private static final long serialVersionUID = 2852200404887945530L;
	
	@Id
	@Column(name="NOMBRE_COMPANIA")
	private String  nombreCompania;
	
	@Column(name="CLASE_VIA")
	private String claseVia;
	
	@Column(name="NOMBRE_VIA")
	private String nombreVia;
	
	@Column(name="NUMERO_VIA")
	private Integer numeroVia;
	
	@Column(name="COD_POSTAL")
	private Integer codPostal;
	
	@Column(name="TELEFONO_CONTRATACION")
	private Integer telefonoContratacion;
	
	@Column(name="TELEFONO_SINIESTROS")
	private Integer telefonoSiniestros;
	
	@Column(name="NOTAS")
	private String notas;
	
    @JsonIgnore
	@OneToMany(mappedBy = "compania")
	private List<CompaniaSeguro> companiaSeguro;



	
	
}
