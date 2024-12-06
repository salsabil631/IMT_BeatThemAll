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
    private List<Hero> possibleHeros = new ArrayList<>();
    private List<Carte> possibleCartes = new ArrayList<>();
    private Hero hero;
    private Carte carte;
    private Scanner scanner = new Scanner(System.in);

    public Main(Hero hero, Carte carte) {
        this.hero = hero;
        this.carte = carte;
    }

    public void main() {
        //DEBUISSON Julian et AMRI Salsabil
        possibleHeros.add(new Hero("Guerrier", 100, 50, 70, new Oneshot()));
        possibleHeros.add(new Hero("Mage", 80, 80, 50, new Soigner()));
        possibleHeros.add(new Hero("Voleur", 90, 60, 30, new Invinsible()));

        possibleCartes.add(new Carte(1, "Foret", 5));
        possibleCartes.add(new Carte(2, "Montagne", 10));
        possibleCartes.add(new Carte(3, "Desert", 15));

        


        System.out.println("Bienvenue dans le jeu");
        System.out.println("Vous incarnez " + hero.getNom());
        System.out.println("Vous avez " + hero.getPv() + " PV");
        System.out.println("Vous avez " + hero.getAttaque() + " points d'attaque");
        System.out.println("Vous avez " + hero.getDefense() + " points de défense");
        System.out.println("Vous êtes sur la carte " + carte.getNom());
        System.out.println("Vous avez " + carte.getNbEnnemis() + " ennemis à combattre");
        System.out.println("Bonne chance !");
    }

    
}
