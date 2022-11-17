package fr.sdv.rsa.automates;

import fr.sdv.rsa.automates.entities.Grille;
import fr.sdv.rsa.automates.exception.NegativeNumberException;

import java.util.Timer;
import java.util.TimerTask;

public class JeuDeLaVie {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Grille grille = new Grille(10, 10);

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
        timer.scheduleAtFixedRate(timerTask,30, 1000);

    }

}
