package be.vdab.repositories;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import be.vdab.entities.Brouwer;
import be.vdab.valueobjects.Adres;

@Repository
public class BrouwersRepository {

	private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private static final String BEGIN_SQL = "select id, naam, omzet, straat, huisNr, postcode, gemeente from brouwers";
    private static final String SQL_FIND_ALL = BEGIN_SQL + "order by naam";
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

	

    
    public List<Brouwer> alfabetisch() {   
    	return namedParameterJdbcTemplate.query(SQL_FIND_ALL, rowMapper); 
 }							     
								     
}