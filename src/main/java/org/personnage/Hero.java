package org.personnage;

import org.capaciteSpeciale.CapaciteSpeciale;

public class Hero extends Personnage {
    private CapaciteSpeciale capaciteSpeciale;

    public Hero(CapaciteSpeciale capaciteSpeciale, int pv, int attaque, int defense, int nom) {
        super(pv, attaque, defense, nom);
        this.capaciteSpeciale = capaciteSpeciale;
    }

    public void utiliserCapaciteSpeciale(Ennemi ennemi, boolean utiliser) {
        capaciteSpeciale.utiliser(this, ennemi, utiliser);
    }
}

