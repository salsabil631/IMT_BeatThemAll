package org.personnage;

public abstract class Personnage {
    private int pv;
    private int attaque;
    private int defense;
    private int nom;

    public Personnage(int pv, int attaque, int defense, int nom) {
        this.pv = pv;
        this.attaque = attaque;
        this.defense = defense;
        this.nom = nom;
    }

    public void attaquer(Personnage p) {
        int degats = this.attaque - (this.attaque * (p.getDefense()/100));
        if (degats < 0) {
            degats = 0;
        }
        p.setPv(p.getPv() - degats);
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public int getAttaque() {
        return attaque;
    }

    public void setAttaque(int attaque) {
        this.attaque = attaque;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getNom() {
        return nom;
    }

    public void setNom(int nom) {
        this.nom = nom;
    }
}
