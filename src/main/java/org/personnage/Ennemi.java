package org.personnage;

public class Ennemi extends Personnage {
    private EnnemieType type;

    public Ennemi(int pv, int attaque, int defense, String nom, EnnemieType type) {
        super(pv, attaque, defense, nom);
        this.type = type;
    }

    public EnnemieType getType() {
        return type;
    }

    public void setType(EnnemieType type) {
        this.type = type;
    }

}
