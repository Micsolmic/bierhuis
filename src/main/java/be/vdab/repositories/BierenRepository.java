package be.vdab.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import be.vdab.entities.Bier;
import be.vdab.entities.Soort;

@Repository
public class BierenRepository {

	private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private final JdbcTemplate jdbcTemplate;
	private static final String ALLE_BIEREN = "select bieren.*,soorten.naam as soortnaam, brouwers.naam as brouwernaam from bieren left join soorten"
			+ " on bieren.soortid=soorten.id left join brouwers on brouwers.id=bieren.brouwerid where bieren.brouwerid=:brouwerid"
			+ " order by naam";

	private static final String SINGLE_SQL_READ = "select  bieren.*,  soorten.naam as soortnaam, brouwers.naam as brouwernaam"
			+ " from  bieren  left join soorten on bieren.soortid = soorten.id"
			+ " left join brouwers on brouwers.id = bieren.brouwerid where  bieren.id = ? order by naam";

	private final RowMapper<Bier> rowMapper = (resultSet, rowNum) -> {
		return new Bier(resultSet.getInt("id"), resultSet.getString("naam"), resultSet.getInt("brouwerid"),
				resultSet.getString("brouwernaam"),
				new Soort(resultSet.getInt("soortid"), resultSet.getString("soortnaam")),
				resultSet.getDouble("alcohol"), resultSet.getBigDecimal("prijs"));
	};

	BierenRepository(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Bier> alleBierenVanBrouwer(int brouwerid) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("brouwerid", brouwerid);
		return namedParameterJdbcTemplate.query(ALLE_BIEREN, parameters, rowMapper);
	}

	public Optional<Bier> read(long id) {
		try {
			return Optional.of(jdbcTemplate.queryForObject(SINGLE_SQL_READ, rowMapper, id));
		} catch (IncorrectResultSizeDataAccessException ex) {
			return Optional.empty(); // record niet gevonden
		}
	}

}
