package fr.sdv.rsa.automates.entities;

import fr.sdv.rsa.automates.enums.EtatCellule;
import fr.sdv.rsa.automates.exception.NegativeNumberException;

import java.util.Arrays;
import java.util.Objects;

public class Grille {
    private final Cellule[][] grille;
    private final int nbLignes;
    private final int nbColonnes;
    private int numeroGrille;
    private Cellule[][] previousGrille;


    /**
     * Ce constructeur créer une grille dont la taille dépend du paramètre nbLignes et nbColonnes.
     * Puis il va faire des itérations pour créer des cellules.
     *
     * @param nbLignes
     * @param nbColonnes
     */
    public Grille(int nbLignes, int nbColonnes) {
        this.numeroGrille = 1;
        this.nbLignes = nbLignes;
        this.nbColonnes = nbColonnes;
        grille = new Cellule[nbLignes][nbColonnes];
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                grille[i][j] = new Cellule();
            }
        }
    }

    public Cellule[][] getGrille() {
        return grille;
    }

    public Cellule[][] getPreviousGrille() {
        return previousGrille;
    }

    /**
     * S'occupe de l'affichage de la grille avec le numéro de la grille.
     */
    public void afficher() {
        System.out.printf("Numéro %d \n", numeroGrille);

        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                System.out.print(grille[i][j].getEtat().getIcon() + " ");
            }
            System.out.println();
        }


    }

    /**
     * Cette méthode va faire évoluer la grille en fonction du nombre de cellule voisines.
     *
     * @throws NegativeNumberException
     */
    public void evoluer() throws NegativeNumberException {
        previousGrille = copyActualGrilleInPreviousGrille();

        for (int i = 0; i < nbColonnes; i++) {
            for (int j = 0; j < nbLignes; j++) {
                grille[j][i].evoluer(nbVoisinesVivantes(j, i));
            }
        }
        numeroGrille++;

        isGameFinished();
    }

    /**
     * Cette méthode va permettre de copier la grille actuelle dans la grille précédente.
     *
     * @return la grille précédente
     */
    private Cellule[][] copyActualGrilleInPreviousGrille() {
        Cellule[][] copyGrille = new Cellule[grille.length][];

        for (int i = 0; i < grille.length; i++) {
            copyGrille[i] = Arrays.copyOf(grille[i], grille[i].length);
            for (int j = 0; j < grille[i].length; j++) {
                copyGrille[i][j] = grille[i][j].clone();
            }
        }
        return copyGrille;
    }

    /**
     * Cette méthode va déceler les nombres de cellules voisines pour une cellule spécifique dont les coordonnées sont
     * donné par les paramètres ligneCellule et colonneCellule
     *
     * @param ligneCellule
     * @param colonneCellule
     * @return Le nombre de cellules voisines
     */
    private int nbVoisinesVivantes(int ligneCellule, int colonneCellule) {
        int nbVoisinesVivantes = 0;
        for (int i = ligneCellule - 1; i <= ligneCellule + 1; i++) {
            for (int j = colonneCellule - 1; j <= colonneCellule + 1; j++) {
                if (i >= 0 && i < nbLignes && j >= 0 && j < nbColonnes && Objects.equals(grille[i][j].getEtat(), EtatCellule.active)) {
                    nbVoisinesVivantes++;
                }
            }
        }
        if (Objects.equals(grille[ligneCellule][colonneCellule].getEtat(), EtatCellule.active)) {
            nbVoisinesVivantes--;
        }
        return nbVoisinesVivantes;
    }

    /**
     * Cette méthode va permettre de savoir si la partie est finie ou non.
     *
     * @throws NegativeNumberException
     */
    private void isGameFinished(){
        if (Arrays.deepEquals(grille, previousGrille)) {
            System.out.println("La partie est terminée");
            System.exit(0);
        }
    }
}
