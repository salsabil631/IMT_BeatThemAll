package org.capaciteSpeciale;

import org.personnage.Hero;
import org.personnage.Ennemi;

public interface CapaciteSpeciale {

    public abstract void utiliser(Hero hero, Ennemi ennemi);

    public abstract void passeTour(Hero hero, Ennemi ennemi);

}

