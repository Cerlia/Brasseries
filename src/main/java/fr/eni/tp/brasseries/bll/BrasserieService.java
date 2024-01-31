package fr.eni.tp.brasseries.bll;

import fr.eni.tp.brasseries.bo.Brasserie;

import java.util.List;

public interface BrasserieService {

    /**
     * Ajout d'une Brasserie
     * CT001 Interdire le nom Kronembourg
     * @param brasserie
     */
    void create(Brasserie brasserie) throws BrasserieServiceException ;
    List<Brasserie> getAll();
    Brasserie getById(Integer id);
}
