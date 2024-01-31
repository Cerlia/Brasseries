package fr.eni.tp.brasseries.dal;

import fr.eni.tp.brasseries.bo.Brasserie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BrasserieDAOImplTest {

    @Autowired
    BrasserieDAO brasserieDAO;

    @Test
    void contextLoads() {
        Brasserie brasserie = new Brasserie("Sainte-Colombe", "Corps-Nuds", "125 212", LocalDate.of(2000,1,1));
        brasserieDAO.insert(brasserie);
        System.out.println(brasserie);


    }
}