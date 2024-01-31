package fr.eni.tp.brasseries.dal;

import fr.eni.tp.brasseries.bo.Biere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class BiereDAOImpl implements BiereDAO {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;
    @Override
    public void insert(Biere biere) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("nom", biere.getNom());
        namedParameters.addValue("type", biere.getType());
        namedParameters.addValue("description", biere.getDescription());
        namedParameters.addValue("dgAlcool", biere.getDgAlcool());
        namedParameters.addValue("note", biere.getNote());
        namedParameters.addValue("idBrasserie", biere.getBrasserie().getIdBrasserie());

        String sql = "INSERT INTO CONTACT (nom, type, description, dg_alcool, note, id_brasserie) VALUES (:nom, :type, :description, :dgAlcool, :note, :idBrasserie)";

        jdbcTemplate.update(sql, namedParameters, keyHolder);

        if (keyHolder != null && keyHolder.getKey() != null) {
            biere.setIdBiere(keyHolder.getKey().intValue());
        }
    }

    @Override
    public List<Biere> selectAll() {
        return null;
    }

    @Override
    public List<Biere> selectAllByBrasserieId(Integer idBrasserie) {
        return null;
    }
}
