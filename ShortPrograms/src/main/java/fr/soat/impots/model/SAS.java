package fr.soat.impots.model;

public class SAS extends Entreprise {

    private String siret;
    private String denomination;
    private String adresseSiegeSocial;


    public SAS(String siret, String denomination, String adresseSiegeSocial) {
        super(TypesEntreprise.SAS);
        this.siret = siret;
        this.denomination = denomination;
        this.adresseSiegeSocial = adresseSiegeSocial;
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

    public String getAdresseSiegeSocial() {
        return adresseSiegeSocial;
    }

    public void setAdresseSiegeSocial(String adresseSiegeSocial) {
        this.adresseSiegeSocial = adresseSiegeSocial;
    }

    @Override
    public String toString() {
        return "SAS{" +
                "siret='" + siret + '\'' +
                ", denomination='" + denomination + '\'' +
                ", adresseSiegeSocial='" + adresseSiegeSocial + '\'' +
                '}';
    }
}
