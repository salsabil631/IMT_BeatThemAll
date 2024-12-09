package org.capaciteSpeciale;

import org.personnage.Hero;
import org.personnage.Ennemi;

public interface CapaciteSpeciale {

    /**
     * Method to use the special capacity
     * @param hero The hero to use the special capacity on
     * @param ennemi The enemy to use the special capacity on
     */
    public abstract void utiliser(Hero hero, Ennemi ennemi);

    /**
     * Method to pass the turn
     * @param hero The hero to pass the turn
     * @param ennemi The enemy to pass the turn
     */
    public abstract void passeTour(Hero hero, Ennemi ennemi);

}

