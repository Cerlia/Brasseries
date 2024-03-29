package fr.eni.tp.brasseries.ihm;

import fr.eni.tp.brasseries.bll.BiereService;
import fr.eni.tp.brasseries.bll.BiereServiceException;
import fr.eni.tp.brasseries.bll.BrasserieService;
import fr.eni.tp.brasseries.bll.BrasserieServiceException;
import fr.eni.tp.brasseries.bo.Biere;
import fr.eni.tp.brasseries.bo.Brasserie;
import fr.eni.tp.brasseries.bo.Type;
import fr.eni.tp.brasseries.dal.BrasserieDAO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
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
    @ModelAttribute("lstTypes")
    List<Type> getTypes() {
        return Arrays.stream(Type.values()).toList();
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
            try {
                biereService.create(biere);
            } catch (BiereServiceException e) {
                FieldError error = new FieldError("biere", "type", e.getMessage());
                bindingResult.addError(error);
                return "view-biere";
            }
            return "redirect:/biere";
        }
    }
}
