package fr.eni.tp.brasseries.ihm;

import fr.eni.tp.brasseries.bll.BrasserieService;
import fr.eni.tp.brasseries.bll.BrasserieServiceException;
import fr.eni.tp.brasseries.bo.Brasserie;
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
@RequestMapping("/brasserie")
public class BrasserieController {

    @Autowired
    BrasserieService brasserieService;

    @ModelAttribute("lstBrasseries")
    List<Brasserie> getBrasseries() {
        return brasserieService.getAll();
    }

    @GetMapping
    public String createBrasserie(Brasserie brasserie){
        return "view-brasserie";
    }

    @PostMapping
    public String createBrasserie(@Valid Brasserie brasserie, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "view-brasserie";
        } else {
            try {
                brasserieService.create(brasserie);
            } catch (BrasserieServiceException e) {
                // TODO gérer l'exception
                System.out.println("BrasserieServiceException "+e.getMessage());
                return "view-brasserie";
            }
            return "redirect:/brasserie";
        }
    }
}
