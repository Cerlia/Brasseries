package fr.eni.tp.brasseries.bll;

import fr.eni.tp.brasseries.bo.Biere;
import fr.eni.tp.brasseries.bo.Brasserie;
import fr.eni.tp.brasseries.bo.Type;
import fr.eni.tp.brasseries.dal.BiereDAO;
import fr.eni.tp.brasseries.dal.BrasserieDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BiereServiceImplTest {

    @Autowired
    BiereDAO biereDAO;
    @Autowired
    BrasserieDAO brasserieDAO;
    @Test
    void create() {
        Brasserie brasserie = new Brasserie("LeffeBrasserie", "LeffeVille", "123 256", LocalDate.of(1989, 2, 12));
        brasserieDAO.insert(brasserie);
        Biere biere = new Biere("Leffe", Type.BLONDE, "Tres bonne biere", 4.5, 2, brasserie);
        biereDAO.insert(biere);
        System.out.println(biere);
    }

    @Test
    void getAll() {
        List<Biere> lst = biereDAO.selectAll();
        lst.forEach(System.out::println);
    }

    @Test
    void getAllByBrasserieId() {
        List<Biere> lst = biereDAO.selectAllByBrasserieId(2);
        lst.forEach(System.out::println);
    }
}