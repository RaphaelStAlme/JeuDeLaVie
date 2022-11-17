package fr.sdv.rsa.automates.entities;

import fr.sdv.rsa.automates.enums.EtatCellule;
import fr.sdv.rsa.automates.exception.NegativeNumberException;

import java.util.Random;

public class Cellule implements Cloneable {
    private static final int NB_CELLULE_MAX = 3;
    private static final EtatCellule[]  etatDisponible = {EtatCellule.inactive,EtatCellule.active};

    private EtatCellule etat;

    /**
     * Le constructeur de Cellule va générer un état au hasard de la cellule. Ce constructeur sera appelé par la grille à sa création
     */
    public Cellule() {
        etat = generateRandomCelluleEtat();
    }

    /**
     * Cette méthode va permettre de faire évoluer l'état de la cellule en fonction du nombre de cellule voisine qu'elle a
     * @param nbVoisinesVivantes
     * @throws NegativeNumberException
     */
    public void evoluer(int nbVoisinesVivantes) throws NegativeNumberException {
        if(!(nbVoisinesVivantes < 0)){
            if (nbVoisinesVivantes == NB_CELLULE_MAX) {
                etat = EtatCellule.active;
            } else if (nbVoisinesVivantes != 2) {
                etat = EtatCellule.inactive;
            }
        } else {
            throw new NegativeNumberException("nbVoisinesVivantes shouldn't have negetive number");
        }
    }

    /**
     * Génère et retourne l'état de la cellule généré par défaut.
     * @return l'état de la cellule. Soit ["X"] soit ["|"]
     */
    public EtatCellule generateRandomCelluleEtat() {
        return etatDisponible[(int) Math.round(Math.random())];
    }

    /**
     * Retourne l'état de la cellule
     * @return l'état de la cellule. Soit ["X"] soit ["|"]
     */
    public EtatCellule getEtat() {
        return etat;
    }

    @Override
    public boolean equals(Object obj){
        if(obj == null){
            return false;
        }
        if(obj == this){
            return true;
        }
        if(!(obj instanceof Cellule)){
            return false;
        }
        Cellule cellule = (Cellule) obj;
        return cellule.getEtat().equals(this.getEtat());
    }

    @Override
    public String toString() {
        return "Cellule{" +
                "etat=" + etat +
                '}';
    }

    @Override
    public Cellule clone() {
        try {
            Cellule clone = (Cellule) super.clone();
            clone.etat = etat;
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
