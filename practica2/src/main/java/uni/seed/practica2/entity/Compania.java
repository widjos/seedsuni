package uni.seed.practica2.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="COMPANIA")
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



	public List<CompaniaSeguro> getCompaniaSeguro() {
		return companiaSeguro;
	}

	public void setCompaniaSeguro(List<CompaniaSeguro> companiaSeguro) {
		this.companiaSeguro = companiaSeguro;
	}

	public String getNombreCompania() {
		return nombreCompania;
	}

	public void setNombreCompania(String nombreCompania) {
		this.nombreCompania = nombreCompania;
	}

	public String getClaseVia() {
		return claseVia;
	}

	public void setClaseVia(String claseVia) {
		this.claseVia = claseVia;
	}

	public String getNombreVia() {
		return nombreVia;
	}

	public void setNombreVia(String nombreVia) {
		this.nombreVia = nombreVia;
	}

	public Integer getNumeroVia() {
		return numeroVia;
	}

	public void setNumeroVia(Integer numeroVia) {
		this.numeroVia = numeroVia;
	}

	public Integer getCodPostal() {
		return codPostal;
	}

	public void setCodPostal(Integer codPostal) {
		this.codPostal = codPostal;
	}

	public Integer getTelefonoContratacion() {
		return telefonoContratacion;
	}

	public void setTelefonoContratacion(Integer telefonoContratacion) {
		this.telefonoContratacion = telefonoContratacion;
	}

	public Integer getTelefonoSiniestros() {
		return telefonoSiniestros;
	}

	public void setTelefonoSiniestros(Integer telefonoSiniestros) {
		this.telefonoSiniestros = telefonoSiniestros;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}
	
	
	
}
