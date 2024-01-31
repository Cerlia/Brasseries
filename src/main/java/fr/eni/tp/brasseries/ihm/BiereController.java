package fr.eni.tp.brasseries.ihm;

import fr.eni.tp.brasseries.bll.BiereService;
import fr.eni.tp.brasseries.bll.BrasserieService;
import fr.eni.tp.brasseries.bll.BrasserieServiceException;
import fr.eni.tp.brasseries.bo.Biere;
import fr.eni.tp.brasseries.bo.Brasserie;
import fr.eni.tp.brasseries.dal.BrasserieDAO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/biere")
public class BiereController {

    @Autowired
    BiereService biereService;
    @Autowired
    BrasserieService brasserieService;

    @ModelAttribute("lstBieres")
    List<Biere> getBieres() {
        return biereService.getAll();
    }
    @ModelAttribute("lstBrasseries")
    List<Brasserie> getBrasseries() {
        return brasserieService.getAll();
    }

    @GetMapping
    public String createBiere(Biere biere) {
        return "view-biere";
    }

    @PostMapping
    public String createBiere(@Valid Biere biere, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "view-biere";
        } else {
            biereService.create(biere);
            return "redirect:/brasserie";
        }
    }
}
