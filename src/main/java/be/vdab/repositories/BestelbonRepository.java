package be.vdab.repositories;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import be.vdab.entities.Bestelbon;

@Repository
public class BestelbonRepository {

	private final SimpleJdbcInsert simpleJdbcInsert;
	
	
	public BestelbonRepository(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate); 
		simpleJdbcInsert.withTableName("bestelbonnen"); 
		simpleJdbcInsert.usingGeneratedKeyColumns("id");
	}
	
	public int create(Bestelbon bbon) {
		Map<String, Object> kolomWaarden = new HashMap<>(); 
		kolomWaarden.put("naam", bbon.getNaam()); 
		kolomWaarden.put("straat", bbon.getAdres().getStraat());
		kolomWaarden.put("huisNr", bbon.getAdres().getHuisNr());
		kolomWaarden.put("postcode", bbon.getAdres().getPostcode());
		kolomWaarden.put("gemeente", bbon.getAdres().getGemeente());
		
		Number id = simpleJdbcInsert.executeAndReturnKey(kolomWaarden); 
		bbon.setId(id.intValue()); 
		return id.intValue();
		}
	
}
