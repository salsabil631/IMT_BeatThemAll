package org.capaciteSpeciale;

import org.personnage.Hero;
import org.personnage.Ennemi;

public class Soigner implements CapaciteSpeciale {

    @Override
    public void utiliser(Hero hero, Ennemi ennemi) {
        hero.setPv(hero.getPv() + 20);
        System.out.println(hero.getNom() + " a été soigné de 20 PV");
    }
    
    @Override
    public void passeTour(Hero hero, Ennemi ennemi) {
        // Ne fait rien
    }
}
