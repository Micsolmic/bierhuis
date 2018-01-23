package be.vdab.repositories;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class RepositoriesConfig {

	@Bean NamedParameterJdbcTemplate namedJdbcTemplate(DataSource dataSource) {  
		return new NamedParameterJdbcTemplate(dataSource); 
		} 
	
}
