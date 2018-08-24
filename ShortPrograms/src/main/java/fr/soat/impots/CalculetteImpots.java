package fr.soat.impots;

import fr.soat.impots.model.Entreprise;

public class CalculetteImpots {

    public static long calculImpotEntreprise(Entreprise entreprise, long CA) {
        return CA*entreprise.getTauxImposition()/100;
    }
}
