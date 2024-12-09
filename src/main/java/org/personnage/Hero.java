package org.personnage;

import java.util.Random;

import org.capaciteSpeciale.CapaciteSpeciale;
import org.logger.LoggerUtil;

/**
 * Class for the hero
 */
public class Hero extends Personnage {
    /** special capacity */
    private CapaciteSpeciale capaciteSpeciale;
    /** if the special capacity is usable */
    private boolean isCapaciteSpecialeUtilisable = true;
    /** maximum number of hp */
    private final int MAX_PV;

    private Random random = new Random();

    public Hero(String nom, int pv, int attaque, int defense, CapaciteSpeciale capaciteSpeciale) {
        super(pv, attaque, defense, nom);
        this.capaciteSpeciale = capaciteSpeciale;
        this.MAX_PV = pv;
    }


    @Override
    public void attaquer(Personnage p) {
        for(int i=0; i< random.nextInt(5)+1; i++){
            super.attaquer(p);
        }
        capaciteSpeciale.passeTour(this, (Ennemi) p);
    }

    /**
     * Method to use the special capacity
     * @param ennemi The enemy to use the special capacity on
     */
    public void utiliserCapaciteSpeciale(Ennemi ennemi) {
        if (!isCapaciteSpecialeUtilisable) {
            LoggerUtil.log("La capacité spéciale a déjà été utilisée");
            return;
        }
        else{
            LoggerUtil.log(this.getNom() + " utilise sa capacité spéciale");
            capaciteSpeciale.utiliser(this, ennemi);
            isCapaciteSpecialeUtilisable = false;
        }
    }

    public int getMAX_PV() {
        return MAX_PV;
    }

    public boolean isCapaciteSpecialeUtilisable() {
        return isCapaciteSpecialeUtilisable;
    }

    /**
     * Method to check if the hero is dead
     * @param hero The chosen hero
     * @return True if the hero is dead, false otherwise
     */
    public boolean isHeroDead(){
        if (getPv() <= 0) {
            LoggerUtil.log("Vous êtes mort !");
            return false;
        }
        return true;
    }


}

