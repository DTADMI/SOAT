package fr.soat.impots;

import fr.soat.impots.model.AutoEntreprise;
import fr.soat.impots.model.Entreprise;
import fr.soat.impots.model.SAS;
import fr.soat.impots.model.TypesEntreprise;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainClass {

    public static void main (String[] args){
        Scanner scanner = new Scanner(System. in);

        System.out.println("Calcul de l'impôt d'une entreprise");

        System.out.println("Saisissez CALCUL pour effectuer un calcul. N'importe quoi d'autre pour fermer l'application");
        String debut = scanner. nextLine();

        while(debut.contains("CALCUL")){
            System.out.println("Saisissez RAPIDE pour effectuer un test rapide. Sinon, il vous sera proposé de rentrer vous-même votre jeu de test");
            String typeTest = scanner. nextLine();

            if(typeTest.contains("RAPIDE")){
                Entreprise autoEntreprise = new AutoEntreprise("4534783647","Papaye");
                Entreprise sas = new SAS("464534154584561", "Goyave", "77, Rue de la sérénité, 75014, Paris");

                int CA_AutoEntreprise = 1000000;
                System.out.println(autoEntreprise.toString());
                System.out.println("CA AutoEntreprise : " + CA_AutoEntreprise + "€");

                System.out.println("Impôt calculé de l'auto-entreprise " + ((AutoEntreprise) autoEntreprise).getDenomination() + ", sur un taux de " + autoEntreprise.getTauxImposition() + "% : " + CalculetteImpots.calculImpotEntreprise(autoEntreprise, CA_AutoEntreprise) + "€");

                int CA_SAS = 70000000;
                System.out.println(sas.toString());
                System.out.println("CA SAS : " + CA_SAS + "€");

                System.out.println("Impôt calculé de la SAS " + ((SAS) sas).getDenomination() + ", sur un taux de " + sas.getTauxImposition() + "% : " + CalculetteImpots.calculImpotEntreprise(sas, CA_SAS) + "€");

                System.out.println("Saisissez CALCUL pour recommencer. N'importe quoi d'autre pour fermer l'application");
                debut = scanner. nextLine();
            }else{
                System.out.println("Saisissez le type de votre entreprise : ");


                for(int i=0; i<TypesEntreprise.values().length; i++) {
                    System.out.println(TypesEntreprise.values()[i].toString());
                }
                String type = scanner. nextLine();
                try {
                    switch (TypesEntreprise.valueOf(type)) {
                        case AUTO: {
                            System.out.println("Saisissez le siret de votre entreprise : ");
                            String siret = scanner.nextLine();

                            System.out.println("Saisissez la dénomination de votre entreprise : ");
                            String denomination = scanner.nextLine();
                            Entreprise autoEntreprise = new AutoEntreprise(siret, denomination);

                            System.out.println("Saisissez le chiffre d'affaire de votre entreprise : ");
                            try {
                                Long CA = scanner.nextLong();

                                System.out.println(autoEntreprise.toString());
                                System.out.println("CA AutoEntreprise : " + CA + "€");

                                System.out.println("Impôt calculé de l'auto-entreprise " + ((AutoEntreprise) autoEntreprise).getDenomination() + ", sur un taux de " + autoEntreprise.getTauxImposition() + "% : " + CalculetteImpots.calculImpotEntreprise(autoEntreprise, CA) + "€");
                            } catch(InputMismatchException ime){
                                System.out.println("Vous avez saisi un chiffre d'affaire non numérique");
                            }
                            System.out.println("Saisissez CALCUL pour recommencer. N'importe quoi d'autre pour fermer l'application");
                            debut = scanner. nextLine();
                            break;
                        }
                        case SAS: {
                            System.out.println("Saisissez le siret de votre entreprise : ");
                            String siret = scanner.nextLine();

                            System.out.println("Saisissez la dénomination de votre entreprise : ");
                            String denomination = scanner.nextLine();

                            System.out.println("Saisissez l'adresse du siege social de votre entreprise : ");
                            String adresseSiegeSocial = scanner.nextLine();
                            Entreprise sas = new SAS(siret, denomination, adresseSiegeSocial);


                            System.out.println("Saisissez le chiffre d'affaire de votre entreprise : ");
                            try {
                                Long CA = scanner.nextLong();

                                System.out.println(sas.toString());
                                System.out.println("CA AutoEntreprise : " + CA + "€");

                                System.out.println("Impôt calculé de l'auto-entreprise " + ((SAS) sas).getDenomination() + ", sur un taux de " + sas.getTauxImposition() + "% : " + CalculetteImpots.calculImpotEntreprise(sas, CA) + "€");
                            } catch(InputMismatchException ime){
                                System.out.println("Vous avez saisi un chiffre d'affaire non numérique");
                            }
                            System.out.println("Saisissez CALCUL pour recommencer. N'importe quoi d'autre pour fermer l'application");
                            debut = scanner. nextLine();
                            break;
                        }
                        default: {
                            System.out.println("Le type d'entreprise que vous avez saisi n'existe pas ou n'est pas encore prise en charge par cette application.");
                            System.out.println("Saisissez CALCUL pour recommencer. N'importe quoi d'autre pour fermer l'application");
                            debut = scanner. nextLine();
                            break;
                        }
                    }
                } catch (IllegalArgumentException iae){
                    System.out.println("Le type d'entreprise que vous avez saisi n'existe pas ou n'est pas encore prise en charge par cette application.");
                    System.out.println("Saisissez CALCUL pour recommencer. N'importe quoi d'autre pour fermer l'application");
                    debut = scanner. nextLine();
                }

                //System.out.println("Saisissez CALCUL pour recommencer. N'importe quoi d'autre pour fermer l'application");
                debut = scanner. nextLine();
            }
        }

        System.out.println("La calculette se ferme. Merci de l'avoir utilisée. :)");
        scanner.close();
    }
}
