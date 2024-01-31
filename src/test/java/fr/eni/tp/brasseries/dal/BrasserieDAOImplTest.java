package fr.eni.tp.brasseries.dal;

import fr.eni.tp.brasseries.bo.Brasserie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BrasserieDAOImplTest {

    @Autowired
    BrasserieDAO brasserieDAO;

    @Test
    @Transactional
    void contextLoads() {
        Brasserie brasserie1 = new Brasserie("Sainte-Colombe", "Corps-Nuds", "125 212", LocalDate.of(2000,1,1));
        Brasserie brasserie2 = new Brasserie("Saint-Omer", "Saint-Omer", "256 812", LocalDate.of(2018,2,11));
        brasserieDAO.insert(brasserie1);
        brasserieDAO.insert(brasserie2);

        List<Brasserie> lst = brasserieDAO.selectAll();
        lst.forEach(System.out::println);

    }
}