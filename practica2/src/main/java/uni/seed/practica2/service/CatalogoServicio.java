package uni.seed.practica2.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import uni.seed.practica2.entity.Perito;

@Service
public class CatalogoServicio {
		@Autowired
		NamedParameterJdbcTemplate sql;
	
		public List<Map<String, Object>> buscarClienteSeguro(){
			String query = "SELECT C.NOMBRE_CL, C.COD_POSTAL, S.NUMERO_POLIZA , S.FECHA_INICIO "
					+ "FROM  CLIENTE C , SEGURO S "
					+ "WHERE C.DNI_CL  = S.DNI_CL";
			SqlParameterSource sqlParameterSource = new MapSqlParameterSource();
			return sql.queryForList(query, sqlParameterSource);
		}
		
		
		public int  nuevoPerito(Perito nuevoPerito) {			
			String query = "insert into perito values("
					+ ":dniPerito , :nombrePerito , :apellidoPerito1,"
					+ ":apellidoPerito2, :telefonoContacto , :telefonoOficina,"
					+ ":claseVia , :nombreVia , :numeroVia, :codPostal , :ciudad)";
		
			SqlParameterSource  sqlParameterSource = new MapSqlParameterSource()
					.addValue("dniPerito", nuevoPerito.getDniPerito())
					.addValue("nombrePerito", nuevoPerito.getNombrePerito())
					.addValue("apellidoPerito1", nuevoPerito.getApellidoPerito1())
					.addValue("apellidoPerito2", nuevoPerito.getApellidoPerito2())
					.addValue("telefonoContacto",nuevoPerito.getTelefonoContacto())
					.addValue("telefonoOficina", nuevoPerito.getTelefonoOficina())
					.addValue("claseVia", nuevoPerito.getClaseVia())
					.addValue("nombreVia", nuevoPerito.getNombreVia())
					.addValue("numeroVia", nuevoPerito.getNumeroVia())
					.addValue("codPostal", nuevoPerito.getCodPostal())
					.addValue("ciudad", nuevoPerito.getCiudad());
			return sql.update(query, sqlParameterSource);
		}
		
		public int eliminarCompaniaSeguro(int id) {
			String query  = "DELETE from COMPANIA_SEGURO WHERE id= :id";
			SqlParameterSource sqlParamerSource =  new MapSqlParameterSource()
					.addValue("id",id);
			
			return sql.update(query, sqlParamerSource);
		}
	
	
		public int updateClienteCodigoPostal( int dniCl, int codPostal) {
			String query =  "UPDATE cliente SET  COD_POSTAL = :codPostal WHERE DNI_CL = :dniCl";
			SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
					.addValue("codPostal", codPostal)
					.addValue("dniCl", dniCl);
			return sql.update(query, sqlParameterSource);
		}
		
}
