package fr.eni.tp.brasseries.ihm.converters;

import fr.eni.tp.brasseries.bll.BrasserieService;
import fr.eni.tp.brasseries.bo.Brasserie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToBrasserieConverter implements Converter<String, Brasserie> {

    @Autowired
    BrasserieService brasserieService;

    @Override
    public Brasserie convert(String idBrasserie) {
        return brasserieService.getById(Integer.valueOf(idBrasserie));
    }
}
