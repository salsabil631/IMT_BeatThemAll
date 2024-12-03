package org.personnage;

public class Ennemi extends Personnage {
    private boolean isdistance;
    private EnnemieType type;

    public Ennemi(int pv, int attaque, int defense, int nom, boolean isdistance, EnnemieType type) {
        super(pv, attaque, defense, nom);
        this.isdistance = isdistance;
        this.type = type;
    }

    public boolean isDistance() {
        return isdistance;
    }

    public void setDistance(boolean isdistance) {
        this.isdistance = isdistance;
    }

    public EnnemieType getType() {
        return type;
    }

    public void setType(EnnemieType type) {
        this.type = type;
    }

}
