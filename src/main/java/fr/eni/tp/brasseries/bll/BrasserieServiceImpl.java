package fr.eni.tp.brasseries.bll;

import fr.eni.tp.brasseries.bo.Brasserie;
import fr.eni.tp.brasseries.dal.BrasserieDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BrasserieServiceImpl implements BrasserieService {

    @Autowired
    BrasserieDAO brasserieDAO;

    @Override
    public void create(Brasserie brasserie) throws BrasserieServiceException {
        if("Kronembourg".equals(brasserie.getNom())){
            throw new BrasserieServiceException("Kronembourg est un nom interdit");
        }
        brasserieDAO.insert(brasserie);
    }

    @Override
    public List<Brasserie> getAll() {

        return brasserieDAO.selectAll();
    }
}
