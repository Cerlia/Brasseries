package fr.eni.tp.brasseries.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Biere {
    private Integer idBiere;
    private String  nom;
    private Type type;
    private String description;
    private Double dgAlcool;
    private Integer note;
    private Brasserie brasserie;

    public Biere(String nom, Type type, String description, Double dgAlcool, Integer note, Brasserie brasserie) {
        this.nom = nom;
        this.type = type;
        this.description = description;
        this.dgAlcool = dgAlcool;
        this.note = note;
        this.brasserie = brasserie;
    }
}
