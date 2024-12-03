package org.capaciteSpeciale;

import org.personnage.Hero;
import org.personnage.Ennemi;

public abstract class CapaciteSpeciale {
    private boolean estUtilise = false;
    private boolean estDisponible = true;

    public abstract void utiliser(Hero hero, Ennemi ennemi, boolean utiliser);

    public boolean isEstUtilise() {
        return estUtilise;
    }

    public void setEstUtilise(boolean estUtilise) {
        this.estUtilise = estUtilise;
    }

    public boolean isEstDisponible() {
        return estDisponible;
    }

    public void setEstDisponible(boolean estDisponible) {
        this.estDisponible = estDisponible;
    }

}

