package be.vdab.repositories;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import be.vdab.entities.Bier;
import be.vdab.entities.Brouwer;
import be.vdab.entities.Soort;
import be.vdab.valueobjects.Adres;

public class BierenRepository {

	private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private final JdbcTemplate jdbcTemplate;
	private static final String BEGIN_SQL = "select bieren.*, soorten.naam as soortnaam, from bieren left join soorten";
	private static final String RELEVANT = " where brouwerid = :brouwerid";
	private static final String ORDERED = " order by naam";
	private static final String SQL_READ = BEGIN_SQL + "where id = ?";

	private final RowMapper<Bier> rowMapper = (resultSet, rowNum) -> {
		return new Bier(resultSet.getInt("id"), 
						resultSet.getString("naam"), 
						resultSet.getInt("brouwerid"),
						new Soort(resultSet.getInt("soortid"), resultSet.getString("soortnaam")),
						resultSet.getDouble("alcohol"),		
						resultSet.getBigDecimal("prijs"));
	};
	
	

	BierenRepository(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Bier> alleBierenVanBrouwer(int brouwerid) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("brouwerid", brouwerid);
		return namedParameterJdbcTemplate.query(BEGIN_SQL + RELEVANT + ORDERED, parameters, rowMapper);
	}

	public Optional<Bier> read(long id) {
		try {
			return Optional.of(jdbcTemplate.queryForObject(SQL_READ, rowMapper, id));
		} catch (IncorrectResultSizeDataAccessException ex) {
			return Optional.empty(); // record niet gevonden
		}
	}

}
