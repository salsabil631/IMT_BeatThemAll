package org.carte;

import java.util.Random;

import org.personnage.Ennemi;
import org.personnage.EnnemieType;
import org.personnage.Hero;

import java.util.ArrayList;
import java.util.List;


public class Carte {
    private int lieu;
    private String nom;
    private int fin;
    private int nbEnnemis;
    private List<Ennemi> ennemis = new ArrayList<>();
    private Random random = new Random();
    private final int MAX_NEW_ENNEMIS = 3;

    public Carte(int lieu, String nom, int fin) {
        this.lieu = lieu;
        this.nom = nom;
        this.fin = fin;
        this.nbEnnemis = random.nextInt(MAX_NEW_ENNEMIS);;
        genererEnnemis();
    }

    public void salleSuivante(){
        System.out.println("Vous avez vaincu tous les ennemis de la salle " + lieu);
        System.out.println("Vous entrez dans la salle " + (lieu + 1));
        if (nbEnnemis == 0) {
            nbEnnemis = random.nextInt(MAX_NEW_ENNEMIS);
            lieu++;
        }
        ennemis.clear();
        genererEnnemis();
        System.out.println("Il y a " + nbEnnemis + " ennemis dans la salle " + lieu);
    }

    public void genererEnnemis(){
        for (int i = 0; i < nbEnnemis; i++) {
            ennemis.add(new Ennemi(random.nextInt(100), random.nextInt(100), random.nextInt(100), "Ennemi " + i, EnnemieType.getRandomType()));
        }
    }

    public void finTour(Hero hero){
        Ennemi ennemi = currentEnnemie();
        if (ennemi.getPv() < 0) {
            System.out.println("L'ennemi " + ennemi.getNom() + " est mort");
            ennemis.remove(ennemi);
            nbEnnemis--;
            if(ennemis.isEmpty()){
                salleSuivante();
            }
            ennemi = currentEnnemie();
        }
        ennemi.attaquer(hero);
        if (hero.getPv() < 0) {
            System.out.println("Vous etes mort !");
            System.exit(0);
        }

    }

    public Ennemi currentEnnemie(){
        return ennemis.get(nbEnnemis - 1);
    }

    public int getlieu() {
        return lieu;
    }

    public void setlieu(int lieu) {
        this.lieu = lieu;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getfin() {
        return fin;
    }

    public void setfin(int fin) {
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