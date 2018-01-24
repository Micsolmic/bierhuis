package be.vdab.repositories;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import be.vdab.entities.Brouwer;
import be.vdab.valueobjects.Adres;

@Repository
public class BrouwersRepository {

	private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;	
	private static final String BEGIN_SQL = "select id, naam, omzet, straat, huisNr, postcode, gemeente from brouwers ";
    private static final String SQL_FIND_ALL = BEGIN_SQL + "order by naam";
    private static final String SQL_READ = BEGIN_SQL + " where id = :id";
    
    private final RowMapper<Brouwer> rowMapper = (resultSet, rowNum) ->  {
		return new Brouwer(resultSet.getInt("id"), 
						   resultSet.getString("naam"),   
						   resultSet.getBigDecimal("omzet"), 		  
				
						   new Adres(resultSet.getString("straat"), 
								   	 resultSet.getInt("huisNr"),      
								     resultSet.getInt("postcode"),
								     resultSet.getString("gemeente")));  };

	BrouwersRepository(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
		
	}

	/*
	   private static final String SQL_FIND_BY_POSTCODE = BEGIN_SQL +
"where postcode between :van and :tot order by naam"; 
@Override
public List<Filiaal> findByPostcodeReeks(PostcodeReeks reeks) {
Map<String, Object> parameters = new HashMap<>(); 
parameters.put("van", reeks.getVanpostcode()); 
parameters.put("tot", reeks.getTotpostcode());
return namedParameterJdbcTemplate.query(SQL_FIND_BY_POSTCODE, parameters, 
rowMapper);
}
	  */

    
    public List<Brouwer> alfabetisch() {   
    	return namedParameterJdbcTemplate.query(SQL_FIND_ALL, rowMapper); 
 }		
 
    public Optional<Brouwer> read(long id) {
    	Map<String, Long> parameters = Collections.singletonMap("id", id); 
    	try {
    	return Optional.of(namedParameterJdbcTemplate.queryForObject(
    	SQL_READ, parameters, rowMapper)); 
    	} catch (IncorrectResultSizeDataAccessException ex) {
    	return Optional.empty(); // record niet gevonden
    	}
    	}
    
    
								     
}