package org.personnage;

import org.capaciteSpeciale.Invinsible;
import org.capaciteSpeciale.Oneshot;
import org.capaciteSpeciale.Soigner;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;



public class HeroTest {

    @Test
    void testSoigner(){
        int max_pv = 100;
        Hero hero = new Hero("hero", max_pv, 1, 0, new Soigner());
        Ennemi ennemi = new Ennemi(100, 20, 0, "ennemi", EnnemieType.BRIGANDS);

        ennemi.attaquer(hero);
        hero.utiliserCapaciteSpeciale(ennemi);

        assertEquals(max_pv, hero.getPv());
    }

    @Test
    void testInvincible(){
        int max_pv = 100;
        Hero hero = new Hero("hero", max_pv, 1, 0, new Invinsible());
        Ennemi ennemi = new Ennemi(100, 20, 0, "ennemi", EnnemieType.BRIGANDS);

        hero.utiliserCapaciteSpeciale(ennemi);
        ennemi.attaquer(hero);

        assertEquals(max_pv, hero.getPv());

        hero.attaquer(ennemi);
        hero.attaquer(ennemi);

        ennemi.attaquer(hero);

        assertNotEquals(max_pv, hero.getPv());
    }

    @Test
    void testOneShot(){
        Hero hero = new Hero("hero", 100, 1, 0, new Oneshot());
        Ennemi ennemi = new Ennemi(10000, 20, 0, "ennemi", EnnemieType.BRIGANDS);

        hero.utiliserCapaciteSpeciale(ennemi);

        assertEquals(0, ennemi.getPv());
    }

}
