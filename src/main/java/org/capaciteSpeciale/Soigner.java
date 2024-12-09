package org.capaciteSpeciale;

import org.personnage.Hero;
import org.personnage.Ennemi;
import org.logger.LoggerUtil;

/**
 * Class for the heal special capacity
 */
public class Soigner implements CapaciteSpeciale {

    @Override
    public void utiliser(Hero hero, Ennemi ennemi) {
        hero.setPv(hero.getPv() + 20);
        LoggerUtil.log(hero.getNom() + " a été soigné de 20 PV");
    }
    
    @Override
    public void passeTour(Hero hero, Ennemi ennemi) {
        // Ne fait rien
    }
}
