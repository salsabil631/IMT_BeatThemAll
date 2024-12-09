package org.personnage;

import org.logger.LoggerUtil;

/**
 * Abstract class for the characters
 */
public abstract class Personnage {
    /** health points of the character */
    private int pv;
    /** attack points of the character */
    private int attaque;
    /** defense points of the character */
    private int defense;
    /** name of the character */
    private String nom;

    /**
     * Constructor
     * @param pv The health points of the character
     * @param attaque The attack points of the character
     * @param defense The defense points of the character
     * @param nom The name of the character
     */
    public Personnage(int pv, int attaque, int defense, String nom) {
        this.pv = pv;
        this.attaque = attaque;
        this.defense = defense;
        this.nom = nom;
    }

    /**
     * Method to attack another character
     * @param p The character to attack
     */
    public void attaquer(Personnage p) {
        if (this.pv <= 0) {
            LoggerUtil.log(this.nom + " est mort et ne peut plus attaquer.");
            return;
        }
        int degats = this.attaque - (this.attaque * (p.getDefense()))/100;
        if (degats < 0) {
            degats = 0;
        }
        p.setPv(p.getPv() - degats);
        LoggerUtil.log(this.nom + " attaque " + p.getNom() + " et lui inflige " + degats + " points de dégats.");
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
