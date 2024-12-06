package org.personnage;

import org.capaciteSpeciale.CapaciteSpeciale;

public class Hero extends Personnage {
    private CapaciteSpeciale capaciteSpeciale;
    private final int MAX_PV = 100;

    public Hero(CapaciteSpeciale capaciteSpeciale, int pv, int attaque, int defense, String nom) {
        super(pv, attaque, defense, nom);
        this.capaciteSpeciale = capaciteSpeciale;
    }

    public void utiliserCapaciteSpeciale(Ennemi ennemi) {
        capaciteSpeciale.utiliser(this, ennemi);
    }

    public int getMAX_PV() {
        return MAX_PV;
    }
}

