package org.capaciteSpeciale;

import org.personnage.Hero;
import org.personnage.Ennemi;

public class Soigner extends CapaciteSpeciale {

    @Override
    public void utiliser(Hero hero, Ennemi ennemi, boolean utiliser) {

        if (isEstDisponible() && utiliser) {
            hero.setPv(hero.getPv() + 10);
            setEstDisponible(false);
        }
    }
    
}
