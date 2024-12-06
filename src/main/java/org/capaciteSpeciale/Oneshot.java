package org.capaciteSpeciale;

import org.personnage.Hero;
import org.personnage.Ennemi;

public class Oneshot implements CapaciteSpeciale {

    @Override
    public void utiliser(Hero hero, Ennemi ennemi) {
        ennemi.setPv(0);
        System.out.println(ennemi.getNom() + " a été tué en un coup");
    }
    
}
