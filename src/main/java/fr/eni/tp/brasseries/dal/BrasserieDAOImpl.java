package fr.eni.tp.brasseries.dal;

import fr.eni.tp.brasseries.bo.Biere;
import fr.eni.tp.brasseries.bo.Brasserie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class BrasserieDAOImpl implements BrasserieDAO {

    private final String INSERT = "INSERT INTO BRASSERIE (nom, adresse, coord_gps, dt_ouverture) VALUES (:nom, :adresse, :coordGPS, :dtOuverture)";
    private final String SELECT_ALL = "SELECT id_brasserie, nom, adresse, coord_gps, dt_ouverture FROM BRASSERIE";
    private final String SELECT_BY_ID = "SELECT id_brasserie, nom, adresse, coord_gps, dt_ouverture FROM BRASSERIE WHERE id_brasserie=?";

    RowMapper<Brasserie> rowMapper = (rs, i) ->
            new Brasserie(rs.getInt("id_brasserie"),
                    rs.getString("nom"),
                    rs.getString("adresse"),
                    rs.getString("coord_gps"),
                    rs.getDate("dt_ouverture").toLocalDate());

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public void insert(Brasserie brasserie) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("nom", brasserie.getNom());
        parameterSource.addValue("adresse", brasserie.getAdresse());
        parameterSource.addValue("coordGPS", brasserie.getCoordGPS());
        parameterSource.addValue("dtOuverture", brasserie.getDtOuverture());

        jdbcTemplate.update(INSERT, parameterSource, keyHolder);

        if (keyHolder != null && keyHolder.getKey() != null) {
            brasserie.setIdBrasserie(keyHolder.getKey().intValue());
        }
    }

    @Override
    public List<Brasserie> selectAll() {
        return jdbcTemplate.query(SELECT_ALL, rowMapper);
    }

    @Override
    public Brasserie selectById(Integer idBrasserie) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID, new BrasserieRowMapper(), idBrasserie);
    }

    @Component
    public class BrasserieRowMapper implements RowMapper<Brasserie> {

        @Override
        public Brasserie mapRow(ResultSet rs, int rowNum) throws SQLException {
            Brasserie brasserie = new Brasserie();
            brasserie.setIdBrasserie(rs.getInt("id_brasserie"));
            brasserie.setNom(rs.getString("nom"));
            brasserie.setAdresse(rs.getString("adresse"));
            brasserie.setCoordGPS(rs.getString("coord_gps"));
            brasserie.setDtOuverture(rs.getDate("dt_ouverture").toLocalDate());

            return brasserie;
        }

    }
}
