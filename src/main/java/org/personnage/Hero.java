package org.personnage;

import org.capaciteSpeciale.CapaciteSpeciale;
import org.logger.LoggerUtil;

public class Hero extends Personnage {
    private CapaciteSpeciale capaciteSpeciale;
    private boolean isCapaciteSpecialeUtilisable = true;
    private final int MAX_PV;

    public Hero(String nom, int pv, int attaque, int defense, CapaciteSpeciale capaciteSpeciale) {
        super(pv, attaque, defense, nom);
        this.capaciteSpeciale = capaciteSpeciale;
        this.MAX_PV = pv;
    }


    @Override
    public void attaquer(Personnage p) {
        super.attaquer(p);
        capaciteSpeciale.passeTour(this, (Ennemi) p);
    }

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


}

