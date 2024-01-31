package fr.eni.tp.brasseries.dal;

import fr.eni.tp.brasseries.bo.Brasserie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class BrasserieDAOImpl implements BrasserieDAO {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;
    @Override
    public void insert(Brasserie brasserie) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        String sql = "INSERT INTO BRASSERIE (nom, adresse, coord_gps, dt_ouverture) VALUES (:nom, :adresse, :coordGPS, :dtOuverture)";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("nom", brasserie.getNom());
        parameterSource.addValue("adresse", brasserie.getAdresse());
        parameterSource.addValue("coordGPS", brasserie.getCoordGPS());
        parameterSource.addValue("dtOuverture", brasserie.getDtOuverture());

        jdbcTemplate.update(sql, parameterSource, keyHolder);

        if(keyHolder != null && keyHolder.getKey() != null){
            brasserie.setIdBrasserie(keyHolder.getKey().intValue());
        }
    }

    @Override
    public List<Brasserie> selectAll() {
        return null;
    }
}
