package fr.eni.tp.brasseries.bll;

import fr.eni.tp.brasseries.bo.Biere;
import fr.eni.tp.brasseries.dal.BiereDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BiereServiceImpl implements BiereService {

    @Autowired
    BiereDAO biereDAO;
    @Override
    public void create(Biere biere) {
        biereDAO.insert(biere);
    }

    @Override
    public List<Biere> getAll() {
        return biereDAO.selectAll();
    }

    @Override
    public List<Biere> getAllByBrasserieId(Integer idBrasserie) {
        return biereDAO.selectAllByBrasserieId(idBrasserie);
    }
}
