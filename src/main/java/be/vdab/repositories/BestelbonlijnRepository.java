package be.vdab.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import be.vdab.entities.Bestelbonlijn;
import be.vdab.entities.Bier;

@Repository
public class BestelbonlijnRepository {

	
	private final SimpleJdbcInsert simpleJdbcInsert;
	
	
	public BestelbonlijnRepository(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate); 
		simpleJdbcInsert.withTableName("bestelbonlijnen"); 
		
	}
	
	public void create(Bier bblijn, int bestelbonid) {
		Map<String, Object> kolomWaarden = new HashMap<>(); 
		kolomWaarden.put("bestelbonid", bestelbonid);
		kolomWaarden.put("bierid", bblijn.getId()); 
		kolomWaarden.put("aantal", bblijn.getAantal());
		kolomWaarden.put("prijs", bblijn.getPrijs());
	
		simpleJdbcInsert.execute(kolomWaarden); 
		
		}
	
	public void bblijnenNaarDB(List<Bier> bblijnen, int bestelbonid) {
		
		for(Bier b :bblijnen) {
			
			create(b, bestelbonid);
			
		}
		
	}
}
