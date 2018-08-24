package fr.soat.impots.model;

import org.jetbrains.annotations.NotNull;

public class Entreprise {

    private int tauxImposition;
    private TypesEntreprise type;
    //Il est possible que touts les types entreprises n'aient pas toujours siret et denomination, mais elles auront toujours un taux par type

    private static final int TAUX_IMPOSITION_AUTO = 25;
    private static final int TAUX_IMPOSITION_SAS = 33;
    private static final int TAUX_IMPOSITION_DEFAULT = 20;

    public Entreprise(int tauxImposition) {
        this.tauxImposition = tauxImposition;
    }

    public Entreprise(int tauxImposition, TypesEntreprise type) {
        this.tauxImposition = tauxImposition;
        this.type = type;
    }

    public Entreprise(@NotNull TypesEntreprise type) {
        this.type = type;

        switch (type)
        {
            case SAS:{
                tauxImposition = TAUX_IMPOSITION_SAS;
                break;
            }
            case AUTO:{
                tauxImposition = TAUX_IMPOSITION_AUTO;
                break;
            }
            case SARL:{
                tauxImposition = TAUX_IMPOSITION_DEFAULT;
                break;
            }
            case SASU:{
                tauxImposition = TAUX_IMPOSITION_DEFAULT;
                break;
            }
            default:{
                tauxImposition = TAUX_IMPOSITION_DEFAULT;
                break;
            }
        }
    }

    public int getTauxImposition() {
        return tauxImposition;
    }

    public void setTauxImposition(int tauxImposition) {
        this.tauxImposition = tauxImposition;
    }

    public TypesEntreprise getType() {
        return type;
    }

    public void setType(TypesEntreprise type) {
        this.type = type;
    }
}
