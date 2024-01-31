package fr.eni.tp.brasseries.dal;

import fr.eni.tp.brasseries.bo.Biere;
import fr.eni.tp.brasseries.bo.Brasserie;
import fr.eni.tp.brasseries.bo.Type;
import org.springframework.beans.factory.annotation.Autowired;
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
public class BiereDAOImpl implements BiereDAO {

    private final String INSERT = "INSERT INTO BIERE (nom, type, description, dg_alcool, note, id_brasserie) VALUES (:nom, :type, :description, :dgAlcool, :note, :idBrasserie)";
    private final String SELECT_ALL = "SELECT (id_biere, nom, type, description, dg_alcool, note, id_brasserie) FROM BIERE";

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public void insert(Biere biere) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("nom", biere.getNom());
        namedParameters.addValue("type", biere.getType().toString());
        namedParameters.addValue("description", biere.getDescription());
        namedParameters.addValue("dgAlcool", biere.getDgAlcool());
        namedParameters.addValue("note", biere.getNote());
        namedParameters.addValue("idBrasserie", biere.getBrasserie().getIdBrasserie());

        jdbcTemplate.update(INSERT, namedParameters, keyHolder);

        if (keyHolder != null && keyHolder.getKey() != null) {
            biere.setIdBiere(keyHolder.getKey().intValue());
        }
    }

    @Override
    public List<Biere> selectAll() {

        return jdbcTemplate.query(SELECT_ALL, );
    }

    @Override
    public List<Biere> selectAllByBrasserieId(Integer idBrasserie) {
        return null;
    }


    @Component
    public class BiereRowMapper implements RowMapper<Biere> {

        @Autowired
        BrasserieDAO brasserieDAO;

        @Override
        public Biere mapRow(ResultSet rs, int rowNum) throws SQLException {
            Biere biere = new Biere();
            biere.setIdBiere(rs.getInt("id_biere"));
            biere.setNom(rs.getString("nom"));
            biere.setDescription(rs.getString("description"));
            biere.setDgAlcool(rs.getDouble("dg_alcool"));
            biere.setNote(rs.getInt("note"));


            //biere.setNom(rs.getString("type"));

//            Brasserie brasserie = brasserieDAO...
            biere.setBrasserie(brasserie);


            film.setTitre(rs.getString("titre"));
            film.setAnnee(Integer.parseInt(rs.getString("annee")));
            film.setDuree(Integer.parseInt(rs.getString("duree")));
            film.setSynopsis(rs.getString("synopsis"));

            Genre genre = genreDAO.read(Long.valueOf(rs.getString("id_genre")));
            film.setGenre(genre);

            Participant realisateur = participantDAO.read(Long.valueOf(rs.getString("id_realisateur")));
            film.setRealisateur(realisateur);

            List<Participant> acteurs = participantDAO.findActeurs(Long.valueOf(rs.getString("id")));
            film.setActeurs(acteurs);

            List<Avis> avis = avisDAO.findByFilm(Long.valueOf(rs.getString("id")));
            if (null != avis) {
                film.setAvis(avis);
            }
            return film;
        }
    }


}
