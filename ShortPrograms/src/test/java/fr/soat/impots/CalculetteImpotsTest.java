package fr.soat.impots;

import fr.soat.impots.model.AutoEntreprise;
import fr.soat.impots.model.Entreprise;
import fr.soat.impots.model.SAS;
import org.junit.Assert;
import org.junit.Test;

public class CalculetteImpotsTest {
    @Test
    public void testCalculerImpotsAutoEntreprise() throws Exception {
        Entreprise autoEntreprise = new AutoEntreprise("564736845314", "Pineapple");
        long CA = 70000000;
        long impotAttendu = 17500000;


        long impotEntreprise = CalculetteImpots.calculImpotEntreprise(autoEntreprise, CA);

        Assert.assertEquals(impotAttendu, impotEntreprise);
    }

    @Test
    public void testCalculerImpotsSAS() throws Exception {
        Entreprise sas = new SAS("74564894735", "FruitBandit", "77 Quai Panhard et Levassor, Paris");
        long CA = 700000000;
        long impotAttendu = 231000000;

        long impotEntreprise = CalculetteImpots.calculImpotEntreprise(sas, CA);

        Assert.assertEquals(impotAttendu, impotEntreprise);

    }
}
