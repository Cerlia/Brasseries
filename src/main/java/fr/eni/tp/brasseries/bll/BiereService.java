package fr.eni.tp.brasseries.bll;

import fr.eni.tp.brasseries.bo.Biere;

import java.util.List;

public interface BiereService {
    void create(Biere biere);
    List<Biere> getAll();
    List<Biere> getAllByBrasserieId(Integer idBrasserie);
}
