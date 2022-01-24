package uni.seed.practica2.service;

import java.math.BigDecimal;
import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;


import uni.seed.practica2.entity.Seguro;

@Service
public class FunctionService {

	@Autowired
	NamedParameterJdbcTemplate sql;
	
	@Autowired
	JdbcTemplate  jdbcTemplate;

	
	public Integer nuevoSeguro(Seguro seguro) {
		
		SimpleJdbcCall simpleJdbcCall = new  SimpleJdbcCall(jdbcTemplate);
		simpleJdbcCall.withFunctionName("FC_NUEVA_POLIZA").withCatalogName("pkg_practica2").
		declareParameters(
				new SqlParameter("numeroPoliza", Types.NUMERIC),
				new SqlParameter("rama", Types.VARCHAR),
				new SqlParameter("fechaInicio", Types.DATE),
				new SqlParameter("fechaVencimiento", Types.DATE),
				new SqlParameter("condParticulares", Types.VARCHAR),
				new SqlParameter("observaciones", Types.VARCHAR),
				new SqlParameter("dniCl", Types.NUMERIC)
				);
		
		SqlParameterSource nameParameter = new  MapSqlParameterSource()
				.addValue("numeroPoliza", seguro.getNumeroPoliza())
				.addValue("rama", seguro.getRamo())
				.addValue("fechaInicio", seguro.getFechaInicio())
				.addValue("fechaVencimiento", seguro.getFechaVencimiento())
				.addValue("condParticulares", seguro.getCondicionesParticulares())
				.addValue("observaciones", seguro.getObservaciones())
				.addValue("dniCl", seguro.getDniCl());
		
		
		return Integer.parseInt((simpleJdbcCall.executeFunction(BigDecimal.class, nameParameter)).toString());
		
	}
	

	
}
