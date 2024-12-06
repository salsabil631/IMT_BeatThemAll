package org.main;

import org.personnage.Hero;
import org.capaciteSpeciale.Invinsible;
import org.capaciteSpeciale.Oneshot;
import org.capaciteSpeciale.Soigner;
import org.carte.Carte;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Hero> possibleHeros = new ArrayList<>();
    private static List<Carte> possibleCartes = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //DEBUISSON Julian et AMRI Salsabil


        possibleHeros.add(new Hero("Guerrier", 100, 50, 70, new Oneshot()));
        possibleHeros.add(new Hero("Mage", 80, 80, 50, new Soigner()));
        possibleHeros.add(new Hero("Voleur", 90, 60, 30, new Invinsible()));

        possibleCartes.add(new Carte(1, "Foret", 5));
        possibleCartes.add(new Carte(2, "Montagne", 10));
        possibleCartes.add(new Carte(3, "Desert", 15));

        System.out.println("Choisissez votre personnage :");
        for (int i = 0; i < possibleHeros.size(); i++) {
            System.out.println(i + 1 + " - " + possibleHeros.get(i).getNom());
        }

        String choixHero = scanner.nextLine();
        Hero hero = possibleHeros.get(Integer.parseInt(choixHero) - 1);

        System.out.println("Choisissez votre carte :");
        for (int i = 0; i < possibleCartes.size(); i++) {
            System.out.println(i + 1 + " - " + possibleCartes.get(i).getNom());
        }

        String choixCarte = scanner.nextLine();
        Carte carte = possibleCartes.get(Integer.parseInt(choixCarte) - 1);

    

        System.out.println("Vous avez choisi " + hero.getNom() + " et la carte " + carte.getNom());
        System.out.println("Appuyez sur entrée pour commencer");
        scanner.nextLine();

        while (hero.getPv() > 0) {
            System.out.println("Vous êtes dans la salle " + carte.getLieu());
            System.out.println("Il y a " + carte.getNbEnnemis() + " ennemis");

            if (hero.isCapaciteSpecialeUtilisable()){
                System.out.println("Voulez-vous utiliser votre capacité spéciale ? oui/non");

                String choix = scanner.nextLine();
                if (choix.equals("oui")) {
                    hero.utiliserCapaciteSpeciale(carte.currentEnnemi());
                }
            }

            System.out.println("Appuyez sur entrée pour attaquer");
            scanner.nextLine();
            hero.attaquer(carte.currentEnnemi());
            boolean fin = carte.finTour(hero);
            System.out.println("Fin du tour");

            if (fin) {
                System.out.println("Vous avez gagné !");
                break;
            }

        }

        
    }

    
}
