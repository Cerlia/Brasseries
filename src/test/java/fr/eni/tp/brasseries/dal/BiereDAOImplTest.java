package fr.eni.tp.brasseries.dal;

import fr.eni.tp.brasseries.bo.Biere;
import fr.eni.tp.brasseries.bo.Brasserie;
import fr.eni.tp.brasseries.bo.Type;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BiereDAOImplTest {

    @Autowired
    BiereDAO biereDAO;
    @Autowired
    BrasserieDAO brasserieDAO;

    @Test
    void insert() {
        Brasserie brasserie1 = new Brasserie("Sainte-Colombe", "Corps-Nuds", "125 212", LocalDate.of(2000,1,1));
        brasserieDAO.insert(brasserie1);
        Biere biere = new Biere("Sainte-Colombe", Type.BLONDE, "Une bière qui est bonne", 4.7, 4, brasserie1);
        biereDAO.insert(biere);
        System.out.println(biere);
    }

    @Test
    void selectAll() {
    }

    @Test
    void selectAllByBrasserieId() {
    }
}