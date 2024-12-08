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

        LoggerUtil.log("\nVous avez choisi " + hero.getNom() + " et la carte " + carte.getNom());
        LoggerUtil.log("Appuyez sur entrée pour commencer");
        scanner.nextLine();

        jouer(hero, carte, scanner);
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
        LoggerUtil.log("Choisissez votre personnage :");
        for (int i = 0; i < possibleHeros.size(); i++) {
            LoggerUtil.log((i + 1) + " - " + possibleHeros.get(i).getNom());
        }

        int choixHero = Integer.parseInt(scanner.nextLine()) - 1;
        return possibleHeros.get(choixHero);
    }

    private static Carte choisirCarte() {
        LoggerUtil.log("Choisissez votre carte :");
        for (int i = 0; i < possibleCartes.size(); i++) {
            LoggerUtil.log((i + 1) + " - " + possibleCartes.get(i).getNom());
        }

        int choixCarte = Integer.parseInt(scanner.nextLine()) - 1;
        return possibleCartes.get(choixCarte);
    }

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

            if (fin) {
                LoggerUtil.log("Vous avez gagné !");
                return true;
            }
        }
        return false;
    }

    private static void utiliserCapaciteSpeciale(Hero hero, Carte carte) {
        LoggerUtil.log("\nVoulez-vous utiliser votre capacité spéciale ? oui/non");
        String choix = scanner.nextLine();
        if ("oui".equals(choix)) {
            hero.utiliserCapaciteSpeciale(carte.currentEnnemi());
            carte.isEnemiDead(carte.currentEnnemi(), scanner);
        }
    }

    private static boolean isHeroDead(Hero hero){
        if (hero.getPv() <= 0) {
            LoggerUtil.log("Vous êtes mort !");
            return false;
        }
        return true;
    }

    private static void attaquer(Hero hero, Carte carte) {
        LoggerUtil.log("Appuyez sur entrée pour attaquer");
        scanner.nextLine();
        if (carte.currentEnnemi().getType().isDistance()) {
            carte.currentEnnemi().attaquer(hero);
            isHeroDead(hero);
            hero.attaquer(carte.currentEnnemi());
        } else {
            hero.attaquer(carte.currentEnnemi());
            carte.currentEnnemi().attaquer(hero);
            isHeroDead(hero);
        }
        carte.isEnemiDead(carte.currentEnnemi(), scanner);
    }
}