package org.capaciteSpeciale;

import org.personnage.Hero;
import org.personnage.Ennemi;

public class Invinsible extends CapaciteSpeciale {
    private int nbTour = 2;

    @Override
    public void utiliser(Hero hero, Ennemi ennemi, boolean utiliser) {
        if (isEstDisponible() && utiliser) {
            hero.setDefense(hero.getDefense() + 100);
            setEstDisponible(false);
            setEstUtilise(true);
            nbTour--;
            return;
        }
        if (nbTour == 0 && isEstUtilise()) {
            hero.setDefense(hero.getDefense() - 100);
            setEstUtilise(false);
            return;
        }
    }
    
}
