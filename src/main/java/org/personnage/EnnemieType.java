package org.personnage;

import java.util.Random;

/**
 * Enum for the type of ennemie
 */
public enum EnnemieType {
    BRIGANDS(false),
    CATCHEURS(false),
    GANGSTERS(true);

    /** if the ennemie is distance */
    private final boolean distance;
    private static final Random RANDOM = new Random();

    EnnemieType(boolean distance) {
        this.distance = distance;
    }

    public boolean isDistance() {
        return distance;
    }

    /**
     * Method to get a random type of ennemie
     * @return A random type of ennemie
     */
    public static EnnemieType getRandomType() {
        EnnemieType[] values = EnnemieType.values();
        return values[RANDOM.nextInt(values.length)];
    }
}
