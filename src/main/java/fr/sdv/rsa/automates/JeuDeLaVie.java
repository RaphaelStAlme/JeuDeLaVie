package fr.sdv.rsa.automates;

import fr.sdv.rsa.automates.entities.Grille;
import fr.sdv.rsa.automates.exception.NegativeNumberException;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class JeuDeLaVie {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Jeu de La Vie");
        System.out.println("-------------");
        System.out.println("1. Créer une grille");
        System.out.println("Defini le nombre de lignes et de colonnes");
        System.out.print("Nombre de lignes : ");
        int nbLignes = scanner.nextInt();
        System.out.print("Nombre de colonnes : ");
        int nbColonnes = scanner.nextInt();

        Grille grille = new Grille(nbLignes, nbColonnes);

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                try {
                    grille.afficher();
                    grille.evoluer();
                } catch (NegativeNumberException  e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Timer timer = new Timer("JeuDeLaVieTimer");
        timer.scheduleAtFixedRate(timerTask,0, 1000);

    }

}
