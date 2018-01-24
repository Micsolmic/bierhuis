package be.vdab.repositories;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import be.vdab.entities.Bestelbonlijn;

@Repository
public class BestelbonlijnRepository {

	
	private final SimpleJdbcInsert simpleJdbcInsert;
	
	
	public BestelbonlijnRepository(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate); 
		simpleJdbcInsert.withTableName("bestelbonlijnen"); 
		simpleJdbcInsert.usingGeneratedKeyColumns("bestelbonid");
	}
	
	public void create(Bestelbonlijn bblijn) {
		Map<String, Object> kolomWaarden = new HashMap<>(); 
		kolomWaarden.put("bierid", bblijn.getBierid()); 
		kolomWaarden.put("aantal", bblijn.getAantal());
		kolomWaarden.put("prijs", bblijn.getPrijs());
		
		Number id = simpleJdbcInsert.executeAndReturnKey(kolomWaarden); 
		bblijn.setBestelbonid(id.intValue()); 
		}
}
