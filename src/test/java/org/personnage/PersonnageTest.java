package org.personnage;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.capaciteSpeciale.Invinsible;
import org.junit.jupiter.api.Test;

public class PersonnageTest {

    @Test
    void testAttaque(){
        Hero hero = new Hero("Hero", 100, 100, 10, new Invinsible());
        Ennemi ennemi = new Ennemi(100, 10, 0, "Ennemi", EnnemieType.BRIGANDS);
        hero.attaquer(ennemi);
        assertEquals(0, ennemi.getPv());
    }


    
}
