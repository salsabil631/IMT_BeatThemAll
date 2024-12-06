package org.personnage;

public abstract class Personnage {
    private int pv;
    private int attaque;
    private int defense;
    private String nom;

    public Personnage(int pv, int attaque, int defense, String nom) {
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
        System.out.println(this.nom + " attaque " + p.getNom() + " et lui inflige " + degats + " points de dégats.");
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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
