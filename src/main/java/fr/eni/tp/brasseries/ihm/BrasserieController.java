package fr.eni.tp.brasseries.ihm;

import fr.eni.tp.brasseries.bll.BrasserieService;
import fr.eni.tp.brasseries.bo.Brasserie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/brasserie")
public class BrasserieController {

    @Autowired
    BrasserieService brasserieService;

    @GetMapping
    public String createBrasserie(Brasserie brasserie){

        return "view-brasserie";
    }
}
