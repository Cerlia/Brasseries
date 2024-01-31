package fr.eni.tp.brasseries.dal;

import fr.eni.tp.brasseries.bo.Brasserie;

import java.util.List;

public interface BrasserieDAO {
    void insert(Brasserie brasserie);
    List<Brasserie> selectAll();

}
