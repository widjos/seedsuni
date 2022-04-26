package uni.seed.practica2.entity;

import java.io.Serializable;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;



@Entity
@Table(name="CLIENTE")
@Data
public class Cliente  implements Serializable{
	private static final long serialVersionUID = 3493288337097925498L;
	
	
	@Id
	@GeneratedValue(generator = "CLIENTE_DNI", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "CLIENTE_DNI", sequenceName = "CLIENTE_DNI",allocationSize=1)
	@Column(name="DNI_CL")
	private Integer dniCl;
	
	@Column(name="NOMBRE_CL")
	private String nombreCl;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="APELLIDO_1")
	private String  apellido1;
	
	@Column(name="APELLIDO_2")
	private String apellido2;
	
	@Column(name="CLASE_VIA")
	private String claseVia;
	
	@Column(name="NOMBRE_VIA")
	private String nombreVia;
	
	@Column(name="NUMERO_VIA")
	private Integer numeroVia;
	
	@Column(name="COD_POSTAL")
	private Integer codPostal;
	
	@Column(name="CIUDAD")
	private String ciudad;
	
	@Column(name="TELEFONO")
	private Integer telefono;
	
	@Column(name="OBSERVACIONES")
	private String observaciones;
	
	@JsonIgnore
	@OneToMany(mappedBy = "dniCl")
	private List<Seguro> seguro;

	
	
}
