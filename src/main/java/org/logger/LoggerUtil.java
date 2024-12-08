package org.logger;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerUtil {
    private static final Logger logger = Logger.getLogger("GameLogger");

    static {
        try {
            // Configurer le fichier de log
            FileHandler fileHandler = new FileHandler("game_logs.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
            logger.setUseParentHandlers(false); // Empêche l'affichage sur la console
        } catch (IOException e) {
            System.err.println("Erreur lors de la configuration du logger : " + e.getMessage());
        }
    }

    public static void log(String message) {
        logger.info(message); // Enregistre le message dans le fichier
        System.out.println(message); // Optionnel : affiche le message dans la console
    }
}