package fr.soat.impots.model;

public class AutoEntreprise extends Entreprise {

    private String siret;
    private String denomination;


    public AutoEntreprise(String siret, String denomination) {
        super(TypesEntreprise.AUTO);
        this.siret = siret;
        this.denomination = denomination;
    }

    public String getSiret() {
        return siret;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }

    public String getDenomination() {
        return denomination;
    }

    public void setDenomination(String denomination) {
        this.denomination = denomination;
    }

    @Override
    public String toString() {
        return "AutoEntreprise{" +
                "siret='" + siret + '\'' +
                ", denomination='" + denomination + '\'' +
                '}';
    }
}
