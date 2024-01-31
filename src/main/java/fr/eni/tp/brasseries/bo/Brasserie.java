package fr.eni.tp.brasseries.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Brasserie {
    private Integer idBrasserie;
    private String nom;
    private String adresse;
    private String coordGPS;
    private LocalDate dtOuverture;

    public Brasserie(String nom, String adresse, String coordGPS, LocalDate dtOuverture) {
        this.nom = nom;
        this.adresse = adresse;
        this.coordGPS = coordGPS;
        this.dtOuverture = dtOuverture;
    }
}