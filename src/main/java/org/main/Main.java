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
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Hero> possibleHeros = new ArrayList<>();
    private static final List<Carte> possibleCartes = new ArrayList<>();

    public static void main(String[] args) {
        // DEBUISSON Julian et AMRI Salsabil

        initializeHeros();
        initializeCartes();

        Hero hero = choisirHero();
        Carte carte = choisirCarte();

        System.out.println("\nVous avez choisi " + hero.getNom() + " et la carte " + carte.getNom());
        System.out.println("Appuyez sur entrée pour commencer");
        scanner.nextLine();

        jouer(hero, carte);
    }

    private static void initializeHeros() {
        possibleHeros.add(new Hero("Guerrier", 100, 50, 70, new Invinsible()));
        possibleHeros.add(new Hero("Mage", 80, 80, 50, new Soigner()));
        possibleHeros.add(new Hero("Voleur", 60, 90, 30, new Oneshot()));
    }

    private static void initializeCartes() {
        possibleCartes.add(new Carte(1, "Forêt", 5));
        possibleCartes.add(new Carte(2, "Montagne", 10));
        possibleCartes.add(new Carte(3, "Désert", 15));
    }

    private static Hero choisirHero() {
        System.out.println("Choisissez votre personnage :");
        for (int i = 0; i < possibleHeros.size(); i++) {
            System.out.println((i + 1) + " - " + possibleHeros.get(i).getNom());
        }

        int choixHero = Integer.parseInt(scanner.nextLine()) - 1;
        return possibleHeros.get(choixHero);
    }

    private static Carte choisirCarte() {
        System.out.println("Choisissez votre carte :");
        for (int i = 0; i < possibleCartes.size(); i++) {
            System.out.println((i + 1) + " - " + possibleCartes.get(i).getNom());
        }

        int choixCarte = Integer.parseInt(scanner.nextLine()) - 1;
        return possibleCartes.get(choixCarte);
    }

    private static void jouer(Hero hero, Carte carte) {
        while (hero.getPv() > 0) {
            System.out.println("Vous êtes dans la salle " + carte.getLieu());
            if (carte.currentEnnemi() != null) {
                System.out.println("Il y a " + carte.getNbEnnemis() + " ennemis");
            } else {
                System.out.println("Il n'y a plus d'ennemis");
                carte.salleSuivante(scanner);
                continue;
            }

            if (hero.isCapaciteSpecialeUtilisable()) {
                utiliserCapaciteSpeciale(hero, carte);
            }

            attaquer(hero, carte);

            boolean fin = carte.finTour(hero);
            System.out.println("\nFin du tour");

            if (fin) {
                System.out.println("Vous avez gagné !");
                break;
            }
        }
    }

    private static void utiliserCapaciteSpeciale(Hero hero, Carte carte) {
        System.out.println("\nVoulez-vous utiliser votre capacité spéciale ? oui/non");
        String choix = scanner.nextLine();
        if ("oui".equals(choix)) {
            hero.utiliserCapaciteSpeciale(carte.currentEnnemi());
            carte.isEnemiDead(carte.currentEnnemi(), scanner);
        }
    }

    private static void attaquer(Hero hero, Carte carte) {
        System.out.println("Appuyez sur entrée pour attaquer");
        scanner.nextLine();
        if (carte.currentEnnemi().getType().isDistance()) {
            carte.currentEnnemi().attaquer(hero);
            hero.attaquer(carte.currentEnnemi());
        } else {
            hero.attaquer(carte.currentEnnemi());
            carte.currentEnnemi().attaquer(hero);
        }
        carte.isEnemiDead(carte.currentEnnemi(), scanner);
    }
}