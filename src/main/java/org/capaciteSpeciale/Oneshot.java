package org.capaciteSpeciale;

import org.personnage.Hero;
import org.personnage.Ennemi;

public class Oneshot extends CapaciteSpeciale {

    @Override
    public void utiliser(Hero hero, Ennemi ennemi, boolean utiliser) {
        if (isEstDisponible() && utiliser) {
            hero.setAttaque(hero.getAttaque() + 10000);
            setEstUtilise(true);
            return;
        }
        if (isEstUtilise()) {
            hero.setAttaque(hero.getAttaque() - 10000);
            setEstUtilise(false);
            setEstDisponible(false);
            return;         
        }
    }
    
}
