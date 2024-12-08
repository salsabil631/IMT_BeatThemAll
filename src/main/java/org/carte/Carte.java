package org.carte;

import java.util.Random;
import java.util.Scanner;

import org.personnage.Ennemi;
import org.personnage.EnnemieType;
import org.personnage.Hero;

import java.util.ArrayList;
import java.util.List;

public class Carte {
    private static final int MAX_NEW_ENNEMIS = 3;
    private static final String AVANCER = "a";
    private static final String RECULER = "r";

    private int lieu;
    private String nom;
    private int debut;
    private int fin;
    private int nbEnnemis;
    private int progression;
    private List<Ennemi> ennemis = new ArrayList<>();
    private Random random = new Random();

    public Carte(int debut, String nom, int fin) {
        this.debut = debut;
        this.lieu = debut;
        this.progression = debut;
        this.nom = nom;
        this.fin = fin;
        this.nbEnnemis = random.nextInt(MAX_NEW_ENNEMIS) + 1;
        genererEnnemis();
    }

    public void salleSuivante(Scanner scanner) {
        System.out.println("\nVous avez vaincu tous les ennemis de la salle " + lieu);
        System.out.println("Voulez-vous avancer ou reculer ? (a/r)");
        String choix = scanner.nextLine();

        if (AVANCER.equals(choix)) {
            lieu++;
            System.out.println("Vous entrez dans la salle " + lieu + "\n");
        } else if (RECULER.equals(choix)) {
            if (lieu == debut) {
                System.out.println("Vous ne pouvez pas reculer");
                salleSuivante(scanner);
                return;
            }
            lieu--;
        }

        if (lieu > progression) {
            progression = lieu;
            nbEnnemis = random.nextInt(MAX_NEW_ENNEMIS) + 1;
            ennemis.clear();
            genererEnnemis();
            System.out.println("Il y a " + nbEnnemis + " ennemis dans la salle " + lieu);
        }
    }

    private void genererEnnemis() {
        for (int i = 0; i < nbEnnemis; i++) {
            ennemis.add(new Ennemi(random.nextInt(40) + 10, random.nextInt(40) + 10, random.nextInt(40) + 10, "Ennemi " + i, EnnemieType.getRandomType()));
        }
    }

    public boolean isReachedEnd(Hero hero) {
        return lieu == fin + 1;
    }

    public void isEnemiDead(Ennemi ennemi, Scanner scanner) {
        if (ennemi.getPv() < 0) {
            System.out.println("\nL'ennemi " + ennemi.getNom() + " est mort");
            ennemis.remove(ennemi);
            nbEnnemis--;
            if (nbEnnemis == 0) {
                salleSuivante(scanner);
            }
        }
    }

    public Ennemi currentEnnemi() {
        if (ennemis.isEmpty()) {
            return null;
        }
        return ennemis.get(nbEnnemis - 1);
    }

    // Getters and setters
    public int getLieu() {
        return lieu;
    }

    public String getNom() {
        return nom;
    }

    public int getFin() {
        return fin;
    }

    public void setFin(int fin) {
        this.fin = fin;
    }

    public int getNbEnnemis() {
        return nbEnnemis;
    }

    public void setNbEnnemis(int nbEnnemis) {
        this.nbEnnemis = nbEnnemis;
    }

    public List<Ennemi> getEnnemis() {
        return ennemis;
    }

    public void setEnnemis(List<Ennemi> ennemis) {
        this.ennemis = ennemis;
    }
}