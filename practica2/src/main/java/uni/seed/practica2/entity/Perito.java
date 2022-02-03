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
@Table(name="PERITO")
@Data
public class Perito implements Serializable{

	private static final long serialVersionUID = 1237483489194372329L;

	@Id
	@Column(name="DNI_PERITO")
	private Integer dniPerito;
	
	@Column(name="NOMBRE_PERITO")
	private String nombrePerito;
	
	@Column(name="APELLIDO_PERITO1")
	private String apellidoPerito1;
	
	@Column(name="APELLIDO_PERITO2")
	private String apellidoPerito2;
	
	@Column(name="TELEFONO_CONTACTO")
	private Integer telefonoContacto;
	
	@Column(name="TELEFONO_OFICINA")
	private Integer telefonoOficina;
	
	@Column(name="CLASE_VIA")
	private String claseVia;
	
	@Column(name="NOMBRE_VIA")
	private String nombreVia;
	
	@Column(name="NUMERO_VIA")
	private String numeroVia;
	
	@Column(name="COD_POSTAL")
	private Integer codPostal;
	
	@Column(name="CIUDAD")
	private String ciudad;
	
	@JsonIgnore
	@OneToMany(mappedBy = "perito")
	private List<Siniestro> siniestro;
	

}
