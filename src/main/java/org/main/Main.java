package org.main;

import org.personnage.Hero;
import org.capaciteSpeciale.Invinsible;
import org.capaciteSpeciale.Oneshot;
import org.capaciteSpeciale.Soigner;
import org.carte.Carte;
import org.logger.LoggerUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Main class
 * Class to initialize the game
 */
public class Main {

    /** scanner for the user prompt */
    private static final Scanner scanner = new Scanner(System.in);
    
    /** list of the heros */
    private static final List<Hero> possibleHeros = new ArrayList<>();
    
    /** list of the cards */
    private static final List<Carte> possibleCartes = new ArrayList<>();

    /**
     * Main method
     * Method to initialize the game
     * @param args
     */
    public static void main(String[] args) {
        // DEBUISSON Julian et AMRI Salsabil

        initializeHeros();
        initializeCartes();

        Hero hero = choisirHero();
        Carte carte = choisirCarte();

        LoggerUtil.log("\nVous avez choisi " + hero.getNom() + " et la carte " + carte.getNom());
        LoggerUtil.log("Appuyez sur entrée pour commencer");
        scanner.nextLine();

        jouer(hero, carte, scanner);
    }

    /**
     * Method to initialize the heros
     */
    private static void initializeHeros() {
        possibleHeros.add(new Hero("Guerrier", 100, 50, 70, new Invinsible()));
        possibleHeros.add(new Hero("Mage", 80, 80, 50, new Soigner()));
        possibleHeros.add(new Hero("Voleur", 60, 90, 30, new Oneshot()));
    }

    /**
     * Method to initialize the cards
     */
    private static void initializeCartes() {
        possibleCartes.add(new Carte(1, "Forêt", 5));
        possibleCartes.add(new Carte(2, "Montagne", 10));
        possibleCartes.add(new Carte(3, "Désert", 15));
    }

    /**
     * Method to choose a hero
     * @return The chosen Hero
     */
    private static Hero choisirHero() {
        LoggerUtil.log("Choisissez votre personnage :");
        for (int i = 0; i < possibleHeros.size(); i++) {
            LoggerUtil.log((i + 1) + " - " + possibleHeros.get(i).getNom());
        }

        int choixHero = Integer.parseInt(scanner.nextLine()) - 1;
        return possibleHeros.get(choixHero);
    }

    /**
     * Method to choose a card
     * @return The chosen card
     */
    private static Carte choisirCarte() {
        LoggerUtil.log("Choisissez votre carte :");
        for (int i = 0; i < possibleCartes.size(); i++) {
            LoggerUtil.log((i + 1) + " - " + possibleCartes.get(i).getNom());
        }

        int choixCarte = Integer.parseInt(scanner.nextLine()) - 1;
        return possibleCartes.get(choixCarte);
    }

    /**
     * Method to play the game
     * @param hero The chosen hero
     * @param carte The chosen card
     * @param scanner The scanner
     * @return True if the player wins, false otherwise
     */
    public static boolean jouer(Hero hero, Carte carte, Scanner scanner) {
        while (hero.getPv() > 0) {
            LoggerUtil.log("Vous êtes dans la salle " + carte.getLieu());
            if (carte.currentEnnemi() != null) {
                LoggerUtil.log("Il y a " + carte.getNbEnnemis() + " ennemis");
            } else {
                LoggerUtil.log("Il n'y a plus d'ennemis");
                carte.salleSuivante(scanner);
                continue;
            }

            if (hero.isCapaciteSpecialeUtilisable()) {
                utiliserCapaciteSpeciale(hero, carte);
            }

            attaquer(hero, carte);

            boolean fin = carte.isReachedEnd(hero);
            LoggerUtil.log("\nFin du tour");
            LoggerUtil.log("il vous reste "+ hero.getPv()+ " pv");

            if (fin) {
                LoggerUtil.log("Vous avez gagné !");
                return true;
            }
        }
        return false;
    }

    /**
     * Method to use the special ability
     * @param hero The chosen hero
     * @param carte The chosen card
     */
    private static void utiliserCapaciteSpeciale(Hero hero, Carte carte) {
        LoggerUtil.log("\nVoulez-vous utiliser votre capacité spéciale ? oui/non");
        String choix = scanner.nextLine();
        if ("oui".equals(choix)) {
            hero.utiliserCapaciteSpeciale(carte.currentEnnemi());
            carte.isEnemiDead(carte.currentEnnemi(), scanner);
        }
    }

    /**
     * Method to attack
     * @param hero The chosen hero
     * @param carte The chosen card
     */
    private static void attaquer(Hero hero, Carte carte) {
        LoggerUtil.log("Appuyez sur entrée pour attaquer");
        scanner.nextLine();
        if (carte.currentEnnemi().getType().isDistance()) {
            carte.currentEnnemi().attaquer(hero);
            hero.isHeroDead();
            hero.attaquer(carte.currentEnnemi());
        } else {
            hero.attaquer(carte.currentEnnemi());
            carte.currentEnnemi().attaquer(hero);
            hero.isHeroDead();
        }
        carte.isEnemiDead(carte.currentEnnemi(), scanner);
    }
}