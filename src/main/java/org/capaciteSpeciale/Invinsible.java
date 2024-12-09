package org.capaciteSpeciale;

import org.personnage.Hero;
import org.personnage.Ennemi;
import org.logger.LoggerUtil;

/**
 * Class for the invinsible special capacity
 */
public class Invinsible implements CapaciteSpeciale {
    /** number of turns */
    private int nbTour = 2;
    /** if the capacity is active */
    private boolean estActif = false;

    @Override
    public void utiliser(Hero hero, Ennemi ennemi) {
        hero.setDefense(hero.getDefense() + 100);
        estActif = true;
        LoggerUtil.log(hero.getNom() + " est invinsible pour 2 tours");
    }

    @Override
    public void passeTour(Hero hero, Ennemi ennemi) {
        nbTour--;
        if (nbTour == 0 && estActif) {
            hero.setDefense(hero.getDefense() - 100);
            estActif = false;
            LoggerUtil.log(hero.getNom() + " n'est plus invinsible");
            return;
        }
    }
    
}
