package org.main;

import org.junit.jupiter.api.Test;
import org.personnage.*;
import org.capaciteSpeciale.Invinsible;
import org.carte.Carte;
import org.main.Main;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class MainTest {

    @Test
    void testHeroMeurtAvantArrivee(){
        Hero hero = new Hero("TestHero", 1, 1, 0, new Invinsible());

        Carte carte = new Carte(1, "TestCarte", 3);

        String simulatedInput = "non\n \n \n \n \n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        Scanner scanner = new Scanner(System.in);

        boolean result = Main.jouer(hero, carte, scanner);
        assertFalse(result);
    }

}
