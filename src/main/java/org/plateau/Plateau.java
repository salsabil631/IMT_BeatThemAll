package org.plateau;

import java.util.Random;
import org.personnage.Hero;

public class Plateau {
    private int salleActuelle;
    private String nom;
    private int longueur;
    private int nbEnnemis;
    private Random random = new Random();

    public Plateau(int salleActuelle, String nom, int longueur, int nbEnnemis) {
        this.salleActuelle = salleActuelle;
        this.nom = nom;
        this.longueur = longueur;
        this.nbEnnemis = nbEnnemis;
    }

    public void salleSuivante(){
        if (nbEnnemis == 0) {
            nbEnnemis = random.nextInt(3);
            salleActuelle++;
        }
    }

    public void tour(Hero hero){
        
    }
}
