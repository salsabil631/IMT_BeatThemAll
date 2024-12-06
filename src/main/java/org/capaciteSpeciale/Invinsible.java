package org.capaciteSpeciale;

import org.personnage.Hero;
import org.personnage.Ennemi;

public class Invinsible implements CapaciteSpeciale {
    private int nbTour = 2;
    private boolean estUtilise = false;

    @Override
    public void utiliser(Hero hero, Ennemi ennemi) {
        if (!estUtilise) {
            hero.setDefense(hero.getDefense() + 100);
            estUtilise = true;
            nbTour--;
            System.out.println(hero.getNom() + " est invinsible pour 2 tours");
            return;
        }
        if (nbTour == 0) {
            hero.setDefense(hero.getDefense() - 100);
            estUtilise = false;
            System.out.println(hero.getNom() + " n'est plus invinsible");
            return;
        }
    }
    
}
