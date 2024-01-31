package fr.eni.tp.brasseries.dal;

import fr.eni.tp.brasseries.bo.Biere;

import java.util.List;

public interface BiereDAO {
    void insert(Biere biere);
    List<Biere> selectAll();
    List<Biere> selectAllByBrasserieId(Integer idBrasserie);
}
