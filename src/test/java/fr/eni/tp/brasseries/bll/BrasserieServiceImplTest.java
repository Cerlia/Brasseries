package fr.eni.tp.brasseries.bll;

import fr.eni.tp.brasseries.bo.Brasserie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BrasserieServiceImplTest {

    @Autowired
    BrasserieService brasserieService;

    @Test
    @Transactional
    void contextLoads() throws BrasserieServiceException {
        Brasserie brasserie1 = new Brasserie("Sainte-Colombe", "Corps-Nuds", "125 212", LocalDate.of(2000,1,1));
        Brasserie brasserie2 = new Brasserie("Saint-Omer", "Saint-Omer", "256 812", LocalDate.of(2018,2,11));
        Brasserie brasserie3 = new Brasserie("Kronembourg", "Kronembourg", "23 325", LocalDate.of(1856,4,24));
        try {
            brasserieService.create(brasserie1);
            brasserieService.create(brasserie2);
            brasserieService.create(brasserie3);
        } catch (BrasserieServiceException e) {
            System.out.println("Capture de l'exception BrasserieServiceException "+e.getMessage());
        }
        List<Brasserie> lst = brasserieService.getAll();
        lst.forEach(System.out::println);
    }
}