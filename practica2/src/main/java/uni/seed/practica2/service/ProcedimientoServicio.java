package uni.seed.practica2.service;


import java.sql.Types;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import uni.seed.practica2.dto.ProcedimientoClienteSeguroDto;

@Service
public class ProcedimientoServicio {
	
	@Autowired
	NamedParameterJdbcTemplate sql;
	
	@Autowired
	JdbcTemplate  jdbcTemplate;

	private final static String VALOR = "valor";

	public int cambiarNumeroCliente(Integer dniCl, Integer telefono) {
		String query = "begin "
				+ "PR_CLIENTE_CAMBIAR_NUMERO(:dniCl, :telefono); "
				+ "end;";
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
				.addValue("dniCl", dniCl)
				.addValue("telefono", telefono);
		
		return sql.update(query, sqlParameterSource);
	}


	public ProcedimientoClienteSeguroDto buscarClienteSeguros(Integer dniCl, Integer numeroPoliza) {
		SimpleJdbcCall simpleJdbcCall = new  SimpleJdbcCall(jdbcTemplate);
		simpleJdbcCall.withProcedureName("PR_CLIENTE_SEGUROS")
			.withoutProcedureColumnMetaDataAccess().declareParameters(
					new SqlParameter("inIdCliente", Types.NUMERIC),
					new SqlOutParameter("out_nombreCliente", Types.VARCHAR),
					new SqlParameter("inCodigoSeguro", Types.NUMERIC),
					new SqlOutParameter("out_fechaInicio", Types.DATE)
					);
		
		SqlParameterSource nameParameter = new  MapSqlParameterSource()
				.addValue("inIdCliente", dniCl)
				.addValue("inCodigoSeguro", numeroPoliza);
		
		Map<String, Object>  out =  simpleJdbcCall.execute(nameParameter);
		
		ProcedimientoClienteSeguroDto dto = new ProcedimientoClienteSeguroDto();
		
		dto.setOutfechaInicio( (Date) out.get("out_fechaInicio"));
		dto.setOutNombreCliente(out.get("out_nombreCliente").toString());
		return dto;
	}


	public double conversionTasa(Double valor) {
		SimpleJdbcCall simpleJdbcCall = new  SimpleJdbcCall(jdbcTemplate);
		simpleJdbcCall.withProcedureName("PR_TASADECAMBIO")
			.withoutProcedureColumnMetaDataAccess().declareParameters(
					new SqlInOutParameter(VALOR, Types.NUMERIC)
					);
	
		SqlParameterSource nameParameter = new  MapSqlParameterSource()
				.addValue(VALOR, valor);
		
		Map<String, Object>  out =  simpleJdbcCall.execute(nameParameter);
		
		return Double.parseDouble(out.get(VALOR).toString());
	}


}
